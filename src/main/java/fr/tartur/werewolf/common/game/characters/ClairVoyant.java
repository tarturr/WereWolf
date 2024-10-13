package fr.tartur.werewolf.common.game.characters;

import fr.tartur.werewolf.common.game.GameInstance;

import java.util.UUID;

/**
 * Class representing the clairvoyant role.
 */
public class ClairVoyant extends BaseCharacter {
    /**
     * The class constructor, which builds the clairvoyant role.
     *
     * @param uuid The {@code UUID} of the player playing as this character.
     *
     * @see CharacterType
     */
    public ClairVoyant(UUID uuid) {
        super(CharacterType.CLAIRVOYANT, uuid);
    }

    /**
     * The method that will be called when it's the clairvoyant's turn.
     *
     * @param gameInstance The running game as a {@code GameInstance}.
     *
     * @see GameInstance
     */
    @Override
    public void play(GameInstance gameInstance) {

    }
}
