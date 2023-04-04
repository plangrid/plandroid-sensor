package com.plangrid.plansensor

class LengthLimitedList<T>(private val maxSize: Int) : ArrayList<T>() {

    override fun add(element: T): Boolean {
        val success = super.add(element)
        evictIfTooBig()
        return success
    }

    override fun add(index: Int, element: T) {
        if (index >= maxSize) {
            throw IndexOutOfBoundsException()
        }
        super.add(index, element)
        evictIfTooBig()
    }

    private fun evictIfTooBig() {
        while (size > maxSize) {
            this.removeAt(0)
        }
    }
}