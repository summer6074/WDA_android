package android.icommunity.community;

import android.app.ActionBar;
import android.app.Activity;
import android.icommunity.R;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2014/9/20.
 */
public class ComplainActivity extends Activity implements View.OnClickListener{
    private ImageButton backBtn = null;
    private Button confirmBtn = null;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.complain_layout);
        backBtn = (ImageButton)findViewById(R.id.complainBackBtn);
        confirmBtn = (Button)findViewById(R.id.complainBackBtnConfirm);
        backBtn.setOnClickListener(this);
        confirmBtn.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        if(v.getId() == R.id.complainBackBtn)
        {
            finish();
        }
        else if(v.getId() == R.id.complainBackBtnConfirm)
        {
            //提交
            Toast.makeText(this, "确定", Toast.LENGTH_SHORT).show();
        }
    }
}
