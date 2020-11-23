package com.koolade446.prepvp;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class chestHandler {
    public static void createSingleChest (List<ItemStack> items, Location loc, World world) {

        Chest chest = (Chest) blockHandler.setBlock(loc, Material.CHEST);

        Inventory inv = chest.getInventory();

        for (int i = 0; i < inv.getSize(); i++) {
            if (items.isEmpty()) break;
            inv.setItem(i, items.remove(0));
        }
    }

    public static void createDoubleChest (List<ItemStack> items, Location loc, World world) {


        Location loc2 = loc.add(1, 0, 0);
        Chest chest1 = (Chest) blockHandler.setBlock(loc, Material.CHEST);
        Chest chest2 = (Chest) blockHandler.setBlock(loc2, Material.CHEST);

        Inventory inv1 = chest1.getInventory();
        Inventory inv2 = chest2.getInventory();

        boolean inv1HasEmptySlot = true;

        while (true) {
            if (inv1HasEmptySlot) {
                for (int i = 0; i < inv1.getSize(); i++) {
                    if (items.isEmpty()) break;
                    inv1.setItem(i, items.remove(0));
                }
                for (ItemStack item : inv1.getContents()) {
                    if (item == null) inv1HasEmptySlot = true;
                    else inv1HasEmptySlot = false; break;
                }
            }
            if (!inv1HasEmptySlot) {
                for (int i = 0; i < inv2.getSize(); i++) {
                    if (items.isEmpty()) break;
                    inv2.setItem(i, items.remove(0));
                }
                break;
            }
            break;
        }
    }
}
