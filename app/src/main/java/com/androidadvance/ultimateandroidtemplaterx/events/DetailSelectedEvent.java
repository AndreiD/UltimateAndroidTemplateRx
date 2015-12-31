package com.androidadvance.ultimateandroidtemplaterx.events;

import com.androidadvance.ultimateandroidtemplaterx.model.forecast.List;


public class DetailSelectedEvent {

  public List details_object;

  public DetailSelectedEvent(List details_object) {
    this.details_object = details_object;
  }
}
