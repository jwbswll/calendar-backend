package com.calendar.springcal.DTOs;

import jakarta.validation.constraints.NotNull;

public class CalendarDateDTO {
  @NotNull
  public String id;
  @NotNull
  public String dateOfEvent;

  CalendarDateDTO() {
  }

  CalendarDateDTO(String id, String dateOfEvent) {
    this.id = id;
    this.dateOfEvent = dateOfEvent;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDateOfEvent() {
    return this.dateOfEvent;
  }

  public void setDateOfEvent(String dateOfEvent) {
    this.dateOfEvent = dateOfEvent;
  }

}
