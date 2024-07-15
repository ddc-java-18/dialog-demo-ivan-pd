package edu.cnm.deepdive.dialogdemo.controller;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import edu.cnm.deepdive.dialogdemo.R;
import edu.cnm.deepdive.dialogdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

  private ActivityMainBinding binding;
  private NavController navController;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    setUpNavigation();
  }

  @Override
  public boolean onSupportNavigateUp() {
    return navController.navigateUp() || super.onSupportNavigateUp();
  }

  private void setUpNavigation() {
    AppBarConfiguration config = new AppBarConfiguration.Builder(R.id.main_fragment)
        .build();

    //noinspection DataFlowIssue
    navController = ((NavHostFragment) getSupportFragmentManager()
        .findFragmentById(R.id.nav_host_fragment))
        .getNavController();
    NavigationUI.setupActionBarWithNavController(this, navController, config);
  }
}