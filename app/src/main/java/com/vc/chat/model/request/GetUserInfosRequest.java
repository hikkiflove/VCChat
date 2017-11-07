package com.vc.chat.model.request;

import java.util.List;

/**
 * @author Hikki
 */
public class GetUserInfosRequest {

    private List<String> querystring;

    public GetUserInfosRequest(List<String> querystring) {
        this.querystring = querystring;
    }

    public List<String> getQuerystring() {
        return querystring;
    }

    public void setQuerystring(List<String> querystring) {
        this.querystring = querystring;
    }
}
