package edu.dp.commands.composite;

import edu.dp.Game;
import edu.dp.commands.InstallCommand;
import edu.dp.commands.PlayCommand;
import edu.dp.commands.UpdateCommand;

public class OneClickPlayCommand extends AbstractCommand {

    public OneClickPlayCommand(Game game) {
        this.addCommand(new InstallCommand(game));
        this.addCommand(new UpdateCommand(game));
        this.addCommand(new PlayCommand(game));
    }
}
