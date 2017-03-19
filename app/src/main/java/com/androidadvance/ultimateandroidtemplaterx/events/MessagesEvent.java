package com.androidadvance.ultimateandroidtemplaterx.events;

public class MessagesEvent {
  private final boolean mSuccess;
  private final String message;

  public MessagesEvent(boolean mSuccess, String message) {
    this.mSuccess = mSuccess;
    this.message = message;
  }

  public boolean ismSuccess() {
    return mSuccess;
  }

  public String getMessage() {
    return message;
  }
}
