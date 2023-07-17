package mazegame.control;

import mazegame.entity.Item;
import mazegame.entity.Player;

public class BuyCommand implements Command {
    public CommandResponse execute (ParsedInput userInput, Player thePlayer) {

        String itemLabel = userInput.getFirstArg();

        if (userInput.getArguments().size() == 0){
            return new CommandResponse("What do you want to buy?");
        }

        //no such item
        Item itemToBuy = thePlayer.getCurrentLocation().getInventory().findItem(itemLabel);
        if (itemToBuy == null)
            return new CommandResponse("There's no " + itemLabel + " in this shop");

        //enough money
        if (thePlayer.getInventory().getGold() >= itemToBuy.getValue())
        {
            boolean successBuy = thePlayer.getInventory().addItem(itemToBuy);

            if (successBuy)
            {
                thePlayer.getInventory().removeMoney(itemToBuy.getValue());
                return new CommandResponse("You bought " + itemLabel);
            }
            else
                return new CommandResponse("It's too heavy!");

        }
        return new CommandResponse("Not enough money!");


    }
}
