package android.icommunity.community;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.icommunity.R;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;


public class HomeActivity extends Activity implements View.OnClickListener {

    /**
     * 用于展示物业的Fragment
     */
    private MyCommunityFragment communityFragment;

    /**
     * 用于展示社区生活的Fragment
     */
    private LifeFragment lifeFragment;

    /**
     * 用于展示动态的Fragment
     */
    private EmotionFragment emotionFragment;

    /**
     * 用于展示设置的Fragment
     */
    private SettingFragment settingFragment;

    /**
     * 物业界面布局
     */
    private View communityLayout;

    /**
     * 小区生活界面布局
     */
    private View lifeLayout;

    /**
     * 情感交流界面布局
     */
    private View emotionLayout;

    /**
     * 设置界面布局
     */
    private View settingLayout;

    /**
     * 在Tab布局上显示我的小区图标的控件
     */
    private ImageView communityImage;

    /**
     * 在Tab布局上显示小区生活图标的控件
     */
    private ImageView lifeImage;

    /**
     * 在Tab布局上显示情感生活图标的控件
     */
    private ImageView emotionImage;

    /**
     * 在Tab布局上显示个人设置图标的控件
     */
    private ImageView settingImage;

    /**
     * 在Tab布局上显示我的物业标题的控件
     */
    private TextView communityText;

    /**
     * 在Tab布局上显示小区生活标题的控件
     */
    private TextView lifeText;

    /**
     * 在Tab布局上显示情感交流标题的控件
     */
    private TextView emotionText;

    /**
     * 在Tab布局上显示个人设置标题的控件
     */
    private TextView settingText;

    /**
     * 用于对Fragment进行管理
     */
    private FragmentManager fragmentManager;

    public HomeActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.home_activity);
        initViews();
        fragmentManager = getFragmentManager();
        // 第一次启动时选中第0个tab
        setTabSelection(0);
    }

    private void initViews() {
        communityLayout = findViewById(R.id.community_layout);
        lifeLayout = findViewById(R.id.life_layout);
        emotionLayout = findViewById(R.id.emotion_layout);
        settingLayout = findViewById(R.id.setting_layout);

        communityImage = (ImageView) findViewById(R.id.community_image);
        lifeImage = (ImageView) findViewById(R.id.life_image);
        emotionImage = (ImageView) findViewById(R.id.emotion_image);
        settingImage = (ImageView) findViewById(R.id.setting_image);

        communityText = (TextView) findViewById(R.id.community_text);
        lifeText = (TextView) findViewById(R.id.life_text);
        emotionText = (TextView) findViewById(R.id.emotion_text);
        settingText = (TextView) findViewById(R.id.setting_text);

        communityLayout.setOnClickListener(this);
        lifeLayout.setOnClickListener(this);
        emotionLayout.setOnClickListener(this);
        settingLayout.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.community_layout:
                // 当点击了我的小区tab时，选中第1个tab
                setTabSelection(0);
                break;
            case R.id.life_layout:
                // 当点击了小区生活tab时，选中第2个tab
                setTabSelection(1);
                break;
            case R.id.emotion_layout:
                // 当点击了情感交流tab时，选中第3个tab
                setTabSelection(2);
                break;
            case R.id.setting_layout:
                // 当点击了个人设置tab时，选中第4个tab
                setTabSelection(3);
                break;
            default:
                break;
        }
    }

    private void setTabSelection(int index) {
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 0:
                // 当点击了我的物业tab时，改变控件的图片和文字颜色
                communityImage.setImageResource(R.drawable.community_selected);
                communityText.setTextColor(Color.WHITE);
                if (communityFragment == null) {
                    // 如果communityFragment为空，则创建一个并添加到界面上
                    communityFragment = new MyCommunityFragment();
                    transaction.add(R.id.content, communityFragment);
                } else {
                    // 直接将它显示出来
                    transaction.show(communityFragment);
                }
                break;
            case 1:
                // 当点击了小区生活tab时，改变控件的图片和文字颜色
                lifeImage.setImageResource(R.drawable.life_selected);
                lifeText.setTextColor(Color.WHITE);
                if (lifeFragment == null) {
                    // 如果lifeFragment为空，则创建一个并添加到界面上
                    lifeFragment = new LifeFragment();
                    transaction.add(R.id.content, lifeFragment);
                } else {
                    // 如果lifeFragment不为空，则直接将它显示出来
                    transaction.show(lifeFragment);
                }
                break;
            case 2:
                // 当点击了情感交流tab时，改变控件的图片和文字颜色
                emotionImage.setImageResource(R.drawable.emotion_selected);
                emotionText.setTextColor(Color.WHITE);
                if (emotionFragment == null) {
                    // 如果emotionFragment为空，则创建一个并添加到界面上
                    emotionFragment = new EmotionFragment();
                    transaction.add(R.id.content, emotionFragment);
                } else {
                    // 如果emotionFragment不为空，则直接将它显示出来
                    transaction.show(emotionFragment);
                }
                break;
            case 3:
            default:
                // 当点击了个人设置tab时，改变控件的图片和文字颜色
                settingImage.setImageResource(R.drawable.setting_selected);
                settingText.setTextColor(Color.WHITE);
                if (settingFragment == null) {
                    // 如果SettingFragment为空，则创建一个并添加到界面上
                    settingFragment = new SettingFragment();
                    transaction.add(R.id.content, settingFragment);
                } else {
                    // 如果SettingFragment不为空，则直接将它显示出来
                    transaction.show(settingFragment);
                }
                break;
        }
        transaction.commit();
    }

    /**
     * 清除掉所有的选中状态。
     */
    private void clearSelection() {
        communityImage.setImageResource(R.drawable.community_unselected);
        communityText.setTextColor(Color.parseColor("#82858b"));
        lifeImage.setImageResource(R.drawable.life_unselected);
        lifeText.setTextColor(Color.parseColor("#82858b"));
        emotionImage.setImageResource(R.drawable.emotion_unselected);
        emotionText.setTextColor(Color.parseColor("#82858b"));
        settingImage.setImageResource(R.drawable.setting_unselected);
        settingText.setTextColor(Color.parseColor("#82858b"));
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction
     *            用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (communityFragment != null) {
            transaction.hide(communityFragment);
        }
        if (lifeFragment != null) {
            transaction.hide(lifeFragment);
        }
        if (emotionFragment != null) {
            transaction.hide(emotionFragment);
        }
        if (settingFragment != null) {
            transaction.hide(settingFragment);
        }
    }
}
