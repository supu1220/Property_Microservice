package com.propertyservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="property")
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	
	@Column(name = "number_of_beds")
	private int numberOfbeds;
	
	@Column(name = "number_of_rooms")
	private int numberOfRooms;
	
	@Column(name = "number_of_bathrooms")
	private int numberOfBathrooms;
	
	@Column(name = "number_of_guest_allowed")
	private int numberOfGuestAllowed;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name = "area_id")
	private Area area;
	
	@ManyToOne
	@JoinColumn(name = "state_id")
	private State state;

	public City getCity() {
		return city;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfbeds() {
		return numberOfbeds;
	}

	public void setNumberOfbeds(int numberOfbeds) {
		this.numberOfbeds = numberOfbeds;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public int getNumberOfBathrooms() {
		return numberOfBathrooms;
	}

	public void setNumberOfBathrooms(int numberOfBathrooms) {
		this.numberOfBathrooms = numberOfBathrooms;
	}

	public int getNumberOfGuestAllowed() {
		return numberOfGuestAllowed;
	}

	public void setNumberOfGuestAllowed(int numberOfGuestAllowed) {
		this.numberOfGuestAllowed = numberOfGuestAllowed;
	}

	



	
}
