package ie.app.cinemaxireland1.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import ie.app.cinemaxireland1.R;

/**
 * Created by sheenakelly on 22/10/2017.
 */

public class WhatsOn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.whatson);

        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(

                new AdapterView.OnItemClickListener(){

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                        startActivity(new Intent(WhatsOn.this, BookTicket.class));
                        //Toast.makeText(WhatsOn.this, "" + position, Toast.LENGTH_SHORT).show();
                    }
                }

        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cinemax_ireland, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuCinema:
                startActivity(new Intent(this, Cinemas.class));
                break;
            case R.id.menuHome:
                startActivity(new Intent(this, CinemaxIrelandActivity.class));
                break;
            case R.id.menuBookTickets: startActivity (new Intent(this, BookTicket.class));
                break;
            case R.id.menuBookingOverview: startActivity (new Intent(this, BookingOverview.class));
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private class ImageAdapter extends BaseAdapter
    {
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbsIds.length;
        }

        public Object getItem(int position){
            return null;
        }

        public long getItemId(int position){
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(mContext);
            imageView.setImageResource(mThumbsIds[position]);
            return imageView;
        }

        private Integer[] mThumbsIds = {
                R.drawable.image1,
                R.drawable.image2,
                R.drawable.image3,
                R.drawable.image4,
                R.drawable.image5,
                R.drawable.image6
                };
    }
}
