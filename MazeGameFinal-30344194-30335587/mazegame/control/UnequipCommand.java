package mazegame.control;


import mazegame.entity.Exit;
import mazegame.entity.Item;
import mazegame.entity.Player;
import mazegame.entity.Weapon;
import mazegame.entity.Armor;



public class UnequipCommand implements Command {
	private CommandResponse response;
	
	public CommandResponse execute(ParsedInput userInput, Player thePlayer){
		

		String itemLabel = (String) userInput.getArguments().get(0);

		if (userInput.getArguments().size() == 0) {
			return new CommandResponse ("If you want to unequip the item tell me what item");
		}
		

        Item desiredItem = thePlayer.getInventory().findItem(itemLabel);
		 if (thePlayer.m_Weapon != null)
         {
             desiredItem = thePlayer.m_Weapon;
             thePlayer.m_Weapon = null;
         }
         else if (thePlayer.m_Armor != null)
         {
             desiredItem = thePlayer.m_Armor;
             thePlayer.m_Armor = null;
         }
         if (desiredItem == null)
         {
             return new CommandResponse("You can not unequip this item." + itemLabel);
         }

         //thePlayer.addItem(itemLabel, desiredItem);

		  thePlayer.getInventory().addItem(desiredItem);
         return new CommandResponse("Successfully Item unequipped " + itemLabel + "\n");
		
	}
	
}
