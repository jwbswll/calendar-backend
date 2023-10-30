package com.calendar.springcal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "events")
public class Event {
  @ManyToOne
  @JoinColumn(name = "date_id", nullable = false)
  private CalendarDate calendarDate;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long id;
  @Column(name = "event_title", nullable = false)
  public String title;
  @Column(name = "event_time", nullable = true)
  public String time;

  Event(String title, String time) {
    this.title = title;
    this.time = time;
  }

  Event(String title) {
    this.title = title;
  }

  public String getTitle() {
    return this.title;
  }

  public String getTime() {
    return this.time;
  }

  public void setTitle(String newTitle) {
    this.title = newTitle;
  }

  public void setTime(String newTime) {
    this.time = newTime;
  }

}
