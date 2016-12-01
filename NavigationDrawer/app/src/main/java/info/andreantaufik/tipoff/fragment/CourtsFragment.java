package info.andreantaufik.tipoff.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import info.andreantaufik.tipoff.R;
import info.andreantaufik.tipoff.activity.DetailCourtsActivity;
import info.andreantaufik.tipoff.activity.DetailPlayersActivity;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CourtsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CourtsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
class DataCourts {
    String courtName;
    String courtAddress;
    String courtPrice;
    String courtType;
    String courtSchedule;
    String courtCondition;

    public DataCourts(String courtName, String courtAddress, String courtPrice, String courtType, String courtSchedule, String courtCondition) {
        this.courtName = courtName;
        this.courtAddress = courtAddress;
        this.courtPrice = courtPrice;
        this.courtType = courtType;
        this.courtSchedule = courtSchedule;
        this.courtCondition = courtCondition;
    }

    //Set-getter
    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }
    public String getCourtName() {
        return courtName;
    }
    public void setCourtAddress(String courtAddress) {
        this.courtAddress = courtAddress;
    }
    public String getCourtAddress() {
        return courtAddress;
    }
    public void setCourtPrice(String courtPrice) {
        this.courtPrice = courtPrice;
    }
    public String getCourtPrice() {
        return courtPrice;
    }
    public void setCourtType(String courtType) {
        this.courtType = courtType;
    }
    public String getCourtType() {
        return courtType;
    }
    public void setCourtSchedule(String courtSchedule) {
        this.courtSchedule = courtSchedule;
    }
    public String getCourtSchedule() {
        return courtSchedule;
    }
    public void setCourtCondition(String courtCondition) {
        this.courtCondition = courtCondition;
    }
    public String getCourtCondition() {
        return courtCondition;
    }
}

public class CourtsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CourtsFragment() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static CourtsFragment newInstance(String param1, String param2) {
        CourtsFragment fragment = new CourtsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    //public TextView getCourtName;
    //public TextView getCourtAddress;
    ArrayAdapter<String> adapterCourts;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        DataCourts courts = new DataCourts("GOR C-TRA Arena", "Cikutra, Bandung", "Rp 500.000 / Shift", "Complete Indoor", "All Day - Night Shift Only", "National League Standard");
        final List<DataCourts> data = new ArrayList<>();
        data.add(courts);
        courts = new DataCourts("Lapangan Basket FK", "C6 Building, Medical Faculty, Unpad, Jatinangor", "Rp 100.000 / Shift", "Complete Indoor", "Weekday - Morning, Noon, Afternoon, Night", "Overall Good, Minus at Lighting");
        data.add(courts);
        courts = new DataCourts("Bale Basket Universitas Padjadjaran", "Bale Unpad, Jatinangor", "Free", "Complete Indoor", "Weekday - Morning, Noon, Afternoon, Night", "National College League Standard");
        data.add(courts);
        courts = new DataCourts("Lapangan Basket MIPA (LBM)", "Science Faculty, Unpad, Jatinangor", "Free", "Outdoor", "Afternoon Only", "Overall Bad - Broken Floor *May injure*");
        data.add(courts);

        List<String> text = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            text.add(data.get(i).getCourtName());
        }

        ListView listCourt = (ListView) getActivity().findViewById(R.id.listViewCourts);
        adapterCourts = new ArrayAdapter<>(CourtsFragment.this.getActivity(), R.layout.layout_list_courts, R.id.CourtsNameOnList, text);
        //adapterCourts.addAll(text);
        listCourt.setAdapter(adapterCourts);
        listCourt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent toKedua = new Intent(CourtsFragment.this.getActivity(), DetailCourtsActivity.class);
                    final String NameCourt = data.get(position).getCourtName();
                    final String AddressCourt = data.get(position).getCourtAddress();
                    final String PriceCourt = data.get(position).getCourtPrice();
                    final String TypeCourt = data.get(position).getCourtType();
                    final String ScheduleCourt = data.get(position).getCourtSchedule();
                    final String ConditionCourt = data.get(position).getCourtCondition();
                    toKedua.putExtra("PassCourtName", NameCourt);
                    toKedua.putExtra("PassCourtAddress", AddressCourt);
                    toKedua.putExtra("PassCourtPrice", PriceCourt);
                    toKedua.putExtra("PassCourtType", TypeCourt);
                    toKedua.putExtra("PassCourtSchedule", ScheduleCourt);
                    toKedua.putExtra("PassCourtCondition", ConditionCourt);

                startActivity(toKedua);
            }
        });
        SearchView inputSearch = (SearchView) getActivity().findViewById(R.id.inputSearchCourts);

        inputSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterCourts.getFilter().filter(newText);
                return false;
            }
        });

//        ListView lv = (ListView) getActivity().findViewById(R.id.listCourts);
//        Resources res = getResources();
//        //final String [] courts = res.getText(R.array.)
//        final String [] courtsName = res.getStringArray(R.array.CourtsName);
//        final ArrayAdapter<String> adapter;
//        adapterCourts.addAll(text);
//        adapter = new ArrayAdapter<String>(getActivity(), R.layout.layout_list_courts, R.id.CourtsNameOnList, courtsName);
//        lv.setAdapter(adapterCourts);


//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                //Log.d("TAG", "Item "+ position + " Selected!" );
//                //Intent myIntent = new Intent(MyFragment.this.getActivity(), MyClass.class);
//                Intent detCourts = new Intent(CourtsFragment.this.getActivity(), DetailCourtsActivity.class);
//                startActivity(detCourts);
//            }
//        });


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
        return inflater.inflate(R.layout.fragment_courts, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        adapterCourts.notifyDataSetChanged();
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
