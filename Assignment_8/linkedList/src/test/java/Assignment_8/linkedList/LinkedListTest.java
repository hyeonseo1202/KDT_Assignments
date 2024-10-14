package Assignment_8.linkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new LinkedList();
    }

    @Test
    void testInsertHeadNode() {
        linkedList.insertHeadNode("first");
        linkedList.insertHeadNode("second");
        ListNode node = linkedList.searchNode("second");
        assertNotNull(node);
        assertEquals("second", node.getData());
    }

    @Test
    void testDeleteHeadNode() {
        linkedList.insertHeadNode("first");
        linkedList.insertHeadNode("second");
        linkedList.deleteHeadNode();
        ListNode node = linkedList.searchNode("second");
        assertNull(node); // second는 삭제되어야 함
        assertNotNull(linkedList.searchNode("first")); // first는 남아있어야 함
    }

    @Test
    void testDeleteTailNode() {
        linkedList.insertHeadNode("first");
        linkedList.insertHeadNode("second");
        linkedList.deleteTailNode(); // 마지막 노드인 first 삭제
        ListNode node = linkedList.searchNode("first");
        assertNull(node); // first가 삭제되어야 함
        assertNotNull(linkedList.searchNode("second")); // second는 남아있어야 함
    }

    @Test
    void testPrintList(){
        linkedList.insertHeadNode("first");
        linkedList.insertHeadNode("second");
        linkedList.insertHeadNode("third");

        System.out.println("리스트 출력:");
        linkedList.printList(); // 콘솔에서 확인 가능
    }
}
