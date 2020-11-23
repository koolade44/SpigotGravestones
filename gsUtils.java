package com.koolade446.prepvp;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class gsUtils {

    public static List<ItemStack> gatherItems (Player player) {
        List<ItemStack> items = new ArrayList<>();

        for (ItemStack item : player.getInventory().getContents()) {
            if (isValid(item)) items.add(item);
        }


        if (isValid(player.getItemOnCursor())) items.add(player.getItemOnCursor());
        return items;
    }

    public static boolean isValid(ItemStack item) {
        return item != null && !item.getType().isAir();
    }

    public static int countItems (List<ItemStack> items) {
        int count = 0;

        for (ItemStack item : items) {
            if (isValid(item)) count++;
        }
        return count;
    }

    public static void createGravestone (Player player, Location loc) {
        World world = loc.getWorld();
        List<ItemStack> items = gatherItems(player);
        int count = countItems(items);

        if (count <= 27) chestHandler.createSingleChest(items, loc, world);
        else if (count > 27) chestHandler.createDoubleChest(items, loc, world);
    }
}
