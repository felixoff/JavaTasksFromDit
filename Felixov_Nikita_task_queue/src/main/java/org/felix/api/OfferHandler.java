package org.felix.api;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
public class OfferHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String type = exchange.getRequestMethod();
        switch (type) {
            case "POST":
                ObjectMapper mapper = new ObjectMapper();
                Queue queue = mapper.readValue(exchange.getRequestBody(), Queue.class);
                System.out.println(queue.toString());
                BusinessLogic business = new BusinessLogic();
                String responce = null;
                try {
                    responce = business.insertInCard(queue);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                exchange.sendResponseHeaders(200, responce.length());
                OutputStream os = exchange.getResponseBody();
                os.write(responce.getBytes());
                os.close();
                break;
        }
    }
}
