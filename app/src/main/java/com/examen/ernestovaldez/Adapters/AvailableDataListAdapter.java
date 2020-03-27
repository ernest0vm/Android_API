package com.examen.ernestovaldez.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.examen.ernestovaldez.Models.AvailableData;
import com.examen.ernestovaldez.R;
import java.util.List;

public class AvailableDataListAdapter extends RecyclerView.Adapter<AvailableDataListAdapter.MyViewHolder>{

    private List<AvailableData> mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView txtType;
        public TextView txtDescription;
        public TextView txtUsed;
        public TextView txtAvailable;
        public TextView txtTotal;
        public View view;
        public MyViewHolder(View v) {
            super(v);
            view = v;
            txtType = view.findViewById(R.id.txtType);
            txtDescription = view.findViewById(R.id.txtDescription);
            txtUsed = view.findViewById(R.id.txtUsed);
            txtAvailable = view.findViewById(R.id.txtAvailables);
            txtTotal = view.findViewById(R.id.txtTotal);
        }
    }


    public AvailableDataListAdapter(List<AvailableData> myDataset) {
        mDataset = myDataset;
    }


    @Override
    public AvailableDataListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_component, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        String text = "Tipo: " + mDataset.get(position).getTipo();
        holder.txtType.setText(text);
        text = mDataset.get(position).getDescripcion();
        holder.txtDescription.setText(text);
        text = "Usadas: " + mDataset.get(position).getUsadas();
        holder.txtUsed.setText(text);
        text = "Disponibles: " + mDataset.get(position).getDisponibles();
        holder.txtAvailable.setText(text);
        text = "Total: " + mDataset.get(position).getTotal();
        holder.txtTotal.setText(text);

    }


    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
