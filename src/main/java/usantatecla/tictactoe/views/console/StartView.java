package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.LimitedIntDialog;

class StartView {

    void interact(StartController startController) {
        startController.start();
        Message.TITLE.writeln();
        int users = new LimitedIntDialog(0, startController.getMaxPlayers()).read(Message.NUMBER_PLAYERS.toString());
        startController.createPlayers(users);
    }

}
