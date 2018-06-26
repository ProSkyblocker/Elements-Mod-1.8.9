package mike.minecraft.elementsmod.handlers;

import java.util.Random;

import org.lwjgl.input.Keyboard;

import mike.minecraft.elementsmod.AchievementManager;
import mike.minecraft.elementsmod.armor.ArmorRegistry;
import mike.minecraft.elementsmod.armor.CloudCape;
import mike.minecraft.elementsmod.armor.ExplodeBoots;
import mike.minecraft.elementsmod.armor.ExplodeChest;
import mike.minecraft.elementsmod.armor.ExplodeHelm;
import mike.minecraft.elementsmod.armor.ExplodeLegs;
import mike.minecraft.elementsmod.blocks.BlockManager;
import mike.minecraft.elementsmod.items.ItemManager;
import mike.minecraft.elementsmod.tools.ToolManager;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.event.world.ChunkWatchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemPickupEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class ElementEvents {
	
	@SubscribeEvent
	public void onPlayerPickup(ItemPickupEvent event){
		ItemStack stack = event.pickedUp.getEntityItem();
		EntityPlayer player = event.player;
		if(stack.isItemEqual(new ItemStack(ItemManager.crystals, 1, 0))){
			player.triggerAchievement(AchievementManager.worldCrystal);
		} else if(stack.isItemEqual(new ItemStack(ItemManager.crystals, 1, 2))){
			player.triggerAchievement(AchievementManager.enderCrystal);
		} else if(stack.isItemEqual(new ItemStack(BlockManager.elb))){
			player.triggerAchievement(AchievementManager.luckyblock);
		} else if(stack.isItemEqual(new ItemStack(ItemManager.crystals, 1, 1))){
			player.triggerAchievement(AchievementManager.netherCrystal);
		} else if(stack.isItemEqual(new ItemStack(ItemManager.crystals, 1, 3))){
			player.triggerAchievement(AchievementManager.lightgem);
		} else if(stack.isItemEqual(new ItemStack(ItemManager.crystals, 1, 4))){
			player.triggerAchievement(AchievementManager.luckyessence);
		} else if(stack.isItemEqual(new ItemStack(ItemManager.lp))){
			player.triggerAchievement(AchievementManager.luckypotion);
		} else if(stack.isItemEqual(new ItemStack(ToolManager.lp))){
			player.triggerAchievement(AchievementManager.luckysword);
		} else if(stack.isItemEqual(new ItemStack(ToolManager.ws))){
			player.triggerAchievement(AchievementManager.worldstaff);
		} else if(stack.isItemEqual(new ItemStack(ToolManager.nstaff))){
			player.triggerAchievement(AchievementManager.netherstaff);
		} else if(stack.isItemEqual(new ItemStack(ToolManager.estaff))){
			player.triggerAchievement(AchievementManager.endstaff);
		} else if(stack.isItemEqual(new ItemStack(ToolManager.estaff))){
			player.triggerAchievement(AchievementManager.endstaff);
		} else if(stack.isItemEqual(new ItemStack(ToolManager.hammer))){
			player.triggerAchievement(AchievementManager.hammer);
		} else if(stack.isItemEqual(new ItemStack(ToolManager.ebs))){
			player.triggerAchievement(AchievementManager.bigsword);
		} else if(stack.isItemEqual(new ItemStack(ToolManager.tac))){
			player.triggerAchievement(AchievementManager.tbow);
		} else if(stack.isItemEqual(new ItemStack(ToolManager.multi))){
			player.triggerAchievement(AchievementManager.wmt);
		} else if(stack.isItemEqual(new ItemStack(ItemManager.crystals, 1, 5))){
			player.triggerAchievement(AchievementManager.exg);
		} else if(stack.isItemEqual(new ItemStack(ItemManager.piece, 1, 5))){
			player.triggerAchievement(AchievementManager.qb);
		} else if(stack.isItemEqual(new ItemStack(ItemManager.nuke))){
			player.triggerAchievement(AchievementManager.nuke);
		} else if(stack.isItemEqual(new ItemStack(ToolManager.cs))){
			player.triggerAchievement(AchievementManager.cs);
		} else if(stack.isItemEqual(new ItemStack(ToolManager.cp))){
			player.triggerAchievement(AchievementManager.cp);
		} else if(stack.isItemEqual(new ItemStack(BlockManager.spawn))){
			player.triggerAchievement(AchievementManager.bs);
		} else if(stack.isItemEqual(new ItemStack(BlockManager.lantern))){
			player.triggerAchievement(AchievementManager.lb);
		} else if(stack.isItemEqual(new ItemStack(ItemManager.crystals, 1, 6))){
			player.triggerAchievement(AchievementManager.ag);
		} else if(stack.isItemEqual(new ItemStack(ToolManager.as))){
			player.triggerAchievement(AchievementManager.scythe);
		} else if(stack.isItemEqual(new ItemStack(ArmorRegistry.cc))){
			player.triggerAchievement(AchievementManager.am);
		}
	}
	
	@SubscribeEvent
	public void onPlayerCraft(ItemCraftedEvent event){
		if(event.crafting.isItemEqual(new ItemStack(BlockManager.elb, 3))){
			event.player.triggerAchievement(AchievementManager.luckyblock);
		} else if(event.crafting.getItem() == ToolManager.wcs){
			event.player.triggerAchievement(AchievementManager.worldSword);
		} else if(event.crafting.getItem() == ToolManager.np){
			event.player.triggerAchievement(AchievementManager.netherpick);
		} else if(event.crafting.getItem() == ToolManager.es){
			event.player.triggerAchievement(AchievementManager.endaxe);
		} else if(event.crafting == new ItemStack(BlockManager.elb)){
			event.player.triggerAchievement(AchievementManager.luckyblock);
		} else if(event.crafting.getItem() == ItemManager.lp){
			event.player.triggerAchievement(AchievementManager.luckypotion);
		} else if(event.crafting.getItem() == ToolManager.ls){
			event.player.triggerAchievement(AchievementManager.luckysword);
		} else if(event.crafting.isItemEqual(new ItemStack(ItemManager.spawn, 1, 0))){
			event.player.triggerAchievement(AchievementManager.spawntable);
		} else if(event.crafting.isItemEqual(new ItemStack(ItemManager.spawn, 1, 1))){
			event.player.triggerAchievement(AchievementManager.lantern);
		} else if(event.crafting.getItem() == ToolManager.ws){
			event.player.triggerAchievement(AchievementManager.worldstaff);
		} else if(event.crafting.getItem() == ToolManager.nstaff){
			event.player.triggerAchievement(AchievementManager.netherstaff);
		} else if(event.crafting.getItem() == ToolManager.estaff){
			event.player.triggerAchievement(AchievementManager.endstaff);
		} else if(event.crafting.getItem() == ToolManager.lp){
			event.player.triggerAchievement(AchievementManager.lightpick);
		} else if(event.crafting.getItem() == ToolManager.icb){
			event.player.triggerAchievement(AchievementManager.crossbow);
		} else if(event.crafting.getItem() == ToolManager.ebs){
			event.player.triggerAchievement(AchievementManager.bigsword);
		} else if(event.crafting.getItem() == ToolManager.hammer){
			event.player.triggerAchievement(AchievementManager.hammer);
		} else if(event.crafting.getItem() == ToolManager.tac){
			event.player.triggerAchievement(AchievementManager.tbow);
		} else if(event.crafting.getItem() == ToolManager.multi){
			event.player.triggerAchievement(AchievementManager.wmt);
		} else if(event.crafting.isItemEqual(new ItemStack(ItemManager.piece, 1, 4))){
			event.player.triggerAchievement(AchievementManager.tb);
		} else if(event.crafting.isItemEqual(new ItemStack(ItemManager.piece, 1, 5))){
			event.player.triggerAchievement(AchievementManager.qb);
		} else if(event.crafting.getItem() == ArmorRegistry.ec){
			event.player.triggerAchievement(AchievementManager.echest);
		} else if(event.crafting.getItem() == ItemManager.nuke){
			event.player.triggerAchievement(AchievementManager.nuke);
		} else if(event.crafting.getItem() == ToolManager.as){
			event.player.triggerAchievement(AchievementManager.scythe);
		} else if(event.crafting.getItem() == ArmorRegistry.cc){
			event.player.triggerAchievement(AchievementManager.am);
		}
	}
	
	
	@SubscribeEvent
	public void onBlockHarvest(HarvestDropsEvent event){
		// getting shards from stone and coal
		Random rand = event.world.rand;
		Block minedBlock = event.state.getBlock();
		
		if(Block.isEqualTo(minedBlock, Blocks.stone) || Block.isEqualTo(minedBlock, Blocks.coal_ore)){
			if(rand.nextInt(6) == 0){
				event.drops.add(new ItemStack(ItemManager.piece, 3, 2));
			} else if(rand.nextInt(10) ==  1){
					event.drops.add(new ItemStack(ItemManager.piece, 3, 0));
				} else if(rand.nextInt(10) == 0) {
					event.drops.add(new ItemStack(ItemManager.piece, 3, 1));
				}
			// get explosive gems from sand
			} else if(Block.isEqualTo(minedBlock, Blocks.sand)){
				if(rand.nextInt(3) == 0){
					event.drops.add(new ItemStack(ItemManager.crystals, 1, 5));
				}
			}
		
		// drop cloud apples from leaves
		if(Block.isEqualTo(minedBlock, Blocks.leaves) || Block.isEqualTo(minedBlock, Blocks.leaves2)){
			if(rand.nextInt(6) == 0){
				event.drops.add(new ItemStack(ItemManager.cb));
			}
		}
		}
	// for the explosive armor to give FIRE resistance while moving
	@SubscribeEvent
	public void giveFireResistance(ChunkWatchEvent event){
		boolean fullSuit = true;
		for(int i = 0; i < 4; i++){
			if(event.player.getCurrentArmor(i) == null){
				fullSuit = false;
				event.player.removePotionEffect(Potion.fireResistance.id);
				return;
			} else if(!(event.player.getCurrentArmor(i).getItem() instanceof ExplodeHelm || event.player.getCurrentArmor(i).getItem() instanceof ExplodeChest ||
					event.player.getCurrentArmor(i).getItem() instanceof ExplodeLegs || event.player.getCurrentArmor(i).getItem() instanceof ExplodeBoots)){
				fullSuit = false;
				event.player.removePotionEffect(Potion.fireResistance.id);
			}
		}
		if(fullSuit){
			event.player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 100, 0, true, false));
		}
	}
	
	// cloud cape makes you fly
	@SubscribeEvent
	public void flyEvent(PlayerTickEvent event){
		EntityPlayer p = event.player;
		if(p.worldObj.isRemote && p.getCurrentArmor(2) != null){
			if(p.getCurrentArmor(2).getItem() instanceof CloudCape){
				if (Keyboard.isKeyDown(Keyboard.KEY_SPACE) &&
				   !Minecraft.getMinecraft().ingameGUI.getChatGUI().getChatOpen() && 
				    Minecraft.getMinecraft().currentScreen == null) {
					if (p.motionY < 0.0D && p.isSneaking() == false) {
						p.motionY /= 1.1499999761581421D;
						p.motionY /= 1.1499999761581421D;
						p.motionY /= 1.1499999761581421d;
				}
			}
		}
	}
	
	}
	
}
	
	

	

