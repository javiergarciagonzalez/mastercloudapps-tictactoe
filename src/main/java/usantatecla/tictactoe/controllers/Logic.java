package usantatecla.tictactoe.controllers;

import java.util.HashMap;
import java.util.Map;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.State;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.StateValue;
import usantatecla.tictactoe.types.Token;

public class Logic {

    private Game game;
    private State state;
    private StartController startController;
    private PlayController playController;
    private ResumeController resumeController;
    private Map<StateValue, Controller> controllers;

    public Logic() {
        this.game = new Game();
        this.state = new State();
        this.controllers = new HashMap<StateValue, Controller>();
        this.controllers.put(StateValue.INITIAL, new StartController(this.game, this.state));
        this.controllers.put(StateValue.IN_GAME, new PlayController(this.game, this.state));
        this.controllers.put(StateValue.RESUME, new ResumeController(this.game, this.state));
        this.controllers.put(StateValue.EXIT, null);


        this.startController = new StartController(this.game, this.state);
        this.playController = new PlayController(this.game, this.state);
        this.resumeController = new ResumeController(this.game, this.state);
    }

    public int getMaxPlayers() {
        return this.startController.getMaxPlayers();
    }

    public void setUsers(int users) {
        this.startController.setUsers(users);
    }

    public Token getToken() {
        return this.playController.getToken();
    }

    public Token getToken(Coordinate coordinate) {
        return this.playController.getToken(coordinate);
    }

    public boolean isBoardComplete() {
        return this.playController.isBoardComplete();
    }

    public boolean isTicTacToe() {
        return this.playController.isTicTacToe();
    }

    public boolean isUser() {
        return this.playController.isUser();
    }

    public Error isValidCoordinate(int[] coordinate) {
        return this.playController.isValidCoordinate(coordinate);
    }

    public int[] getRandomCoordinate() {
        return this.playController.getRandomCoordinate();
    }

    public Error put(int[] coordinate) {
        return this.playController.put(coordinate);
    }

    public Error move(int[] origin, int[] target) {
        return this.playController.move(origin, target);
    }

    public void reset() {
        this.resumeController.reset();
    }

}
