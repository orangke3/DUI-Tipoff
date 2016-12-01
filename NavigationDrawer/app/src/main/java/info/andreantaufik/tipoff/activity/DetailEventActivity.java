package info.andreantaufik.tipoff.activity;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.TextView;

import info.andreantaufik.tipoff.R;
import info.andreantaufik.tipoff.fragment.CourtsFragment;
import info.andreantaufik.tipoff.fragment.EventsFragment;

public class DetailEventActivity extends AppCompatActivity {
    public TextView getEventName;
    public TextView getOrganizer;
    public TextView getEventDesc;
    public TextView getEventPay;
    public TextView getEventType;
    public TextView getEventFor;
    public TextView getEventLoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_event);

        final Bundle bundle = getIntent().getExtras();
        String nm = bundle.getString("PassEventName");
        String org = bundle.getString("PassEventOrg");
        String dsc = bundle.getString("PassEventDesc");
        String py = bundle.getString("PassEventPay");
        String typ = bundle.getString("PassEventType");
        String fr = bundle.getString("PassEventFor");
        String loc = bundle.getString("PassEventLocation");


        getEventName = (TextView) findViewById(R.id.getEventName);
        getOrganizer = (TextView) findViewById(R.id.getOrganizer);
        getEventDesc = (TextView) findViewById(R.id.getEventDesc);
        getEventPay = (TextView) findViewById(R.id.getEventPay);
        getEventType = (TextView) findViewById(R.id.getEventType);
        getEventFor = (TextView) findViewById(R.id.getEventFor);
        getEventLoc = (TextView) findViewById(R.id.getEventLoc);

        getEventName.setText(nm);
        getOrganizer.setText(org);
        getEventDesc.setText(dsc);
        getEventPay.setText(py);
        getEventType.setText(typ);
        getEventFor.setText(fr);
        getEventLoc.setText(loc);
    }


}
