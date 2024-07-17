package edu.cnm.deepdive.dialogdemo.controller;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import edu.cnm.deepdive.dialogdemo.databinding.FragmentEditBinding;
import java.io.File;
import java.util.UUID;

public class EditFragment extends BottomSheetDialogFragment {

  private FragmentEditBinding binding;

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
    File imageDir = new File(context.getFilesDir(), "images");
    //noinspection ResultOfMethodCallIgnored
    imageDir.mkdir();
    File file = new File(imageDir, UUID.randomUUID().toString());
    Uri uri = FileProvider.getUriForFile(context, AUTHORITY, file);
    imageDir.
  }
}
