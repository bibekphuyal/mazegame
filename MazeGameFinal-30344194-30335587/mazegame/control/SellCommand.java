package mazegame.control;

import mazegame.entity.Item;
import mazegame.entity.Player;

public class SellCommand implements Command {
    public CommandResponse execute (ParsedInput userInput, Player thePlayer) {

        //Similar to buy command

        if (userInput.getArguments().size() == 0)
            return new CommandResponse("What do you want to sell?");

        String itemLabel = userInput.getFirstArg();

        Item itemToSell = thePlayer.getInventory().findItem(itemLabel);

        if (itemToSell == null) {
            return new CommandResponse("You do not have a " + itemLabel);
        } else {
            thePlayer.getInventory().removeItem(itemLabel);
            thePlayer.getInventory().addMoney(itemToSell.getValue());
            return new CommandResponse("You sold " + itemLabel + " and get " + itemToSell.getValue() + " pieces of gold!");
        }
    }
}
