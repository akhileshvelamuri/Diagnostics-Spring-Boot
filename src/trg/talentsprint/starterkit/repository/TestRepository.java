package trg.talentsprint.starterkit.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import trg.talentsprint.starterkit.model.Test;

@Repository
public interface TestRepository extends CrudRepository<Test, Long> {

	@Query("select t from Test t where t.testname =?1")
	public Test searchIdByName(String testname);

}
