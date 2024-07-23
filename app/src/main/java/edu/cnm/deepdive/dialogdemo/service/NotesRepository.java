package edu.cnm.deepdive.dialogdemo.service;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import edu.cnm.deepdive.dialogdemo.model.Note;
import edu.cnm.deepdive.dialogdemo.model.dao.NoteDao;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NotesRepository {

  private final NoteDao noteDao;
  private final ExecutorService executor;

  private NotesRepository() {
    noteDao = NotesDatabase.getInstance().getNoteDao();
    executor = Executors.newSingleThreadExecutor();
  }

  public static NotesRepository getInstance() {
    return Holder.INSTANCE;
  }

  public LiveData<List<Note>> getNotes() {
    return noteDao.selectAll();
  }

  public void addNote(Note note) {
    executor.execute(() -> noteDao.insert(note));
  }

  private static class Holder {

    private static final NotesRepository INSTANCE = new NotesRepository();

  }

}
