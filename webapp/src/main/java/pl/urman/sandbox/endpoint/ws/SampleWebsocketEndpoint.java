package pl.urman.sandbox.endpoint.ws;

import java.io.IOException;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/ws/user-notify")
public class SampleWebsocketEndpoint {

    @OnMessage
    public void onMessage(Session session, String msg) {
        try {
            for (Session sess : session.getOpenSessions()) {
                if (sess.isOpen() && !sess.getId().equals(session.getId())) {
                    sess.getBasicRemote().sendText(msg);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to execute @OnMessage handler", e);

        }
    }
}
