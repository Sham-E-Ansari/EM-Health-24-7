package joker.bloodbanktest;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Profile extends Activity {

    private int userID;
    private TextView myName,myMobNo, myEmail,myLocation,myBloodGRP,myAge,myWeight,lastDateDonation, hiv, hp;
    ArrayList<String> rUserData = new ArrayList<String>();
    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getActionBar().setTitle("My Profile");

        myName = (TextView)findViewById(R.id.myNameTV);
        myMobNo = (TextView)findViewById(R.id.myNumberTV);
        myEmail = (TextView)findViewById(R.id.myEmailTV);
        myLocation = (TextView)findViewById(R.id.myLocationTV);
        myBloodGRP = (TextView)findViewById(R.id.myBldGrpTV);
        myAge = (TextView)findViewById(R.id.myAgeTV);
        myWeight = (TextView)findViewById(R.id.myWeightTV);
        lastDateDonation = (TextView)findViewById(R.id.myLastDateDonationTV);
        hp = (TextView)findViewById(R.id.showHepB);
        hiv= (TextView)findViewById(R.id.showHiv);

        //Received Data
        Intent rIntent = getIntent();
        Bundle rBundle = rIntent.getBundleExtra("USER_DATA");
        userID = rBundle.getInt("USER_ID");
        rUserData = helper.userInfo(userID);
        showInfo();
    }
    public void showInfo()
    {
        myName.setText(rUserData.get(0));
        myMobNo.setText(rUserData.get(1));
        myEmail.setText(rUserData.get(2));
        myLocation.setText(rUserData.get(3));
        myBloodGRP.setText(rUserData.get(4));
        myAge.setText(rUserData.get(5));
        myWeight.setText(rUserData.get(6));
        String t = rUserData.get(7)+ "-" + rUserData.get(8)+ "-" + rUserData.get(9);
        lastDateDonation.setText(t);
        hiv.setText(rUserData.get(10));
        hp.setText(rUserData.get(11));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.profile_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case R.id.editIn:
                Intent i = new Intent(Profile.this,EditProfile.class);
                i.putExtra("CURRENT_INFO",rUserData);
                i.putExtra("USER_ID",userID);
                startActivity(i);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
