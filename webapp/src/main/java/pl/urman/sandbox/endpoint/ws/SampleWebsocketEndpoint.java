package pl.urman.sandbox.endpoint.ws;

import java.io.IOException;

import javax.inject.Inject;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import pl.urman.sandbox.model.user.UserFinder;

@ServerEndpoint(value = "/ws/user-notify", configurator = WebsocketEnpointConfig.class)
public class SampleWebsocketEndpoint {

    @Inject
    private UserFinder userFinder;

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
