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
    }

    @Test
    void testDeleteQueue() {
        queue.insertQueue("first");
        queue.insertQueue("second");
        queue.deleteQueue(); // 앞에서부터 삭제
        // 삭제 후 리스트 확인
    }

    @Test
    void testPrintQueue() {
        queue.insertQueue("first");
        queue.insertQueue("second");
        queue.printQueue();
        // 출력 확인은 콘솔 출력으로 직접 확인하거나 추가 처리 가능
    }
}
