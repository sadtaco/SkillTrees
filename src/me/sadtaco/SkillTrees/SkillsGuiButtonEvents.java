package me.sadtaco.SkillTrees;

import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.event.screen.ScreenListener;
import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.player.SpoutPlayer;

public class SkillsGuiButtonEvents extends ScreenListener{
	
	private static SkillTrees plugin;
	private static SkillsGui gui;
	
	public SkillsGuiButtonEvents(){
		plugin = SkillTrees.plugin;
		gui = new SkillsGui(plugin);
	}
	
	@Override
	public void onButtonClick(ButtonClickEvent event) {
		Button button = event.getButton();
		SpoutPlayer sPlayer = event.getPlayer(); 
		sPlayer.sendMessage("Button "+button.getTooltip()+" clicked");
		gui.switchSkillTreeTab(button);
	}
	
	/*public void onScreenClose(ScreenCloseEvent event){
		
	}*/
}
