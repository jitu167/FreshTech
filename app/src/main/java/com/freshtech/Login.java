package com.freshtech;

        import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.InputStream;

public class Login extends Activity {

    Context ctxt;
    String fileName;
    SharedPreferences.Editor editor;
    String user,password,phoneno;
    public String fileextension;
    String k;
    Button login;
    InputStream is=null;
    EditText username,passw,phone;
    String [] extensions;
    SharedPreferences share;
    public void onCreate(Bundle sd)
    {
        super.onCreate(sd);
        setContentView(R.layout.login);
        ctxt=this.getApplicationContext();
        login=(Button)findViewById(R.id.button);
        // cancel=(Button)rootview.findViewById(R.id.btnCancel);
        username=(EditText)findViewById(R.id.editText);
        phone=(EditText)findViewById(R.id.editText2);
        passw=(EditText)findViewById(R.id.editText3);
        Session sess=new Session(ctxt);
        Toast.makeText(getBaseContext(), "Designed and developed by JITENDRA KUMAR", Toast.LENGTH_SHORT).show();
        if (sess.getusename().compareTo("")!=0){
                display();
        }
        else
        {
            login.setOnClickListener(new OnClickListener(){

                                         public void onClick(View v) {
                                             try
                                             {

                                                 user=username.getText().toString();
                                                 password=passw.getText().toString();
                                                 phoneno=phone.getText().toString();
                                                 Session sess=new Session(ctxt);
                                                 sess.setusename(user);
                                                 sess.setPhone(phoneno);
                                                 if(user.compareTo("")==0 ||password.compareTo("")==0||phoneno.compareTo("")==0)
                                                     Toast.makeText(getApplication().getApplicationContext(),"Input Cannot be left Blank",Toast.LENGTH_SHORT).show();
                                                 else
                                                 display();
                                             }
                                             catch(Exception e)
                                             {
                                                 CharSequence ce=e.getMessage();
                                                 Toast.makeText(getBaseContext(),e.getMessage(), Toast.LENGTH_SHORT).show();
                                                 e.printStackTrace();
                                             }
                                         }
                                     }
            );}

    }

    public void display()
    {
        Intent i=new Intent("com.freshtech.MainActivity");
        startActivity(i);
        finish();
    }



}
