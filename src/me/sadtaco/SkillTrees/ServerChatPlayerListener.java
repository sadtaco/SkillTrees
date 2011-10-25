package me.sadtaco.SkillTrees;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;

public class ServerChatPlayerListener extends PlayerListener {
	
	private static SkillTrees plugin;
	private static SkillsGui gui;
	
	public ServerChatPlayerListener(){
		plugin = SkillTrees.plugin;
		gui = new SkillsGui(plugin);
	}
	
	public void onPlayerChat(PlayerChatEvent event){
		Player p = event.getPlayer();
		String msg = event.getMessage().toLowerCase();
		if( msg.contains("hi") && msg.contains("server") ){
			p.sendMessage(ChatColor.RED + "[Server] " + ChatColor.WHITE + "Hi!");
		}
	}
	
	public void onPlayerJoin(PlayerJoinEvent event){
		Player p = event.getPlayer();
		gui.skillHint(p);
	}
}