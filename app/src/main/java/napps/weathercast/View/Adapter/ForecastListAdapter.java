package napps.weathercast.View.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import javax.inject.Inject;

import napps.weathercast.Contract.ForeCastAdapterViewContract;
import napps.weathercast.Model.Forecastday;
import napps.weathercast.R;

/**
 * Created by "nithesh" on 8/1/2017.
 */

public class ForecastListAdapter extends RecyclerView.Adapter implements View.OnClickListener, ForeCastAdapterViewContract.Adapter{

    private final static String TODAY_TEXT = "Today";

    private List<Forecastday> mForecastList;

    public ForeCastAdapterViewContract.View mView;

    @Inject
    public ForecastListAdapter(ForeCastAdapterViewContract.View view){
        mView  = view;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater)LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.forecast_item, parent, false);
        return new ForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Forecastday forecastday = mForecastList.get(position*2);
        ForecastViewHolder forecastViewHolder = (ForecastViewHolder) holder;
        forecastViewHolder.itemView.setTag(position);
        forecastViewHolder.itemView.setOnClickListener(this);
        forecastViewHolder.forecastTitle.setText(position == 0? TODAY_TEXT :forecastday.getTitle());
        forecastViewHolder.forecastText.setText(forecastday.getFcttext());
        Glide.with(mView.getContext())
                .load(forecastday.getIconUrl())
                .into(forecastViewHolder.foreCastIconView);
    }

    @Override
    public int getItemCount() {
        if(mForecastList == null){
            return 0;
        }

        return mForecastList.size()/2;
    }

    @Override
    public void onClick(View v) {
        if(v.getTag() != null && v.getTag() instanceof Integer){
            mView.onItemClick((Integer)v.getTag());
        }
    }

    @Override
    public void setForeCastList(List<Forecastday> foreCastList) {
        mForecastList = foreCastList;
        notifyDataSetChanged();
    }

    public class ForecastViewHolder extends RecyclerView.ViewHolder{

        private ImageView foreCastIconView;
        private TextView forecastTitle;
        private TextView forecastText;

        public ForecastViewHolder(View itemView) {
            super(itemView);
            foreCastIconView = (ImageView) itemView.findViewById(R.id.forecast_icon);
            forecastText = (TextView) itemView.findViewById(R.id.forecast_text);
            forecastTitle = (TextView) itemView.findViewById(R.id.forecast_title);
        }
    }
}
