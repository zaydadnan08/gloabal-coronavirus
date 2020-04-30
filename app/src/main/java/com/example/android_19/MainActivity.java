package com.example.android_19;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.blongho.country_data.World;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        World.init(getApplicationContext());
        jsonmaker();

    }



    private void jsonmaker(){
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this ));

        String URL = "https://api.covid19api.com/summary";
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) { //convert JSONArray "response" to java object
                        String stats = response.toString();
                        displayer(stats); }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Rest Resp", error.toString());
                    }
                }
        );
        requestQueue.add(objectRequest);
    }


    public void updatebtn(View view){
        jsonmaker();
    }


    private void displayer(String s) {
         Gson gson = new Gson();
         GeneralInfo generalInfo = new Gson().fromJson(s, GeneralInfo.class);
        TextView gcase, gdeath, grecover;
        gcase = findViewById(R.id.gcases);
        grecover = findViewById(R.id.grecover);
        gdeath = findViewById(R.id.gdeaths);


        gcase.setText(generalInfo.getGlobal().getTotalConfirmed().toString());
        grecover.setText(generalInfo.getGlobal().getTotalRecovered().toString());
        gdeath.setText(generalInfo.getGlobal().getTotalDeaths().toString());

        recyclerAdapter = new RecyclerAdapter(generalInfo);
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                recyclerAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
