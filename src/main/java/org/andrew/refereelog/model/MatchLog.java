package org.andrew.refereelog.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class MatchLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^\\D*$", message = "Must not contain numbers")
    private String referee;

    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^\\D*$", message = "Must not contain numbers")
    private String assistantReferee1;

    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^\\D*$", message = "Must not contain numbers")
    private String assistantReferee2;

    @NotBlank(message = "Team name is required")
    private String homeTeamName;

    @NotBlank(message = "Team name is required")
    private String awayTeamName;

    @NotBlank(message = "Score is required")
    @Min(value = 0, message = "Must be zero or a positive number")
    private int homeTeamScore;

    @NotBlank(message = "Score is required")
    @Min(value = 0, message = "Must be zero or a positive number")
    private int awayTeamScore;

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public String getAssistantReferee1() {
        return assistantReferee1;
    }

    public void setAssistantReferee1(String assistantReferee1) {
        this.assistantReferee1 = assistantReferee1;
    }

    public String getAssistantReferee2() {
        return assistantReferee2;
    }

    public void setAssistantReferee2(String assistantReferee2) {
        this.assistantReferee2 = assistantReferee2;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(int awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }
}
