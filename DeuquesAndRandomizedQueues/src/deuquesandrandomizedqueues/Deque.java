/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deuquesandrandomizedqueues;

import java.util.Iterator;

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
        }
        size--;
        return item;
    }

    public Item removeLast() {

        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }

        Item item = (Item) last.item;
        Node tmp = first;

        while (tmp.next != null && tmp.next != last) {
            tmp = tmp.next;
        }
        last = tmp;
        if (first == tmp) {
            last = null;
        } else {
            last.next = null;
        }
        size--;

        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {

    }
}
