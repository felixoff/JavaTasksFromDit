package org.felix.api;

import java.util.Objects;

public class Queue {
    private int id;
    private String msg;

    public Queue(String[] s) {
        id = Integer.parseInt(s[0]);
        msg = s[1];
    }

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

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setId(int id) {
        this.id = id;
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
