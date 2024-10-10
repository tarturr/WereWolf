package fr.tartur.werewolf.common.game;

import fr.tartur.werewolf.common.game.characters.BaseCharacter;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class GameScheduler implements PropertyChangeListener {

    private final DelayedResult<List<BaseCharacter>> roles;

    @Getter
    @Accessors(fluent = true)
    private final RoleDispatcher dispatcher;

    public GameScheduler() {
        this.dispatcher = new RoleDispatcher();
        this.roles = new DelayedResult<>(this.dispatcher, this);
    }

    // TODO: Add a connect(Player player) method to give an item to a Player which opens a menu to choose a
    //  CharacterType. It includes creating a dedicated class which will run code on right-click & creating a new GUI
    //  for the character choice.

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

}
