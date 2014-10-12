package android.icommunity.community;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.icommunity.R;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2014/9/14.
 */
public class NeedRepairNewActivity extends Activity implements View.OnClickListener{
    private ImageButton backBtn = null;
    private Button confirmBtn = null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.needrepairnew_layout);
        backBtn = (ImageButton)findViewById(R.id.needRepairNewBackBtn);
        confirmBtn = (Button)findViewById(R.id.needRepairNewConfirm);
        backBtn.setOnClickListener(this);
        confirmBtn.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        if(v.getId() == R.id.needRepairNewBackBtn)
        {
            finish();
        }
        else if(v.getId() == R.id.needRepairNewConfirm)
        {
            //提交
            Toast.makeText(this, "提交成功", Toast.LENGTH_SHORT).show();
        }
    }
}
