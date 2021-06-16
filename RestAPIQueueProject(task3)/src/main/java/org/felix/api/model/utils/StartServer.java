package org.felix.api.model.utils;

import com.sun.net.httpserver.HttpServer;
import org.felix.api.model.handlers.*;

import java.io.IOException;
import java.net.InetSocketAddress;

public class StartServer {
    public void start() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/offer", new OfferHandler());
        server.createContext("/poll", new PollHandler());
        server.createContext("/peek", new PeekHandler());
        server.createContext("/max", new PeekMaxHandler());
        server.createContext("/all", new AllHandler());
        server.setExecutor(null);
        server.start();
    }
}