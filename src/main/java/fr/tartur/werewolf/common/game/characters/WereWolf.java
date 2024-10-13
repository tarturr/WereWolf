package fr.tartur.werewolf.common.game.characters;

import fr.tartur.werewolf.common.ChatColor;
import fr.tartur.werewolf.common.game.GameInstance;
import net.kyori.adventure.text.Component;

import java.util.UUID;

/**
 * Class representing the werewolf role.
 */
public class WereWolf extends BaseCharacter {
    /**
     * The class constructor, which builds a werewolf role.
     *
     * @param uuid The {@code UUID} of the player playing as this character.
     *
     * @see CharacterType
     */
    public WereWolf(UUID uuid) {
        super(CharacterType.WEREWOLF, uuid);
    }

    /**
     * The method that will be called when it's the werewolves' turn.
     *
     * @param gameInstance The running game as a {@code GameInstance}.
     *
     * @see GameInstance
     */
    @Override
    public void play(GameInstance gameInstance) {
        super.player.sendMessage(
                Component.text("C'est à votre tour de jouer ! Discutez avec votre partenaire loup-garou afin " +
                                "de décider du joueur que vous mangerez cette nuit...")
                .color(ChatColor.INDIGO.color())
        );

        // TODO: Implement the missing code, including:
        //       - Hidden chat for other players.
        //       - Add a DelayedResult<VoteCounter> somewhere to handle werewolves' votes.
        //       - Click on Player to vote for him. Maybe place it in the BaseCharacter class.
    }
}
