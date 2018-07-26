package cn.aizhangzhang.aizhangzhang.Login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import cn.aizhangzhang.aizhangzhang.Base.BaseActivity;
import cn.aizhangzhang.aizhangzhang.HttpUtil.HttpPost;
import cn.aizhangzhang.aizhangzhang.MainActivity;
import cn.aizhangzhang.aizhangzhang.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Response;

import static cn.aizhangzhang.aizhangzhang.HttpUtil.GlobalConstants.UserLogin_URL;

public class LoginActivity extends BaseActivity {

    private SharedPreferences pref;

    private SharedPreferences.Editor editor;

    private EditText accountEdit;

    private EditText passwordEdit;

    private Button login;

    private CheckBox rememberPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        accountEdit = (EditText) findViewById(R.id.account);
        passwordEdit = (EditText) findViewById(R.id.password);
        rememberPass = (CheckBox) findViewById(R.id.remember_pass);
        login = (Button) findViewById(R.id.login);
        boolean isRemember = pref.getBoolean("remember_password", false);
        if (isRemember) {
            // 将账号和密码都设置到文本框中
            String account = pref.getString("account", "");
            String password = pref.getString("password", "");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url =UserLogin_URL;

                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();

                FormBody.Builder builder = new FormBody.Builder()
                        .add("account",account)
                        .add("password",password);
                new HttpPost().postData(url, builder, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        isLoginSuccess(response.body().string());

                    }
                });


//                // 如果账号是admin且密码是123456，就认为登录成功
//                if (account.equals("admin") && password.equals("123456")) {
//
//
//                } else {
//                    Toast.makeText(LoginActivity.this, "account or password is invalid",
//                            Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }

    private void isLoginSuccess(String response) {
        try{
            System.out.println("response1 " + response);  //12
            JSONObject jsonObject = new JSONObject(response);
            if(jsonObject.getInt("error") == 1){
                saveUserInfo(accountEdit.getText().toString(),passwordEdit.getText().toString());
                initUserinfo(jsonObject);
                goto_admin_activity();
            }
            else {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(LoginActivity.this, "zz:account or password is invalid",
                                Toast.LENGTH_SHORT).show();
                    }
                });

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void saveUserInfo(String account, String password){
        editor = pref.edit();
        if (rememberPass.isChecked()) { // 检查复选框是否被选中
            editor.putBoolean("remember_password", true);
            editor.putString("account", account);
            editor.putString("password", password);
        } else {
            editor.clear();
        }
        editor.apply();

//        SharedPreferences.Editor editor = getSharedPreferences("userinfo", MODE_PRIVATE).edit();
//        editor.putString("username", username);
//        editor.putString("pwd", password);
//        editor.apply();
    }
    private void initUserinfo(JSONObject jsonObject) throws JSONException {
        UserInfo.userid = pref.getString("account", "");

        JSONObject jsonObject1 = jsonObject.getJSONObject("test1");
        UserInfo.level = jsonObject1.getInt("dg1");
        UserInfo.bumen = jsonObject1.getString("dg2");
        UserInfo.xkmk = jsonObject1.getString("dg3");
        UserInfo.tel = jsonObject.getJSONObject("test2").getString("dg5");
    }

    private void goto_admin_activity(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}
