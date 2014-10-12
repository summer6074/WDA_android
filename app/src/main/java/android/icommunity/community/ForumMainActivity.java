package android.icommunity.community;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.icommunity.R;
import android.icommunity.communityAdapter.ForumMainAdatper;
import android.icommunity.utility.ForumList;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/9/3.
 */
public class ForumMainActivity extends Activity {
    private ListView mListView;
    private List<ForumList> mDatas;
    private ForumMainAdatper mAdapter;
    private ImageButton backBtn = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.forummain_layout);

        ForumList forumData = new ForumList();
        forumData.SetTitle("论坛聊天开放啦！！！！！！！！");
        forumData.SetTime("2014-08-29 23:25");
        forumData.SetPoster("小胖子");
        forumData.SetReplyNum("回复 12");
        mDatas = new ArrayList<ForumList>();
        mDatas.add(forumData);
        forumData = new ForumList();
        forumData.SetTitle("大家一起来灌水！！！！！！！！！！！！！！！！！！");
        forumData.SetTime("2014-08-30 21:25");
        forumData.SetPoster("小黄瓜");
        forumData.SetReplyNum("回复 1");
        mDatas.add(forumData);
        mListView = (ListView) findViewById(R.id.id_lv_main);
        mListView.setAdapter(mAdapter = new ForumMainAdatper(this, mDatas));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ForumMainActivity.this, ForumDetailActivity.class);
                startActivity(intent);
            }
        });

        backBtn = (ImageButton)findViewById(R.id.forumMainBackBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.forumMainBackBtn)
                {
                    finish();
                }
            }
        });

    }


}