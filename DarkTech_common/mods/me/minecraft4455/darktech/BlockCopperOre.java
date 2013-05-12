package mods.me.minecraft4455.darktech;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockCopperOre extends Block {

	public BlockCopperOre(int id) {
		super(id, Material.rock);
		this.setResistance(2F);
		this.setHardness(2F);
		this.setCreativeTab(DarkTech.tabDtblocks);
		this.setUnlocalizedName("CopperOre");
	}
	
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("minecraft4455:CopperOre");
    }
	
}
