package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.GameBuilder;
import usantatecla.tictactoe.types.Error;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayControllerTest {

    private PlayController playController;

    @BeforeEach
    void before() {
        this.playController = new PlayController(new GameBuilder().build());
    }

    @Test
    void testGivenValidCoordinateWhenIsValidCoordinateThenIsOk() {
        assertEquals(this.playController.isValidCoordinate(new int[]{0, 0}), Error.NULL);
    }

    @Test
    void testGivenInvalidCoordinateWhenIsValidCoordinateThenIsError() {

        int[] invalidRow = {99, 2};
        int[] invalidColumn = {2, 99};
        int[] invalidRowColumn = {99, -99};

        assertEquals(this.playController.isValidCoordinate(invalidRow), Error.NOT_VALID);
        assertEquals(this.playController.isValidCoordinate(invalidColumn), Error.NOT_VALID);
        assertEquals(this.playController.isValidCoordinate(invalidRowColumn), Error.NOT_VALID);
    }

    @Test
    void testGivenNewPlayControllerWhenPutAValidCoordinateThenIsOk() {
        int[] coordinate = {0,0};
        assertEquals(this.playController.put(coordinate), Error.NULL);
    }

    @Test
    void testGivenNewPlayControllerWhenGetRandomCoordinateThenCoordinateIsValid() {
        assertEquals(this.playController.isValidCoordinate(this.playController.getRandomCoordinate()), Error.NULL);
    }

}
