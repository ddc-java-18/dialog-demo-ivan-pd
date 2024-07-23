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
  private final OnItemClickListener listener;

  public NotesAdapter(@NonNull Context context, @NonNull List<Note> notes, OnItemClickListener listener) {
    inflater = LayoutInflater.from(context);
    this.notes = new ArrayList<>(notes);
    this.listener = listener;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int ignoredItemType) {
    return new Holder(ItemNotesBinding.inflate(inflater, viewGroup, false), listener);
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
    private final OnItemClickListener listener;

    private Holder(@NonNull ItemNotesBinding binding, OnItemClickListener listener) {
      super(binding.getRoot());
      this.binding = binding;
      this.listener = listener;
    }

    private void bind(int position, @NonNull Note note) {
      binding.comment.setText(note.getComment());
      binding.thumbnail.setImageURI(note.getImage());
      binding.getRoot().setOnClickListener((v) -> listener.onItemClick(v, note, position));
    }

  }

  public interface OnItemClickListener {

    void onItemClick(View view, Note note, int position);

  }
}
