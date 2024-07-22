package edu.cnm.deepdive.dialogdemo.controller;

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
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import edu.cnm.deepdive.dialogdemo.R;
import edu.cnm.deepdive.dialogdemo.databinding.FragmentEditBinding;
import edu.cnm.deepdive.dialogdemo.service.ImageFileProvider;
import edu.cnm.deepdive.dialogdemo.viewmodel.NotesViewModel;
import java.io.File;
import java.util.UUID;

public class EditFragment extends BottomSheetDialogFragment {

  private static final String AUTHORITY = ImageFileProvider.class.getName().toLowerCase();

  private NotesViewModel viewModel;
  private FragmentEditBinding binding;
  private Uri uri;
  private ActivityResultLauncher<Uri> takePhotoLauncher;
  String additionalStuff; // This is just for demonstrating passing data to destinations.


  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    additionalStuff = EditFragmentArgs.fromBundle(getArguments()).getAdditionalStuff();
  }

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
    viewModel = new ViewModelProvider(requireActivity()).get(NotesViewModel.class);
    viewModel.getImageUri()
        .observe(getViewLifecycleOwner(), (uri) -> binding.thumbnail.setImageURI(uri));
    takePhotoLauncher = registerForActivityResult(
        new ActivityResultContracts.TakePicture(), viewModel::confirmImageCapture);
  }

  @Override
  public void onDestroyView() {
    binding = null;
    super.onDestroyView();
  }

  private void takePicture() {
    Context context = requireContext();
    File imageDir = new File(context.getFilesDir(), getString(R.string.images_subdirectory));
    //noinspection ResultOfMethodCallIgnored
    imageDir.mkdir();
    File file;
    do {
     file = new File(imageDir, UUID.randomUUID().toString());
    } while (file.exists());
    uri = FileProvider.getUriForFile(context, AUTHORITY, file);
    viewModel.setPendingImageUri(uri);
    takePhotoLauncher.launch(uri);
  }

}
