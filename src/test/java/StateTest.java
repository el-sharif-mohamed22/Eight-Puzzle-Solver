import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class StateTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/grids.csv", numLinesToSkip = 1)
    void getNeighbors(@ConvertWith(IntegerArrayConverter.class) int[] grid,
                      @ConvertWith(IntegerMultiArrayConverter.class) int[][] expectedNeighbors) {

        int state = State.gridToState(grid);
        List<Integer> neighborsHex = State.getNeighbors(state);
        int[][] neighbors = new int[neighborsHex.size()][9];

        for (int i = 0; i < neighborsHex.size(); i++) {
            neighbors[i] = State.stateToGrid(neighborsHex.get(i));
        }
        assertThat(neighbors).isEqualTo(expectedNeighbors);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/grid-state.csv", numLinesToSkip = 1)
    void gridToState(@ConvertWith(IntegerArrayConverter.class) int[] grid, long state) {
        assertThat((int)state).isEqualTo(State.gridToState(grid));
    }


    @ParameterizedTest
    @CsvFileSource(resources = "grid-state.csv", numLinesToSkip = 1)
    void stateToGrid(@ConvertWith(IntegerArrayConverter.class) int[] grid, long state) {

        assertThat(grid).isEqualTo(State.stateToGrid((int)state));
    }
}