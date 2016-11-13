import app.CalendarImpl;
import app.DashBoardImpl;
import app.GreeterImpl;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import server.Parser;
import server.Server;
import server.implementation.ParserImpl;
import server.implementation.RouterImpl;

import java.io.IOException;

/**
 * Created by LaroSelf on 12.11.2016.
 */
public class Main {


    public static void main(String[] args) throws IOException{


        RouterImpl router = new RouterImpl();

        router.register("/dashboard", DashBoardImpl::new);
        router.register("/calendar", CalendarImpl::new);
        router.register("/greeter", GreeterImpl::new);


        Server server = new Server(router, new ParserImpl());

        server.start();

    }
}
