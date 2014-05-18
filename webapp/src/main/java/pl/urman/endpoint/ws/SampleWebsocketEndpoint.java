package pl.urman.endpoint.ws;

import java.io.IOException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/echo")
public class SampleWebsocketEndpoint {

    @OnOpen
    public void OnOpen(Session session, EndpointConfig conf) {
        System.out.println("Session with Id created " + session.getId() + " was initialized");
    }

    @OnMessage
    public void onMessage(Session session, String msg) {
        try {
            for (Session sess : session.getOpenSessions()) {
                if (sess.isOpen()) {
                    sess.getBasicRemote().sendText(msg);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to execute @OnMessage handler", e);

        }
    }
}
