package mods.me.minecraft4455.darktech.client.gui;

import org.lwjgl.opengl.GL11;

import mods.me.minecraft4455.darktech.core.items.ItemDarkTechHandBook;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.src.ModLoader;

	public class GuiDarkTechHandBook extends GuiScreen {
		public final int xSizeOfTexture = 176;
		public final int ySizeOfTexture = 88;
		
		public GuiDarkTechHandBook(InventoryPlayer inventory, ItemDarkTechHandBook item) {
			// TODO Auto-generated constructor stub
		}
		@Override
		public void drawScreen(int x, int y, float f)
		{
		drawDefaultBackground();

		@SuppressWarnings("unused")
		int var4 = this.mc.renderEngine.getTexture("/Block/changeColorGUI.png");
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture("/mods/minecraft4455/textures/gui/DarkTechHandBook.png");

		int posX = (this.width - xSizeOfTexture) / 3;
		int posY = (this.height - ySizeOfTexture) / 4;

		drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);

		super.drawScreen(x, y, f);
		}
		
		@SuppressWarnings("unchecked")
		public void initGui() {
	        buttonList.clear();
	        buttonList.add(new GuiButton(1, width / 2 + 2, height / 2 + 20, 98, 20, "Make it Rain"));
	        buttonList.add(new GuiButton(2, width / 2 - 100, height / 2 + 20, 98, 20, "Stop the Rain"));
	 
	            }
	 
	    protected void actionPerformed(GuiButton guibutton)
	    {
	        if(guibutton.id == 1)
	        {
	                ModLoader.getMinecraftInstance().theWorld.setRainStrength(5F); 
	               
	        }
	        if(guibutton.id == 2)
	        {
	                ModLoader.getMinecraftInstance().theWorld.setRainStrength(0F); 
	       
	        }
	 
	    }
	    
	    public void updateScreen() {
	    	
	    }
	    
	    public boolean doesGuiPauseGame()
	    {
	        return false;
	    }
	
		
}