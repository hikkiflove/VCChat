package com.vc.chat.model.request;

/**
 * @author Hikki
 */
public class AddToBlackListRequest {
    private String friendId;

    public AddToBlackListRequest(String friendId) {
        this.friendId = friendId;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }
}
