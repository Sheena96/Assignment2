package ie.app.cinemaxireland1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Button;
import android.widget.DatePicker;

import ie.app.cinemaxireland1.R;


public class CinemaxIrelandActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinemax_ireland);

    }


    public void whatsOn(View v) {
        startActivity(new Intent(CinemaxIrelandActivity.this, WhatsOn.class));

    }
}
