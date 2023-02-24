package eci.arep.SparkService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Response {

    private String type;
    private String path;
    private String body;

    public String getHeader() {
        return "HTTP/1.1 200 OK\r\n" +
                "Content-type: "+getType()+"\r\n" +
                "\r\n";
    }

    public String getResponse() {
        return getHeader() + getBody();
    }

    public void setBody() {
        String path2 = getPath();
        byte[] content = new byte[0];
        try {
            Path file = Paths.get(path2);
            content = Files.readAllBytes(file);
            String type = (path2).split("\\.")[1];
            setType("text/"+type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setBody(new String(content));
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody(){
        return body;
    }

    public String getType() {
        return type;
    }

    public String getPath() {
        return "src/main/resources/"+path;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
