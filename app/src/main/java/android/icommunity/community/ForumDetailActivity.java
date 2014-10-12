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
 * Created by Administrator on 2014/9/3.
 */
public class ForumDetailActivity extends Activity implements View.OnClickListener{
    private ImageButton backBtn = null;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.forumdetail_layout);
        backBtn = (ImageButton)findViewById(R.id.forumdetailBackBtn);
        backBtn.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        if(v.getId() == R.id.forumdetailBackBtn)
        {
            finish();
        }
    }
}
