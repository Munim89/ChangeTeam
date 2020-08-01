package me.SilverBeast.ChangeTeam;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener {
	
	public Inventory inv;
	
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
		createInv();
	}
	@Override
	public void onDisable() {
		
	}
	public boolean onCommand(CommandSender sender, Command cmd,  String label, String[] args) {
		// /changeteam
		if (label.equalsIgnoreCase("changeteam")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("You cannot do this!");
				return true;
			}
			Player player = (Player) sender;
			// open the GUI
			player.openInventory(inv);
			return true;
		}
		return false;
	}
	
	@EventHandler()
	public void onClick(InventoryClickEvent event) {
		if (!event.getInventory().equals(inv))
			return;
		if (event.getCurrentItem() == null) return;
		if (event.getCurrentItem().getItemMeta() == null) return;
		if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
		
		event.setCancelled(true);
		
		Player player = (Player) event.getWhoClicked();
		if (event.getSlot() == 0 && event.getCurrentItem().getType() == Material.BLUE_CONCRETE) {
			// blue team
			ItemStack[] armor = player.getEquipment().getArmorContents();
			armor = changeColor(armor, Color.BLUE);
			player.getEquipment().setArmorContents(armor);
			player.sendMessage(ChatColor.GOLD + "You changed your team!");
		}
		if (event.getSlot() == 1 && event.getCurrentItem().getType() == Material.RED_CONCRETE) {
			// red team
			ItemStack[] armor = player.getEquipment().getArmorContents();
			armor = changeColor(armor, Color.RED);
			player.getEquipment().setArmorContents(armor);
			player.sendMessage(ChatColor.GOLD + "You changed your team!");
		}
		if (event.getSlot() == 2 && event.getCurrentItem().getType() == Material.LIME_CONCRETE) {
			// green team
			ItemStack[] armor = player.getEquipment().getArmorContents();
			armor = changeColor(armor, Color.LIME);
			player.getEquipment().setArmorContents(armor);
			player.sendMessage(ChatColor.GOLD + "You changed your team!");
		}
		if (event.getSlot() == 3 && event.getCurrentItem().getType() == Material.ORANGE_CONCRETE) {
			// orange team
			ItemStack[] armor = player.getEquipment().getArmorContents();
			armor = changeColor(armor, Color.ORANGE);
			player.getEquipment().setArmorContents(armor);
			player.sendMessage(ChatColor.GOLD + "You changed your team!");
		}
		if (event.getSlot() == 4 && event.getCurrentItem().getType() == Material.PURPLE_CONCRETE) {
			// purple team
			ItemStack[] armor = player.getEquipment().getArmorContents();
			armor = changeColor(armor, Color.PURPLE);
			player.getEquipment().setArmorContents(armor);
			player.sendMessage(ChatColor.GOLD + "You changed your team!");
		}
		if (event.getSlot() == 5 && event.getCurrentItem().getType() == Material.CYAN_CONCRETE) {
			// cyan team
			ItemStack[] armor = player.getEquipment().getArmorContents();
			armor = changeColor(armor, Color.AQUA);
			player.getEquipment().setArmorContents(armor);
			player.sendMessage(ChatColor.GOLD + "You changed your team!");
		}
		if (event.getSlot() == 6 && event.getCurrentItem().getType() == Material.BLACK_CONCRETE) {
			// black team
			ItemStack[] armor = player.getEquipment().getArmorContents();
			armor = changeColor(armor, Color.BLACK);
			player.getEquipment().setArmorContents(armor);
			player.sendMessage(ChatColor.GOLD + "You changed your team!");
		}
		if (event.getSlot() == 8 && event.getCurrentItem().getType() == Material.BARRIER) {
			player.closeInventory();
		}
		
		return;
		
	}
	public ItemStack[] changeColor(ItemStack[] a, Color color) {
		for (ItemStack item : a) {
			try {
				if (item.getType() == Material.LEATHER_BOOTS || item.getType() == Material.LEATHER_CHESTPLATE ||
						item.getType() == Material.LEATHER_HELMET || item.getType() == Material.LEATHER_LEGGINGS) {
					LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
					meta.setColor(color);
					item.setItemMeta(meta);
				}
			} catch(Exception e) {
				// do nothing
			}                                              
		}
		
		return a;
	}
	
	
	public void createInv() {
		inv = Bukkit.createInventory(null, 9, ChatColor.GOLD + "" + ChatColor.BOLD +"ChangeTeam");
		
		ItemStack item = new ItemStack(Material.BLUE_CONCRETE);
		ItemMeta meta = item.getItemMeta();
		
		// Blue Team
		meta.setDisplayName(ChatColor.DARK_BLUE + "Blue Team");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "Click to join team");
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(0, item);
		
		// Red Team
		item.setType(Material.RED_CONCRETE);
		meta.setDisplayName(ChatColor.DARK_RED + "Red Team");
		item.setItemMeta(meta);
		inv.setItem(1, item);
		
		// Green Team
		item.setType(Material.LIME_CONCRETE);
		meta.setDisplayName(ChatColor.GREEN + "Green Team");
		item.setItemMeta(meta);
		inv.setItem(2, item);
		
		// Orange Team
		item.setType(Material.ORANGE_CONCRETE);
		meta.setDisplayName(ChatColor.GOLD + "Orange Team");
		item.setItemMeta(meta);
		inv.setItem(3, item);
		
		// Purple Team
		item.setType(Material.PURPLE_CONCRETE);
		meta.setDisplayName(ChatColor.DARK_PURPLE + "Purple Team");
		item.setItemMeta(meta);
		inv.setItem(4, item);
				
		// Red Team
		item.setType(Material.CYAN_CONCRETE);
		meta.setDisplayName(ChatColor.BLUE + "Blue Team");
		item.setItemMeta(meta);
		inv.setItem(5, item);
		
		// Red Team
		item.setType(Material.BLACK_CONCRETE);
		meta.setDisplayName(ChatColor.DARK_GRAY + "Black Team");
		item.setItemMeta(meta);
		inv.setItem(6, item);
		
		// close button
		item.setType(Material.BARRIER);
		meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Close Menu");
		lore.clear();
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(8, item);
	}
}
