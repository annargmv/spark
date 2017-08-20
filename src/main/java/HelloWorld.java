/**
 * Created by anna_rgmv on 20/08/2017.
 */
import org.apache.log4j.BasicConfigurator;

import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        port(getHerokuAssignedPort());
        get("/hello", (req, res) -> "Hello Heroku World");
        get("/login", (req, res) -> "Hello Heroku World Login");

    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

}