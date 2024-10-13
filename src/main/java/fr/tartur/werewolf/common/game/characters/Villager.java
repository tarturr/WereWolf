package fr.tartur.werewolf.common.game.characters;

import fr.tartur.werewolf.common.game.GameInstance;

import java.util.UUID;

/**
 * Class representing the villager role.
 * @see BaseCharacter
 */
public class Villager extends BaseCharacter {

    /**
     * The class constructor, which builds a villager role.
     *
     * @param uuid The {@code UUID} of the player playing as this character.
     *
     * @see UUID
     */
    public Villager(UUID uuid) {
        super(CharacterType.VILLAGER, uuid);
    }

    /**
     * The method that will be called when it's the villagers' turn, which means never.
     *
     * @param gameInstance The running game as a {@code GameInstance}.
     *
     * @see GameInstance
     */
    @Override
    public void play(GameInstance gameInstance) {
    }

}
