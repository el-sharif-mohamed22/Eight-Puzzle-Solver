import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;


class StateTest {

    @Test
    void getNeighbors() {

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/grid-state.csv", numLinesToSkip = 1)
    void gridToState(@ConvertWith(IntegerArrayConverter.class) int[] grid, int state) {
        assertThat(state).isEqualTo(State.gridToState(grid));
    }


    @ParameterizedTest
    @CsvFileSource(resources = "grid-state.csv", numLinesToSkip = 1)
    void stateToGrid(@ConvertWith(IntegerArrayConverter.class) int[] grid, int state) {
        assertThat(grid).isEqualTo(State.stateToGrid(state));
    }
}