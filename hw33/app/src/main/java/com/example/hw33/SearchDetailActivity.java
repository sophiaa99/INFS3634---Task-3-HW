package com.example.hw33;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static com.example.hw33.FavouritesFragment.favArray;

public class SearchDetailActivity extends AppCompatActivity {

    private static Button addToFav;
    private TextView dd_name;
    private TextView dd_description;
    private TextView dd_weight;
    private TextView dd_temperament;
    private TextView dd_lifeSpan;
    private TextView dd_origin;
    private TextView dd_link;
    private TextView dd_friendliness;
    private ImageView d_imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_detail);

        final String id = getIntent().getExtras().getString("id");
        final String name = getIntent().getExtras().getString("name");
        final String description = getIntent().getExtras().getString("description");
        final String weight = getIntent().getExtras().getString("weight");
        final String temperament = getIntent().getExtras().getString("termperament");
        final String origin = getIntent().getExtras().getString("origin");
        final String life_span = getIntent().getExtras().getString("life_span");
        final String wikipedia_url = getIntent().getExtras().getString("wikipedia_url");
        final int dog_friendly = getIntent().getExtras().getInt("dog_friendly");


        dd_name = findViewById(R.id.d_name);
        dd_description = findViewById(R.id.d_description);
        dd_weight = findViewById(R.id.d_weight);
        dd_temperament = findViewById(R.id.d_temperament);
        dd_origin = findViewById(R.id.d_origin);
        dd_lifeSpan = findViewById(R.id.d_lifeSpan);
        dd_link = findViewById(R.id.d_link);
        dd_friendliness = findViewById(R.id.d_dogFriend);
        addToFav = findViewById(R.id.d_addToFav);

        d_imageView = findViewById(R.id.d_image);


        dd_name.setText(name);
        dd_description.setText(description);
        dd_weight.setText("Weight: " + weight.substring(1, weight.length()-1));
        dd_temperament.setText("Temperament: " + temperament);
        dd_origin.setText("Origin: " + origin);
        dd_lifeSpan.setText("Life Span: " + life_span + " years");
        dd_link.setText("URL: " + wikipedia_url);
        dd_friendliness.setText(("Dog Freindliness Level: ")+ (Integer.toString(dog_friendly)) ) ;


        addToFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String idString = id;
                final String nameString = name;
                final String desString = description;
                final String tempString = temperament;
                final String weightString = weight;
                final String originString = origin;
                final String wikiString = wikipedia_url;
                final String lifeString = life_span;
                final int dogInt = dog_friendly;

                Toast.makeText(SearchDetailActivity.this, "Meaow!!! The " + nameString + " has been added to your favourties!!", Toast.LENGTH_SHORT).show();
                FavouritesFragment.favArray.add(new Search(idString, nameString, desString, tempString, weightString, originString, wikiString, lifeString, dogInt));


                Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(myIntent);


            }
        });


        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());


        final String url = "https://api.thecatapi.com/v1/images/search?breed_id=" +id;

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            // request = new JsonArrayRequest(url, new Response.Listener<String>()){}

            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Image[] photo = gson.fromJson(response, Image[].class);
                String URL = "";

                for (int i = 0; i < photo.length; i++) {
                    URL = photo[i].getImage_url();
                    System.out.println("working up to here");
                }

                Glide.with(SearchDetailActivity.this).load(URL).into(d_imageView);
                requestQueue.stop();
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "The request failed: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                requestQueue.stop();
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener,
                errorListener);

        requestQueue.add(stringRequest);



    }
}






