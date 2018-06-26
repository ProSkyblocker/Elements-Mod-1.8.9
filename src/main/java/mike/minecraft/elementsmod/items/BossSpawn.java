package mike.minecraft.elementsmod.items;

import java.lang.reflect.Field;
import java.util.List;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.entity.EntityRandomSlime;
import mike.minecraft.elementsmod.tools.ToolManager;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BossSpawn extends Item implements IMetadata {
	public static String name = "boss";
	public static String[] metaNames = {"demon", "eboss", "luckwolf", "slimest", "rabbits", 
			"friend", "pal", "lucky", "party", "terror"};
	
	
	public BossSpawn() {
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
		this.setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack){
		/*
		 * returns the normal prefix for getUnlocalizedName() in Item
		 * plus it adds the metadata name at the ending
		 */
		return super.getUnlocalizedName() + "." + metaNames[stack.getItemDamage()];
		
	}
	
	@Override // puts the versions of the item into the creative menu
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item itemIn, CreativeTabs tab, List items) {
		for(int meta = 0; meta < metaNames.length; meta++){
			items.add(new ItemStack(this, 1, meta)); 
		}
	};
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		switch(stack.getMetadata()){
		case 0:
			stack.setStackDisplayName(EnumChatFormatting.BLUE + "Spawn Speedy Demon");
			tooltip.add(EnumChatFormatting.BOLD + "It's a boss!");
			break;
		case 1:
			stack.setStackDisplayName(EnumChatFormatting.RED + "Spawn Super Bob!");
			tooltip.add(EnumChatFormatting.BOLD + "No - It's Super Bob!!!");
			break;
		case 2:
			stack.setStackDisplayName(EnumChatFormatting.GREEN + "Spawn Lucky Wolf");
			tooltip.add(EnumChatFormatting.BOLD + "A helpful friend!");
			break;
		case 3:
			stack.setStackDisplayName(EnumChatFormatting.DARK_GREEN + "Spawn Slime Stack");
			tooltip.add(EnumChatFormatting.BOLD + "A stack of slime!");
			break;
		case 4:
			stack.setStackDisplayName(EnumChatFormatting.YELLOW + "Spawn Rabbit Swarm");
			tooltip.add(EnumChatFormatting.DARK_GRAY + "They're rabbits... they can't hurt you!");
			break;
		case 5:
			stack.setStackDisplayName(EnumChatFormatting.AQUA + "Spawn Friendly Creeper");
			tooltip.add(EnumChatFormatting.DARK_GRAY + "Shh....");
			break;
		case 6:
			stack.setStackDisplayName(EnumChatFormatting.DARK_PURPLE + "Spawn Slime Pet");
			tooltip.add(EnumChatFormatting.BOLD + "Your slimy pet!");
			break;
		case 7:
			stack.setStackDisplayName(EnumChatFormatting.LIGHT_PURPLE + "Spawn Boxer George");
			tooltip.add(EnumChatFormatting.DARK_GRAY + "Trained at the Nether Point Academy...");
			break;
		case 8:
			stack.setStackDisplayName(EnumChatFormatting.OBFUSCATED + "Spawn PARTAY!");
			tooltip.add(EnumChatFormatting.DARK_GRAY + "Oh my...");
			break;
		case 9:
			stack.setStackDisplayName(EnumChatFormatting.GOLD + "Spawn Baby Bob!");
			tooltip.add(EnumChatFormatting.DARK_GRAY + "The cool guy on a chicken...");
		}
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side,
			float hitX, float hitY, float hitZ) {
		if(!player.capabilities.isCreativeMode){
			--stack.stackSize;
		}
		
		switch(stack.getMetadata()){
			case 0:
				if(!world.isRemote){
					EntityZombie zomb = createBossZombie(world, pos.up());
					world.spawnEntityInWorld(zomb);
				}
				break;
			case 1:
				if(!world.isRemote){
					EntityZombie zomb = getElementalBoss(world, pos.up());
					world.spawnEntityInWorld(zomb);
				}
				break;
			case 2:
				if(!world.isRemote){
					EntityWolf wolf = getLuckyWolf(player, world, pos.up());
					ItemStack bones = new ItemStack(Items.bone, 20);
					EntityItem enBone = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), bones);
					world.spawnEntityInWorld(wolf);
					world.spawnEntityInWorld(enBone);
				}
				break;
			case 3:
				if(!world.isRemote){
					this.createSlimeStack(world, pos);
				}
				break;
			case 4:
				if(!world.isRemote){
					this.getKillerRabbits(world, pos);
				}
				break;
			case 5:
				if(!world.isRemote){
					world.spawnEntityInWorld(this.createFriendlyCreeper(world, pos));
				}
				break;
			case 6:
				if(!world.isRemote){
					this.createSlimePet(world, pos, player);
				}
				break;
			case 7:
				if(!world.isRemote){
					world.spawnEntityInWorld(this.getLuckySkeleton(world, pos));
				}
				break;
			case 8:
				if(!world.isRemote){
					//world.playSoundAtEntity(player, "elements:boss.final_road", 8.0f, 5.0f);
					this.createParty(world, pos);
				}
				break;
			case 9:
				if(!world.isRemote){
					world.playSoundAtEntity(player, "elements:boss.airship", 8.0f, 5.0f);
					this.createBabyTerror(world, pos);
				}
			}
		return true;
	}

	@Override
	public String getNameFromDamage(int metadata){
		return name + metaNames[metadata];
	}
	
	public void registerVariants(){ // registers the versions of the item
		ModelResourceLocation[] variants = new ModelResourceLocation[metaNames.length];
		for(int i = 0; i < metaNames.length; i++){
			variants[i] = new ModelResourceLocation(ElementsMod.MODID + ":" + getNameFromDamage(i), "inventory");
		}
		ModelBakery.registerItemVariants(ItemManager.boss, variants);
	}
	
	public static EntityZombie createBossZombie(World world, BlockPos pos){
		EntityZombie boss = new EntityZombie(world);
		boss.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
		
		boss.setCustomNameTag(EnumChatFormatting.RED + "Speedy Demon");
		
		boss.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(85.0d);
		boss.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.52d);
		
		ItemStack hurtful = new ItemStack(ToolManager.ebs);
		hurtful.setStackDisplayName(EnumChatFormatting.BLUE + "The Speedy Big Sword");
		hurtful.addEnchantment(Enchantment.knockback, 2);
		hurtful.addEnchantment(Enchantment.sharpness, 2);
		hurtful.addEnchantment(Enchantment.looting, 2);
		
		boss.setCurrentItemOrArmor(0, hurtful);
		
		ItemStack sh = new ItemStack(Items.golden_helmet);
		sh.addEnchantment(Enchantment.unbreaking, 6);
		sh.addEnchantment(Enchantment.protection, 4);
		sh.addEnchantment(Enchantment.respiration, 1);
		sh.addEnchantment(Enchantment.fireProtection, 3);
		sh.setStackDisplayName(EnumChatFormatting.BOLD + "Rich Boss Hat");
		
		boss.setCurrentItemOrArmor(1, sh);
		
		ItemStack sl = new ItemStack(Items.leather_chestplate);
		sl.setStackDisplayName(EnumChatFormatting.DARK_BLUE + "Boss Vest");
		sl.addEnchantment(Enchantment.protection, 7);
		sl.addEnchantment(Enchantment.thorns, 3);
		sl.addEnchantment(Enchantment.projectileProtection, 4);
		sl.addEnchantment(Enchantment.unbreaking, 10);
		sl.addEnchantment(Enchantment.blastProtection, 4);
		
		boss.setCurrentItemOrArmor(2, sl);
		
		ItemStack tl = new ItemStack(Items.leather_leggings);
		tl.setStackDisplayName(EnumChatFormatting.DARK_PURPLE + "Thorny Pants");
		tl.addEnchantment(Enchantment.protection, 5);
		tl.addEnchantment(Enchantment.thorns, 5);
		boss.setCurrentItemOrArmor(3, tl);
		
		ItemStack booties = new ItemStack(Items.chainmail_boots);
		booties.setStackDisplayName(EnumChatFormatting.BOLD + "Basic Enchanted Boots");
		booties.addEnchantment(Enchantment.protection, 4);
		boss.setCurrentItemOrArmor(4, booties);
		
		return boss;
	}
	
	public static EntityWolf getLuckyWolf(EntityPlayer p, World world, BlockPos pos){
		EntityWolf wolf = new EntityWolf(world);
		wolf.setPosition(pos.getX(), pos.getY(), pos.getZ());
		wolf.setCustomNameTag(p.getName() +"'s Lucky Wolf");
		wolf.setCurrentItemOrArmor(0, new ItemStack(Items.diamond_sword));
		wolf.setCurrentItemOrArmor(2, new ItemStack(Items.diamond_chestplate));
		wolf.setCurrentItemOrArmor(1, new ItemStack(Items.diamond_helmet));
		wolf.setCurrentItemOrArmor(3, new ItemStack(Items.diamond_leggings));
		wolf.setCurrentItemOrArmor(4, new ItemStack(Items.diamond_boots));
		
		return wolf;
	}
	
	public static EntityZombie getElementalBoss(World world, BlockPos pos){
		EntityZombie boss = new EntityZombie(world);
		boss.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
		
		boss.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(500.0d);
		boss.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.7f);
		boss.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3f);
		
		ItemStack hurtful = new ItemStack(ToolManager.hammer);
		hurtful.setStackDisplayName(EnumChatFormatting.BLUE + "The Super Hammer!");
		hurtful.addEnchantment(Enchantment.sharpness, 4);
		hurtful.addEnchantment(Enchantment.knockback, 3);
		hurtful.addEnchantment(Enchantment.fireAspect, 1);
		hurtful.addEnchantment(Enchantment.looting, 2);

		boss.setCurrentItemOrArmor(0, hurtful);
		
		ItemStack sh = new ItemStack(Items.diamond_helmet);
		sh.addEnchantment(Enchantment.protection, 2);
		sh.addEnchantment(Enchantment.respiration, 1);
		sh.addEnchantment(Enchantment.fireProtection, 3);
		sh.addEnchantment(Enchantment.blastProtection, 2);
		sh.setStackDisplayName(EnumChatFormatting.BOLD + "Bob's Lucky Hat");
		
		boss.setCurrentItemOrArmor(1, sh);
		
		ItemStack sl = new ItemStack(Items.diamond_chestplate);
		sl.setStackDisplayName(EnumChatFormatting.DARK_BLUE + "Bob's Lucky Diamond Vest");
		sl.addEnchantment(Enchantment.protection, 3);
		sl.addEnchantment(Enchantment.thorns, 2);
		sl.addEnchantment(Enchantment.projectileProtection, 2);
		sl.addEnchantment(Enchantment.blastProtection, 4);
		
		boss.setCurrentItemOrArmor(2, sl);
		
		ItemStack tl = new ItemStack(Items.diamond_leggings);
		tl.setStackDisplayName(EnumChatFormatting.DARK_PURPLE + "Bob's Lucky Pantalones");
		tl.addEnchantment(Enchantment.protection, 2);
		tl.addEnchantment(Enchantment.thorns, 3);
		sl.addEnchantment(Enchantment.projectileProtection, 2);
		sl.addEnchantment(Enchantment.blastProtection, 4);
		boss.setCurrentItemOrArmor(3, tl);
		
		ItemStack sbbots = new ItemStack(Items.diamond_boots);
		sbbots.setStackDisplayName(EnumChatFormatting.AQUA + "Bob's Expensive Shoes");
		sbbots.addEnchantment(Enchantment.protection, 2);
		sbbots.addEnchantment(Enchantment.thorns, 3);
		sl.addEnchantment(Enchantment.projectileProtection, 2);
		sl.addEnchantment(Enchantment.blastProtection, 4);
		
		boss.setCurrentItemOrArmor(4, sbbots);
		boss.addPotionEffect(new PotionEffect(Potion.resistance.id, 5090, 1, true, false));
		boss.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 5090, 1, true, false));
		
		boss.setCustomNameTag(EnumChatFormatting.AQUA + "Super Bob!!");
		
		return boss;
	}
	
	public static void createSlimeStack(World w, BlockPos pos){
		EntityRandomSlime a = new EntityRandomSlime(w);
		a.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
		a.setCustomNameTag(EnumChatFormatting.DARK_GREEN + "Slime Stack!!!");
		a.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0d);;
		a.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.35f);
		EntityRandomSlime b = new EntityRandomSlime(w);
		
		b.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
		b.setCustomNameTag(EnumChatFormatting.DARK_GREEN + "Slime Stack!!!");
		b.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0d);;
		b.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.35f);
		EntityRandomSlime c = new EntityRandomSlime(w);
		
		c.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
		c.setCustomNameTag(EnumChatFormatting.DARK_GREEN + "Slime Stack!!!");
		c.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0d);;
		c.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.35f);
		a.mountEntity(b);
		b.mountEntity(c);
		
		w.spawnEntityInWorld(a);
		w.spawnEntityInWorld(b);
		w.spawnEntityInWorld(c);
	}
	
	public static void getKillerRabbits(World w, BlockPos pos){
		EntityRabbit main = new EntityRabbit(w);
		main.setPosition(pos.getX(), pos.getY() + 2, pos.getZ());
		main.setRabbitType(99);
		main.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 30000, 0, true, false));
		main.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 30000, 1, true, false));
		main.addPotionEffect(new PotionEffect(Potion.jump.id, 30000, 1, true, false));
		main.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(400.0d);
		
		ItemStack wooden = new ItemStack(Items.stone_sword);
		wooden.addEnchantment(Enchantment.unbreaking, 5);
		wooden.addEnchantment(Enchantment.sharpness, 3);
		wooden.addEnchantment(Enchantment.knockback, 2);
		wooden.addEnchantment(Enchantment.smite, 5);
		wooden.setStackDisplayName(EnumChatFormatting.GRAY + "Stone Cane");
		main.setCurrentItemOrArmor(0, wooden);
		
		ItemStack helm = new ItemStack(Items.iron_helmet);
		helm.addEnchantment(Enchantment.protection, 8);
		helm.addEnchantment(Enchantment.thorns, 2);
		helm.addEnchantment(Enchantment.blastProtection, 5);
		helm.addEnchantment(Enchantment.aquaAffinity, 2);
		helm.setStackDisplayName(EnumChatFormatting.RED + "TNT Hater Helmet");
		main.setCurrentItemOrArmor(1, helm);
		
		ItemStack chest = new ItemStack(Items.iron_chestplate);
		chest.addEnchantment(Enchantment.protection, 10);
		chest.addEnchantment(Enchantment.thorns, 5);
		chest.addEnchantment(Enchantment.projectileProtection, 5);
		chest.setStackDisplayName(EnumChatFormatting.BOLD + "Layered Leggings");
		main.setCurrentItemOrArmor(2, chest);
		
		ItemStack legs = new ItemStack(Items.iron_chestplate);
		legs.addEnchantment(Enchantment.protection, 8);
		legs.addEnchantment(Enchantment.thorns, 2);
		legs.addEnchantment(Enchantment.unbreaking, 4);
		legs.setStackDisplayName(EnumChatFormatting.BOLD + "Blockade Chestplate");
		main.setCurrentItemOrArmor(3, legs);
		
		ItemStack boots = new ItemStack(Items.diamond_boots);
		boots.addEnchantment(Enchantment.protection, 13);
		boots.addEnchantment(Enchantment.thorns, 2);
		boots.addEnchantment(Enchantment.unbreaking, 4);
		boots.addEnchantment(Enchantment.depthStrider, 3);
		boots.setStackDisplayName(EnumChatFormatting.ITALIC + "Protected Boots");
		main.setCurrentItemOrArmor(4, boots);
		
		main.setCustomNameTag(EnumChatFormatting.DARK_PURPLE + "The Master Bunny");
		w.spawnEntityInWorld(main);
		
		for(int i = 0; i < 10; i++){
			EntityRabbit r = new EntityRabbit(w);
			r.setCustomNameTag("Cohort");
			r.setCurrentItemOrArmor(1, new ItemStack(Items.diamond_helmet));
			r.setCurrentItemOrArmor(0, new ItemStack(Items.iron_sword));
			r.setRabbitType(99);
			r.setPosition(pos.getX(), pos.getY() + 2, pos.getZ());
			w.spawnEntityInWorld(r);
		}
	}
	
	public static EntityCreeper createFriendlyCreeper(World w, BlockPos pos){
		EntityCreeper c = new EntityCreeper(w);
		String[] names = {"Bob the Friendly Creeper", "Sans the Friendly Creeper", 
				"Papyrus the Friendly Creeper", "Creep the Friendly Creeper"};
		
		c.setPosition(pos.getX(), pos.getY() + 2, pos.getZ());
		c.setCustomNameTag(names[c.getRNG().nextInt(names.length)]);
		try{
			Field fuse = EntityCreeper.class.getDeclaredField("fuseTime");
			fuse.setAccessible(true);
			fuse.set(c, 9000000);
			System.out.println("Creeper fuse time is: " + fuse.get(c));
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			w.spawnEntityInWorld(c);
		}
		return c;
		
	}
	
	public static void createSlimePet(World w, BlockPos pos, EntityPlayer p){
		EntityRandomSlime slime = new EntityRandomSlime(w);
		slime.setPosition(pos.getX(), pos.getY()+ 2, pos.getZ());
		slime.setCustomNameTag(p.getName() + "'s Slime Pet");
		slime.setSlimeSize(1);
		slime.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 4000000, 0, true, false));
		slime.setCurrentItemOrArmor(1, new ItemStack(Items.diamond_helmet));
		slime.setCurrentItemOrArmor(2, new ItemStack(Items.diamond_chestplate));
		slime.setCurrentItemOrArmor(3, new ItemStack(Items.iron_leggings));
		slime.setCurrentItemOrArmor(4, new ItemStack(Items.iron_boots));
		w.spawnEntityInWorld(slime);
	}
	
	public static EntitySkeleton getLuckySkeleton(World w, BlockPos pos){
		EntitySkeleton lucky = new EntitySkeleton(w);
		lucky.setSkeletonType(1);
		lucky.setPosition(pos.getX(), pos.getY() + 2, pos.getZ());
		lucky.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(179.0d);
		lucky.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.28d);
		
		ItemStack luck = new ItemStack(ToolManager.ls);
		luck.addEnchantment(Enchantment.sharpness, 4);
		luck.addEnchantment(Enchantment.knockback, 5);
		luck.addEnchantment(Enchantment.unbreaking, 2);
		luck.addEnchantment(Enchantment.smite, 2);
		luck.setStackDisplayName(EnumChatFormatting.GOLD + "Skull's Lucky Sword");
		lucky.setCurrentItemOrArmor(0, luck);
		
		ItemStack chainh = new ItemStack(Items.chainmail_helmet);
		chainh.addEnchantment(Enchantment.protection, 3);
		chainh.addEnchantment(Enchantment.unbreaking, 2);
		chainh.addEnchantment(Enchantment.blastProtection, 2);
		chainh.setStackDisplayName(EnumChatFormatting.AQUA + "Linked Helmet");
		
		lucky.setCurrentItemOrArmor(1, chainh);
		lucky.setCurrentItemOrArmor(2, new ItemStack(Items.diamond_chestplate));
		
		ItemStack chainl = new ItemStack(Items.chainmail_leggings);
		chainl.addEnchantment(Enchantment.protection, 3);
		chainl.addEnchantment(Enchantment.unbreaking, 2);
		chainl.addEnchantment(Enchantment.projectileProtection, 2);
		chainl.addEnchantment(Enchantment.thorns, 2);
		chainl.setStackDisplayName(EnumChatFormatting.BLUE + "Barbed Pants");
		
		lucky.setCurrentItemOrArmor(3, chainl);
		lucky.setCurrentItemOrArmor(4, new ItemStack(Items.diamond_leggings));
		return lucky;
	}
	
	public static void createParty(World w, BlockPos pos){
		EntityCreeper a = new EntityCreeper(w);
		EntityCreeper b = new EntityCreeper(w);
		a.setPosition(pos.getX() + 1, pos.getY() + 2, pos.getZ());
		b.setPosition(pos.getX() + 1, pos.getY() + 2, pos.getZ());
		a.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 300000, 1));
		b.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 300000, 1));
		try{
			Field fuse = EntityCreeper.class.getDeclaredField("fuseTime");
			fuse.setAccessible(true);
			fuse.set(a, 1);
			fuse.set(b, 1);
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			w.spawnEntityInWorld(a);
			w.spawnEntityInWorld(b);
			w.spawnEntityInWorld(getElementalBoss(w, pos));
			w.spawnEntityInWorld(getElementalBoss(w, pos));
			EntityRandomSlime slime = new EntityRandomSlime(w);
			slime.setPosition(pos.getX() + 1, pos.getY() + 2, pos.getZ());
			slime.setSlimeSize(8);
			w.spawnEntityInWorld(slime);
			w.spawnEntityInWorld(createFriendlyCreeper(w, pos));
		}
	}
	
	public static void createBabyTerror(World w, BlockPos pos){
		EntityZombie babyZomb = new EntityZombie(w);
		babyZomb.setPosition(pos.getX(), pos.getY() + 2, pos.getZ());
		babyZomb.setCustomNameTag("Baby Bob!");
		
		ItemStack worldSword = new ItemStack(ToolManager.wcs);
		worldSword.addEnchantment(Enchantment.fireAspect, 2);
		worldSword.addEnchantment(Enchantment.sharpness, 2);
		worldSword.addEnchantment(Enchantment.smite, 3);
		worldSword.addEnchantment(Enchantment.baneOfArthropods, 3);
		worldSword.setStackDisplayName("A Strong Sword");
		
		babyZomb.setCurrentItemOrArmor(0, worldSword);
		babyZomb.setCurrentItemOrArmor(1, new ItemStack(Items.diamond_helmet));
		babyZomb.setCurrentItemOrArmor(2, new ItemStack(Items.diamond_chestplate));
		babyZomb.setCurrentItemOrArmor(3, new ItemStack(Items.diamond_leggings));
		babyZomb.setCurrentItemOrArmor(4, new ItemStack(Items.diamond_boots));
		babyZomb.setChild(true);
		
		EntityChicken chick = new EntityChicken(w);
		chick.setPosition(pos.getX(), pos.getY() + 2, pos.getZ());
		babyZomb.mountEntity(chick);
		w.spawnEntityInWorld(chick);
		w.spawnEntityInWorld(babyZomb);
	}
	
	@Override
	public String getName(){
		return name;
	}
	

}
