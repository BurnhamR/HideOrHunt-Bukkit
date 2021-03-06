package me.Latestion.HOH.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetEvent;

import me.Latestion.HOH.HideOrHunt;
import me.Latestion.HOH.Game.GameState;

public class TrulyGrace implements Listener {

	private HideOrHunt plugin;
	
	public TrulyGrace(HideOrHunt plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		if (GameState.getCurrentGamestate() == GameState.ON)  {
			if (plugin.game.grace) {
				if (plugin.getConfig().getBoolean("Grace-Period-Peaceful")) {
					event.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void target(EntityTargetEvent event) {
		if (GameState.getCurrentGamestate() == GameState.ON)  {
			if (plugin.game.grace) {
				if (plugin.getConfig().getBoolean("Grace-Period-Peaceful")) {
					event.setCancelled(true);
				}
			}
		}
	}
}
