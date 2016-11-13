package server;

import org.apache.tomcat.core.Constants;
import server.implementation.ParserImpl;
import server.implementation.RouterImpl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by LaroSelf on 12.11.2016.
 */
public class Server {
    private RouterImpl router;
    private ParserImpl parser;


    public Server(RouterImpl router, ParserImpl parser) {
        this.router = router;
        this.parser = parser;
    }

    public void start() throws IOException{

        ServerSocket server = new ServerSocket(9999);


        while (true){

            Socket socket = server.accept();
            HttpRequest request = parser.parse(socket.getInputStream());

            if (!request.getPath().isEmpty()) {
                String dispatch = router.getResponse(request);

                socket.getOutputStream().write(dispatch.getBytes("UTF-8"));
            }
            socket.close();;

        }

    }

    public void stop(){
        System.exit(0);
    }


}
