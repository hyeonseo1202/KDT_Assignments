package Assignment_8.linkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new LinkedList(); // null 대신 빈 리스트로 초기화
    }

    @Test
    void testInsertHeadNode() {
        linkedList.insertHeadNode("first");
        linkedList.insertHeadNode("second");
        ListNode node = linkedList.searchNode("second");
        assertNotNull(node);  // 노드가 존재해야 함
        assertEquals("second", node.getData());  // 노드 데이터 확인
    }

    @Test
    void testDeleteHeadNode() {
        linkedList.insertHeadNode("first");
        linkedList.insertHeadNode("second");
        linkedList.deleteHeadNode(); // 가장 앞 노드("second") 삭제

        // 삭제 후 첫 번째 노드는 "first"여야 함
        ListNode node = linkedList.searchNode("first");
        assertNotNull(node);  // "first" 노드가 남아 있어야 함
        assertEquals("first", node.getData());  // 첫 번째 노드 확인
    }

    @Test
    void testDeleteTailNode() {
        linkedList.insertHeadNode("first");
        linkedList.insertHeadNode("second");
        linkedList.deleteTailNode(); // 마지막 노드("first") 삭제

        // 삭제 후 "first"는 없어야 하고, "second"만 남아 있어야 함
        ListNode node = linkedList.searchNode("first");
        assertNull(node);  // "first"가 삭제되었는지 확인

        ListNode remainingNode = linkedList.searchNode("second");
        assertNotNull(remainingNode);  // "second" 노드가 남아 있어야 함
        assertEquals("second", remainingNode.getData());
    }
}
