package com.vc.chat.model.exception;

import com.vc.chat.R;
import com.vc.chat.util.UIUtils;

/**
 * @author Hikki
 *         服务器异常
 */
public class ServerException extends Exception {

    public ServerException(int errorCode) {
        this(UIUtils.getString(R.string.error_code) + errorCode);
    }

    public ServerException(String message) {
        super(message);
    }

}
