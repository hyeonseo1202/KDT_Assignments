package Assignment_8.linkedList.stack;

import Assignment_8.linkedList.LinkedList;

public class StackUseLinkedList {
    private LinkedList linkedList;

    public void insertStack(String data){
        linkedList.insertHeadNode(data);
    }
    public void deleteStack(){
        linkedList.deleteTailNode();
    }
    public void printStack(){
        linkedList.printList();
    }
}
