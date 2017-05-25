/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deuquesandrandomizedqueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author farukmoralioglu
 * @param <Item>
 */
public class Deque<Item> implements Iterable<Item> {

    /**
     */
    private Node first, last;
    private int size;

    public Deque() {
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException();
        }
        Node newFirst = new Node();
        newFirst.item = item;
        newFirst.next = first;

        if (isEmpty()) {
            last = newFirst;
        } else {
            first.prev = newFirst;
        }
        first = newFirst;
        size++;
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException();
        }
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        last.prev = oldlast;
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        Item item = (Item) first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        } else {
            first.prev = null;
        }
        size--;
        return item;
    }

    public Item removeLast() {

        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }

        Item item = (Item) last.item;
        if (size > 1) {
            last = last.prev;
            last.next = null;
        } else {
            first = null;
            last = null;
        }

        size--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            Item item = (Item) current.item;
            current = current.next;
            return item;
        }

    }

    private class Node<Item> {

        Item item;
        Node next;
        Node prev;
    }

    public static void main(String[] args) {

    }
}
