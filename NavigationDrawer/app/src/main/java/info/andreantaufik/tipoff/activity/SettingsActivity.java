package info.andreantaufik.tipoff.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.os.Vibrator;
import android.widget.Toast;

import info.andreantaufik.tipoff.R;

public class SettingsActivity extends AppCompatActivity {

    Switch switchFontSize;
    Switch switchNightMode;
    Switch switchNotifications;

    TextView tvGeneral;
    TextView tvNotif;
    TextView switchFontSizeDesc;
    TextView switchNightModeDesc;
    TextView switchNotificationsDesc;

    LinearLayout layoutSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tvGeneral = (TextView) findViewById(R.id.tvGeneral);
        tvNotif = (TextView) findViewById(R.id.tvNotif);
        switchFontSizeDesc = (TextView) findViewById(R.id.switchFontSizeDesc);
        switchNightModeDesc = (TextView) findViewById(R.id.switchNightModeDesc);
        switchNotificationsDesc = (TextView) findViewById(R.id.switchNotificationsDesc);

        layoutSettings = (LinearLayout) findViewById(R.id.activity_settings);

        switchFontSize = (Switch) findViewById(R.id.switchFontSize);
        switchFontSize.setChecked(false);
        switchFontSize.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tvGeneral.setTextSize(30);
                    switchFontSize.setTextSize(24);
                    switchFontSizeDesc.setTextSize(20);
                    switchNightMode.setTextSize(24);
                    switchNightModeDesc.setTextSize(20);
                    tvNotif.setTextSize(30);
                    switchNotifications.setTextSize(24);
                    switchNotificationsDesc.setTextSize(20);
                }else{
                    tvGeneral.setTextSize(24);
                    switchFontSize.setTextSize(18);
                    switchFontSizeDesc.setTextSize(14);
                    switchNightMode.setTextSize(18);
                    switchNightModeDesc.setTextSize(14);
                    tvNotif.setTextSize(24);
                    switchNotifications.setTextSize(18);
                    switchNotificationsDesc.setTextSize(14);
                }
            }
        });

        switchNightMode = (Switch) findViewById(R.id.switchNightMode);
        switchNightMode.setChecked(false);
        switchNightMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    layoutSettings.setBackgroundColor(Color.parseColor("#222222"));
                    tvGeneral.setTextColor(Color.parseColor("#eaa525"));
                    switchFontSize.setTextColor(Color.parseColor("#ffffff"));
                    switchFontSizeDesc.setTextColor(Color.parseColor("#9b9b9b"));
                    switchNightMode.setTextColor(Color.parseColor("#ffffff"));
                    switchNightModeDesc.setTextColor(Color.parseColor("#9b9b9b"));
                    tvNotif.setTextColor(Color.parseColor("#eaa525"));
                    switchNotifications.setTextColor(Color.parseColor("#ffffff"));
                    switchNotificationsDesc.setTextColor(Color.parseColor("#9b9b9b"));
                }else{
                    layoutSettings.setBackgroundColor(Color.parseColor("#fafafa"));
                    tvGeneral.setTextColor(Color.parseColor("#eaa525"));
                    switchFontSize.setTextColor(Color.parseColor("#000000"));
                    switchFontSizeDesc.setTextColor(Color.parseColor("#514e4e"));
                    switchNightMode.setTextColor(Color.parseColor("#000000"));
                    switchNightModeDesc.setTextColor(Color.parseColor("#514e4e"));
                    tvNotif.setTextColor(Color.parseColor("#eaa525"));
                    switchNotifications.setTextColor(Color.parseColor("#000000"));
                    switchNotificationsDesc.setTextColor(Color.parseColor("#514e4e"));
                }
            }
        });


        switchNotifications = (Switch) findViewById(R.id.switchNotifications);
        switchNotifications.setChecked(true);
        switchNotifications.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(getApplicationContext(), "Notifications switched to ON!", Toast.LENGTH_SHORT).show();
                    Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(400);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Notifications switched to OFF!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            // finish the activity
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
