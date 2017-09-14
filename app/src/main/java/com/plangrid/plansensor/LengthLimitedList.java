package com.plangrid.plansensor;

import java.util.ArrayList;
import java.util.Collection;


class LengthLimitedList<T> extends ArrayList<T> {
    private final int maxSize;

    LengthLimitedList(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public boolean add(T o) {
        boolean success = super.add(o);
        evictIfTooBig();
        return success;
    }

    @Override
    public void add(int index, T element) {
        if (index >= maxSize) {
            throw new IndexOutOfBoundsException();
        }
        super.add(index, element);
        evictIfTooBig();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return super.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return super.addAll(index, c);
    }

    private void evictIfTooBig() {
        while (this.size() > maxSize) {
            this.remove(0);
        }
    }
}
