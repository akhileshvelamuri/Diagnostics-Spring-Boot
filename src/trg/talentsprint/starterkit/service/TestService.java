package trg.talentsprint.starterkit.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trg.talentsprint.starterkit.model.Test;
import trg.talentsprint.starterkit.repository.TestRepository;

@Service
public class TestService {

	@Autowired
	private TestRepository repository;

	public List<Test> findAll() {
		return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());

	}

	public Optional<Test> findById(Long id) {
		return repository.findById(id);

	}

	public Test save(Test stock) {
		return repository.save(stock);

	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public Test searchIdByName(String testname) {
		return repository.searchIdByName(testname);
		}
}