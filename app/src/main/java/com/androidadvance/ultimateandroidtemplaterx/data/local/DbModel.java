package com.androidadvance.ultimateandroidtemplaterx.data.local;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = WeatherDatabase.class)
public class DbModel extends BaseModel {

  @PrimaryKey(autoincrement = true) long id;

  @Column String current_weather;

  @Column String forecast_weather;

  @Column long last_update_time;

  public DbModel() {
  }

  public DbModel(String current_weather, String forecast_weather, long last_update_time) {
    this.current_weather = current_weather;
    this.forecast_weather = forecast_weather;
    this.last_update_time = last_update_time;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getCurrent_weather() {
    return current_weather;
  }

  public void setCurrent_weather(String current_weather) {
    this.current_weather = current_weather;
  }

  public String getForecast_weather() {
    return forecast_weather;
  }

  public void setForecast_weather(String forecast_weather) {
    this.forecast_weather = forecast_weather;
  }

  public long getLast_update_time() {
    return last_update_time;
  }

  public void setLast_update_time(long last_update_time) {
    this.last_update_time = last_update_time;
  }

  @Override public String toString() {
    return "DbModel{" +
        "id=" + id +
        ", current_weather='" + current_weather + '\'' +
        ", forecast_weather='" + forecast_weather + '\'' +
        ", last_update_time=" + last_update_time +
        '}';
  }
}