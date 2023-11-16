package com.example.pawsome;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ongoing_timers extends AppCompatActivity {
    private Button timer1,timer2,timer3,timer4,timer5;
    private TextView timer1_text,timer2_text,timer3_text,timer4_text,timer5_text;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ongoing_timers);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        timer1 = findViewById(R.id.timer1);
        timer2 = findViewById(R.id.timer2);
        timer3 = findViewById(R.id.timer3);
        timer4 = findViewById(R.id.timer4);
        timer5 = findViewById(R.id.timer5);
        timer1_text = findViewById(R.id.timer1_text);
        timer2_text = findViewById(R.id.timer2_text);
        timer3_text = findViewById(R.id.timer3_text);
        timer4_text = findViewById(R.id.timer4_text);
        timer5_text = findViewById(R.id.timer5_text);

        timer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialogue1();
            }
        });

        timer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialogue2();
            }
        });
        timer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialogue3();
            }
        });
        timer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialogue4();
            }
        });
        timer5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialogue5();
            }
        });
    }

    private void showTimePickerDialogue1() {
        final Calendar calendar = Calendar.getInstance();
        int hour,min;
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        min = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
   //             SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.getDefault());
   //             SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy", Locale.getDefault());
   //             String selectedDay = dayFormat.format(calendar.getTime());
   //             String selectedDate = dateFormat.format(calendar.getTime());
                String selectTime = hourOfDay+":"+minute;
                timer1_text.setText(selectTime);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://feedinfo-api.azurewebsites.net/api/products/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                ApiService apiService = retrofit.create(ApiService.class);
                TimeData timeData = new TimeData(selectTime);

                Call<Void> call = apiService.postTimeData(timeData);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Time data posted to server", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Failed to post time data to server", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Unable to post data to server",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        },hour,min,false);
        timePickerDialog.show();
    }
    private void showTimePickerDialogue2() {
        final Calendar calendar = Calendar.getInstance();
        int hour,min;
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        min = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
    //            SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.getDefault());
    //            SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy", Locale.getDefault());
    //            String selectedDay = dayFormat.format(calendar.getTime());
    //            String selectedDate = dateFormat.format(calendar.getTime());
                String selectTime = hourOfDay+":"+minute;
                timer2_text.setText(selectTime);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://feedinfo-api.azurewebsites.net/api/products/1")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                ApiService apiService = retrofit.create(ApiService.class);
                TimeData timeData = new TimeData(selectTime);

                Call<Void> call = apiService.postTimeData(timeData);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast.makeText(getApplicationContext(),"Data posted to server",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Unable to post data to server",Toast.LENGTH_SHORT).show();
                    }
                });


            }
        },hour,min,false);
        timePickerDialog.show();
    }
    private void showTimePickerDialogue3() {
        final Calendar calendar = Calendar.getInstance();
        int hour,min;
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        min = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
     //           SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.getDefault());
     //           SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy", Locale.getDefault());
     //           String selectedDay = dayFormat.format(calendar.getTime());
     //           String selectedDate = dateFormat.format(calendar.getTime());
                String selectTime = hourOfDay+":"+minute;
                timer3_text.setText(selectTime);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://feedinfo-api.azurewebsites.net/api/products/1")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                ApiService apiService = retrofit.create(ApiService.class);
                TimeData timeData = new TimeData(selectTime);

                Call<Void> call = apiService.postTimeData(timeData);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast.makeText(getApplicationContext(),"Data posted to server",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Unable to post data to server",Toast.LENGTH_SHORT).show();
                    }
                });


            }
        },hour,min,false);
        timePickerDialog.show();
    }
    private void showTimePickerDialogue4() {
        final Calendar calendar = Calendar.getInstance();
        int hour,min;
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        min = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.getDefault());
                SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy", Locale.getDefault());
     //           String selectedDay = dayFormat.format(calendar.getTime());
    //            String selectedDate = dateFormat.format(calendar.getTime());
                String selectTime = hourOfDay+":"+minute;
                timer4_text.setText(selectTime);
/*
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://feedinfo-api.azurewebsites.net/api/products")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                ApiService apiService = retrofit.create(ApiService.class);
                TimeData timeData = new TimeData(selectTime);

                Call<Void> call = apiService.postTimeData(timeData);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast.makeText(getApplicationContext(),"Data posted to server",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Unable to post data to server",Toast.LENGTH_SHORT).show();
                    }
                });

 */
            }
        },hour,min,false);
        timePickerDialog.show();
    }
    private void showTimePickerDialogue5() {
        final Calendar calendar = Calendar.getInstance();
        int hour,min;
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        min = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
         //       SimpleDateFormat dayFormat = new SimpleDateFormat("EEE", Locale.getDefault());
         //       SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy", Locale.getDefault());
        //        String selectedDay = dayFormat.format(calendar.getTime());
             //   String selectedDate = dateFormat.format(calendar.getTime());
                String selectTime = hourOfDay+":"+minute+" ";
                timer5_text.setText(selectTime);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://feedinfo-api.azurewebsites.net/api/products")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                ApiService apiService = retrofit.create(ApiService.class);
                TimeData timeData = new TimeData(selectTime);

                Call<Void> call = apiService.postTimeData(timeData);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast.makeText(getApplicationContext(),"Data posted to server",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Unable to post data to server",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        },hour,min,true);
        timePickerDialog.show();
    }
}