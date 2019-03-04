package mmsone.com.maarnaol.playlist;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mmsone.com.maarnaol.LocaleHelper;
import mmsone.com.maarnaol.MainActivity;
import mmsone.com.maarnaol.R;
import mmsone.com.maarnaol.databinding.ActivityPlayListBinding;
import mmsone.com.maarnaol.databinding.MenuDialogBinding;
import mmsone.com.maarnaol.description.DescriptionActivity;
import mmsone.com.maarnaol.musicplayer.MusicPlayerActivity;
import mmsone.com.maarnaol.playlist.language.LanguageAdapter;
import mmsone.com.maarnaol.playlist.language.LanguageItem;

public class PlayListActivity extends AppCompatActivity implements LanguageAdapter.OnLanguageClickListener {

    private ActivityPlayListBinding binding;
    private MenuDialogBinding dialogBinding;
    private TextView textViewDesc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_play_list);
        textViewDesc = findViewById(R.id.descriptionmenu);
        binding.imgMenu.setOnClickListener(view -> {
            final Dialog dialog = new Dialog(this);
            dialogBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.menu_dialog, null, false);
            dialogBinding.recyclerView.setAdapter(new LanguageAdapter(getMockLanguges(), this));
            dialog.setContentView(dialogBinding.getRoot());
            dialog.show();
            dialogBinding.description.setOnClickListener(it -> {
                startActivity(new Intent(this, DescriptionActivity.class));
            });
            dialogBinding.btnContact.setOnClickListener(v -> {
                if (dialogBinding.lnrContactHolder.getVisibility() == View.GONE) {
                    dialogBinding.lnrContactHolder.setVisibility(View.VISIBLE);
                    dialogBinding.btnContact.setBackgroundResource(R.drawable.ic_arrow_down);
                } else {
                    dialogBinding.lnrContactHolder.setVisibility(View.GONE);
                    dialogBinding.btnContact.setBackgroundResource(R.drawable.ic_arrow_right);
                }
            });
            dialogBinding.btnLanguages.setOnClickListener(v -> {
                if (dialogBinding.recyclerView.getVisibility() == View.GONE) {
                    dialogBinding.recyclerView.setVisibility(View.VISIBLE);
                    dialogBinding.btnLanguages.setBackgroundResource(R.drawable.ic_arrow_down);
                } else {
                    dialogBinding.recyclerView.setVisibility(View.GONE);
                    dialogBinding.btnLanguages.setBackgroundResource(R.drawable.ic_arrow_right);
                }
            });
        });
        binding.list0.setOnClickListener(view -> {
            startActivity(new Intent(this, MusicPlayerActivity.class));
        });

    }

    private List<LanguageItem> getMockLanguges() {
        List<LanguageItem> items = new ArrayList<>();
        items.add(new LanguageItem("Angol"));
        items.add(new LanguageItem("Német"));
        items.add(new LanguageItem("Orosz"));
        items.add(new LanguageItem("Magyar"));
        items.add(new LanguageItem("Lett"));
        items.add(new LanguageItem("Litván"));
        items.add(new LanguageItem("Bulgár"));
        items.add(new LanguageItem("Román"));
        items.add(new LanguageItem("Horvát"));
        items.add(new LanguageItem("Szlovák"));
        items.add(new LanguageItem("Szerb"));
        items.add(new LanguageItem("Görög"));
        items.add(new LanguageItem("Olasz"));
        items.add(new LanguageItem("Francia"));
        items.add(new LanguageItem("Spanyol"));
        items.add(new LanguageItem("Portugál"));
        items.add(new LanguageItem("Svájc"));
        items.add(new LanguageItem("Kína"));
        items.add(new LanguageItem("Japán"));
        items.add(new LanguageItem("Mongol"));
        items.add(new LanguageItem("Észt"));
        items.add(new LanguageItem("Finn"));
        return items;
    }

    @Override
    public void onItemClick(LanguageItem item) {
        if (item.getLanguageName().equals("Német"))  setNewLocale("gem");

        if (item.getLanguageName().equals("Magyar")) setNewLocale("hu");

        if (item.getLanguageName().equals("Angol")) setNewLocale("en");

        if (item.getLanguageName().equals("Brazil")) setNewLocale("pt-rBR");

        if (item.getLanguageName().equals("Francia"))  setNewLocale("fr");

        if (item.getLanguageName().equals("Lengyel"))  setNewLocale("pl");

        if (item.getLanguageName().equals("Olasz"))  setNewLocale("it");

        if (item.getLanguageName().equals("Orosz")) setNewLocale("ru");

        if (item.getLanguageName().equals("Spanyol")) setNewLocale("es");

    }

    private void setNewLocale(String language){
        Context context;
        context = LocaleHelper.setLocale(PlayListActivity.this,language);
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase));
    }

}
