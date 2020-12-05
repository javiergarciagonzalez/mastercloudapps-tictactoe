package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.YesNoDialog;

class ResumeView {

    private Logic logic;

    public ResumeView(Logic logic) {
        this.logic = logic;
    }

    boolean interact() {
        boolean isResumed = new YesNoDialog().read(Message.RESUME.toString());
        if (isResumed) {
            this.logic.reset();
        }
        return isResumed;
    }

}
