package app;

import server.Handler;
import server.HttpRequest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by LaroSelf on 12.11.2016.
 */
public class DashBoardImpl extends HtmlPageGenerator implements Handler{

    private String pageContent = "<a href=\"greeter\">greater</a><br>" +
                                  "<a href=\"calendar\">calendar</a>" ;

    public DashBoardImpl(HttpRequest httpRequest) {

    }


    @Override
    public String getAction() {
        return   "<form action=\"/\">";
    }

    @Override
    public String getPageContent(HttpRequest httpRequest) {

        return pageContent;
    }

    @Override
    public String print(HttpRequest httpRequest) {

        return createPage(httpRequest);
    }
}
