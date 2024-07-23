package edu.cnm.deepdive.dialogdemo.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.dialogdemo.model.Note;
import edu.cnm.deepdive.dialogdemo.model.dao.NoteDao;
import edu.cnm.deepdive.dialogdemo.service.NotesDatabase.Convertors;

@Database(
    entities = {Note.class},
    version = 1,
    exportSchema = false
)
@TypeConverters(Convertors.class)
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

  public static class Convertors {
    @TypeConverter
    public static String toString(Uri value) {
      return value != null ? value.toString() : null;
    }

    @TypeConverter
    public static Uri toUri(String value) {
      return value != null ? Uri.parse(value) : null;
    }
  }

  private static class Holder {

    @SuppressLint("StaticFieldLeak")
    private static final NotesDatabase INSTANCE =
        Room.databaseBuilder(context, NotesDatabase.class, NAME).build();;

  }

}
