package com.example.hostelmanagmentsystemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;



import android.content.Context;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputLayout;



public class SignUp extends AppCompatActivity {

    TextInputLayout regName,userName,email,phonenNumber,idNumber,Password,cPassword;
    Button regBtn,regToLoginbtn;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();

        //Hooks to all xml element in activity sing up
        regName=findViewById(R.id.name);
        userName=findViewById(R.id.uname);
        email=findViewById(R.id.email);
        phonenNumber=findViewById(R.id.phonenumber);
        idNumber=findViewById(R.id.idnumber);
        Password=findViewById(R.id.password);
        cPassword=findViewById(R.id.confirmpassword);
        regBtn=findViewById(R.id.reg_btn);
        regToLoginbtn=findViewById(R.id.reg_login_btn);
        progressBar=findViewById(R.id.progress_bar);


        regToLoginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignUp.this,Login.class);
                startActivity(intent);
            }
        });

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //get all the values
                String Email=email.getEditText().getText().toString();
                String Pwd=Password.getEditText().getText().toString();
                String cPwd=cPassword.getEditText().getText().toString();

                boolean isValidated=validateData(Email,Pwd,cPwd);
                if (!isValidated){
                    return;
                }else {
                    createAccount(Email,Pwd);
                }


            }
        });

    }

    void createAccount(String email,String password){
        changeInProgress(true);

//        if (connection != null) {
//            String name=regName.getEditText().getText().toString();
//            String uName=userName.getEditText().getText().toString();
//            String phoneNumber=phonenNumber.getEditText().getText().toString();
//            String IDNumber=idNumber.getEditText().getText().toString();
//            String cPwd=cPassword.getEditText().getText().toString();
//
//            String query = "INSERT INTO [slcrms].[dbo].[user] (name, nic, email,phone,address,image,role,password) VALUES (?, ?, ?, ?, ?, ?,?,?)";
//            PreparedStatement statement = null;
//            try {
//                statement = connection.prepareStatement(query);
//                statement.setString(1, name);
//                statement.setString(2, IDNumber);
//                statement.setString(3, email);
//                statement.setString(4, phoneNumber);
//                statement.setString(5, uName);
//                statement.setString(6, "user4.jpg");
//                statement.setString(7, "user");
//                statement.setString(8, password);
//
//
//                int rowsAffected = statement.executeUpdate();
//                if (rowsAffected > 0) {
//                    Context context = getApplicationContext();
//                    Toast.makeText(context, "Register Successfully!", Toast.LENGTH_SHORT).show();
//                    finish();
//                } else {
//                    Context context = getApplicationContext();
//                    Toast.makeText(context, "Register Failed!", Toast.LENGTH_SHORT).show();
//                }
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//
//        }

    }

    void changeInProgress(boolean inProgress){
        if (inProgress){
            progressBar.setVisibility(View.VISIBLE);
            regBtn.setVisibility(View.GONE);
        }else {
            progressBar.setVisibility(View.GONE);
            regBtn.setVisibility(View.VISIBLE);
        }
    }
    boolean validateData(String testEmail,String TPassword,String TcPassword){
        //validate user enter data
        if(!Patterns.EMAIL_ADDRESS.matcher(testEmail).matches()){
            email.setError("Email is Invalid");
            return false;
        }
        if (TPassword.length()<6){
            email.setError("");
            Password.setError("Password Length Invaild");
            return false;
        }
        if (!TPassword.equals(TcPassword)){
            Password.setError("");
            cPassword.setError("Password not matched");
            return false;
        }
        return true;

    }


}