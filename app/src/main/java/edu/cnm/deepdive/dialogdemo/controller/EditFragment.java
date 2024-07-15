package edu.cnm.deepdive.dialogdemo.controller;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import edu.cnm.deepdive.dialogdemo.R;
import edu.cnm.deepdive.dialogdemo.databinding.FragmentEditBinding;

public class EditFragment extends DialogFragment {

  private FragmentEditBinding binding;



  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    binding = FragmentEditBinding.inflate(getLayoutInflater(), null, false);
    return new AlertDialog.Builder(requireContext())
        .setTitle(R.string.edit_dialog_title)
        .setView(binding.getRoot())
        .setPositiveButton(android.R.string.ok, (dlg, which) -> {/* TODO: 7/15/24 Save content.*/})
        .setNegativeButton(android.R.string.cancel, (dlg, which) -> {/* TODO: Probably nothing. */})
        .setIcon(android.R.drawable.ic_dialog_info)
        .create();
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
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
}
