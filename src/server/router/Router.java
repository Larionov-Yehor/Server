package server.router;

import server.HttpRequest;
import server.handler.Handler;

import java.util.function.Function;

/**
 * Created by LaroSelf on 11.11.2016.
 */
public interface Router {
    public void register(String path, Function<HttpRequest, Handler> handlerFactory);
    public String dispatch(HttpRequest httpRequest);
}
