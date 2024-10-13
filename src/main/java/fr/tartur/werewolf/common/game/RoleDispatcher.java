package fr.tartur.werewolf.common.game;

import fr.tartur.werewolf.common.game.characters.*;
import org.bukkit.entity.Player;

import java.util.*;
import java.util.function.Supplier;

/**
 * Class which dispatch the roles following as much as possible the player's choices.
 */
public class RoleDispatcher implements Supplier<List<BaseCharacter>> {

    private final Map<Player, CharacterType> choices;

    /**
     * Class constructor which initializes an empty vote box.
     */
    public RoleDispatcher() {
        this.choices = new HashMap<>();
    }

    /**
     * Automatically sets the player's vote to {@code CharacterType.UNCHOSEN}.
     * @param player The new player.
     * @see CharacterType
     */
    public void connect(Player player) {
        this.registerChoice(player, CharacterType.UNCHOSEN);
    }

    /**
     * Removes the player from all of the registered character choices.
     * @param player The disconnecting player.
     */
    public void disconnect(Player player) {
        this.choices.remove(player);
    }

    /**
     * Register a choice of a {@code CharacterType} made by a {@code Player}.
     * @param player The player choosing the {@code CharacterType}.
     * @param type The chosen {@code CharacterType}.
     * @see CharacterType
     */
    public void registerChoice(Player player, CharacterType type) {
        this.choices.put(player, type);
    }

    /**
     * Returns an {@code List<Player>} which containing all the players who chose the provided {@code CharacterType}.
     * @param type The chosen {@code CharacterType}
     * @return An {@code List<Player>} which containing all the players who chose the provided {@code CharacterType}.
     */
    private List<Player> playersWithChoice(CharacterType type) {
        return this.choices.entrySet().stream()
                .filter(entry -> entry.getValue() == type)
                .map(Map.Entry::getKey)
                .toList();
    }

    /**
     * Main method which will return the results of the role distribution.
     * @return A new {@code List<BaseCharacter>} which contains each player wrapped in a {@code BaseCharacter} class
     *         instance, associated with its role.
     * @see BaseCharacter
     */
    @Override
    public List<BaseCharacter> get() {
        final List<BaseCharacter> characters = new ArrayList<>();
        final List<CharacterType> choicesMade = Arrays.asList(CharacterType.values());

        for (final CharacterType choice : CharacterType.values()) {
            final List<Player> players = this.playersWithChoice(choice);
            final int count = players.size();

            // If no player has chosen the current role.
            if (count == 0 || choice == CharacterType.UNCHOSEN) {
                continue;
            }

            final Player winner = count == 1
                    ? players.getFirst()
                    : players.get(new Random().nextInt(count));

            this.choices.remove(winner);
            choicesMade.remove(choice);
            characters.add(choice.buildFromUUID(winner.getUniqueId()));
        }

        final var remainingPlayers = this.choices.keySet().iterator();

        for (CharacterType type : choicesMade) {
            final Player player = remainingPlayers.next();

            characters.add(type.buildFromUUID(player.getUniqueId()));
        }

        while (remainingPlayers.hasNext()) {
            characters.add(CharacterType.VILLAGER.buildFromUUID(remainingPlayers.next().getUniqueId()));
        }

        return characters;
    }

}
