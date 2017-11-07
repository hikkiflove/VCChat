package com.vc.chat.model.request;


/**
 * @author Hikki
 */
public class AgreeFriendsRequest {

    private String friendId;

    public AgreeFriendsRequest(String friendId) {
        this.friendId = friendId;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }
}
