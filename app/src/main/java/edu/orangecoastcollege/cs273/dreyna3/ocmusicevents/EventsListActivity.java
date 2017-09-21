package edu.orangecoastcollege.cs273.dreyna3.ocmusicevents;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EventsListActivity extends ListActivity {

    /**
     * creates the activity EventsListActivity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_events_list
        // Content has already been set by ListActivity

        // define a built in list adapter for this ListActivity
        setListAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, MusicEvent.titles));


    }

    /**
     * Handles button event from the activity_events_list
     * @param l
     * @param v
     * @param position the list item's index
     * @param id
     */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //Use the position in the list to look up in the titles array
        String title = MusicEvent.titles[position];
        String details = MusicEvent.details[position];

        //Create an Intent to go to DetailsActivity with title and details sent
        Intent detailsIntent = new Intent(this, EventDetailsActivity.class);
        detailsIntent.putExtra("title", title);
        detailsIntent.putExtra("details", details);

        startActivity(detailsIntent);
    }
}
