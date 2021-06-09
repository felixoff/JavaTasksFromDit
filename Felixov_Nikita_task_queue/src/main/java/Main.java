import org.felix.api.InitTables;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.felix.api.StartServer;
public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        InitTables init = new InitTables();
        init.createTables();
        StartServer server = new StartServer();
        server.start();
        List<Integer> ks = new LinkedList<>();
    }
}