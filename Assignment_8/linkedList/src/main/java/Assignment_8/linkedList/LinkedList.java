package Assignment_8.linkedList;

public class LinkedList {
    private ListNode head;

    public LinkedList() {
    }

    /**
     * stack.queue 구현해야함.
     * 둘 다 FI이므로 Insert는 Head에 넣는 걸로 구현
     * @param data 넣을 데이터
     */
    public void insertHeadNode(String data){
        ListNode newNode = new ListNode(data); //새로운 노드 생성
        if(head == null){
            this.head = newNode;
        }else{
            newNode.link = head;
            head = newNode;
        }
    }
    public void insertTailNode(String data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode; // 리스트가 비어 있으면 새 노드를 head로 설정
        } else {
            ListNode tempNode = head;
            while (tempNode.link != null) { // 마지막 노드까지 이동
                tempNode = tempNode.link;
            }
            tempNode.link = newNode; // 마지막에 새 노드를 추가
        }
    }

    public void deleteTailNode(){
        ListNode preNode;
        ListNode tempNode;

        //head노드가 null이면 모든 노드가 삭제된 것이므로 return
        if(head == null){
            return;
        }
        //head노드의 link가 null -> 노드가 한 개 남은 경우
        if(head.link == null){
            head = null; //head에 null을 할당하며 남은 노드와의 연결 끊음
        }
        else{
            preNode = head;
            tempNode = head.link;

            /**
             * tempNode의 link가 null이 아닐 때까지 한 노드씩 다음 노드로 이동
             * preNode는 마지막 노드의 이전 노드가 되고,
             * tempNode는 마지막 노드
             */
            while(tempNode.link != null){
                preNode = tempNode;
                tempNode = tempNode.link;
            }
            //가장 마지막 노드를 삭제
            //즉, preNode 다음 노드인 tempNode로의 연결 끊기
            preNode.link = null;
        }
    }
    public void deleteHeadNode(){
        if(head == null){
            return;
        }else {
            head = head.link;
        }

    }
    public ListNode searchNode(String data){
        ListNode tempNode = this.head;
        while(tempNode != null){
            if(data.equals(tempNode.getData())){
                return tempNode;
            }
            else{
                tempNode = tempNode.link;
            }
        }
        return tempNode;
    }
    public void printList(){
        ListNode tempNode = this.head;
        while(tempNode != null){
            System.out.print(tempNode.getData() + " ");
            tempNode = tempNode.link;
        }
        System.out.println();
    }
    // 큐의 맨 앞 요소 반환 (삭제하지 않음)
    public String peekHeadNode() {
        if (head == null) {
            return null;
        }
        return head.getData();
    }

    // 리스트 크기 반환
    public int size() {
        int count = 0;
        ListNode tempNode = head;
        while (tempNode != null) {
            count++;
            tempNode = tempNode.link;
        }
        return count;
    }
}
