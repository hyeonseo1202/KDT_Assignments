package Assignment_8.myLinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyLinkedListTest {

    private MyLinkedList<Integer> list;

    @BeforeEach
    public void setUp() {
        list = new MyLinkedList<>();
    }

    @Test
    public void testAddAndSize() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size(), "리스트의 크기는 3이어야 합니다.");
    }

    @Test
    public void testGetElement() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(2, list.get(1), "인덱스 1의 요소는 2이어야 합니다.");
        assertEquals(3, list.get(2), "인덱스 2의 요소는 3이어야 합니다.");
    }

    @Test
    public void testDeleteElement() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.delete(1);  // 인덱스 1의 요소 삭제
        assertEquals(2, list.size(), "삭제 후 리스트 크기는 2이어야 합니다.");
        assertEquals(3, list.get(1), "삭제 후 인덱스 1의 요소는 3이어야 합니다.");
    }

    @Test
    public void testPopElement() {
        list.add(1);
        list.add(2);
        list.add(3);
        int popped = list.pop();  // 마지막 요소 제거
        assertEquals(3, popped, "pop된 요소는 3이어야 합니다.");
        assertEquals(2, list.size(), "pop 후 리스트의 크기는 2이어야 합니다.");
    }

    @Test
    public void testDequeueElement() {
        list.add(1);
        list.add(2);
        list.add(3);
        int dequeued = list.dequeue();  // 첫 번째 요소 제거
        assertEquals(1, dequeued, "dequeue된 요소는 1이어야 합니다.");
        assertEquals(2, list.size(), "dequeue 후 리스트의 크기는 2이어야 합니다.");
    }

    @Test
    public void testForEachLoop() {
        list.add(1);
        list.add(2);
        list.add(3);

        int[] expected = {1, 2, 3};
        int index = 0;

        for (int element : list) {
            assertEquals(expected[index], element, "for-each로 순회하는 요소는 예상과 일치해야 합니다.");
            index++;
        }
    }
}

