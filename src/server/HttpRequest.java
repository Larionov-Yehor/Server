package server;

import java.util.Map;

/**
 * Created by LaroSelf on 12.11.2016.
 */
public class HttpRequest {

    private String path;
    private Map<String,String> parameters;

    public HttpRequest(String path, Map<String, String> parameters) {
        this.path = path;
        this.parameters = parameters;
    }

    public String getPath() {
        return path;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

}
