package com.khit.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khit.library.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

}
