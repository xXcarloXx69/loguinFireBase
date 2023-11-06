package com.example.loguinfirebase;

import static android.app.ProgressDialog.show;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class iniciarSesion extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText correo , pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        correo= findViewById(R.id.txt_email);
        pass = findViewById(R.id.txt_contraseña);
        mAuth= FirebaseAuth.getInstance();
    }
    @Override
    public void onStart(){
        super.onStart();

        FirebaseUser current = mAuth.getCurrentUser();
    }
    public void IniciarSesion(View view){
        mAuth.signInWithEmailAndPassword(correo.getText().toString(),pass.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "ha ingresado correctamente",Toast.LENGTH_SHORT).show();
                    FirebaseUser user = mAuth.getCurrentUser();
                }else{
                    Toast.makeText(getApplicationContext(),"autorizacion fallida",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}