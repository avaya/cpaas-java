package com.zang.api.domain;

/**
 * List of a conference's various subresources and their URI path. Examples of conference
 * subresources are participants.
 *
 */
public class ConferenceSubresourceUris {

    private String participants;

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }


}