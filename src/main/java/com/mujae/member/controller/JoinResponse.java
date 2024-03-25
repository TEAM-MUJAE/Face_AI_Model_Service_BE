package com.mujae.member.controller;

public class JoinResponse {

    private boolean emailAvailable;
    private boolean userIdAvailable;
    private boolean phoneAvailable;

    public JoinResponse() {
    }

    public JoinResponse(boolean emailAvailable, boolean userIdAvailable, boolean phoneAvailable) {
        this.emailAvailable = emailAvailable;
        this.userIdAvailable = userIdAvailable;
        this.phoneAvailable = phoneAvailable;
    }

    public boolean isEmailAvailable() {
        return emailAvailable;
    }

    public void setEmailAvailable(boolean emailAvailable) {
        this.emailAvailable = emailAvailable;
    }

    public boolean isUserIdAvailable() {
        return userIdAvailable;
    }

    public void setUserIdAvailable(boolean userIdAvailable) {
        this.userIdAvailable = userIdAvailable;
    }

    public boolean isPhoneAvailable() {
        return phoneAvailable;
    }

    public void setPhoneAvailable(boolean phoneAvailable) {
        this.phoneAvailable = phoneAvailable;
    }

    @Override
    public String toString() {
        return "JoinResponse{" +
                "emailAvailable=" + emailAvailable +
                ", userIdAvailable=" + userIdAvailable +
                ", phoneAvailable=" + phoneAvailable +
                '}';
    }
}
