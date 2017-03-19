package com.androidadvance.ultimateandroidtemplaterx;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.androidadvance.ultimateandroidtemplaterx.data.remote.APIService;
import com.androidadvance.ultimateandroidtemplaterx.view.main.MainActivity;
import javax.inject.Inject;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;

@RunWith(AndroidJUnit4.class) public class MainActivityTest {

  private static final String CITY_NAME = "Sofia,bg";

  @Rule public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

  @Inject APIService apiService;

  //@Before public void setUp() {
  //  apiService = ((BaseApplication) activityTestRule.getActivity().getApplication()).getApplicationComponent().apiService();
  //}
  //
  //@Test public void correctWeatherDataDisplayed() {
  //  WeatherPojo weatherData = apiService.getWeatherForCity(CITY_NAME, "metric").toBlocking().first();
  //  //onView(withId(R.id.button_get_weather)).perform(click());
  //  onView(withId(R.id.textview_main_city)).check(matches(withText(containsString("Sofia"))));
  //}
  //
  //@Test public void correctOtherShit() {
  //  WeatherPojo weatherData = apiService.getWeatherForCity(CITY_NAME, "metric").toBlocking().first();
  //  onView(withId(R.id.button_main_next_days)).perform(click());
  //
  //  //continue...
  //
  //}
}