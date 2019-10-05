package joker.bloodbanktest;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private Button emergencyBtn,donorProfile,findDonor,logoutBtn;

    private ArrayList<String> rUserData = new ArrayList<String>();
    private DatabaseHelper helper = new DatabaseHelper(this);
    private int userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Received Data
        Intent rIntent = getIntent();
        Bundle rBundle = rIntent.getBundleExtra("USER_DATA");
        userID = rBundle.getInt("USER_ID");

        emergencyBtn = (Button)findViewById(R.id.EmerBTN);
        donorProfile = (Button)findViewById(R.id.loginDonorBTN);
        findDonor = (Button)findViewById(R.id.findDonorBTN);
        logoutBtn = (Button)findViewById(R.id.logOutBTN);

        findDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,FindPage.class));
            }
        });

        donorProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Profile.class);
                Bundle data = new Bundle();
                data.putInt("USER_ID",userID);
                i.putExtra("USER_DATA",data);
                startActivity(i);
            }
        });

        emergencyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(MainActivity.this,EmergencyPage.class));
            }
        });

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,LoginPage.class));
                finish();

            }
        });
    }


    public void onBackPressed() {

    }
}

