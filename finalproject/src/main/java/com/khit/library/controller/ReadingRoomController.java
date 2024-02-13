package com.khit.library.controller;

import com.khit.library.service.ReadingRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/readingRoom")
public class ReadingRoomController {

    private final ReadingRoomService readingRoomService;
}
