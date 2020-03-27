package com.examen.ernestovaldez;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.examen.ernestovaldez.Adapters.AvailableDataListAdapter;
import com.examen.ernestovaldez.Interfaces.ApiService;
import com.examen.ernestovaldez.Managers.ApiManager;
import com.examen.ernestovaldez.Models.AvailableResponse;
import com.examen.ernestovaldez.Models.LoginResponse;
import com.examen.ernestovaldez.Utils.Globals;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity {
    ApiService apiService = ApiManager.getApiService();
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        layoutManager = new LinearLayoutManager(this);

        TextView lblRange = findViewById(R.id.lblRange);
        lblRange.setText("Disponibles (DHL)");

        final Call<AvailableResponse> getAvailableRequest = apiService.getDHLAvailables(
                Globals.getToken()
        );

        getAvailableRequest.enqueue(new Callback<AvailableResponse>() {
            @Override
            public void onResponse(Call<AvailableResponse> call, Response<AvailableResponse> response) {
                if (response.body() == null) {
                    return;
                }

                try{

                    RecyclerView recycler = findViewById(R.id.rv1);
                    recycler.setHasFixedSize(true);
                    recycler.setAdapter(null);
                    recycler.setLayoutManager(layoutManager);

                    RecyclerView.Adapter adapter = new AvailableDataListAdapter(response.body().getData());

                    recycler.setAdapter(adapter);

                } catch (Throwable t) {
                    Log.e("Error", "Could not parse malformed data: \"" + t.getLocalizedMessage() + "\"");
                }

            }

            @Override
            public void onFailure(Call<AvailableResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
