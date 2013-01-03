package com.gmail.chase4926.stattracker;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.EntityTameEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.weather.LightningStrikeEvent;

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
		String name = "BlocksBroken";
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
	public void CreeperExplodeTracker(EntityExplodeEvent event) {
		if (event.getEntityType() == EntityType.CREEPER) {
			String name = "CreepersExploded";
			if (plugin.getConfig().getBoolean(name)) {
				plugin.set_value(name, plugin.get_value(name) + 1);
			}
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
	public void ItemEnchantTracker(EnchantItemEvent event) {
		String name = "ItemsEnchanted";
		if (plugin.getConfig().getBoolean(name)) {
			plugin.set_value(name, plugin.get_value(name) + 1);
		}
	}
	
	@EventHandler
	public void ItemSmeltTracker(FurnaceSmeltEvent event) {
		String name = "ItemsSmelted";
		if (plugin.getConfig().getBoolean(name)) {
			plugin.set_value(name, plugin.get_value(name) + 1);
		}
	}
	
	@EventHandler
	public void LightningStrikeTracker(LightningStrikeEvent event) {
		String name = "LightningStrikes";
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
	public void PetTameTracker(EntityTameEvent event) {
		String name = "PetsTamed";
		if (plugin.getConfig().getBoolean(name)) {
			plugin.set_value(name, plugin.get_value(name) + 1);
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
