package edu.cnm.deepdive.dialogdemo.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import edu.cnm.deepdive.dialogdemo.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {

  FragmentMainBinding binding;

  public MainFragment() {

  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    binding = FragmentMainBinding.inflate(inflater, container, false);
    binding.showEditFragment.setOnClickListener((v) ->
        Navigation.findNavController(binding.getRoot())
            .navigate(MainFragmentDirections.navigateToEditFragment()));
    // TODO: 7/15/24 Attach listeners to widgets in binding fields.
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    // TODO: 7/15/24 Attach to viewmodel(s) and observe livedata of interest.
  }

  @Override
  public void onDestroyView() {
    binding = null;
    super.onDestroyView();
  }
}
