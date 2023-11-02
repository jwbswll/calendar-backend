package com.calendar.springcal.DTOs;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;

public class EventDTO {
  @NotBlank
  public String title;
  @Nullable
  public String time;

  EventDTO() {
  }

  EventDTO(String title) {
    this.title = title;
  }

  EventDTO(String title, String time) {
    this.title = title;
    this.time = time;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getTime() {
    return this.time;
  }

  public void setTime(String time) {
    this.time = time;
  }

}
