package info.andreantaufik.tipoff.activity;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import info.andreantaufik.tipoff.R;

import static android.R.attr.data;

class DataIsiChats{
    String isiPesan;

    public DataIsiChats(String isiPesan){
        this.isiPesan = isiPesan;
    }

    public void setIsiPesan(String isiPesan) {
        this.isiPesan = isiPesan;
    }
    public String getIsiPesan() {
        return isiPesan;
    }
}

public class DetailChatActivity extends AppCompatActivity {

    //public ArrayList<String> arrayList;
    public ArrayAdapter<String> adapterIsiChat;
    public EditText chatMessage;

    //public TextView getNamefromChatList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_chat);

        //final Bundle bundle = getIntent().getExtras();
        //String nm = bundle.getString("PassChatName");

        //getNamefromChatList = (TextView)findViewById(R.id.getNamefromChatList);
        //getNamefromChatList.setText(nm);

        DataIsiChats pesan = new DataIsiChats("");
        final List<DataIsiChats> data = new ArrayList<>();


        final List<String> text = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            text.add(data.get(i).getIsiPesan());
        }

        final ListView lisIsiChat = (ListView) findViewById(R.id.detChat);
        adapterIsiChat = new ArrayAdapter<>(this, R.layout.layout_isi_chat, R.id.isiChat, text);
        lisIsiChat.setAdapter(adapterIsiChat);

        chatMessage = (EditText)findViewById(R.id.chatMessage);
        Button btnSend = (Button) findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newPesan = chatMessage.getText().toString();
                text.add(newPesan);
                adapterIsiChat.notifyDataSetChanged();
                chatMessage.setText("");
            }
        });
    }



}
