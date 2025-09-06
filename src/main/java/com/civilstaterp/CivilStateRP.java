package com.civilstaterp;

import com.civilstaterp.client.ClientProxy;
import com.civilstaterp.common.CommonProxy;
import com.civilstaterp.core.database.DatabaseManager;
import com.civilstaterp.core.init.*;
import com.civilstaterp.core.network.NetworkHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Main mod class for CivilStateRP - Half-Life 2 Roleplay Mod
 * 
 * This mod provides a comprehensive roleplay experience inspired by Half-Life 2,
 * featuring advanced GUI systems, profession mechanics, loyalty systems, and more.
 */
@Mod(CivilStateRP.MOD_ID)
public class CivilStateRP {
    
    public static final String MOD_ID = "civilstaterp";
    public static final String MOD_NAME = "CivilStateRP";
    public static final String VERSION = "1.0.0";
    
    public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);
    
    public static CivilStateRP instance;
    public static CommonProxy proxy;
    
    public CivilStateRP() {
        instance = this;
        
        // Initialize proxy
        proxy = DistExecutor.unsafeRunForDist(
            () -> ClientProxy::new,
            () -> CommonProxy::new
        );
        
        // Register deferred registers
        ModContainers.CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModTileEntities.TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModEntities.ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        com.civilstaterp.core.audio.ModSounds.SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        com.civilstaterp.core.particles.ModParticles.PARTICLES.register(FMLJavaModLoadingContext.get().getModEventBus());
        
        // Register mod event bus
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::createEntityAttributes);
        
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        
        LOGGER.info("CivilStateRP mod loading...");
    }
    
    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("CivilStateRP common setup");
        
        // Initialize network handler
        NetworkHandler.init();
        
        // Initialize database
        DatabaseManager.init();
        
        // Initialize dialogue system
        com.civilstaterp.core.dialogue.DialogueManager.loadDialogues();
        
        // Register event handlers
        proxy.init();
        
        LOGGER.info("CivilStateRP common setup completed");
    }
    
    private void clientSetup(final FMLClientSetupEvent event) {
        LOGGER.info("CivilStateRP client setup");
        proxy.clientInit();
    }
    
    private void serverSetup(final FMLDedicatedServerSetupEvent event) {
        LOGGER.info("CivilStateRP server setup");
        proxy.serverInit();
    }
    
    /**
     * Register entity attributes for all custom entities
     */
    private void createEntityAttributes(final EntityAttributeCreationEvent event) {
        LOGGER.info("Registering entity attributes...");
        
        // Register attributes for NPC entities that can move
        event.put(ModEntities.CRIMINAL_NPC.get(), 
            com.civilstaterp.core.entities.CriminalNPCEntity.createAttributes().build());
        event.put(ModEntities.VORTIGAUNT.get(), 
            com.civilstaterp.core.entities.VortigauntEntity.createAttributes().build());
        
        // Register attributes for stationary NPCs
        event.put(ModEntities.PROFESSION_NPC.get(), 
            com.civilstaterp.core.npc.ProfessionNPC.createAttributes().build());
        event.put(ModEntities.GSR_CHIEF_NPC.get(), 
            com.civilstaterp.core.npc.GSRChiefNPC.createAttributes().build());
        event.put(ModEntities.QUARTERMASTER_NPC.get(), 
            com.civilstaterp.core.npc.QuartermasterNPC.createAttributes().build());
        
        // Register attributes for flying entities
        event.put(ModEntities.CITY_SCANNER.get(), 
            com.civilstaterp.core.entities.CityScannerEntity.createAttributes().build());
        
        LOGGER.info("Entity attributes registered successfully.");
    }
}