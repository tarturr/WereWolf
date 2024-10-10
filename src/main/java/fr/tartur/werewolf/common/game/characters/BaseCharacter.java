package fr.tartur.werewolf.common.game.characters;

import fr.tartur.werewolf.common.game.GameInstance;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.bukkit.entity.Player;

/**
 * Class representing a playable character in the game.
 */
@Getter
@Accessors(fluent = true)
public abstract class BaseCharacter {

    /**
     * The character's raw name.
     */
    private final String name;

    /**
     * The {@code CharacterType} associated with this character.
     * @see CharacterType
     */
    private final CharacterType type;

    /**
     * The {@code Player} which incarnates the character.
     * @see Player
     */
    private final Player player;

    /**
     * The class constructor, only usable by its child classes which will have to set the character name as a
     * {@code String} and its type as a {@code CharacterType}.
     * @param name The character's raw name.
     * @param type The character's type.
     * @see CharacterType
     */
    protected BaseCharacter(String name, CharacterType type, Player player) {
        this.name = name;
        this.type = type;
        this.player = player;
    }

    /**
     * The method that will be called when it's the character's turn.
     * @param gameInstance The running game as a {@code GameInstance}.
     * @see GameInstance
     */
    public abstract void play(GameInstance gameInstance);

}
