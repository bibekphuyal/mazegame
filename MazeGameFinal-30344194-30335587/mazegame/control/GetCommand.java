package mazegame.control;

import mazegame.entity.Item;
import mazegame.entity.Player;

public class GetCommand implements Command {

    @Override
    public CommandResponse execute(ParsedInput userInput, Player thePlayer) {

        String itemLabel = userInput.getFirstArg();

        if (userInput.getArguments().size() == 0){
            return new CommandResponse("What do you want to get?");
        }


        //get gold command
        int gp = thePlayer.getCurrentLocation().getInventory().getGold();
        if (itemLabel.equals("gold")){
            if (gp == 0){
                return new CommandResponse("There is no gold here...");
            }
            else{
                thePlayer.getInventory().addMoney(gp);
                thePlayer.getCurrentLocation().getInventory().removeMoney(gp);
                return new CommandResponse("You got " + gp + " pieces of gold!");
            }
        }



        //get items command
        //find if there's the item which inputed by the user
        Item itemOnLocation = thePlayer.getCurrentLocation().getInventory().findItem(itemLabel);

        if (itemOnLocation == null){
            return new CommandResponse("There is no " + itemLabel + " at this place...");
        }

        //successfully added
        boolean successAdd = thePlayer.getInventory().addItem(itemOnLocation);
        if (successAdd){

            thePlayer.getCurrentLocation().getInventory().removeItem(itemLabel);
            return  new CommandResponse("You picked up a " + itemLabel);
        }

        //failed to add
        return new CommandResponse("It's too heavy!");
    }
}
