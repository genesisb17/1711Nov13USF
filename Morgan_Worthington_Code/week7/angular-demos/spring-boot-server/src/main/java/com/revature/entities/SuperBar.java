package com.revature.entities;

public class SuperBar {
	private String name;
	private int id;
	private String power;
	private int rating;

	public SuperBar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SuperBar(String name, int id, String power, int rating) {
		super();
		this.name = name;
		this.id = id;
		this.power = power;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((power == null) ? 0 : power.hashCode());
		result = prime * result + rating;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuperBar other = (SuperBar) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (power == null) {
			if (other.power != null)
				return false;
		} else if (!power.equals(other.power))
			return false;
		if (rating != other.rating)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SuperBar [name=" + name + ", id=" + id + ", power=" + power + ", rating=" + rating + "]";
	}

}
