package edu.cnm.deepdive.dialogdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import edu.cnm.deepdive.dialogdemo.databinding.ItemNotesBinding;
import edu.cnm.deepdive.dialogdemo.model.Note;
import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends Adapter<ViewHolder> {

  private final LayoutInflater inflater;
  private final List<Note> notes;

  public NotesAdapter(@NonNull Context context, @NonNull List<Note> notes) {
    this.inflater = LayoutInflater.from(context);
    this.notes = new ArrayList<>(notes);
  }


  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int ignoredItemType) {
    return new Holder(ItemNotesBinding.inflate(inflater, viewGroup, false));
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
    ((Holder) viewHolder).bind(position, notes.get(position));
  }

  @Override
  public int getItemCount() {
    return notes.size();
  }

  private static class Holder extends ViewHolder {

    private final ItemNotesBinding binding;

    private Holder(@NonNull ItemNotesBinding binding) {
      super(binding.getRoot());
      this.binding = binding;
    }

    private void bind(int position, @NonNull Note note) {
      binding.comment.setText(note.getComment());
      binding.thumbnail.setImageURI(note.getImage());
    }

  }
}
