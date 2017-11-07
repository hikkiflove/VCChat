package com.vc.chat.model.response;

/**
 * @author Hikki
 */
public class CreateGroupResponse {

    /**
     * code : 200
     * result : {"id":"ArVtlWJSv"}
     */
    private int code;
    /**
     * id : ArVtlWJSv
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
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
