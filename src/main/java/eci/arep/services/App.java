package eci.arep.services;

import eci.arep.HTTPServer;
import eci.arep.SparkService.Spark;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        HTTPServer server = HTTPServer.getInstance();
        Spark.get("",(req, res)->{res.setType("application/json");
            return res.getResponse();
        });
        server.run(args);
    }
}
