package ie.app.cinemaxireland1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.android.gms.maps.OnMapReadyCallback;

import ie.app.cinemaxireland1.R;

/**
 * Created by sheenakelly on 13/12/2017.
 */

public class Cinemas extends FragmentActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the layout view that renders the map.
        setContentView(R.layout.activity_maps);
        // Get the SupportMapFragment and request a notification when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }
    /* When the map is ready to be used, a notification is sent and
      * we can add markers, lines etc. to the map */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            // Add a marker in Sydney, Australia,
            // and move the map's camera to the same location.
            LatLng waterford = new LatLng(-52.26, 7.110);
            googleMap.addMarker(new MarkerOptions().position(waterford)
                    .title("Marker in Waterford"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(waterford));
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cinemax_ireland, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuMovies:
                startActivity(new Intent(this, WhatsOn.class));
                break;
            case R.id.menuHome:
                startActivity(new Intent(this, CinemaxIrelandActivity.class));
                break;
            case R.id.menuBookTickets: startActivity (new Intent(this, BookTicket.class));
            break;
        }
        return super.onOptionsItemSelected(item);
    }

}
