package edu.cnm.deepdive.dialogdemo.controller;

import android.app.Instrumentation.ActivityResult;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import edu.cnm.deepdive.dialogdemo.databinding.FragmentEditBinding;
import edu.cnm.deepdive.dialogdemo.service.ImageFileProvider;
import java.io.File;
import java.util.UUID;

public class EditFragment extends BottomSheetDialogFragment {

  private static final String AUTHORITY = ImageFileProvider.class.getName().toLowerCase();

  private final ActivityResultLauncher<Uri> takePhotoLauncher = registerForActivityResult(
      new ActivityResultContracts.TakePicture(), this::confirmCapture);

  private FragmentEditBinding binding;
  private Uri uri;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    binding = FragmentEditBinding.inflate(getLayoutInflater(), null, false);
    binding.takePicture.setOnClickListener((view) -> takePicture());
    return binding.getRoot(); // Makes sure that onViewCreated and onDestroyView get invoked.
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    // TODO: 7/15/24 Attach to viewmodel(s) and observe any LiveData of interest.
  }

  @Override
  public void onDestroyView() {
    binding = null;
    super.onDestroyView();
  }

  private void takePicture() {
    Context context = requireContext();
    File imageDir = new File(context.getFilesDir(), "captured-images");
    //noinspection ResultOfMethodCallIgnored
    imageDir.mkdir();
    File file = new File(imageDir, UUID.randomUUID().toString());
    uri = FileProvider.getUriForFile(context, AUTHORITY, file);
    takePhotoLauncher.launch(uri);
  }

  private void confirmCapture(Boolean success) {
    if (success) {
      binding.thumbnail.setImageURI(uri);
    }
  }
}
