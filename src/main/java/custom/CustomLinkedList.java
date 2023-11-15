package main.java.custom;

public class CustomLinkedList<T> {
    node<T> head;
    node<T> tail;
    private int size = 0;

    private class node<T> {
        T data;
        node<T> previous;
        node<T> next;

        node(T data) {
            this.data = data;
            this.previous = null;
            this.next = null;
        }
    }

    CustomLinkedList() {
        this.head = null;
        this.tail = null;
    }

    void add(T data) {
        node<T> newNode = new node<>(data);

        if (this.head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    void addFirst(T data) {
        node<T> newNode = new node<>(data);

        if (this.head == null) {
            head = tail = newNode;
        } else {
            head.next = newNode;
            newNode.previous = head;
            tail = newNode;
        }
        size++;
    }

    void add(int index, T data) {
        if (index > size) {
            System.out.println("Index Unavailable in LinkedList");
            return;
        }
        if (index == 1) {
            node<T> temp = head;
            head = new node<T>(data);
            head.next = temp;
            return;
        }

        node<T> temp = head;
        node<T> prev = new node<T>(null);

        while (index - 1 > 0) {
            prev = temp;
            temp = temp.next;
            index--;
        }
        prev.next = new node<T>(data);
        prev.next.next = temp;
    }

    void clear() {
        head = null;
        size = 0;
    }

    boolean empty() {
        return head == null;
    }

        /*T get(int index) {
            return T;
        }

        void remove(int index) {
            node<T> prev = new node<>(null);
            prev.next = head;
            node<T> next = head.next;
            node<T> temp = head;
            boolean exists = false;

            if (head.data == key) {
                head = head.next;
                exists = true;
            }

            while (temp.next != null) {
                if (String.valueOf(temp.data).equals(String.valueOf(key))) {
                    prev.next = next;
                    exists = true;
                    break;
                }
                prev = temp;
                temp = temp.next;
                next = temp.next;
            }

            if (!exists && String.valueOf(temp.data).equals(String.valueOf(key))) {
                prev.next = null;
                exists = true;
            }

            if (exists) {
                size--;
            } else {
                System.out.println("Given Value is not present in linked list");
            }
        }*/

    void remove(T key) {
        node<T> prev = new node<>(null);
        prev.next = head;
        node<T> next = head.next;
        node<T> temp = head;
        boolean exists = false;

        if (head.data == key) {
            head = head.next;
            exists = true;
        }

        while (temp.next != null) {
            if (String.valueOf(temp.data).equals(String.valueOf(key))) {
                prev.next = next;
                exists = true;
                break;
            }
            prev = temp;
            temp = temp.next;
            next = temp.next;
        }

        if (!exists && String.valueOf(temp.data).equals(String.valueOf(key))) {
            prev.next = null;
            exists = true;
        }

        if (exists) {
            size--;
        } else {
            System.out.println("Given Value is not present in linked list");
        }
    }

    //E set(int index, E element) {}

    int size() {
        return this.size;
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

