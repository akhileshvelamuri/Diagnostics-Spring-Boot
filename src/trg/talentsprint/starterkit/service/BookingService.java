package trg.talentsprint.starterkit.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trg.talentsprint.starterkit.model.Booking;
import trg.talentsprint.starterkit.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	public List<Booking> findAll() {
		return StreamSupport.stream(bookingRepository.findAll().spliterator(), false).collect(Collectors.toList());

	}

	public Optional<Booking> findById(Long id) {
		return bookingRepository.findById(id);

	}

	public Booking save(Booking list) {
		return bookingRepository.save(list);

	}

	public void deleteById(Long id) {
		bookingRepository.deleteById(id);
	}

	public void updateStatus(String status, Long bid) {
		bookingRepository.updateStatus(status, bid);
	}
	
	public List<Booking> searchBookingByUsername(String username) {
		return bookingRepository.searchBookingByUsername(username);
	}

}
