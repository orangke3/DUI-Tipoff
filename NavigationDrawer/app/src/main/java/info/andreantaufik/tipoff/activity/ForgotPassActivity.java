//ForgotPassActivity

package info.andreantaufik.tipoff.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import info.andreantaufik.tipoff.R;

public class ForgotPassActivity extends AppCompatActivity {

    public Button forgotPass;
    public EditText emailForgot;

    public void forgotEmail(){
        forgotPass = (Button)findViewById(R.id.forgotPass);
        emailForgot = (EditText)findViewById(R.id.emailForgot);

        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                String checkString = emailForgot.getText().toString();
                if(checkString.equals("")){
                    Toast.makeText(ForgotPassActivity.this, "invalid email!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(ForgotPassActivity.this, "Link has been sent to your email", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        forgotEmail();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            // do something on back.
            Intent bStart = new Intent(ForgotPassActivity.this, LoginActivity.class);
            startActivity(bStart);
            finish();

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

}
