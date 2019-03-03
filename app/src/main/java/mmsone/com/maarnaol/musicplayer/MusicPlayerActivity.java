package mmsone.com.maarnaol.musicplayer;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import mmsone.com.maarnaol.R;
import mmsone.com.maarnaol.databinding.ActivityMusicPlayerBinding;

public class MusicPlayerActivity extends AppCompatActivity {

    private ActivityMusicPlayerBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_music_player);
    }
}
