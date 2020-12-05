package usantatecla.tictactoe.models;

import usantatecla.utils.ClosedInterval;

public enum Token {

    X,
    O,
    NULL;

    static Token get(int ordinal) {
        assert new ClosedInterval(0, Token.values().length - 2).isIncluded(ordinal);

        return Token.values()[ordinal];
    }

    public boolean isNull() {
        return this.equals(Token.NULL);
    }

    @Override
    public String toString() {
        if (this == NULL) {
            return " ";
        } else return this.name();
    }
}