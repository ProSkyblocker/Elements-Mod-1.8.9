package mike.minecraft.elementsmod.util;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import mike.minecraft.elementsmod.armor.ArmorRegistry;
import mike.minecraft.elementsmod.entity.EntityRandomSlime;
import mike.minecraft.elementsmod.items.BossSpawn;
import mike.minecraft.elementsmod.items.ItemManager;
import mike.minecraft.elementsmod.throwables.ExStarThrowable;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class LuckyPotionItems {
	public static Potion[] types = {Potion.absorption, Potion.blindness, Potion.confusion, Potion.damageBoost, Potion.digSlowdown, 
			Potion.digSpeed, Potion.fireResistance, Potion.harm, Potion.heal, Potion.healthBoost, Potion.hunger, Potion.invisibility,
			Potion.jump, Potion.moveSlowdown, Potion.moveSpeed, Potion.nightVision, Potion.poison, Potion.regeneration, Potion.resistance,
			Potion.saturation, Potion.waterBreathing, Potion.weakness, Potion.wither};

	public void chooseDrink(World w, EntityPlayer p, BlockPos pos){
		Random r = w.rand;
		int number = r.nextInt(26);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		
		System.out.println(number);
		
		switch(number){
			case 0:
				int pNum = r.nextInt(types.length);
				int potionID = types[pNum].id;
				p.addPotionEffect(new PotionEffect(potionID, 600, r.nextInt(4)));
				break;
			case 1:
				for(int i = 0; i < 2; i++){
				w.setBlockState(p.getPosition().west(2).up(i), Blocks.diamond_block.getDefaultState());
				w.setBlockState(p.getPosition().east(2).up(i), Blocks.gold_block.getDefaultState());
				w.setBlockState(p.getPosition().north(2).up(i), Blocks.lapis_block.getDefaultState());
				w.setBlockState(p.getPosition().south(2).up(i), Blocks.emerald_block.getDefaultState());
				}
				
				break;
			case 2:
				ItemStack slow = new ItemStack(Items.potionitem, 1, 16390);
				slow.setStackDisplayName(EnumChatFormatting.AQUA + "Slow-Mo Potion");
				List sfx = ((ItemPotion) slow.getItem()).getEffects(16390);
				sfx.clear();
				sfx.add(new PotionEffect(Potion.moveSlowdown.id, 1200, 255));
				EntityItem item = new EntityItem(w, x, y, z, slow);
				
				
				ItemStack weak = new ItemStack(Items.potionitem, 1, 16392);
				weak.setStackDisplayName(EnumChatFormatting.YELLOW + "Pacifist Potion");
				List wsfx = ((ItemPotion) weak.getItem()).getEffects(16392);
				wsfx.clear();
				wsfx.add(new PotionEffect(Potion.weakness.id, 1200, 255));
				EntityItem witem = new EntityItem(w, x, y, z, weak);
				

				ItemStack death = new ItemStack(Items.potionitem, 1, 16396);
				death.setStackDisplayName(EnumChatFormatting.BLACK + "Death Potion");
				List dsfx = ((ItemPotion) death.getItem()).getEffects(16396);
				dsfx.clear();
				dsfx.add(new PotionEffect(Potion.wither.id, 1200, 255));
				EntityItem ditem = new EntityItem(w, x, y, z, death);
				
				w.spawnEntityInWorld(item);
				w.spawnEntityInWorld(witem);
				w.spawnEntityInWorld(ditem);
				break;
			case 3:
				p.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.YELLOW + "Herobrine joined the game."));
				break;
			case 4:
				for(int fx = 0; fx < 2; fx++){
					for(int fy = 0; fy < 3; fy++){
						for(int fz = 0; fz < 2; fz++){
							EntityItem enD = new EntityItem(w, x + fx, y + fy, z + fz, new ItemStack(Items.diamond));
							EntityItem enE = new EntityItem(w, x + fx, y + fy, z + fz, new ItemStack(Items.emerald));
							EntityItem enG = new EntityItem(w, x + fx, y + fy, z + fz, new ItemStack(Items.gold_ingot));
							w.spawnEntityInWorld(enG);
							w.spawnEntityInWorld(enE);
							w.spawnEntityInWorld(enD);
						}
					}
				}
				break;
			case 5:
				break;
			case 6:
				ItemStack stale = new ItemStack(Items.bread);
				stale.setStackDisplayName(EnumChatFormatting.ITALIC + "Stale Bread");
				stale.addEnchantment(Enchantment.sharpness, 3);
				stale.addEnchantment(Enchantment.knockback, 2);
				stale.addEnchantment(Enchantment.smite, 2);
				stale.addEnchantment(Enchantment.baneOfArthropods, 2);
				EntityItem enS = new EntityItem(w, x, y, z, stale);
				w.spawnEntityInWorld(enS);
				break;
			case 7:
				for(int i = 0; i < 10; i++){
					EntityZombie zomb = new EntityZombie(w);
					zomb.setChild(true);
					zomb.setPosition(x + 3, y + i, z);
					zomb.setCurrentItemOrArmor(1, new ItemStack(Blocks.pumpkin));
					w.spawnEntityInWorld(zomb);
				}
				break;
			case 8:
				ItemStack luckw = new ItemStack(ItemManager.boss, 3, 2);
				EntityItem enLuckw = new EntityItem(w, x, y, z, luckw);
				w.spawnEntityInWorld(enLuckw);
				break;
			case 9:
				ThreadLocalRandom tlr = ThreadLocalRandom.current();
				ItemStack good = new ItemStack(ArmorRegistry.eChest);
				good.addEnchantment(Enchantment.protection, tlr.nextInt(2, 5));
				good.addEnchantment(Enchantment.thorns, tlr.nextInt(2, 5));
				good.addEnchantment(Enchantment.projectileProtection, tlr.nextInt(2, 5));
				good.addEnchantment(Enchantment.unbreaking, tlr.nextInt(2, 5));
				good.addEnchantment(Enchantment.blastProtection, tlr.nextInt(2, 5));
				good.setStackDisplayName(p.getName()+"'s Lucky Chestplate");
				EntityItem enGoodC = new EntityItem(w, x, y, z, good);
				w.spawnEntityInWorld(enGoodC);
				break;
			case 10:
				for(int fx = 0; fx < 4; fx++){
					for(int fy = 0; fy < 15; fy++){
						for(int fz = 0; fz < 4; fz++){
							w.setBlockToAir(new BlockPos(x + 1 + fx, y - fy, z + fz));
						}
					}
				}
				break;
			case 11:
				w.setBlockState(new BlockPos(x, y, z), Blocks.enchanting_table.getDefaultState());
				for(int fx = 0; fx < 8;fx++){
					for(int fy = 0; fy < 3; fy++){
						for(int fz = 0; fz < 5; fz++){
							EntityXPOrb xp = new EntityXPOrb(w, x+fx, y+fy, z+fz, 2);
							
							w.spawnEntityInWorld(xp);
						}
					}
				}
				break;
			case 12:
				ThreadLocalRandom trl = ThreadLocalRandom.current();
					ItemStack goodL = new ItemStack(ArmorRegistry.eLegs);
					goodL.addEnchantment(Enchantment.protection, trl.nextInt(2, 5));
					goodL.addEnchantment(Enchantment.thorns, trl.nextInt(2, 5));
					goodL.addEnchantment(Enchantment.projectileProtection, trl.nextInt(2, 5));
					goodL.addEnchantment(Enchantment.unbreaking, trl.nextInt(2, 5));
					goodL.addEnchantment(Enchantment.blastProtection, trl.nextInt(2, 5));
					goodL.setStackDisplayName(p.getName()+"'s Lucky Leggings");
					EntityItem enGoodl = new EntityItem(w, x, y, z, goodL);
					w.spawnEntityInWorld(enGoodl);
				break;
			case 13:
				ItemStack wp = new ItemStack(Items.wooden_pickaxe);
				ItemStack wa = new ItemStack(Items.wooden_axe);
				ItemStack ws = new ItemStack(Items.wooden_sword);
				ItemStack wsh = new ItemStack(Items.wooden_shovel);
				ItemStack wh = new ItemStack(Items.wooden_hoe);
				EntityItem enWP = new EntityItem(w, x, y, z, wp);
				EntityItem enA = new EntityItem(w, x, y, z, wa);
				EntityItem enSh = new EntityItem(w, x, y, z, ws);
				EntityItem enWSH = new EntityItem(w, x, y, z, wsh);
				EntityItem enH = new EntityItem(w, x, y, z, wh);
				w.spawnEntityInWorld(enWP);
				w.spawnEntityInWorld(enA);
				w.spawnEntityInWorld(enSh);
				w.spawnEntityInWorld(enWSH);
				w.spawnEntityInWorld(enH);
				break;
			case 14:
				p.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 100, 255));
				p.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.BLUE + "SUGAR RUSH!"));
				break;
			case 15:
				ItemStack light = new ItemStack(ItemManager.crystals, 5, 3);
				EntityItem enLight = new EntityItem(w, x + 2, y, z, light);
				w.spawnEntityInWorld(enLight);
				w.setBlockState(new BlockPos(x + 2, y, z), Blocks.glowstone.getDefaultState());
				w.setBlockState(new BlockPos(x -2, y, z), Blocks.redstone_block.getDefaultState());
				w.setBlockState(new BlockPos(x + 5, y, z), Blocks.redstone_lamp.getDefaultState());
				w.setBlockState(new BlockPos(x, y, z + 1), Blocks.redstone_torch.getDefaultState());
				break;
			case 16:
				ThreadLocalRandom thlr = ThreadLocalRandom.current();
				ItemStack goodh = new ItemStack(ArmorRegistry.eHelm);
				goodh.addEnchantment(Enchantment.protection, thlr.nextInt(2, 5));
				goodh.addEnchantment(Enchantment.thorns, thlr.nextInt(2, 5));
				goodh.addEnchantment(Enchantment.projectileProtection, thlr.nextInt(2, 5));
				goodh.addEnchantment(Enchantment.unbreaking, thlr.nextInt(2, 5));
				goodh.addEnchantment(Enchantment.blastProtection, thlr.nextInt(2, 5));
				goodh.addEnchantment(Enchantment.aquaAffinity, thlr.nextInt(2, 5));
				goodh.addEnchantment(Enchantment.respiration, thlr.nextInt(2, 5));
				goodh.setStackDisplayName(p.getName()+"'s Lucky Helmet");
				EntityItem enGoodh = new EntityItem(w, x, y, z, goodh);
				w.spawnEntityInWorld(enGoodh);
				break;
			case 17:
				ThreadLocalRandom tlrand = ThreadLocalRandom.current();
				ItemStack goodb = new ItemStack(ArmorRegistry.eBoots);
				goodb.addEnchantment(Enchantment.protection, tlrand.nextInt(2, 5));
				goodb.addEnchantment(Enchantment.thorns, tlrand.nextInt(2, 5));
				goodb.addEnchantment(Enchantment.projectileProtection, tlrand.nextInt(2, 5));
				goodb.addEnchantment(Enchantment.unbreaking, tlrand.nextInt(2, 5));
				goodb.addEnchantment(Enchantment.blastProtection, tlrand.nextInt(2, 5));
				goodb.addEnchantment(Enchantment.depthStrider, tlrand.nextInt(2, 5));
				goodb.setStackDisplayName(p.getName()+"'s Lucky Boots");
				EntityItem enGoodB = new EntityItem(w, x, y, z, goodb);
				w.spawnEntityInWorld(enGoodB);
				break;
			case 18:
				p.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.DARK_PURPLE +"FLY!!!!"));
				p.setPositionAndUpdate(p.posX + 30, p.posY + 30, p.posZ + 30);
				break;
			case 19:
				for(int fx = 0; fx < 5; fx++){
					for(int fy = 0; fy < 3; fy++){
						for(int fz =0 ; fz < 5; fz++){
							w.setBlockState(new BlockPos(x + fx,y - fy, z + fz), Blocks.flowing_lava.getDefaultState());
						}
					}
				}
				break;
			case 20:
				for(int i = 0; i < 5; i++){
				EntityRabbit rab = new EntityRabbit(w);
				rab.setPosition(x + 2, y + i, z);
				rab.setRabbitType(99);
				w.spawnEntityInWorld(rab);
		}
				break;
			case 21:
				ItemStack ih = new ItemStack(Items.iron_helmet);
				ItemStack ic = new ItemStack(Items.iron_chestplate);
				ItemStack il = new ItemStack(Items.iron_leggings);
				ItemStack ib = new ItemStack(Items.iron_boots);
				w.spawnEntityInWorld(new EntityItem(w, x, y + 2, z, ih));
				w.spawnEntityInWorld(new EntityItem(w, x, y + 2, z, ic));
				w.spawnEntityInWorld(new EntityItem(w, x, y + 2, z, il));
				w.spawnEntityInWorld(new EntityItem(w, x, y + 2, z, ib));
				break;
			case 22:
				p.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.BLACK + "Look up..."));
				for(int i = 0; i < 5; i++){
					ExStarThrowable emt = new ExStarThrowable(w);
					emt.setPositionAndUpdate(x + i, y + 4, z);
					w.spawnEntityInWorld(emt);
				}
				break;
			case 23:
				EntityVillager vi = new EntityVillager(w);
				vi.setPositionAndUpdate(x + 1, y + 2, z);
				vi.setCustomNameTag("The Three Muskateers!");
				EntityVillager vd = new EntityVillager(w);
				vd.setPositionAndUpdate(x, y + 2, z);
				vd.setCustomNameTag("The Three Muskateers!");
				EntityVillager vt = new EntityVillager(w);
				vt.setPositionAndUpdate(x - 1, y + 2, z);
				vt.setCustomNameTag("The Three Muskateers!");
				w.spawnEntityInWorld(vi);
				w.spawnEntityInWorld(vd);
				w.spawnEntityInWorld(vt);
				break;
			case 24:
				BossSpawn.createFriendlyCreeper(w, pos);
				BossSpawn.createFriendlyCreeper(w, pos);
				break;
			case 25:
				p.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "Healing Shower!"));
				   for(int fx = 0; fx < 5; fx++){
					   for(int fy = 0; fy < 4; fy++){
						   for(int fz = 0; fz < 4; fz++){
							   EntityPotion full = new EntityPotion(w, p, 16485);
							   full.setPosition(x + fx, y + fy, z + fz);
							   w.spawnEntityInWorld(full);
							   EntityPotion lovely = new EntityPotion(w, p, 16481);
							   lovely.setPosition(x + fx, y + fy, z + fz);
							   w.spawnEntityInWorld(lovely);
						   }
					   }
				   }
				break;
			
		}
	}
	
	public void chooseUnluckyDrink(World w, EntityPlayer p, BlockPos pos){
		Random r = w.rand;
		int number = r.nextInt(21);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		
		System.out.println(number);
		
		switch(number){
		   case 0:
			   for(int fx = 0; fx < 4; fx++){
				   for(int fy = 0; fy < 2; fy++){
					   for(int fz = 0; fz < 1; fz++){
						    EntityRabbit rab = new EntityRabbit(w);
							rab.setPosition(x + fx, y + fy, z + fz);
							rab.setRabbitType(99);
							w.spawnEntityInWorld(rab);
					   }
				   }
			   }
			   break;
		   case 1:
			   for(int fx = 0; fx < 5; fx++){
					for(int fy = 0; fy < 3; fy++){
						for(int fz =0 ; fz < 5; fz++){
							w.setBlockState(new BlockPos(x + fx,y - fy, z + fz), Blocks.flowing_lava.getDefaultState());
						}
					}
				}
			   break;
		   case 2:
			   w.newExplosion(p, x, y, z, 4.7f, true, true);
			   break;
		   case 3:
			   EntityPotion regen = new EntityPotion(w, p, 8289);
			   regen.setPosition(x + 1, y, z);
			   w.spawnEntityInWorld(regen);
			   EntityPotion regenagain = new EntityPotion(w, p, 8289);
			   regenagain.setPosition(x + 1, y, z);
			   w.spawnEntityInWorld(regenagain);
			   EntityItem enIce = new EntityItem(w, x, y, z, new ItemStack(Blocks.wool, 5, 6));
			   w.spawnEntityInWorld(enIce);
			   break;
		   case 4:
			   p.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GRAY + "Arrow Storm!"));
			   for(int fx = 0; fx < 5; fx++){
				   for(int fy = 0; fy < 4; fy++){
					   for(int fz = 0; fz < 4; fz++){
						    EntityArrow ea = new EntityArrow(w, x + fx, y + fy, z + fz);
						    w.spawnEntityInWorld(ea);
					   }
				   }
			   }
			   break;
		   case 5:
			   EntityPotion wither = new EntityPotion(w, p, 8289);
			   wither.setPosition(x + 1, y + 4, z);
			   w.spawnEntityInWorld(wither);
			   EntityPotion slowness = new EntityPotion(w, p, 16490);
			   slowness.setPosition(x + 1, y + 4, z);
			   w.spawnEntityInWorld(slowness);
			   EntityPotion harm = new EntityPotion(w, p, 16492);
			   harm.setPosition(x + 1, y + 4, z);
			   w.spawnEntityInWorld(harm);
			   EntityPotion weak = new EntityPotion(w, p, 16488);
			   weak.setPosition(x + 1, y + 4, z);
			   w.spawnEntityInWorld(weak);
			   EntityPotion pois = new EntityPotion(w, p, 16484);
			   pois.setPosition(x + 1, y + 4, z);
			   w.spawnEntityInWorld(pois);
			   break;
		   case 6:
			   for(int i = 0; i < 10; i++){
					EntityZombie zomb = new EntityZombie(w);
					zomb.setChild(true);
					zomb.setPosition(x + 3, y + i, z);
					zomb.setCurrentItemOrArmor(1, new ItemStack(Blocks.pumpkin));
					w.spawnEntityInWorld(zomb);
				}
			   break;
		   case 7:
			   p.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GREEN + "Poisonous Storm!"));
			   for(int fx = 0; fx < 5; fx++){
				   for(int fy = 0; fy < 4; fy++){
					   for(int fz = 0; fz < 4; fz++){
						   EntityPotion full = new EntityPotion(w, p, 16484);
						   full.setPosition(x + fx, y + fy, z + fz);
						   w.spawnEntityInWorld(full);
					   }
				   }
			   }
			   break;
		   case 8:
			   p.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.BOLD + "Snowball Storm!"));
			   for(int fx = 0; fx < 5; fx++){
				   for(int fy = 0; fy < 4; fy++){
					   for(int fz = 0; fz < 4; fz++){
						   EntitySnowball ball = new EntitySnowball(w, x + fx, y + fy, z + fz);
						   w.spawnEntityInWorld(ball);
					   }
				   }
			   }
			   break;
		   case 9:
			   for(int fx = 0; fx < 2; fx++){
				   for(int fy = 0; fy < 2; fy++){
					   for(int fz = 0; fz < 4; fz++){
						   EntityLightningBolt elb = new EntityLightningBolt(w, x + fx, y + fy,  z + fz);
						   w.spawnEntityInWorld(elb);
					   }
				   }
			   }
			   break;
		   case 10:
			   w.playSoundAtEntity(p, "mob.ghast.affectionate_scream", 0.5F, 0.4F / (w.rand.nextFloat() * 0.4F + 0.8F));
			   break;
		   case 11:
			   for(int fx = 0; fx < 5; fx++){
					for(int fy = 0; fy < 3; fy++){
						for(int fz =0 ; fz < 5; fz++){
							w.setBlockState(new BlockPos(x + fx,y - fy, z + fz), Blocks.dirt.getDefaultState());
						}
					}
				}
			   break;
		   case 12:
			   w.newExplosion(p, x, y, z, 0.1f, false, false);
			   break;
		   case 13:
			   for(int fx = 0; fx < 4; fx++){
					for(int fz = 0; fz  < 4; fz++){
						w.setBlockState(new BlockPos(x + fx, y , z + fz), Blocks.fire.getDefaultState());
					   }
			   }
			   break;
		   case 14:
			   for(int fx = 0; fx < 5; fx++){
				   for(int fy = 0; fy < 4; fy++){
					   for(int fz = 0; fz < 4; fz++){
						   EntityPotion full = new EntityPotion(w, p, 16492);
						   full.setPosition(x + fx, y + fy, z + fz);
						   w.spawnEntityInWorld(full);
					   }
				   }
			   }
			   break;
		   case 15:
			   p.addPotionEffect(new PotionEffect(Potion.blindness.id, 200, 1));
			   p.addPotionEffect(new PotionEffect(Potion.nightVision.id, 200, 1));
			   break;
		   case 16:
			   for(int fy = 0; fy < 10; fy++){
				   ItemStack sweet = new ItemStack(Items.sugar);
				   sweet.setStackDisplayName("So Sweet!");
				   w.spawnEntityInWorld(new EntityItem(w, x, y + fy, z, sweet));
			   }
			   break;
		   case 17:
			   EntityRandomSlime slime = new EntityRandomSlime(w);
			   slime.setPosition(x, y + 2, z);
			   slime.setSlimeSize(7);
			   w.spawnEntityInWorld(slime);
			   break;
		   case 18:
			   for(int fy = 0; fy < 10; fy++){
				   ItemStack sweet = new ItemStack(Items.bone);
				   sweet.setStackDisplayName("#Bone");
				   w.spawnEntityInWorld(new EntityItem(w, x, y + fy, z, sweet));
			   }
			   break;
		   case 19:
			   for(int fx = 0; fx < 5; fx++){
				   for(int fy = 0; fy < 4; fy++){
					   for(int fz = 0; fz < 4; fz++){
						   EntityPotion full = new EntityPotion(w, p, 16484);
						   full.setPosition(x + fx, y + fy, z + fz);
						   w.spawnEntityInWorld(full);
					   }
				   }
			   }
			   break;
		   case 20:
			   p.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.BOLD + "READ!!!"));
			   for(int fx = 0; fx < 4; fx++){
				   for(int fy = 0; fy < 4; fy++){
					for(int fz = 0; fz  < 4; fz++){
						w.setBlockState(new BlockPos(x + fx, y + fy , z + fz), Blocks.bookshelf.getDefaultState());
					   }
				   }
			   }
			   break;
		}
	}
	
	public void chooseLuckyDrink(World w, EntityPlayer p, BlockPos pos){
		Random r = w.rand;
		int number = r.nextInt(21);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		
		System.out.println(number);
		
		switch(number){
		  case 0:
			  p.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "Healing Shower!"));
			   for(int fx = 0; fx < 5; fx++){
				   for(int fy = 0; fy < 4; fy++){
					   for(int fz = 0; fz < 4; fz++){
						   EntityPotion full = new EntityPotion(w, p, 16485);
						   full.setPosition(x + fx, y + fy, z + fz);
						   w.spawnEntityInWorld(full);
						   EntityPotion lovely = new EntityPotion(w, p, 16481);
						   lovely.setPosition(x + fx, y + fy, z + fz);
						   w.spawnEntityInWorld(lovely);
					   }
				   }
			   }
			break;
		  case 1:
			  EntityPotion poison = new EntityPotion(w, p, 8194);
			  poison.setPosition(x + 1, y, z);
			   w.spawnEntityInWorld(poison);
			   EntityPotion poisagain = new EntityPotion(w, p, 8201);
			   poisagain.setPosition(x + 1, y, z);
			   w.spawnEntityInWorld(poisagain);
			   EntityItem enIce = new EntityItem(w, x, y, z, new ItemStack(Blocks.wool, 5, 3));
			   w.spawnEntityInWorld(enIce);
			  break;
		  case 2:
			  for(int fx = 0; fx < 4; fx++){
				   for(int fy = 0; fy < 2; fy++){
					   for(int fz = 0; fz < 1; fz++){
						    EntityPig rab = new EntityPig(w);
						    rab.setCustomNameTag(EnumChatFormatting.LIGHT_PURPLE + "PIG PARTY!!");
							rab.setPosition(x + fx, y + fy, z + fz);
							w.spawnEntityInWorld(rab);
					   }
				   }
			   }
			  break;
		  case 3:
			  for(int fx = 0; fx < 3; fx++){
					for(int fy = 0; fy < 2; fy++){
						for(int fz =0 ; fz < 2; fz++){
							w.setBlockState(new BlockPos(x + fx,y - fy, z + fz), Blocks.gold_block.getDefaultState());
						}
					}
				}
			  break;
		  case 4:
			  p.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GRAY + "Chickons!"));
			   for(int fx = 0; fx < 5; fx++){
				   for(int fy = 0; fy < 4; fy++){
					   for(int fz = 0; fz < 4; fz++){
						    EntityEgg ea = new EntityEgg(w, x + fx, y + fy, z + fz);
						    w.spawnEntityInWorld(ea);
					   }
				   }
			   }
			  break;
		  case 5:
			  ThreadLocalRandom tlrand = ThreadLocalRandom.current();
				ItemStack good = new ItemStack(ArmorRegistry.eBoots);
				good.addEnchantment(Enchantment.protection, tlrand.nextInt(2, 5));
				good.addEnchantment(Enchantment.thorns, tlrand.nextInt(2, 5));
				good.addEnchantment(Enchantment.projectileProtection, tlrand.nextInt(2, 5));
				good.addEnchantment(Enchantment.unbreaking, tlrand.nextInt(2, 5));
				good.addEnchantment(Enchantment.blastProtection, tlrand.nextInt(2, 5));
				good.addEnchantment(Enchantment.depthStrider, tlrand.nextInt(2, 5));
				good.setStackDisplayName(p.getName()+"'s Lucky Boots");
				EntityItem enGoodC = new EntityItem(w, x, y, z, good);
				w.spawnEntityInWorld(enGoodC);
			  break;
		  case 6:
			  ThreadLocalRandom thlr = ThreadLocalRandom.current();
				ItemStack goodhe = new ItemStack(ArmorRegistry.eHelm);
				goodhe.addEnchantment(Enchantment.protection, thlr.nextInt(2, 5));
				goodhe.addEnchantment(Enchantment.thorns, thlr.nextInt(2, 5));
				goodhe.addEnchantment(Enchantment.projectileProtection, thlr.nextInt(2, 5));
				goodhe.addEnchantment(Enchantment.unbreaking, thlr.nextInt(2, 5));
				goodhe.addEnchantment(Enchantment.blastProtection, thlr.nextInt(2, 5));
				goodhe.addEnchantment(Enchantment.aquaAffinity, thlr.nextInt(2, 5));
				goodhe.addEnchantment(Enchantment.respiration, thlr.nextInt(2, 5));
				goodhe.setStackDisplayName(p.getName()+"'s Lucky Helmet");
				EntityItem enGoodh = new EntityItem(w, x, y, z, goodhe);
				w.spawnEntityInWorld(enGoodh);
			  break;
		  case 7:
			  ThreadLocalRandom trl = ThreadLocalRandom.current();
					ItemStack goodL = new ItemStack(ArmorRegistry.eLegs);
					goodL.addEnchantment(Enchantment.protection, trl.nextInt(2, 5));
					goodL.addEnchantment(Enchantment.thorns, trl.nextInt(2, 5));
					goodL.addEnchantment(Enchantment.projectileProtection, trl.nextInt(2, 5));
					goodL.addEnchantment(Enchantment.unbreaking, trl.nextInt(2, 5));
					goodL.addEnchantment(Enchantment.blastProtection, trl.nextInt(2, 5));
					goodL.setStackDisplayName(p.getName()+"'s Lucky Leggings");
					EntityItem goodlen = new EntityItem(w, x, y, z, goodL);
					w.spawnEntityInWorld(goodlen);
			  break;
		  case 8:
			  ThreadLocalRandom tlr = ThreadLocalRandom.current();
				ItemStack goodchest = new ItemStack(ArmorRegistry.eChest);
				goodchest.addEnchantment(Enchantment.protection, tlr.nextInt(2, 5));
				goodchest.addEnchantment(Enchantment.thorns, tlr.nextInt(2, 5));
				goodchest.addEnchantment(Enchantment.projectileProtection, tlr.nextInt(2, 5));
				goodchest.addEnchantment(Enchantment.unbreaking, tlr.nextInt(2, 5));
				goodchest.addEnchantment(Enchantment.blastProtection, tlr.nextInt(2, 5));
				goodchest.setStackDisplayName(p.getName()+"'s Lucky Chestplate");
				EntityItem enGoodCh = new EntityItem(w, x, y, z, goodchest);
				w.spawnEntityInWorld(enGoodCh);
			  break;
		  case 9:
			  EntityHorse steed = new EntityHorse(w);
			  steed.setPosition(x, y, z);
			  steed.setHorseTamed(true);
			  steed.setHorseSaddled(true);
			  steed.setHorseArmorStack(new ItemStack(Items.diamond_horse_armor));
			  steed.setCustomNameTag(p.getName() + "'s Lucky Horse");
			  w.spawnEntityInWorld(steed);
			  break;
		  case 10:
			  for(int fx = 0; fx < 5; fx++){
						for(int fz =0 ; fz < 5; fz++){
							w.setBlockState(new BlockPos(x + fx,y, z + fz), Blocks.cake.getDefaultState());
						}
					
				}
			  break;
		  case 11:
			  ItemStack ticket = new ItemStack(Items.paper);
			  ticket.setStackDisplayName("Ticket to Destiny");
			  EntityItem enTicket = new EntityItem(w, x, y, z, ticket);
			  w.spawnEntityInWorld(enTicket);
			  break;
		  case 12:
			  ItemStack cookie = new ItemStack(Items.diamond, 20);
			  cookie.setStackDisplayName(EnumChatFormatting.BOLD + "Blue Coal");
			  EntityItem enCookie = new EntityItem(w, x, y, z, cookie);
			  w.spawnEntityInWorld(enCookie);
			  break;
		  case 13:
			  ItemStack unp = new ItemStack(ItemManager.up, 10);
			  EntityItem enunp = new EntityItem(w, x, y, z, unp);
			  w.spawnEntityInWorld(enunp);
			  break;
		  case 14:
			  p.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 200, 1));
			  p.addPotionEffect(new PotionEffect(Potion.jump.id, 200, 1));
			  break;
		  case 15:
			  ItemStack ih = new ItemStack(Items.iron_helmet);
				ItemStack ic = new ItemStack(Items.iron_chestplate);
				ItemStack il = new ItemStack(Items.iron_leggings);
				ItemStack ib = new ItemStack(Items.iron_boots);
				w.spawnEntityInWorld(new EntityItem(w, x, y + 2, z, ih));
				w.spawnEntityInWorld(new EntityItem(w, x, y + 2, z, ic));
				w.spawnEntityInWorld(new EntityItem(w, x, y + 2, z, il));
				w.spawnEntityInWorld(new EntityItem(w, x, y + 2, z, ib));
			  break;
		  case 16:
			  for(int fy = 0; fy < 10; fy++){
				  ItemStack cokee = new ItemStack(Items.cookie);
				  EntityItem encokee = new EntityItem(w, x, y + fy, z, cokee);
				  w.spawnEntityInWorld(encokee);
			  }
			  break;
		  case 17:
			  BossSpawn.createSlimePet(w, pos, p);
			  break;
		  case 18:
			  for(int i = 0; i < 5; i++){
				  BossSpawn.createFriendlyCreeper(w, pos);
			  }
			  break;
		  case 19:
			  for(int fx = 0; fx < 5; fx++){
				   for(int fy = 0; fy < 4; fy++){
					   for(int fz = 0; fz < 4; fz++){
						   EntityPotion full = new EntityPotion(w, p, 16494);
						   full.setPosition(x + fx, y + fy, z + fz);
						   w.spawnEntityInWorld(full);
					   }
				   }
			   }
			  break;
		  case 20:
			  for(int fx = 0; fx < 5; fx++){
				   for(int fy = 0; fy < 4; fy++){
					   for(int fz = 0; fz < 4; fz++){
						   EntityPotion full = new EntityPotion(w, p, 16489);
						   full.setPosition(x + fx, y + fy, z + fz);
						   w.spawnEntityInWorld(full);
					   }
				   }
			   }
			  break;
		}
	}
	
	
	
	
}


