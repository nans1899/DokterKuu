package com.example.dokterrkuu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.Date;

public class DocAppointment extends AppCompatActivity {

    //INITIATE VARIABLES
    EditText uName,uKeluh;
    Button Janji;
    Spinner dropdown, dropdown2, dropdown3;
    DatabaseHelper databaseHelper;

    //AppointmentData appointmentData = new AppointmentData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_appointment);

        Button btn1 = findViewById(R.id.CekButton);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DocAppointment.this, ShowAppointment.class);
                startActivity(intent);
            }
        });

        //CALLING DATABASEHELPER
        databaseHelper = new DatabaseHelper(this);

        //GET UI ID'S
        uName = (EditText) findViewById(R.id.UsernameDocAppointment);
        uKeluh = (EditText) findViewById(R.id.NotesKeluhan);
        Janji = (Button) findViewById(R.id.JanjiButton);

        //GET SPINNER ID'S
        dropdown = findViewById(R.id.spinner1);
        dropdown2 = findViewById(R.id.spinner2);
        dropdown3 = findViewById(R.id.spinner3);

        //THE SPECIALIST
        final String[] specialValues = new String[]{"Penglihatan","Kesehatan Gigi","Pernafasan","Pencernaan","Sakit Kepala","Kesehatan Jantung","Pendengaran","Tulang"};

        //THE DOCTORS
        final String[] Penglihatan = {"Prof. Dr. Darwin Dalimunthe","Prof. Dr. Enrique Immanuel","Prof. Dr. Enrico Herlambang"};
        final String[] Kesehatangigi = {"Prof. Dr. DjokoSoemantri","Prof. Dr. M. Hidayat","Prof. Dr. Enrico Herlambang"};
        final String[] Pernafasan = {"Prof. Dr. dr. Harianto N","Prof. Dr. M. Hidayat","Prof. Dr. Dhea Deminto"};
        final String[] Lambung = {"Prof. Dr. Soetjipto","Prof. Dr. Austin Deminto","Prof. Dr. dr. Harianto N","Prof. Dr. DjokoSoematri"};
        final String[] SakitKepala = {"Prof. Dr. Darwin Dalimunthe","Prof. Dr. Enrico Herlambang","","Prof. Dr. Dhea Deminto"};
        final String[] KesehatanJantung = {"Prof. Dr. Ezra Adiwena","Prof. Dr. Austin Deminto","Prof. Dr. Enrico Herlambang"};
        final String[] Pendengaran = {"Prof. Dr. dr. Harianto N","Prof. Dr. Dhea Deminto","Prof. Dr. dr. Daniel Colunga"};
        final String[] Tulang = {"Prof. Dr. Ezra Adiwena","Prof. Dr. Enrique Immanuel","Prof. Dr. dr. Harianto N","Prof. Dr. M. Hidayat"};

        //THE HOSPITALS
        final String[] drHarianto = {"Rs Cipto Mangunkusumo","Rs Al Minthohardjo","Rs MMC"};
        final String[] drDjokoSoematri = {"Rs Pertamina","Rs MMC","Hospital Tanggerang"};
        final String[] drMHidayat = {"Rs Pelni","Rs Pertamina","Rs MMC"};
        final String[] drSoetjipto = {"Rs Pelni","Rs Pertamina","Hospital Tanggerang"};
        final String[] drDarwin = {"Rs Cipto Mangunkusumo","Rs MMC", "Rs Al Minthohardjo"};
        final String[] drEzra = {"Rs Hermina Tanjung Priok","Rs Mitra Keluarga", "Rs Hermina Kartini Bekasi"};
        final String[] drDhea = {"Rs Hermina Kartini Bekasi","Rs Cipto Mangunkusumo","Hospital Tanggerang"};
        final String[] drAustin={"Rs Pelni","Rs Hermina Tanjung Priok","Rs Cipto Mangunkusumo"};
        final String[] drEnrico={"Rs Hermina Kartini Bekasi","Rs Cipto Mangunkusumo","Rs Pertamina"};
        final String[] drEnrique={"Rs Al Minthohardjo","Rs Pertamina","Rs Hermina Tanjung Priok"};
        final String[] drDaniel={"Hospital Tanggerang","Rs Pelni","Rs MMC"};


        //POPULATING FROM ARRAY SPECIALIST
        final ArrayAdapter<String> adapterSC = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, specialValues);
        dropdown3.setAdapter(adapterSC);

        //POPULATE FROM THE SPECIALIST
        dropdown3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemSelect = specialValues[position];
                //  FIRST
                if(position == 0){
                    ArrayAdapter<String> adapterfromSC1 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, Penglihatan);
                    dropdown.setAdapter(adapterfromSC1);

                    dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String docSelect = Penglihatan[position];
                            if(position == 0){
                                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drDarwin);
                                dropdown2.setAdapter(adapter2);
                            }
                            if(position == 1){
                                ArrayAdapter<String> adapter22 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drEnrique);
                                dropdown2.setAdapter(adapter22);
                            }
                            if(position == 2){
                                ArrayAdapter<String> adapter23 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drEnrico);
                                dropdown2.setAdapter(adapter23);
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                }


                // SECOND
                if(position == 1){
                    ArrayAdapter<String> adapterfromSC2 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, Kesehatangigi );
                    dropdown.setAdapter(adapterfromSC2);

                    dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String docSelect = Kesehatangigi[position];
                            if(position == 0){
                                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drDjokoSoematri);
                                dropdown2.setAdapter(adapter2);
                            }
                            if(position == 1){
                                ArrayAdapter<String> adapter22 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drMHidayat);
                                dropdown2.setAdapter(adapter22);
                            }
                            if(position == 2){
                                ArrayAdapter<String> adapter23 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drEnrico);
                                dropdown2.setAdapter(adapter23);
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }


                // THIRD
                if(position == 2){
                    ArrayAdapter<String> adapterfromSC3 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, Pernafasan );
                    dropdown.setAdapter(adapterfromSC3);

                    dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String docSelect = Pernafasan[position];
                            if(position == 0){
                                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drHarianto);
                                dropdown2.setAdapter(adapter2);
                            }
                            if(position == 1){
                                ArrayAdapter<String> adapter22 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drMHidayat);
                                dropdown2.setAdapter(adapter22);
                            }
                            if(position == 2){
                                ArrayAdapter<String> adapter23 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drDhea);
                                dropdown2.setAdapter(adapter23);
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }

                // FOURTH
                if(position == 3){
                    ArrayAdapter<String> adapterfromSC4 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, Lambung );
                    dropdown.setAdapter(adapterfromSC4);

                    dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String docSelect = Lambung[position];
                            if(position == 0){
                                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drSoetjipto);
                                dropdown2.setAdapter(adapter2);
                            }
                            if(position == 1){
                                ArrayAdapter<String> adapter22 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drAustin);
                                dropdown2.setAdapter(adapter22);
                            }
                            if(position == 2){
                                ArrayAdapter<String> adapter23 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drHarianto);
                                dropdown2.setAdapter(adapter23);
                            }
                            if(position == 3){
                                ArrayAdapter<String> adapter24 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drDjokoSoematri);
                                dropdown2.setAdapter(adapter24);
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                }


                //  FIFTH
                if(position == 4){
                    ArrayAdapter<String> adapterfromSC5 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, SakitKepala );
                    dropdown.setAdapter(adapterfromSC5);

                    dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String docSelect = SakitKepala[position];
                            if(position == 0){
                                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drDarwin);
                                dropdown2.setAdapter(adapter2);
                            }
                            if(position == 1){
                                ArrayAdapter<String> adapter22 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drEnrico);
                                dropdown2.setAdapter(adapter22);
                            }
                            if(position == 2){
                                ArrayAdapter<String> adapter23 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drDhea);
                                dropdown2.setAdapter(adapter23);
                            }

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                }


                //   SIXTH
                if(position == 5){
                    ArrayAdapter<String> adapterfromSC6 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, KesehatanJantung );
                    dropdown.setAdapter(adapterfromSC6);

                    dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String docSelect = KesehatanJantung[position];
                            if(position == 0){
                                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drEzra);
                                dropdown2.setAdapter(adapter2);
                            }
                            if(position == 1){
                                ArrayAdapter<String> adapter22 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drAustin);
                                dropdown2.setAdapter(adapter22);
                            }
                            if(position == 2){
                                ArrayAdapter<String> adapter23 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drEnrico);
                                dropdown2.setAdapter(adapter23);
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                }


                //    SEVENTH
                if(position == 6){
                    ArrayAdapter<String> adapterfromSC7 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, Pendengaran);
                    dropdown.setAdapter(adapterfromSC7);

                    dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String docSelect = Pendengaran[position];
                            if(position == 0){
                                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drHarianto);
                                dropdown2.setAdapter(adapter2);
                            }
                            if(position == 1){
                                ArrayAdapter<String> adapter22 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drDhea);
                                dropdown2.setAdapter(adapter22);
                            }
                            if(position == 2){
                                ArrayAdapter<String> adapter23 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drDaniel);
                                dropdown2.setAdapter(adapter23);
                            }

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }


                // EIGHTH
                if(position == 7){
                    ArrayAdapter<String> adapterfromSC8 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, Tulang);
                    dropdown.setAdapter(adapterfromSC8);

                    dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String docSelect = Tulang[position];
                            if(position == 0){
                                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drEzra);
                                dropdown2.setAdapter(adapter2);
                            }
                            if(position == 1){
                                ArrayAdapter<String> adapter22 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drEnrique);
                                dropdown2.setAdapter(adapter22);
                            }
                            if(position == 2){
                                ArrayAdapter<String> adapter23 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drHarianto);
                                dropdown2.setAdapter(adapter23);
                            }
                            if(position == 3){
                                ArrayAdapter<String> adapter24 = new ArrayAdapter<String>(DocAppointment.this, android.R.layout.simple_spinner_dropdown_item, drMHidayat);
                                dropdown2.setAdapter(adapter24);
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //METHOD FOR APPOINTMENT BUTTON
        AddData();

    }

    public void AddData(){
        Janji.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Date date;
                //GET DROPDOWN VALUES
                String diseaseValues = dropdown3.getSelectedItem().toString();
                String dValues1 = dropdown.getSelectedItem().toString();
                String dValues2 = dropdown2.getSelectedItem().toString();

                //GET DATEPICKER ID
                 DatePicker datePicker = (DatePicker) findViewById(R.id.tglReservasi);

                 /*
                //GET DATEPICKER VALUES
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth();
                int year = datePicker.getYear();
                Calendar calendar = Calendar.getInstance();
                calendar.set(day, month, year);

                //CONVERTING TO SIMPLE DATE FORMAT STRING
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String formatDate = sdf.format(calendar.getTime());
                  */

                date = new Date(datePicker.getYear() - 1900, datePicker.getMonth(), datePicker.getDayOfMonth());
                String valuedate = date.toString();

                boolean isInserted = databaseHelper.insertData(uName.getText().toString(), valuedate, diseaseValues, dValues1, dValues2, uKeluh.getText().toString());
                if(isInserted = true){
                    Toast.makeText(DocAppointment.this, "Data Successfuly inserted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(DocAppointment.this, "Failed Inserting The Data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    //CREATE DB


    //INI YANG MANUAL MASUKINNYA DI ONCREATE HARUSNYA
        /*
        String[] items2 = new String[]{"Rs MMC", "Rs Pertamina", "Rs Cipto Mangunkusumo", "Rs AL Minthohardjo", "Rs Pelni"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        dropdown2.setAdapter(adapter2);
        */

}
