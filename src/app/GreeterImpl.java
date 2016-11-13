package app;

import app.calendar.HtmlCalendar;
import server.Handler;
import server.HttpRequest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by LaroSelf on 12.11.2016.
 */
public class GreeterImpl extends HtmlPageGenerator implements Handler {

    private String pageContent =  "<input type=\"text\" name=\"name\" placeholder=\"Enter your name\"/>" +
                                  "<input type=\"submit\" value=\"greet\"></form> "; ;

    public GreeterImpl(HttpRequest httpRequest) {

    }

    @Override
    public String print(HttpRequest httpRequest) {

        return createPage( httpRequest);
    }

    @Override
    public String getAction() {
       return  "<form action=\"/greeter/\">";

    }

    @Override
    public String getPageContent(HttpRequest httpRequest) {
        String result = "";

        try {
            result += pageContent;

            String name = httpRequest.getParameters().get("name");
            System.out.println(name);

                result += "Hello  "+URLDecoder.decode(name, "UTF-8");


        } catch (NullPointerException e) {
            result += "Hello Incognito";
        } catch (UnsupportedEncodingException e) {
        }

        return result;
    }


}

