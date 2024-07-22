package edu.cnm.deepdive.dialogdemo.service;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import edu.cnm.deepdive.dialogdemo.model.Note;
import java.util.LinkedList;
import java.util.List;

public class NotesRepository {

  private final MutableLiveData<List<Note>> notes;

  private NotesRepository() {
    notes = new MutableLiveData<>(new LinkedList<>());
  }

  public static NotesRepository getInstance() {
    return Holder.INSTANCE;
  }

  public LiveData<List<Note>> getNotes() {
    return notes;
  }

  public void addNote(Note note) {
    List<Note> notes = this.notes.getValue();
    //noinspection DataFlowIssue
    notes.add(note);
    this.notes.postValue(notes);
  }

  private static class Holder {

    private static final NotesRepository INSTANCE = new NotesRepository();

  }

}
