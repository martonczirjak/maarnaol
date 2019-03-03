package mmsone.com.maarnaol.description;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import mmsone.com.maarnaol.R;
import mmsone.com.maarnaol.databinding.ActivityDescriptonBinding;

public class DescriptionActivity extends AppCompatActivity {
    private ActivityDescriptonBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_descripton);

    }
}
