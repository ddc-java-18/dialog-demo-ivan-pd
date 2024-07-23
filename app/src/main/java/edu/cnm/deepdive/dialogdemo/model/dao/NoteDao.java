package edu.cnm.deepdive.dialogdemo.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.dialogdemo.model.Note;
import java.util.List;

@Dao
public interface NoteDao {

  @Insert
  void insert(Note note);

  @Query("SELECT * FROM note ORDER BY note_id ASC")
  LiveData<List<Note>> selectAll();
}
