package edu.cnm.deepdive.dialogdemo.service;

import androidx.core.content.FileProvider;
import edu.cnm.deepdive.dialogdemo.R;

public class ImageFileProvider extends FileProvider {

  public ImageFileProvider() {
    super(R.xml.provider_paths);
  }
}
