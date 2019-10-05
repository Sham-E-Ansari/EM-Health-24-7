package joker.bloodbanktest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EmergencyPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_page);

        getActionBar().setTitle("Emergency Ambulance");

        Uri gmmIntentUri = Uri.parse("geo:0,0?q=Ambulance+Service");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        //mapIntent.putExtra("rankBy","distance");
        startActivity(mapIntent);
    }
}

