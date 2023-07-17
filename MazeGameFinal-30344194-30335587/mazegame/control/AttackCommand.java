package mazegame.control;

import mazegame.entity.Player;

public class AttackCommand implements Command {
    public CommandResponse execute (ParsedInput userInput, Player thePlayer) {

        if (userInput.getArguments().size() == 0){
            return new CommandResponse("Who do you want to attack?");
        }

        //check if there is an NPC
        if (thePlayer.getCurrentLocation().getNpc() == null) {
            return new CommandResponse("Nobody is here!");
        }

        //check if the NPC is a hostile
        else if(thePlayer.getCurrentLocation().getNpc().getHostile() == false){
            return new CommandResponse(thePlayer.getCurrentLocation().getNpc().getName() + " is not a hostile!");
        }

        else
        {
            System.out.println("You attacked " + thePlayer.getCurrentLocation().getNpc().getName() + " for "
                    + thePlayer.getStrength() + " life points!");

            //NPC lost life points
            thePlayer.getCurrentLocation().getNpc().setLifePoints(thePlayer.getCurrentLocation().getNpc().getLifePoints() -
            thePlayer.getStrength());


            //NPC is dead
            if (thePlayer.getCurrentLocation().getNpc().getLifePoints() <= 0){
                System.out.println(thePlayer.getCurrentLocation().getNpc().getName() + " is dead...");
                thePlayer.getCurrentLocation().removeNpc();
                return new CommandResponse("");
            }

            //NPC is still alive
            else{
                //NPC fight back
                System.out.println(thePlayer.getCurrentLocation().getNpc().getName() + " attacked you for "
                        + thePlayer.getCurrentLocation().getNpc().getStrength() + " life points!");


                thePlayer.setLifePoints(thePlayer.getLifePoints() - thePlayer.getCurrentLocation().getNpc().getStrength());

                System.out.println("Your current life point: " + thePlayer.getLifePoints());

                System.out.println(thePlayer.getCurrentLocation().getNpc().getName() + "'s current life point: " +
                thePlayer.getCurrentLocation().getNpc().getLifePoints());

                //player died
                if (thePlayer.getLifePoints() <= 0){
                    return new CommandResponse("You died!",true);
                }

                return new CommandResponse("");

            }



        }




//        return new CommandResponse ("You entered the attack command");
    }
}
