package server.parser;

import server.HttpRequest;
import server.handler.Handler;

import java.io.*;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by LaroSelf on 11.11.2016.
 */
public class ParserImpl implements Parser {
    @Override
    public  Map<String, String> getParameters(String query) throws UnsupportedEncodingException {
        String parameters = query.substring(query.indexOf("?") + 1);
        Map<String, String> query_pairs = new LinkedHashMap<>();
        String[] pairs = parameters.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf("=");
            query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
        }
        return query_pairs;
    }

    @Override
    public HttpRequest parseHttpRequest(InputStream inputStream) throws IOException{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String path = bufferedReader.readLine().split(" ")[1];

        HttpRequest httpRequest = new HttpRequest();
        httpRequest.setPath(path);
        httpRequest.setParameters(getParameters(path));

        return httpRequest;
    }
}
