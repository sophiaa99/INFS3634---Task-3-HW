package com.example.hw33;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;



public class SearchFragment extends Fragment {

    private final String JSON_URL = "https://api.thecatapi.com/v1/breeds?api_key=037a37db-0a43-4d70-8fa6-2baa2410db9c";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Search> listSearch;
    SearchAdapter myAdapter = new SearchAdapter(getContext(), listSearch);
    private RecyclerView recyclerView;

    public SearchFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        recyclerView = view.findViewById(R.id.searchRecycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        listSearch = new ArrayList<>();
        Database.saveSearchToDatabase(listSearch);
        final SearchAdapter searchAdapter = new SearchAdapter(getContext(), listSearch);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(searchAdapter);


        EditText editText = view.findViewById(R.id.editText);


        jsonrequest();

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());


            }
        });

        return view;

    }

    private void filter(String text) {
        ArrayList<Search> filteredList = new ArrayList<>();

        for (Search item : listSearch) {
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);

            }
        }

        setuprecyclerview(filteredList);
        myAdapter.filterList(filteredList);

    }


    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;

                for (int i = 0; i < response.length(); i++) {

                    try {
                        jsonObject = response.getJSONObject(i);
                        Search search = new Search();
                        search.setId(jsonObject.getString("id"));
                        search.setName(jsonObject.getString("name"));
                        search.setDescription(jsonObject.getString("description"));
                        search.setLife_span(jsonObject.getString("life_span"));
                        search.setTemperament(jsonObject.getString("temperament"));
                        search.setWeight(jsonObject.getString("weight"));
                        search.setOrigin(jsonObject.getString("origin"));
                        search.setFriendliness(jsonObject.getInt("dog_friendly"));
                        search.setWikipedia_url(jsonObject.getString("wikipedia_url"));

                        listSearch.add(search);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setuprecyclerview(listSearch);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // requestQueue.stop();
            }
        });

        requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(request);
    }

    private void setuprecyclerview(List<Search> listSearch) {

        SearchAdapter searchAdapter = new SearchAdapter(getContext(), listSearch);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(searchAdapter);

    }

}