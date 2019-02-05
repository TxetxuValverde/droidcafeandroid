package com.example.droidcafe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        rg = findViewById(R.id.delivery_options);

        Spinner spinner = findViewById(R.id.label_spinner);

        if (spinner != null) {
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                    this, R.array.labels_array, android.R.layout.simple_spinner_item);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner.setAdapter(adapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String spinnerLabel = parent.getItemAtPosition(position).toString();
                    displayToast(spinnerLabel);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    displayToast(R.string.nothing_selected);
                }
            });




        }
    }

    public void displayToast(int idMessage) {
        displayToast(getString(idMessage));
    }

    public void displayToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void onRadioButtonClicked(View view) {
        int id = rg.getCheckedRadioButtonId();

        switch (id) {
            case R.id.sameday:
                displayToast(R.string.same_day_messenger_service);
                break;
            case R.id.nextday:
                displayToast(R.string.next_day_ground_delivery);
                break;
            case R.id.pickup:
                displayToast(R.string.pick_up);
                break;
            default:
                displayToast(R.string.not_expected_option);
        }
    }

}
