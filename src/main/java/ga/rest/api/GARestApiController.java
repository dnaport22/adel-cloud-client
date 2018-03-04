package ga.rest.api;

import mautini.assistant.demo.exception.AuthenticationException;
import mautini.assistant.demo.exception.ConverseException;
import mautini.assistant.demo.exception.DeviceRegisterException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mautini.assistant.demo.GoogleAssistantClient;

@Controller
@RequestMapping("/ga-rest-api")
public class GARestApiController {

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody
    GARestApiResponse askForAssistance(@RequestParam(value="query", required=false, defaultValue="hi") String query) {
        String response = null;
        try {
            GoogleAssistantClient googleAssistantClient = new GoogleAssistantClient();
            response = googleAssistantClient.requestAssistant(query);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        } catch (ConverseException e) {
            e.printStackTrace();
        } catch (DeviceRegisterException e) {
            e.printStackTrace();
        }

        return new GARestApiResponse(query, response);
    }

}
