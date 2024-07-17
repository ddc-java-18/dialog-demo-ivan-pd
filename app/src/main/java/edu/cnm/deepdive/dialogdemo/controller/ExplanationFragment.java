package edu.cnm.deepdive.dialogdemo.controller;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import edu.cnm.deepdive.dialogdemo.R;

public class ExplanationFragment extends DialogFragment {

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    return new Builder(requireContext())
        .setTitle(R.string.camera_permission_title)
        .setIcon(android.R.drawable.ic_dialog_info)
        .setMessage(R.string.camera_permission_explanation)
        .setNeutralButton(android.R.string.ok, (dialog, whichBtn) -> {})
        .create();
  }

  @Override
  public void onDismiss(@NonNull DialogInterface dialog) {
    super.onDismiss(dialog);
    ((AlertDismissHandler) requireActivity()).onDismiss();
  }

  public interface AlertDismissHandler {
    void onDismiss();
  }

}
