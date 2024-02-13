package com.khit.library.service;

import com.khit.library.repository.ReadingRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReadingRoomService {
    private final ReadingRoomRepository readingRoomRepository;
}
