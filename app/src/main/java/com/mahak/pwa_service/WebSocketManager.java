package com.mahak.pwa_service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public class WebSocketManager {
    private static final String WS_URL = "ws://10.0.2.2:8080"; // Use your desired port

    private WebSocket webSocket;

    public void startWebSocket() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(WS_URL).build();

        WebSocketListener socketListener = new WebSocketListener() {
            @Override
            public void onOpen(WebSocket webSocket, okhttp3.Response response) {
                // Connection opened
            }

            @Override
            public void onMessage(WebSocket webSocket, String text) {
                // Handle received text message
            }

            @Override
            public void onMessage(WebSocket webSocket, ByteString bytes) {
                // Handle received binary message
            }

            @Override
            public void onClosing(WebSocket webSocket, int code, String reason) {
                // Connection is closing
            }

            @Override
            public void onClosed(WebSocket webSocket, int code, String reason) {
                // Connection closed
            }

            @Override
            public void onFailure(WebSocket webSocket, Throwable t, okhttp3.Response response) {
                // Handle failure
            }
        };

        webSocket = client.newWebSocket(request, socketListener);
    }

    public void sendMessage(String message) {
        webSocket.send(message);
    }

    public void closeWebSocket() {
        webSocket.close(1000, "Connection closed");
    }
}

