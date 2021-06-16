package org.felix.api.model.repository;

import com.google.gson.Gson;
import org.felix.api.model.model.Queue;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserCrud implements BaseOper<Queue> {
    private static String jdbcURL = "jdbc:h2:mem:base;DB_CLOSE_DELAY=-1";
    private static String jdbcUsername = "sa";
    private static String jdbcPassword = "";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    @Override
    public String offer(Queue queue) {
        String INSERT_SQL = "INSERT INTO queue" + " (msg) VALUES " + "(?); ";

        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
            String s = queue.getMsg();
            preparedStatement.setString(1, s);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            try {
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("IncorrectBody");
                return "Incorrect body";
            }
        } catch (SQLException e) {
            printSQLException((SQLException) e);
        }
        return "Add to queue complete!";
    }

    @Override
    public String all() {
        String QUERY = "select id,msg from queue";

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
            ResultSet rs = preparedStatement.executeQuery();
            List<Queue> queues = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String msg = rs.getString("msg");
                Queue queue = new Queue(id, msg);
                queues.add(queue);
            }
            Gson gson = new Gson();
            String s = gson.toJson(queues);
            return (s);
        } catch (SQLException e) {
            printSQLException((SQLException) e);
        }
        return "";
    }

    @Override
    public String peek() {
        //   String QUERY = "select id, msg from queue HAVING id = MIN(id)";
        String QUERY = "select TOP 1 * from queue ORDER BY id";

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
            ResultSet rs = preparedStatement.executeQuery();
            List<Queue> queues = new ArrayList<>();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String msg = rs.getString("msg");
                Queue queue = new Queue(id, msg);
                queues.add(queue);
            }
            Gson gson = new Gson();
            String s = gson.toJson(queues);
            return (s);
        } catch (SQLException e) {
            printSQLException((SQLException) e);
        }
        return "";
    }

    @Override
    public String peekMax() {
        String QUERY = "select TOP 1 * from queue ORDER BY msg desc";

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
            ResultSet rs = preparedStatement.executeQuery();
            List<Queue> queues = new ArrayList<>();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String msg = rs.getString("msg");
                Queue queue = new Queue(id, msg);
                queues.add(queue);
            }
            Gson gson = new Gson();
            String s = gson.toJson(queues);
            return (s);
        } catch (SQLException e) {
            printSQLException((SQLException) e);
        }
        // Step 4: try-with-resource statement will auto close the connection.
        return "";
    }

    @Override
    public String poll() {
        String QUERY1 = "select TOP 1 * from queue ORDER BY id";
        String QUERY2 = "delete from queue where id = (select MIN(id) from queue)";

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement1 = connection.prepareStatement(QUERY1);
             Statement Statement2 = connection.createStatement()) {
            ResultSet rs = preparedStatement1.executeQuery();
            Statement2.execute(QUERY2);
            List<Queue> queues = new ArrayList<>();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String msg = rs.getString("msg");
                Queue queue = new Queue(id, msg);
                queues.add(queue);
            }
            Gson gson = new Gson();
            String s = gson.toJson(queues);
            return (s);
        } catch (SQLException e) {
            printSQLException((SQLException) e);
        }
        return "";
    }
}