package edu.cnm.deepdive.dialogdemo.viewmodel;

import android.app.Application;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class NotesViewModel extends AndroidViewModel {

  private final MutableLiveData<Uri> imageUri;

  private Uri pendingImageUri;

  public NotesViewModel(@NonNull Application application) {
    super(application);
    imageUri = new MutableLiveData<>();
  }

  public LiveData<Uri> getImageUri() {
    return imageUri;
  }

  public void setPendingImageUri(Uri pendingImageUri) {
    this.pendingImageUri = pendingImageUri;
  }

  public void confirmImageCapture(boolean captured) {
    imageUri.setValue(captured ? pendingImageUri : null);
  }

}
