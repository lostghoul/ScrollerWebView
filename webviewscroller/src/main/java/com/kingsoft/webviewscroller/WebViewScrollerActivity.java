package com.kingsoft.webviewscroller;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;


public class WebViewScrollerActivity extends Activity {

    private Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_scroller);
        WebViewScrollerFragment fragment = new WebViewScrollerFragment();
        showFragment(fragment);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_web_view_scroller, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showFragment(Fragment fragment) {
        if (!fragment.isAdded()) {
            mFragment = fragment;
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.content_fragment, fragment, "");
            ft.commit();
        }
    }

    public void hideFragment() {
//        mCurrentType = -1;
//        if (mActionBarTitle != null) {
//            mActionBarTitle.setText(R.string.hello_mr_mail);
//        }
//        if (mDeleteAll != null) {
//            mDeleteAll.setVisibility(View.GONE);
//        }

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.remove(mFragment);
        ft.commit();
//        mFragment = mFragments.get(1);

//        mFeedbackEntry.setVisibility(View.VISIBLE);
//        if (FeedbackController.sHasUnreadFeedback) {
//            mFeedbackIcon.setImageResource(R.drawable.feedback_suggest_unread_img);
//        } else {
//            mFeedbackIcon.setImageResource(R.drawable.feedback_suggest_img);
//        }
    }
}
