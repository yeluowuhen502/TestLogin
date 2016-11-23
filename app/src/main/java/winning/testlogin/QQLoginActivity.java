package winning.testlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class QQLoginActivity extends AppCompatActivity {
private Button btn;
private Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qqlogin);
        btn = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ShareAction(QQLoginActivity.this).withText("hello")
                        .setDisplayList(SHARE_MEDIA.QQ)
                        .setCallback(new UMShareListener() {
                            @Override
                            public void onResult(SHARE_MEDIA media) {

                            }

                            @Override
                            public void onError(SHARE_MEDIA media, Throwable throwable) {

                            }

                            @Override
                            public void onCancel(SHARE_MEDIA media) {

                            }
                        }).open();
            }
        });
        btn2 = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UMShareAPI  mShareAPI = UMShareAPI.get( QQLoginActivity.this );
                mShareAPI.doOauthVerify(QQLoginActivity.this, SHARE_MEDIA.QQ, umAuthListener);
                mShareAPI.getPlatformInfo(QQLoginActivity.this, SHARE_MEDIA.QQ, new UMAuthListener() {
                    @Override
                    public void onComplete(SHARE_MEDIA media, int i, Map<String, String> map) {
                        Map<String,String> map1map  = map;
                    }

                    @Override
                    public void onError(SHARE_MEDIA media, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(SHARE_MEDIA media, int i) {

                    }
                });
            }
        });
    }

    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(getApplicationContext(), "Authorize succeed", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText( getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText( getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }
}
