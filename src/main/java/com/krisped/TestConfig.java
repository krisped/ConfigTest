package com.krisped;

import net.runelite.client.config.*;

import java.awt.*;
import java.time.Duration;
import java.util.EnumSet;

@ConfigGroup("test")
public interface TestConfig extends Config
{
    // 🔹 Hovedkategori
    @ConfigSection(
            name = "Main Settings",
            description = "General settings",
            position = 0
    )
    String mainSettings = "mainSettings";

    // 🔹 Avkrysningsboks (Checkbox)
    @ConfigItem(
            keyName = "checkbox",
            name = "Enable Feature",
            description = "Turn on/off this feature",
            section = mainSettings
    )
    default boolean checkbox() { return false; }

    // 🔹 Dropdown
    @ConfigItem(
            keyName = "dropdown",
            name = "Select Mode",
            description = "Choose an option",
            section = mainSettings
    )
    default TestEnums.Mode dropdown() { return TestEnums.Mode.SIMPLE; }

    // 🔹 Multi-Choice EnumSet
    @ConfigItem(
            keyName = "multiChoice",
            name = "Multi-Select Options",
            description = "Select multiple options",
            section = mainSettings
    )
    default EnumSet<TestEnums.MultiOptions> multiChoice() {
        return EnumSet.noneOf(TestEnums.MultiOptions.class);
    }

    // 🔹 Tekstfelt
    @ConfigItem(
            keyName = "textfield",
            name = "Enter Text",
            description = "Write something here",
            section = mainSettings
    )
    default String textfield() { return "Default Text"; }

    // 🔹 Slider
    @Range(min = 1, max = 100)
    @ConfigItem(
            keyName = "slider",
            name = "Adjust Value",
            description = "Slide to adjust",
            section = mainSettings
    )
    default int slider() { return 50; }

    // 🔹 Fargevelger
    @ConfigItem(
            keyName = "color",
            name = "Choose Color",
            description = "Select a color",
            section = mainSettings
    )
    @Alpha
    default Color color() { return Color.RED; }

    // 🔹 Tidsvelger
    @ConfigItem(
            keyName = "duration",
            name = "Set Timeout",
            description = "Choose a duration",
            section = mainSettings
    )
    default Duration duration() { return Duration.ofSeconds(30); }
}
