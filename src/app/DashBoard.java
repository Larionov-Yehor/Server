package app;

import server.HtmlPage;
import server.HttpRequest;
import server.handler.Handler;

/**
 * Created by LaroSelf on 11.11.2016.
 */
public class DashBoard extends HtmlPage implements Handler {

    @Override
    public String handle(HttpRequest httpRequest) {



        return null;
    }

    public static String getPath() {
        return   "<form action=\"/\">";
    }
}
