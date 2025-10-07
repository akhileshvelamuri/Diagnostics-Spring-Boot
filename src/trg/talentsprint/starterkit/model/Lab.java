package trg.talentsprint.starterkit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lab")
public class Lab {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long labid;

	private String labName;

	private Long tid;

	public Lab() {
		super();
	}

	public Long getLabid() {
		return labid;
	}

	public void setLabid(Long labid) {
		this.labid = labid;
	}

	public String getLabName() {
		return labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}

	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

}
