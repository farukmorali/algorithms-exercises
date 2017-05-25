/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deuquesandrandomizedqueues;

/**
 *
 * @author farukmoralioglu
 */
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] arr;
    private int size;

    public RandomizedQueue() {
        arr = (Item[]) new Object[2];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize(int capacity) {
        assert capacity >= size;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        autoEnlarge();
        arr[size++] = item;
    }

    private void autoEnlarge() {
        if (size == arr.length) {
            resize(2 * arr.length);
        }
    }

    public Item dequeue() {
        assertNotEmpty();
        int index = randomIndex();
        Item item = arr[index];
        arr[index] = arr[size - 1];
        arr[size - 1] = null;
        size--;
        autoShrink();
        return item;
    }

    private void assertNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    private void autoShrink() {
        if (size > 0 && size == arr.length / 4) {
            resize(arr.length / 2);
        }
    }

    private int randomIndex() {
        Random rand = new Random();
        return rand.nextInt(size);
    }

    public Item sample() {
        assertNotEmpty();
        return arr[randomIndex()];
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomArrayIterator();
    }

    private class RandomArrayIterator implements Iterator<Item> {

        private Item[] items;
        private int ind;

        public RandomArrayIterator() {
            copyQueue();
        }

        private void copyQueue() {
            items = (Item[]) new Object[size];
            System.arraycopy(arr, 0, items, 0, size);
        }

        @Override
        public boolean hasNext() {
            return ind < size;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return items[ind++];
        }
    }
}
