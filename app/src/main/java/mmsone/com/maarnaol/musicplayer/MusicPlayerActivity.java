package mmsone.com.maarnaol.musicplayer;

import android.animation.ObjectAnimator;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;

import mmsone.com.maarnaol.R;
import mmsone.com.maarnaol.databinding.ActivityMusicPlayerBinding;

public class MusicPlayerActivity extends AppCompatActivity {

    private ActivityMusicPlayerBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_music_player);
        ObjectAnimator flip = ObjectAnimator.ofFloat(binding.logo, "rotationY", 90f, -90f);
        flip.setDuration(2800);
//        flip.setInterpolator(new DecelerateInterpolator());
        float scale = getApplicationContext().getResources().getDisplayMetrics().density;
        binding.logo.setCameraDistance(8000 * scale);
        flip.setRepeatCount(Animation.INFINITE);
        flip.start();
    }
}
