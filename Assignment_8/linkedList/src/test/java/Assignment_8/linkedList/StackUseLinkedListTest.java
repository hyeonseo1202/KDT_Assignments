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

        assertEquals("third", stack.peekStack(), "스택의 맨 위 값이 'third'이어야 합니다.");
        assertEquals(3, stack.size(), "스택에 3개의 요소가 있어야 합니다.");
    }

    @Test
    void testDeleteStack() {
        stack.insertStack("first");
        stack.insertStack("second");
        stack.deleteStack(); // 맨 위에서부터 삭제

        assertEquals("first", stack.peekStack(), "삭제 후 맨 위 값이 'first'이어야 합니다.");
        assertEquals(1, stack.size(), "삭제 후 스택에 1개의 요소가 있어야 합니다.");
    }

    @Test
    void testPrintStack() {
        stack.insertStack("first");
        stack.insertStack("second");
        stack.printStack(); // 콘솔 출력 확인
        assertEquals(2, stack.size(), "스택에 2개의 요소가 있어야 합니다.");
    }
}
