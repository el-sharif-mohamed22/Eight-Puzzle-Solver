import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class StateTest {

    @Test
    void getNeighbors() {
    }

    @Test
    void gridToState() {
        int[] grid = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] output = State.stateToGrid(State.gridToState(grid));
        assertThat(grid).isEqualTo(output);
    }

    @Test
    void stateToGrid() {
    }
}