package mike.minecraft.elementsmod.entity;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.throwables.EntityElementsPearl;
import mike.minecraft.elementsmod.throwables.EntityFlameOrb;
import mike.minecraft.elementsmod.throwables.EntityHarmGrenade;
import mike.minecraft.elementsmod.throwables.ExStarThrowable;
import mike.minecraft.elementsmod.throwables.EntityNuke;
import mike.minecraft.elementsmod.throwables.EntityUnluckyPotion;
import mike.minecraft.elementsmod.throwables.EntityWeakGrenade;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ElementsEntityRegistry {
	static int startEntityID = 300;
	
	public static void mainRegistry(){
		new ElementsEntityRegistry().registerEntities();
	}
	
	public void registerEntities(){
		registerEntityEgg(EntityElementMaster.class, 0xD2619E, 0x8FBC8F, "elementmaster", 0);
		registerNaturalSpawning(EntityElementMaster.class, EnumCreatureType.MONSTER);
		
		registerEntityEgg(EntityAttackGiantZombie.class, 0x000080, 0xff0000, "attackgiantzombie", 2);
		registerNaturalSpawning(EntityAttackGiantZombie.class, EnumCreatureType.MONSTER);
		
		registerEntityEgg(EntityLuckyCreeper.class, 0xffd700, 0x3a5f0b, "luckycreeper", 10);
		registerNaturalSpawning(EntityLuckyCreeper.class, EnumCreatureType.MONSTER);
		
		EntityRegistry.registerModEntity(ExStarThrowable.class, "magicthrowable", 1, 
				ElementsMod.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityElementsPearl.class, "elementspearl", 3, 
				ElementsMod.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityFlameOrb.class, "flameorb", 4,
				ElementsMod.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityUnluckyPotion.class, "unluckypotion", 5, 
				ElementsMod.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityRandomSlime.class, "randomslime", 6, 
				ElementsMod.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityWeakGrenade.class, "weakgrenade", 7, 
				ElementsMod.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityHarmGrenade.class, "harmgrenade", 8, 
				ElementsMod.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityNuke.class, "nuke", 9, 
				ElementsMod.instance, 80, 3, true);
	}
	
	
	
	
	public static void registerEntityEgg(Class<? extends Entity> entity,
			int primary, int secondary, String name,  int id){
		
		int uniqueid = getUniqueEntityID();
		EntityList.idToClassMapping.put(uniqueid, entity);
		EntityRegistry.registerModEntity(entity, name, id, 
				ElementsMod.instance, 80, 3, true, primary, secondary);
		
	}
	
	public void registerNaturalSpawning(Class<? extends EntityLiving> entity, EnumCreatureType type){
		for(int i = 0; i < BiomeGenBase.getBiomeGenArray().length; i++){
			if(BiomeGenBase.getBiomeGenArray()[i] != null){
				EntityRegistry.addSpawn(entity, 40, 1, 2, type, BiomeGenBase.getBiomeGenArray()[i]);
			}
		}
	}
	
	public static int getUniqueEntityID(){
		do {
			startEntityID++;
		} while(EntityList.getStringFromID(startEntityID) != null);
		
		return startEntityID;
	}

}
