package btl;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Data
@Entity
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String brandname;
	private String platenumber;
	private String color;
	private String model;
	private int seatnumber;
	private int usedyear;
	private String lastmaintaincedate;
	
}
