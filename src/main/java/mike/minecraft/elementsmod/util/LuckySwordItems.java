package mike.minecraft.elementsmod.util;

import mike.minecraft.elementsmod.items.BossSpawn;
import mike.minecraft.elementsmod.throwables.EntityUnluckyPotion;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class LuckySwordItems {

	public void chooseAttack(EntityPlayer player, EntityLivingBase target){
		World w = player.getEntityWorld();
		int choice = w.rand.nextInt(29);
		
		int x = target.getPosition().getX();
		int y = target.getPosition().getY();
		int z = target.getPosition().getZ();
		
		System.out.println(choice);
		
		switch(choice){
		case 0:
			player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 400, 0));
			player.addPotionEffect(new PotionEffect(Potion.wither.id, 400, 0));
			player.addPotionEffect(new PotionEffect(Potion.confusion.id, 400, 0));
			break;
		case 1:
			target.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 400, 0));
			target.addPotionEffect(new PotionEffect(Potion.wither.id, 400, 0));
			target.addPotionEffect(new PotionEffect(Potion.confusion.id, 400, 0));
			break;
		case 2:
			EntityLightningBolt bolt = new EntityLightningBolt(w, x, y, z);
			w.spawnEntityInWorld(bolt);
			target.setFire(12000);
			break;
		case 3:
			w.newExplosion(player, x, y, z, w.rand.nextInt(3) + 2, false, false);
			break;
		case 4:
			player.addChatComponentMessage(new ChatComponentText("Diamonds to You!!"));
			EntityItem diamonds = new EntityItem(w,x + 2,y + 3,z,new ItemStack(Items.diamond, 5));
			w.spawnEntityInWorld(diamonds);
			break;
		case 5:
			for(int fx = 0; fx < 2; fx++){
				for(int fy = 0; fy < 2; fy++){
					for(int fz = 0; fz < 2; fz++){
						EntityTNTPrimed egg = new EntityTNTPrimed(w, x + fx, y + fy, z + fz, null);
						w.spawnEntityInWorld(egg);
					}
				}
			}
			break;
		case 6:
			player.inventory.dropAllItems();
			break;
		case 7:
			target.heal(target.getMaxHealth());
			break;
		case 8:
			target.motionY += 5;
			break;
		case 9:
			target.setCustomNameTag(EnumChatFormatting.LIGHT_PURPLE + "Magic Man!");
			player.setCustomNameTag("Random Guy");
			break;
		case 10:
			for(int fx = 0; fx < 5; fx++){
				for(int fy = 0; fy < 5; fy++){
					for(int fz = 0; fz < 5; fz++){
						EntityEgg egg = new EntityEgg(w, x + fx, y + fy, z + fz);
						w.spawnEntityInWorld(egg);
					}
				}
			}
			break;
		case 11:
			int px = player.getPosition().getX();
			int py = player.getPosition().getY();
			int pz = player.getPosition().getZ();
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 600, 0));
			player.addPotionEffect(new PotionEffect(Potion.jump.id, 600, 0));
			break;
		case 12:
			if(w.rand.nextInt(4) == 0)
				w.spawnEntityInWorld(BossSpawn.createBossZombie(w, new BlockPos(x, y, z)));
			break;
		case 13:
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.BLUE + "LOOK!"));
			player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 400, 254));
			target.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 400, 254));
			break;
		case 14:
			for(int i = 0; i < 5; i++){
				EntityArrow arrow = new EntityArrow(w, x + i, y + i, z + i);
				w.spawnEntityInWorld(arrow);
			}
			break;
		case 15:
			for(int fx = 0; fx < 4; fx++){
				for(int fy = 0; fy < 2; fy++){
					for(int fz = 0; fz < 4; fz++){
						w.setBlockState(new BlockPos(x + fx, y + fy, z + fz), Blocks.web.getDefaultState());
					}
				}
			}
			break;
		case 16:
			for(int fx = 0; fx < 2; fx++){
				for(int fy = 0; fy < 2; fy++){
					for(int fz = 0; fz < 2; fz++){
						w.setBlockState(new BlockPos(x + fx, y + fy, z + fz), Blocks.water.getDefaultState());
					}
				}
			}
			break;
		case 17:
			player.setHealth(1);
			target.setHealth(1);
			break;
		case 18:
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.BLACK + "Smoke Bomb!"));
			player.addPotionEffect(new PotionEffect(Potion.blindness.id, 200, 0));
			target.addPotionEffect(new PotionEffect(Potion.invisibility.id, 300, 0));
			break;
		case 19:
			w.newExplosion(player, x, y, z, 2.1f, false, true);
			break;
		case 20:
			for(int i = 0; i < 2; i++){
				EntityPotion pois = new EntityPotion(w, x + i, y + 3, z, 16424);
				w.spawnEntityInWorld(pois);
				
			}
			break;
		case 21:
			for(int i = 0; i < 2; i++){
				BlockPos pos = player.getPosition();
				EntityPotion pois = new EntityPotion(w, pos.getX()+ i, pos.getY() + 3, pos.getZ(), 16449);
				w.spawnEntityInWorld(pois);
		}
			break;
		case 22:
			target.addPotionEffect(new PotionEffect(Potion.blindness.id, 200, 0));
			player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 300, 0));
			break;
		case 23:
			for(int fx = 0; fx < 4; fx++){
				for(int fz = 0; fz < 4; fz++){
					w.setBlockState(new BlockPos(x + fx, y , z + fz), Blocks.fire.getDefaultState());
				}
			}
			break;
		case 24:
			
			break;
		case 25:
			break;
		case 26:
			break;
		case 27:
			break;
		case 28:
			for(int i = 0; i < 2; i++){
				BlockPos pos = player.getPosition();
				EntityPotion pois = new EntityPotion(w, pos.getX()+ i, pos.getY() + 3, pos.getZ(), 16421);
				w.spawnEntityInWorld(pois);
		}
			break;
		}
	}

}
