package tool.cpsdk.demo;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import tools.android.cpsdk.CpSdk;

public class MainApplication extends Application {
    @Override
    public Context getBaseContext() {
        return CpSdk.applicationGetBaseContext(this, super.getBaseContext());
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(CpSdk.TAG, "Application|onCreate|Process|" + CpSdk.getCurrentProcessName(this));
        if (CpSdk.isPluginProcess(this)) {
            return;
        }
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        CpSdk.applicationAttachBaseContext(this, base);
    }
}
