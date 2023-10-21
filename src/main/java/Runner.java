import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        Uninformed dfs = new Uninformed(new DfsFrontier());
        try {
            int[] grid = {1,2,5,3,4,0,6,7,8};
            dfs.startRam = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            dfs.search(State.gridToState(grid));
            dfs.endRam = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            dfs.calculatePathToGoalOfStates();
            dfs.calculatePathToGoalOfSteps();
//            for (Integer di : dfs.pathToGoalStates) {
//                System.out.println(Arrays.toString(State.stateToGrid(di)));
//            }
//            System.out.println(Arrays.toString(dfs.pathToGoalSteps));
            dfs.calculateRunningTime();
            dfs.calculateRamUsage();
            System.out.printf("%f", dfs.maxRamUsage);
        } catch (IllegalStateException e) {
            System.out.println("This case doesn't have a solution");
        }
    }
}
