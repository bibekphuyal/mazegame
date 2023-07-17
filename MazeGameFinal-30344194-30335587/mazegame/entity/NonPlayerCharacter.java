package mazegame.entity;

public class NonPlayerCharacter extends Character {
	private Boolean hostile = false;

	public NonPlayerCharacter(String name, int lifePoints){
        super.setName(name);
        super.setLifePoints(lifePoints);
        super.setAgility(10);
        super.setStrength(10);
    }

    public NonPlayerCharacter(String name, int lifePoints, String h)
    {
        super.setName(name);
        super.setLifePoints(lifePoints);
        super.setAgility(8);
        super.setStrength(12);
        hostile = true;
    }


    public boolean getHostile () {
    	return this.hostile;
    }
    
    public void setHostile (boolean hostile) {
    	this.hostile = hostile;
    }

    public String toString(){
        return super.getName();
    }

}
