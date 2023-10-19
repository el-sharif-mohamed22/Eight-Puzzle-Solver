import java.util.Stack;

public class DfsFrontier extends Frontier {
    private Stack<Integer> stack = new Stack<>();

    @Override
    boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    void put(int x) {
        stack.push(x);
    }

    @Override
    int remove() {
        return stack.pop();
    }
}