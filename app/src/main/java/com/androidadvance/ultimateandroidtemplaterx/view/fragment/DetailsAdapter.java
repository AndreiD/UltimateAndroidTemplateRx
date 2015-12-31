package com.androidadvance.ultimateandroidtemplaterx.view.fragment;

import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import com.androidadvance.ultimateandroidtemplaterx.R;
import com.androidadvance.ultimateandroidtemplaterx.events.DetailSelectedEvent;
import com.androidadvance.ultimateandroidtemplaterx.view.main.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;

import de.greenrobot.event.EventBus;
import timber.log.Timber;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.ViewHolder> {
  private final int NOTIFY_DELAY = 500;
  private List<com.androidadvance.ultimateandroidtemplaterx.model.forecast.List> mListForecast;

  public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    @Bind(R.id.row_textView_forecast) TextView row_textView_forecast;
    @Bind(R.id.row_imageView_forecast) ImageView row_imageView_forecast;
    @Bind(R.id.row_details_cardview) CardView row_details_cardview;

    public ViewHolder(View view) {
      super(view);
      ButterKnife.bind(this, view);

      row_details_cardview.setOnClickListener(this);
    }

    @Override public void onClick(View view) {
      EventBus.getDefault().post(new DetailSelectedEvent((com.androidadvance.ultimateandroidtemplaterx.model.forecast.List) view.getTag()));
    }
  }

  public DetailsAdapter(List<com.androidadvance.ultimateandroidtemplaterx.model.forecast.List> list_forecast) {
    mListForecast = list_forecast;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_details, parent, false);

    return new ViewHolder(v);
  }

  @Override public void onBindViewHolder(ViewHolder viewHolder, int position) {
    com.androidadvance.ultimateandroidtemplaterx.model.forecast.List mForecast = mListForecast.get(position);

    Picasso.with(viewHolder.row_imageView_forecast.getContext()).load(MainActivity.getIcon(mForecast.getWeather().get(0).getId())).into(viewHolder.row_imageView_forecast);

    viewHolder.row_textView_forecast.setText(String.format("%s %s %s", mForecast.getDtTxt(), mForecast.getMain().getTempMin(), mForecast.getMain().getTempMax()));
    viewHolder.row_details_cardview.setTag(mForecast);
  }

  @Override public long getItemId(int position) {
    return mListForecast.get(position).getDt();
  }

  @Override public int getItemCount() {
    return mListForecast.size();
  }

  public void addForecast(final com.androidadvance.ultimateandroidtemplaterx.model.forecast.List forecast, final int position) {
    // notify of the insertion with a delay, so there is a brief pause after returning
    // from the new book screen; this makes the animation more noticeable
    Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
      @Override public void run() {
        mListForecast.add(position, forecast);
        notifyItemInserted(position);
      }
    }, NOTIFY_DELAY);
  }

  public void removeForecast(final int position) {
    mListForecast.remove(position);

    // notify of the removal with a delay so there is a brief pause after returning
    // from the book details screen; this makes the animation more noticeable
    Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
      @Override public void run() {
        notifyItemRemoved(position);
      }
    }, NOTIFY_DELAY);
  }
}