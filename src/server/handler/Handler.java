package server.handler;

import server.HttpRequest;

/**
 * Created by LaroSelf on 11.11.2016.
 */
public interface Handler {
    public String handle(HttpRequest httpRequest);
}
