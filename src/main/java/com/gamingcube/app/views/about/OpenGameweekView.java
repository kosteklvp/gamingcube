package com.gamingcube.app.views.about;

import com.gamingcube.app.views.MainLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Open Gameweek")
@Route(value = "opengameweek", layout = MainLayout.class)
public class OpenGameweekView extends HorizontalLayout {

  public OpenGameweekView() {
    createSimpleUpload();
  }

  private void createSimpleUpload() {
    Div output = new Div();

    MemoryBuffer buffer = new MemoryBuffer();
    Upload upload = new Upload(buffer);

    upload.setAcceptedFileTypes(".json");

    upload.addSucceededListener(event -> Notification.show("Added: " + event.getFileName()));

    int size5MB = 5 * 1024 * 1024;
    upload.setMaxFileSize(size5MB);
    upload.setId("test-upload");
    output.setId("test-output");

    add(upload, output);
  }

}
