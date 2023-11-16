package main.java.custom;

import java.util.LinkedList;

public class CustomLinkedList<T> {
    node<T> head;
    node<T> tail;
    private int size = 0;

    private class node<T> {
        T data;
        node<T> prev;
        node<T> next;

        node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
        node(node<T> prev, T data, node<T> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;

        }
    }

    public CustomLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(T data) {
        node<T> newNode = new node<>(data);

        if (this.head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void addFirst(T data) {
        node<T> newNode = new node<>(data);

        if (this.head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void add(int index, T data) {
        if (!isPositionIndex(index)) {
            System.out.println("Index Unavailable in LinkedList");
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        } else if (index == size) {
            add(data);
            return;
        } else {
            node<T> succ = getNode(index);
            node<T> pred = succ.prev;
            node<T> newNode = new node<>(pred, data, succ);
            succ.prev = newNode;
            if (pred == null)
                head = newNode;
            else
                pred.next = newNode;
        }
        size++;
    }

    public void clear() {
        for (node<T> node = head; node != null; ) {
            node<T> next = node.next;
            node.data = null;
            node.next = null;
            node.prev = null;
            node = next;
        }
        head = tail = null;
        size = 0;
    }

    public boolean empty() {
        return head == null;
    }

    private node<T> getNode(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        node<T> temp;
        if (index < (size >> 1)) {
            temp = head;
            for (int i = 0; i < index; i++)
                temp = temp.next;
        } else {
            temp = tail;
            for (int i = size - 1; i > index; i--)
                temp = temp.prev;
        }
        return temp;
    }

    public T get(int index) {
        return getNode(index).data;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    public T remove(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        return unlink(getNode(index));
    }

    public boolean remove(T key) {
        if (key == null) {
            for (node<T> node = head; node != null; node = node.next) {
                if (node.data == null) {
                    unlink(node);
                    return true;
                }
            }
        } else {
            for (node<T> node = head; node != null; node = node.next) {
                if (key.equals(node.data)) {
                    unlink(node);
                    return true;
                }
            }
        }
        return false;
    }

    public void set(int index, T data) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        node<T> node = getNode(index);
        node.data = data;
    }

    public int size() {
        return this.size;
    }

    private T unlink(node<T> node) {
        final T data = node.data;
        final node<T> next = node.next;
        final node<T> prev = node.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.data = null;
        size--;
        return data;
    }

    public String toString() {
        String S = "{ ";
        node<T> X = head;

        if (X == null)
            return S + " }";

        while (X.next != null) {
            S += String.valueOf(X.data) + " -> ";
            X = X.next;
        }

        S += String.valueOf(X.data);
        return S + " }";
    }
}

