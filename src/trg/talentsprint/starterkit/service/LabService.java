package trg.talentsprint.starterkit.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trg.talentsprint.starterkit.model.Lab;
import trg.talentsprint.starterkit.repository.LabRepository;

@Service
public class LabService {

	@Autowired
	private LabRepository repository;

	public List<Lab> findAll() {
		return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());

	}

	public Optional<Lab> findById(Long id) {
		return repository.findById(id);

	}

	public Lab save(Lab stock) {
		return repository.save(stock);

	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public List<String> searchLabsByTid(Long tid) {
		return repository.searchLabsByTid(tid);
	}

}