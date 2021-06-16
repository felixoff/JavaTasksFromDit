package org.felix.api.model.repository;


import org.felix.api.model.model.Queue;

import java.sql.SQLException;

public interface BaseOper<Queus> {

    String offer(Queue queue) throws SQLException;

    String all();

    String peek();

    String peekMax();

    String poll();
}

