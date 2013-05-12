package mods.me.minecraft4455.darktech.core;

import mods.me.minecraft4455.darktech.client.gui.GuiDarkTechHandBook;
import mods.me.minecraft4455.darktech.client.gui.GuiHullConstructer;
import mods.me.minecraft4455.darktech.client.gui.GuiWriter;
import mods.me.minecraft4455.darktech.core.containers.ContainerHullConstructer;
import mods.me.minecraft4455.darktech.core.containers.ContainerWriter;
import mods.me.minecraft4455.darktech.core.items.ItemDarkTechHandBook;
import mods.me.minecraft4455.darktech.core.lib.GUIIDS;
import mods.me.minecraft4455.darktech.core.tileentitys.TileHullConstructer;
import mods.me.minecraft4455.darktech.core.tileentitys.TileWriter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

  @Override
     public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
    
   if (!world.blockExists(x, y, z))
    return null;

   TileEntity tile = world.getBlockTileEntity(x, y, z);

   switch (ID) {

   case GUIIDS.WriterID:
    if (!(tile instanceof TileWriter))
     return null;
    return new GuiWriter(player.inventory, (TileWriter) tile);
    
   case GUIIDS.HullConstructerID:
	    if (!(tile instanceof TileHullConstructer))
	     return null;
	    return new GuiHullConstructer(player.inventory, (TileHullConstructer) tile);
	    
   case GUIIDS.DarkTechHandBook:
   return new GuiDarkTechHandBook(player.inventory, (ItemDarkTechHandBook)player.inventory.getCurrentItem().getItem());
	default:
    return null;
   }
     }
 
 
   @Override
      public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
     
    if (!world.blockExists(x, y, z))
    return null;

   TileEntity tile = world.getBlockTileEntity(x, y, z);

   switch (ID) {

   case GUIIDS.WriterID:
    if (!(tile instanceof TileWriter))
     return null;
    return new ContainerWriter(player.inventory, (TileWriter) tile);
    
   case GUIIDS.HullConstructerID:
   if (!(tile instanceof TileHullConstructer))
	   return null;
   return new ContainerHullConstructer(player.inventory, (TileHullConstructer) tile);

   default:
    return null;
   }
     
   }
 
}
