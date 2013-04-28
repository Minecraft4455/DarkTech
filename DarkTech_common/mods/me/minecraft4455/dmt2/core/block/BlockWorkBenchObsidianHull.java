package mods.me.minecraft4455.dmt2.core.block;

import mods.me.minecraft4455.dmt2.DarkMagicTech2;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockWorkBenchObsidianHull extends Block {
    public BlockWorkBenchObsidianHull(int id) {
        super(id, Material.iron);
        this.setResistance(5F);
        this.setHardness(5F);
        this.setUnlocalizedName("WorkBenchObsidianHull");
        this.setCreativeTab(DarkMagicTech2.tabDtblocks);
        this.setStepSound(soundWoodFootstep);
    }
    public void registerIcons(IconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon("minecraft4455:WorkBenchObsidianHull");
    }
}
