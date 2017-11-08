package com.vc.chat.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.vc.chat.R;
import com.vc.chat.ui.base.BaseActivity;
import com.vc.chat.ui.presenter.CommonConfigAtPresenter;
import com.vc.chat.ui.view.ICommonConfigAtView;
import com.vc.chat.util.UIUtils;
import com.vc.chat.widget.IPEditText;

import butterknife.BindView;

/**
 * @author Hikki
 */

public class CommonConfigActivity extends BaseActivity<ICommonConfigAtView,
        CommonConfigAtPresenter> implements ICommonConfigAtView{

    @BindView(R.id.etWorkflowIP) IPEditText mWorkflowIP;
    @BindView(R.id.etMsgIP) IPEditText mMsgIP;
    @BindView(R.id.etWorkflow_protocol) EditText mWorkflowProtocol;
    @BindView(R.id.etMsg_protocol) EditText mMsgProtocol;
    @BindView(R.id.etVideo_encoder) EditText mVideoEncoder;
    @BindView(R.id.etVideo_bandwidth) EditText mVideoBandwidth;
    @BindView(R.id.ctAuto_answer) CheckBox mAutoAnswer;
    @BindView(R.id.config_save) Button mSaveBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDefaultValue();
    }

    private void initDefaultValue() {
        //Set default value
        mWorkflowIP.setPortText(UIUtils.getString(R.string.default_port));
        mMsgIP.setPortText(UIUtils.getString(R.string.default_port));
        mWorkflowProtocol.setText(UIUtils.getString(R.string.default_protocol));
        mMsgProtocol.setText(UIUtils.getString(R.string.default_protocol));
        mAutoAnswer.setChecked(true);
        mSaveBtn.setEnabled(true);
    }

    @Override
    public void initListener() {
        mSaveBtn.setOnClickListener( v -> {
            if (canSave()) {
                mPresenter.save();
            }
        });
    }

    private boolean canSave() {

        if (mWorkflowIP.getIPText().toString().trim().length() <= 0) {
            mWorkflowIP.setIPFocus();
            UIUtils.showToast(UIUtils.getString(R.string.workflow_addr_empty));
            return false;
        }

        if (mMsgIP.getIPText().toString().trim().length() <= 0) {
            mMsgIP.setIPFocus();
            UIUtils.showToast(UIUtils.getString(R.string.msg_addr_empty));
            return false;
        }

        if (mWorkflowIP.getPortText().toString().trim().length() <= 0) {
            mWorkflowIP.setPortFocus();
            UIUtils.showToast(UIUtils.getString(R.string.msg_addr_empty));
            return false;
        }

        if (mWorkflowProtocol.getText().toString().trim().length() <= 0) {
            mMsgIP.setPortFocus();
            UIUtils.showToast(UIUtils.getString(R.string.msg_addr_empty));
            return false;
        }

        if (mWorkflowProtocol.getText().toString().trim().length() <= 0) {
            mWorkflowProtocol.requestFocus();
            UIUtils.showToast(UIUtils.getString(R.string.workflow_protoco_empty));
            return false;
        }

        if (mMsgProtocol.getText().toString().trim().length() <= 0) {
            mMsgProtocol.requestFocus();
            UIUtils.showToast(UIUtils.getString(R.string.msg_protoco_empty));
            return false;
        }

        if (mVideoEncoder.getText().toString().trim().length() <= 0) {
            mVideoEncoder.requestFocus();
            UIUtils.showToast(UIUtils.getString(R.string.video_encoder_empty));
            return false;
        }

        if (mVideoBandwidth.getText().toString().trim().length() <= 0) {
            mVideoBandwidth.requestFocus();
            UIUtils.showToast(UIUtils.getString(R.string.video_bandwidth_empty));
            return false;
        }

        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IPEditText getWorkflowIPAddr() {
        return mWorkflowIP;
    }

    @Override
    public IPEditText getMsgIPAddr() {
        return mMsgIP;
    }

    @Override
    public EditText getWorkflowProtocol() {
        return mWorkflowProtocol;
    }

    @Override
    public EditText getMsgProtocol() {
        return mMsgProtocol;
    }

    @Override
    public EditText getVideoEncoder() {
        return mVideoEncoder;
    }

    @Override
    public EditText getVideoBandwidth() {
        return mVideoBandwidth;
    }

    @Override
    public CheckBox getAutoAnswer() {
        return mAutoAnswer;
    }

    @Override
    protected CommonConfigAtPresenter createPresenter() {
        return new CommonConfigAtPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_common_config;
    }
}
