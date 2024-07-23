package edu.cnm.deepdive.dialogdemo;

import android.app.Application;
import androidx.appcompat.app.AppCompatDelegate;
import edu.cnm.deepdive.dialogdemo.service.NotesDatabase;

public class DialogDemoApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
    NotesDatabase.setContext(this);
  }
}
