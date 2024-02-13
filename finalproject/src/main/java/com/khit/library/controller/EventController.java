package com.khit.library.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khit.library.entity.Event;
import com.khit.library.service.EventService;



@Controller
@RequestMapping("/evnet")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/pagelist")
    public String eventPageList(Model model) {
        List<Event> eventList = eventService.getAllEvents();
        model.addAttribute("eventList", eventList);
        return "event/pagelist";
    }

    @GetMapping("/detail/{eventId}")
    public String eventDetail(@PathVariable Long eventId, Model model) {
        Event event = eventService.getEventById(eventId);
        model.addAttribute("event", event);
        return "event/detail";
    }
}
