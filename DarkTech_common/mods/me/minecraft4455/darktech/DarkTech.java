package mods.me.minecraft4455.darktech;

import java.util.logging.Logger;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import mods.me.minecraft4455.darktech.core.CommonProxy;
import mods.me.minecraft4455.darktech.core.Dmt2Config;
import mods.me.minecraft4455.darktech.core.GuiHandler;
import mods.me.minecraft4455.darktech.core.block.BlockHullConstructer;
import mods.me.minecraft4455.darktech.core.block.BlockWorkBenchDiamondHull;
import mods.me.minecraft4455.darktech.core.block.BlockWorkBenchIronHull;
import mods.me.minecraft4455.darktech.core.block.BlockWorkBenchObsidianHull;
import mods.me.minecraft4455.darktech.core.block.BlockWorkBenchWoodenHull;
import mods.me.minecraft4455.darktech.core.block.BlockWriter;
import mods.me.minecraft4455.darktech.core.items.ItemDarkTechHandBook;
import mods.me.minecraft4455.darktech.core.items.ItemDiamondRod;
import mods.me.minecraft4455.darktech.core.items.ItemIronRod;
import mods.me.minecraft4455.darktech.core.items.ItemObsidianRod;
import mods.me.minecraft4455.darktech.core.lib.Reference;
import mods.me.minecraft4455.darktech.core.tileentitys.TileHullConstructer;
import mods.me.minecraft4455.darktech.core.tileentitys.TileWriter;
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
    
    public class DarkTech {
    	
        private GuiHandler guiHandler = new GuiHandler();
        
        @Instance
        public static DarkTech instance;
        
        @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
        public static CommonProxy proxy;
        public static Logger logger;
      
        /*
         * CreativeTabs
         */
        public static CreativeTabs tabDtblocks = new CreativeTabs("tabDtblocks") {
            public ItemStack getIconItemStack() {return new ItemStack(Writer, 1, 0);
            }};
        public static CreativeTabs tabDtitems = new CreativeTabs("tabDtitems") {
            public ItemStack getIconItemStack() {return new ItemStack(Item.eyeOfEnder, 1, 0);
            }};
        
        /*
         * Blocks with GUIs
         */
        public static Block Writer;
        public static Block HullConstructer;
        /*
         * Hulls
         */
        public static Block WorkBenchWoodenHull;
        public static Block WorkBenchIronHull;
        public static Block WorkBenchObsidianHull;
        public static Block WorkBenchDiamondHull;
        /*
         * Ores
         */
        public static Block CopperOre;
        public static Block TinOre;
        
        /*
         * Blocks end
         */
        
        /*
         * Items 
         */
        public static Item DarkTechHandBook;
        public static Item IronRod;
        public static Item ObsidianRod;
        public static Item DiamondRod;
        
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
             * Blocks with GUIs
             */
            Writer = new BlockWriter(Dmt2Config.WriterID);
            GameRegistry.registerTileEntity(TileWriter.class, "Writer");
            GameRegistry.registerBlock(Writer, "WorkBench Creator_Minecraft4455");
            LanguageRegistry.addName(Writer,  "WorkBench Creator");
            HullConstructer = new BlockHullConstructer(Dmt2Config.HullConstructerID);
            GameRegistry.registerTileEntity(TileHullConstructer.class, "HullConstructer");
            GameRegistry.registerBlock(HullConstructer, "HullConstructer_Minecraft4455");
            LanguageRegistry.addName(HullConstructer, "Hull Constructer");

            /*
             * Hulls
             */
            WorkBenchWoodenHull = new BlockWorkBenchWoodenHull(Dmt2Config.WorkBenchWoodenHullID);
            GameRegistry.registerBlock(WorkBenchWoodenHull, "WorkBenchWoodenHull_Minecraft4455");
            LanguageRegistry.addName(WorkBenchWoodenHull, "WorkBench Wooden Hull");
            WorkBenchIronHull = new BlockWorkBenchIronHull(Dmt2Config.WorkBenchIronHullID);
            GameRegistry.registerBlock(WorkBenchIronHull, "WorkBenchIronHull_Minecraft4455");
            LanguageRegistry.addName(WorkBenchIronHull, "WorkBench Iron Hull");
            WorkBenchObsidianHull = new BlockWorkBenchObsidianHull(Dmt2Config.WorkBenchObsidianHullID);
            GameRegistry.registerBlock(WorkBenchObsidianHull, "WorkBenchObsidianHull_Minecraft4455");
            LanguageRegistry.addName(WorkBenchObsidianHull, "WorkBench Obsidian Hull");
            WorkBenchDiamondHull = new BlockWorkBenchDiamondHull(Dmt2Config.WorkBenchDiamondHullID);
            GameRegistry.registerBlock(WorkBenchDiamondHull, "WorkBenchDiamondHull_Minecraft4455");
            LanguageRegistry.addName(WorkBenchDiamondHull, "WorkBench Diamond Hull");
            /*
             * Ores
             */
            CopperOre = new BlockCopperOre(Dmt2Config.CopperOreID);
            GameRegistry.registerBlock(CopperOre, "CopperOre_Minecraft4455");
            LanguageRegistry.addName(CopperOre, "Copper Ore");
            
            
            /*
             * Blocks end
             */
            
            /*
             * Items 
             */
            DarkTechHandBook = new ItemDarkTechHandBook(Dmt2Config.DarkTechHandBookID);
            LanguageRegistry.addName(DarkTechHandBook, "DarkTech HandBook");
            IronRod = new ItemIronRod(Dmt2Config.IronRodID);
            LanguageRegistry.addName(IronRod, "Iron Rod");
            ObsidianRod = new ItemObsidianRod(Dmt2Config.ObsidianRodID);
            LanguageRegistry.addName(ObsidianRod, "Obsidian Rod");
            DiamondRod = new ItemDiamondRod(Dmt2Config.DiamondRodID);
            LanguageRegistry.addName(DiamondRod, "Diamond Rod");
            
            /*
             * Recipes
             */
            GameRegistry.addRecipe(new ItemStack(Writer), " B ", "WCW", "SWS", 'S', Item.stick, 'C', Block.workbench, 'B', Item.book, 'W', Block.planks);
            GameRegistry.addRecipe(new ItemStack(HullConstructer), "WBW", "WCW", "SWS", 'S', IronRod, 'C', Block.workbench, 'B', Item.book, 'W', Item.ingotIron);
            GameRegistry.addRecipe(new ItemStack(IronRod), "  I", " I ", "I  ", 'I', Item.ingotIron);
            GameRegistry.addRecipe(new ItemStack(ObsidianRod), "  O", " O ", "O  ", 'O', Block.obsidian);
            GameRegistry.addRecipe(new ItemStack(DiamondRod), "  D", " D ", "D  ", 'D', Item.diamond);
            
            /*
             * LanguageRegistry
             */
            LanguageRegistry.instance().addStringLocalization("itemGroup.tabDtblocks", "en_US", "DarkTech Blocks");
            LanguageRegistry.instance().addStringLocalization("itemGroup.tabDtitems", "en_US", "DarkTech Items");
            
        }
        
        @PostInit
        public void postInit(FMLPostInitializationEvent event) {

        }
     
}

