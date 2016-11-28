package winning.myapplication;

import android.app.Application;

/**
 * Created by Jiang on 2016/11/25.
 */

public class CrashApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CustomCrashHandler crashHandler = CustomCrashHandler.getInstance();
        crashHandler.setCustomCrashHanler(getApplicationContext());
    }
}
