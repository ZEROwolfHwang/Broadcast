package wolf.zero.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    private static String actionToast = "wolf.zero.myapplication.MyReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String action = intent.getAction();
        String info = intent.getStringExtra("info");
        if (action == actionToast) {
            Toast.makeText(context, info, Toast.LENGTH_SHORT).show();
        }

    }
}
