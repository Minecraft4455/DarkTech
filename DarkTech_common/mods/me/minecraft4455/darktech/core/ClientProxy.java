package mods.me.minecraft4455.darktech.core;

import net.minecraftforge.common.MinecraftForge;
import mods.me.minecraft4455.darktech.core.handler.SoundHandler;

public class ClientProxy extends CommonProxy{
    @Override
    public void registerRenderThings() {
      
    }
    @Override
    public void registerSoundHandler() {
        MinecraftForge.EVENT_BUS.register(new SoundHandler());
    }
}
