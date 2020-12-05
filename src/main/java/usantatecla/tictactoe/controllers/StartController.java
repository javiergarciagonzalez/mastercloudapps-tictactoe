package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.State;

public class StartController extends Controller {

    public StartController(Game game, State state) {
        super(game, state);
    }

    public void setUsers(int users) {
        this.game.setUsers(users);
    }

    public int getMaxPlayers() {
        return this.game.getMaxPlayers();
    }

    public void start() {
        this.state.next();
    }

    public void createPlayers(int numberOfUsers) {
        this.game.createPlayers(numberOfUsers);
    }

    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
