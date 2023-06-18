package com.app.uas_quran;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.uas_quran.Model.AyatIndo.CombinedItem;

import java.util.List;

public class AyatIndoAdapter extends RecyclerView.Adapter<AyatIndoAdapter.ViewHolder> {

    private static List<CombinedItem> list;

    public AyatIndoAdapter(List<CombinedItem> list){
        this.list = list;
    }

    @NonNull
    @Override
    public AyatIndoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.ayat, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull AyatIndoAdapter.ViewHolder holder, int position) {
        CombinedItem item = list.get(position);

        holder.textViewAyat.setText(item.getTextUthmani());
        holder.textViewNomorAyat.setText(String.valueOf(position + 1));
        holder.textViewArti.setText(item.getText());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(List<CombinedItem> result) {
        list.clear();
        list.addAll(result);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewAyat, textViewNomorAyat, textViewArti;
        public ViewHolder(View itemView) {
            super(itemView);
            textViewAyat = itemView.findViewById(R.id.tvAyat);
            textViewArti = itemView.findViewById(R.id.tvTerjemahanAyat);
            textViewNomorAyat = itemView.findViewById(R.id.tvNomorAyat);
        }
    }
}
