package info.andreantaufik.tipoff.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import info.andreantaufik.tipoff.R;
import info.andreantaufik.tipoff.activity.DetailCourtsActivity;
import info.andreantaufik.tipoff.activity.DetailPlayersActivity;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PlayersFragment.OnFragmentInteractionListener} interface
 * to handle interaction players.
 * Use the {@link PlayersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

class DataPlyrs {
    String plyrName;
    String plyrEmail;
    String plyrgender;
    String plyrAge;

    public DataPlyrs(String plyrName, String plyrEmail, String plyrgender, String plyrAge) {
        this.plyrEmail = plyrEmail;
        this.plyrName = plyrName;
        this.plyrgender = plyrgender;
        this.plyrAge = plyrAge;
    }

    //Set-getter
    public void setPlyrName(String plyrName) {
        this.plyrName = plyrName;
    }
    public String getPlyrName() {return plyrName;}
    public void setPlyrEmail(String plyrEmail) {
        this.plyrEmail = plyrEmail;
    }
    public String getPlyrEmail() {
        return plyrEmail;
    }
    public void setPlyrgender(String plyrgender) {
        this.plyrgender = plyrgender;
    }
    public String getPlyrgender() {
        return plyrgender;
    }
    public void setPlyrAge(String plyrAge) {
        this.plyrAge = plyrAge;
    }
    public String getPlyrAge() {
        return plyrAge;
    }
}

public class PlayersFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private ArrayAdapter adapter;

    public PlayersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlayersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlayersFragment newInstance(String param1, String param2) {
        PlayersFragment fragment = new PlayersFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        return inflater.inflate(R.layout.fragment_players, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    ArrayAdapter<String> adapterPlyrs;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        DataPlyrs plyrs = new DataPlyrs("Andrean Taufik", "andreantaufik@live.com", "Male", "20");
        final List<DataPlyrs> data = new ArrayList<>();
        data.add(plyrs);
        plyrs = new DataPlyrs("Kobe Bryant", "kobebryant24@gmail.com", "Male", "40");
        data.add(plyrs);
        plyrs = new DataPlyrs("Anas Tazcia Lestari", "tazciaa@gmail.com", "Female", "21");
        data.add(plyrs);
        plyrs = new DataPlyrs("Maria Selena", "mariaselena0013@gmail.com", "Female", "27");
        data.add(plyrs);
        plyrs = new DataPlyrs("Coach Cipuy", "ivanalexander@gmail.com", "Male", "22");
        data.add(plyrs);
        plyrs = new DataPlyrs("Harits Muhammad", "haritsmuhammad@gmail.com", "Male", "22");
        data.add(plyrs);
        plyrs = new DataPlyrs("Fajar Satria", "ajangsinger@gmail.com", "Male", "20");
        data.add(plyrs);
        plyrs = new DataPlyrs("Daniel Wenas", "dd07wenas@gmail.com", "Male", "24");
        data.add(plyrs);
        plyrs = new DataPlyrs("Andakara Prastawa", "prasaspac@gmail.com", "Male", "24");
        data.add(plyrs);
        plyrs = new DataPlyrs("Denny Sumargo", "dennysumargo@gmail.com", "Male", "33");
        data.add(plyrs);

        List<String> text = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            text.add(data.get(i).getPlyrName());
        }

        ListView listPlyrs = (ListView) getActivity().findViewById(R.id.listPlayers);
        adapterPlyrs = new ArrayAdapter<>(PlayersFragment.this.getActivity(), R.layout.layout_list_players, R.id.PlayerNameOnList, text);
        //adapterCourts.addAll(text);
        listPlyrs.setAdapter(adapterPlyrs);
        listPlyrs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent toKedua = new Intent(PlayersFragment.this.getActivity(), DetailPlayersActivity.class);
                final String namePlayers = data.get(position).getPlyrName();
                final String emailPlayers = data.get(position).getPlyrEmail();
                final String genderPlayers = data.get(position).getPlyrgender();
                final String agePlayers = data.get(position).getPlyrAge();
                toKedua.putExtra("PassPlyrName", namePlayers);
                toKedua.putExtra("PassPlyrEmail", emailPlayers);
                toKedua.putExtra("PassPlyrGender", genderPlayers);
                toKedua.putExtra("PassPlyrAge", agePlayers);
                startActivity(toKedua);
            }
        });
        SearchView inputSearch = (SearchView) getActivity().findViewById(R.id.inputSearchPlayers);

        inputSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterPlyrs.getFilter().filter(newText);
                return false;
            }
        });
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//
//        ListView lv = (ListView) getActivity().findViewById(R.id.listPlayers);
//        SearchView inputSearch = (SearchView) getActivity().findViewById(R.id.inputSearchPlayers);
//        //strings.xml
//        Resources res = getResources();
//        final String [] players = res.getStringArray(R.array.Players);
//        final ArrayAdapter<String> adapter;
//        adapter = new ArrayAdapter<String>(getActivity(), R.layout.layout_list_players, R.id.PlayerNameOnList, players);
//        lv.setAdapter(adapter);
//        inputSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                adapter.getFilter().filter(newText);
//                return false;
//            }
//        });
//
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                //Log.d("TAG", "Item "+ position + " Selected!" );
//                //Intent myIntent = new Intent(MyFragment.this.getActivity(), MyClass.class);
//
//                Intent detPlayers = new Intent(PlayersFragment.this.getActivity(), DetailPlayersActivity.class);
//                startActivity(detPlayers);
//            }
//        });
//    }

    @Override
    public void onResume () {
        super.onResume();
        adapterPlyrs.notifyDataSetChanged();
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
