package mods.me.minecraft4455.darktech.core.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.me.minecraft4455.darktech.DarkTech;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemIronRod extends Item {
	public ItemIronRod(int id) {
		super(id);
		this.setUnlocalizedName("IronRod");
		this.setCreativeTab(DarkTech.tabDtitems);
	}
	
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("minecraft4455:IronRod");
    }
}
