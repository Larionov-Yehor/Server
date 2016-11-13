package server.implementation;

import app.DashBoardImpl;
import server.Handler;
import server.HttpRequest;
import server.Router;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by LaroSelf on 12.11.2016.
 */
public class RouterImpl implements Router{

    private Map<String, Function<HttpRequest, Handler>> routes = new HashMap<>();

    @Override
    public void register(String path, Function<HttpRequest, Handler> handlerFactory) {
        routes.put(path, handlerFactory);
    }

    @Override
    public String getResponse(HttpRequest httpRequest) {
        Handler handler;
        if (routes.containsKey(httpRequest.getPath())){
            handler = routes.get(httpRequest.getPath()).apply(httpRequest);
        }else {
            handler = new DashBoardImpl(httpRequest);
        }
        return handler.print(httpRequest);
    }


}
