package com.vc.chat.ui.view;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.vc.chat.widget.IPEditText;

/**
 * @author Hikki
 */

public interface ICommonConfigAtView {
    IPEditText getWorkflowIPAddr();
    IPEditText getMsgIPAddr();
    EditText getWorkflowProtocol();
    EditText getMsgProtocol();
    EditText getVideoEncoder();
    EditText getVideoBandwidth();
    CheckBox getAutoAnswer();
}
