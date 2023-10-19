import java.util.*;

public class Uninformed {
    static final int GOAL = 0x76543210;
    Frontier frontier;
    HashSet<Integer> explored;
    HashMap<Integer, Integer> parentMap;

    public Uninformed(Frontier algFrontier) {
        this.frontier = algFrontier;
        this.explored = new HashSet<>();
        this.parentMap = new HashMap<>();
    }

    public boolean search(int start) {

        frontier.put(start);
        parentMap.put(start, start);

        while (!frontier.isEmpty()) {

            int state = frontier.remove();

            explored.add(state);

            if (state == GOAL) {
                return true;
            }
            List<Integer> neighbors = State.getNeighbors(state);
            for (Integer neighbor : neighbors) {
                if (!explored.contains(neighbor) && !parentMap.containsKey(neighbor)) {
                    frontier.put(neighbor);
                    parentMap.put(neighbor, state);
                }
            }
        }
        return false;
    }
}
