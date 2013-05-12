package mods.me.minecraft4455.darktech.core.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.me.minecraft4455.darktech.DarkTech;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemDiamondRod extends Item {
	public ItemDiamondRod(int id) {
		super(id);
		this.setUnlocalizedName("DiamondRod");
		this.setCreativeTab(DarkTech.tabDtitems);
	}
	
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("minecraft4455:DiamondRod");
    }
}
