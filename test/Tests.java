/**
 * Created by LaroSelf on 13.11.2016.
 */


import org.junit.Before;
import org.junit.Test;
import server.HttpRequest;
import server.Parser;
import server.implementation.ParserImpl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Tests {

    private Parser parser = new ParserImpl();
    private HttpRequest httpRequest;



    @Test
    public void assertCorrectParametersGet() throws IOException{
        String request = "GET /calendar/?firstday=WEDNESDAY&year=1994&month=MAY";
        InputStream inputStream = new ByteArrayInputStream(request.getBytes(StandardCharsets.UTF_8));
        httpRequest = parser.parse(inputStream);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("firstday", "WEDNESDAY");
        parameters.put("year", "1994");
        parameters.put("month", "MAY");
        assertThat(parameters.get("firstday"), equalTo(httpRequest.getParameters().get("firstday")));
        assertThat(parameters.get("year"), equalTo(httpRequest.getParameters().get("year")));
        assertThat(parameters.get("month"), equalTo(httpRequest.getParameters().get("month")));

    }
    @Test
    public void assertCorrectPathGet() throws IOException {
        String rawRequest = "GET /greeter/?name=Alex";
        httpRequest = parser.parse(new ByteArrayInputStream(rawRequest.getBytes(StandardCharsets.UTF_8)));

        assertThat("/greeter", equalTo(httpRequest.getPath()));

    }

}
