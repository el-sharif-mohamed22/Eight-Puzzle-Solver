import java.util.LinkedList;
import java.util.Queue;

public class BfsFrontier extends Frontier {
    private Queue<Integer> queue = new LinkedList<>();

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void put(int x) {
        queue.add(x);
    }

    @Override
    public int remove() {
        return queue.remove();
    }
}