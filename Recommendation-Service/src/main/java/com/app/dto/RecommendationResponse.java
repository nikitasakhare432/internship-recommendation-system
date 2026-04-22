package com.app.dto;

public class RecommendationResponse {

    private InternshipDto internship;
    private int matchScore;

    public RecommendationResponse() {
    }

    public RecommendationResponse(InternshipDto internship, int matchScore) {
        this.internship = internship;
        this.matchScore = matchScore;
    }

    public InternshipDto getInternship() {
        return internship;
    }

    public void setInternship(InternshipDto internship) {
        this.internship = internship;
    }

    public int getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(int matchScore) {
        this.matchScore = matchScore;
    }

    @Override
    public String toString() {
        return "RecommendationResponse [internship=" + internship + ", matchScore=" + matchScore + "]";
    }
}