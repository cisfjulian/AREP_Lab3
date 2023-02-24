package eci.arep.SparkService;

import java.util.HashMap;
import java.util.Map;

public class Spark {

    public static Map<String, Response> cache = new HashMap<>();


    public static void get(String path, Route route){
        Request req = new Request();
        Response res = new Response();
        String body = route.manage(req,res);
        res.setBody(body);
        res.setPath(path);
        cache.put(path,res);
    }


    public static String post(String value, String key){
        Response res = new Response();
        String body = "{"+key+":"+value+"}";
        res.setBody(body);
        res.setType("application/json");
        cache.put(key,res);
        return res.getResponse();
    }

    public static String addToCache(String path){
        Response res = new Response();
        res.setPath(path);
        res.setBody();
        cache.put(path, res);
        return res.getResponse();
    }
}
