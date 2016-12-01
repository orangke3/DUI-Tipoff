//RegisterActivity

package info.andreantaufik.tipoff.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

import info.andreantaufik.tipoff.R;
import info.andreantaufik.tipoff.fragment.CalendarFragment;

public class RegisterActivity extends AppCompatActivity {

    public EditText regName, regEmail, regPass, regConfPass;
    public Button btnRegLog;

    public void regLog(){
        btnRegLog = (Button)findViewById(R.id.btnRegLog);
        regName = (EditText)findViewById(R.id.regName);
        regEmail = (EditText)findViewById(R.id.regEmail);
        regPass = (EditText)findViewById(R.id.regPass);
        regConfPass = (EditText)findViewById(R.id.regConfPass);

        btnRegLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String checkRegName = regName.getText().toString();
                String checkRegEmail = regEmail.getText().toString();
                String checkRegPass = regPass.getText().toString();
                String checkRegConf = regConfPass.getText().toString();
                if(checkRegName.equals("") || checkRegEmail.equals("") || checkRegPass.equals("") || checkRegConf.equals("")){
                    Toast.makeText(RegisterActivity.this, "All field must be input!", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(!checkRegPass.equals(checkRegConf)){
                        Toast.makeText(RegisterActivity.this, "Password doesn't match!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Intent toLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(toLogin);
                        finish();
                    }
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, StartActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public TextView backLog;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            // do something on back.
            Intent bStart = new Intent(RegisterActivity.this, StartActivity.class);
            startActivity(bStart);
            finish();

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    public Spinner gender;
    ArrayAdapter<CharSequence> adapter;


    public  Button pickDate;
    public TextView lblDate, lblError;
    int year_x, month_x, day_x;
    static final int DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //setContentView(R.layout.activity_register);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gender = (Spinner)findViewById(R.id.gender);
        adapter = ArrayAdapter.createFromResource(this, R.array.gender, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        gender.setAdapter(adapter);

        backLog = (TextView)findViewById(R.id.backLog);

        backLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bLog = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(bLog);
                finish();
            }
        });

        regLog();

        final Calendar cal = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);

        showDialogOnButtonClick();
    }

    public void showDialogOnButtonClick(){
        lblDate = (TextView)findViewById(R.id.lblDate);
        pickDate = (Button)findViewById(R.id.pickDate);
        pickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id){
        if(id==DIALOG_ID){
            return new DatePickerDialog(this, dpickerListener, year_x,month_x,day_x);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener dpickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {


            year_x = year;
            month_x = month;
            day_x = dayOfMonth;

            int bulan = month_x;
            String bln = Integer.toString(bulan);
            if((month_x+1) == 1){
                bln = "January";
            }
            else if((month_x+1) == 2){
                bln = "February";
            }
            else if((month_x+1) == 3){
                bln = "March";
            }
            else if((month_x+1) == 4){
                bln = "April";
            }
            else if((month_x+1) == 5){
                bln = "May";
            }
            else if((month_x+1) == 6){
                bln = "June";
            }
            else if((month_x+1) == 7){
                bln = "July";
            }
            else if((month_x+1) == 8){
                bln = "August";
            }
            else if((month_x+1) == 9){
                bln = "September";
            }
            else if((month_x+1) == 10){
                bln = "October";
            }
            else if((month_x+1) == 11){
                bln = "November";
            }
            else if((month_x+1) == 12){
                bln = "December";
            }

            int hari = day_x;
            String hr = Integer.toString(hari);
            if(day_x ==1 || day_x == 11 || day_x == 31){
                hr = "st";
            }
            else if(day_x ==2 || day_x == 12 || day_x == 22){
                hr = "nd";
            }
            else if(day_x ==3 || day_x == 13 || day_x == 23){
                hr = "rd";
            }
            else{
                hr = "th";
            }

            //Toast.makeText(RegisterActivity.this,  (bln) + ", " + day_x+(hr) + " " +  year_x , Toast.LENGTH_SHORT).show();

            lblDate.setText(new StringBuilder()
                    .append(day_x).append(" ").append(bln).append(" ").append(year_x));
        }

    };

}