package mazegame.control;

import java.util.ArrayList;
import java.util.Random;

import mazegame.entity.Exit;
import mazegame.entity.Location;
import mazegame.entity.Player;

public class Flee implements Command  {
	
	private CommandResponse response;
	
	
	public CommandResponse execute(ParsedInput userInput, Player thePlayer){
		
		if (thePlayer.getCurrentLocation().getNpc() == null || (thePlayer.getCurrentLocation().getNpc() != null && !thePlayer.getCurrentLocation().getNpc().getHostile()))
        {
            return new CommandResponse("You cannot flee from here!!");
        }

		ArrayList<Exit> exits = new ArrayList<>();
     
        /*Location location = thePlayer.getCurrentLocation();

        for (String key : thePlayer.getCurrentLocation().exits.keySet()) {
           
        	Exit label = thePlayer.getCurrentLocation().exits.get(key);
        	exits.add(label);
        }
        
        Random random = new Random();
        Exit exit = exits.get(random.nextInt(exits.size()));
        thePlayer.setCurrentLocation(exit.getDestination());
        */
		String exitLabel="south";
   	 	Exit desiredExit = thePlayer.getCurrentLocation().getExitCollection().getExit(exitLabel);
   	 	thePlayer.setCurrentLocation(desiredExit.getDestination());
        return new CommandResponse("You have successfully fled to another location.");
	}
}