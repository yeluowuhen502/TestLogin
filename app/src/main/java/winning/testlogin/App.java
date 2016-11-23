package winning.testlogin;

import android.app.Application;
import android.os.Bundle;


import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UMShareAPI.get(this);
    }

    //各个平台的配置，建议放在全局Application或者程序入口
    {
        PlatformConfig.setQQZone("1105206263", "ulNIo4Yxcp8KP2Cz");
    }
}
