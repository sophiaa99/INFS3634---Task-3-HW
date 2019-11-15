package com.example.hw33;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class FavouritesFragment extends Fragment {


    public static ArrayList<Search> favArray = new ArrayList<Search>();
    public static RecyclerView favRV;

public static ArrayList<Search> getFavArray() {return favArray; }
public static void setFavArray(ArrayList<Search>favArray){


    FavouritesFragment.favArray = favArray;

}

public FavouritesFragment(){

    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_favourites, container, false);

        favRV = view.findViewById(R.id.favRV);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        favRV.setLayoutManager(layoutManager);
        FavouriteAdapter myAdapter = new FavouriteAdapter();

        myAdapter.setData(favArray);
        favRV.setLayoutManager((new LinearLayoutManager(getContext())));
        favRV.setAdapter(myAdapter);
        return view;

    }


}

//
//    ArrayList<String> values=new ArrayList<String>();
//    HashSet<String> hashSet = new HashSet<String>();
//    hashSet.addAll(values);
//            values.clear();
//            values.addAll(hashSet);