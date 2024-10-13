package fr.tartur.werewolf.common.game.characters;

import fr.tartur.werewolf.common.game.GameInstance;

import java.util.UUID;

/**
 * Class representing the little girl role.
 */
public class LittleGirl extends BaseCharacter {
    /**
     * The class constructor, which builds the little girl role.
     *
     * @param uuid The {@code UUID} of the player playing as this character.
     *
     * @see CharacterType
     */
    public LittleGirl(UUID uuid) {
        super(CharacterType.LITTLE_GIRL, uuid);
    }

    /**
     * The method that will be called when it's the little girl's turn, which means never.
     *
     * @param gameInstance The running game as a {@code GameInstance}.
     *
     * @see GameInstance
     */
    @Override
    public void play(GameInstance gameInstance) {

    }
}
