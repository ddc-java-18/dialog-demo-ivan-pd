package edu.cnm.deepdive.dialogdemo.controller;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import edu.cnm.deepdive.dialogdemo.NavGraphDirections;
import edu.cnm.deepdive.dialogdemo.R;
import edu.cnm.deepdive.dialogdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements
    ExplanationFragment.AlertDismissHandler {

  private static final int PERMISSIONS_REQUEST_CODE = 314159;
  private ActivityMainBinding binding;
  private NavController navController;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    setUpNavigation();
    if (shouldRequestCameraPermission()) {
      if (shouldExplainCameraPermission()) {
        navController.navigate(NavGraphDirections.navigateToExplanationFragment());
      } else {
        onDismiss();
      }
    }
  }

  @Override
  public boolean onSupportNavigateUp() {
    return navController.navigateUp() || super.onSupportNavigateUp();
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    if (requestCode == PERMISSIONS_REQUEST_CODE) {
      if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
        // TODO: 7/15/24 Remember that we have permission to use the camera.
      }
    } else {
      super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
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

  private boolean shouldRequestCameraPermission() {
    return ContextCompat.checkSelfPermission(
        this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED;
  }

  private boolean shouldExplainCameraPermission() {
    return ActivityCompat.shouldShowRequestPermissionRationale(
        this, android.Manifest.permission.CAMERA);
  }

  @Override
  public void onDismiss() {
    requestPermissions(new String[]{Manifest.permission.CAMERA}, PERMISSIONS_REQUEST_CODE);
  }
}
