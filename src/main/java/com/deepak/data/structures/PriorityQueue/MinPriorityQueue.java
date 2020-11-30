package com.deepak.data.structures.PriorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://algorithmtutor.com/Data-Structures/Tree/Priority-Queues/
 * https://stackoverflow.com/questions/2661065/a-good-sorted-list-for-java
 * https://www.geeksforgeeks.org/search-insert-and-delete-in-a-sorted-array/
 */
public class MinPriorityQueue<T> {
    private List<T> list;

    public MinPriorityQueue() {
        this.list = new ArrayList<>();
    }

    public void add(T value) {
        list.add(value);
        Collections.sort(list, (o1, o2) -> {
            if (o1 instanceof Integer) {
                if ((int) o1 < (int) o2) {
                    return -1;
                } else if ((int) o1 > (int) o2) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                throw new RuntimeException("no compare for this type");
            }
        });
    }

    public T poll() {
        return list.get(0);
    }

    public int size() {
        return list.size();
    }
}
