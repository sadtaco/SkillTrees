package me.sadtaco.SkillTrees;

import java.util.logging.Logger;

import me.sadtaco.SkillTrees.Skills.Tree;

import org.bukkit.entity.Player;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.gui.Container;
import org.getspout.spoutapi.gui.ContainerType;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericContainer;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.InGameHUD;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.Screen;
import org.getspout.spoutapi.gui.WidgetAnchor;

public class SkillsGui {
	
	private static SkillTrees plugin;
	
	public final Logger logger = Logger.getLogger("Minecraft");
	
	public SkillsGui(SkillTrees plugin) {
		SkillsGui.setPlugin(plugin);
	}
	
	static GenericPopup skillTreePopup;
	static Container curTab;

	public void skillHint(Player player){
		SpoutPlayer sPlayer = SpoutManager.getPlayer(player);
		
		GenericLabel label = new GenericLabel("Press \"K\" to open Skills");
		label.setTextColor(new Color(1.0F, 0.3F, 0.15F, 1.0F)); 
		label.setAlign(WidgetAnchor.BOTTOM_RIGHT).setAnchor(WidgetAnchor.BOTTOM_RIGHT);
		sPlayer.getMainScreen().attachWidget(getPlugin(), label);
	}
	
	public void openSkillTree(Player player){
		if( plugin == null )
			this.logger.info("plugin is null.");
		SpoutPlayer sPlayer = SpoutManager.getPlayer(player);
		
		GenericPopup popup = new GenericPopup();
		skillTreePopup = popup;
		
		GenericTexture bg = new GenericTexture();
		bg.setUrl("SkillTree.png");
		bg.setWidth(300).setHeight(230);
		bg.setX(-150).setY(5);
		bg.setPriority(RenderPriority.Highest);
		bg.setAnchor(WidgetAnchor.TOP_CENTER);
		popup.attachWidget(getPlugin(), bg);
		
		Container tabs = new GenericContainer();
		tabs.setLayout(ContainerType.VERTICAL);
		tabs.setWidth(50).setHeight(230);
		tabs.setAnchor(WidgetAnchor.TOP_CENTER);
		tabs.setX(-150).setY(6);
		
		createTab(tabs, "Bow");
		createTab(tabs, "Sword");
		createTab(tabs, "Axe");
		createTab(tabs, "Hoe");
		createTab(tabs, "Shovel");
		createTab(tabs, "Pickaxe");
		createTab(tabs, "Boning");
		createTab(tabs, "Sorcery");
		createTab(tabs, "Smithing");
		
		popup.attachWidget(getPlugin(), tabs);
		
		sPlayer.getMainScreen().attachPopupScreen(popup);
	}
	
	public boolean skillTreeIsOpen(Screen screen){
		if( skillTreePopup == null )
			return false;
		if( skillTreePopup == ((InGameHUD) screen).getActivePopup() )
			return true;
		else
			return false;
	}
	
	public void closeSkillTree(){
		skillTreePopup.close();
	}
	
	public void switchSkillTreeTab(Button button){		
		Tree tree = new Tree(skillTreePopup, getPlugin());
		curTab = tree.box;
		
		String name = button.getTooltip();
		GenericLabel label = new GenericLabel();
		label.setText(name + "\nYou probably wish this did something, but it doesn't yet.");
		label.setAnchor(WidgetAnchor.TOP_CENTER);
		label.setWidth(168);
		label.setX(-90).setY(10);
		label.setHeight(10);
		label.setScale(0.7F);
		skillTreePopup.attachWidget(getPlugin(), label);
	}
	
	public void createTab(Container box, String name){
		Container outter = new GenericContainer();
		outter.setAlign(WidgetAnchor.CENTER_CENTER);
		Container buttonStack = new GenericContainer();
		buttonStack.setLayout(ContainerType.OVERLAY);
		buttonStack.setMargin(2, 0, 0, 2);
		buttonStack.shiftXPos(buttonStack.getWidth() / -2);
		
		GenericButton button = new GenericButton("");
		button.setWidth(55).setHeight(21).setFixed(true);
		button.setTooltip(name + " Skills");
		button.setPriority(RenderPriority.High);
		buttonStack.addChild(button);
		
		GenericTexture tex = new GenericTexture();
		tex.setUrl(name + ".png");
		tex.setWidth(16).setHeight(16).setFixed(true);
		tex.setMargin(2,22,3,2);
		tex.setPriority(RenderPriority.Normal);
		buttonStack.addChild(tex);
		
		GenericLabel label = new GenericLabel();
		label.setText(name + "\nSkills");
		label.setPriority(RenderPriority.Normal);
		label.setWidth(22);
		label.setMargin(3,2,3,19);
		label.setScale(0.8F);
		buttonStack.addChild(label);
		
		outter.addChild(buttonStack);
		box.addChild(outter);
	}
	
	public static SkillTrees getPlugin() {
		return plugin;
	}
	public static void setPlugin(SkillTrees plugin) {
		SkillsGui.plugin = plugin;
	}
}