package tool.cpsdk.app;

import android.app.Activity;
import android.compact.impl.TaskPayload;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import tools.android.cpsdk.AbsCallback;
import tools.android.cpsdk.CpSdk;
import tools.android.cpsdk.ResultListener;
import tools.android.retryrequest.GsonUtil;

public class MainActivity extends Activity {

    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn1 = (Button) findViewById(R.id.btn1);
        final TextView btn1ret = (TextView) findViewById(R.id.btn1_ret);
        final Button btn2 = (Button) findViewById(R.id.btn2);
        final TextView btn2ret = (TextView) findViewById(R.id.btn2_ret);

        if (mHandler == null) {
            HandlerThread ht = new HandlerThread("phonestate-single-thread") {
                {
                    start();
                }
            };
            mHandler = new Handler(ht.getLooper());
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                String jid = "j-ylCRwAVtcKLX1jUcNjUiQhkMwu0u8=";
                Log.d("PPP", "requestPlayUrl|" + jid);
//                CpSdk.requestPlayUrl(view.getContext(), jid, new AbsCallback() {
//                    @Override
//                    public void onPlayUrlResult(List<String> lowUrl, List<String> normalUrl, List<String> highUrl, List<String> superUrl, List<String> defs) {
//                        Log.d("PPP", "requestPlayUrl|onPlayUrlResult|low|" + lowUrl.size() + "|normal|" + normalUrl.size() + "|high|" + highUrl.size() + "|super|" + superUrl.size() + "|defs|" + GsonUtil.toJson(defs));
//                    }
//                    @Override
//                    public void onPayloadResult(TaskPayload payload) {
//                        Log.d("PPP", "requestPlayUrl|payload|" + GsonUtil.toJson(payload));
//                    }
//                });
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
//                CpSdk.requestUrl(view.getContext(), "qbjQzrp7X5Az", new ResultListener() {
//                    @Override
//                    public void onPayloadResult(TaskPayload payload) {
//                        Log.d("PPP", "requestUrl|qbjQzrp7X5Az|=>|" + new Gson().toJson(payload));
//                    }
//                });
            }
        });

        CpSdk.migrate(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}