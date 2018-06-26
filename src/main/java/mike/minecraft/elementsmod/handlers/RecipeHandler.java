package mike.minecraft.elementsmod.handlers;

import mike.minecraft.elementsmod.armor.ArmorRegistry;
import mike.minecraft.elementsmod.blocks.BlockManager;
import mike.minecraft.elementsmod.items.ItemManager;
import mike.minecraft.elementsmod.tools.ToolManager;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeHandler {
	
	public static void registerRecipies(){
		ItemStack light = new ItemStack(ToolManager.lp);
		light.addEnchantment(Enchantment.silkTouch, 1);
		ItemStack nc = new ItemStack(ItemManager.crystals, 1, 1);
		ItemStack ec = new ItemStack(ItemManager.crystals, 1, 2);
		ItemStack lc = new ItemStack(ItemManager.crystals, 1, 3);
		ItemStack luc = new ItemStack(ItemManager.crystals, 1, 4);
		ItemStack eg = new ItemStack(ItemManager.crystals, 1, 5);
		ItemStack ac = new ItemStack(ItemManager.crystals, 1, 6);
		ItemStack eh = new ItemStack(ArmorRegistry.eh);
		eh.addEnchantment(Enchantment.blastProtection, 2);
		ItemStack exc = new ItemStack(ArmorRegistry.ec);
		exc.addEnchantment(Enchantment.blastProtection, 2);
		ItemStack el = new ItemStack(ArmorRegistry.el);
		el.addEnchantment(Enchantment.blastProtection, 2);
		ItemStack eb = new ItemStack(ArmorRegistry.eb);
		eb.addEnchantment(Enchantment.blastProtection, 2);
		
		// all of our crafting recipies and smelting recipies
		GameRegistry.addRecipe(new ItemStack(Items.gold_ingot), new Object[]{
				"GGG", "GGG", "GGG", 'G', new ItemStack(ItemManager.piece, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(Items.diamond), new Object[]{
				"DDD", "DDD", "DDD", 'D', new ItemStack(ItemManager.piece, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(Items.emerald), new Object[]{
		"EEE", "EEE", "EEE", 'E', new ItemStack(ItemManager.piece, 1, 1)});
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.iron), Items.stick, Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(ArmorRegistry.nb), new Object[]{
				" N ", "N N", " L ", 'N', nc,
				'L', Items.leather_boots});
		GameRegistry.addRecipe(new ItemStack(ItemManager.flame, 5), new Object[]{
				" I ", "INI", " I ", 'I', Items.iron_ingot, 'N', 
				nc});
		GameRegistry.addRecipe(new ItemStack(ToolManager.wcs), new Object[]{
				" W ", " W ", " I ", 'I', ItemManager.iron, 'W', 
				new ItemStack(ItemManager.crystals, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(ToolManager.np), new Object[]{
				"NNN", " I ", " I ", 'I', ItemManager.iron, 'N', 
				nc});
		GameRegistry.addRecipe(light, new Object[]{
				"GGG", " I ", " I ", 'I', ItemManager.iron, 'G', 
				lc
		});
		GameRegistry.addRecipe(new ItemStack(ToolManager.ep), new Object[]{
				"GGG", "EEE", " I ", 'E', eg, 'I', ItemManager.iron, 'G', Items.gunpowder});
		GameRegistry.addRecipe(new ItemStack(ToolManager.es), new Object[]{
				"EE ", "EI ", " I ", 'I', ItemManager.iron, 'E', 
				ec});
		GameRegistry.addRecipe(new ItemStack(BlockManager.elb), new Object[]{
				" L ", "LDL", " L ", 'D', Blocks.dropper, 'L', 
				luc
		});
		GameRegistry.addRecipe(new ItemStack(ItemManager.lp), new Object[]{
				"LLL", " L ", " G ", 'G', Items.glass_bottle, 'L', 
				luc
		});
		GameRegistry.addRecipe(new ItemStack(ToolManager.ls), new Object[]{
				" L ", " L ", " I ", 'I', ItemManager.iron, 'L',
				luc
		});
		GameRegistry.addRecipe(new ItemStack(ItemManager.spawn, 1), new Object[]{
				"WNW", "LBL", "WNW", 'B', Items.book, 'W', ItemManager.crystals,
				'N', nc, 'L', lc
		});
		GameRegistry.addRecipe(new ItemStack(ItemManager.spawn, 1, 1), new Object[]{
				"ILI", "LTL", "ILI", 'I', Blocks.iron_bars, 'T', Blocks.torch, 'L', lc});
		GameRegistry.addShapelessRecipe(new ItemStack(BlockManager.leb), 
				BlockManager.elb, Blocks.gold_block, Blocks.gold_block, Blocks.gold_block);
		GameRegistry.addShapelessRecipe(new ItemStack(BlockManager.leb), 
				BlockManager.elb, Blocks.emerald_block, Blocks.emerald_block, Blocks.emerald_block);
		GameRegistry.addShapelessRecipe(new ItemStack(BlockManager.leb), 
				BlockManager.elb, Blocks.diamond_block, Blocks.diamond_block, Blocks.diamond_block);
		GameRegistry.addShapelessRecipe(new ItemStack(BlockManager.ub), 
				BlockManager.elb, Items.potato, Items.potato, Items.potato);
		GameRegistry.addShapelessRecipe(new ItemStack(BlockManager.ub), 
				BlockManager.elb, new ItemStack(Items.fish, 1, 3), new ItemStack(Items.fish, 1, 3),
				new ItemStack(Items.fish, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(BlockManager.ub), 
				BlockManager.elb, Items.rotten_flesh, Items.rotten_flesh, Items.rotten_flesh);
		GameRegistry.addRecipe(new ItemStack(ToolManager.ws), new Object[]{
				" WW", " SW", "S W", 'S', Items.stick, 'W', 
				new ItemStack(ItemManager.crystals)});
		GameRegistry.addRecipe(new ItemStack(ToolManager.nstaff), new Object[]{
				" WW", " FW", "S W", 'S', Items.stick, 'W', nc, 'F', Items.flint_and_steel});
		GameRegistry.addRecipe(new ItemStack(ToolManager.estaff), new Object[]{
				" WW", " EW", "S W", 'S', Items.stick, 'W', 
				ec, 'E', Items.ender_pearl});
		GameRegistry.addRecipe(new ItemStack(ItemManager.mana, 5), new Object[]{
				" W ", "WDW", " W ", 'W', ItemManager.crystals, 'D', Blocks.dirt});
		GameRegistry.addRecipe(new ItemStack(ItemManager.mana, 10, 1), new Object[]{
				" C ", "CNC", " C ", 'C', nc, 
				'N', Blocks.netherrack});
		GameRegistry.addRecipe(new ItemStack(ItemManager.mana, 10, 2), new Object[]{
				" C ", "CNC", " C ", 'C', ec, 
				'N', Blocks.end_stone});
		GameRegistry.addRecipe(new ItemStack(ItemManager.dn), new Object[]{
				" L ", "LCL", " L ", 'L', lc,
				'C', Items.clock});
		GameRegistry.addRecipe(new ItemStack(ToolManager.ebs), new Object[]{
				"NWE", "NWE", "NSE", 'W', ItemManager.crystals, 'N', nc,
				'E', ec, 'S', ItemManager.iron});
		GameRegistry.addRecipe(new ItemStack(ToolManager.hammer), new Object[]{
				"WEN", "NDC", "NIN", 'W', ItemManager.crystals, 'E', Blocks.emerald_block,
				'N', ec, 'D', Blocks.diamond_block, 'I', ItemManager.iron, 'C', nc});
		GameRegistry.addRecipe(new ItemStack(ToolManager.icb), new Object[]{
				" IS", "IAS", " IS", 'I', ItemManager.iron, 'S', Items.string,
				'A', Items.arrow});
		GameRegistry.addRecipe(new ItemStack(ToolManager.tac), new Object[]{
				" DE", "GCE", " DE", 'D', Items.diamond, 'E', Items.emerald,
				'G', Items.gold_ingot, 'C', ToolManager.icb});
		GameRegistry.addRecipe(new ItemStack(ItemManager.boss, 1, 5), new Object[]{
				" W ", "GGG", " W ", 'W', Items.water_bucket, 'G', Items.gunpowder});
		GameRegistry.addRecipe(new ItemStack(ItemManager.boss, 1, 6), new Object[]{
				" G ", "GSG", " G ", 'G', Items.gold_ingot, 'S', Items.slime_ball});
		GameRegistry.addShapelessRecipe(new ItemStack(BlockManager.elb), 
				BlockManager.leb, Items.potato, Items.potato, Items.potato);
		GameRegistry.addShapelessRecipe(new ItemStack(BlockManager.elb), 
				BlockManager.leb, new ItemStack(Items.fish, 1, 3), new ItemStack(Items.fish, 1, 3),
				new ItemStack(Items.fish, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(BlockManager.elb), 
				BlockManager.leb, Items.rotten_flesh, Items.rotten_flesh, Items.rotten_flesh);
		GameRegistry.addShapelessRecipe(new ItemStack(BlockManager.elb), 
				BlockManager.ub, Items.diamond, Items.diamond, Items.diamond);
		GameRegistry.addShapelessRecipe(new ItemStack(BlockManager.elb),
				BlockManager.ub, Items.emerald, Items.emerald, Items.emerald);
		GameRegistry.addShapelessRecipe(new ItemStack(BlockManager.elb), 
				BlockManager.ub, Blocks.gold_block, Blocks.gold_block, Blocks.gold_block);
		GameRegistry.addShapelessRecipe(new ItemStack(BlockManager.leb), 
				BlockManager.elb, Items.diamond, Items.diamond, Items.diamond);
		GameRegistry.addShapelessRecipe(new ItemStack(BlockManager.leb),
				BlockManager.elb, Items.emerald, Items.emerald, Items.emerald);
		GameRegistry.addShapelessRecipe(new ItemStack(BlockManager.leb), 
				BlockManager.elb, Blocks.gold_block, Blocks.gold_block, Blocks.gold_block);
		GameRegistry.addShapelessRecipe(new ItemStack(BlockManager.ub), 
				BlockManager.elb, Items.potato, Items.potato, Items.potato);
		GameRegistry.addShapelessRecipe(new ItemStack(BlockManager.ub), 
				BlockManager.elb, new ItemStack(Items.fish, 1, 3), new ItemStack(Items.fish, 1, 3),
				new ItemStack(Items.fish, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(BlockManager.ub), 
				BlockManager.elb, Items.rotten_flesh, Items.rotten_flesh, Items.rotten_flesh);
		GameRegistry.addRecipe(new ItemStack(ArmorRegistry.eHelm), new Object[]{
				"EDE", "W W", "   ", 'W', ItemManager.crystals, 'E', ec, 'D',
				Items.diamond});
		GameRegistry.addRecipe(new ItemStack(ArmorRegistry.eChest), new Object[]{
				"E E", "ENE", "WWW", 'W', ItemManager.crystals, 'E', ec, 'N', nc});
		GameRegistry.addRecipe(new ItemStack(ArmorRegistry.eLegs), new Object[]{
				"DID", "W N", "W N", 'N', nc, 'W', ItemManager.crystals, 'D',
				Items.diamond, 'I', Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(ArmorRegistry.eBoots), new Object[]{
				"   ", "W W", "N N", 'W', ItemManager.crystals, 'N', nc});
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.lep), 
				ItemManager.lp, Items.diamond, Items.diamond, Items.diamond);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.lep), 
				ItemManager.lp, Items.emerald, Items.emerald, Items.emerald);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.lep), 
				ItemManager.lp, Blocks.iron_block, Blocks.iron_block, Blocks.iron_block);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.lp), 
				ItemManager.up, Items.diamond, Items.diamond, Items.diamond);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.lp), 
				ItemManager.up, Items.emerald, Items.emerald, Items.emerald);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.lp), 
				ItemManager.up, Items.iron_ingot, Items.iron_ingot, Items.iron_ingot);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.up), 
				ItemManager.lp, Items.rotten_flesh, Items.rotten_flesh, Items.rotten_flesh);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.up), 
				ItemManager.lp, Items.bone, Items.bone, Items.bone);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.up), 
				ItemManager.lp, Items.gunpowder, Items.gunpowder, Items.gunpowder);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.lp), 
				ItemManager.lep, Items.rotten_flesh, Items.rotten_flesh, Items.rotten_flesh);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.lp), 
				ItemManager.lep, Items.bone, Items.bone, Items.bone);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.lp), 
				ItemManager.lep, Items.gunpowder, Items.gunpowder, Items.gunpowder);
		ItemStack ss = new ItemStack(ToolManager.is);
		GameRegistry.addRecipe(new ItemStack(ToolManager.is), new Object[]{
				"WIW", "III", "WIW", 'W', Blocks.planks, 'I', Items.iron_ingot});
		ss.addEnchantment(Enchantment.sharpness, 1);
		GameRegistry.addShapelessRecipe(ss, ToolManager.is, Items.flint, Items.iron_ingot,
				Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(ToolManager.multi), new Object[]{
				"WWW", "WW ", " S ", 'W', ItemManager.crystals, 'S', ItemManager.iron});
		GameRegistry.addRecipe(new ItemStack(ItemManager.meal), new Object[]{
				" N ", "NBN", " N ", 'N', Blocks.netherrack, 'B', new ItemStack(Items.dye, 1, 15)});
		GameRegistry.addRecipe(new ItemStack(ItemManager.pgw, 4), new Object[]{
				" S ", "EWE", "EEE", 'S', Items.spider_eye, 'W', Items.water_bucket, 
				'E', eg});
		GameRegistry.addRecipe(new ItemStack(ItemManager.pgh, 4), new Object[]{
				"GSG", "EWE", "EEE", 'S', Items.spider_eye, 'W', Items.water_bucket, 
				'E', eg, 'G', Items.gold_nugget});
		GameRegistry.addRecipe(new ItemStack(ItemManager.piece, 3, 3), new Object[]{
				"ESF", "ECE", "EEE", 'E', eg, 'C', Items.clock, 'S', Items.stick,
				'F', Items.flint_and_steel});
		GameRegistry.addRecipe(new ItemStack(ItemManager.piece, 3, 4), new Object[]{
				" S ", "EFE", "EEE", 'E', eg, 'S', Items.stick, 'F', Items.flint_and_steel
		});
		GameRegistry.addRecipe(eh, new Object[]{"EEE", "E E", "   ", 'E', eg});
		GameRegistry.addRecipe(exc, new Object[]{"E E", "EEE", "EEE", 'E', eg});
		GameRegistry.addRecipe(el, new Object[]{"TET", "E E", "E E", 'E', eg, 'T', Blocks.tnt});
		GameRegistry.addRecipe(eb, new Object[]{"   ", "E E", "E E", 'E', eg});
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.cd, 5), new Object[]{
				Items.sugar, new ItemStack(Items.dye, 1, 1), Items.sugar, new ItemStack(Items.dye, 1, 15)});
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.cd, 5, 1), new Object[]{
				new ItemStack(Items.dye, 1, 3), new ItemStack(Items.dye, 1, 3), Items.milk_bucket
		});
		GameRegistry.addRecipe(new ItemStack(ItemManager.cd, 8, 2), new Object[]{
				"SSS", "SSS", "SSS", 'S', Items.sugar});
		GameRegistry.addRecipe(new ItemStack(ItemManager.cd, 5, 3), new Object[]{
				"SSS", "RWB", " S ", 'W', Items.water_bucket, 'S', Items.sugar, 
				'R', new ItemStack(Items.dye, 1, 1), 'B', new ItemStack(Items.dye, 1, 4)});
		GameRegistry.addRecipe(new ItemStack(ItemManager.cd, 5, 4), new Object[]{
				" P ", "SCS", " P ", 'P', new ItemStack(Items.dye, 1, 5), 'S', Items.sugar,
				'C', Items.reeds});
		GameRegistry.addRecipe(new ItemStack(ItemManager.nuke), new Object[]{
				"TTT", "ETE", "EEE", 'E', eg, 'T', Blocks.tnt});
		GameRegistry.addRecipe(new ItemStack(ToolManager.as), new Object[]{
				"AA ", " AA", "  I", 'A', ac, 'I', ItemManager.iron});
		GameRegistry.addRecipe(new ItemStack(ItemManager.cb, 5), new Object[]{
				" A ", "APA", " A ", 'A', ac, 'P', Items.apple});
		GameRegistry.addRecipe(new ItemStack(ArmorRegistry.cc), new Object[]{
				"F F", "ADA", "SAS", 'S', Items.string, 'D', Items.diamond,
				'F', Items.feather, 'A', ac});
		GameRegistry.addSmelting(new ItemStack(ItemManager.piece, 1, 6), new ItemStack(Items.coal, 1, 1), 1.2f);
		GameRegistry.addRecipe(new ItemStack(ItemManager.portal), new Object[]{
				"WOW", "OLO", "WLW", 'W', new ItemStack(Blocks.stained_hardened_clay),
				'O', Blocks.obsidian, 'L', Items.lava_bucket});
	}

}
