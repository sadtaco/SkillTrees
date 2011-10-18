package me.sadtaco.SkillTrees;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.event.input.InputListener;
import org.getspout.spoutapi.event.input.KeyReleasedEvent;
import org.getspout.spoutapi.keyboard.Keyboard;

public class SkillsKeyboardListener extends InputListener {
	
	public static SkillTrees plugin;
	public final SkillsGui gui = new SkillsGui(plugin);
	
	public SkillsKeyboardListener(SkillTrees instance){
		plugin = instance;
	}
	
    @Override
    public void onKeyReleasedEvent(KeyReleasedEvent event) {
    	if( event.getKey() == Keyboard.KEY_K ){
    		Player p = event.getPlayer();
    		p.sendMessage(ChatColor.RED + "[Server] " + ChatColor.WHITE + "You pressed K.");
    		
    		gui.openSkillTree(p);
    	}
    }
}