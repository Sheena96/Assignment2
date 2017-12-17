package ie.app.cinemaxireland1.activities;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Date;

import ie.app.cinemaxireland1.R;
import ie.app.cinemaxireland1.activities.Database.DBDesigner;

/**
 * Created by sheenakelly on 05/11/2017.
 */


public class BookTicket extends AppCompatActivity{

    public Button        bookButton;
    public DatePicker    Datepick;
    public NumberPicker  amountPicker;
    public RadioGroup    paymentMethod;
    public EditText      bookingName;
    public String        BookingID;
    DBDesigner mDBDesigner;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_ticket);
        mDBDesigner = new DBDesigner(this);
        Datepick = (DatePicker) findViewById(R.id.Datepick);
        bookButton = (Button) findViewById(R.id.bookButton);
        bookingName = (EditText) findViewById(R.id.bookingName);
        paymentMethod = (RadioGroup) findViewById(R.id.paymentType);
        amountPicker = (NumberPicker) findViewById(R.id.amountPicker);

        amountPicker.setMinValue(1);
        amountPicker.setMaxValue(6);


        AddData();
    }

        // some exception handling: the use must enter their name to successfully make a booking.
        public void AddData() {
            bookButton.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (bookingName.getText().toString().length() == 0)
                                Toast.makeText(BookTicket.this, "Booking not made", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(BookTicket.this, "Booking made successfully", Toast.LENGTH_LONG).show();
                        }
                    }
            );
        }


        //Validation the data entered by the user - error with newEntry, couldn't figure out how to resolve it
    /*public void AddData(int newEntry){
        boolean insertData = mDBDesigner.addData(newEntry);

        if (insertData){
            Toast.makeText(BookTicket.this, "Data Successfully Inserted", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(BookTicket.this, "Sorry, Something went wrong", Toast.LENGTH_LONG).show();
        }
    }*/

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
            case R.id.menuBookingOverview:
                startActivity(new Intent(this, BookingOverview.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }





}






