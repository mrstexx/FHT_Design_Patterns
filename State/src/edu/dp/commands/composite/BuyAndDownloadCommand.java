package edu.dp.commands.composite;

import edu.dp.Game;
import edu.dp.commands.BuyCommand;
import edu.dp.commands.DownloadCommand;

public class BuyAndDownloadCommand extends AbstractCommand {

    public BuyAndDownloadCommand(Game game) {
        this.addCommand(new BuyCommand(game));
        this.addCommand(new DownloadCommand(game));
    }

}
