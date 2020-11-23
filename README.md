# SpigotGravestones
Makes making spigot gravestones easier!

Simply download the three provided files and copy them into your spigot source folder

functions:

`gsUtils.gatherItems(Player)` returns ArrayList of all items in players inventory,  
`gsUtils.isValid(ItemStack)` returns true if the item specified is not air or null,  
`gsUtils.countItems(List<ItemStack>)` returns the number of items in a ItemStack ArrayList,  
`gsUtils.createGravestone(Player, Location)` creates a gravestone for the specified player at the specified location,  
Notice: the chestHandler class works directly with the gsUtils class and can not be used seprate,  
`blockHandler.setBlock(Location, Material)` sets the specified block at the specified location, returns BlockState  

Ex:

               public class Listeners implements Listener {
                        public void PlayerDeath (PlayerDeathEvent event) {
                        Player player = event.getEntity().getPlayer();
                        Location loc = player.getLoaction();
                        World world = player.getWorld
                
                        if (!world.getGameRuleValue(GameRule.KEEP_INVENTORY)) gsUtils.createGravestone(player, loc);
                        event.getDrops().clear();
                        }
                }

Using blockHandler.setBlock

`Chest chest = (Chest) blockHandler.setBlock(Loaction, Material.CHEST);`
