package mods.me.minecraft4455.dmt2;

import java.util.logging.Logger;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import mods.me.minecraft4455.dmt2.core.CommonProxy;
import mods.me.minecraft4455.dmt2.core.Dmt2Config;
import mods.me.minecraft4455.dmt2.core.GuiHandler;
import mods.me.minecraft4455.dmt2.core.block.BlockWorkBenchWoodenHull;
import mods.me.minecraft4455.dmt2.core.block.BlockWriter;
import mods.me.minecraft4455.dmt2.core.lib.Reference;
import mods.me.minecraft4455.dmt2.core.tileentitys.TileWriter;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

    @Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION_NUMBER)
    @NetworkMod(clientSideRequired = true, serverSideRequired = false)
    public class DarkMagicTech2 {
        private GuiHandler guiHandler = new GuiHandler();
        @Instance
        public static DarkMagicTech2 instance;
        @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
        public static CommonProxy proxy;
        public static Logger logger;
      
        /*
         * Blocks
         */
        public static Block Writer;
        public static Block WorkBenchWoodenHull;
        /*
         * Blocks end
         */
        @PreInit
        public void preInit(FMLPreInitializationEvent event) {
            logger = Logger.getLogger(Reference.MOD_ID);
            logger.setParent(FMLLog.getLogger());

            Configuration config = new Configuration(
                          event.getSuggestedConfigurationFile());
            Dmt2Config.load(config);
            proxy.registerRenderThings();
            proxy.registerSoundHandler();
        }
        
        @Init
        public void init(FMLInitializationEvent event) {
            /*
             * Register things
             */
            NetworkRegistry.instance().registerGuiHandler(instance, guiHandler);
            /*
             * Blocks
             */
            Writer = new BlockWriter(Dmt2Config.WriterID);
            GameRegistry.registerTileEntity(TileWriter.class, "Writer");
            GameRegistry.registerBlock(Writer, "WorkBench Creator");
            LanguageRegistry.addName(Writer,  "WorkBench Creator");
            WorkBenchWoodenHull = new BlockWorkBenchWoodenHull(Dmt2Config.WorkBenchWoodenHullID);
            GameRegistry.registerBlock(WorkBenchWoodenHull, "WorkBenchWoodenHull");
            LanguageRegistry.addName(WorkBenchWoodenHull, "WorkBench Wooden Hull");
            /*
             * Recipes
             */
            GameRegistry.addRecipe(new ItemStack(Writer), " B ", "WCW", "SWS", 'S', Item.stick, 'C', Block.workbench, 'B', Item.book, 'W', Block.planks);
            
        }
        
        @PostInit
        public void postInit(FMLPostInitializationEvent event) {

        }
     
}
