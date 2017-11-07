package com.vc.chat.model.response;


/**
 * @author Hikki
 */
public class VerifyCodeResponse {

    /**
     * code : 200
     * result : {"verification_token":"86bd3a00-b80a-11e5-b5ab-433619959d67"}
     */
    private int code;

    /**
     * verification_token : 86bd3a00-b80a-11e5-b5ab-433619959d67
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
        private String verification_token;

        public String getVerification_token() {
            return verification_token;
        }

        public void setVerification_token(String verification_token) {
            this.verification_token = verification_token;
        }
    }
}
