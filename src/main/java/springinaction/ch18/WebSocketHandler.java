package springinaction.ch18;

import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;

//如果要做一个socket的实现，首先要定义我们socket要做的事情，比如建立连接前后的处理，消息的处理等
//但是更直接的做法是直接使用现成的抽象方法AbstractWebSocketHandler，见另一个具体实现的做法
public interface WebSocketHandler {
    void afterConnected(WebSocketSession session) throws Exception;

    void handleMsg(WebSocketSession session, WebSocketMessage message) throws Exception;

    void afterClosed(WebSocketSession session) throws Exception;

    void handleTransportError(WebSocketSession session,Throwable error) throws Exception;

    boolean supportsPartialMessage();
}
