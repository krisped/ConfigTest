package com.krisped;

import net.runelite.client.ui.PluginPanel;
import javax.swing.*;
import java.awt.*;

public class TestPanel extends PluginPanel
{
    private final TestConfig config;

    public TestPanel(TestConfig config)
    {
        this.config = config;
        setLayout(new BorderLayout());

        // 🔹 Hovedtittel
        JLabel title = new JLabel("Test Plugin Panel", SwingConstants.CENTER);
        add(title, BorderLayout.NORTH);

        // 🔹 Faner (Tabbed UI)
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("General", createGeneralTab());
        tabbedPane.addTab("Advanced", createAdvancedTab());
        add(tabbedPane, BorderLayout.CENTER);
    }

    private JPanel createGeneralTab()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        // 🔹 Knapp med bilde
        JButton button = new JButton("Click me", new ImageIcon("icon.png"));
        panel.add(button);

        // 🔹 Toggler-knapp
        JToggleButton toggleButton = new JToggleButton("Enable");
        panel.add(toggleButton);

        // 🔹 Numerisk spinner
        JSpinner spinner = new JSpinner(new SpinnerNumberModel(50, 1, 100, 1));
        panel.add(spinner);

        return panel;
    }

    private JPanel createAdvancedTab()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        // 🔹 Multi-choice liste
        JList<String> list = new JList<>(new String[]{"Option 1", "Option 2", "Option 3"});
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        panel.add(new JScrollPane(list));

        return panel;
    }
}
