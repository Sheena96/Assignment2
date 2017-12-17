package ie.app.cinemaxireland1.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListViewCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import ie.app.cinemaxireland1.R;
import ie.app.cinemaxireland1.activities.Database.DBDesigner;

/**
 * Created by sheenakelly on 14/12/2017.
 */

public class BookingOverview extends AppCompatActivity
{
    private static final String TAG = "BookingOverview";

    DBDesigner mDBDesigner;

    private ListView mListView;


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_overview);
        mListView = (ListView) findViewById(R.id.overviewList);
        mDBDesigner = new DBDesigner(this);

        populateListView();
    }


    private void populateListView() {
        Log.d(TAG, "populateListView: Displaying data in the ListView.");

        //get the data and add it to the array list
        Cursor data = mDBDesigner.getData();
        ArrayList<String> overviewList = new ArrayList<>();
        while (data.moveToNext()) {
            /*get the data from column 1 then it is added to the array list
            * data.getString(1) is getting the data from my first column
            * which is COL2 in this case (date) as COL1 (ID) is technically
            * column 0
            * repeat this to add data for each column*/
            overviewList.add(data.getString(1));
            overviewList.add(data.getString(2));
            overviewList.add(data.getString(3));
            overviewList.add(data.getString(4));
        }

        //Creating an adapter and setting the adapter
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, overviewList);
        mListView.setAdapter(adapter);

    }


                /*
                Cursor data = mDBDesigner.getItemID(name); //get the ID associated with that name
                int itemID = -1;
                while(data.moveToNext()) { // retrieve the data by using the .moveToNext method
                    itemID = data.getInt(0);
                }
                //error handling
                if(itemID > -1) {
                    Log.d(TAG, "onItemClick: The ID is: " + itemID);
                    Intent editScreenIntent = new Intent(BookingOverview.this, editBooking.class);
                    editScreenIntent.putExtra("id", itemID);
                    editScreenIntent.putExtra("name", name);
                    editScreenIntent.putExtra("date", date);
                    editScreenIntent.putExtra("amount", amount);
                    editScreenIntent.putExtra("method", method);

                    startActivity(editScreenIntent);
                }
                else{
                    toastMessage("No ID associated with that name");
                }

            }


        });*/

    /*
    Yummy Toast
     */
    private void toastMessage(String message)
    {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cinemax_ireland, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menuCinema: startActivity (new Intent(this, Cinemas.class));
                break;
            case R.id.menuMovies: startActivity (new Intent(this, WhatsOn.class));
                break;
            case R.id.menuHome:
                startActivity(new Intent(this, CinemaxIrelandActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
