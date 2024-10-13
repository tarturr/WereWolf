package fr.tartur.werewolf.common.game.characters;

import fr.tartur.werewolf.common.game.GameInstance;

import java.util.UUID;

/**
 * Class representing the Cupid role.
 */
public class Cupid extends BaseCharacter {
    /**
     * The class constructor, which builds the cupid role.
     *
     * @param uuid The {@code UUID} of the player playing as this character.
     *
     * @see CharacterType
     */
    public Cupid(UUID uuid) {
        super(CharacterType.CUPID, uuid);
    }

    /**
     * The method that will be called when it's Cupid's turn.
     *
     * @param gameInstance The running game as a {@code GameInstance}.
     *
     * @see GameInstance
     */
    @Override
    public void play(GameInstance gameInstance) {

    }
}
