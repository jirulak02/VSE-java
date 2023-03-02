package com.example.document;

import com.example.catalog.Searchable;

public class Interview implements Searchable {
    private String interviewee;
    private String interviewer;
    private String transcript;
    private int lengthInMinutes;

    public Interview(String interviewee, String interviewer, String transcript, int lengthInMinutes) {
        this.interviewee = interviewee;
        this.interviewer = interviewer;
        this.transcript = transcript;
        this.lengthInMinutes = lengthInMinutes;
    }

    public String getInterviewee() {
        return interviewee;
    }

    public void setInterviewee(String interviewee) {
        this.interviewee = interviewee;
    }

    public String getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer;
    }

    public String getTranscript() {
        return transcript;
    }

    public void setTranscript(String transcript) {
        this.transcript = transcript;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public void setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    @Override
    public String getDisplayName() {
        return interviewee;
    }

    @Override
    public String prepareSearchableString() {
        return interviewee + interviewer + transcript;
    }
}
