package org.felix.api.model.model;

import java.util.Objects;

public class Queue {
    private final int id;
    private final String msg;

    public Queue(int inp_id, String inp_msg) {
        id = inp_id;
        msg = inp_msg;
    }

    public Queue() {
        id = 0;
        msg = "";
    }

    public int getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Queue queue = (Queue) o;
        return id == queue.id && Objects.equals(msg, queue.msg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, msg);
    }

    @Override
    public String toString() {
        return "Queue(id='" + this.id + "',msg='" + this.msg + "')";
    }

}
