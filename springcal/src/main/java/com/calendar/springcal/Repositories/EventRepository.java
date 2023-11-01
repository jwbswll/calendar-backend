package com.calendar.springcal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calendar.springcal.Entities.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {

}
