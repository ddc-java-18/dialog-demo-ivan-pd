package edu.cnm.deepdive.dialogdemo.controller;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import edu.cnm.deepdive.dialogdemo.databinding.FragmentMainBinding;
import edu.cnm.deepdive.dialogdemo.viewmodel.NotesViewModel;

public class MainFragment extends Fragment {

  FragmentMainBinding binding;
  private NotesViewModel viewModel;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    binding = FragmentMainBinding.inflate(inflater, container, false);
    binding.showEditFragment.setOnClickListener((v) ->
        Navigation.findNavController(binding.getRoot())
            .navigate(MainFragmentDirections.navigateToEditFragment()
                .setAdditionalStuff("example argument")));
    // TODO: 7/15/24 Attach listeners to widgets in binding fields.
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(requireActivity()).get(NotesViewModel.class);
    viewModel.getNotes().observe(getViewLifecycleOwner(), (notes) -> {
      // TODO: 7/22/24 create instance of adapter, and attach to binding.notes. 
    });
  }

  @Override
  public void onDestroyView() {
    binding = null;
    super.onDestroyView();
  }

}
