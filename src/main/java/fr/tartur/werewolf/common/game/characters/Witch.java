package fr.tartur.werewolf.common.game.characters;

import fr.tartur.werewolf.common.game.GameInstance;

import java.util.UUID;

/**
 * Class representing the witch role.
 */
public class Witch extends BaseCharacter {
    /**
     * The class constructor, which builds the witch role.
     *
     * @param uuid The {@code UUID} of the player playing as this character.
     *
     * @see CharacterType
     */
    public Witch(UUID uuid) {
        super(CharacterType.WITCH, uuid);
    }

    /**
     * The method that will be called when it's the witch's turn.
     *
     * @param gameInstance The running game as a {@code GameInstance}.
     *
     * @see GameInstance
     */
    @Override
    public void play(GameInstance gameInstance) {

    }
}
