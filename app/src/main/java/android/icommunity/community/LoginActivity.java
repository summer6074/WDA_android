package android.icommunity.community;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.icommunity.R;
import android.icommunity.utility.Global;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.pm.pojo.User;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.util.Map;

import android.app.AlertDialog;

/**
 * Created by Administrator on 2014/9/17.
 */
public class LoginActivity extends Activity implements View.OnClickListener{

    private final int RESPONSE_IS_OK = 0;
    private EditText mUserPhone;
    private EditText mUserPasswd;
    private Button mLoginBtn;
    private ProgressDialog progressDialog;

    private Handler handler = new Handler(){
        public void handleMessage(Message msg)
        {
            //隐藏输入键盘
            InputMethodManager imm = (InputMethodManager)getSystemService(LoginActivity.this.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(mUserPasswd.getWindowToken(), 0);
            switch(msg.what) {
                case RESPONSE_IS_OK:
                    boolean retVal = (Boolean)msg.obj;
                    if (retVal)
                    {
                        progressDialog = ProgressDialog.show(LoginActivity.this, null, "正在登陆...", true, false);
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                progressDialog.dismiss();
                                Intent Intent = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(Intent);
                                finish();
                            }
                        }, 3000);
                    }
                    else
                    {
                        new AlertDialog.Builder(LoginActivity.this)
                                .setTitle("登录失败")
                                .setMessage("账号或密码错误，请重新填写")
                                .setPositiveButton("确定", null)
                                .create().show();
                    }

                    break;
                default:
                    break;

            }
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        mUserPhone = (EditText)findViewById(R.id.login_phone);
        mUserPasswd = (EditText)findViewById(R.id.login_password);
        mLoginBtn = (Button)findViewById(R.id.login_btn);

        mLoginBtn.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        if(v.getId() == R.id.login_btn)
        {
             LoginInCommunity();
        }
    }

    private void LoginInCommunity()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                User user = new User();
                byte[] data = new byte[1024];
                ByteArrayOutputStream outStream = new ByteArrayOutputStream();
                int len = 0;
                user.setUPhone(mUserPhone.getText().toString());
                user.setUPassword(mUserPasswd.getText().toString());
                Date cureDate = new Date(0);
                user.setURegTime(cureDate);
                String urlStr = Global.getHttpServerUrl() + "userapp/userLogin";

                Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

                String str = gson.toJson(user);
                String str1 = null;

                HttpURLConnection httpURLConnection = null;
                try {
                    URL url = new URL(urlStr);
                    httpURLConnection = (HttpURLConnection)url.openConnection();
                    httpURLConnection.setConnectTimeout(3000);
                    httpURLConnection.setDoInput(true);                  //打开输入流，以便从服务器获取数据
                    httpURLConnection.setDoOutput(true);                 //打开输出流，以便向服务器提交数据
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setUseCaches(false);               //使用Post方式不能使用缓存
                    //设置请求体的类型是文本类型
                    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    //设置请求体的长度
                    httpURLConnection.setRequestProperty("Content-Length", String.valueOf(str.getBytes().length));
                    //获得输出流，向服务器写入数据
                    OutputStream outputStream = httpURLConnection.getOutputStream();

                    OutputStreamWriter osw = new OutputStreamWriter(outputStream, "UTF-8");
                    osw.write(str);
                    osw.flush();

                    int response = httpURLConnection.getResponseCode();            //获得服务器的响应码
                    if(response == HttpURLConnection.HTTP_OK) {

                        InputStream inStream = httpURLConnection.getInputStream();
                        while ((len = inStream.read(data)) != -1) {
                            outStream.write(data, 0, len);
                        }
                        inStream.close();
                        Map<String,Object> ret = gson.fromJson(outStream.toString(),new TypeToken<Map<String,Object>>(){}.getType());

                        Message msg = new Message();
                        msg.what = RESPONSE_IS_OK;
                        msg.obj = ret.get("retVal");

                        handler.sendMessage(msg);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                finally {
                    if (httpURLConnection != null)
                    {
                        httpURLConnection.disconnect();
                    }
                }
            }
        }).start();
    }
}
