import java.util.*;

public class Solution {
    final int GOAL = 0x76543210;
    Character[] pathToGoalSteps;
    Integer[] pathToGoalStates;
    int costOfPath;
    int nodesExpanded;
    int fringeSize;
    int MaxFringeSize;
    int searchDepth;
    int maxSearchDepth;
    double runningTime;
    double maxRamUsage;
    long startRam;
    long endRam;
    long startTime;
    long endTime;
    HashMap<Integer, Integer> parentMap;
    public void calculatePathToGoalOfStates() {
        List<Integer> steps = new ArrayList<>();
        Integer key = GOAL;
        steps.add(key);
        do {
            key = parentMap.get(key);
            steps.add(key);
        } while (!Objects.equals(parentMap.get(key), key));

        Collections.reverse(steps);
        pathToGoalStates = steps.toArray(new Integer[0]);
    }

    public void calculatePathToGoalOfSteps() {
        pathToGoalSteps = new Character[pathToGoalStates.length - 1];
        for (int i = 1; i < pathToGoalStates.length; ++i) {
            switch ((pathToGoalStates[i] & 0xF) - (pathToGoalStates[i - 1] & 0xF)) {
                case -3 -> pathToGoalSteps[i - 1] = 'U';
                case -1 -> pathToGoalSteps[i - 1] = 'L';
                case 1 -> pathToGoalSteps[i - 1] = 'R';
                case 3 -> pathToGoalSteps[i - 1] = 'D';
            }
        }
    }
    public void calculateRunningTime() {
        runningTime = endTime - startTime;
        runningTime /= 1000000000;
    }
    public void calculateRamUsage() {
        maxRamUsage = endRam - startRam;
        maxRamUsage /= 1024;
        maxRamUsage /= 1024;

    }
}
