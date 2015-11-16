package com.kelvinhado.eventparis.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.kelvinhado.eventparis.R;
import com.kelvinhado.eventparis.event.DataSet;
import com.kelvinhado.eventparis.event.Event;
import com.kelvinhado.eventparis.event.Events;
import com.kelvinhado.eventparis.event.Storage;
import com.kelvinhado.eventparis.network.EventsRequest;
import com.kelvinhado.eventparis.network.VolleyApplication;


public class EventsListFragment extends ListFragment {

    OnEventSelectedListenner mListener = null;
    private Events events;
    private EventsListAdapter lvAdapter;


    public EventsListFragment() {
        // Required empty public constructor
    }
    public static EventsListFragment newInstance() {
        EventsListFragment myFragment = new EventsListFragment();
        Bundle args = new Bundle();
        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        if (getActivity() != null)
//            stationContractName = getActivity().getIntent().getExtras().getString(Tags.TAG_STATION_CONTRACT_NAME);


        events = new Events();
        lvAdapter = new EventsListAdapter(getActivity(), events);

    }

    @Override
    public void onStart() {
        super.onStart();

        EventsRequest eventRequest = new EventsRequest(
                //if its works
                new Response.Listener<DataSet>() {
                    @Override
                    public void onResponse(DataSet dataSet) {
                        Storage.global_dataset = dataSet;
                        populateListView(dataSet.getRecords());
                    }
                },
                // if it does not work
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
        // Add the request to the RequestQueue.
        VolleyApplication.getRequestQueue().add(eventRequest);
    }


    private void populateListView(Events events) {
        lvAdapter = new EventsListAdapter(getActivity(), events);
        setListAdapter(lvAdapter);
    }



       /* To hundle interation, the activity must implements this interface */

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnEventSelectedListenner) activity;
        } catch (ClassCastException e) {
            // Unchecked exception.
            throw new ClassCastException(activity.toString()
                    + " must implement OnCustomItemSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // Send the event to the host activity
        Event event = (Event) getListView().getItemAtPosition(position);
        mListener.onEventSelected(event);
    }

    public // Interface interne
    interface OnEventSelectedListenner {
        void onEventSelected(Event event);
    }


}