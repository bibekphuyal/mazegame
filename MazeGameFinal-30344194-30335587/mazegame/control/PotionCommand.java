package mazegame.control;

import mazegame.entity.Player;

public class PotionCommand implements Command {
    @Override
    public CommandResponse execute(ParsedInput userInput, Player thePlayer) {

        if(thePlayer.getPotions() == 0){
            return new CommandResponse("You do not have any more potions!");
        }
        else{
            thePlayer.setLifePoints(thePlayer.getLifePoints() + 10);
            thePlayer.usePotions();
            System.out.println("You use a potion to restore 10 life points!");
            return new CommandResponse("Your current life point: " + thePlayer.getLifePoints());
        }

    }
}
