package fr.tartur.werewolf.items.common;

import fr.tartur.werewolf.items.common.gui.GUI;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.experimental.Accessors;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.event.Event;

import java.util.List;

/**
 * Class representing a single {@code GUI} component.
 */
@Builder(toBuilder = true)
@Accessors(fluent = true)
@Getter
public class ClickableItem<T extends Event> {

    /**
     * The display name of the component as a {@code Component}.
     * Default value: {@code Component.text("")}.
     * @see Component
     */
    @Builder.Default
    private Component name = Component.text("");

    /**
     * The {@code Material} of the component.
     * @see Material
     */
    private Material material;

    /**
     * Enable the glowing effect on the component (which means it will act as if it had an invisible enchantment).
     */
    @Builder.Default
    private boolean glowEffect = true;

    /**
     * The amount of components in the same stack.
     * Default value: {@code 1}
     */
    @Builder.Default
    private int amount = 1;

    /**
     * The description of the component when the mouse hovers it. Each description line is a {@code Component}.
     * @see Component
     */
    @Singular("descriptionLine")
    private List<Component> description;

    /**
     * The X coordinate of the component in the {@code GUI}. Be aware that if the coordinate is out of bounds of the GUI
     * width (9, starting to 0), this will throw an {@code InvalidGUICoordinatesException}.
     * @see GUI
     * @see fr.tartur.werewolf.exception.InvalidGUICoordinatesException
     */
    private int x;

    /**
     * The Y coordinate of the component in the {@code GUI}. Be aware that if the coordinate is out of bounds of the GUI
     * height (starting to 0), this will throw an {@code InvalidGUICoordinatesException}.
     * @see GUI
     * @see fr.tartur.werewolf.exception.InvalidGUICoordinatesException
     */
    private int y;

    /**
     * The callback {@code Clickable<? extends Event>} which has to be called when the {@code GUIItem} is clicked by
     * a player. Its parameter is an instance of {@code InventoryClickEvent}, and returns nothing.
     * @see Clickable
     */
    private final Clickable<T> onPress;

    /**
     * Copy constructor only visible for children classes.
     * @param copy The {@code ClickableItem} (often just a ClickableItem.builder() call) which will be copied to the
     *             child class.
     */
    protected ClickableItem(ClickableItem<T> copy) {
        this.name = copy.name;
        this.material = copy.material;
        this.glowEffect = copy.glowEffect;
        this.amount = copy.amount;
        this.description = copy.description;
        this.x = copy.x;
        this.y = copy.y;
        this.onPress = copy.onPress;
    }

}
