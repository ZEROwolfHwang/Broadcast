package wolf.zero.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static String mainAction = "wolf.zero.myapplication.MainActivity";

    private Button mButton;
    private Intent mIntent;
    private LocalBroadcastManager mManager;
    private HehedaBroadcast mBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*mIntent = new Intent("wolf.zero.myapplication.MyReceiver");
                mIntent.putExtra("info", "DSB");
                sendBroadcast(mIntent);*/

                Intent intent = new Intent();
                intent.setAction(mainAction);
                mManager.sendBroadcast(intent);
            }
        });
        mManager = LocalBroadcastManager.getInstance(MainActivity.this);

        IntentFilter filter = new IntentFilter();
        filter.addAction(mainAction);

        mBroadcast = new HehedaBroadcast();

        mManager.registerReceiver(mBroadcast, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mManager.unregisterReceiver(mBroadcast);
    }

    public class HehedaBroadcast extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "128741931", Toast.LENGTH_SHORT).show();
        }
    }

}
