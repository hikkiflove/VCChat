package com.vc.chat.model.request;

/**
 * @author Hikki
 */
public class JoinGroupRequest {

    private String groupId;

    public JoinGroupRequest(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
