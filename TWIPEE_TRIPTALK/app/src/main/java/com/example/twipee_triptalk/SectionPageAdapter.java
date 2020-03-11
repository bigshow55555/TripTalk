package com.example.twipee_triptalk;

import android.content.Context;

import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.twipee_triptalk.TripTalk.Chat.ChatActivity;

public class SectionPageAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3, R.string.tab_text_4};
    private final Context mContext;
    public SNSView mSNSView = null;

    public TripTalkView mTripTalkView = null;
    public ChatActivity mChatActivity = null;
    public NearFacilityView mNearFacilityView = null;
    public UserInfoView mUserInfoView = null;
    public SectionPageAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }


    public CharSequence getPageTitle(int position)
    {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return mSNSView = new SNSView();
            case 1:
                return mTripTalkView = new TripTalkView();
            case 2:
                return mNearFacilityView = new NearFacilityView();
            case 3:
                return mUserInfoView = new UserInfoView();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
