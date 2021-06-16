package org.felix.api.model.service;

import org.felix.api.model.model.Queue;
import org.felix.api.model.repository.UserCrud;

import java.sql.SQLException;

public class BusinessLogic {
    private static UserCrud base;

    public BusinessLogic() {
        base = new UserCrud();
    }

    public static String offer(Queue queue) throws SQLException {
        return base.offer(queue);
    }

    public static String all() throws SQLException {
        return base.all();
    }

    public static String peek() throws SQLException {
        return base.peek();
    }

    public static String poll() throws SQLException {
        return base.poll();
    }

    public static String peekMax() throws SQLException {
        return base.peekMax();
    }

}
