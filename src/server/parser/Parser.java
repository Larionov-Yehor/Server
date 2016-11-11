package server.parser;

import server.HttpRequest;
import server.handler.Handler;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by LaroSelf on 11.11.2016.
 */
public interface Parser {
    public Map<String, String> getParameters(String query) throws UnsupportedEncodingException;
    public HttpRequest parseHttpRequest(InputStream inputStream) throws IOException;
}
