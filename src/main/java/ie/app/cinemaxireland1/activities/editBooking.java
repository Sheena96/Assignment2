package ie.app.cinemaxireland1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioGroup;
import android.widget.Toast;

import ie.app.cinemaxireland1.R;
import ie.app.cinemaxireland1.activities.Database.DBDesigner;

/**
 * Created by sheenakelly on 15/12/2017.
 */

public class editBooking extends AppCompatActivity {

    private static final String TAG = "editBooking";

    private Button updateButton;
    private Button deleteDataButton;
    public DatePicker Datepick;
    public NumberPicker amountPicker;
    public RadioGroup paymentMethod;
    public EditText bookingName;

    private EditText editable_item;
    private DatePicker editable_date;
    private NumberPicker editable_amount;
    private RadioGroup editable_method;


    DBDesigner mDBDesigner;
    private String selectedName;
    private String selectedDate;
    private String selectedAmount;
    private String selectedMethod;
    private int selectedID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_booking_layout);
        updateButton = (Button) findViewById(R.id.updateButton);
        deleteDataButton = (Button) findViewById(R.id.deleteDataButton);
        Datepick = (DatePicker) findViewById(R.id.Datepick);
        amountPicker = (NumberPicker) findViewById(R.id.amountPicker);
        paymentMethod = (RadioGroup) findViewById(R.id.paymentType);
        editable_item = (EditText) findViewById(R.id.editable_item);

        mDBDesigner = new DBDesigner(this);

        //get the intent extra from the BookingOverview
        Intent receivedIntent = getIntent();

        //get the itemID that was passed as an extra
        selectedID = receivedIntent.getIntExtra("id", -1); // -1 is the default value

        //get the name that was passed as an extra
        selectedName = receivedIntent.getStringExtra("name");

        //get the date that was passed as an extra
        selectedDate = receivedIntent.getStringExtra("date");

        //get the amount that was passed as an extra
        selectedAmount = receivedIntent.getStringExtra("amount");

        //get the name that was passed as an extra
        selectedMethod = receivedIntent.getStringExtra("method");

        //set the text to show the current selected name
        editable_item.setText(selectedName);

        /*
        * Could not set the date picker, number picker or radio buttons to display
        * what the user previously selected
        //set the text to show the current selected date
        editable_date.setDate(selectedDate);

        //set the text to show the current selected amount
        editable_amount.setAmount(selectedAmount);

        //set the text to show the current selected method
        editable_method.setMethod(selectedMethod); */


        updateName();
        updateDate();
        updateAmount();
        updateMethod();
        deleteData();

    }

    // updating the data when the update button is clicked
    public void updateName() {
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = editable_item.getText().toString();
                if (!item.equals("")) {
                    mDBDesigner.updateName(item, selectedID, selectedName);
                } else {
                    Toast.makeText(editBooking.this, "You must enter a name", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void updateDate() {
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* tried to apply the updateName method
                String date = editable_date.getDate();
                mDBDesigner.updateDate(date, selectedDate);*/
            }
        });
    }

    public void updateAmount() {
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* tried to apply the updateName method
                String amount = editable_amount.getAmount();
                mDBDesigner.updateAmount(amount, selectedAmount);*/
            }
        });
    }

    public void updateMethod() {
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* tried to apply the updateName method
                String method = editable_method.getMethod();
                mDBDesigner.updateMethod(method, selectedMethod);*/
            }
        });
    }

    public void deleteData() {
        /*deletDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                mDBDesigner.deleteData(selectedID, selectedDate ,selectedAmount, selectedMethod);
                Toast.makeText(editBooking.this, "Booking Deleted", Toast.LENGTH_LONG).show();
            }
        });
    }*/

    }
}


