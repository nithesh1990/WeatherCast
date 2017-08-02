package napps.weathercast.View;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import napps.weathercast.Model.ForeCastDayDetail;
import napps.weathercast.R;
import napps.weathercast.databinding.ActivityDetailForeCastBinding;

public class DetailForeCastActivity extends AppCompatActivity {

    public static final String FORECAST_DETAIL = "forecast_detail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_fore_cast);
        ActivityDetailForeCastBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_fore_cast);
        Bundle extras = getIntent().getExtras();
        String detailJson;
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        if (extras != null) {
            detailJson = extras.getString(FORECAST_DETAIL, "");
            ForeCastDayDetail foreCastDayDetail = new Gson().fromJson(detailJson, ForeCastDayDetail.class);
            binding.setDetail(foreCastDayDetail);
            ImageView imageView = (ImageView)findViewById(R.id.foreCastIcon);
             Glide.with(this)
                    .load(foreCastDayDetail.getIconUrl())
                    .into(imageView);
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
