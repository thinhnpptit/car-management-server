package btl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;

@Data
@Entity
public class Trip {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(targetEntity=Employee.class) 
	private Employee driver;
	
	@ManyToOne(targetEntity=Employee.class) 
	private Employee subdriver;
	
	@ManyToOne(targetEntity=Car.class) 
	private Car car;
	
	@ManyToOne(targetEntity=Route.class)
	private Route route;
	
	private int numberofpassengers;
	private float price;
	private Date createdat;
}