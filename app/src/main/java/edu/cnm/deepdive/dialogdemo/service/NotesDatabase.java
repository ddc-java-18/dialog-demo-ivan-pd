package edu.cnm.deepdive.dialogdemo.service;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import edu.cnm.deepdive.dialogdemo.model.Note;
import edu.cnm.deepdive.dialogdemo.model.dao.NoteDao;

@Database(
    entities = {Note.class},
    version = 1,
    exportSchema = false
)
public abstract class NotesDatabase extends RoomDatabase {

  private static final String NAME = "notes";

  @SuppressLint("StaticFieldLeak")
  private static Context context;

  public static void setContext(Context context) {
    NotesDatabase.context = context;
  }

  public abstract NoteDao getNoteDao();

  public static NotesDatabase getInstance() {
    return Holder.INSTANCE;
  }

  private static class Holder {

    @SuppressLint("StaticFieldLeak")
    private static final NotesDatabase INSTANCE =
        Room.databaseBuilder(context, NotesDatabase.class, NAME).build();;

  }


}
