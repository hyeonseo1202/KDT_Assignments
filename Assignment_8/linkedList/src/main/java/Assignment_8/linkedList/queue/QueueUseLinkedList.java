package Assignment_8.linkedList.queue;

import Assignment_8.linkedList.LinkedList;

public class QueueUseLinkedList {
    private LinkedList linkedList;
    public void insertQueue(String data){
        linkedList.insertHeadNode(data);
    }
    public void deleteQueue(){
        linkedList.deleteHeadNode();
    }
    public void printQueue(){
        linkedList.printList();
    }

}
