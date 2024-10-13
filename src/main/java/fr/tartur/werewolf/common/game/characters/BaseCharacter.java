package fr.tartur.werewolf.common.game.characters;

import fr.tartur.werewolf.common.game.GameInstance;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Class representing a playable character in the game.
 */
@Getter
@Accessors(fluent = true)
public abstract class BaseCharacter {

    /**
     * The {@code CharacterType} associated with this character.
     *
     * @see CharacterType
     */
    protected final CharacterType type;

    /**
     * The {@code Player} which incarnates the character.
     *
     * @see Player
     */
    protected final Player player;

    /**
     * The class constructor, only usable by its child classes which will have to set the character name as a
     * {@code String} and its type as a {@code CharacterType}.
     *
     * @param type The character's type.
     * @param uuid The {@code UUID} of the player playing as this character.
     *
     * @see CharacterType
     */
    protected BaseCharacter(CharacterType type, UUID uuid) {
        this.type = type;
        this.player = switch (Bukkit.getPlayer(uuid)) {
            case null -> throw new IllegalArgumentException("The player with the UUID " + uuid + " could not be found.");
            case final Player foundPlayer -> foundPlayer;
        };
    }

    /**
     * The method that will be called when it's the character's turn.
     *
     * @param gameInstance The running game as a {@code GameInstance}.
     *
     * @see GameInstance
     */
    public abstract void play(GameInstance gameInstance);

}
