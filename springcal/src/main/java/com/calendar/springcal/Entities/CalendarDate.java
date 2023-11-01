package com.calendar.springcal.Entities;

// import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "dates")
public class CalendarDate {
  @Id
  @Column(name = "date_id")
  public String id;
  @Column(name = "event_dates", nullable = false)
  public String dateOfEvent;
  // @Column(name = "dateCreated")
  // public Date dateCreated;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "date_id")
  private List<Event> events;

  CalendarDate() {
  }

  CalendarDate(List<Event> events) {
    this.events = events;
  }

  // CalendarDate(Date dateOfEvent) {
  // this.dateOfEvent = dateOfEvent;
  // }

  // CalendarDate(Date dateOfEvent, List<Event> events) {
  // this.dateOfEvent = dateOfEvent;
  // this.events = events;
  // }

  public CalendarDate addEvent(Event event) {
    this.events.add(event);
    return this;
  }

  // public Date getDate() {
  // return this.dateOfEvent;
  // }

  // public void setDate(Date newDate) {
  // this.dateOfEvent = newDate;
  // }

  public List<Event> getEvents() {
    return this.events;
  }

}
