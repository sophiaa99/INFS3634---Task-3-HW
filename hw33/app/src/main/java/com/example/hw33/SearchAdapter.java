package com.example.hw33;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {//} implements Filterable {

    private Context mContext;

    public static List<Search> searchToAdapt;

  //private ArrayList<Search> mExampleList;

    //RequestOptions option;


    public SearchAdapter(Context mContext, List<Search> searchToAdapt) {
        this.mContext = mContext;
        this.searchToAdapt = searchToAdapt;
        //this.mExampleList=mExampleList;

       // searchListFull = new ArrayList<>(searchToAdapt);

        //  option = new RequestOptions(.center)
    }

    public SearchAdapter(List<Search> listSearch) {
    }


    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.search_row_item, parent, false);
        final SearchViewHolder viewHolder = new SearchViewHolder(view);

        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                Intent intent = new Intent(context, SearchDetailActivity.class);
          intent.putExtra("id", searchToAdapt.get(viewHolder.getAdapterPosition()).getId());
                intent.putExtra("name", searchToAdapt.get(viewHolder.getAdapterPosition()).getName());
                intent.putExtra("description", searchToAdapt.get(viewHolder.getAdapterPosition()).getDescription());
                intent.putExtra("origin", searchToAdapt.get(viewHolder.getAdapterPosition()).getOrigin());
                intent.putExtra("weight", searchToAdapt.get(viewHolder.getAdapterPosition()).getWeight());
                intent.putExtra("termperament", searchToAdapt.get(viewHolder.getAdapterPosition()).getTemperament());
                intent.putExtra("life_span", searchToAdapt.get(viewHolder.getAdapterPosition()).getLife_span());
                intent.putExtra("wikipedia_url", searchToAdapt.get(viewHolder.getAdapterPosition()).getWikipedia_url());
                intent.putExtra("dog_friendly", searchToAdapt.get(viewHolder.getAdapterPosition()).getFriendliness());
                context.startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {

        holder.name.setText(searchToAdapt.get(position).getName());


    }

    @Override
    public int getItemCount() {

        return searchToAdapt.size();
    }

    public void filterList(ArrayList<Search> filteredList){
        searchToAdapt = filteredList;
        notifyDataSetChanged();
    }
////
//    @Override
//    public Filter getFilter() {
//        return searchFilter;
//    }

//    @Override
//    public Filter getFilter() {
//        return searchFilter;
//    }
////
//private Filter searchFilter = new Filter(){
//        @Override
//    protected FilterResults performFiltering(CharSequence constraint){
//
//            List<Search> filteredList = new ArrayList<>();
//
//            if (constraint ==null || constraint.length() ==0){
//                filteredList.addAll(searchListFull);
//
//            }else{
//                String filterPattern = constraint.toString().toLowerCase().trim();
//                 for (Search item: searchListFull){
//                     if(item.getName().toLowerCase().contains(filterPattern)){
//                         filteredList.add(item);
//
//                     }
//                 }
//            }
//            FilterResults results = new FilterResults();
//            results.values = filteredList;
//            return results;
//        }
//        @Override
//    protected void publishResults(CharSequence constraint, FilterResults results){
//            searchToAdapt.clear();
//            searchToAdapt.addAll((List) results.values);
//            notifyDataSetChanged();
//
//        }
//};

    public class SearchViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView name;
//        TextView description;
//        TextView weight;
//        TextView temperament;
//        TextView origin;
//        TextView lifeSpan;
//        TextView wikiLink;
       // TextView friendliness;
        //public ImageView image;
        ConstraintLayout view_container;


        public SearchViewHolder(View v) {
            super(v);
            view = v;
            name = v.findViewById(R.id.catName);
//            description = v.findViewById(R.id.d_description);
//            weight = v.findViewById(R.id.d_weight);
//            temperament = v.findViewById(R.id.d_temperament);
//            origin = v.findViewById(R.id.d_origin);
//            lifeSpan = v.findViewById(R.id.d_lifeSpan);
//            wikiLink = v.findViewById(R.id.d_link);
            // friendliness=v.findViewsWithText(R.id.d_friendliness);

            view_container = v.findViewById(R.id.container);


        }


    }
}
