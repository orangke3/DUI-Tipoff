package info.andreantaufik.tipoff.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import info.andreantaufik.tipoff.R;
import info.andreantaufik.tipoff.fragment.PlayersFragment;

import static info.andreantaufik.tipoff.R.id.btnRegister;
import static info.andreantaufik.tipoff.R.id.btnLogHome;

class DataPlayers {
    String email;
    String password;

    public DataPlayers(String email, String password) {
        this.email = email;
        this.password = password;
    }

    //Set-getter
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {return email; }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
}

public class LoginActivity extends AppCompatActivity {

    public Button btnLogHome;
    public EditText loginEmail;
    public EditText loginPassword;

    public void logHome(final List<DataPlayers> data){
        btnLogHome = (Button)findViewById(R.id.btnLogHome);
        btnLogHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = loginEmail.getText().toString();
                String password = loginPassword.getText().toString();

                Intent goLogin = new Intent(LoginActivity.this, MainActivity.class);
                if (cekLogin(email, password, data)) {
                    goLogin.putExtra("PassUsersEmail", email);
                    startActivity(goLogin);
                    finish();
                }
                else{
                    Toast.makeText(LoginActivity.this, "Invalid Email/Password!", Toast.LENGTH_SHORT).show();
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            // do something on back.
            Intent bStart = new Intent(LoginActivity.this, StartActivity.class);
            startActivity(bStart);
            finish();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    public TextView backReg, goForgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loginEmail = (EditText) findViewById(R.id.loginEmail);
        loginPassword = (EditText) findViewById(R.id.loginPassword);
        DataPlayers user = new DataPlayers("users", "users");

        List<DataPlayers> data = new ArrayList<>();
        data.add(user);
        user = new DataPlayers("andreantaufik@live.com", "andre");
        data.add(user);
        user = new DataPlayers("tazciaa@gmail.com", "anas");
        data.add(user);
        user = new DataPlayers("admin", "admin");
        data.add(user);

        backReg = (TextView)findViewById(R.id.backReg);
        goForgot = (TextView)findViewById(R.id.goForgot);

        backReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bReg = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(bReg);
                finish();
            }
        });

        goForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bFor = new Intent(LoginActivity.this, ForgotPassActivity.class);
                startActivity(bFor);
                finish();
            }
        });

        logHome(data);
    }

    public boolean cekLogin(String email, String password, List<DataPlayers> data) {
        for(int i = 0; i < data.size(); i++) {
            DataPlayers temp = data.get(i);
            if (email.equals(temp.getEmail()) && password.equals(temp.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
