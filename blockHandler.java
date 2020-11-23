package com.koolade446.prepvp;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;

public class blockHandler {
    public static BlockState setBlock (Location loc, Material block) {
        World world = loc.getWorld();
        Block setBlock = world.getBlockAt(loc);
        setBlock.setType(block);
        return setBlock.getState();
    }
}
