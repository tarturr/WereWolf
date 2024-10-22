package fr.tartur.werewolf.items.common;

import fr.tartur.werewolf.items.common.gui.GUIAdapter;
import lombok.Builder;
import org.bukkit.event.player.PlayerInteractEvent;

@Builder
public class ClickableItemInventoryOpener<G extends GUIAdapter> extends ClickableItem<PlayerInteractEvent> {

    private record Action<G extends GUIAdapter>(G gui) implements Clickable<PlayerInteractEvent> {
        @Override
        public void onLeftClick(PlayerInteractEvent event) {
        }

        @Override
        public void onRightClick(PlayerInteractEvent event) {
            event.getPlayer().openInventory(this.gui.getInventory());
        }
    }

    public ClickableItemInventoryOpener(ClickableItem<PlayerInteractEvent> clickableItem, G gui) {
        super(clickableItem.toBuilder()
                .onPress(new Action<>(gui))
                .build());
    }

}
