package edu.cnm.deepdive.dialogdemo.model;

import android.net.Uri;

public class Note {

  private String comment;
  private Uri image;

  public Note(String comment, Uri image) {
    this.comment = comment;
    this.image = image;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Uri getImage() {
    return image;
  }

  public void setImage(Uri image) {
    this.image = image;
  }
}
