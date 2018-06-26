package mike.minecraft.elementsmod.proxy;

import static com.google.common.collect.Maps.immutableEntry;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.armor.ArmorRegistry;
import mike.minecraft.elementsmod.blocks.BlockManager;
import mike.minecraft.elementsmod.entity.EntityAttackGiantZombie;
import mike.minecraft.elementsmod.entity.EntityElementMaster;
import mike.minecraft.elementsmod.entity.EntityLuckyCreeper;
import mike.minecraft.elementsmod.entity.EntityRandomSlime;
import mike.minecraft.elementsmod.items.ItemManager;
import mike.minecraft.elementsmod.rm.ModelElementMaster;
import mike.minecraft.elementsmod.rm.RenderElementMaster;
import mike.minecraft.elementsmod.rm.RenderLuckyCreeper;
import mike.minecraft.elementsmod.rm.TELanternRender;
import mike.minecraft.elementsmod.rm.TESpawnRenderer;
import mike.minecraft.elementsmod.throwables.EntityElementsPearl;
import mike.minecraft.elementsmod.throwables.EntityFlameOrb;
import mike.minecraft.elementsmod.throwables.EntityHarmGrenade;
import mike.minecraft.elementsmod.throwables.EntityNuke;
import mike.minecraft.elementsmod.throwables.EntityUnluckyPotion;
import mike.minecraft.elementsmod.throwables.EntityWeakGrenade;
import mike.minecraft.elementsmod.throwables.ExStarThrowable;
import mike.minecraft.elementsmod.tileentity.TileEntityLantern;
import mike.minecraft.elementsmod.tileentity.TileEntitySpawn;
import mike.minecraft.elementsmod.tools.ToolManager;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelCreeper;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderGiantZombie;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderSlime;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class CilentProxy extends CommonProxy{

	@Override
	public void renderItems() {
		Map<IMetadata, int[]> itemsToRender = addEntriesToMap(
				immutableEntry(ItemManager.piece, IntStream.range(0, 6).toArray()), immutableEntry(ItemManager.crystals, IntStream.range(0, 7).toArray()),
				immutableEntry(ItemManager.rewards, new int[] {0}), immutableEntry(ItemManager.iron, new int[] {0}),
				immutableEntry(ItemManager.mana, IntStream.range(0, 3).toArray()), immutableEntry(ItemManager.exStar, new int[] {0}),
				immutableEntry(ItemManager.ePearl, new int[] {0}), immutableEntry(ItemManager.meal, new int[] {0}),
				immutableEntry(ItemManager.flame, new int[] {0}), immutableEntry(ItemManager.spawn, IntStream.range(0, 2).toArray()),
				immutableEntry(ItemManager.apple, IntStream.range(0, 2).toArray()), immutableEntry(ItemManager.boss, IntStream.range(0, 10).toArray()),
				immutableEntry(ItemManager.lp, new int[] {0}), immutableEntry(ItemManager.up, new int[] {0}), immutableEntry(ItemManager.lep, new int[] {0}),
				immutableEntry(ItemManager.dn, new int[] {0}), immutableEntry(ItemManager.cd, IntStream.range(0, 5).toArray()),
				immutableEntry(ItemManager.pgw, new int[] {0}), immutableEntry(ItemManager.pgh, new int[] {0}), immutableEntry(ItemManager.cb, new int[] {0}),
				immutableEntry(ItemManager.nuke, new int[] {0}), immutableEntry(ItemManager.portal, new int[] {0}), immutableEntry(ArmorRegistry.nb, new int[] {0}),
				immutableEntry(ArmorRegistry.eHelm, new int[] {0}), immutableEntry(ArmorRegistry.eChest, new int[] {0}), immutableEntry(ArmorRegistry.eLegs, new int[] {0}),
				immutableEntry(ArmorRegistry.eBoots, new int[] {0}), immutableEntry(ArmorRegistry.eh, new int[] {0}), immutableEntry(ArmorRegistry.ec, new int[] {0}),
				immutableEntry(ArmorRegistry.el, new int[] {0}), immutableEntry(ArmorRegistry.eb, new int[] {0}), immutableEntry(ArmorRegistry.cc, new int[] {0}));
		RenderItem item = Minecraft.getMinecraft().getRenderItem();
		
		for(Map.Entry<IMetadata, int[]> immutableEntry : itemsToRender.entrySet()) {
			Item mcItem = (Item) immutableEntry.getKey(); // works because all Items in the map are of type IMetadata
			for(int meta : immutableEntry.getValue()) 
				item.getItemModelMesher().register(mcItem, meta, 
						new ModelResourceLocation(ElementsMod.MODID + ":" + immutableEntry.getKey().getNameFromDamage(meta), "inventory"));
		}
	}
	
	@Override
	public void renderBlocks(){
		IMetadata[] blocksToRender = new IMetadata[] {BlockManager.wore, BlockManager.noce, BlockManager.eco,
				BlockManager.spawn, BlockManager.lco, BlockManager.leo, BlockManager.elb, BlockManager.leb,
				BlockManager.ub, BlockManager.lantern, BlockManager.bco, BlockManager.fdb, BlockManager.bsb,
				BlockManager.brc, BlockManager.ao};
		RenderItem item = Minecraft.getMinecraft().getRenderItem();
		
		for(IMetadata block : blocksToRender) {
			Item mcItem = Item.getItemFromBlock((Block) block);
			item.getItemModelMesher().register(mcItem, 0, 
					new ModelResourceLocation(ElementsMod.MODID + ":" + block.getName(), "inventory"));
		}
	}
	
	@Override
	public void renderTools() {
		IMetadata[] toolsToRender = new IMetadata[] {ToolManager.wcs, ToolManager.ws, ToolManager.es,
				ToolManager.multi, ToolManager.estaff, ToolManager.nstaff, ToolManager.hammer,
				ToolManager.np, ToolManager.is, ToolManager.ls, ToolManager.lp, ToolManager.ep,
				ToolManager.ebs, ToolManager.ebs, ToolManager.icb, ToolManager.tac, ToolManager.cs,
				ToolManager.cp, ToolManager.as};
		RenderItem item = Minecraft.getMinecraft().getRenderItem();
		
		for(IMetadata tool : toolsToRender) {
			item.getItemModelMesher().register((Item) tool, 0, 
					new ModelResourceLocation(ElementsMod.MODID + ":" + tool.getName(), "inventory"));
		}
	}
	
	@Override
	public void registerEntities(){
		RenderItem item = Minecraft.getMinecraft().getRenderItem();
		
		// entities and throwables
		RenderingRegistry.registerEntityRenderingHandler(EntityElementMaster.class, 
				new RenderElementMaster(new ModelElementMaster(), 0.5f));
		RenderingRegistry.registerEntityRenderingHandler(EntityLuckyCreeper.class, 
				new RenderLuckyCreeper(new ModelCreeper(), 0.5f));
		RenderingRegistry.registerEntityRenderingHandler(ExStarThrowable.class, 
				new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), ItemManager.exStar, item));
		RenderingRegistry.registerEntityRenderingHandler(EntityElementsPearl.class, 
				new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), ItemManager.ePearl, item));		
		RenderingRegistry.registerEntityRenderingHandler(EntityAttackGiantZombie.class, 
				new RenderGiantZombie(Minecraft.getMinecraft().getRenderManager(), new ModelZombie(), 0.5f, 4));
		RenderingRegistry.registerEntityRenderingHandler(EntityFlameOrb.class,
				new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), ItemManager.flame, item));
		RenderingRegistry.registerEntityRenderingHandler(EntityUnluckyPotion.class,
				new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), ItemManager.up, item));
		RenderingRegistry.registerEntityRenderingHandler(EntityRandomSlime.class,
				new RenderSlime(Minecraft.getMinecraft().getRenderManager(), new ModelSlime(5), 2f));
		RenderingRegistry.registerEntityRenderingHandler(EntityWeakGrenade.class,
				new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), ItemManager.pgw, item));
		RenderingRegistry.registerEntityRenderingHandler(EntityHarmGrenade.class, 
				new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), ItemManager.pgh, item));
		RenderingRegistry.registerEntityRenderingHandler(EntityNuke.class, 
				new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), ItemManager.nuke, item));
		
	    // tile entities
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySpawn.class, 
				new TESpawnRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLantern.class, 
				new TELanternRender());
	}
	
	private <K, V> Map<K, V> addEntriesToMap(Map.Entry<? extends K, ? extends V>... entries) {
		Map<K, V> metaMap = new HashMap<>(entries.length);
		
		for(Map.Entry<? extends K, ? extends V> entry : entries) {
			metaMap.put(entry.getKey(), entry.getValue());
		}
		return Collections.unmodifiableMap(metaMap);
	}
	
	

}
