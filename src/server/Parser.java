package server;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by LaroSelf on 12.11.2016.
 */
public interface Parser {
  /*  public HttpRequest parse(InputStream stream) throws IOException ;
    public String getPath(InputStream inputStream);*/

    public HttpRequest parse(InputStream stream) throws IOException;

}
