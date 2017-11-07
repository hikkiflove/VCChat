package com.vc.chat.model.request;

/**
 * @author Hikki
 */
public class SetNameRequest {

    private String nickname;

    public SetNameRequest(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
