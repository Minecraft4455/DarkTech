package mods.me.minecraft4455.dmt2.core.block;

import mods.me.minecraft4455.dmt2.DarkMagicTech2;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockWorkBenchIronHull extends Block {
	public BlockWorkBenchIronHull(int id) {
		super(id, Material.iron);
		this.setResistance(5f);
		this.setHardness(5f);
		this.setCreativeTab(DarkMagicTech2.tabDtblocks);
		this.setStepSound(soundMetalFootstep);
		this.setUnlocalizedName("WorkBenchIronHull");
	}
    public void registerIcons(IconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon("minecraft4455:WorkBenchIronHull");
    }
	
	
}
