package android.icommunity.community;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.icommunity.R;
import android.icommunity.communityAdapter.ForumMainAdatper;
import android.icommunity.communityAdapter.NoticeMainAdapter;
import android.icommunity.communityAdapter.RepairMainAdapter;
import android.icommunity.utility.ForumList;
import android.icommunity.utility.RepairInfoList;
import android.os.Bundle;
import android.view.Menu;
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
public class NeedRepairMainActivity extends Activity implements View.OnClickListener{
    private ListView mListView;
    private List<RepairInfoList> mRepairInfo;
    private RepairMainAdapter mAdapter;
    private ImageButton backBtn;
    private ImageButton addNewRepairSer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.needrepairlist_layout);
        mRepairInfo = new ArrayList<RepairInfoList>();
        RepairInfoList repairData = new RepairInfoList();
        repairData.SetRepairContent("5单元2楼水管坏了，麻烦派人来修理一下");
        repairData.SetRepairTime("上门时间：2014-09-26 17:00 - 18:00");
        repairData.SetRepairContacter("联系人：老黄瓜");
        repairData.SetRepairPhone("联系电话：021-110");
        repairData.SetRepairPostTime("2014-09-13 17:10");
        repairData.SetmRepirStatus(true);
        mRepairInfo.add(repairData);
        repairData = new RepairInfoList();
        repairData.SetRepairContent("5单元2楼电视机坏了，麻烦派人来修理一下");
        repairData.SetRepairTime("上门时间：2014-09-15 10:00 - 11:00");
        repairData.SetRepairContacter("联系人：老黄瓜");
        repairData.SetRepairPhone("联系电话：021-110");
        repairData.SetRepairPostTime("2014-09-12 11:10");
        repairData.SetmRepirStatus(false);
        mRepairInfo.add(repairData);

        mListView = (ListView) findViewById(R.id.repairservice_content);
        mListView.setAdapter(mAdapter = new RepairMainAdapter(this, mRepairInfo));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(NeedRepairMainActivity.this, NeedRepairDetailActivity.class);
                startActivity(intent);
            }
        });

        backBtn = (ImageButton)findViewById(R.id.repairServiceBackImg);
        addNewRepairSer = (ImageButton)findViewById(R.id.repairServiceNewBtn);
        backBtn.setOnClickListener(this);
        addNewRepairSer.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        if(v.getId() == R.id.repairServiceBackImg)
        {
            finish();
        }
        else if(v.getId() == R.id.repairServiceNewBtn)
        {
            Intent addNewRepairIntent = new Intent(NeedRepairMainActivity.this, NeedRepairNewActivity.class);
            startActivity(addNewRepairIntent);
        }
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.add_bx_info:
                Intent addNewRepairIntent = new Intent(NeedRepairMainActivity.this, NeedRepairNewActivity.class);
                startActivity(addNewRepairIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setOverflowShowingAlways() {
        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            menuKeyField.setAccessible(true);
            menuKeyField.setBoolean(config, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
