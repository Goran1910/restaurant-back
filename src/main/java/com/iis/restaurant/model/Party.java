package com.iis.restaurant.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Party {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "party_id")
	private Long id;

	private Date partyDate;

	@ManyToMany
	private Set<TableEntity> tables = new HashSet<TableEntity>();

	@OneToMany(mappedBy = "party")
	private Set<PartyMeal> partyMeals = new HashSet<PartyMeal>();

	public Party() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getPartyDate() {
		return partyDate;
	}

	public void setPartyDate(Date partyDate) {
		this.partyDate = partyDate;
	}

	public Set<TableEntity> getTables() {
		return tables;
	}

	public void setTables(Set<TableEntity> tables) {
		this.tables = tables;
	}

	public Set<PartyMeal> getPartyMeals() {
		return partyMeals;
	}

	public void setPartyMeals(Set<PartyMeal> partyMeals) {
		this.partyMeals = partyMeals;
	}

	@Override
	public String toString() {
		return "Party [id=" + id + ", partyDate=" + partyDate + ", tables=" + tables + ", partyMeals=" + partyMeals
				+ "]";
	}

}
