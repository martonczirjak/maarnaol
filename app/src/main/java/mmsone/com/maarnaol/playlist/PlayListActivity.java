package mmsone.com.maarnaol.playlist;

import android.app.Dialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import mmsone.com.maarnaol.R;
import mmsone.com.maarnaol.databinding.ActivityPlayListBinding;
import mmsone.com.maarnaol.databinding.MenuDialogBinding;
import mmsone.com.maarnaol.description.DescriptionActivity;
import mmsone.com.maarnaol.musicplayer.MusicPlayerActivity;

public class PlayListActivity extends AppCompatActivity {

    private ActivityPlayListBinding binding;
    private MenuDialogBinding dialogBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_play_list);
        binding.imgMenu.setOnClickListener(view -> {
            final Dialog dialog = new Dialog(this);
            dialogBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.menu_dialog, null, false);
            dialog.setContentView(dialogBinding.getRoot());
            dialog.show();
            dialogBinding.description.setOnClickListener(it -> {
                startActivity(new Intent(this, DescriptionActivity.class));
            });
        });
        binding.list0.setOnClickListener(view -> {
            startActivity(new Intent(this, MusicPlayerActivity.class));
        });
    }
}
