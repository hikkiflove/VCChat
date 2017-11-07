package com.vc.chat.model.response;

/**
 * @author Hikki
 */
public class QiNiuTokenResponse {

    /**
     * code : 200
     * result : {"target":"qiniu","domain":"7xogjk.com1.z0.glb.clouddn.com","token":"livk5rb3__JZjCtEiMxXpQ8QscLxbNLehwhHySnX:eNVE-zcecMiHjRpOvK1txr2-LgY=:eyJzY29wZSI6InNlYWx0YWxrLWltYWdlIiwiZGVhZGxpbmUiOjE0NTk4MjgzMTh9"}
     */

    private int code;
    /**
     * target : qiniu
     * domain : 7xogjk.com1.z0.glb.clouddn.com
     * token : livk5rb3__JZjCtEiMxXpQ8QscLxbNLehwhHySnX:eNVE-zcecMiHjRpOvK1txr2-LgY=:eyJzY29wZSI6InNlYWx0YWxrLWltYWdlIiwiZGVhZGxpbmUiOjE0NTk4MjgzMTh9
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

    public static class ResultEntity {
        private String target;
        private String domain;
        private String token;

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
