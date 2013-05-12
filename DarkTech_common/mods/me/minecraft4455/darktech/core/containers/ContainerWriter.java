package mods.me.minecraft4455.darktech.core.containers;


import mods.me.minecraft4455.darktech.DarkTech;
import mods.me.minecraft4455.darktech.core.handler.CraftingManagerWriter;
import mods.me.minecraft4455.darktech.core.tileentitys.TileWriter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerWriter extends Container {

 protected TileWriter tile_entity;
 public InventoryCrafting craftMatrix = new InventoryCrafting(this, 1, 3);
    public IInventory craftResult = new InventoryCraftResult();
    private World worldObj;
    private int posX;
    private int posY;
    private int posZ;
   
    public static int InputSlotNumber = 3; //Number of Slots in the Crafting Grid
    public static int InOutputSlotNumber = InputSlotNumber + 1; //Same plus Output Slot
    public static int InventorySlotNumber = 36; //Inventory Slots (Inventory and Hotbar)
    public static int InventoryOutSlotNumber = InventorySlotNumber + 1; //Inventory Slot Number + Output
    public static int FullSlotNumber = InventorySlotNumber + InOutputSlotNumber; //All slots
    
    
    
    public ContainerWriter(InventoryPlayer inventory, TileWriter tile){
  
   
      this.tile_entity = tile;
            int var6;
            int var7;
            worldObj = tile.worldObj;
            posX = tile.xCoord;
            posY = tile.yCoord;
            posZ = tile.zCoord;
  

            addSlotToContainer(new SlotCrafting(inventory.player, this.craftMatrix, craftResult, 0, 124, 35));
            
            for (var6 = 0; var6 < 1; ++var6)
            {
                for (var7 = 0; var7 < 1; ++var7)
                {
                    this.addSlotToContainer(new Slot(this.craftMatrix, var7 + var6 * 1, 50 + var7 * -10, 13 + var6 * 60));
                }
                for (var7 = 1; var7 < 2; ++var7)
                {
                    this.addSlotToContainer(new Slot(this.craftMatrix, var7 + var6 * 1, 50 + var7 * -29, 13 + var6 * 60));
                }
                for (var7 = 2; var7 < 3; ++var7)
                {
                    this.addSlotToContainer(new Slot(this.craftMatrix, var7 + var6 * 1, 50 + var7 * 15, 13 + var6 * 60));
                }
            }
            

            

            for (var6 = 0; var6 < 3; ++var6)
            {
                for (var7 = 0; var7 < 9; ++var7)
                {
                    this.addSlotToContainer(new Slot(inventory, var7 + var6 * 9 + 9, 8 + var7 * 18, 84 + var6 * 18));
                }
            }

            for (var6 = 0; var6 < 9; ++var6)
            {
                this.addSlotToContainer(new Slot(inventory, var6, 8 + var6 * 18, 142));
            }

            this.onCraftMatrixChanged(this.craftMatrix);
           
           
            
           }

   
    @Override
    public void onCraftMatrixChanged(IInventory par1IInventory){
   craftResult.setInventorySlotContents(0, CraftingManagerWriter.getInstance().findMatchingRecipe(craftMatrix, worldObj));
  }


    @Override
  public void onCraftGuiClosed(EntityPlayer par1EntityPlayer)
  {
   
   super.onCraftGuiClosed(par1EntityPlayer);

   if (worldObj.isRemote)
   {
    return;
   }

   for (int i = 0; i < InputSlotNumber; i++)
   {
    ItemStack itemstack = craftMatrix.getStackInSlotOnClosing(i);

    if (itemstack != null)
    {
     par1EntityPlayer.dropPlayerItem(itemstack);
    }
   }
   
  }

    
    @Override
  public boolean canInteractWith(EntityPlayer par1EntityPlayer){
   if (worldObj.getBlockId(posX, posY, posZ) != DarkTech.Writer.blockID){
    return false;
   }

   return par1EntityPlayer.getDistanceSq((double)posX + 0.5D, (double)posY + 0.5D, (double)posZ + 0.5D) <= 64D;
  }
     
    
   @Override
   public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
     {
         ItemStack var3 = null;
         Slot var4 = (Slot)this.inventorySlots.get(par2);

         if (var4 != null && var4.getHasStack())
         {
             ItemStack var5 = var4.getStack();
             var3 = var5.copy();

             if (par2 == 0)
             {
                 if (!this.mergeItemStack(var5, InOutputSlotNumber, FullSlotNumber, true))
                 {
                     return null;
                 }

                 var4.onSlotChange(var5, var3);
             }
             else if (par2 >= InOutputSlotNumber && par2 < InventoryOutSlotNumber)
             {
                 if (!this.mergeItemStack(var5, InventoryOutSlotNumber, FullSlotNumber, false))
                 {
                     return null;
                 }
             }
             else if (par2 >= InventoryOutSlotNumber && par2 < FullSlotNumber)
             {
                 if (!this.mergeItemStack(var5, InOutputSlotNumber, InventoryOutSlotNumber, false))
                 {
                     return null;
                 }
             }
             else if (!this.mergeItemStack(var5, InOutputSlotNumber, FullSlotNumber, false))
             {
                 return null;
             }

             if (var5.stackSize == 0)
             {
                 var4.putStack((ItemStack)null);
             }
             else
             {
                 var4.onSlotChanged();
             }

             if (var5.stackSize == var3.stackSize)
             {
                 return null;
             }

             var4.onPickupFromSlot(par1EntityPlayer, var5);
         }

         return var3;
     }
}
