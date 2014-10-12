package android.icommunity.community;

import android.app.Activity;
import android.icommunity.R;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by Administrator on 2014/9/14.
 */
public class NoticeDetailActivity extends Activity implements View.OnClickListener{
    private ImageButton backBtn = null;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.noticedetail_layout);
        backBtn = (ImageButton)findViewById(R.id.noticeDetailBackBtn);
        backBtn.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        if(v.getId() == R.id.noticeDetailBackBtn)
        {
            finish();
        }
    }
}
