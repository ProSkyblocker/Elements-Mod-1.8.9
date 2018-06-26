package mike.minecraft.elementsmod.util;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import mike.minecraft.elementsmod.armor.ArmorRegistry;
import mike.minecraft.elementsmod.blocks.BlockManager;
import mike.minecraft.elementsmod.entity.EntityAttackGiantZombie;
import mike.minecraft.elementsmod.entity.EntityRandomSlime;
import mike.minecraft.elementsmod.gen.TrapA;
import mike.minecraft.elementsmod.gen.TrapB;
import mike.minecraft.elementsmod.gen.TrapC;
import mike.minecraft.elementsmod.items.BossSpawn;
import mike.minecraft.elementsmod.items.ItemManager;
import mike.minecraft.elementsmod.throwables.ExStarThrowable;
import mike.minecraft.elementsmod.throwables.EntityNuke;
import mike.minecraft.elementsmod.tools.ToolManager;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class LuckyBlockItems {
	public String[] ls = {"May fortune smile upon you one day", "Your death is incoming",
			"Your fate is undecidable", "Good luck...", "You will someday have great strength."};

	public void chooseSituation(World world, BlockPos pos){
		int number = world.rand.nextInt(101);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		EntityPlayer p = this.getPlayer(world);
		
		System.out.println(number);
		
		switch(number){
		case 0:
			world.setBlockState(pos.west(), Blocks.gold_block.getDefaultState());
			for(int i = 1; i < 5; i++){
				world.setBlockState(pos.west().up(i), Blocks.gold_block.getDefaultState());
			}
			break;
		case 1:
			EntityLightningBolt bolt = new EntityLightningBolt(world, x, y, z - 1);
			world.spawnEntityInWorld(bolt);
			break;
		case 2:
			for(int i = 0; i < 5; i++){
				ItemStack ender = new ItemStack(Blocks.end_portal_frame, 1);
				ender.setStackDisplayName("Challenge Games Loot!");
				EntityItem enEnder = new EntityItem(world, x, y + i, z, ender);
				world.spawnEntityInWorld(enEnder);
			}
		break;
		case 3:
			int meta = this.getMetaForPotion(world.rand);
			for(int i = 0; i < 2; i++){
				ItemStack tonic = new ItemStack(Items.potionitem, 1, meta);
				tonic.setStackDisplayName(EnumChatFormatting.BLUE + "Tonic");
				EntityItem enTonic = new EntityItem(world, x, y + i, z, tonic);
				world.spawnEntityInWorld(enTonic);
			}
			break;
		case 4:
			ItemStack bush = new ItemStack(ToolManager.ls);
			EntityItem enBush = new EntityItem(world, x, y, z, bush);
			world.spawnEntityInWorld(enBush);
			
			break;
		case 5:
			for(int i = 0; i < 4; i++){
				EntityGhast g = new EntityGhast(world);
				g.setPosition(x + i, y, z);
				g.setCustomNameTag("Ghastly Ghast");
				world.spawnEntityInWorld(g);
			}
			break;
		case 6:
			ItemStack pickaxe = new ItemStack(Items.stone_pickaxe);
			pickaxe.addEnchantment(Enchantment.silkTouch, 1);
			pickaxe.addEnchantment(Enchantment.efficiency, 3);
			pickaxe.setStackDisplayName(EnumChatFormatting.BOLD + "Pick the Axe!");
			EntityItem enPick = new EntityItem(world, x, y, z, pickaxe);
			world.spawnEntityInWorld(enPick);
			break;
		case 7:
			break;
		case 8:
			world.newExplosion(null, x, y, z, 5F, true, true);
			break;
		case 9:
			EntityAttackGiantZombie eagz = new EntityAttackGiantZombie(world);
			eagz.setPosition(x, y, z);
			eagz.setCustomNameTag(EnumChatFormatting.RED + "Jen's Angry Mom");
			world.spawnEntityInWorld(eagz);
			break;
		case 10:
			p.attackEntityFrom(DamageSource.magic, p.getMaxHealth() / 2);
			p.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.BLUE + "NINJA!"));
			break;
		case 11:
			if(world.rand.nextInt(3) == 0){
			ItemStack lucky = new ItemStack(ToolManager.wcs);
			lucky.addEnchantment(Enchantment.sharpness, 3);
			lucky.addEnchantment(Enchantment.fireAspect, 1);
			lucky.addEnchantment(Enchantment.knockback, 3);
			lucky.setStackDisplayName(EnumChatFormatting.GOLD +"The Hero's Sword");
			EntityItem enLuck = new EntityItem(world, x, y, z, lucky);
			world.spawnEntityInWorld(enLuck);
			}
			break;
		case 12:
			p.addChatComponentMessage(new ChatComponentText("JUMP!"));
			p.addPotionEffect(new PotionEffect(Potion.jump.id, 1200, 100));
			break;
		case 13:
			ItemStack shirt = new ItemStack(Items.leather_chestplate);
			
			shirt.setStackDisplayName(EnumChatFormatting.DARK_AQUA + "Bulky Shirt");
			shirt.addEnchantment(Enchantment.unbreaking, world.rand.nextInt(5));
			shirt.addEnchantment(Enchantment.protection, world.rand.nextInt(5));
			shirt.addEnchantment(Enchantment.projectileProtection, world.rand.nextInt(5));
			shirt.addEnchantment(Enchantment.thorns, world.rand.nextInt(5));
			shirt.addEnchantment(Enchantment.blastProtection, world.rand.nextInt(5));
			
			ItemArmor chestplate = (ItemArmor) shirt.getItem();
			chestplate.setColor(shirt, getColorClothingHex(world.rand));
			
			EntityItem enShirt = new EntityItem(world, x, y, z, shirt);
			world.spawnEntityInWorld(enShirt);
			break;
		case 14:
			world.setBlockState(pos.west(), Blocks.chest.getDefaultState());
		
			TileEntityChest teChest = (TileEntityChest) world.getTileEntity(pos.west());
			
			teChest.setInventorySlotContents(0, new ItemStack(Blocks.log, 5));
			teChest.setInventorySlotContents(5, new ItemStack(Items.apple, 10));
			teChest.setInventorySlotContents(7, new ItemStack(Items.wooden_pickaxe));
			teChest.setInventorySlotContents(14, new ItemStack(Blocks.cobblestone, 2));
			teChest.setInventorySlotContents(20, new ItemStack(Items.stick, 2));
			break;
		case 15:
			for(int fx = 0; fx < 4; fx++){
				for(int fy = 0; fy < 4; fy++){
					for(int fz = 0; fz < 4; fz++){
						BlockPos build = new BlockPos(x + fx, y + fy, z + fz);
						world.setBlockState(build, Blocks.slime_block.getDefaultState());
					}
				}
			}
			
		
			
			break;
		case 16:
			ItemStack blocky = new ItemStack(BlockManager.elb);
			blocky.clearCustomName();
			blocky.setStackDisplayName(EnumChatFormatting.DARK_PURPLE + "A Blocky Weapon!");
			blocky.addEnchantment(Enchantment.sharpness, 6);
			blocky.addEnchantment(Enchantment.fireAspect, 1);
			blocky.addEnchantment(Enchantment.knockback, 1);
			blocky.addEnchantment(Enchantment.looting, 2);
			EntityItem enBlock = new EntityItem(world, x, y, z, blocky);
			world.spawnEntityInWorld(enBlock);
			break;
		case 17:
			for(int fy = 0; fy < 10; fy++){
				world.setBlockState(pos.east().up(fy), Blocks.dirt.getDefaultState());
			}
			
			world.setBlockState(pos.east().up(4), Blocks.emerald_block.getDefaultState());
			world.setBlockState(pos.east().up(9), Blocks.beacon.getDefaultState());
			world.setBlockState(pos.east().up(6), Blocks.enchanting_table.getDefaultState());
			world.setBlockState(pos.east().up(7), Blocks.diamond_block.getDefaultState());
			world.setBlockState(pos.east().up(1), Blocks.gold_block.getDefaultState());
			world.setBlockState(pos.east().up(2), Blocks.lapis_block.getDefaultState());
			
			break;
		case 18:
			ItemStack gApple = new ItemStack(Items.golden_apple, 2);
			ItemStack gApple2 = new ItemStack(ItemManager.apple, 2);
			for(int i = 0; i < 3; i++){
			EntityItem enGapple = new EntityItem(world, x, y + i, z, gApple);
			EntityItem enGapple2 = new EntityItem(world, x, y + i, z, gApple2);
			world.spawnEntityInWorld(enGapple);
			world.spawnEntityInWorld(enGapple2);
		}
			break;
			
		case 19:
			world.setBlockState(pos.east().down(), Blocks.trapped_chest.getDefaultState());
			
			TileEntityChest trapped = (TileEntityChest) world.getTileEntity(pos.east().down());
			
			ItemStack note = new ItemStack(Items.paper);
			
			note.setStackDisplayName("Did you enjoy reading me?");
			
			trapped.setInventorySlotContents(0, note);
			
			for(int fx = 0; fx < 3; fx++){
				for(int fz = 0; fz < 3; fz++){
					BlockPos tnt = new BlockPos(x + fx, y - 2, z + fz);
					world.setBlockState(tnt, Blocks.tnt.getDefaultState());
					
				}
			}
			
			break;
		case 20:
			EntityZombie zomb = new EntityZombie(world);
			zomb.setPosition(x + 3, y, z);
			zomb.setCustomNameTag("Super Bob!");
			
			ItemStack fireSword = new ItemStack(ToolManager.es);
			fireSword.addEnchantment(Enchantment.fireAspect, 5);
			fireSword.addEnchantment(Enchantment.knockback, 4);
			fireSword.setStackDisplayName("Bob's Lucky Sword");
			
			zomb.setCurrentItemOrArmor(0, fireSword);
			
			
			zomb.setCurrentItemOrArmor(1, new ItemStack(Items.diamond_helmet));
			zomb.setCurrentItemOrArmor(2, new ItemStack(Items.diamond_chestplate));
			
			ItemStack boblegs = new ItemStack(Items.diamond_leggings);
			boblegs.addEnchantment(Enchantment.protection, 2);
			boblegs.addEnchantment(Enchantment.projectileProtection, 2);
			boblegs.addEnchantment(Enchantment.thorns, 1);
			
			
			zomb.setCurrentItemOrArmor(3, boblegs);
			zomb.setCurrentItemOrArmor(4, new ItemStack(Items.diamond_boots));
			
			world.spawnEntityInWorld(zomb);
			break;
		case 21:
			EntityCreeper creep = new EntityCreeper(world);
			creep.setPosition(x + 1, y, z);
			creep.addPotionEffect(new PotionEffect(Potion.invisibility.id, 12000, 3));
			world.spawnEntityInWorld(creep);
			break;
		case 22:
			ItemStack dirt = new ItemStack(Blocks.dirt, 6);
			ItemStack emerald = new ItemStack(Items.emerald, 4);
			
			for(int i = 0; i < 5; i++){
				EntityItem enDirt = new EntityItem(world, x, y + i, z, dirt);
				EntityItem enEm = new EntityItem(world, x, y + i, z, emerald);
				world.spawnEntityInWorld(enDirt);
				world.spawnEntityInWorld(enEm);
			}
			break;
		case 23:
			ItemStack twilight = new ItemStack(Items.nether_star);
			twilight.setStackDisplayName(EnumChatFormatting.LIGHT_PURPLE + "Twilight");
			EntityItem enTwilight = new EntityItem(world, x, y, z, twilight);
			world.spawnEntityInWorld(enTwilight);
			break;
		case 24:
			world.setBlockState(pos.east(), Blocks.chest.getDefaultState());
			TileEntityChest tec = (TileEntityChest) world.getTileEntity(pos.east());
			
			tec.setInventorySlotContents(0, new ItemStack(Items.diamond, 5));
			tec.setInventorySlotContents(5, new ItemStack(Items.golden_apple, 1, 1));
			tec.setInventorySlotContents(10, new ItemStack(Blocks.emerald_block));
			tec.setInventorySlotContents(20, new ItemStack(BlockManager.elb, 5));
			tec.setInventorySlotContents(19, new ItemStack(Items.carrot, 20));
			tec.setInventorySlotContents(7, new ItemStack(ItemManager.apple, 6));
			tec.setInventorySlotContents(6, new ItemStack(ItemManager.apple, 3, 1));
			
			break;
		case 25:
			EntitySkeleton skele = new EntitySkeleton(world);
			skele.setPosition(x + 3, y, z);
			skele.setCustomNameTag("Super Joey!");
			
			ItemStack bow = new ItemStack(Items.bow);
			bow.addEnchantment(Enchantment.flame, 3);
			bow.addEnchantment(Enchantment.knockback, 3);
			bow.addEnchantment(Enchantment.power, 5);
			
			bow.setStackDisplayName("Joey's Lucky Bow");
			
			skele.setCurrentItemOrArmor(0, bow);
			
			skele.setCurrentItemOrArmor(4, new ItemStack(Items.diamond_helmet));
			
			
			ItemStack chest = new ItemStack(Items.diamond_chestplate);
			chest.addEnchantment(Enchantment.protection, 3);
			chest.addEnchantment(Enchantment.blastProtection, 2);
			chest.addEnchantment(Enchantment.thorns, 2);
			
			chest.setStackDisplayName("Joey's Suave Shirt");
			
			skele.setCurrentItemOrArmor(2, chest);
			skele.setCurrentItemOrArmor(3, new ItemStack(Items.diamond_leggings));
			skele.setCurrentItemOrArmor(4, new ItemStack(Items.diamond_boots));
			world.spawnEntityInWorld(skele);
			break;
		case 26:
			EntityZombie babyZomb = new EntityZombie(world);
			babyZomb.setPosition(x + 3, y, z);
			babyZomb.setCustomNameTag("Baby Bob!");
			
			ItemStack worldSword = new ItemStack(ToolManager.wcs);
			worldSword.addEnchantment(Enchantment.fireAspect, 2);
			worldSword.addEnchantment(Enchantment.sharpness, 2);
			worldSword.setStackDisplayName("A Strong Sword");
			
			babyZomb.setCurrentItemOrArmor(0, worldSword);
			
			babyZomb.setCurrentItemOrArmor(1, new ItemStack(Items.diamond_helmet));
			babyZomb.setCurrentItemOrArmor(2, new ItemStack(Items.diamond_chestplate));
			babyZomb.setCurrentItemOrArmor(3, new ItemStack(Items.diamond_leggings));
			babyZomb.setCurrentItemOrArmor(4, new ItemStack(Items.diamond_boots));
			
			babyZomb.setChild(true);
			
			EntityChicken chick = new EntityChicken(world);
			chick.setPosition(x, y, z);
			
			babyZomb.mountEntity(chick);
			
			world.spawnEntityInWorld(chick);
			world.spawnEntityInWorld(babyZomb);
			
			break;
		case 27:
			ItemStack legs = new ItemStack(Items.leather_leggings);
			
			legs.setStackDisplayName(EnumChatFormatting.DARK_GREEN + "Acidified Leggings");
			legs.addEnchantment(Enchantment.unbreaking, world.rand.nextInt(5));
			legs.addEnchantment(Enchantment.protection, world.rand.nextInt(5));
			legs.addEnchantment(Enchantment.thorns, world.rand.nextInt(5));
			legs.addEnchantment(Enchantment.fireProtection, world.rand.nextInt(5));
			
			ItemArmor leggings = (ItemArmor) legs.getItem();
			leggings.setColor(legs, getColorClothingHex(world.rand));
			
			EntityItem enLegs = new EntityItem(world, x, y, z, legs);
			world.spawnEntityInWorld(enLegs);
			break;
		case 28:
			ItemStack helm = new ItemStack(Items.leather_helmet);
			
			helm.setStackDisplayName(EnumChatFormatting.DARK_PURPLE + "Hard Hat");
			helm.addEnchantment(Enchantment.unbreaking, world.rand.nextInt(5));
			helm.addEnchantment(Enchantment.protection, world.rand.nextInt(5));
			helm.addEnchantment(Enchantment.projectileProtection, world.rand.nextInt(5));
			
			ItemArmor helmet = (ItemArmor) helm.getItem();
			helmet.setColor(helm, getColorClothingHex(world.rand));
			
			EntityItem enHelm = new EntityItem(world, x, y, z, helm);
			world.spawnEntityInWorld(enHelm);
			break;
		case 29:
			ItemStack boots = new ItemStack(Items.leather_boots);
			
			boots.setStackDisplayName(EnumChatFormatting.YELLOW + "Metal Boots");
			boots.addEnchantment(Enchantment.unbreaking, world.rand.nextInt(5));
			boots.addEnchantment(Enchantment.protection, world.rand.nextInt(5));
			boots.addEnchantment(Enchantment.projectileProtection, world.rand.nextInt(5));
			boots.addEnchantment(Enchantment.blastProtection, world.rand.nextInt(5));
			boots.addEnchantment(Enchantment.fireProtection, world.rand.nextInt(5));
			
			ItemArmor armorBoots = (ItemArmor) boots.getItem();
			armorBoots.setColor(boots, getColorClothingHex(world.rand));
			
			EntityItem enBoots = new EntityItem(world, x, y, z, boots);
			world.spawnEntityInWorld(enBoots);
			break;
		case 30:
			Random ra = world.rand;
			ItemStack lucky = new ItemStack(Items.potionitem, 1, 8203);
			lucky.setStackDisplayName(EnumChatFormatting.YELLOW + "Hero's Potion");
			ItemPotion potion = (ItemPotion) lucky.getItem();
			List effects = potion.getEffects(8203);
			createLuckyPotionEffects(effects, ra);
			EntityItem enLucky = new EntityItem(world, x, y, z, lucky);
			world.spawnEntityInWorld(enLucky);
			
			break;
		case 32:
			Random rand = world.rand;
			ItemStack unlucky = new ItemStack(Items.potionitem, 1, 16392);
			unlucky.setStackDisplayName(EnumChatFormatting.DARK_GRAY + "Unlucky Potion");
			ItemPotion unPotion = (ItemPotion) unlucky.getItem();
			List bEffects = unPotion.getEffects(16392);
			createUnluckyPotionEffects(bEffects, rand);
			EntityItem enUnlucky = new EntityItem(world, x, y, z, unlucky);
			world.spawnEntityInWorld(enUnlucky);
			
			break;
		case 33:
			ItemStack hoe = new ItemStack(Items.diamond_hoe);
			hoe.setStackDisplayName(EnumChatFormatting.BLUE + "Paulyaulk Hoe");
			hoe.addEnchantment(Enchantment.sharpness, world.rand.nextInt(3));
			hoe.addEnchantment(Enchantment.knockback, world.rand.nextInt(21));
			EntityItem enHoe = new EntityItem(world, x, y, z, hoe);
			world.spawnEntityInWorld(enHoe);
			break;
		case 34:
			ItemStack shield = new ItemStack(ToolManager.is);
			shield.addEnchantment(Enchantment.sharpness, 3);
			shield.setStackDisplayName(EnumChatFormatting.RED + "Spiky Shield");
			EntityItem enIS = new EntityItem(world, x, y, z, shield);
			world.spawnEntityInWorld(enIS);
			break;
		case 35:
			ItemStack lp = new ItemStack(ItemManager.lp, 5);
			EntityItem enLP = new EntityItem(world, x, y, z, lp);
			world.spawnEntityInWorld(enLP);
			break;
		case 36:
			world.setBlockState(pos.west(), Blocks.command_block.getDefaultState());
			world.setBlockState(pos.west().up(), Blocks.light_weighted_pressure_plate.getDefaultState());
			world.setBlockState(pos.west(2), Blocks.redstone_wire.getDefaultState());
			world.setBlockState(pos.west(3), Blocks.command_block.getDefaultState());
			TileEntityCommandBlock tecb = (TileEntityCommandBlock) world.getTileEntity(pos.west());
			TileEntityCommandBlock clear = (TileEntityCommandBlock) world.getTileEntity(pos.west(3));
			tecb.getCommandBlockLogic().setCommand(this.getCommand(world.rand));
			clear.getCommandBlockLogic().setCommand("/setblock ~2 ~ ~ air");
			break;
		case 37:
			EntityZombie ks = new EntityZombie(world);
			ks.setPosition(x + 3, y, z);
			ks.setCustomNameTag("Farmer Joe");
			ItemStack py = new ItemStack(Items.iron_hoe);
			py.setStackDisplayName(EnumChatFormatting.BLUE + "Infected Paulyaulk Hoe");
			py.addEnchantment(Enchantment.sharpness, world.rand.nextInt(6));
			py.addEnchantment(Enchantment.knockback, world.rand.nextInt(6));
			ks.setCurrentItemOrArmor(0, py);
			ks.setCurrentItemOrArmor(1, new ItemStack(Items.golden_helmet));
			ks.setCurrentItemOrArmor(2, new ItemStack(Items.iron_chestplate));
			ItemStack sl = new ItemStack(Items.diamond_leggings);
			sl.addEnchantment(Enchantment.protection, 2);
			sl.addEnchantment(Enchantment.projectileProtection, 2);
			sl.addEnchantment(Enchantment.thorns, 1);
			ks.setCurrentItemOrArmor(3, sl);
			ks.setCurrentItemOrArmor(4, new ItemStack(Items.leather_boots));
			world.spawnEntityInWorld(ks);
			break;
		case 38:
			ItemStack rf = new ItemStack(Items.gold_ingot, 20);
			rf.setStackDisplayName(EnumChatFormatting.GOLD + "GOLD!!!");
			EntityItem enG = new EntityItem(world, x, y, z, rf);
			world.spawnEntityInWorld(enG);
			break;
		case 39:
			for(int fx = 0; fx < 2; fx++){
				for(int fy = 0; fy < 2; fy++){
					for(int fz = 0; fz < 2; fz++){
						world.setBlockState(new BlockPos(x + fx, y + fy, z + fz), Blocks.hay_block.getDefaultState());
					}
				}
			}
			break;
		case 40:
			ItemStack e4 = new ItemStack(BlockManager.elb);
			e4.setStackDisplayName(EnumChatFormatting.RED + "Error 404!");
			EntityItem enE4 = new EntityItem(world, x, y, z, e4);
			world.spawnEntityInWorld(enE4);
			break;
		case 41:
			for(int fx = 0; fx < 2; fx++){
				for(int fy = 0; fy < 2; fy++){
					for(int fz = 0; fz < 2; fz++){
						world.setBlockState(new BlockPos(x + fx, y + fy, z + fz), BlockManager.elb.getDefaultState());
					}
				}
			}
			break;
		case 42:
			ItemStack funny = new ItemStack(Items.fish, 1, 2);
			funny.setStackDisplayName("You found Nemo!!!");
			EntityItem enFunny = new EntityItem(world, x, y, z, funny);
			world.spawnEntityInWorld(enFunny);
			break;
		case 43:
			ItemStack explode = new ItemStack(ToolManager.ep);
			explode.setStackDisplayName(EnumChatFormatting.BOLD + "Explode Me!");
			EntityItem enExplode = new EntityItem(world, x, y, z, explode);
			world.spawnEntityInWorld(enExplode);
			break;
		case 44:
			ItemStack banana = new ItemStack(Items.golden_sword);
			banana.setStackDisplayName(EnumChatFormatting.YELLOW + "Wait, this ain't banana");
			banana.addEnchantment(Enchantment.unbreaking, 3);
			banana.addEnchantment(Enchantment.sharpness, 5);
			banana.addEnchantment(Enchantment.knockback, 2);
			EntityItem enBanana = new EntityItem(world, x, y, z, banana);
			world.spawnEntityInWorld(enBanana);
			break;
		case 45:
			p.addChatComponentMessage(new ChatComponentText("A Teleport Trap!"));
			this.triggerTeleportTrap(world);
			break;
		case 46:
			p.addChatComponentMessage(new ChatComponentText("Never Gonna Give You Up"));
			p.addChatComponentMessage(new ChatComponentText("Never Gonna Let You Down"));
			p.addChatComponentMessage(new ChatComponentText("Never Gonna Run Around And Desert You"));
			p.addChatComponentMessage(new ChatComponentText("Never Gonna Make You Cry"));
			p.addChatComponentMessage(new ChatComponentText("Never Gonna Say Goodbye"));
			p.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.BOLD + "You just got rickrolled!"));
			break;
		case 47:
			for(int fx = 0; fx < 3; fx++){
					for(int fz = 0; fz < 3; fz++){
						EntityBat bats = new EntityBat(world);
						bats.setPosition(x + fx,y,z+ fz);
						EntityTNTPrimed tnt = new EntityTNTPrimed(world);
						tnt.mountEntity(bats);
						world.spawnEntityInWorld(bats);
						world.spawnEntityInWorld(tnt);
						}
			}
			break;
		case 48:
			for(int i = 0; i < 5; i++){
				for(int fz = 0; fz < 5; fz++){
					ItemStack pois = new ItemStack(Items.poisonous_potato);
					pois.setStackDisplayName(EnumChatFormatting.WHITE + "Potato");
					EntityItem enPois = new EntityItem(world, x + i, y + 1, z + fz, pois);
					world.spawnEntityInWorld(enPois);
				}
			}
			break;
		case 49:
			ItemStack night = new ItemStack(Items.potionitem, 1, 123458);
			night.setStackDisplayName(EnumChatFormatting.AQUA + "Night Potion");
			ItemPotion itemnight = (ItemPotion) night.getItem();
			List neffects = itemnight.getEffects(123458);
			neffects.clear();
			neffects.add(new PotionEffect(Potion.blindness.id, 240, 0));
			neffects.add(new PotionEffect(Potion.nightVision.id, 300, 2));
			EntityItem enNight = new EntityItem(world, x, y, z, night);
			world.spawnEntityInWorld(enNight);
			break;
		case 50:
			ItemStack grenade = new ItemStack(ItemManager.exStar, 10);
			EntityItem enGrenade = new EntityItem(world, x, y, z, grenade);
			world.spawnEntityInWorld(enGrenade);
			break;
		case 51:
			for(int fy = 0; fy < 7; fy++){
				ItemStack db = new ItemStack(Items.iron_ingot);
				world.spawnEntityInWorld(new EntityItem(world, x, y + fy, z, db));
			}
			break;
		case 52:
			for(int fx = 0; fx < 5; fx++){
				for(int fy = 0; fy < 20; fy++){
					world.spawnEntityInWorld(new EntitySnowball(world, x + fx , y + fy, z));
				}
			}
			break;
		case 53:
			EntityItem enBow = new EntityItem(world, x, y + 1, z, new ItemStack(ToolManager.icb));
			EntityItem enArrow = new EntityItem(world, x, y + 1, z, new ItemStack(Items.arrow, 20));
			world.spawnEntityInWorld(enBow);
			world.spawnEntityInWorld(enArrow);
			break;
		case 54:
			EntityItem enJuke = new EntityItem(world, x, y + 1, z, new ItemStack(Blocks.jukebox));
			EntityItem en11 = new EntityItem(world, x, y + 1, z, new ItemStack(Items.record_11));
			EntityItem en13 = new EntityItem(world, x, y + 1, z, new ItemStack(Items.record_13));
			EntityItem encat = new EntityItem(world, x, y + 1, z, new ItemStack(Items.record_cat));
			world.spawnEntityInWorld(enJuke);
			world.spawnEntityInWorld(en11);
			world.spawnEntityInWorld(en13);
			world.spawnEntityInWorld(encat);
			break;
		case 55:
			EntityRandomSlime slime = new EntityRandomSlime(world);
			slime.setPositionAndUpdate(x, y, z);
			slime.setSlimeSize(11);
			slime.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20000, 40));
			world.spawnEntityInWorld(slime);
			break;
		case 56:
			ItemStack reverse = new ItemStack(Items.potionitem, 1, 12345434);
			reverse.setStackDisplayName(EnumChatFormatting.OBFUSCATED + "WTH???");
			ItemPotion rip = (ItemPotion) reverse.getItem();
			List re = rip.getEffects(12345434);
			re.clear();
			re.add(new PotionEffect(Potion.heal.id, 400, -5));
			re.add(new PotionEffect(Potion.regeneration.id, 400, -5));
			re.add(new PotionEffect(Potion.weakness.id, 400, -5));
			re.add(new PotionEffect(Potion.resistance.id, 400, -5));
			re.add(new PotionEffect(Potion.damageBoost.id, 400, -5));
			re.add(new PotionEffect(Potion.jump.id, 300, -5));
			EntityItem enReverse = new EntityItem(world, x, y, z, reverse);
			world.spawnEntityInWorld(enReverse);
			break;
		case 57:
			p.addChatComponentMessage(new ChatComponentText("Fortune smiles among all players! Everyone gets regen! :)"));
			Iterator players = world.playerEntities.iterator();	
			while(players.hasNext()){
				Object o = players.next();
				if(o instanceof EntityPlayer){
					EntityPlayer player = (EntityPlayer) o;
					player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 300, 0));
				}
			}
			break;
		case 58:
			//p.addChatComponentMessage(new ChatComponentText("Oh lookee! You're obese " + p.getName() + "!!"));
			//p.addPotionEffect(new PotionEffect(Potion.jump.id, 400, 254));
			break;
		case 59:
			p.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.DARK_GRAY + "EXPLOSIVE STORM!"));
			for(int fx = 0; fx < 3; fx++){
				for(int fy = 0; fy < 2; fy++){
					for(int fz = 0; fz < 3; fz++){
						ExStarThrowable emt = new ExStarThrowable(world, x + fx, y + fy, z + fz);
						world.spawnEntityInWorld(emt);
					}
				}
			}
			break;
		case 60:
			p.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "I'm sorry " + p.getName() + ", I'm afraid I can't do that."));
			break;
		case 61:
			for(int fx = 0; fx < 2; fx++){
				for(int fy = 0; fy < 1; fy++){
					for(int fz = 0; fz < 2; fz++){
						world.setBlockState(new BlockPos(x + fx, y + fy, z + fz), Blocks.diamond_block.getDefaultState());
						world.setBlockState(new BlockPos(x + fx + 1, y + fy + 1, z + fz + 1), BlockManager.fdb.getDefaultState());
					}
				}
			}
			break;
		case 62:
			for(int fx = 0; fx < 2; fx++){
				for(int fy = 0; fy < 2; fy++){
					for(int fz = 0; fz < 2; fz++){
						world.setBlockState(new BlockPos(x + fx, y + fy, z + fz), Blocks.tnt.getStateFromMeta(1));
					}
				}
			}
			break;
		case 63:
			ItemStack book = new ItemStack(Items.book);
			book.setStackDisplayName(ls[new Random().nextInt(ls.length)]);
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, book));
			break;
		case 64:
			ItemStack qeb = new ItemStack(ItemManager.piece, 10, 4);
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, qeb));
			break;
		case 65:
			ItemStack fns = new ItemStack(Items.flint_and_steel);
			fns.setStackDisplayName(EnumChatFormatting.GOLD + "Zippo Elemental");
			fns.addEnchantment(Enchantment.fireAspect, 2);
			fns.addEnchantment(Enchantment.efficiency, 3);
			fns.addEnchantment(Enchantment.sharpness, 3);
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, fns));
			break;
		case 66:
			world.setWorldTime(13333);
			for(int i = 0; i < 5; i++){
				EntitySpider spid = new EntitySpider(world);
				spid.setPosition(x, y + 2, z);
				EntityZombie zombi = new EntityZombie(world);
				zombi.setPosition(x, y + 3,  z);
				zombi.mountEntity(spid);
				world.spawnEntityInWorld(spid);
				world.spawnEntityInWorld(zombi);
			}
			break;
		case 67:
			for(int fx = 0; fx < 2; fx++){
				for(int fy = 0; fy < 2; fy++){
					for(int fz = 0; fz < 2; fz++){
						world.setBlockState(new BlockPos(x + fx, y + fy, z + fz), BlockManager.fdb.getDefaultState());
					}
				}
			}
			break;
		case 68:
			p.addPotionEffect(new PotionEffect(Potion.resistance.id, 300, 6, true, false));
			this.triggerTeleportTrap(world);
			break;
		case 69:
			p.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.YELLOW + "Welp..."));
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(ItemManager.nuke)));
			break;
		case 70:
			if(world.rand.nextInt(3) == 1 || world.rand.nextInt(3) == 2){
				ItemStack one = new ItemStack(ToolManager.cs);
				one.addEnchantment(Enchantment.looting, 30);
				EntityItem enOne = new EntityItem(world, x, y, z, one);
				enOne.setCustomNameTag(EnumChatFormatting.BOLD + "THE ONE-HIT SWORD!!");
				world.spawnEntityInWorld(enOne);
			}
			break;
		case 71:
			for(int fx = 0; fx < 4; fx++){
				for(int fy = 0; fy < 4; fy++){
					for(int fz = 0; fz < 2; fz++){
						world.spawnEntityInWorld(new EntityItem(world, x + fx, y + fy, z + fz, new ItemStack(Items.diamond)));
						world.spawnEntityInWorld(new EntityItem(world, x + fx, y + fy, z + fz, new ItemStack(Items.emerald)));
					}
				}
			}
			break;
		case 72:
			ItemStack smite = new ItemStack(Blocks.tripwire);
			smite.addEnchantment(Enchantment.sharpness, 2);
			smite.addEnchantment(Enchantment.smite, 8);
			smite.addEnchantment(Enchantment.baneOfArthropods, 8);
			smite.addEnchantment(Enchantment.fireAspect, 3);
			smite.setStackDisplayName(EnumChatFormatting.DARK_RED + "Smite Thee!!");
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, smite));
			break;
		case 73:
			EntityRandomSlime slimez = new EntityRandomSlime(world);
			slimez.setPosition(x, y + 2, z);
			slimez.setCustomNameTag("Ride em' ranger!");
			world.spawnEntityInWorld(slimez);
			p.mountEntity(slimez);
			break;
		case 74:
			p.addChatComponentMessage(new ChatComponentText("Statue anyone?"));
			p.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 500, 254));
			break;
		case 75:
			if(world.rand.nextInt(2) == 0){
				ItemStack hamma = new ItemStack(ToolManager.hammer);
				hamma.addEnchantment(Enchantment.sharpness, 2);
				hamma.addEnchantment(Enchantment.fireAspect, 1);
				hamma.addEnchantment(Enchantment.knockback, 2);
				hamma.setStackDisplayName(EnumChatFormatting.AQUA +"The Multi-Colored Killer");
				EntityItem enLuck = new EntityItem(world, x, y + 1, z, hamma);
				world.spawnEntityInWorld(enLuck);
				}
			break;
		case 76:
			if(world.rand.nextInt(3) == 1 || world.rand.nextInt(3) == 2){
				ItemStack one = new ItemStack(ToolManager.cp);
				one.addEnchantment(Enchantment.fortune, 30);
				one.addEnchantment(Enchantment.unbreaking, 2);
				EntityItem enOne = new EntityItem(world, x, y, z, one);
				enOne.setCustomNameTag(EnumChatFormatting.BOLD + "THE FORTUNATE PICKAXE!!");
				world.spawnEntityInWorld(enOne);
			}
			break;
		case 77:
			world.setBlockState(pos.west(), BlockManager.leb.getDefaultState());
			world.setBlockState(pos.east(), BlockManager.ub.getDefaultState());
			p.addChatComponentMessage(new ChatComponentText("One is lucky, one is not."));
			break;
		case 78:
			ItemStack exhelm = new ItemStack(ArmorRegistry.eh);
			ThreadLocalRandom thlor = ThreadLocalRandom.current();
			exhelm.setStackDisplayName(EnumChatFormatting.GRAY + "Exploding Helmet");
			exhelm.addEnchantment(Enchantment.unbreaking, thlor.nextInt(1, 6));
			exhelm.addEnchantment(Enchantment.protection, thlor.nextInt(2, 5));
			exhelm.addEnchantment(Enchantment.projectileProtection, thlor.nextInt(2, 5));
			exhelm.addEnchantment(Enchantment.thorns, thlor.nextInt(2, 5));
			exhelm.addEnchantment(Enchantment.aquaAffinity, thlor.nextInt(2, 5));
			EntityItem enexhelm = new EntityItem(world, x, y + 1, z, exhelm);
			world.spawnEntityInWorld(enexhelm);
			break;
		case 79:
			ItemStack echest = new ItemStack(ArmorRegistry.ec);
			ThreadLocalRandom thrlr = ThreadLocalRandom.current();
			echest.setStackDisplayName(EnumChatFormatting.GRAY + "Exploding Chestplate");
			echest.addEnchantment(Enchantment.unbreaking, thrlr.nextInt(1, 6));
			echest.addEnchantment(Enchantment.protection, thrlr.nextInt(2, 5));
			echest.addEnchantment(Enchantment.projectileProtection, thrlr.nextInt(2, 5));
			echest.addEnchantment(Enchantment.thorns, thrlr.nextInt(2, 5));
			echest.addEnchantment(Enchantment.blastProtection, thrlr.nextInt(2, 5));
			EntityItem enChest = new EntityItem(world, x, y + 1, z, echest);
			world.spawnEntityInWorld(enChest);
			break;
		case 80:
			ItemStack nether = new ItemStack(ToolManager.nstaff);
			nether.setStackDisplayName(EnumChatFormatting.RED + "Fireball Launcher!!!");
			nether.addEnchantment(Enchantment.unbreaking, 2);
			ItemStack mana = new ItemStack(ItemManager.mana, 10, 1);
			world.spawnEntityInWorld(new EntityItem(world, x, y + 1, z, nether));
			world.spawnEntityInWorld(new EntityItem(world, x, y+1,z,mana));
			break;
		case 81:
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(Blocks.ender_chest, 2)));
			break;
		case 82:
			ItemStack exboots = new ItemStack(ArmorRegistry.eb);
			ThreadLocalRandom tblr = ThreadLocalRandom.current();
			
			exboots.setStackDisplayName(EnumChatFormatting.GRAY + "Exploding Boots");
			exboots.addEnchantment(Enchantment.unbreaking, tblr.nextInt(1, 6));
			exboots.addEnchantment(Enchantment.protection, tblr.nextInt(2, 5));
			exboots.addEnchantment(Enchantment.projectileProtection, tblr.nextInt(2, 5));
			exboots.addEnchantment(Enchantment.thorns, tblr.nextInt(2, 5));
			exboots.addEnchantment(Enchantment.featherFalling, tblr.nextInt(2, 5));
			EntityItem enxBoots = new EntityItem(world, x, y + 1, z, exboots);
			world.spawnEntityInWorld(enxBoots);
			break;
		case 83:
			ItemStack exlegs = new ItemStack(ArmorRegistry.el);
			ThreadLocalRandom trl = ThreadLocalRandom.current();
			exlegs.setStackDisplayName(EnumChatFormatting.GRAY + "Exploding Leggings");
			exlegs.addEnchantment(Enchantment.unbreaking, trl.nextInt(1,6));
			exlegs.addEnchantment(Enchantment.protection, trl.nextInt(2, 5));
			exlegs.addEnchantment(Enchantment.thorns, trl.nextInt(2, 4));
			exlegs.addEnchantment(Enchantment.fireProtection, trl.nextInt(2, 5));
			EntityItem enxlegs = new EntityItem(world, x + 1, y, z, exlegs);
			world.spawnEntityInWorld(enxlegs);
			break;
		case 84:
			p.addChatComponentMessage(new ChatComponentText("Row row row your boat"));
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(Items.boat)));
			break;
		case 85:
			world.playSoundAtEntity(p, "fireworks.blast_far1", 0.5f, 0.4F / (world.rand.nextFloat() * 0.4F + 0.8F));
			for(int i = 0; i < 4; i++){
				for(int iy = 0; iy < 2; iy++){
					world.spawnEntityInWorld(new EntityItem(world, x + i, y + iy, z, new ItemStack(ItemManager.crystals)));
					world.spawnEntityInWorld(new EntityItem(world, x + i, y + iy, z, new ItemStack(ItemManager.crystals, 1, 1)));
				}
			}
			break;
		case 86:
			EntityZombie ez = new EntityZombie(world);
			ez.setPositionAndUpdate(x, y, z);
			ez.setCurrentItemOrArmor(0, new ItemStack(ToolManager.ep));
			ez.setCurrentItemOrArmor(1, new ItemStack(ArmorRegistry.eh));
			ez.setCurrentItemOrArmor(2, new ItemStack(ArmorRegistry.ec));
			ez.setCurrentItemOrArmor(3, new ItemStack(ArmorRegistry.el));
			ez.setCurrentItemOrArmor(4, new ItemStack(ArmorRegistry.eb));
			ez.setCustomNameTag(EnumChatFormatting.BLACK + "EXPLOSIVE BOB!!!");
			world.spawnEntityInWorld(ez);
			break;
		case 87:
			p.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GREEN+"CREEPER BOMBARDMENT!"));
			world.setTotalWorldTime(1333);
			for(int i = 0; i < 5; i++){
				for(int iy = 0; iy < 5; iy++){
					for(int iz = 0; iz < 3; iz++){
						EntityCreeper creepa = new EntityCreeper(world);
						creepa.setPosition(x + i, iy + y, iz + z);
						world.spawnEntityInWorld(creepa);
					}
				}
			}
			break;
		case 88:
			p.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "Nether Gardener's Dream!"));
			for(int i = 0; i < 2; i++){
				for(int iy = 0; iy < 5; iy++){
					for(int iz = 0; iz < 2; iz++){
						world.spawnEntityInWorld(new EntityItem(world, x+i, y+iy, z+iz, new ItemStack(ItemManager.meal)));
					}
				}
			}
			break;
		case 89:
			Random r = new Random();
			ItemStack betty = new ItemStack(ToolManager.es);
			betty.setStackDisplayName(EnumChatFormatting.LIGHT_PURPLE + "Betty!");
			betty.addEnchantment(Enchantment.sharpness, r.nextInt(6));
			betty.addEnchantment(Enchantment.knockback, r.nextInt(5));
			betty.addEnchantment(Enchantment.fireAspect, r.nextInt(6));
			betty.addEnchantment(Enchantment.thorns, r.nextInt(25));
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, betty));
			break;
		case 90:
			p.addChatComponentMessage(new ChatComponentText("ZAMBIE APOCOLYPSE!"));
			world.setTotalWorldTime(14000);
			for(int i = 0; i < 5; i++){
				for(int iy = 0; iy < 5; iy++){
					for(int iz = 0; iz < 3; iz++){
						EntityZombie zambie = new EntityZombie(world);
						zambie.setPosition(x + i, iy + y, iz + z);
						world.spawnEntityInWorld(zambie);
					}
				}
			}
			break;
		case 91:
			p.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.AQUA + "Look Up..."));
			TrapA trap = new TrapA(world);
			trap.generate(world, new Random(), pos);
			p.setPositionAndUpdate(x + 2.5, y + 3, z + 2.5);
			break;
		case 92:
			p.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.AQUA + "Look Up..."));
			TrapB trapb = new TrapB(world);
			trapb.generate(world, new Random(), pos);
			p.setPositionAndUpdate(x + 2.5, y + 3, z + 2.5);
			break;
		case 93:
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(BlockManager.brc)));
			break;
		case 94:
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(BlockManager.bsb)));
			break;
		case 95:
			TrapC tc = new TrapC(world);
			tc.generate(world, world.rand, pos);
			p.setPositionAndUpdate(x + 2.5, y + 3, z + 2.5);
			break;
		case 96:
			ItemStack sb = new ItemStack(Items.snowball);
			ItemStack slb = new ItemStack(Items.slime_ball);
			sb.setStackDisplayName(EnumChatFormatting.BLUE + "Ballin'");
			slb.setStackDisplayName(EnumChatFormatting.DARK_GREEN + "Ballin'");
			sb.addEnchantment(Enchantment.silkTouch, world.rand.nextInt(255));
			slb.addEnchantment(Enchantment.efficiency, world.rand.nextInt(255));
			world.spawnEntityInWorld(new EntityItem(world, x, y + 1, z, sb));
			world.spawnEntityInWorld(new EntityItem(world, x, y + 1, z, slb));
			break;
		case 97:
			p.addChatComponentMessage(new ChatComponentText("NUKE!"));
			world.newExplosion(null, x, y, z, 125f, true, true);
			break;
		case 98:
			world.setBlockState(pos.west(), Blocks.chest.getDefaultState());
			TileEntityChest tech = (TileEntityChest) world.getTileEntity(pos.west());
			ItemStack paper = new ItemStack(Items.paper);
			paper.setStackDisplayName("-->");
			tech.setInventorySlotContents(2, new ItemStack(ItemManager.crystals, 1, 4));
			tech.setInventorySlotContents(10, new ItemStack(ItemManager.crystals, 1, 4));
			tech.setInventorySlotContents(12, new ItemStack(ItemManager.crystals, 1, 4));
			tech.setInventorySlotContents(20, new ItemStack(ItemManager.crystals, 1, 4));
			tech.setInventorySlotContents(11, new ItemStack(Blocks.dropper));
			tech.setInventorySlotContents(14, paper);
			tech.setInventorySlotContents(16, new ItemStack(BlockManager.elb));
			break;
		case 99:
			ItemStack desc = new ItemStack(Items.paper);
			desc.setStackDisplayName(EnumChatFormatting.RED + "Build Your Own Nether Wart Kit!");
			p.inventory.addItemStackToInventory(desc);
			p.inventory.addItemStackToInventory(new ItemStack(ItemManager.meal, 5));
			p.inventory.addItemStackToInventory(new ItemStack(Blocks.soul_sand, 20));
			p.inventory.addItemStackToInventory(new ItemStack(Items.nether_wart, 10));
			break;
		case 100:
			ItemStack hund = new ItemStack(Items.emerald);
			hund.setStackDisplayName(EnumChatFormatting.BOLD + "100th Drop Added!");
			hund.addEnchantment(Enchantment.luckOfTheSea, world.rand.nextInt(255));
			hund.addEnchantment(Enchantment.sharpness, world.rand.nextInt(255));
			hund.addEnchantment(Enchantment.power, world.rand.nextInt(255));
			hund.addEnchantment(Enchantment.fireAspect, world.rand.nextInt(255));
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, hund));
			break;
		}
	}
		
	
	
	public void createLuckySituation(World world, BlockPos pos){
		int number = world.rand.nextInt(71);
		EntityPlayer player = this.getPlayer(world);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		System.out.println(number);
		
		switch(number){
		case 0:
			world.setBlockState(pos.west(), Blocks.iron_block.getDefaultState());
			for(int i = 1; i < 5; i++){
				world.setBlockState(pos.west().up(i), Blocks.iron_block.getDefaultState());
			}
			break;
		case 1:
			ItemStack bush = new ItemStack(ToolManager.ls);
			EntityItem enBush = new EntityItem(world, x, y, z, bush);
			world.spawnEntityInWorld(enBush);
			break;
		case 2:
			if(world.rand.nextInt(2) == 0){
				ItemStack lucky = new ItemStack(ToolManager.hammer);
				lucky.addEnchantment(Enchantment.sharpness, 2);
				lucky.addEnchantment(Enchantment.fireAspect, 1);
				lucky.addEnchantment(Enchantment.knockback, 2);
				lucky.setStackDisplayName(EnumChatFormatting.AQUA +"The Multi-Colored Killer");
				EntityItem enLuck = new EntityItem(world, x, y + 1, z, lucky);
				world.spawnEntityInWorld(enLuck);
				}
			break;
		case 3:
			ItemStack shirt = new ItemStack(Items.golden_chestplate);
			ThreadLocalRandom tlr = ThreadLocalRandom.current();
			
			shirt.setStackDisplayName(EnumChatFormatting.YELLOW + "Butter Shirt");
			shirt.addEnchantment(Enchantment.unbreaking, 10);
			shirt.addEnchantment(Enchantment.protection, tlr.nextInt(2, 5));
			shirt.addEnchantment(Enchantment.projectileProtection, tlr.nextInt(2, 5));
			shirt.addEnchantment(Enchantment.thorns, tlr.nextInt(2, 4));
			shirt.addEnchantment(Enchantment.blastProtection, tlr.nextInt(2, 5));
			
			EntityItem enShirt = new EntityItem(world, x, y + 1, z, shirt);
			world.spawnEntityInWorld(enShirt);
			break;
		case 4:
			for(int fy = 0; fy < 10; fy++){
				world.setBlockState(pos.east().up(fy), Blocks.sponge.getDefaultState());
			}
			
			world.setBlockState(pos.east().up(4), Blocks.emerald_block.getDefaultState());
			world.setBlockState(pos.east().up(9), Blocks.beacon.getDefaultState());
			world.setBlockState(pos.east().up(6), Blocks.enchanting_table.getDefaultState());
			world.setBlockState(pos.east().up(7), Blocks.diamond_block.getDefaultState());
			world.setBlockState(pos.east().up(1), Blocks.gold_block.getDefaultState());
			world.setBlockState(pos.east().up(2), Blocks.lapis_block.getDefaultState());
			break;
		case 5:
			ItemStack gApple = new ItemStack(Items.golden_apple, 2, 1);
			ItemStack gApple2 = new ItemStack(ItemManager.apple, 2, 1);
			ItemStack gAppler = new ItemStack(Items.golden_apple, 2);
			ItemStack gAppler2 = new ItemStack(ItemManager.apple, 2);
			for(int i = 0; i < 3; i++){
			EntityItem enGapple = new EntityItem(world, x, y + i, z, gAppler);
			EntityItem enGapple2 = new EntityItem(world, x, y + i, z, gAppler2);
			EntityItem enGapple3 = new EntityItem(world, x, y + i, z, gApple);
			EntityItem enGapple4 = new EntityItem(world, x, y + i, z, gApple2);
			world.spawnEntityInWorld(enGapple);
			world.spawnEntityInWorld(enGapple2);
			world.spawnEntityInWorld(enGapple3);
			world.spawnEntityInWorld(enGapple4);
		}
			break;
		case 6:
			ItemStack twilight = new ItemStack(Items.nether_star);
			twilight.setStackDisplayName(EnumChatFormatting.LIGHT_PURPLE + "Twilight");
			EntityItem enTwilight = new EntityItem(world, x, y + 1, z, twilight);
			world.spawnEntityInWorld(enTwilight);
			break;
		case 7:
			world.setBlockState(pos.east(), Blocks.chest.getDefaultState());
			TileEntityChest tec = (TileEntityChest) world.getTileEntity(pos.east());
			tec.setInventorySlotContents(0, new ItemStack(Items.diamond, 5));
			tec.setInventorySlotContents(5, new ItemStack(Items.golden_apple, 1, 1));
			tec.setInventorySlotContents(10, new ItemStack(Blocks.emerald_block));
			tec.setInventorySlotContents(20, new ItemStack(BlockManager.elb, 5));
			tec.setInventorySlotContents(19, new ItemStack(Items.carrot, 20));
			tec.setInventorySlotContents(7, new ItemStack(ItemManager.apple, 6));
			tec.setInventorySlotContents(6, new ItemStack(ItemManager.apple, 3, 1));
			break;
		case 8:
			ItemStack tonic = new ItemStack(Items.potionitem, 1, 1432);
			tonic.setStackDisplayName(EnumChatFormatting.LIGHT_PURPLE + "Emergency Health Potion");
			List sfx = ((ItemPotion) tonic.getItem()).getEffects(1432);
			sfx.clear();
			sfx.add(new PotionEffect(Potion.heal.id, 200, 255));
			sfx.add(new PotionEffect(Potion.absorption.id, 200, 2));
			sfx.add(new PotionEffect(Potion.regeneration.id, 200, 255));
			sfx.add(new PotionEffect(Potion.confusion.id, 360, 255));
			EntityItem enTonic = new EntityItem(world, x, y + 1, z, tonic);
			world.spawnEntityInWorld(enTonic);
			break;
		case 9:
			ItemStack lup = new ItemStack(ItemManager.lep, 2);
			EntityItem enLup = new EntityItem(world, x, y + 1, z, lup);
			world.spawnEntityInWorld(enLup);
			break;
		case 10:
			Random r = world.rand;
			if(r.nextInt(2) == 0){
			ItemStack lucky = new ItemStack(Items.potionitem, 1, 8203);
			lucky.setStackDisplayName(EnumChatFormatting.YELLOW + "Hero's Potion");
			ItemPotion potion = (ItemPotion) lucky.getItem();
			List effects = potion.getEffects(8203);
			createLuckyPotionEffects(effects, r);
			EntityItem enLucky = new EntityItem(world, x + 1, y, z, lucky);
			world.spawnEntityInWorld(enLucky);
			}
			break;
		case 11:
			for(int fx = 0; fx < 2; fx++){
				for(int fy = 0; fy < 2; fy++){
					for(int fz = 0; fz < 2; fz++){
						world.setBlockState(new BlockPos(x + fx, y + fy, z + fz), Blocks.cake.getDefaultState());
					}
				}
			}
			break;
		case 12:
			world.setBlockState(pos.west(), Blocks.redstone_block.getDefaultState());
			for(int i =1; i < 6; i++){
				world.setBlockState(pos.west().up(i), Blocks.tnt.getDefaultState());
			}
			break;
		case 13:
			ItemStack legs = new ItemStack(ArmorRegistry.el);
			ThreadLocalRandom trl = ThreadLocalRandom.current();
			
			legs.setStackDisplayName(EnumChatFormatting.GRAY + "Exploding Leggings");
			legs.addEnchantment(Enchantment.unbreaking, 10);
			legs.addEnchantment(Enchantment.protection, trl.nextInt(2, 5));
			legs.addEnchantment(Enchantment.thorns, trl.nextInt(2, 4));
			legs.addEnchantment(Enchantment.fireProtection, trl.nextInt(2, 5));
			EntityItem enLegs = new EntityItem(world, x + 1, y, z, legs);
			world.spawnEntityInWorld(enLegs);
			break;
		case 14:
			ItemStack boots = new ItemStack(ArmorRegistry.eb);
			ThreadLocalRandom tblr = ThreadLocalRandom.current();
			
			boots.setStackDisplayName(EnumChatFormatting.GRAY + "Exploding Boots");
			boots.addEnchantment(Enchantment.unbreaking, 10);
			boots.addEnchantment(Enchantment.protection, tblr.nextInt(2, 5));
			boots.addEnchantment(Enchantment.projectileProtection, tblr.nextInt(2, 5));
			boots.addEnchantment(Enchantment.thorns, tblr.nextInt(2, 5));
			boots.addEnchantment(Enchantment.featherFalling, tblr.nextInt(2, 5));
			EntityItem enBoots = new EntityItem(world, x, y + 1, z, boots);
			world.spawnEntityInWorld(enBoots);
			break;
		case 15:
			ItemStack wolf = new ItemStack(ItemManager.boss, 4, 2);
			world.spawnEntityInWorld(new EntityItem(world, x + 1, y, z, wolf));
			break;
		case 16:
			EntitySnowman snowman = new EntitySnowman(world);
			snowman.setPosition(x + 1, y, z);
			snowman.setHealth(800f);
			snowman.setCustomNameTag("The Snowman of Persistance!");
			snowman.setCurrentItemOrArmor(2, new ItemStack(Items.diamond_chestplate));
			world.spawnEntityInWorld(snowman);
			break;
		case 17:
			for(int i = 0; i < 5; i++){
				world.setBlockState(pos.west().up(i), BlockManager.leb.getDefaultState());
			}
			break;
		case 18:
			ItemStack beacon = new ItemStack(Blocks.barrier);
			beacon.setStackDisplayName("Invisible");
			world.spawnEntityInWorld(new EntityItem(world, x + 1, y, z, beacon));
			break;
		case 19:
			break;
		case 20:
			for(int fx = 0; fx < 3; fx++){
				for(int fy = 0; fy < 3; fy++){
					for(int fz = 0; fz < 3; fz++){
						world.setBlockState(new BlockPos(x + fx, y - fy, z + fz), Blocks.water.getDefaultState());
					}
				}
			}
			EntitySquid squid = new EntitySquid(world);
			squid.setPosition(x + 1, y, z);
			squid.setCustomNameTag(EnumChatFormatting.GOLD + "Lucky Squid");
			world.spawnEntityInWorld(squid);
			break;
		case 21:
			ItemStack hunger = new ItemStack(Items.potionitem, 1, 16397);
			hunger.setStackDisplayName(EnumChatFormatting.DARK_GREEN + "Hunger Potion");
			List hsfx = ((ItemPotion) hunger.getItem()).getEffects(16397);
			hsfx.clear();
			hsfx.add(new PotionEffect(Potion.hunger.id, 400, 255));
			EntityItem enHunger = new EntityItem(world, x, y + 1, z, hunger);
			world.spawnEntityInWorld(enHunger);
			break;
		case 22:
			if(world.rand.nextInt(2) == 0){
			ItemStack crossbow = new ItemStack(ToolManager.tac);
			ThreadLocalRandom thlr = ThreadLocalRandom.current();
			crossbow.setStackDisplayName(EnumChatFormatting.BOLD + player.getName() + "'s Lucky Crossbow");
			crossbow.addEnchantment(Enchantment.power, thlr.nextInt(1, 4));
			crossbow.addEnchantment(Enchantment.punch, thlr.nextInt(1, 4));
			crossbow.addEnchantment(Enchantment.flame, 1);
			crossbow.addEnchantment(Enchantment.infinity, 1);
			ItemStack arrow = new ItemStack(Items.arrow);
			world.spawnEntityInWorld(new EntityItem(world, x, y + 1, z, arrow));
			world.spawnEntityInWorld(new EntityItem(world, x, y + 1, z, crossbow));
			}
			break;
		case 23:
			player.addExperienceLevel(5 + world.rand.nextInt(6));
			break;
		case 24:
			Random rand = world.rand;
			ItemStack unlucky = new ItemStack(Items.potionitem, 1, 16392);
			unlucky.setStackDisplayName(EnumChatFormatting.DARK_GRAY + "Unlucky Potion");
			ItemPotion unPotion = (ItemPotion) unlucky.getItem();
			List bEffects = unPotion.getEffects(16392);
			createUnluckyPotionEffects(bEffects, rand);
			EntityItem enUnlucky = new EntityItem(world, x, y, z, unlucky);
			world.spawnEntityInWorld(enUnlucky);
			
			break;
		case 25:
			ItemStack rod = new ItemStack(Items.fishing_rod);
			rod.setStackDisplayName(EnumChatFormatting.BOLD + player.getName() + "'s Lucky Fishing Rod");
			rod.addEnchantment(Enchantment.unbreaking, 3);
			rod.addEnchantment(Enchantment.lure, 3);
			rod.addEnchantment(Enchantment.luckOfTheSea, 3);
			world.spawnEntityInWorld(new EntityItem(world, x, y + 1, z, rod));
			break;
		case 26:
			ItemStack head = new ItemStack(Blocks.skull, 1, 3);
			head.setStackDisplayName(EnumChatFormatting.BOLD + player.getName() + "'s Lucky Head");
			head.addEnchantment(Enchantment.protection, world.rand.nextInt(5));
			head.addEnchantment(Enchantment.projectileProtection, world.rand.nextInt(5));
			head.addEnchantment(Enchantment.blastProtection, world.rand.nextInt(5));
			head.addEnchantment(Enchantment.aquaAffinity, world.rand.nextInt(5));
			head.addEnchantment(Enchantment.fireProtection, world.rand.nextInt(5));
			world.spawnEntityInWorld(new EntityItem(world, x, y + 1, z, head));
		case 27:
			ItemStack puffer = new ItemStack(Items.fish, 5, 3);
			ItemStack dhorse = new ItemStack(Items.diamond_horse_armor, 3);
			ItemStack saddle = new ItemStack(Items.saddle, 3);
			world.spawnEntityInWorld(new EntityItem(world, x, y + 3, z, puffer));
			world.spawnEntityInWorld(new EntityItem(world, x, y + 3, z, saddle));
			world.spawnEntityInWorld(new EntityItem(world, x, y + 3, z, dhorse));
			player.addChatComponentMessage(new ChatComponentText("RARE ITEMS!!"));
			break;
		case 28:
			player.attackEntityFrom(DamageSource.cactus, 0.1f);
			break;
		case 29:
			for(int i = 1; i < 15; i++){
				world.setBlockState(pos.west(), Blocks.wool.getDefaultState());
				world.setBlockState(pos.west().up(i), Blocks.wool.getStateFromMeta(i));
				world.setBlockState(pos.west().up(16), Blocks.lapis_block.getDefaultState());
			}
			break;
		case 30:
			ItemStack nether = new ItemStack(ToolManager.nstaff);
			nether.setStackDisplayName(EnumChatFormatting.RED + "Fireball Launcher!!!");
			nether.addEnchantment(Enchantment.unbreaking, 2);
			ItemStack mana = new ItemStack(ItemManager.mana, 10, 1);
			world.spawnEntityInWorld(new EntityItem(world, x, y + 1, z, nether));
			world.spawnEntityInWorld(new EntityItem(world, x, y+1,z,mana));
			break;
		case 31:
			EntityGhast ghast = new EntityGhast(world);
			ghast.setPosition(x, y + 10, z);
			ghast.setCustomNameTag("The Friendly Ghast?");
			world.spawnEntityInWorld(ghast);
			player.mountEntity(ghast);
			break;
		case 32:
			for(int i = 0; i < 5; i++){
				ItemStack apple = new ItemStack(Items.apple, 2);
				world.spawnEntityInWorld(new EntityItem(world,x + i, y, z, apple));
			}
			break;
		case 33:
			EntityChicken fallin = new EntityChicken(world);
			fallin.setPosition(x, y + 20, z);
			fallin.setCustomNameTag("Free Fallin'");
			world.spawnEntityInWorld(fallin);
			player.mountEntity(fallin);
			break;
		case 34:
			EntitySheep cuteattack = new EntitySheep(world);
			cuteattack.setPosition(x, y + 2, z);
			cuteattack.setCustomNameTag("Cutie Sheep");
			world.spawnEntityInWorld(cuteattack);
			player.mountEntity(cuteattack);
			break;
		case 35:
			ItemStack e4 = new ItemStack(BlockManager.elb);
			e4.setStackDisplayName(EnumChatFormatting.RED + "Error 404!");
			EntityItem enE4 = new EntityItem(world, x, y, z, e4);
			world.spawnEntityInWorld(enE4);
			break;
		case 36:
			player.addChatComponentMessage(new ChatComponentText("Fortune smiles among all players! Everyone gets regen! :)"));
			Iterator players = world.playerEntities.iterator();	
			while(players.hasNext()){
				Object o = players.next();
				if(o instanceof EntityPlayer){
					EntityPlayer p = (EntityPlayer) o;
					player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 300, 0));
				}
			}
			break;
		case 37:
			for(int i = 0; i < 5; i++){
				EntityItem tnt = new EntityItem(world, x, y + i, z, new ItemStack(Blocks.tnt));
				world.spawnEntityInWorld(tnt);
			}
			break;
		case 38:
			for(int i = 0; i < 8; i++){
				EntityItem tnt = new EntityItem(world, x, y + i, z, new ItemStack(ItemManager.cd));
				world.spawnEntityInWorld(tnt);
				EntityItem choco = new EntityItem(world, x, y + i, z, new ItemStack(ItemManager.cd, 1, 1));
				world.spawnEntityInWorld(choco);
				EntityItem c3 = new EntityItem(world, x, y + i, z, new ItemStack(ItemManager.cd, 1, 2));
				world.spawnEntityInWorld(c3);
				EntityItem c4 = new EntityItem(world, x, y + i, z, new ItemStack(ItemManager.cd, 1, 3));
				world.spawnEntityInWorld(c4);
				EntityItem c5 = new EntityItem(world, x, y + i, z, new ItemStack(ItemManager.cd, 1, 4));
				world.spawnEntityInWorld(c5);
			}
			break;
		case 39:
			EntitySlime slimez = new EntitySlime(world);
			slimez.setPosition(x, y + 2, z);
			slimez.setCustomNameTag("Ride em' ranger!");
			world.spawnEntityInWorld(slimez);
			player.mountEntity(slimez);
			break;
		case 40:
			player.addChatComponentMessage(new ChatComponentText("Fortune smiles among all players! Everyone gets resistance! :)"));
			Iterator itplayer = world.playerEntities.iterator();	
			while(itplayer.hasNext()){
				Object o = itplayer.next();
				if(o instanceof EntityPlayer){
					EntityPlayer p = (EntityPlayer) o;
					player.addPotionEffect(new PotionEffect(Potion.resistance.id, 300, 0));
				}
			}
			break;
		case 41:
			ItemStack wi = new ItemStack(Items.book);
			wi.setStackDisplayName(ls[new Random().nextInt(ls.length)]);
			wi.addEnchantment(Enchantment.knockback, 1);
			EntityItem enWI = new EntityItem(world, x, y + 4, z, wi);
			world.spawnEntityInWorld(enWI);
			break;
		case 42:
			for(int fx = 0; fx < 4; fx++){
				   for(int fy = 0; fy < 2; fy++){
					   for(int fz = 0; fz < 1; fz++){
						    EntityPig rab = new EntityPig(world);
						    rab.setCustomNameTag(EnumChatFormatting.LIGHT_PURPLE + "PIG PARTY!!");
							rab.setPosition(x + fx, y + fy, z + fz);
							world.spawnEntityInWorld(rab);
					   }
				   }
			   }
			break;
		case 43:
			  EntityHorse steed = new EntityHorse(world);
			  steed.setPosition(x, y, z);
			  steed.setHorseTamed(true);
			  steed.setHorseSaddled(true);
			  steed.setHorseArmorStack(new ItemStack(Items.diamond_horse_armor));
			  steed.setCustomNameTag(player.getName() + "'s Lucky Horse");
			  world.spawnEntityInWorld(steed);
			break;
		case 44:
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.BLACK + "STONE FOR DAYZ!"));
			for(int i = 0; i < 10; i++){
				for(int fy = 0; fy < 10; fy++){
					for(int fz = 0; fz < 10; fz++){
						world.spawnEntityInWorld(new EntityItem(world, x + i, y + fy, z + fz, new ItemStack(Blocks.stone)));
					}
				}
			}
			break;
		case 45:
			ItemStack better = new ItemStack(Items.wooden_hoe);
			better.setStackDisplayName(EnumChatFormatting.BLUE + "Poor Man's Hoe?");
			better.addEnchantment(Enchantment.unbreaking, 10);
			better.addEnchantment(Enchantment.efficiency, 4);
			better.addEnchantment(Enchantment.fortune, 2);
			better.addEnchantment(Enchantment.silkTouch, 1);
			world.spawnEntityInWorld(new EntityItem(world, x, y + 1, z, better));
			break;
		case 46:
			ItemStack echest = new ItemStack(ArmorRegistry.ec);
			ThreadLocalRandom thrlr = ThreadLocalRandom.current();
			echest.setStackDisplayName(EnumChatFormatting.GRAY + "Exploding Chestplate");
			echest.addEnchantment(Enchantment.unbreaking, 10);
			echest.addEnchantment(Enchantment.protection, thrlr.nextInt(2, 5));
			echest.addEnchantment(Enchantment.projectileProtection, thrlr.nextInt(2, 5));
			echest.addEnchantment(Enchantment.thorns, thrlr.nextInt(2, 5));
			echest.addEnchantment(Enchantment.blastProtection, thrlr.nextInt(2, 5));
			EntityItem enChest = new EntityItem(world, x, y + 1, z, echest);
			world.spawnEntityInWorld(enChest);
			break;
		case 47:
			Random random = world.rand;
			ItemStack ulucky = new ItemStack(Items.potionitem, 1, 16392);
			ulucky.setStackDisplayName(EnumChatFormatting.DARK_PURPLE + "Unlucky Potion");
			ItemPotion enupotion = (ItemPotion) ulucky.getItem();
			List effects = enupotion.getEffects(16392);
			createLuckyPotionEffects(effects, random);
			EntityItem entunlucky = new EntityItem(world, x, y, z, ulucky);
			world.spawnEntityInWorld(entunlucky);
			break;	
		case 48:
			break;
		case 49:
			for(int fx = 0; fx < 3; fx++){
				for(int fz = 0; fz < 4; fz++){
					EntityVillager villager = new EntityVillager(world);
					villager.setPosition(x + fx, y, z + fz);
					villager.setCustomNameTag("Where the village at?");
					world.spawnEntityInWorld(villager);
				}
			}
			break;
		case 50:
			player.addChatComponentMessage(new ChatComponentText("Fortune smiles among all players! Everyone gets night vision! :)"));
			Iterator iplayer = world.playerEntities.iterator();	
			while(iplayer.hasNext()){
				Object o = iplayer.next();
				if(o instanceof EntityPlayer){
					EntityPlayer p = (EntityPlayer) o;
					p.addPotionEffect(new PotionEffect(Potion.nightVision.id, 300, 0));
				}
			}
			break;
		case 51:
			player.addChatComponentMessage(new ChatComponentText("Fortune smiles among all players! Everyone gets a speed bonus! :)"));
			Iterator iteratorp = world.playerEntities.iterator();	
			while(iteratorp.hasNext()){
				Object o = iteratorp.next();
				if(o instanceof EntityPlayer){
					EntityPlayer pl = (EntityPlayer) o;
					pl.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 300, 0));
				}
			}
			break;
		case 52:
			for(int fy = 0; fy < 7; fy++){
				world.spawnEntityInWorld(new EntityItem(world, x, y + fy, z, new ItemStack(Items.speckled_melon)));
			}
			break;
		case 53:
			for(int fy = 0; fy < 10; fy++){
				world.spawnEntityInWorld(new EntityXPOrb(world, x, y + fy, z, 2));
			}
			break;
		case 54:
			ItemStack helm = new ItemStack(ArmorRegistry.eb);
			ThreadLocalRandom thlor = ThreadLocalRandom.current();
			helm.setStackDisplayName(EnumChatFormatting.GRAY + "Exploding Helmet");
			helm.addEnchantment(Enchantment.unbreaking, 10);
			helm.addEnchantment(Enchantment.protection, thlor.nextInt(2, 5));
			helm.addEnchantment(Enchantment.projectileProtection, thlor.nextInt(2, 5));
			helm.addEnchantment(Enchantment.thorns, thlor.nextInt(2, 5));
			helm.addEnchantment(Enchantment.aquaAffinity, thlor.nextInt(2, 5));
			EntityItem enHelm = new EntityItem(world, x, y + 1, z, helm);
			world.spawnEntityInWorld(enHelm);
			break;
		case 55:
			ItemStack hund = new ItemStack(Items.emerald);
			hund.setStackDisplayName(EnumChatFormatting.BOLD + "100th Drop Added!");
			hund.addEnchantment(Enchantment.luckOfTheSea, world.rand.nextInt(255));
			hund.addEnchantment(Enchantment.sharpness, world.rand.nextInt(255));
			hund.addEnchantment(Enchantment.power, world.rand.nextInt(255));
			hund.addEnchantment(Enchantment.fireAspect, world.rand.nextInt(255));
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, hund));
			break;
		case 56:
			ItemStack desc = new ItemStack(Items.paper);
			desc.setStackDisplayName(EnumChatFormatting.RED + "Build Your Own Nether Wart Kit!");
			player.inventory.addItemStackToInventory(desc);
			player.inventory.addItemStackToInventory(new ItemStack(ItemManager.meal, 5));
			player.inventory.addItemStackToInventory(new ItemStack(Blocks.soul_sand, 20));
			player.inventory.addItemStackToInventory(new ItemStack(Items.nether_wart, 10));
			break;
		case 57:
			world.setBlockState(pos.west(), Blocks.chest.getDefaultState());
			TileEntityChest tech = (TileEntityChest) world.getTileEntity(pos.west());
			ItemStack paper = new ItemStack(Items.paper);
			paper.setStackDisplayName("-->");
			tech.setInventorySlotContents(2, new ItemStack(ItemManager.crystals, 1, 4));
			tech.setInventorySlotContents(10, new ItemStack(ItemManager.crystals, 1, 4));
			tech.setInventorySlotContents(12, new ItemStack(ItemManager.crystals, 1, 4));
			tech.setInventorySlotContents(20, new ItemStack(ItemManager.crystals, 1, 4));
			tech.setInventorySlotContents(11, new ItemStack(Blocks.dropper));
			tech.setInventorySlotContents(14, paper);
			tech.setInventorySlotContents(16, new ItemStack(BlockManager.elb));
			break;
		case 58:
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(BlockManager.bsb)));
			break;
		case 59:
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(BlockManager.brc)));
			break;
		case 60:
			Random randome = new Random();
			ItemStack betty = new ItemStack(ToolManager.es);
			betty.setStackDisplayName(EnumChatFormatting.LIGHT_PURPLE + "Betty!");
			betty.addEnchantment(Enchantment.sharpness, randome.nextInt(6));
			betty.addEnchantment(Enchantment.knockback, randome.nextInt(5));
			betty.addEnchantment(Enchantment.fireAspect, randome.nextInt(6));
			betty.addEnchantment(Enchantment.thorns, randome.nextInt(25));
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, betty));
			break;
		case 61:
			player.addChatComponentMessage(new ChatComponentText("[Gold God] Got Gold?"));
			world.spawnEntityInWorld(new EntityItem(world, x, y + 3, z, new ItemStack(Items.gold_ingot, 14)));
			break;
		case 62:
			ItemStack he = new ItemStack(Blocks.pumpkin);
			he.setStackDisplayName(EnumChatFormatting.GOLD + "Halloween Pumpkin");
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, he));
			break;
		case 63:
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.AQUA + "Look Up..."));
			TrapA trap = new TrapA(world);
			trap.generate(world, new Random(), pos);
			player.setPositionAndUpdate(x + 2.5, y + 3, z + 2.5);
			break;
		case 64:
			ItemStack sb = new ItemStack(Items.snowball);
			ItemStack slb = new ItemStack(Items.slime_ball);
			sb.setStackDisplayName(EnumChatFormatting.BLUE + "Ballin'");
			slb.setStackDisplayName(EnumChatFormatting.DARK_GREEN + "Ballin'");
			sb.addEnchantment(Enchantment.silkTouch, world.rand.nextInt(255));
			slb.addEnchantment(Enchantment.efficiency, world.rand.nextInt(255));
			world.spawnEntityInWorld(new EntityItem(world, x, y + 1, z, sb));
			world.spawnEntityInWorld(new EntityItem(world, x, y + 1, z, slb));
			break;
		case 65:
			player.addChatComponentMessage(new ChatComponentText("Peter Piper picked a peck of pickled peppers."));
			ItemStack pepper = new ItemStack(Items.carrot);
			pepper.setStackDisplayName(EnumChatFormatting.WHITE + "Pepper");
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, pepper));
			break;
		case 66:
			world.spawnEntityInWorld(new EntityItem(world, x, y + 2, z, new ItemStack(Items.diamond_helmet)));
			world.spawnEntityInWorld(new EntityItem(world, x, y + 2, z, new ItemStack(Items.golden_chestplate)));
			break;
		case 67:
			world.spawnEntityInWorld(new EntityItem(world, x, y + 2, z, new ItemStack(Items.diamond_sword)));
			world.spawnEntityInWorld(new EntityItem(world, x, y + 2, z, new ItemStack(Items.golden_pickaxe)));
			break;
		case 68:
			ItemStack fp = new ItemStack(Items.bow);
			fp.addEnchantment(Enchantment.punch, 20);
			fp.setStackDisplayName(EnumChatFormatting.RED + "Falcon PUNCH!");
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, fp));
			break;
		case 69:
			player.addChatComponentMessage(new ChatComponentText("Fortune smiles among all players? Everyone gets health boost!"));
			Iterator it = world.playerEntities.iterator();	
			while(it.hasNext()){
				Object o = it.next();
				if(o instanceof EntityPlayer){
					EntityPlayer pl = (EntityPlayer) o;
					pl.addPotionEffect(new PotionEffect(Potion.healthBoost.id, 300, 2));
				}
			}
			break;
		case 70:
			player.addChatComponentMessage(new ChatComponentText("Fortune smiles among all players? Everyone gets 10 diamonds!"));
			Iterator piterator = world.playerEntities.iterator();	
			while(piterator.hasNext()){
				Object o = piterator.next();
				if(o instanceof EntityPlayer){
					EntityPlayer pl = (EntityPlayer) o;
					pl.inventory.addItemStackToInventory(new ItemStack(Items.diamond, 10));
				}
			}
			break;
		
		
		}
		
	}
	
	public void createUnluckySituation(World world, BlockPos pos){
		int number = world.rand.nextInt(68);
		EntityPlayer player = this.getPlayer(world);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		System.out.println(number);
		
		switch(number){
		case 0:
			EntityLightningBolt bolt = new EntityLightningBolt(world, x, y, z - 1);
			world.spawnEntityInWorld(bolt);
			 break;
		case 1:
			for(int i = 0; i < 4; i++){
				EntityGhast g = new EntityGhast(world);
				g.setPosition(x + i, y, z);
				g.setCustomNameTag("Ghastly Ghast");
				world.spawnEntityInWorld(g);
			}
			break;
		case 2:
			world.newExplosion(null, x, y, z, 5F, true, true);
			break;
		case 3:
			EntityAttackGiantZombie eagz = new EntityAttackGiantZombie(world);
			eagz.setPosition(x, y, z);
			eagz.setCustomNameTag(EnumChatFormatting.RED + "Jen's Angry Mom");
			world.spawnEntityInWorld(eagz);
			break;
		case 4:
			world.setBlockState(pos.west(), Blocks.chest.getDefaultState());
			TileEntityChest teChest = (TileEntityChest) world.getTileEntity(pos.west());
			teChest.setInventorySlotContents(0, new ItemStack(Blocks.log, 5));
			teChest.setInventorySlotContents(5, new ItemStack(Items.apple, 10));
			teChest.setInventorySlotContents(7, new ItemStack(Items.wooden_pickaxe));
			teChest.setInventorySlotContents(14, new ItemStack(Blocks.cobblestone, 2));
			teChest.setInventorySlotContents(20, new ItemStack(Items.stick, 2));
			break;
		case 5:
			ItemStack lucky = new ItemStack(Items.wooden_sword);
			lucky.addEnchantment(Enchantment.power, 3);
			lucky.addEnchantment(Enchantment.punch, 1);
			lucky.addEnchantment(Enchantment.flame, 3);
			lucky.addEnchantment(Enchantment.infinity, 1);
			lucky.setStackDisplayName(EnumChatFormatting.DARK_BLUE +"The Ultimate Bow");
			EntityItem enLuck = new EntityItem(world, x, y, z, lucky);
			world.spawnEntityInWorld(enLuck);
			break;
		case 6:
			world.setBlockState(pos.east().down(), Blocks.trapped_chest.getDefaultState());
			TileEntityChest trapped = (TileEntityChest) world.getTileEntity(pos.east().down());
			ItemStack note = new ItemStack(Items.paper);
			note.setStackDisplayName("Did you enjoy reading me?");
			trapped.setInventorySlotContents(0, note);
			for(int fx = 0; fx < 3; fx++){
				for(int fz = 0; fz < 3; fz++){
					BlockPos tnt = new BlockPos(x + fx, y - 2, z + fz);
					world.setBlockState(tnt, Blocks.tnt.getDefaultState());
					
				}
			}
			break;
		case 7:
			ItemStack lone = new ItemStack(Blocks.dirt);
			lone.setStackDisplayName(EnumChatFormatting.GRAY + "The Lone Ranger");
			EntityItem enTwilight = new EntityItem(world, x, y, z, lone);
			world.spawnEntityInWorld(enTwilight);
			break;
		case 8:
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "Healing Shower!"));
			   for(int fx = 0; fx < 5; fx++){
				   for(int fy = 0; fy < 4; fy++){
					   for(int fz = 0; fz < 4; fz++){
						   EntityPotion full = new EntityPotion(world, player, 16485);
						   full.setPosition(x + fx, y + fy, z + fz);
						   world.spawnEntityInWorld(full);
						   EntityPotion lovely = new EntityPotion(world, player, 16481);
						   lovely.setPosition(x + fx, y + fy, z + fz);
						   world.spawnEntityInWorld(lovely);
					   }
				   }
			   }
			break;
		case 9:
			EntityCreeper creep = new EntityCreeper(world);
			creep.setPosition(x + 1, y, z);
			creep.addPotionEffect(new PotionEffect(Potion.invisibility.id, 12000, 3));
			EntityCreeper anothercreep = new EntityCreeper(world);
			anothercreep.setPosition(x + 1, y, z);
			anothercreep.addPotionEffect(new PotionEffect(Potion.invisibility.id, 12000, 3));
			world.spawnEntityInWorld(anothercreep);
			world.spawnEntityInWorld(creep);
			break;
		case 10:
			EntityZombie babyZomb = new EntityZombie(world);
			babyZomb.setPosition(x + 3, y, z);
			babyZomb.setCustomNameTag("Baby Bob!");
			ItemStack worldSword = new ItemStack(ToolManager.wcs);
			worldSword.addEnchantment(Enchantment.fireAspect, 2);
			worldSword.addEnchantment(Enchantment.sharpness, 2);
			worldSword.setStackDisplayName("A Strong Sword");
			babyZomb.setCurrentItemOrArmor(0, worldSword);
			babyZomb.setCurrentItemOrArmor(1, new ItemStack(Items.diamond_helmet));
			babyZomb.setCurrentItemOrArmor(2, new ItemStack(Items.diamond_chestplate));
			babyZomb.setCurrentItemOrArmor(3, new ItemStack(Items.diamond_leggings));
			babyZomb.setCurrentItemOrArmor(4, new ItemStack(Items.diamond_boots));
			babyZomb.setChild(true);
			EntityChicken chick = new EntityChicken(world);
			chick.setPosition(x, y, z);
			babyZomb.mountEntity(chick);
			world.spawnEntityInWorld(chick);
			world.spawnEntityInWorld(babyZomb);
			break;
		case 11:
			ItemStack lp = new ItemStack(ItemManager.up, 10);
			EntityItem enLP = new EntityItem(world, x, y, z, lp);
			world.spawnEntityInWorld(enLP);
			break;
		case 12:
			for(int fx = 0; fx < 2; fx++){
				for(int fy = 0; fy < 2; fy++){
					for(int fz = 0; fz < 2; fz++){
						world.setBlockState(new BlockPos(x + fx, y + fy, z + fz), BlockManager.ub.getDefaultState());
					}
				}
			}
			break;
		case 13:
			for(int fx = 0; fx < 3; fx++){
				for(int fy = 0; fy < 2; fy++){
					for(int fz = 0; fz < 3; fz++){
						EntityRabbit toast = new EntityRabbit(world);
						toast.setPosition(x + fx, y + fy, z + fz);
						toast.setRabbitType(99);
						toast.setCustomNameTag(EnumChatFormatting.DARK_RED + "You're Toast!");
						world.spawnEntityInWorld(toast);
					}
				}
			}
			break;
		case 14:
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.DARK_GRAY + "EXPLOSIVE STORM!"));
			for(int fx = 0; fx < 3; fx++){
				for(int fy = 0; fy < 2; fy++){
					for(int fz = 0; fz < 3; fz++){
						ExStarThrowable emt = new ExStarThrowable(world, x + fx, y + fy, z + fz);
						world.spawnEntityInWorld(emt);
					}
				}
			}
			break;
		case 15:
			ItemStack diamond = new ItemStack(Items.diamond);
			EntityItem enD = new EntityItem(world, x, y, z, diamond);
			world.spawnEntityInWorld(enD);
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.DARK_GREEN + "That's a nice diamond you got there. It would be a real sssshame if ssssomething were to happen to it."));
			break;
		case 16:
			break;
		case 17:
			EntityZombie zomb = new EntityZombie(world);
			zomb.setPosition(x + 3, y, z);
			zomb.setCustomNameTag("Super Bob!");
			ItemStack fireSword = new ItemStack(ToolManager.hammer);
			fireSword.addEnchantment(Enchantment.fireAspect, 1);
			fireSword.addEnchantment(Enchantment.knockback, 3);
			fireSword.setStackDisplayName("Bob's Lucky Hammer");
			zomb.setCurrentItemOrArmor(0, fireSword);
			zomb.setCurrentItemOrArmor(1, new ItemStack(Items.diamond_helmet));
			zomb.setCurrentItemOrArmor(2, new ItemStack(Items.diamond_chestplate));
			ItemStack boblegs = new ItemStack(Items.diamond_leggings);
			boblegs.addEnchantment(Enchantment.protection, 2);
			boblegs.addEnchantment(Enchantment.projectileProtection, 2);
			boblegs.addEnchantment(Enchantment.thorns, 1);
			zomb.setCurrentItemOrArmor(3, boblegs);
			zomb.setCurrentItemOrArmor(4, new ItemStack(Items.diamond_boots));
			world.spawnEntityInWorld(zomb);
			break;
		case 18:
			EntityZombie hug = new EntityZombie(world);
			hug.setChild(true);
			hug.setCustomNameTag(EnumChatFormatting.AQUA + "HUG ME!!!!");
			hug.setPosition(x + 5, y, z);
			EntityTNTPrimed tnt = new EntityTNTPrimed(world);
			tnt.mountEntity(hug);
			world.spawnEntityInWorld(hug);
			world.spawnEntityInWorld(tnt);
			break;
		case 19:
			for(int fx = 0; fx < 3; fx++){
				for(int fy = 0; fy < 2; fy++){
					for(int fz = 0; fz < 3; fz++){
						EntityTNTPrimed emt = new EntityTNTPrimed(world, x + fx, y + fy, z + fz, null);
						world.spawnEntityInWorld(emt);
					}
				}
			}
			break;
		case 20:
			for(int fx = 0; fx < 2; fx++){
				for(int fy = 0; fy < 2; fy++){
					for(int fz = 0; fz < 2; fz++){
						ItemStack pi = new ItemStack(Items.pumpkin_pie);
						pi.setStackDisplayName("pi");
						EntityItem enPi = new EntityItem(world,x + fx, y + fy, z + fz, pi);
						world.spawnEntityInWorld(enPi);
					}
				}
			}
			break;
		case 21:
			EntitySheep jeb = new EntitySheep(world);
			jeb.setCustomNameTag(EnumChatFormatting.GOLD + "Unlucky Sheep");
			jeb.setPosition(x, y, z);
			world.spawnEntityInWorld(jeb);
			break;
		case 22:
			EntitySkeleton skele = new EntitySkeleton(world);
			skele.setPosition(x + 3, y, z);
			skele.setCustomNameTag("Super Joey!");
			ItemStack bow = new ItemStack(Items.bow);
			bow.addEnchantment(Enchantment.flame, 3);
			bow.addEnchantment(Enchantment.knockback, 3);
			bow.addEnchantment(Enchantment.power, 5);
			bow.setStackDisplayName("Joey's Lucky Bow");
			skele.setCurrentItemOrArmor(0, bow);
			skele.setCurrentItemOrArmor(4, new ItemStack(Items.diamond_helmet));
			ItemStack chest = new ItemStack(Items.diamond_chestplate);
			chest.addEnchantment(Enchantment.protection, 3);
			chest.addEnchantment(Enchantment.blastProtection, 2);
			chest.addEnchantment(Enchantment.thorns, 2);
			chest.setStackDisplayName("Joey's Suave Shirt");
			skele.setCurrentItemOrArmor(2, chest);
			skele.setCurrentItemOrArmor(3, new ItemStack(Items.diamond_leggings));
			skele.setCurrentItemOrArmor(4, new ItemStack(Items.diamond_boots));
			world.spawnEntityInWorld(skele);
			break;
		case 23:
			player.setPositionAndUpdate(player.posX + 30, player.posY + 30, player.posZ + 30);
			break;
		case 24:
			ItemStack fishing_chest = new ItemStack(Items.leather_chestplate);
			fishing_chest.addEnchantment(Enchantment.unbreaking, 1);
			fishing_chest.addEnchantment(Enchantment.lure, 3);
			fishing_chest.addEnchantment(Enchantment.luckOfTheSea, 3);
			fishing_chest.setStackDisplayName("YOU are the ROD!");
			EntityItem enFish = new EntityItem(world, x, y,z, fishing_chest);
			world.spawnEntityInWorld(enFish);
			break;
		case 25:
			EntityGiantZombie giant = new EntityGiantZombie(world);
			giant.setPosition(x,y,z);
			giant.setCustomNameTag("Jumbo the Friendly Giant");
			world.spawnEntityInWorld(giant);
			break;
		case 26:
			for(int fx = 0; fx < 5; fx++){
				for(int fy = 0; fy < 5; fy++){
					for(int fz = 0; fz < 5; fz++){
						world.setBlockToAir(new BlockPos(x + fx, y - fy, z + fz));
					}
				}
			}
			
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.BOLD +"YOU ARE the GroundMaster!"));
			player.setPositionAndUpdate(x + 3, y - 3 ,z - 3);
			break;
		case 27:
			world.setBlockState(pos.west(), Blocks.redstone_block.getDefaultState());
			for(int i =1; i < 6; i++){
				world.setBlockState(pos.west().up(i), Blocks.tnt.getDefaultState());
			}
			break;
		case 28:
			world.setWorldTime(14000);
			for(int i =  0; i < 10; i++){
				EntityCaveSpider spidey = new EntityCaveSpider(world);
				spidey.setPosition(x + i, y, z);
				spidey.setCustomNameTag(EnumChatFormatting.BLACK + "DEATH SPIDER!");
				world.spawnEntityInWorld(spidey);
			}
			break;
		case 29:
			ItemStack cobs = new ItemStack(Blocks.web, 10);
			world.spawnEntityInWorld(new EntityItem(world, x, y + 1, z, cobs));
			break;
		case 30:
			BossSpawn.createSlimeStack(world, pos);
			break;
		case 31:
			BossSpawn.createFriendlyCreeper(world, pos);
			break;
		case 32:
			world.spawnEntityInWorld(BossSpawn.createBossZombie(world, pos));
			break;
		case 33:
			ItemStack e4 = new ItemStack(BlockManager.elb);
			e4.setStackDisplayName(EnumChatFormatting.RED + "Error 404!");
			EntityItem enE4 = new EntityItem(world, x, y, z, e4);
			world.spawnEntityInWorld(enE4);
			break;
		case 34:
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "Ho ho ho..."));
			for(int fx = 0; fx < 5; fx++){
				for(int fy = 0; fy < 20; fy++){
					ItemStack db = new ItemStack(Blocks.deadbush);
					world.spawnEntityInWorld(new EntityItem(world, x + fx, y + fy, z, db));
				}
			}
			break;
		case 35:
			for(int fx = 0; fx < 5; fx++){
				for(int fy = 0; fy < 20; fy++){
					world.spawnEntityInWorld(new EntityTNTPrimed(world, x + fx, y + fy, z, player));
				}
			}
			break;
		case 36:
			for(int fx = 0; fx < 3; fx++){
				for(int fz = 0; fz < 3; fz++){
					EntityBat bats = new EntityBat(world);
					bats.setPosition(x + fx,y,z+ fz);
					world.spawnEntityInWorld(bats);
					}
		}
			break;
		case 37:
			ItemStack wi = new ItemStack(Items.paper);
			wi.setStackDisplayName("Note: You will DIE opening this blocks...");
			EntityItem enWI = new EntityItem(world, x, y + 4, z, wi);
			world.spawnEntityInWorld(enWI);
			break;
		case 38:
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.BOLD + "Wreak vengeance on this world!"));
			EntityItem enBow = new EntityItem(world, x, y + 1, z, new ItemStack(ItemManager.pgh, 5));
			EntityItem enArrow = new EntityItem(world, x, y + 1, z, new ItemStack(ItemManager.pgw, 5));
			world.spawnEntityInWorld(enBow);
			world.spawnEntityInWorld(enArrow);
			break;
		case 39:
			for(int fx =0; fx < 10; fx++){
				for(int fy = 0; fy < 10; fy++){
					for(int fz = 0; fz < 3; fz++){
						world.setBlockState(new BlockPos(x + fx, y + fy, z +fz), Blocks.lava.getDefaultState());
					}
				}
			}
			break;
		case 40:
			for(int i = 0; i < 3; i++){
				world.spawnEntityInWorld(BossSpawn.getElementalBoss(world, pos));
			}
			break;
		case 41:
			ItemStack stuck = new ItemStack(Items.stick);
			stuck.setStackDisplayName(EnumChatFormatting.DARK_GRAY + "Stuck...");
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, stuck));
			break;
		case 42:
			for(int fx = 0; fx < 2; fx++){
				for(int fy = 0; fy < 2; fy++){
					for(int fz = 0; fz < 2; fz++){
						world.setBlockState(new BlockPos(x + fx, y + fy, z + fz), Blocks.tnt.getStateFromMeta(1));
					}
				}
			}
			break;
		case 43:
			for(int fx = 0; fx < 5; fx++){
				for(int fy = 0; fy < 2; fy++){
					for(int fz = 0; fz < 2; fz++){
						world.setBlockState(new BlockPos(x + fx, y + fy, z + fz), BlockManager.fdb.getDefaultState());
					}
				}
			}
			break;
		case 44:
	        world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(Blocks.log2, 10)));
			break;
		case 45:
			for(int fx = 0; fx < 5; fx++){
				for(int fy = 0; fy < 3; fy++){
					for(int fz =0 ; fz < 5; fz++){
						world.setBlockState(new BlockPos(x + fx,y - fy, z + fz), Blocks.flowing_water.getDefaultState());
					}
				}
			}
			break;
		case 46:
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.YELLOW + "It's time to die!"));
			world.spawnEntityInWorld(new EntityNuke(world, x, y + 5, z));
			break;
		case 47:
			player.addChatComponentMessage(new ChatComponentText("Well, those are problems"));
			for(int fy = 0; fy < 10; fy++){
				world.setBlockState(pos.up(fy), Blocks.bedrock.getDefaultState());
			}
			break;
		case 48:
			player.addChatComponentMessage(new ChatComponentText("Fortune smiles among all players? Everyone gets poison? :("));
			Iterator iteratorp = world.playerEntities.iterator();	
			while(iteratorp.hasNext()){
				Object o = iteratorp.next();
				if(o instanceof EntityPlayer){
					EntityPlayer pl = (EntityPlayer) o;
					pl.addPotionEffect(new PotionEffect(Potion.poison.id, 300, 2));
				}
			}
			break;
		case 49:
			player.addChatComponentMessage(new ChatComponentText("Fortune smiles among all players? Everyone gets wither! :("));
			Iterator it = world.playerEntities.iterator();	
			while(it.hasNext()){
				Object o = it.next();
				if(o instanceof EntityPlayer){
					EntityPlayer pl = (EntityPlayer) o;
					pl.addPotionEffect(new PotionEffect(Potion.wither.id, 300, 2));
				}
			}
			break;
		case 50:
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.BLUE + "Your wish came true!!!"));
			for(int fx = 0; fx < 4; fx++){
				for(int fy = 0; fy < 4; fy++){
					for(int fz = 0; fz < 4; fz++){
						world.spawnEntityInWorld(new EntityTNTPrimed(world, x + fx, y + fy, z + fz, player));
					}
				}
			}
			break;
		case 51:
			world.setBlockState(pos.west(), Blocks.chest.getDefaultState());
			break;
		case 52:
			ItemStack sword = new ItemStack(Items.stone_sword);
			sword.setStackDisplayName(EnumChatFormatting.WHITE + "Sword");
			world.spawnEntityInWorld(new EntityItem(world, x, y + 2, z, sword));
			break;
		case 53:
			EntityRandomSlime slimez = new EntityRandomSlime(world);
			slimez.setPosition(x, y + 2, z);
			slimez.setCustomNameTag("Ride em' ranger!");
			world.spawnEntityInWorld(slimez);
			player.mountEntity(slimez);
			break;
		case 54:
			Random randoim = world.rand;
			ItemStack luckyh = new ItemStack(Items.potionitem, 1, 8203);
			luckyh.setStackDisplayName(EnumChatFormatting.DARK_PURPLE + "Hero's Potion");
			ItemPotion potion = (ItemPotion) luckyh.getItem();
			List effects = potion.getEffects(8203);
			createUnluckyPotionEffects(effects, randoim);
			EntityItem enLucky = new EntityItem(world, x + 1, y, z, luckyh);
			world.spawnEntityInWorld(enLucky);
			break;
		case 55:
			player.addChatComponentMessage(new ChatComponentText("NUKE!"));
			world.newExplosion(null, x, y, z, 125f, true, true);
			break;
		case 56:
			TrapC tc = new TrapC(world);
			tc.generate(world, world.rand, pos);
			player.setPositionAndUpdate(x + 2.5, y + 3, z + 2.5);
			break;
		case 57:
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.AQUA + "Look Up..."));
			TrapB trapb = new TrapB(world);
			trapb.generate(world, new Random(), pos);
			player.setPositionAndUpdate(x + 2.5, y + 3, z + 2.5);
			break;
		case 58:
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.AQUA + "Look Up..."));
			TrapA trap = new TrapA(world);
			trap.generate(world, new Random(), pos);
			player.setPositionAndUpdate(x + 2.5, y + 3, z + 2.5);
			break;
		case 59:
			player.addChatComponentMessage(new ChatComponentText("ZAMBIE APOCOLYPSE!"));
			world.setTotalWorldTime(14000);
			for(int i = 0; i < 5; i++){
				for(int iy = 0; iy < 5; iy++){
					for(int iz = 0; iz < 3; iz++){
						EntityZombie zambie = new EntityZombie(world);
						zambie.setPosition(x + i, iy + y, iz + z);
						world.spawnEntityInWorld(zambie);
					}
				}
			}
			break;
		case 60:
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GREEN+"CREEPER BOMBARDMENT!"));
			world.setTotalWorldTime(14000);
			for(int i = 0; i < 5; i++){
				for(int iy = 0; iy < 5; iy++){
					for(int iz = 0; iz < 3; iz++){
						EntityCreeper creepa = new EntityCreeper(world);
						creepa.setPosition(x + i, iy + y, iz + z);
						world.spawnEntityInWorld(creepa);
					}
				}
			}
			break;
		case 61:
			EntityZombie ez = new EntityZombie(world);
			ez.setPositionAndUpdate(x, y, z);
			ez.setCurrentItemOrArmor(0, new ItemStack(ToolManager.ep));
			ez.setCurrentItemOrArmor(1, new ItemStack(ArmorRegistry.eh));
			ez.setCurrentItemOrArmor(2, new ItemStack(ArmorRegistry.ec));
			ez.setCurrentItemOrArmor(3, new ItemStack(ArmorRegistry.el));
			ez.setCurrentItemOrArmor(4, new ItemStack(ArmorRegistry.eb));
			ez.setCustomNameTag(EnumChatFormatting.BLACK + "EXPLOSIVE BOB!!!");
			world.spawnEntityInWorld(ez);
			break;
		case 62:
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.BLACK+"SPIDER SWARM!"));
			world.setTotalWorldTime(14000);
			for(int i = 0; i < 5; i++){
				for(int iy = 0; iy < 5; iy++){
					for(int iz = 0; iz < 3; iz++){
						EntitySpider creepa = new EntitySpider(world);
						creepa.setPosition(x + i, iy + y, iz + z);
						world.spawnEntityInWorld(creepa);
					}
				}
			}
			break;
		case 63:
			EntityHorse th = new EntityHorse(world);
			th.setPosition(x + 5, y, z);
			th.setHorseSaddled(true);
			th.setHorseTamed(true);
			th.attackEntityFrom(DamageSource.fall, th.getHealth() - 1);
			EntityCreeper troll = new EntityCreeper(world);
			troll.addPotionEffect(new PotionEffect(Potion.invisibility.id, 2000, 0, true, false));
			troll.setPosition(x + 5, y, z);
			world.spawnEntityInWorld(th);
			world.spawnEntityInWorld(troll);
			
			break;
		case 64:
			ItemStack db = new ItemStack(Blocks.deadbush);
			db.setStackDisplayName(EnumChatFormatting.BOLD + "#TheUltimateWeapon");
			world.spawnEntityInWorld(new EntityItem(world,x,y,z,db));
			break;
		case 65:
			EntitySkeleton cf = new EntitySkeleton(world);
			cf.setPosition(x + 5, y, z);
			ItemStack redhood = new ItemStack(Items.leather_helmet);
			ItemArmor helm = (ItemArmor) redhood.getItem();
			helm.setColor(redhood, 0xff0000);
			redhood.setStackDisplayName(EnumChatFormatting.RED + "Captain Falcon's Helmet");
			redhood.addEnchantment(Enchantment.protection, world.rand.nextInt(25));
			redhood.addEnchantment(Enchantment.projectileProtection, world.rand.nextInt(25));
			ItemStack fp = new ItemStack(Items.bow);
			fp.addEnchantment(Enchantment.punch, world.rand.nextInt(25));
			fp.setStackDisplayName(EnumChatFormatting.RED + "Falcon PUNCH!");
			cf.setCurrentItemOrArmor(0, fp);
			cf.setCurrentItemOrArmor(1, redhood);
			cf.setCurrentItemOrArmor(2, new ItemStack(Items.iron_chestplate));
			cf.setCurrentItemOrArmor(3, new ItemStack(Items.iron_leggings));
			cf.setCurrentItemOrArmor(4, new ItemStack(Items.diamond_boots));
			world.spawnEntityInWorld(cf);
			break;
		case 66:
			world.setBlockState(pos.west(), Blocks.redstone_block.getDefaultState());
			for(int i = 0; i < 20; i++){
				world.setBlockState(pos.west().up(i + 1), Blocks.tnt.getDefaultState());
				
			}
			break;
		case 67:
			for(int fx = 0; fx < 5; fx++){
				for(int fz = 0; fz < 10; fz++){
					world.spawnEntityInWorld(new ExStarThrowable(world, x +fx, y + 40, z + fz));
				}
			}
			break;
		
		}
	}
	
	
	
	
	public int getMetaForPotion(Random rand){
		switch(rand.nextInt(5)){
		case 0:
			return 16387;
		case 1:
			return 16388;
		case 2:
			return 16399;
		case 3:
			return 164908;
		case 4:
			return 16392234;
		}
		return 16388;
	}
	

	
	
	public EntityPlayer getPlayer(World world){
		Iterator i = world.playerEntities.iterator(); 
		while(i.hasNext()){
			Object o = i.next();
			if(o instanceof EntityPlayer){
				return (EntityPlayer) o;
			}
		}
		return null;
	}
	
	public void triggerTeleportTrap(World world){
		Iterator players = world.playerEntities.iterator();	
		while(players.hasNext()){
			Object o = players.next();
			if(o instanceof EntityPlayer){
				EntityPlayer player = (EntityPlayer) o;
				player.setPositionAndUpdate(player.posX + 30, player.posY + 30, player.posZ + 30);
			}
		}
	
	}
	
	public int getColorClothingHex(Random rand){
		switch(rand.nextInt(7)){
		case 0:
			return 0x000000;
		case 1:
			return 0x214D21;
		case 2:
			return 0x927D3A;
		case 3:
			return 0xA93EC4;
		case 4:
			return 0x3EBBC4;
		case 5:
			return 0x3E5BC4;
		case 6:
			return 0xC43E98;
		default:
			return 0x000000;
		}
	}
	
	public String getCommand(Random r){
		switch(r.nextInt(6)){
		case 0:
			return "/summon EnderCrystal";
		case 1:
			return "/give @p emerald 10";
		case 2:
			return "/give @p rotten_flesh 64";
		case 3:	
			return "/give @p diamond_block 2";
		case 4:
			return "/say What's up @p ?";
		case 5:
			return "/summon Creeper ~ ~15 ~ {Invulnerable:0,Riding:{id:Bat,Size:-10,­Invulnerable:1,ActiveEffects:[{Amplifier­:1,Ambient:1,Id:14,Duration:0}],Riding:{­id:Slime,Size:2,Invulnerable:0,ActiveEff­ects:[{Amplifier:1,Id:14,Duration:0}],Riding:{id:,direction:[0.0,0.0,0.0]}}}} ";	
		default:
			return "";
		}
	}
	
	
	
	
	
	
	public static void createLuckyPotionEffects(List effects, Random r){
		effects.clear();
		effects.add(new PotionEffect(Potion.regeneration.id, r.nextInt(6000), r.nextInt(5)));
		effects.add(new PotionEffect(Potion.moveSpeed.id, r.nextInt(6000), r.nextInt(5)));
		effects.add(new PotionEffect(Potion.damageBoost.id, r.nextInt(6000), r.nextInt(5)));
		effects.add(new PotionEffect(Potion.resistance.id, r.nextInt(6000), r.nextInt(5)));
		effects.add(new PotionEffect(Potion.healthBoost.id, r.nextInt(6000), r.nextInt(5)));
		effects.add(new PotionEffect(Potion.absorption.id, r.nextInt(6000), r.nextInt(5)));
		effects.add(new PotionEffect(Potion.invisibility.id, r.nextInt(6000), r.nextInt(5)));
		
	}
	
	public static void createUnluckyPotionEffects(List bEffects, Random rand){
		bEffects.clear();
		bEffects.add(new PotionEffect(Potion.blindness.id, rand.nextInt(6000), rand.nextInt(5)));
		bEffects.add(new PotionEffect(Potion.moveSlowdown.id, rand.nextInt(6000), rand.nextInt(5)));
		bEffects.add(new PotionEffect(Potion.wither.id, rand.nextInt(6000), rand.nextInt(5)));
		bEffects.add(new PotionEffect(Potion.poison.id, rand.nextInt(6000), rand.nextInt(5)));
		bEffects.add(new PotionEffect(Potion.weakness.id, rand.nextInt(6000), rand.nextInt(5)));
		bEffects.add(new PotionEffect(Potion.digSlowdown.id, rand.nextInt(6000), rand.nextInt(5)));
		bEffects.add(new PotionEffect(Potion.hunger.id, rand.nextInt(6000), rand.nextInt(5)));
		bEffects.add(new PotionEffect(Potion.nightVision.id, rand.nextInt(6000), rand.nextInt(5)));
	}
	
	
	
	

}
