package com.vc.chat.model.request;

import java.util.List;

/**
 * @author Hikki
 */
public class DeleteGroupMemberRequest {

    private String groupId;
    private List<String> memberIds;

    public DeleteGroupMemberRequest(String groupId, List<String> memberIds) {
        this.groupId = groupId;
        this.memberIds = memberIds;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<String> getMemberIds() {
        return memberIds;
    }

    public void setMemberIds(List<String> memberIds) {
        this.memberIds = memberIds;
    }
}
