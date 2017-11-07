package com.vc.chat.model.response;

/**
 * @author Hikki
 */
public class GetFriendInfoByIDResponse {

    private int code;
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

    public static class ResultEntity {


        private String displayName;
        private UserEntity user;


        public void setdisplayName(String displayName) {
            this.displayName = displayName;
        }

        public String getdisplayName() {
            return displayName;
        }

        public UserEntity getUser() {
            return user;
        }

        public void setUser(UserEntity user) {
            this.user = user;
        }

        public static class UserEntity {
            private String id;
            private String nickname;
            private String region;
            private String phone;
            private String portraitUri;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getRegion() {
                return region;
            }

            public void setRegion(String region) {
                this.region = region;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getPortraitUri() {
                return portraitUri;
            }

            public void setPortraitUri(String portraitUri) {
                this.portraitUri = portraitUri;
            }
        }
    }
}
