package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author  Andrew Steele aeste - aesteele
 * CIS175 - Fall 2021
 * Jan 27, 2023
 */
@Entity
@Table(name = "characterlist")
public class Cast {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	@Column(name = "CHARACTER_NAME")
	private String character;
	@Column(name = "CHARACTER_RANK")
	private String rank;
	@Column(name = "ACTOR_NAME")
	private String actor;

	public Cast() {
		super();
	}

	public Cast(String character, String rank, String actor) {
		super();
		this.character = character;
		this.rank = rank;
		this.actor = actor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String outputDetails() {
		return "[ID= " + this.id + ", character=" + this.character + ", rank=" + this.rank + ", actor=" + this.actor + "]";
	}
	
	
}
