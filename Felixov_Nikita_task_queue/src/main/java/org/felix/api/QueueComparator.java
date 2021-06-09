package org.felix.api;


import java.util.Comparator;

public class QueueComparator implements Comparator<Queue> {
    @Override
    public int compare(Queue o1, Queue o2) {
        return o1.getMsg().compareTo(o2.getMsg());
    }
}