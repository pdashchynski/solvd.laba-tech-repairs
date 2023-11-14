package main.java.custom;

public class CustomLinkedList {
    class node<T> {
        T data;
        node<T> next;

        node(T data)
        {
            this.data = data;
            this.next = null;
        }
    }

    class customLinkedList<T> {
        node<T> head;
        private int length = 0;

        customLinkedList() {
            this.head = null;
        }

        void add(T data) {
            node<T> temp = new node<>(data);

            if (this.head == null) {
                head = temp;
            } else {
                node<T> X = head;
                while (X.next != null) {
                    X = X.next;
                }
                X.next = temp;
            }
            length++;
        }

        void add(int position, T data) {
            if (position > length + 1) {
                System.out.println(
                        "Position Unavailable in LinkedList");
                return;
            }
            if (position == 1) {
                node<T> temp = head;
                head = new node<T>(data);
                head.next = temp;
                return;
            }

            node<T> temp = head;
            node<T> prev = new node<T>(null);

            while (position - 1 > 0) {
                prev = temp;
                temp = temp.next;
                position--;
            }
            prev.next = new node<T>(data);
            prev.next.next = temp;
        }

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
                if (String.valueOf(temp.data).equals(
                        String.valueOf(key))) {
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
                length--;
            } else {
                System.out.println("Given Value is not present in linked list");
            }
        }

        void clear() {
            head = null;
            length = 0;
        }

        boolean empty() {
            return head == null;
        }

        int length() {
            return this.length;
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
}
