package org.gochev.repository;

import org.gochev.model.Event;
import org.gochev.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository(value = EventRepository.NAME)
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
	public static final String NAME = "eventRepository";
	
	public Page<Event> findByOrderByStartTimeDesc(Pageable pageable);
}
