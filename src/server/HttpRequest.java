package server;

import java.util.Map;

/**
 * Created by LaroSelf on 11.11.2016.
 */
public class HttpRequest {
    private String path;
    private Map<String, String> parameters;


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }


    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }
}
