package Assignment_8.myLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // 기본 생성자
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // add() - 리스트의 끝에 데이터 추가
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // get(index) - 주어진 인덱스의 데이터를 반환
    public T get(int index) {
        checkElementIndex(index);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    // delete(index) - 주어진 인덱스의 노드를 삭제
    public void delete(int index) {
        checkElementIndex(index);
        if (index == 0) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            Node<T> prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            prev.next = prev.next.next;
            if (prev.next == null) {
                tail = prev;
            }
        }
        size--;
    }

    // 리스트의 크기 반환
    public int size() {
        return size;
    }

    // 인덱스 범위 체크 메서드
    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
    // Iterator 구현
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = current.data;
            current = current.next;
            return data;
        }
    }

    // Stack 기능: 마지막에 추가된 요소 제거 후 반환
    public T pop() {
        if (size == 0) throw new NoSuchElementException();
        T data = tail.data;
        delete(size - 1);
        return data;
    }

    // Queue 기능: 첫 번째 요소 제거 후 반환
    public T dequeue() {
        if (size == 0) throw new NoSuchElementException();
        T data = head.data;
        delete(0);
        return data;
    }
}
