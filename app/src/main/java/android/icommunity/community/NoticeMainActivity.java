package android.icommunity.community;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.icommunity.R;
import android.icommunity.communityAdapter.NoticeMainAdapter;
import android.icommunity.utility.NoticeList;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/9/14.
 */
public class NoticeMainActivity extends Activity{
    private ListView mListView;
    private List<NoticeList> mNotice;
    private NoticeMainAdapter mAdapter;
    private ImageButton backBtn = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.noticeitemlist_layout);
        NoticeList noticeData = new NoticeList();
        noticeData.SetTitle("关于公元社区收取2014年物业费以及补交上年度物业费的相关通知");
        noticeData.SetTime("2014-09-29 23:25");
        mNotice = new ArrayList<NoticeList>();
        mNotice.add(noticeData);
        mListView = (ListView) findViewById(R.id.content_main1);
        mListView.setAdapter(mAdapter = new NoticeMainAdapter(this, mNotice));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(NoticeMainActivity.this, NoticeDetailActivity.class);
                startActivity(intent);
            }
        });
        backBtn  = (ImageButton)findViewById(R.id.noticeMainBackBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.noticeMainBackBtn)
                {
                    finish();
                }
            }
        });

    }
}
