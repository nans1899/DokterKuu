package com.example.dokterrkuu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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

import com.example.dokterrkuu.Model.User;
import com.example.dokterrkuu.RecyclerViewPackage.ModelClass;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class DocAppointment extends AppCompatActivity {

    //INITIATE VARIABLES
    EditText uKeluh;
    Button Janji,Update, Delete;
    Spinner dropdown, dropdown2, dropdown3;
    DatabaseHelper databaseHelper;

    FirebaseUser fuser;
    DatabaseReference databaseReference;

    //AppointmentData appointmentData = new AppointmentData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_appointment);

       // Button btn1 = findViewById(R.id.CekButton);

        //btn1.setOnClickListener(new View.OnClickListener() {
          //  @Override
           // public void onClick(View v) {
            //    Intent intent = new Intent(DocAppointment.this, ShowAppointment.class);
             //   startActivity(intent);
            //}
      // });



        //FIREBASE
        fuser = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("Appointments").child(fuser.getUid());


        //CALLING DATABASEHELPER
        databaseHelper = new DatabaseHelper(this);

        //GET UI ID'S
        //uName = (EditText) findViewById(R.id.UsernameDocAppointment);
        uKeluh = (EditText) findViewById(R.id.NotesKeluhan);
        Janji = (Button) findViewById(R.id.JanjiButton);
        Update = (Button) findViewById(R.id.ReplaceButton);
        //Delete = (Button) findViewById(R.id.DeleteButton);
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
        //AddData();

        Janji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                createAppointment();
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setMessage("Are You Sure ? Once You Made an Appointment You Can Only Reschedule The Appointment").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();


            }
        });

        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Reschedule();
            }
        });
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

                boolean isInserted = databaseHelper.insertData( valuedate, diseaseValues, dValues1, dValues2, uKeluh.getText().toString());
                if(isInserted == true){
                    Toast.makeText(DocAppointment.this, "Permintaan Anda Berhasil Diteruskan", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DocAppointment.this, ActivityUtama.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(DocAppointment.this, "Gagal Meneruskan Permintaan Anda", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void createAppointment(){
                fuser = FirebaseAuth.getInstance().getCurrentUser();
                assert fuser != null;
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users").child(fuser.getUid());
                databaseReference = FirebaseDatabase.getInstance().getReference("Appointments").child(fuser.getUid());

                final String userid = fuser.getUid();

                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull final DataSnapshot dSnapshot) {
                        databaseReference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                User user = dSnapshot.getValue(User.class);
                                    Date date;
                                    DatePicker datePicker = (DatePicker) findViewById(R.id.tglReservasi);
                                    date = new Date(datePicker.getYear() - 1900, datePicker.getMonth(), datePicker.getDayOfMonth());
                                    String valuedate = date.toString();
                                    String name = user.getUsername();
                                    String keluhan = uKeluh.getText().toString();
                                    String penyakit = dropdown3.getSelectedItem().toString();
                                    String dokter = dropdown.getSelectedItem().toString();
                                    String rumahsakit = dropdown2.getSelectedItem().toString();


                                    if(keluhan == ""){
                                        keluhan = "Tidak ada keluhan";
                                        HashMap<String, String> hashMap = new HashMap<>();
                                        hashMap.put("id", userid);
                                        hashMap.put("Username", name);
                                        hashMap.put("Date", valuedate);
                                        hashMap.put("Disease", penyakit);
                                        hashMap.put("Doctor", dokter);
                                        hashMap.put("Hospital", rumahsakit);
                                        hashMap.put("Comment", keluhan);

                                        databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()){
                                                    Toast.makeText(DocAppointment.this, "Appointment Berhasil Dibuat", Toast.LENGTH_SHORT).show();
                                                    Intent intent = new Intent(DocAppointment.this, ActivityUtama.class);
                                                    startActivity(intent);
                                                }else{
                                                    Toast.makeText(DocAppointment.this, "Appointment Tidak Berhasil Dibuat", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                                    }else{
                                        String adakeluhan = uKeluh.getText().toString();
                                        HashMap<String, String> hashMap = new HashMap<>();
                                        hashMap.put("id", userid);
                                        hashMap.put("Username", name);
                                        hashMap.put("Date", valuedate);
                                        hashMap.put("Disease", penyakit);
                                        hashMap.put("Doctor", dokter);
                                        hashMap.put("Hospital", rumahsakit);
                                        hashMap.put("Comment", adakeluhan);

                                        databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()){
                                                    Toast.makeText(DocAppointment.this, "Appointment Berhasil Dibuat", Toast.LENGTH_SHORT).show();
                                                    Intent intent = new Intent(DocAppointment.this, ActivityUtama.class);
                                                    startActivity(intent);
                                                }else{
                                                    Toast.makeText(DocAppointment.this, "Appointment Tidak Berhasil Dibuat", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                                    }
                                }



                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });








    }

    public void Reschedule(){
        fuser = FirebaseAuth.getInstance().getCurrentUser();
        assert fuser != null;
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users").child(fuser.getUid());
        databaseReference = FirebaseDatabase.getInstance().getReference("Appointments").child(fuser.getUid());

        final String userid = fuser.getUid();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot dSnapshot) {
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        User user = dSnapshot.getValue(User.class);
                        if (userid.equals(null)) {
                            Toast.makeText(DocAppointment.this, "Anda Belum membuat Appointment", Toast.LENGTH_SHORT).show();
                        } else {
                            Date date;
                            DatePicker datePicker = (DatePicker) findViewById(R.id.tglReservasi);
                            date = new Date(datePicker.getYear() - 1900, datePicker.getMonth(), datePicker.getDayOfMonth());
                            String valuedate = date.toString();
                            String name = user.getUsername();
                            String keluhan = uKeluh.getText().toString();
                            String penyakit = dropdown3.getSelectedItem().toString();
                            String dokter = dropdown.getSelectedItem().toString();
                            String rumahsakit = dropdown2.getSelectedItem().toString();


                            if (keluhan == "") {
                                keluhan = "Tidak ada keluhan";
                                HashMap<String, String> hashMap = new HashMap<>();
                                hashMap.put("id", userid);
                                hashMap.put("Username", name);
                                hashMap.put("Date", valuedate);
                                hashMap.put("Disease", penyakit);
                                hashMap.put("Doctor", dokter);
                                hashMap.put("Hospital", rumahsakit);
                                hashMap.put("Comment", keluhan);

                                databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(DocAppointment.this, "Appointment Berhasil Dibuat", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(DocAppointment.this, ActivityUtama.class);
                                            startActivity(intent);
                                        } else {
                                            Toast.makeText(DocAppointment.this, "Appointment Tidak Berhasil Dibuat", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            } else {
                                String adakeluhan = uKeluh.getText().toString();
                                HashMap<String, String> hashMap = new HashMap<>();
                                hashMap.put("id", userid);
                                hashMap.put("Username", name);
                                hashMap.put("Date", valuedate);
                                hashMap.put("Disease", penyakit);
                                hashMap.put("Doctor", dokter);
                                hashMap.put("Hospital", rumahsakit);
                                hashMap.put("Comment", adakeluhan);

                                databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(DocAppointment.this, "Appointment Berhasil Dibuat", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(DocAppointment.this, ActivityUtama.class);
                                            startActivity(intent);
                                        } else {
                                            Toast.makeText(DocAppointment.this, "Appointment Tidak Berhasil Dibuat", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }


                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }





    //INI YANG MANUAL MASUKINNYA DI ONCREATE HARUSNYA
        /*
        String[] items2 = new String[]{"Rs MMC", "Rs Pertamina", "Rs Cipto Mangunkusumo", "Rs AL Minthohardjo", "Rs Pelni"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        dropdown2.setAdapter(adapter2);
        */

}
