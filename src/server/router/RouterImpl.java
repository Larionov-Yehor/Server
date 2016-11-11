package server.router;

/**
 * Created by LaroSelf on 11.11.2016.
 */


        import server.handler.Handler;
        import server.HttpRequest;

        import java.util.HashMap;
        import java.util.Map;
        import java.util.function.Function;


public class RouterImpl implements Router {

    private Map<String, Function<HttpRequest, Handler>> routes = new HashMap<>();

    @Override
    public void register(String path, Function<HttpRequest, Handler> handlerFactory) {
        routes.put(path, handlerFactory);
    }

    @Override
    public String dispatch(HttpRequest httpRequest) {
        Handler handler = routes.get(httpRequest.getPath()).apply(httpRequest);
        return null;
        //return handler.print(httpRequest);
    }
}
