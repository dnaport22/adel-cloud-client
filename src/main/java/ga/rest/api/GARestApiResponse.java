package ga.rest.api;

public class GARestApiResponse {

    private final String query;
    private final String response;

    public GARestApiResponse(String query, String response) {
        this.query = query.replaceAll("^\\+$", "");
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public String getQuery() {
        return query;
    }

}
