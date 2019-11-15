package com.example.hw33;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.SearchView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

private SearchAdapter adapter;
private List<Search> searchList;

 ImageView pic;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navlistener);
         pic = findViewById(R.id.imageView4);


    }


    private BottomNavigationView.OnNavigationItemSelectedListener navlistener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {


                        case R.id.nav_search:
                            selectedFragment = new SearchFragment();
                            break;

                        case R.id.nav_favourites:
                            selectedFragment = new FavouritesFragment();
                            break;

                    }

   getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
 selectedFragment).commit();
                    return true;

                }
            };

//    private void fillExampleList() {
//        exampleList = new ArrayList<>();
//        exampleList.add(new ExampleItem(R.drawable.ic_android, "One", "Ten"));
//        exampleList.add(new ExampleItem(R.drawable.ic_audio, "Two", "Eleven"));
//        exampleList.add(new ExampleItem(R.drawable.ic_sun, "Three", "Twelve"));
//        exampleList.add(new ExampleItem(R.drawable.ic_android, "Four", "Thirteen"));
//        exampleList.add(new ExampleItem(R.drawable.ic_audio, "Five", "Fourteen"));
//        exampleList.add(new ExampleItem(R.drawable.ic_sun, "Six", "Fifteen"));
//        exampleList.add(new ExampleItem(R.drawable.ic_android, "Seven", "Sixteen"));
//        exampleList.add(new ExampleItem(R.drawable.ic_audio, "Eight", "Seventeen"));
//        exampleList.add(new ExampleItem(R.drawable.ic_sun, "Nine", "Eighteen"));
//    }


//
//    private void setUpRecyclerView() {
//        RecyclerView recyclerView = findViewById(R.id.searchRecycler);
//        recyclerView.setHasFixedSize(true);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
//        adapter = new SearchAdapter(searchList);
//
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);
//    }
//
//
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.search_menu, menu);
//
//        MenuItem searchItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) searchItem.getActionView();
//
//        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                adapter.getFilter().filter(newText);
//                return false;
//            }
//        });
//        return true;
//    }
}




