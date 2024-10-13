package Assignment_8.linkedList;

import Assignment_8.linkedList.stack.StackUseLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackUseLinkedListTest {
    private StackUseLinkedList stack;

    @BeforeEach
    void setUp() {
        stack = new StackUseLinkedList();
    }

    @Test
    void testInsertStack() {
        stack.insertStack("first");
        stack.insertStack("second");
        stack.insertStack("third");
        // 스택 동작 확인
    }

    @Test
    void testDeleteStack() {
        stack.insertStack("first");
        stack.insertStack("second");
        stack.deleteStack(); // 뒤에서부터 삭제
        // 삭제 후 리스트 확인
    }

    @Test
    void testPrintStack() {
        stack.insertStack("first");
        stack.insertStack("second");
        stack.printStack();
        // 출력 확인은 콘솔 출력으로 직접 확인하거나 추가 처리 가능
    }
}

