package marsRover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class marsRoverTest {
    @Test
    void expect_0_0_N_when_2_2_0_0_N(){
        ControlInput input= new ControlInput("2 2 0 0 N");
        assertEquals("0 0 N",input.finalPositions());
    }
}
