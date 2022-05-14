package sg.edu.rp.c36.id21028831.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    DatePicker pickDate;
    TimePicker pickTime;
    EditText name;
    EditText phone;
    EditText pax;
    CheckBox smoke;
    Button book;
    Button reset;

    TextView outputName;
    TextView outputPhone;
    TextView outputPax;
    TextView outputSmoke;
    TextView outputDate;
    TextView outputTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pickDate=findViewById(R.id.datePicker);
        pickTime=findViewById(R.id.timePicker);
        name=findViewById(R.id.name);
        phone=findViewById(R.id.phone);
        pax=findViewById(R.id.pax);
        smoke=findViewById(R.id.smoke);
        book=findViewById(R.id.book);
        reset=findViewById(R.id.reset);


        outputName=findViewById(R.id.outputName);
        outputPhone=findViewById(R.id.outputPhone);
        outputPax=findViewById(R.id.outputPax);
        outputSmoke=findViewById(R.id.outputSmoke);
        outputDate=findViewById(R.id.outputDate);
        outputTime=findViewById(R.id.outputTime);

        pickDate.updateDate(2020, 5, 1);
        pickTime.setCurrentHour(19);
        pickTime.setCurrentMinute(30);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String customerName=name.getText().toString();
                outputName.setText(customerName);

                String customerPhone=phone.getText().toString();
                outputPhone.setText(customerPhone);

                String customerPax=pax.getText().toString();
                outputPax.setText(customerPax);

                //Smoking/Non-Smoking
                String location = "";
                if (smoke.isChecked()){
                    location="Smoking Area";
                }else{
                    location="Non-Smoking Area";
                }

                outputSmoke.setText(location);

                //Date
                final Calendar c = Calendar.getInstance();
                String month=c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());

                int displayDay=pickDate.getDayOfMonth();
                int displayYear=pickDate.getYear();

                String dayString;
                if (displayDay<10){
                    dayString="0"+(pickDate.getDayOfMonth()+"");
                }else{
                    dayString=pickDate.getDayOfMonth()+"";
                }

                String date=month + " " + dayString + " " + displayYear;
                outputDate.setText(date);

                //Time
                String displayHour=pickTime.getCurrentHour().toString();
                int displayMinute=pickTime.getCurrentMinute();

                String mintueString;
                if (displayMinute<10){
                    mintueString="0"+ (pickTime.getCurrentMinute().toString());
                }else{
                    mintueString=pickTime.getCurrentMinute().toString();
                }

                String time=displayHour + ":" + mintueString;
                outputTime.setText(time);

                String toastMsg= String.format("You have successfully booked a reservation!\n Name: %s\n Telephone: %s\n No. of Pax: %s\n Location: %s\n Booking Date: %s\n Booking Time: %s", customerName, customerPhone, customerPax, location, date, time);
                Toast.makeText(MainActivity.this, toastMsg, Toast.LENGTH_LONG).show();

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.getText().clear();
                phone.getText().clear();
                pax.getText().clear();

                pickDate.updateDate(2020, 5, 1);
                pickTime.setCurrentHour(19);
                pickTime.setCurrentMinute(30);

                outputName.setText("");
                outputPhone.setText("");
                outputPax.setText("");
                outputSmoke.setText("");
                outputDate.setText("");
                outputTime.setText("");


            }
        });

    }

}