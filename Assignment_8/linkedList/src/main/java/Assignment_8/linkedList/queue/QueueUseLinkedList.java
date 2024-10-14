package Assignment_8.linkedList.queue;

import Assignment_8.linkedList.LinkedList;

public class QueueUseLinkedList {
    private LinkedList linkedList;

    public QueueUseLinkedList() {
        linkedList = new LinkedList();
    }

    // 큐에 데이터 삽입
    public void insertQueue(String data) {
        linkedList.insertTailNode(data); // 맨 뒤에 삽입
    }

    // 큐에서 데이터 삭제
    public void deleteQueue() {
        linkedList.deleteHeadNode(); // 맨 앞에서 삭제
    }

    // 큐의 맨 앞 데이터 확인
    public String peek() {
        return linkedList.peekHeadNode();  // 맨 앞 데이터 반환
    }

    // 큐 출력
    public void printQueue() {
        linkedList.printList();  // 리스트 출력
    }

    // 큐의 크기 확인
    public int size() {
        return linkedList.size();  // 리스트 크기 반환
    }
}
