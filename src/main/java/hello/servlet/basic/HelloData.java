package hello.servlet.basic;


import jakarta.websocket.server.ServerEndpoint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloData {
    private String username;
    private int age;
}
