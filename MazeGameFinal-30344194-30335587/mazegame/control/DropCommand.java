package mazegame.control;

import mazegame.entity.Item;
import mazegame.entity.Player;

public class DropCommand implements Command {

    @Override
    public CommandResponse execute(ParsedInput userInput, Player thePlayer) {


        if (userInput.getArguments().size() == 0){
            return new CommandResponse("What do you want to drop?");
        }

        //get user's input of the item
        String itemLabel = userInput.getFirstArg();


        //find if there's the item which inputed by the user
        Item itemInInventory = thePlayer.getInventory().findItem(itemLabel);

        if (itemInInventory == null){
            return new CommandResponse("There is no " + itemLabel + " in your inventory...");
        }

        //successfully dropped
        boolean successDrop = thePlayer.getCurrentLocation().getInventory().addItem(itemInInventory);

        if(successDrop) {
            thePlayer.getInventory().removeItem(itemLabel);
            return new CommandResponse(itemLabel + " is dropped on the location");
        }
        return new CommandResponse(itemLabel + " not found..");

    }

}
