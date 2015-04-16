package com.russ4stall.critter.core;

/**
 * Created by russ on 3/24/15.
 *
 * Represents a creet and the signed in user's vote status
 */
public class CreetAndVoteStatus {
    private Creet creet;
    private VoteStatus voteStatus;

    public CreetAndVoteStatus(Creet creet, VoteStatus voteStatus) {
        this.creet = creet;
        this.voteStatus = voteStatus;
    }

    public Creet getCreet() {
        return creet;
    }

    public VoteStatus getVoteStatus() {
        return voteStatus;
    }
}
