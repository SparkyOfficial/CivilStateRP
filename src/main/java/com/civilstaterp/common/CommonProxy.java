package com.civilstaterp.common;

import com.civilstaterp.core.events.ServerEventHandler;
import net.minecraftforge.common.MinecraftForge;

/**
 * Common proxy for shared client-server functionality
 */
public class CommonProxy {
    
    public void init() {
        // Register common event handlers
        MinecraftForge.EVENT_BUS.register(new ServerEventHandler());
    }
    
    public void clientInit() {
        // Override in ClientProxy
    }
    
    public void serverInit() {
        // Server-specific initialization
    }
}