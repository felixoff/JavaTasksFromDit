package org.felix.api.model;

import org.felix.api.model.utils.InitTables;

import java.io.IOException;
import java.sql.SQLException;

import org.felix.api.model.utils.StartServer;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        InitTables init = new InitTables();
        init.createTables();
        StartServer server = new StartServer();
        server.start();
    }
}