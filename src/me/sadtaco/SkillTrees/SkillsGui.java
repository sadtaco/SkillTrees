package me.sadtaco.SkillTrees;

import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericPopup;

public class SkillsGui {
	
	private static SkillTrees plugin;
	
	public SkillsGui(ServerChatPlayerListener serverChatPlayerListener) {
		// TODO Auto-generated constructor stub
	}

	public void skillHint(){
		GenericPopup Popup = new GenericPopup();
		GenericButton Button = new GenericButton("+");
		
		Button.setColor(new Color(1.0F, 1.0F, 0, 1.0F)); //This makes the button text yellow.
		Button.setHoverColor(new Color(1.0F, 0, 0, 1.0F)); //When you hover over with a mouse this makes the text red.
		Button.setX(100).setY(100); //Puts the button at 100*100 on the screen
		Button.setWidth(40).setHeight(40); //Makes the button 200 wide and 20 high
		Popup.attachWidget(plugin, Button);
	}

}