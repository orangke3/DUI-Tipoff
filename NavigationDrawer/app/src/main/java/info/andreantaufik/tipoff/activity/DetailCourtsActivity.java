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

public class DetailCourtsActivity extends AppCompatActivity {
    public TextView getCourtName;
    public TextView getCourtAddress;
    public TextView getCourtPrice;
    public TextView getCourtType;
    public TextView getCourtSchedule;
    public TextView getCourtCondition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_courts);

        final Bundle bundle = getIntent().getExtras();
        String nm = bundle.getString("PassCourtName");
        String adrs = bundle.getString("PassCourtAddress");
        String prc = bundle.getString("PassCourtPrice");
        String typ = bundle.getString("PassCourtType");
        String sch = bundle.getString("PassCourtSchedule");
        String con = bundle.getString("PassCourtCondition");

        getCourtName = (TextView) findViewById(R.id.getCourtName);
        getCourtAddress = (TextView) findViewById(R.id.getCourtAddress);
        getCourtPrice = (TextView) findViewById(R.id.getCourtPrice);
        getCourtType = (TextView) findViewById(R.id.getCourtType);
        getCourtSchedule = (TextView) findViewById(R.id.getCourtSchedule);
        getCourtCondition = (TextView) findViewById(R.id.getCourtCondition);

        getCourtName.setText(nm);
        getCourtAddress.setText(adrs);
        getCourtPrice.setText(prc);
        getCourtType.setText(typ);
        getCourtSchedule.setText(sch);
        getCourtCondition.setText(con);
    }
}
