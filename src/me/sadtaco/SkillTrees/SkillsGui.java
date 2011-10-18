package me.sadtaco.SkillTrees;

import org.bukkit.entity.Player;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericGradient;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.WidgetAnchor;

public class SkillsGui {
	
	private static SkillTrees plugin;
	
	public SkillsGui(SkillTrees plugin) {
		SkillsGui.setPlugin(plugin);
	}

	public void skillHint(Player player){
		SpoutPlayer sPlayer = SpoutManager.getPlayer(player);
		
		GenericLabel label = new GenericLabel("Press \"K\" to open Skills");
		label.setTextColor(new Color(1.0F, 0.3F, 0.15F, 1.0F)); 
		label.setAlign(WidgetAnchor.BOTTOM_RIGHT).setAnchor(WidgetAnchor.BOTTOM_RIGHT);
		sPlayer.getMainScreen().attachWidget(getPlugin(), label);
	}
	
	public void openSkillTree(Player player){
		SpoutPlayer sPlayer = SpoutManager.getPlayer(player);
		
		GenericPopup popup = new GenericPopup();
		
		GenericGradient bg = new GenericGradient();
		bg.setTopColor(new Color(0.7F, 0.7F, 0.7F, 0.6F)).setBottomColor(new Color(0.7F, 0.7F, 0.7F, 0.8F));
		bg.setWidth(300).setHeight(220);
		bg.setX(-150).setY(10);
		bg.setPriority(RenderPriority.Highest);
		bg.setAnchor(WidgetAnchor.TOP_CENTER);
		popup.attachWidget(getPlugin(), bg);
		
		GenericButton buttonSkill1 = new GenericButton("+");
		buttonSkill1.setColor(new Color(1.0F, 1.0F, 0, 1.0F));
		buttonSkill1.setHoverColor(new Color(1.0F, 0, 0, 1.0F));
		buttonSkill1.setX(-145).setY(15);
		buttonSkill1.setWidth(20).setHeight(16); 
		buttonSkill1.setAnchor(WidgetAnchor.TOP_CENTER);
		buttonSkill1.setPriority(RenderPriority.High);
		buttonSkill1.setTooltip("Mining Skills");
		popup.attachWidget(getPlugin(), buttonSkill1);
		
		GenericTexture texture = new GenericTexture();
		texture.setUrl("Archery.png"); //Have to be a png or jpg
		//texture.setUrl("http://www.google.com/intl/en_com/images/srpr/logo3w.png");
		texture.setWidth(16).setHeight(16); //Use the same size as the png here.
		texture.setX(-160).setY(17);
		texture.setAnchor(WidgetAnchor.TOP_CENTER);
		texture.setPriority(RenderPriority.Normal);
		popup.attachWidget(getPlugin(), texture);
		
		sPlayer.getMainScreen().attachPopupScreen(popup);
	}
	
	public static SkillTrees getPlugin() {
		return plugin;
	}
	public static void setPlugin(SkillTrees plugin) {
		SkillsGui.plugin = plugin;
	}
}