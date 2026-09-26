import java.util.*;

public class SinglyLinkedList<E extends Comparable<E>> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    public SinglyLinkedList() {

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e) {
        head = new Node<>(e, head);

        if (isEmpty()) {
            tail = head;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()) {
            tail = null;
        }
        return answer;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = head;
        while (current != null) {
            sb.append(current.getElement());
            sb.append(" ");
            current = current.getNext();
        }
        return sb.toString();
    }

    // write your codes here
    public void swap() {
        List<E> sortedList = new ArrayList<>();
        Node<E> walk = head;

        while (walk != null) {
            sortedList.add(walk.getElement());
            walk = walk.getNext();
        }

        Collections.sort(sortedList);

        for (int i = 0; i < sortedList.size() / 2; i++) {
            if (sortedList.get(i) == sortedList.get(sortedList.size() - i - 1)) {
                break;
            }

            Node<E> Lwalk = head;
            Node<E> Lprev = null;
            Node<E> Lnext = Lwalk.getNext();
            Node<E> Swalk = head;
            Node<E> Sprev = null;
            Node<E> Snext = Swalk.getNext();

            while (Lwalk.getElement() != sortedList.get(i)) {
                Lprev = Lwalk;
                Lwalk = Lwalk.getNext();
                Lnext = Lwalk.getNext();
            }

            while (Swalk.getElement() != sortedList.get(sortedList.size() - i - 1)) {
                Sprev = Swalk;
                Swalk = Swalk.getNext();
                Snext = Swalk.getNext();
            }

            if (Lnext == Swalk) {

                if (Lprev != null) {
                    Lprev.setNext(Swalk);
                } else {
                    head = Swalk;
                }

                Lwalk.setNext(Snext);
                Swalk.setNext(Lwalk);
            } else if (Snext == Lwalk) {

                if (Sprev != null) {
                    Sprev.setNext(Lwalk);
                } else {
                    head = Lwalk;
                }

                Swalk.setNext(Lnext);
                Lwalk.setNext(Swalk);

            } else {

                if (Lprev != null) {
                    Lprev.setNext(Swalk);
                } else {
                    head = Swalk;
                }

                if (Sprev != null) {
                    Sprev.setNext(Lwalk);
                } else {
                    head = Lwalk;
                }

                Lwalk.setNext(Snext);
                Swalk.setNext(Lnext);
            }

            if (Lwalk.getNext() == null) {
                tail = Lwalk;
            }

            if (Swalk.getNext() == null) {
                tail = Swalk;
            }

        }

    }

}
