package com.modul2.learning.dto.validation;

import com.tenis.challenge.ChallengeStatus;
import com.tenis.challenge.dto.validation.AdvancedInfo;
import com.tenis.challenge.dto.validation.BasicInfo;
import com.tenis.challenge.dto.validation.ValidDate;
import com.tenis.event.dto.EventDTO;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ValidDate(groups = AdvancedInfo.class)
public class ChallengeCreateDTO {
    private Integer id;
    private LocalDate creationDate;
    @NotNull(groups = BasicInfo.class)
    private LocalDateTime matchStartDate;
    @NotNull(groups = BasicInfo.class)
    private LocalDateTime matchEndDate;
    private String location;
    private Integer creatorTeamId;
    private Integer creatorPlayerId;
    private Integer invitedTeamId;
    private ChallengeStatus challengeStatus;
    private Integer courtId;
    private EventDTO event;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getMatchStartDate() {
        return matchStartDate;
    }

    public void setMatchStartDate(LocalDateTime matchStartDate) {
        this.matchStartDate = matchStartDate;
    }

    public LocalDateTime getMatchEndDate() {
        return matchEndDate;
    }

    public void setMatchEndDate(LocalDateTime matchEndDate) {
        this.matchEndDate = matchEndDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCreatorTeamId() {
        return creatorTeamId;
    }

    public void setCreatorTeamId(Integer creatorTeamId) {
        this.creatorTeamId = creatorTeamId;
    }

    public Integer getCreatorPlayerId() {
        return creatorPlayerId;
    }

    public void setCreatorPlayerId(Integer creatorPlayerId) {
        this.creatorPlayerId = creatorPlayerId;
    }

    public Integer getInvitedTeamId() {
        return invitedTeamId;
    }

    public void setInvitedTeamId(Integer invitedTeamId) {
        this.invitedTeamId = invitedTeamId;
    }

    public ChallengeStatus getChallengeStatus() {
        return challengeStatus;
    }

    public void setChallengeStatus(ChallengeStatus challengeStatus) {
        this.challengeStatus = challengeStatus;
    }

    public EventDTO getEvent() {
        return event;
    }

    public void setEvent(EventDTO event) {
        this.event = event;
    }

    public Integer getCourtId() {
        return courtId;
    }

    public void setCourtId(Integer courtId) {
        this.courtId = courtId;
    }
}
