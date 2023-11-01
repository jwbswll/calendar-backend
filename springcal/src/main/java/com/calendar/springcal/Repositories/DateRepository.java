package com.calendar.springcal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calendar.springcal.Entities.CalendarDate;

public interface DateRepository extends JpaRepository<CalendarDate, String> {

}
