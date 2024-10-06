package fr.tartur.werewolf.gui.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.experimental.Accessors;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

@Builder
@Accessors(fluent = true)
@Getter
public class GUIItem {

    private final UUID uuid = UUID.randomUUID();

    @Builder.Default
    private Component name = Component.text("");
    private Material material;
    @Builder.Default
    private boolean glowEffect = true;
    @Builder.Default
    private int amount = 1;
    @Singular("descriptionLine")
    private List<Component> description;
    private int x;
    private int y;
    private final Consumer<InventoryClickEvent> onPress;

}
