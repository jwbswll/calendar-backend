package com.calendar.springcal;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calendar.springcal.DTOs.CalendarDateDTO;
import com.calendar.springcal.Entities.CalendarDate;
import com.calendar.springcal.Entities.Event;
import com.calendar.springcal.Repositories.DateRepository;

@RestController
@RequestMapping("/dates")
public class CalendarDateController {

  @Autowired
  private DateRepository dateRepo;

  @Autowired
  private ModelMapper mapper;

  @PostMapping("/")
  public ResponseEntity<CalendarDate> saveDate(@RequestBody CalendarDateDTO date) {
    System.out.println("Date save called...");
    CalendarDate mappedDate = mapper.map(date, CalendarDate.class);
    CalendarDate newDate = dateRepo.save(mappedDate);
    System.out.println("Saved!");
    return new ResponseEntity<CalendarDate>(newDate, HttpStatus.OK);
  }

  @GetMapping("/{date}")
  public ResponseEntity<List<Event>> getDate(@PathVariable(name = "date") String date) {
    System.out.println("Date get called...");
    Optional<CalendarDate> maybeDate = dateRepo.findById(date);
    if (!maybeDate.isEmpty()) {
      System.out.println("Accepted");
      return new ResponseEntity<List<Event>>(maybeDate.get().getEvents(), HttpStatus.OK);

    } else {
      return new ResponseEntity<List<Event>>(HttpStatus.NOT_FOUND);
    }

  }

  @PatchMapping("/{date}")
  public ResponseEntity<List<Event>> updateEvents(@PathVariable(name = "date") String date, Event event) {
    Optional<CalendarDate> maybeDate = dateRepo.findById(date);
    if (!maybeDate.isEmpty()) {
      CalendarDate eventAdded = maybeDate.get().addEvent(event);
      dateRepo.save(eventAdded);
      Optional<CalendarDate> maybeUpdated = dateRepo.findById(date);
      return new ResponseEntity<List<Event>>(maybeUpdated.get().getEvents(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
