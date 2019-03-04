package mmsone.com.maarnaol.playlist.language;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import mmsone.com.maarnaol.R;
import mmsone.com.maarnaol.databinding.LanguageItemBinding;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder> {

    private List<LanguageItem> recyclerLanguages;
    private OnLanguageClickListener listener;


    public LanguageAdapter(List<LanguageItem> ticketList, OnLanguageClickListener listener) {
        this.recyclerLanguages = ticketList;

        this.listener = listener;
    }

    public List<LanguageItem> getRecyclerLanguages() {
        return recyclerLanguages;
    }

    public void setRecyclerLanguages(List<LanguageItem> recyclerLanguages) {
        this.recyclerLanguages = recyclerLanguages;
    }



    @NonNull
    @Override
    public LanguageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        LanguageItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.language_item, viewGroup, false);
        return new LanguageViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LanguageViewHolder ticketViewHolder, int i) {
        ticketViewHolder.languageName.setText(recyclerLanguages.get(i).getLanguageName());
        ticketViewHolder.languageName.setOnClickListener(view ->{
                listener.onItemClick(recyclerLanguages.get(i));
        });
    }

    @Override
    public int getItemCount() {
        return recyclerLanguages.size();
    }

    static class LanguageViewHolder extends RecyclerView.ViewHolder {
        TextView languageName;

        LanguageViewHolder(@NonNull LanguageItemBinding itemView) {
            super(itemView.getRoot());
            languageName = itemView.txtLanguage;
        }


    }

    public interface OnLanguageClickListener {
        void onItemClick(LanguageItem item);
    }


}
