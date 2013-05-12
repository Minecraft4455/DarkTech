package mods.me.minecraft4455.darktech.core.items;

import mods.me.minecraft4455.darktech.DarkTech;
import mods.me.minecraft4455.darktech.core.lib.GUIIDS;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDarkTechHandBook extends Item {
	public ItemDarkTechHandBook(int id) {
		super(id);
		this.setUnlocalizedName("DarkTechHandBook");
		this.setMaxStackSize(1);
		this.setCreativeTab(DarkTech.tabDtitems);
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		par3EntityPlayer.openGui(DarkTech.instance , GUIIDS.DarkTechHandBook, par2World, 0, 0, 0);
		return par1ItemStack;
	}

}
