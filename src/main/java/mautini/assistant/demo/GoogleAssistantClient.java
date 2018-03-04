package mautini.assistant.demo;

import mautini.assistant.demo.api.AssistantClient;
import mautini.assistant.demo.authentication.AuthenticationHelper;
import mautini.assistant.demo.config.AssistantConf;
import mautini.assistant.demo.config.AuthenticationConf;
import mautini.assistant.demo.config.DeviceRegisterConf;
import mautini.assistant.demo.device.DeviceRegister;
import mautini.assistant.demo.exception.AuthenticationException;
import mautini.assistant.demo.exception.ConverseException;
import mautini.assistant.demo.exception.DeviceRegisterException;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigBeanFactory;
import com.typesafe.config.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GoogleAssistantClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoogleAssistantClient.class);

    private AuthenticationHelper authenticationHelper;
    private AssistantClient assistantClient;

    public GoogleAssistantClient() throws AuthenticationException, ConverseException, DeviceRegisterException {

        Config root = ConfigFactory.load();
        AuthenticationConf authenticationConf = ConfigBeanFactory.create(root.getConfig("authentication"), AuthenticationConf.class);
        DeviceRegisterConf deviceRegisterConf = ConfigBeanFactory.create(root.getConfig("deviceRegister"), DeviceRegisterConf.class);
        AssistantConf assistantConf = ConfigBeanFactory.create(root.getConfig("assistant"), AssistantConf.class);

        // Authentication
        authenticationHelper = new AuthenticationHelper(authenticationConf);
        authenticationHelper
                .authenticate()
                .orElseThrow(() -> new AuthenticationException("Error during authentication"));

        // Check if we need to refresh the access token to request the api
        if (authenticationHelper.expired()) {
            authenticationHelper
                    .refreshAccessToken()
                    .orElseThrow(() -> new AuthenticationException("Error refreshing access token"));
        }

        // Register Device model and device
        DeviceRegister deviceRegister = new DeviceRegister(deviceRegisterConf, authenticationHelper.getOAuthCredentials().getAccessToken());
        deviceRegister.register();

        // Build the client (stub)
        assistantClient = new AssistantClient(authenticationHelper.getOAuthCredentials(), assistantConf,
                deviceRegister.getDeviceModel(), deviceRegister.getDevice());


    }

    public String requestAssistant(String query) {
        byte[] queryByte = query.getBytes();

        byte[] response = new byte[0];
        try {
            response = assistantClient.requestAssistant(queryByte, "text");
        } catch (ConverseException e) {
            e.printStackTrace();
        }

        if (response.length > 0) {
            return assistantClient.getStringResponse();
        } else {
            return "No response from the API";
        }
    }
}
