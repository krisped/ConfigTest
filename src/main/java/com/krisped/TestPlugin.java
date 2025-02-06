package com.krisped;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
        name = "Test Plugin",
        description = "A plugin that demonstrates all possible UI elements",
        tags = {"test", "UI", "config", "sidepanel"}
)
public class TestPlugin extends Plugin
{
    @Inject
    private Client client;

    @Inject
    private TestConfig config;

    @Inject
    private OverlayManager overlayManager;

    private TestPanel panel;

    @Provides
    TestConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(TestConfig.class);
    }

    @Override
    protected void startUp() throws Exception
    {
        log.info("Test Plugin started!");
        panel = new TestPanel(config);
    }

    @Override
    protected void shutDown() throws Exception
    {
        log.info("Test Plugin stopped!");
    }

    public PluginPanel getPanel()
    {
        return panel;
    }
}
