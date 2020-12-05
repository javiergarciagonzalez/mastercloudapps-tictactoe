package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.views.Message;

class PlayView {

    private Logic logic;

    PlayView(Logic logic) {
        this.logic = logic;
    }

    void interact() {
        do {
            if (!this.logic.isBoardComplete()) {
                this.put();
            } else {
                this.move();
            }
            new GameView(this.logic).write();
        } while (!this.logic.isTicTacToe());
        new TokenView(this.logic.getToken()).write();
        Message.PLAYER_WIN.writeln();
    }

    private void put() {
        boolean isUser = this.logic.isUser();
        int[] coordinate;
        Error error;
        do {
            if (isUser) {
                coordinate = new CoordinateView(this.logic).read(Message.COORDINATE_TO_PUT.toString());
            } else {
                coordinate = this.logic.getRandomCoordinate();
            }
            error = this.logic.put(coordinate);
            if (isUser) {
                new ErrorView(error).writeln();
            }
        } while (!error.isNull());
    }

    private void move() {
        boolean isUser = this.logic.isUser();
        int[] origin;
        int[] target;
        Error error;
        do {
            if (isUser) {
                origin = new CoordinateView(this.logic).read(Message.COORDINATE_TO_REMOVE.toString());
                target = new CoordinateView(this.logic).read(Message.COORDINATE_TO_MOVE.toString());
            } else {
                origin = this.logic.getRandomCoordinate();
                target = this.logic.getRandomCoordinate();
            }
            error = this.logic.move(origin, target);
            if (isUser) {
                new ErrorView(error).writeln();
            }
        } while (!error.isNull());
    }

}
