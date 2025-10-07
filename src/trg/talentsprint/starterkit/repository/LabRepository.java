package trg.talentsprint.starterkit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import trg.talentsprint.starterkit.model.Lab;
import trg.talentsprint.starterkit.model.Test;

@Repository
public interface LabRepository extends CrudRepository<Lab, Long> {

	@Query("select l.labName from Lab l where l.tid =?1")
	public List<String> searchLabsByTid(Long tid);
}