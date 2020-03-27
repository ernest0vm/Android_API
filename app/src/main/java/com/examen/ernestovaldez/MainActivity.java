package com.examen.ernestovaldez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.examen.ernestovaldez.Interfaces.ApiService;
import com.examen.ernestovaldez.Managers.ApiManager;
import com.examen.ernestovaldez.Models.LoginResponse;
import com.examen.ernestovaldez.Utils.Globals;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ApiService apiService = ApiManager.getApiService();
    Intent listIntent;

    @BindView(R.id.edtEmail)
    EditText edtEmail;

    @BindView(R.id.edtPassword)
    EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        listIntent = new Intent(this, ListActivity.class);
    }

    @OnClick(R.id.btnLogin)
    public void onBtnLoginClicked() {

        if (edtEmail.getText().length() == 0) {
            Log.e("login error", "email is empty");
            Toast.makeText(this, "El correo no debe estar vacio", Toast.LENGTH_SHORT).show();
            return;
        }

        if (edtPassword.getText().length() == 0) {
            Log.e("login error", "password is empty");
            Toast.makeText(this, "La contraseña no debe estar vacia", Toast.LENGTH_SHORT).show();
            return;
        }

        final Call<LoginResponse> loginRequest = apiService.login(
                edtEmail.getText().toString(),
                edtPassword.getText().toString()
        );

        loginRequest.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.body() == null) {
                    return;
                }

                if (response.body().getData().getMessage() != null){
                    Toast.makeText(getApplicationContext(), response.body().getData().getMessage(), Toast.LENGTH_SHORT).show();
                    return;
                }

                Globals.setToken(response.body().getData().getToken());
                edtEmail.setText("");
                edtPassword.setText("");
                startActivity(listIntent);
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
