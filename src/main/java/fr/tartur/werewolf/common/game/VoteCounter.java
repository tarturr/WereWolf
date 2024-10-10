package fr.tartur.werewolf.common.game;

import fr.tartur.werewolf.common.game.characters.BaseCharacter;

import java.util.*;
import java.util.function.Supplier;

/**
 * Class containing each player's vote.
 */
public class VoteCounter implements Supplier<Map<BaseCharacter, Integer>> {

    private final Map<BaseCharacter, BaseCharacter> votes;

    /**
     * Class constructor building a new voting box.
     */
    public VoteCounter() {
        this.votes = new HashMap<>();
    }

    /**
     * Returns an {@code Optional} which may contain the pair {voter: voted player}.
     * @param voter The voting player.
     * @return An {@code Optional<BaseCharacter>} which may contain the SingleVote that associates the provided voter
     *         and its target.
     * @see BaseCharacter
     */
    public Optional<BaseCharacter> voteResult(BaseCharacter voter) {
        return Optional.ofNullable(this.votes.get(voter));
    }

    /**
     * Returns {@code true} if the player has voted for any other player, {@code false} otherwise.
     * @param voter The voting player.
     * @return {@code true} if the player has voted for any other player, {@code false} otherwise.
     */
    public boolean hasVoted(BaseCharacter voter) {
        return this.votes.containsKey(voter);
    }

    /**
     * Allows a player to vote for another one if and only if this player has not voted yet.
     * @param voter The voting player.
     * @param target The voted player.
     * @return {@code true} if the player successfully voted, {@code false} otherwise.
     * @see BaseCharacter
     */
    public boolean vote(BaseCharacter voter, BaseCharacter target) {
        return this.votes.putIfAbsent(voter, target) == null;
    }

    /**
     * Cancels the vote made by the provided player.
     * @param voter The player who wants to cancel his vote.
     * @return {@code true} if the vote was successfully removed, {@code false} otherwise.
     * @see BaseCharacter
     */
    public boolean cancelVote(BaseCharacter voter) {
        return this.votes.remove(voter) != null;
    }

    // TODO: Maybe change this method to only return the maximum vote value instead.
    /**
     * Gets the vote results.
     * @return The vote results as a {@code Map<BaseCharacter, Integer>}.
     * @see BaseCharacter
     */
    @Override
    public Map<BaseCharacter, Integer> get() {
        final Map<BaseCharacter, Integer> results = new HashMap<>();

        for (final BaseCharacter voter : this.votes.keySet()) {
            if (results.computeIfPresent(voter, (target, count) -> count + 1) == null) {
                results.put(voter, 1);
            }
        }

        return results;
    }
}
