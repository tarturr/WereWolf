package fr.tartur.werewolf.common.game.characters;

import fr.tartur.werewolf.common.game.GameInstance;

import java.util.UUID;

/**
 * Class representing the stealer role.
 */
public class Stealer extends BaseCharacter {
    /**
     * The class constructor, which builds the stealer role.
     *
     * @param uuid The {@code UUID} of the player playing as this character.
     *
     * @see CharacterType
     */
    public Stealer(UUID uuid) {
        super(CharacterType.STEALER, uuid);
    }

    /**
     * The method that will be called when it's the stealer's turn.
     *
     * @param gameInstance The running game as a {@code GameInstance}.
     *
     * @see GameInstance
     */
    @Override
    public void play(GameInstance gameInstance) {

    }
}
