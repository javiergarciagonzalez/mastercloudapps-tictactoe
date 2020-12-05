package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.Token;

class Player {

    private Token token;
    private Board board;

    Player(Token token, Board board) {
        assert token != null && !token.isNull();
        assert board != null;

        this.token = token;
        this.board = board;
    }

    Error put(Coordinate coordinate) {
        if (!this.board.isEmpty(coordinate)) {
            return Error.NOT_EMPTY;
        }
        this.board.put(coordinate, this.token);
        return Error.NULL;
    }

    Error move(Coordinate origin, Coordinate target) {
        assert origin != null && !origin.isNull();
        assert target != null && !target.isNull();

        if (!this.board.isOccupied(origin, this.token)) {
            return Error.NOT_OWNER;
        }
        if (origin.equals(target)) {
            return Error.SAME_COORDINATES;
        }
        if (!this.board.isEmpty(target)) {
            return Error.NOT_EMPTY;
        }
        this.board.move(origin, target);
        return Error.NULL;
    }

    Token getToken() {
        return this.token;
    }

}
