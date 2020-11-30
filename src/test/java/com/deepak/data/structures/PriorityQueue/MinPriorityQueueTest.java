package com.deepak.data.structures.PriorityQueue;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinPriorityQueueTest {

    @Test
    public void add_size() {
        MinPriorityQueue<Integer> minPriorityQueue = new MinPriorityQueue<>();

        minPriorityQueue.add(1);
        minPriorityQueue.add(2);

        assertThat(minPriorityQueue.size()).isEqualTo(2);
    }

    @Test
    public void add_poll() {
        MinPriorityQueue<Integer> minPriorityQueue = new MinPriorityQueue<>();

        minPriorityQueue.add(3);
        minPriorityQueue.add(1);
        minPriorityQueue.add(2);
        assertThat(minPriorityQueue.size()).isEqualTo(3);

        Integer minValue = minPriorityQueue.poll();
        assertThat(minValue).isEqualTo(1);
    }
}