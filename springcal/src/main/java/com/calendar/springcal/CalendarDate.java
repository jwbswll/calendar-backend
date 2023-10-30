package com.calendar.springcal;

import java.util.Set;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "dates")
public class EventDate {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long id;
  @Column(name = "event_dates", nullable = false)
  public Date dateOfEvent;
  public Date dateCreated;

  EventDate(Date dateOfEvent) {
    this.dateOfEvent = dateOfEvent;
  }

  public Date getDate() {
    return this.dateOfEvent;
  }

  public void setDate(Date newDate) {
    this.dateOfEvent = newDate;
  }

  @OneToMany(mappedBy = "dates")
  private Set<Event> events;
}
