package mike.minecraft.elementsmod.util;

public interface IMetadata {
	
	String getName();
	default String getNameFromDamage(int metadata) {return getName();}

}
