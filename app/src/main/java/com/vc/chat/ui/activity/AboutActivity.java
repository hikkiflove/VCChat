package com.vc.chat.ui.activity;

import com.vc.chat.R;
import com.vc.chat.ui.base.BaseActivity;
import com.vc.chat.ui.base.BasePresenter;

/**
 * @author Hikki
 *         关于界面
 */
public class AboutActivity extends BaseActivity {

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_about;
    }
}
