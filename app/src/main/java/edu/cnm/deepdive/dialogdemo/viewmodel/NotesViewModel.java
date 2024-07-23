package edu.cnm.deepdive.dialogdemo.viewmodel;

import android.app.Application;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import edu.cnm.deepdive.dialogdemo.model.Note;
import edu.cnm.deepdive.dialogdemo.service.NotesRepository;
import java.util.List;

public class NotesViewModel extends AndroidViewModel {

  private final NotesRepository repository;
  private final MutableLiveData<Uri> imageUri;

  private Uri pendingImageUri;

  public NotesViewModel(@NonNull Application application) {
    super(application);
    repository = NotesRepository.getInstance();
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

  public LiveData<List<Note>> getNotes() {
    return repository.getNotes();
  }

  public void addNote(Note note) {
    repository.addNote(note);
    imageUri.setValue(null);
  }


}
