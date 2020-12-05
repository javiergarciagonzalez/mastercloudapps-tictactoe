package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.Controller;
import usantatecla.tictactoe.controllers.ControllersVisitor;

public abstract class View implements ControllersVisitor {

    public void interact() {
        do {
            this.start();
            this.play();
        } while (this.isResumed());
    }

    public void interact(Controller controller) {
        controller.accept(this);
    }

    protected abstract void start();

    protected abstract void play();

    protected abstract boolean isResumed();

}
