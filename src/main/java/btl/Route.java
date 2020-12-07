package btl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Route {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String start;
	private String end;
	private float length;
	private int complicatedlevel;
	
//	@OneToMany(targetEntity=Trip.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
//	private Trip trip;
}
