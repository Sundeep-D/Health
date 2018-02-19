package com.example.android.health;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Signup extends AppCompatActivity {



    DatabaseReference database_reference;
    FirebaseDatabase database;
    EditText username;
    EditText password,mail_id,height,weight,blood;
    EditText confirm_password;
    Button signup;


    int a=1;

    Spinner gender,age;
    String usrname,mail_string,height_string,weight_string,blood_string;
    String pass,gender_string,age_string;
    String com_pass;


    ArrayList<String> available_user=new ArrayList<>();
    String count;
    Long number_of_users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);





        database_reference= FirebaseDatabase.getInstance().getReference("REGISTERED USER");
        database_reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child:dataSnapshot.getChildren() )
                {
                    String usrs=child.getValue(String.class);
                    available_user.add(usrs);
                    number_of_users=dataSnapshot.getChildrenCount();
                    count=Long.toString(number_of_users);




                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





        //--------------------------------------------------------------

        final TextView signin_textview=(TextView) findViewById(R.id.signin);
        signin_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signin_screen=new Intent(Signup.this, Login.class);
                startActivity(signin_screen);
            }
        });




        //--------------------------------------------------------------

        username=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);
        confirm_password=(EditText) findViewById(R.id.confirm_password);
        signup=(Button) findViewById(R.id.signup_button);
        mail_id=(EditText) findViewById(R.id.email);
        gender=(Spinner) findViewById(R.id.gender);
        age=(Spinner) findViewById(R.id.age);
        weight=(EditText) findViewById(R.id.weight);
        height=(EditText) findViewById(R.id.height);

        blood=(EditText) findViewById(R.id.blood);

        username.setSelected(false);
        password.setSelected(false);
        confirm_password.setSelected(false);





        //--------------------------------------------------------------

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(am_i_connected())
                {



                    usrname = username.getText().toString().trim();
                    pass = password.getText().toString().trim();
                    com_pass = confirm_password.getText().toString();
                    mail_string=mail_id.getText().toString().trim();
                    age_string=age.getSelectedItem().toString();
                    gender_string=gender.getSelectedItem().toString();
                    weight_string=weight.getText().toString().trim();
                    height_string=height.getText().toString().trim();
                    blood_string=blood.getText().toString().trim();



                    if (TextUtils.isEmpty(usrname)) {
                        Toast.makeText(Signup.this, "Enter Username", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(pass)) {
                        Toast.makeText(Signup.this, "Enter Password", Toast.LENGTH_SHORT).show();

                    } else if (TextUtils.isEmpty(com_pass)) {

                      Toast.makeText(Signup.this, "Enter Confirm Password", Toast.LENGTH_SHORT).show();

                    }
                    else if (TextUtils.isEmpty(height_string)) {

                        Toast.makeText(Signup.this, "Enter Height", Toast.LENGTH_SHORT).show();

                    }
                    else if (TextUtils.isEmpty(weight_string)) {

                        Toast.makeText(Signup.this, "Enter Weight", Toast.LENGTH_SHORT).show();

                    }

                    else if (TextUtils.isEmpty(blood_string)) {

                        Toast.makeText(Signup.this, "Enter Bloodgroup", Toast.LENGTH_SHORT).show();

                    }else {


                        for (int i = 0; i < number_of_users; i++) {
                            String check = available_user.get(i);

                            if (check.equals(usrname)) {
                                Toast.makeText(Signup.this, "Username alreadytaken", Toast.LENGTH_SHORT).show();

                            }
                        }

                                try {

                                    database_reference = FirebaseDatabase.getInstance().getReference("USER DETAILS").child(usrname);
                                    database_reference.child("PASSWORD").setValue(pass);
                                    database_reference.child("USERNAME").setValue(usrname);
                                    database_reference.child("EMAIL").setValue(mail_string);
                                    database_reference.child("GENDER").setValue(gender_string);
                                    database_reference.child("AGE").setValue(age_string);
                                    database_reference.child("WEIGHT").setValue(weight_string);
                                    database_reference.child("HEIGHT").setValue(height_string);
                                    database_reference.child("BLOODGROUP").setValue(blood_string);
                                    database_reference = FirebaseDatabase.getInstance().getReference("REGISTERED USER");
                                    database_reference.child(usrname).setValue(usrname);
                                    database_reference = FirebaseDatabase.getInstance().getReference("USERNAME_PASSWORD");
                                    database_reference.child(usrname + pass).setValue(usrname + pass);

                                    signup.setText("R E G I S T E R E D");

                                    Intent signin_screen = new Intent(Signup.this, Login.class);
                                    startActivity(signin_screen);

                                } catch (Exception e) {

                                    Toast.makeText(Signup.this, "Invalid Username", Toast.LENGTH_SHORT).show();

                                }





                    }













                }

                else


                {

                    Toast.makeText(Signup.this, "No internet Connecttion", Toast.LENGTH_SHORT).show();

//                    alert=new AlertDialog.Builder(Signup.this);
//                    alert.setPositiveButton("Dismiss", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            dialogInterface.dismiss();
//                        }
//                    })
//                            .setTitle("No Internet Connection")
//                            .create();
//                    alert.show();


                }




            }
        });




    }
    public boolean am_i_connected()
    {
        ConnectivityManager con=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info=con.getActiveNetworkInfo();

        return info!=null&&info.isConnected();
    }




}
