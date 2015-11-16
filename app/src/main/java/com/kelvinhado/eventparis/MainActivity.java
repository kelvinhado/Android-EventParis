package com.kelvinhado.eventparis;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.kelvinhado.eventparis.event.Event;
import com.kelvinhado.eventparis.fragments.EventDetailsFragment;
import com.kelvinhado.eventparis.fragments.EventsListFragment;
import com.kelvinhado.eventparis.fragments.MapFragment;

public class MainActivity extends AppCompatActivity
        implements  NavigationView.OnNavigationItemSelectedListener,
                    EventsListFragment.OnEventSelectedListenner,
                    MapFragment.OnFragmentMapInteractionListener{

    //TODO delete this textview
    private TextView tvHello;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // display the list fragment !
            final EventsListFragment eventsListFragment = EventsListFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayoutMainActivity, eventsListFragment)
                .commit();



       //  InitializeView();
       // LoadJsonFromAPI();
    }

    private void InitializeView() {
      //  tvHello = (TextView) findViewById(R.id.tvHello);

    }


    private void LoadJsonFromAPI() {

//        String url = "http://opendata.paris.fr/api/records/1.0/search?dataset=evenements-a-paris&facet=updated_at&facet=tags&facet=department&facet=region&facet=city&facet=date_start&facet=date_end&refine.date_start=2015&refine.updated_at=2015";
//        final ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//
//        // Request a string response from the provided URL.
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                //if its works
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        DataSet dataSet = null;
//                        try {
//                            dataSet = objectMapper.readValue(response, new TypeReference<DataSet>(){});
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                        tvHello.setText("Response is: "+ dataSet);
//                    }
//                },
//
//                // if it does not work
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        tvHello.setText("That didn't work!");
//                    }
//                });
//
//    // Add the request to the RequestQueue.
//        VolleyApplication.getRequestQueue().add(stringRequest);


//        EventsRequest eventRequest = new EventsRequest(
//                //if its works
//                new Response.Listener<DataSet>() {
//                    @Override
//                    public void onResponse(DataSet dataSet) {
//                        Storage.global_dataset = dataSet;
//                        String result = "";
//                        for(Event event : dataSet.getRecords()) {
//                            result += event.getFields().getTitle() + "\n";
//                        }
//                        tvHello.setText(result);
//                    }
//                },
//                // if it does not work
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        error.printStackTrace();
//                        tvHello.setText("That didn't work!");
//                    }
//                });
//        // Add the request to the RequestQueue.
//        VolleyApplication.getRequestQueue().add(eventRequest);


    }


    /*

    Fragment interactions
     */


    @Override
    public void onEventSelected(Event event) {

        // replace the current list fragment by the eventDetailsFragment using the id
        final EventDetailsFragment eventDetailsFragment = EventDetailsFragment.newInstance(event.getRecordid());
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayoutMainActivity, eventDetailsFragment)
                .commit();

    }

    @Override
    public void onFragmentMapInteraction(Uri uri) {

    }









    /*
        NAVIGATION AREA
     */





    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            // replace the current fragment by the mapFragment
            final MapFragment mapFragment = MapFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameLayoutMainActivity, mapFragment)
                    .commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Log.d("STATES", Integer.toString(id));
        if (id == R.id.nav_calendar) {
            // Handle the camera action
        } else if (id == R.id.nav_guide) {

        } else if (id == R.id.nav_map) {
            Log.d("STATES", "INTO NAV_MAP");
            // replace the current fragment by the mapFragment
            final MapFragment mapFragment = MapFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameLayoutMainActivity, mapFragment)
                    .commit();


        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
