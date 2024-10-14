package Assignment_8.linkedList.stack;

import Assignment_8.linkedList.LinkedList;

public class StackUseLinkedList {
    private LinkedList linkedList;

    // 생성자에서 LinkedList 초기화
    public StackUseLinkedList() {
        linkedList = new LinkedList();
    }

    // 스택에 데이터 삽입 (맨 앞에 삽입)
    public void insertStack(String data) {
        linkedList.insertHeadNode(data);  // 스택이므로 맨 앞에 삽입
    }

    // 스택에서 데이터 삭제 (맨 앞에서 삭제)
    public void deleteStack() {
        linkedList.deleteHeadNode();  // 스택이므로 맨 앞에서 삭제
    }

    // 스택 출력
    public void printStack() {
        linkedList.printList();  // 스택의 현재 상태 출력
    }

    // 스택의 크기 반환
    public int size() {
        return linkedList.size();  // 스택의 크기 확인
    }

    // 스택의 맨 위 데이터 확인 (삭제하지 않음)
    public String peekStack() {
        return linkedList.peekHeadNode();  // 스택의 맨 위 요소 확인
    }
}
