package mazegame.entity;

import java.util.HashMap;

public class Player extends Character {

    private Location currentLocation;
    private Inventory inventory;
    private int potions;
    private int capacity;
    private int gold;
    private HashMap<String,Item> listofitems;

    public Player() {
    }

    public Player(String name) {
        super (name);
        inventory = new Inventory();
        potions = 3;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Inventory getInventory(){
        return inventory;
    }

    public int getPotions(){
        return potions;
    }

    public void usePotions(){
        potions -= 1;
    }
    
    public void addItem(String ItemLabel,Item item)
	{
		listofitems.put(ItemLabel,item);
		this.capacity+=item.getWeight();
	}
	
	
	public Item getItem(String itemLabel){
		
		return (Item)listofitems.get(itemLabel);
	}
	
	public void removeItem(String itemLabel,Item item){
		listofitems.remove(itemLabel);
		this.capacity -= item.getWeight();
	}
	
	public void equip(String ItemLabel,Item item)
	{
		listofitems.remove(ItemLabel, item);
	}
	
	public void unequip(String itemLabel,Item item){
		listofitems.put(itemLabel,item);
	}
	
	public HashMap<String, Item> getListOfItem()
	{
		return listofitems;
	}
	
	
	
	public int getCapacity(){
		
		return capacity;
	}
	
	
	public void setCapacity(int _capacity){
		
		this.capacity = _capacity;
	}
	
	public int getGold(){
		
		return gold;
	}
	
	
	public void setGold(int _gold){
		
		this.gold = _gold;
	}


}
