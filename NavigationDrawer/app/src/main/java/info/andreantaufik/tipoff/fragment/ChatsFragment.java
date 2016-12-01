package info.andreantaufik.tipoff.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import info.andreantaufik.tipoff.R;
import info.andreantaufik.tipoff.activity.DetailChatActivity;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ChatsFragment.OnFragmentInteractionListener} interface
 * to handle interaction chats.
 * Use the {@link ChatsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

class DataChats {
    String chatName;

    public DataChats(String chatName) {
        this.chatName = chatName;
    }
    //Set-getter
    public void setChatName(String chatName) {
        this.chatName = chatName;
    }
    public String getChatName() {return chatName;}
}

public class ChatsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ChatsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChatsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChatsFragment newInstance(String param1, String param2) {
        ChatsFragment fragment = new ChatsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    ArrayAdapter<String> adapterChats;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        DataChats chats = new DataChats("Kobe Bryant");
        final List<DataChats> data = new ArrayList<>();
        data.add(chats);

        chats = new DataChats("Maria Selena");
        data.add(chats);
        chats = new DataChats("Coach Cipuy");
        data.add(chats);
        chats = new DataChats("Harits Muhammad");
        data.add(chats);
        chats = new DataChats("Fajar Satria");
        data.add(chats);
        chats = new DataChats("Andakara Prastawa");
        data.add(chats);
        chats = new DataChats("Denny Sumargo");
        data.add(chats);

        List<String> text = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            text.add(data.get(i).getChatName());
        }

        ListView listChats = (ListView) getActivity().findViewById(R.id.listViewChats);
        adapterChats = new ArrayAdapter<>(ChatsFragment.this.getActivity(), R.layout.layout_list_chats, R.id.PlayerChatsOnList, text);
        //adapterCourts.addAll(text);
        listChats.setAdapter(adapterChats);
        listChats.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent toKedua = new Intent(ChatsFragment.this.getActivity(), DetailChatActivity.class);
                final String nmChat = data.get(position).getChatName();
                toKedua.putExtra("PassChatName", nmChat);
                startActivity(toKedua);
            }
        });
        SearchView inputSearch = (SearchView) getActivity().findViewById(R.id.inputSearchChats);

        inputSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterChats.getFilter().filter(newText);
                return false;
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chats, container, false);
    }

    @Override
    public void onResume () {
        super.onResume();
        adapterChats.notifyDataSetChanged();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
