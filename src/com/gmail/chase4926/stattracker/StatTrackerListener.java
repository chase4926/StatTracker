package com.gmail.chase4926.stattracker;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class StatTrackerListener implements Listener {
	private StatTracker plugin = null;
	
	public StatTrackerListener(StatTracker p) {
		plugin = p;
	}
	
	@EventHandler
	public void ArrowFireTracker(EntityShootBowEvent event) {
		String name = "ArrowsFired";
		if (plugin.getConfig().getBoolean(name)) {
			plugin.set_value(name, plugin.get_value(name) + 1);
		}
	}
	
	@EventHandler
	public void BlockBreakTracker(BlockBreakEvent event) {
		String name = "BlocksBroke";
		if (plugin.getConfig().getBoolean(name)) {
			plugin.set_value(name, plugin.get_value(name) + 1);
		}
	}
	
	@EventHandler
	public void BlockBurnTracker(BlockBurnEvent event) {
		String name = "BlocksBurned";
		if (plugin.getConfig().getBoolean(name)) {
			plugin.set_value(name, plugin.get_value(name) + 1);
		}
	}
	
	@EventHandler
	public void BlockPlaceTracker(BlockPlaceEvent event) {
		String name = "BlocksPlaced";
		if (plugin.getConfig().getBoolean(name)) {
			plugin.set_value(name, plugin.get_value(name) + 1);
		}
	}
	
	@EventHandler
	public void EggThrowTracker(PlayerEggThrowEvent event) {
		String name = "EggsThrown";
		if (plugin.getConfig().getBoolean(name)) {
			plugin.set_value(name, plugin.get_value(name) + 1);
		}
	}
	
	@EventHandler
	public void ItemCraftTracker(CraftItemEvent event) {
		String name = "ItemsCrafted";
		if (plugin.getConfig().getBoolean(name)) {
			plugin.set_value(name, plugin.get_value(name) + 1);
		}
	}
	
	@EventHandler
	public void MobDeathTracker(EntityDeathEvent event) {
		if (event.getEntity() instanceof Monster) {
			String name = "MobsKilled";
			if (plugin.getConfig().getBoolean(name)) {
				plugin.set_value(name, plugin.get_value(name) + 1);
			}
		}
	}
	
	@EventHandler
	public void PlayerDeathTracker(PlayerDeathEvent event) {
		String name = "PlayerDeaths";
		if (plugin.getConfig().getBoolean(name)) {
			plugin.set_value(name, plugin.get_value(name) + 1);
		}
	}
	
	@EventHandler
	public void PlayerJoinTracker(PlayerJoinEvent event) {
		String name = "PlayersJoined";
		if (plugin.getConfig().getBoolean(name)) {
			plugin.set_value(name, plugin.get_value(name) + 1);
		}
	}
	
	@EventHandler
	public void SnowballThrowTracker(ProjectileLaunchEvent event) {
		if (event.getEntityType() == EntityType.SNOWBALL) {
			String name = "SnowballsThrown";
			if (plugin.getConfig().getBoolean(name)) {
				plugin.set_value(name, plugin.get_value(name) + 1);
			}
		}
	}
}
