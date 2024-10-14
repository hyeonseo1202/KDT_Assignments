package Assignment_8.linkedList;

import Assignment_8.linkedList.queue.QueueUseLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QueueUseLinkedListTest {
    private QueueUseLinkedList queue;

    @BeforeEach
    void setUp() {
        queue = new QueueUseLinkedList();
    }

    @Test
    void testInsertQueue() {
        queue.insertQueue("first");
        queue.insertQueue("second");
        queue.insertQueue("third");

        // 큐 동작 확인
        assertEquals("first", queue.peek(), "첫 번째 값이 'first'이어야 합니다.");
        assertEquals(3, queue.size(), "큐에 3개의 요소가 있어야 합니다.");
    }

    @Test
    void testDeleteQueue() {
        queue.insertQueue("first");
        queue.insertQueue("second");
        queue.deleteQueue(); // 앞에서부터 삭제

        // 삭제 후 리스트 확인
        assertEquals("second", queue.peek(), "삭제 후 첫 번째 값이 'second'이어야 합니다.");
        assertEquals(1, queue.size(), "삭제 후 큐에 1개의 요소가 있어야 합니다.");
    }

    @Test
    void testPrintQueue() {
        queue.insertQueue("first");
        queue.insertQueue("second");

        // 큐 출력 확인
        System.out.println("큐 내용:");
        queue.printQueue();

        // 큐 내용 확인을 위한 직접적인 출력은 콘솔에서 확인
        assertEquals(2, queue.size(), "큐에 2개의 요소가 있어야 합니다.");
    }
}
