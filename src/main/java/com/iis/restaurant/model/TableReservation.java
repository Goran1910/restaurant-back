package com.iis.restaurant.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TableReservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservation_table_id")
	private Long id;

	private int numOfPeople;

	@Column(name = "reservation_date")
	private Timestamp date;

	@ManyToOne
	@JoinColumn(name = "table_id")
	private TableEntity table;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	public TableReservation(Long id, int numOfPeople, Timestamp date) {
		super();
		this.id = id;
		this.numOfPeople = numOfPeople;
		this.date = date;
	}

	public TableReservation() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumOfPeople() {
		return numOfPeople;
	}

	public void setNumOfPeople(int numOfPeople) {
		this.numOfPeople = numOfPeople;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public TableEntity getTable() {
		return table;
	}

	public void setTable(TableEntity table) {
		this.table = table;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "TableReservation [id=" + id + ", numOfPeople=" + numOfPeople + ", date=" + date + ", table=" + table
				+ ", client=" + client + "]";
	}

}
