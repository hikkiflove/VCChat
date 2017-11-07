package com.vc.chat.model.response;

import java.io.Serializable;

/**
 * @author Hikki
 */
public class GetGroupInfoResponse {

    /**
     * code : 200
     * result : {"id":"HMo0KF3AS","name":"啦啦啦","portraitUri":"http://rongcloud-image.ronghub.com/image_jpeg__RC-0116-00-26_115_1453797774?e=2147483647&token=CddrKW5AbOMQaDRwc3ReDNvo3-sL_SO1fSUBKV3H:An7uUCZEfnKxDU2uISg9BOKLz_8=","memberCount":4,"creatorId":"7w0UxC8IB"}
     */

    private int code;
    /**
     * id : HMo0KF3AS
     * name : 啦啦啦
     * portraitUri : http://rongcloud-image.ronghub.com/image_jpeg__RC-0116-00-26_115_1453797774?e=2147483647&token=CddrKW5AbOMQaDRwc3ReDNvo3-sL_SO1fSUBKV3H:An7uUCZEfnKxDU2uISg9BOKLz_8=
     * memberCount : 4
     * creatorId : 7w0UxC8IB
     */

    private ResultEntity result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ResultEntity getResult() {
        return result;
    }

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public static class ResultEntity implements Serializable {
        private String id;
        private String name;
        private String portraitUri;
        private int memberCount;
        private String creatorId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPortraitUri() {
            return portraitUri;
        }

        public void setPortraitUri(String portraitUri) {
            this.portraitUri = portraitUri;
        }

        public int getMemberCount() {
            return memberCount;
        }

        public void setMemberCount(int memberCount) {
            this.memberCount = memberCount;
        }

        public String getCreatorId() {
            return creatorId;
        }

        public void setCreatorId(String creatorId) {
            this.creatorId = creatorId;
        }
    }
}
