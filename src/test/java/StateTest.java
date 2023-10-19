import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class StateTest {

    @Test
    void getNeighbors() {
    }

    @Test
    void gridToState() {
        int[] grid = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] output = State.stateToGrid(State.gridToState(grid));
        assertArrayEquals(grid, output);
    }

    @Test
    void stateToGrid() {
    }
}