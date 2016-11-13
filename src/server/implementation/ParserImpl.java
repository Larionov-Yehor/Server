package server.implementation;

import server.HttpRequest;
import server.Parser;

import javax.lang.model.element.PackageElement;
import java.io.*;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by LaroSelf on 12.11.2016.
 */
public class ParserImpl implements Parser {

    @Override
    public HttpRequest parse(InputStream stream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        try {

            String fullPath = reader.readLine().split(" ")[1];

            System.out.println(fullPath);

            return new HttpRequest(getPath(fullPath), getParameters(fullPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getPath(String path){

        int la = path.lastIndexOf("/");
        return path.substring(0, la == 0 ? path.length() : la);
    }

    private Map<String, String> getParameters(String path) throws UnsupportedEncodingException {

        String string = path.substring(path.indexOf("?") + 1);
     //   System.out.println(string);
        Map<String, String> query_pairs = new LinkedHashMap<>();
        String[] pairs = string.split("&");

        for (String pair : pairs) {
            int idx = pair.indexOf("=");
            try {
                query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"),
                        URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
            }catch (IndexOutOfBoundsException e){}
        }
        return query_pairs;
    }

/*

    public HttpRequest parse(InputStream inputStream) throws IOException{

        HttpRequest httpRequest = new HttpRequest(getPath(inputStream),getParameters(getPath(inputStream)) );

        return httpRequest;
    }

    public String getPath(InputStream inputStream) throws IOException {

            String path = "";

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String fullPath = reader.readLine().split(" ")[1];
            System.out.println(fullPath);

            if(fullPath==null){
                fullPath = "/";
            }
            int pathStartIndex = fullPath.indexOf("/");

            path = fullPath.substring(pathStartIndex).trim();

            System.out.println("|"+path+"|");


            return path;


    }
        public Map<String, String> getParameters(String path){

           Map<String, String> parameters = new HashMap<>();

        return parameters;}*/




    }
