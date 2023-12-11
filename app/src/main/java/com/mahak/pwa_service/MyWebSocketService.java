package com.mahak.pwa_service;

// MyWebSocketService.java
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;

public class MyWebSocketService extends WebSocketServer {

    public MyWebSocketService(int port) {
        super(new InetSocketAddress(port));
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        System.out.println("New connection: " + conn.getRemoteSocketAddress());
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        System.out.println("Closed connection: " + conn.getRemoteSocketAddress());
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        System.out.println("Received message: " + message);
        conn.send("Echo: " + message);
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        System.err.println("Error on connection: " + conn.getRemoteSocketAddress());
        ex.printStackTrace();
    }

    @Override
    public void onStart() {

    }

    public static void main(String[] args) {
        int port = 3000; // Change this to your desired port
        MyWebSocketService server = new MyWebSocketService(port);
        server.start();
        System.out.println("WebSocket server running on port " + port);
    }
}

