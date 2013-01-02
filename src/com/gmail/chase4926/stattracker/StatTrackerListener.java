package com.gmail.chase4926.stattracker;

import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.CraftItemEvent;

public class StatTrackerListener implements Listener {
	private StatTracker plugin = null;
	
	public StatTrackerListener(StatTracker p) {
		plugin = p;
	}
	
	@EventHandler
	public void BlockPlaceTracker(BlockPlaceEvent event) {
		String name = "BlocksPlaced";
		plugin.set_value(name, plugin.get_value(name) + 1);
	}
	
	@EventHandler
	public void BlockBreakTracker(BlockBreakEvent event) {
		String name = "BlocksBroke";
		plugin.set_value(name, plugin.get_value(name) + 1);
	}
	
	@EventHandler
	public void ItemCraftedTracker(CraftItemEvent event) {
		String name = "ItemsCrafted";
		plugin.set_value(name, plugin.get_value(name) + 1);
	}
	
	@EventHandler
	public void MobDeathTracker(EntityDeathEvent event) {
		if (event.getEntity() instanceof Monster) {
			String name = "MobsKilled";
			plugin.set_value(name, plugin.get_value(name) + 1);
		}
	}
}
