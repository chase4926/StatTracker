package com.gmail.chase4926.stattracker;

import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.inventory.CraftItemEvent;

public class StatTrackerListener implements Listener {
	private StatTracker plugin = null;
	
	public StatTrackerListener(StatTracker p) {
		plugin = p;
	}
	
	@EventHandler
	public void BlockPlaceTracker(BlockPlaceEvent event) {
		String name = "BlocksPlaced";
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
	public void ArrowFireTracker(EntityShootBowEvent event) {
		String name = "ArrowsFired";
		if (plugin.getConfig().getBoolean(name)) {
			plugin.set_value(name, plugin.get_value(name) + 1);
		}
	}
}
