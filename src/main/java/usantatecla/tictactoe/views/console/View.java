package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;

public class View extends usantatecla.tictactoe.views.View {

    private StartView startView;
    private PlayView playView;
    private ResumeView resumeView;

    public View(Logic logic) {
        this.playView = new PlayView(logic);
        this.resumeView = new ResumeView(logic);
    }

    public void visit(StartController startController) {
        this.startView.interact(startController);
    }

    public void visit(PlayController playController) {
        // this.playView.interact(playController);
    }

    public void visit(ResumeController resumeController) {
        // this.resumeView.interact(resumeController);
    }

    @Override
    protected void start() {

    }

    @Override
    protected void play() {
        this.playView.interact();
    }

    @Override
    protected boolean isResumed() {
        return this.resumeView.interact();
    }
}
