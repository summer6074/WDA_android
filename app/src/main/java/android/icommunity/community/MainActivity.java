package android.icommunity.community;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.icommunity.R;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;
import android.os.Handler;

public class MainActivity extends Activity {

    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.icommunity_activity);
        LinearLayout linearLayout = (LinearLayout) this.findViewById(R.id.community_layout);
        linearLayout.setBackgroundResource(R.drawable.community_activity);
        SplashDisplay(MainActivity.this, LoginActivity.class);
    }

    private void SplashDisplay(final Context context, final Class<?> cls)
    {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent Intent = new Intent(context, cls);
                startActivity(Intent);
                finish();
            }

        }, SPLASH_DISPLAY_LENGTH);

    }
}