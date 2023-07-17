package mazegame.entity;

public class Party {
	
	
	   private Boolean moveable;
       public Location m_Location;
       public Character m_Character;
	
	public Party(){
		
	}
	
	
	public Boolean getMoveable(){
		return moveable;
		
	}
	
	public void setMoveable(Boolean _moveable){
	
		this.moveable = _moveable;
		
	}
       
       
       
}
