package ga.rest.api;

import java.util.Map;

public class GARestApiResponse {

    private final String query;
    private final Map response;

    public GARestApiResponse(String query, Map response) {
        this.query = query.replaceAll("^\\+$", "");
        this.response = response;
    }

    public Map getResponse() {
        return response;
    }

    public String getQuery() {
        return query;
    }

}
