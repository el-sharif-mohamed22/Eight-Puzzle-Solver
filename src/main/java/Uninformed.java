import java.util.*;

public class Uninformed extends Solution {

    Frontier frontier;
    HashSet<Integer> explored;


    Uninformed(Frontier algFrontier) {
        this.frontier = algFrontier;
        this.explored = new HashSet<>();
        this.parentMap = new HashMap<>();
    }

    public HashMap<Integer, Integer> search(int start) {
        startTime = System.nanoTime();
        frontier.put(start);
        parentMap.put(start, start);

        while (!frontier.isEmpty()) {

            int state = frontier.remove();

            explored.add(state);

            if (state == GOAL) {
                endTime = System.nanoTime();
                return parentMap;
            }
            List<Integer> neighbors = State.getNeighbors(state);
            for (Integer neighbor : neighbors) {
                if (!explored.contains(neighbor) && !parentMap.containsKey(neighbor)) {
                    frontier.put(neighbor);
                    parentMap.put(neighbor, state);
                }
            }
        }
        throw new IllegalStateException("Grid is unsolvable.");
    }
}
