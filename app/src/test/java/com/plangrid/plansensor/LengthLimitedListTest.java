package com.plangrid.plansensor;

import org.junit.Test;

import static org.junit.Assert.*;

public class LengthLimitedListTest {
    @Test
    public void add() throws Exception {
        LengthLimitedList<Integer> list = new LengthLimitedList<>(3);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertEquals(3, list.size());
        assertTrue(list.contains(4));
        assertFalse(list.contains(1));
    }
}