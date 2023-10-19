import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class State {

    private static final int MAX_DIRECTIONS = 4;
    private static final int BIT_SHIFT_MULTIPLIER = 4;
    private static final int[] DIRECTION_X_OFFSETS = {0, 1, 0, -1};
    private static final int[] DIRECTION_Y_OFFSETS = {1, 0, -1, 0};
    private static final int GRID_DIMENSION = 3;
    private static final int ZERO_POSITION_MASK = 0xF;

    /**
     * Calculates and returns the neighbors of the current state.
     */
    public static List<Integer> getNeighbors(int state) {
        List<Integer> neighbors = new LinkedList<>();
        int zeroPosition = state & ZERO_POSITION_MASK;
        int zeroX = zeroPosition / GRID_DIMENSION, zeroY = zeroPosition % GRID_DIMENSION;

        for (int direction = 0; direction < MAX_DIRECTIONS; ++direction) {
            int neighborX = zeroX + DIRECTION_X_OFFSETS[direction], neighborY = zeroY + DIRECTION_Y_OFFSETS[direction];

            if (isValidMove(neighborX, neighborY)) {
                int neighborPosition = neighborX * GRID_DIMENSION + neighborY;
                int neighborState = calculateNeighborState(zeroPosition, neighborPosition, state);
                neighbors.add(neighborState);
            }
        }
        return neighbors;
    }

    /**
     * Checks if the given coordinates are valid.
     */
    private static boolean isValidMove(int x, int y) {
        return x >= 0 && x < GRID_DIMENSION && y >= 0 && y < GRID_DIMENSION;
    }

    /**
     * Calculates the state of the neighbor.
     */
    private static int calculateNeighborState(int zeroPosition, int neighborPosition, int state) {
        int neighborState = (~ZERO_POSITION_MASK & state) | neighborPosition;

        for (int i = 1; i < GRID_DIMENSION * GRID_DIMENSION; i++) {
            int mask = ZERO_POSITION_MASK << (i * BIT_SHIFT_MULTIPLIER);

            if ((mask & state) == (neighborPosition << (i * BIT_SHIFT_MULTIPLIER))) {
                neighborState = (neighborState & ~mask) | (zeroPosition << (BIT_SHIFT_MULTIPLIER * i));
                break;
            }
        }
        return neighborState;
    }

    public static int gridToState(int[] grid) {
        int state = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i] != 8) {
                state |= (i << (grid[i] * BIT_SHIFT_MULTIPLIER));
            }
        }
        return state;
    }

    public static int[] stateToGrid(int state) {
        int[] grid = new int[9];
        Arrays.fill(grid, 8);

        for (int i = 0; i < 8; i++) {
            grid[(state >> (i * BIT_SHIFT_MULTIPLIER)) & ZERO_POSITION_MASK] = i;
        }
        return grid;
    }
}