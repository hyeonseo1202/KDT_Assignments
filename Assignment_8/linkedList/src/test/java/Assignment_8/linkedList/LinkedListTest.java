package Assignment_8.linkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList linkedList;

    @BeforeEach //각 테스트가 실행되기 전에 호출됨
    void setUp() {
        linkedList = new LinkedList(null); // 초기화
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
        linkedList.deleteHeadNode(); // 가장 앞 노드 삭제
        ListNode node = linkedList.searchNode("second");
        assertNull(node); // "second" 노드가 삭제되어야 함
    }

    @Test
    void testDeleteTailNode() {
        linkedList.insertHeadNode("first");
        linkedList.insertHeadNode("second");
        linkedList.deleteTailNode(); // 마지막 노드 삭제
        ListNode node = linkedList.searchNode("first");
        assertNull(node); // "first" 노드가 삭제되어야 함
    }

    @Test
    void testPrintList() {
        linkedList.insertHeadNode("first");
        linkedList.insertHeadNode("second");
        linkedList.insertHeadNode("third");
        // 출력 확인을 위해 실제로 테스트할 때는 콘솔 출력을 대신 처리하거나 별도로 검증할 수 있습니다.
    }
}

