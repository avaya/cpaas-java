package com.zang.api.domain;

import com.zang.api.domain.enums.ConferenceStatus;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Resource properties about conference calls that occurred through a Zang
 * account can be requested using our REST API. To view a single conference
 * resource, simply request it by its ConferenceSid.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Conference extends BaseZangObject{
    @JsonProperty("friendly_name")
    private String friendlyName;

    @JsonProperty("active_participants_count")
    private Integer activeParticipantsCount;
    private ConferenceStatus status;
    @JsonProperty("run_time")
    private Integer runTime;

    @JsonProperty("subresource_uris")
    private ConferenceSubresourceUris subresourceUris;

    /**
     * @return User generated name of the conference.
     */
    public String getFriendlyName() {
        return friendlyName;
    }
    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    /**
     * @return Conference status. Can be 'init', 'in-progress' or 'completed'.
     *         'init' means the conference has been initialized, but no one has
     *         entered yet.
     */
    public ConferenceStatus getStatus() {
        return status;
    }
    public void setStatus(ConferenceStatus status) {
        this.status = status;
    }
    /**
     * @return The number of members that participated in the conference.
     */
    public Integer getActiveParticipantsCount() {
        return activeParticipantsCount;
    }
    public void setActiveParticipantsCount(Integer activeParticipantsCount) {
        this.activeParticipantsCount = activeParticipantsCount;
    }
    /**
     * @return Conference duration in seconds.
     */
    public Integer getRunTime() {
        return runTime;
    }
    public void setRunTime(Integer runTime) {
        this.runTime = runTime;
    }

    public ConferenceSubresourceUris getSubresourceUris() {
        return subresourceUris;
    }
    public void setSubresourceUris(ConferenceSubresourceUris subresourceUris) {
        this.subresourceUris = subresourceUris;
    }

}
