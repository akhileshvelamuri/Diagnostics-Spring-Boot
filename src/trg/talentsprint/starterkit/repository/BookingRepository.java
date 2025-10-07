package trg.talentsprint.starterkit.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import trg.talentsprint.starterkit.model.Booking;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {

	@Modifying
	@Transactional
	@Query("update Booking b SET b.status=?1 where b.Bid=?2")
	public void updateStatus(String status, Long bid);

	@Query("select b from Booking b where b.username=?1")
	public List<Booking> searchBookingByUsername(String username);
}