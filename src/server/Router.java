package server;

import java.util.function.Function;

/**
 * Created by LaroSelf on 12.11.2016.
 */
public interface Router {
        void register(String path, Function<HttpRequest, Handler> handlerFactory);
        String getResponse(HttpRequest httpRequest);
    }
