package mazegame.control;

import mazegame.entity.Armor;
import mazegame.entity.Item;
import mazegame.entity.Player;
import mazegame.entity.Weapon;

public class EquipCommand implements Command {

    @Override
    public CommandResponse execute(ParsedInput userInput, Player thePlayer) {

        String itemLabel = userInput.getFirstArg();

        if (userInput.getArguments().size() == 0){
            return new CommandResponse("What do you want to equip?");
        }

        
        //check items command
        Item desiredItem = thePlayer.getInventory().findItem(itemLabel);

        if (desiredItem == null){
            return new CommandResponse("You do not have " + itemLabel );
        }

        //successfully added
        if (desiredItem instanceof Weapon && thePlayer.m_Weapon != null)
        {
            return new CommandResponse("You can not equip weapon, you are equipped with weapon");
        }
        else if (desiredItem instanceof Armor && thePlayer.m_Armor != null)
        {
            return new CommandResponse("You can not equip armor, you are equipped with armor");
        }
		  
		  if(desiredItem instanceof Weapon){
			  
			  thePlayer.m_Weapon = (Weapon) desiredItem;
			  
		  }else if (desiredItem instanceof Armor)
        {
            thePlayer.m_Armor = (Armor) desiredItem;
        }
		  
		  //thePlayer.removeItem(itemLabel, desiredItem);
		  thePlayer.getInventory().removeItem(itemLabel);
	return new CommandResponse ("Successfully the equipped item: " + itemLabel);
    }
}

