package com.civilstaterp.client;

import com.civilstaterp.client.events.ClientEventHandler;
import com.civilstaterp.client.gui.hud.HUDRenderer;
import com.civilstaterp.client.input.KeyBindings;
import com.civilstaterp.client.renderer.entity.CriminalNPCRenderer;
import com.civilstaterp.client.renderer.entity.ProfessionNPCRenderer;
import com.civilstaterp.client.renderer.entity.VortigauntRenderer;
import com.civilstaterp.client.renderer.entity.GSRChiefNPCRenderer;
import com.civilstaterp.client.renderer.entity.QuartermasterNPCRenderer;
import com.civilstaterp.common.CommonProxy;
import com.civilstaterp.client.gui.SuitcaseScreen;
import com.civilstaterp.core.init.ModContainers;
import com.civilstaterp.core.init.ModEntities;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * Client-side proxy for handling client-specific functionality
 */
public class ClientProxy extends CommonProxy {
    
    @Override
    public void init() {
        super.init();
        
        // Register client event handlers
        MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
        MinecraftForge.EVENT_BUS.register(new HUDRenderer());
        
        // Register particle factory handler
        FMLJavaModLoadingContext.get().getModEventBus().register(com.civilstaterp.client.particles.ParticleFactoryRegistry.class);
    }
    
    @Override
    public void clientInit() {
        // Initialize key bindings
        KeyBindings.init();
        
        // Register entity renderers
        registerEntityRenderers();
        
        // Register screen factories and other client-side elements
        registerScreens();
    }
    
    private void registerEntityRenderers() {
        // Register entity renderers for custom NPCs
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.CRIMINAL_NPC.get(), CriminalNPCRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.VORTIGAUNT.get(), VortigauntRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.PROFESSION_NPC.get(), ProfessionNPCRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.GSR_CHIEF_NPC.get(), GSRChiefNPCRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.QUARTERMASTER_NPC.get(), QuartermasterNPCRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.CITY_SCANNER.get(), 
            com.civilstaterp.client.renderer.entity.CityScannerRenderer::new);
    }
    
    private void registerScreens() {
        // Register GUI screen factories
        ScreenManager.registerFactory(ModContainers.SUITCASE.get(), SuitcaseScreen::new);
        
        // TODO: Register other GUI screens as needed:
        // ScreenManager.registerFactory(ModContainers.RADIO.get(), RadioScreen::new);
        // ScreenManager.registerFactory(ModContainers.SEARCH.get(), SearchScreen::new);
    }
}