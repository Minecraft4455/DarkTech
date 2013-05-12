package mods.me.minecraft4455.darktech.core.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.me.minecraft4455.darktech.DarkTech;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemObsidianRod extends Item {
	public ItemObsidianRod(int id) {
		super(id);
		this.setCreativeTab(DarkTech.tabDtitems);
		this.setUnlocalizedName("ObsidianRod");
	}

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("minecraft4455:ObsidianRod");
    }
}
