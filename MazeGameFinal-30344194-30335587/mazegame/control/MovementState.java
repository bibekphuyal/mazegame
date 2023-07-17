package mazegame.control;

import mazegame.entity.Blacksmith;
import mazegame.entity.Player;

public class MovementState extends CommandState {
    public MovementState()
    {
        this.getAvailableCommands().put("quit", new QuitCommand());
        this.getAvailableCommands().put("move", new MoveCommand());
        this.getAvailableCommands().put("look", new LookCommand());
        this.getAvailableCommands().put("attack", new AttackCommand());
        this.getAvailableCommands().put("flee", new Flee());
        this.getAvailableCommands().put("list", new ListCommand());
        this.getAvailableCommands().put("get", new GetCommand());
        this.getAvailableCommands().put("drop", new DropCommand());
        this.getAvailableCommands().put("potion", new PotionCommand());
        this.getAvailableCommands().put("equip", new EquipCommand());
        this.getAvailableCommands().put("unequip", new UnequipCommand());

    }

    public CommandState update(Player thePlayer)
    {
        if (thePlayer.getCurrentLocation() instanceof Blacksmith)
            return new CommerceState();
        return this;
    }
}
