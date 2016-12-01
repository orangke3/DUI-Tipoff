package info.andreantaufik.tipoff.activity;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import info.andreantaufik.tipoff.R;
import info.andreantaufik.tipoff.fragment.ChatsFragment;
import info.andreantaufik.tipoff.fragment.PlayersFragment;

public class DetailPlayersActivity extends AppCompatActivity {
    public TextView getPlyrName;
    public TextView getPlyrEmail;
    public TextView getPlyrGender;
    public TextView getPlyrAge;
    public String saveName;
    public Button chatButton;

    public void chatPlayer(){
        chatButton = (Button)findViewById(R.id.chatMeNow);
        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailPlayersActivity.this, "Link to "+saveName+" Chatting Page", Toast.LENGTH_SHORT).show();
                Intent goLogin = new Intent(DetailPlayersActivity.this, DetailChatActivity.class);
                startActivity(goLogin);
                finish();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_players);

        final Bundle bundle = getIntent().getExtras();
        String nm = bundle.getString("PassPlyrName");
        String eml = bundle.getString("PassPlyrEmail");
        String gdr = bundle.getString("PassPlyrGender");
        String age = bundle.getString("PassPlyrAge");

        getPlyrName = (TextView) findViewById(R.id.getPlyrName);
        getPlyrEmail = (TextView) findViewById(R.id.getPlyrEmail);
        getPlyrGender = (TextView) findViewById(R.id.getPlyrGender);
        getPlyrAge = (TextView) findViewById(R.id.getPlyrAge);

        getPlyrName.setText(nm);
        getPlyrEmail.setText(eml);
        getPlyrGender.setText(gdr);
        getPlyrAge.setText(age);

        saveName = nm;
        chatPlayer();
    }


}
