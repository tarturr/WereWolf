package fr.tartur.werewolf.common.game.characters;

import fr.tartur.werewolf.common.game.GameInstance;

import java.util.UUID;

/**
 * Class representing the hunter role.
 */
public class Hunter extends BaseCharacter {
    /**
     * The class constructor, which builds the hunter role.
     *
     * @param uuid The {@code UUID} of the player playing as this character.
     *
     * @see CharacterType
     */
    public Hunter(UUID uuid) {
        super(CharacterType.HUNTER, uuid);
    }

    /**
     * The method that will be called when it's the hunter's turn, which means never.
     *
     * @param gameInstance The running game as a {@code GameInstance}.
     *
     * @see GameInstance
     */
    @Override
    public void play(GameInstance gameInstance) {

    }
}
