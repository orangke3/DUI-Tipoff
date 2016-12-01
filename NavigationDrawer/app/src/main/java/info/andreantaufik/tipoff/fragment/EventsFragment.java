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
import info.andreantaufik.tipoff.activity.DetailCourtsActivity;
import info.andreantaufik.tipoff.activity.DetailEventActivity;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EventsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EventsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
class DataEvents {
    String eventName;
    String organizer;
    String eventDesc;
    String eventPay;
    String eventType;
    String eventFor;
    String eventLocation;

    public DataEvents(String eventName,String organizer, String eventDesc, String eventPay, String eventFor, String eventType, String eventLocation) {
        this.eventName = eventName;
        this.organizer = organizer;
        this.eventDesc = eventDesc;
        this.eventPay = eventPay;
        this.eventType = eventType;
        this.eventFor = eventFor;
        this.eventLocation = eventLocation;
    }

    //Set-getter
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public String getEventName() {
        return eventName;
    }
    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }
    public String getOrganizer() {
        return organizer;
    }
    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }
    public String getEventDesc() {
        return eventDesc;
    }
    public void setEventPay(String eventPay) {
        this.eventPay = eventPay;
    }
    public String getEventPay() {
        return eventPay;
    }
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
    public String getEventType() {
        return eventType;
    }
    public void setEventFor(String eventFor) {
        this.eventFor = eventFor;
    }
    public String getEventFor() {
        return eventFor;
    }
    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }
    public String getEventLocation() {
        return eventLocation;
    }
}

public class EventsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public EventsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EventsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EventsFragment newInstance(String param1, String param2) {
        EventsFragment fragment = new EventsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    ArrayAdapter<String> adapterEvents;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        DataEvents events = new DataEvents("Honda DBL 2016 - Bandung Series", "JawaPos Group Multimedia", "Developmental Basketball League (DBL) was established by Azrul Ananda in Surabaya. 2004. Begining in 2008. The league expanded to other parts of the nation. In 2015, DBL was held in 25 cities and in 22 provinces in Indonesia. Over 41.000 students and officials participated in DBL in 2015. DBL was watched by over 855.000 spectators. The league will continue to expand to other parts of Indonesia. And the number of spectators is predicted to exceed 1 million people per year in the next few years.\n\nEvent : January 4th 2017 - January 24th 2017 ",
                "Rp 2.500.000 / School", "High School Students at Bandung City", "High School Mens & Womens"
                , "GOR C-TRA Arena Bandung");
        final List<DataEvents> data = new ArrayList<>();
        data.add(events);
        events = new DataEvents("Troops 3x3 2016", "FAPSI Universitas Padjadjaran", "TROOPS By Psikologi Unpad........\n\nEvent : December 14th 2016 - December 16th 2016 ",
                "Rp 250.000 / Team", "Public", "3x3 Basketball Mens", "GOR C-TRA Arena Bandung");
        data.add(events);
        events = new DataEvents("OSEAN 2017 - Cabang Basket", "BEM KEMA FMIPA Unpad", "OSEAN Basketball 2017 .....\n\nEvent : Mei 1st 2017 - Mei 24th 2017 ",
                "Rp 150.000 / Department", "Active (and 4 youngest gen) Unpad College Students of Faculty of Science",
                "College Students Mens and Womens", "Lapangan Basket MIPA (LBM)");
        data.add(events);
        events = new DataEvents("MEGA FORSI Unpad 20167- Cabang Basket", "BEM KEMA Universitas Padjadjaran" , "Mega Forsi Basketball 2017........\n\nEvent : October 15th 2017 - November 2nd 2017 ",
                "Rp 750.000 / Faculty", "Active (and 4 youngest gen) Unpad College Students",
                "College Students Mens and Womens", "Lapangan Basket Bale Unpad");
        data.add(events);

        List<String> text = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            text.add(data.get(i).getEventName());
        }

        ListView listEvents = (ListView) getActivity().findViewById(R.id.listViewEvents);
        adapterEvents = new ArrayAdapter<>(EventsFragment.this.getActivity(), R.layout.layout_list_events, R.id.EventsNameOnList, text);
        //adapterCourts.addAll(text);
        listEvents.setAdapter(adapterEvents);
        listEvents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent toKedua = new Intent(EventsFragment.this.getActivity(), DetailEventActivity.class);
                final String NameEvent = data.get(position).getEventName();
                final String organizer = data.get(position).getOrganizer();
                final String DescEvent = data.get(position).getEventDesc();
                final String PayEvent = data.get(position).getEventPay();
                final String TypeEvent = data.get(position).getEventType();
                final String ForEvent = data.get(position).getEventFor();
                final String LocEvent = data.get(position).getEventLocation();
                toKedua.putExtra("PassEventName", NameEvent);
                toKedua.putExtra("PassEventOrg", organizer);
                toKedua.putExtra("PassEventDesc", DescEvent);
                toKedua.putExtra("PassEventPay", PayEvent);
                toKedua.putExtra("PassEventType", TypeEvent);
                toKedua.putExtra("PassEventFor", ForEvent);
                toKedua.putExtra("PassEventLocation", LocEvent);

                startActivity(toKedua);
            }
        });
        SearchView inputSearch = (SearchView) getActivity().findViewById(R.id.inputSearchEvents);

        inputSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterEvents.getFilter().filter(newText);
                return false;
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        adapterEvents.notifyDataSetChanged();
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
        return inflater.inflate(R.layout.fragment_events, container, false);
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
