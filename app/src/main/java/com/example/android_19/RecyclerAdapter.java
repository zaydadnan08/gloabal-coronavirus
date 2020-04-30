package com.example.android_19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.blongho.country_data.World;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> implements Filterable {
    private static final String TAG = "RecyclerAdapter";
    GeneralInfo generalInfos;
    List<UserSimple> countryListAll;
    public RecyclerAdapter(GeneralInfo generalInfos)
    {

        this.generalInfos = generalInfos;
        this.countryListAll = new ArrayList<UserSimple>(generalInfos.getCountries());
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.stats, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.countryText.setText(generalInfos.getCountries().get(position).getCountry());
        holder.totalConfirmed.setText(generalInfos.getCountries().get(position).getTotalConfirmed().toString());
        holder.totalDeaths.setText(generalInfos.getCountries().get(position).getTotalDeaths().toString());
        holder.totalRecovered.setText(generalInfos.getCountries().get(position).getTotalRecovered().toString());
        holder.newConfirmed.setText(generalInfos.getCountries().get(position).getNewConfirmed().toString());
        holder.newDeaths.setText(generalInfos.getCountries().get(position).getNewDeaths().toString());
        holder.newRecovered.setText(generalInfos.getCountries().get(position).getNewRecovered().toString());
       // holder.newRecovered.setText(countryPicker.getCountryByISO("KE").getCurrency());

        final int flag = World.getFlagOf(generalInfos.getCountries().get(position).getCountryCode());
        holder.countryflag.setImageResource(flag);

        boolean isExpanded = generalInfos.getCountries().get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }


    @Override
    public int getItemCount() {
        return generalInfos.getCountries().size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        //runs on a background thread
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<UserSimple> filteredList = new ArrayList<>();

            if(constraint.toString().isEmpty()){
                filteredList.addAll(countryListAll);
            } else {
                for (int i = 0; i < countryListAll.size(); i++) {
                    String country = countryListAll.get(i).getCountry();
                    if (country.toLowerCase().contains(constraint.toString().toLowerCase())) {
                        filteredList.add(countryListAll.get(i));
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }
        //run on a ui thread
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            generalInfos.getCountries().clear();
            generalInfos.getCountries().addAll((Collection<? extends UserSimple>) results.values);
            notifyDataSetChanged();

        }
    };


    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView countryflag;
        TextView countryText, totalConfirmed, totalDeaths, totalRecovered, newConfirmed, newDeaths, newRecovered;
        TextView  gcase, gdeath, grecovers;
        LinearLayout expandableLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            countryflag = itemView.findViewById(R.id.imageView2);
            countryText = itemView.findViewById(R.id.countryText);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);

            totalConfirmed = itemView.findViewById(R.id.totalConfirmed);
            totalDeaths = itemView.findViewById(R.id.totalDeaths);
            newRecovered = itemView.findViewById(R.id.newRecovered);
            totalRecovered = itemView.findViewById(R.id.totalRecovered);
            newConfirmed = itemView.findViewById(R.id.newConfirmed);
            newDeaths = itemView.findViewById(R.id.newDeaths);


            //gdeath.setText(generalInfos.getGlobal().getTotalDeaths().toString());
            // grecovers.setText(generalInfos.getGlobal().getTotalRecovered().toString());

            countryText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    UserSimple generalInfo = generalInfos.getCountries().get(getAdapterPosition());
                    generalInfo.setExpanded(!generalInfo.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}
