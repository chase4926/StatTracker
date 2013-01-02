package com.gmail.chase4926.stattracker;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class StatTrackerListener implements Listener {
	private StatTracker plugin = null;
	
	public StatTrackerListener(StatTracker p) {
		plugin = p;
	}
	
	@EventHandler
	public void BlockPlaceTracker(BlockPlaceEvent event) {
		plugin.set_value("BlockPlaced", plugin.get_value("BlockPlaced") + 1);
	}
}
