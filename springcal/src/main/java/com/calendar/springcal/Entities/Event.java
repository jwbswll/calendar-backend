package com.calendar.springcal.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "events")
public class Event {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "event_id")
  public Long id;
  @Column(name = "event_title", nullable = false)
  public String title;
  @Column(name = "event_time", nullable = true)
  public String time;

  Event() {
  }

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
