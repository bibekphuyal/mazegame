package mazegame;

import mazegame.boundary.IMazeData;
import mazegame.entity.*;
import mazegame.entity.utility.*;

public class HardCodedData implements IMazeData {
	private Location startUp;
	private Location location1;
	private Location location2;
	private Location location3;
	private Location location4;
	private Blacksmith shop1;
	private Blacksmith shop2;

	
	public HardCodedData()
	{
		createLocations();
		settingUpItems();
		populateWeightLimitTable();
		populateStrengthTable();
		populateAgilityTable();
	}


    public Location getStartingLocation()
	{
		return startUp;
	}
	
	public String getWelcomeMessage()
	{
		return "Welcome to the Mount Helanous";
	}
	
	private void createLocations () 
	{
		startUp = new Location ("an empty classroom", "Classroom");
		location1 = new Location ("a library", "Library");
		location2 = new Location ("a lecture room", "Room");
		location3 = new Location ("a lounge with chairs and a table", "Lounge");
		location4 = new Location ("a long corridor with flower pots", "Corridor");
		shop1 = new Blacksmith("a canteen with a strange staff, you can buy and sell here", "Canteen");
		shop2 = new Blacksmith("a vending machine, you can buy and sell here", "Vending Machine");
		
		// Connect Locations
		startUp.getExitCollection().addExit("south",  new Exit ("you see a canteen to the south", shop1));
		shop1.getExitCollection().addExit("north", new Exit("you see an empty classroom to the north", startUp));

        startUp.getExitCollection().addExit("west", new Exit("you see a library to the west", location1));
        location1.getExitCollection().addExit("east", new Exit("you see an empty classroom to the east", startUp));

        startUp.getExitCollection().addExit("north", new Exit("you see a huge lecture room to the north", location2));
        location2.getExitCollection().addExit("south", new Exit("you see an empty classroom to the south", startUp));

        startUp.getExitCollection().addExit("east", new Exit("you see a lounge with chairs and tables to the east", location3));
        location3.getExitCollection().addExit("west", new Exit("you see an empty classroom to the west", startUp));

        location3.getExitCollection().addExit("east", new Exit("you see a corridor to the east", location4));
        location4.getExitCollection().addExit("west", new Exit("you see a lounge with a sofa to the west", location3));

        location4.getExitCollection().addExit("north", new Exit("you see an vending machine to the north", shop2));
        shop2.getExitCollection().addExit("south", new Exit("you see a corridor to the south", location4));

        // setup NPC
        location1.setupNpc("Jerry",20);
        location2.setupNpc("Tom",32,"hostile");


	}

//    public void createWeapons() {
//        Weapon Dagger = new Weapon("Dagger", 1, 2, "a small dagger");
//        Weapon Nunchaku = new Weapon("Nunchaku", 2,2,"a traditional nunchaku");
//        Weapon Greatclub = new Weapon ("Greatclub", 5,10,"a greatclub with nails on it");
//        Weapon Longspear = new Weapon ("Longspear", 5, 9, "a long spear");
//        Weapon Handaxe = new Weapon ("Handaxe", 6, 5, "a common handaxe");
//        Weapon ThrowingAxe = new Weapon ("ThrowingAxe", 8, 4, "a axe which can be thrown");
//        Weapon LightFlail = new Weapon ("LightFlail", 8, 5, "a light flail");
//        Weapon Glaive = new Weapon ("Glaive", 8,15, "a sharp glaive");
//        Weapon Guisarme = new Weapon ("Guisarme", 9,15,"a long guisarme");
//        Weapon ShortSword = new Weapon ("ShortSword", 10,3,"a short sword");
//        Weapon Battleaxe = new Weapon ("Battleaxe", 10,7,"a large axe for battle");
//        Weapon Halberd = new Weapon("Halberd",10,15,"a long halberd");
//        Weapon Ranseur = new Weapon("Ranseur", 10,15,"a long ranseur");
//        Weapon Warhammer = new Weapon("Warhammer", 12,8,"a huge warhammer");
//        Weapon Longsword = new Weapon("Longsword", 15,4,"a long sword");
//
//    }
//
//    private void createArmors(){
//	    Armor Padded = new Armor ("Padded", 5, 10, "a common padded");
//	    Armor Leather = new Armor ("Leather", 10, 15, "a common leather");
//	    Armor StuddedLeather = new Armor ("StuddedLeather", 25,20,"a studded leather");
//	    Armor ChainShirt = new Armor ("ChainShirt",100,25,"a chain shirt" );
//	    Armor Hide = new Armor("Hide", 15,25,"a hide made of ox skin");
//	    Armor ScaleMail = new Armor ("ScaleMail",50,30,"a scale mail made of metal");
//	    Armor Chainmail = new Armor ("Chainmail", 150,40,"a good chainmail");
//	    Armor Breastplate = new Armor ("Breastplate", 200,30,"a breastplate protect your heart");
//
//    }

    public void settingUpItems(){

        // Initiate gold in different locations
        location1.getInventory().addMoney(20);
        location2.getInventory().addMoney(50);
        location4.getInventory().addMoney(10);

        // Initiate items lying on different locations
        startUp.getInventory().addItem(new Weapon ("dagger",10,2,"a small dagger"));
        location2.getInventory().addItem(new Armor("leather", 20, 15, "a common leather"));
        location3.getInventory().addItem(new Weapon("longsword", 15, 4, "a long sword"));
        location3.getInventory().addItem(new Armor("hide", 150, 25, "a hide made of ox skin"));

        // Initiate items in shops
        shop1.getInventory().addItem(new Weapon("nunchaku",2,2,"a traditional nunchaku"));
        shop1.getInventory().addItem(new Weapon("greatclub",5,10,"a greatclub with nails on it"));
        shop1.getInventory().addItem(new Weapon("longspear",5,9,"a long spear"));
        shop1.getInventory().addItem(new Weapon("handaxe",6,5,"a common handaxe"));
        shop1.getInventory().addItem(new Weapon("warhammer",12,8,"a huge warhammer"));

        shop2.getInventory().addItem(new Armor("padded",5,10,"a common padded"));
        shop2.getInventory().addItem(new Armor("chainshirt", 100, 25, "a chain shirt"));
        shop2.getInventory().addItem(new Armor("scalemail", 50, 30, "a scale mail made of metal"));
        shop2.getInventory().addItem(new Armor("chainmail", 150, 40, "a good chainmail"));
        shop2.getInventory().addItem(new Armor("breastplate", 200, 30, "a breastplate protect your heart"));

    }
	
	
	 private void populateStrengthTable()
     {
         StrengthTable strengthModifiers = StrengthTable.getInstance();
         strengthModifiers.setModifier(1, -5);
         strengthModifiers.setModifier(2, -4);
         strengthModifiers.setModifier(3, -4);
         strengthModifiers.setModifier(4, -3);
         strengthModifiers.setModifier(5, -3);
         strengthModifiers.setModifier(6, -2);
         strengthModifiers.setModifier(7, -2);
         strengthModifiers.setModifier(8, -1);
         strengthModifiers.setModifier(9, -1);
         strengthModifiers.setModifier(10, 0);
         strengthModifiers.setModifier(11, 0);
         strengthModifiers.setModifier(12, 1);
         strengthModifiers.setModifier(13, 1);
         strengthModifiers.setModifier(14, 2);
         strengthModifiers.setModifier(15, 2);
         strengthModifiers.setModifier(16, 3);
         strengthModifiers.setModifier(17, 3);
         strengthModifiers.setModifier(18, 4);
         strengthModifiers.setModifier(19, 4);
         strengthModifiers.setModifier(20, 5);
         strengthModifiers.setModifier(21, 5);
         strengthModifiers.setModifier(22, 5);
         strengthModifiers.setModifier(23, 5);
         strengthModifiers.setModifier(24, 5);
         strengthModifiers.setModifier(25, 5);
         strengthModifiers.setModifier(26, 8);
         strengthModifiers.setModifier(27, 8);
         strengthModifiers.setModifier(28, 8);
         strengthModifiers.setModifier(29, 8);
         strengthModifiers.setModifier(30, 10);
         strengthModifiers.setModifier(31, 10);
         strengthModifiers.setModifier(32, 10);
         strengthModifiers.setModifier(33, 10);
         strengthModifiers.setModifier(34, 10);
         strengthModifiers.setModifier(35, 10);
         strengthModifiers.setModifier(36, 12);
         strengthModifiers.setModifier(37, 12);
         strengthModifiers.setModifier(38, 12);
         strengthModifiers.setModifier(39, 12);
         strengthModifiers.setModifier(40, 12);
         strengthModifiers.setModifier(41, 15);
         strengthModifiers.setModifier(42, 15);
         strengthModifiers.setModifier(43, 15);
         strengthModifiers.setModifier(44, 17);
         strengthModifiers.setModifier(45, 17);
         strengthModifiers.setModifier(46, 18);
     }

     private void populateAgilityTable()
     {
         AgilityTable agilityModifiers = AgilityTable.getInstance();
         agilityModifiers.setModifier(1, -5);
         agilityModifiers.setModifier(2, -5);
         agilityModifiers.setModifier(3, -5);
         agilityModifiers.setModifier(4, -3);
         agilityModifiers.setModifier(5, -3);
         agilityModifiers.setModifier(6, -2);
         agilityModifiers.setModifier(7, -2);
         agilityModifiers.setModifier(8, -1);
         agilityModifiers.setModifier(9, -1);
         agilityModifiers.setModifier(10, 0);
         agilityModifiers.setModifier(11, 0);
         agilityModifiers.setModifier(12, 1);
         agilityModifiers.setModifier(13, 1);
         agilityModifiers.setModifier(14, 2);
         agilityModifiers.setModifier(15, 2);
         agilityModifiers.setModifier(16, 3);
         agilityModifiers.setModifier(17, 3);
         agilityModifiers.setModifier(18, 4);
         agilityModifiers.setModifier(19, 4);
         agilityModifiers.setModifier(20, 6);
         agilityModifiers.setModifier(21, 6);
         agilityModifiers.setModifier(22, 6);
         agilityModifiers.setModifier(23, 6);
         agilityModifiers.setModifier(24, 6);
         agilityModifiers.setModifier(25, 6);
         agilityModifiers.setModifier(26, 8);
         agilityModifiers.setModifier(27, 8);
         agilityModifiers.setModifier(28, 8);
         agilityModifiers.setModifier(29, 8);
         agilityModifiers.setModifier(30, 8);
         agilityModifiers.setModifier(31, 8);
         agilityModifiers.setModifier(32, 11);
         agilityModifiers.setModifier(33, 11);
         agilityModifiers.setModifier(34, 11);
         agilityModifiers.setModifier(35, 11);
         agilityModifiers.setModifier(36, 11);
         agilityModifiers.setModifier(37, 11);
         agilityModifiers.setModifier(38, 13);
         agilityModifiers.setModifier(39, 13);
         agilityModifiers.setModifier(40, 13);
         agilityModifiers.setModifier(41, 13);
         agilityModifiers.setModifier(42, 13);
         agilityModifiers.setModifier(43, 13);
         agilityModifiers.setModifier(44, 15);
         agilityModifiers.setModifier(45, 15);
         agilityModifiers.setModifier(46, 15);
     }

     private void populateWeightLimitTable()
     {
         WeightLimit weightModifier = WeightLimit.getInstance();
         weightModifier.setModifier(1, 6);
         weightModifier.setModifier(2, 13);
         weightModifier.setModifier(3, 20);
         weightModifier.setModifier(4, 26);
         weightModifier.setModifier(5, 33);
         weightModifier.setModifier(6, 40);
         weightModifier.setModifier(7, 46);
         weightModifier.setModifier(8, 53);
         weightModifier.setModifier(9, 60);
         weightModifier.setModifier(10, 66);
         weightModifier.setModifier(11, 76);
         weightModifier.setModifier(12, 86);
         weightModifier.setModifier(13, 100);
         weightModifier.setModifier(14, 116);
         weightModifier.setModifier(15, 133);
         weightModifier.setModifier(16, 153);
         weightModifier.setModifier(17, 173);
         weightModifier.setModifier(18, 200);
         weightModifier.setModifier(19, 233);
         weightModifier.setModifier(20, 266);
         weightModifier.setModifier(21, 306);
         weightModifier.setModifier(22, 346);
         weightModifier.setModifier(23, 400);
         weightModifier.setModifier(24, 466);
         weightModifier.setModifier(25, 533);
         weightModifier.setModifier(26, 613);
         weightModifier.setModifier(27, 693);
         weightModifier.setModifier(28, 800);
         weightModifier.setModifier(29, 933);
         weightModifier.setModifier(30, 1013);
         weightModifier.setModifier(31, 1093);
         weightModifier.setModifier(32, 1300);
         weightModifier.setModifier(33, 1433);
         weightModifier.setModifier(34, 1513);
         weightModifier.setModifier(35, 1593);
         weightModifier.setModifier(36, 1700);
         weightModifier.setModifier(37, 1833);
         weightModifier.setModifier(38, 1913);
         weightModifier.setModifier(39, 1993);
         weightModifier.setModifier(40, 2100);
         weightModifier.setModifier(41, 2233);
         weightModifier.setModifier(42, 2313);
         weightModifier.setModifier(43, 2393);
         weightModifier.setModifier(44, 2500);
         weightModifier.setModifier(45, 2633);
         weightModifier.setModifier(46, 2713);
     }
}
