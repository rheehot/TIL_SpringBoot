import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayStackTest {
    private ArrayStack arrayStack;
    private static final int[] PUSH_DATA = {1, 3, 5, 7, 9};

    @BeforeEach
    void setUp() {
        arrayStack = new ArrayStack(5);
    }

    @Test
    void push() {
        arrayStack.push(1);
        arrayStack.push(3);
        arrayStack.push(5);
        arrayStack.push(7);
        arrayStack.push(9);
        for (int i = 0; i < arrayStack.stack.length; i++) {
            Assertions.assertEquals(PUSH_DATA[i], arrayStack.stack[i]);
        }
    }

    @Test
    void pop() {
        arrayStack.push(1);
        arrayStack.push(3);
        arrayStack.push(5);
        arrayStack.push(7);
        arrayStack.push(9);

        Assertions.assertEquals(9, arrayStack.pop());
    }
}
