package Assignment_8.linkedList;

public class LinkedList implements LinkedListInterface{
    private ListNode head;

    public LinkedList(ListNode head) {
        this.head = head;
    }
    //스택, 큐 전부 First-In이니까! - 마지막에 삽입
    public void insertNode(String data){
        ListNode newNode = new ListNode(data); //새로운 노드 생성
        if(head == null){
            this.head = newNode;
        }else{
            //head 노드가 null이 아닌 경우 temp 노드가 head 참조
            //tempNode는 마지막 노드를 찾아서 참조하기 위해 사용
            ListNode tempNode = head;

            while(tempNode.link != null){
                tempNode = tempNode.link; //다음 노드 참조
            }


        }
    }
    public void deleteTailNode(){


    }
    public void deleteFirstNode(){
        ListNode preNode;
        ListNode tempNode;

        if(head == null){
            return;
        }else {
            preNode = head;
        }

    }
    public void deleteSpecificNode(String data){

    }
    public void searchNode(String data){

    }
    public void printList(){

    }

}
