package br.com.caelum.vraptor.models.entities;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

//@PersistenceCapable(detachable="true")
//@PersistenceCapable(identityType = IdentityType.APPLICATION)
@PersistenceCapable
public class Product {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;

	@Persistent
	private String name;

	@Persistent
	private String nameUpperCase;

	@Persistent
	private String description;
	
	@Persistent
	private String descriptionUpperCase;

	@Persistent
	private Double price;

	@Persistent
	private Integer amount;

	@Persistent
	private Date registrationDate;

	@Persistent
	private Date updateDate;

	public Product(String name, String description, Double price, int amout,
			Date registrationDate, Date updateDate) {
		this.name = name;
		nameUpperCase = name.toUpperCase();
		this.description = description;
		descriptionUpperCase = description.toUpperCase();
		this.price = price;
		this.amount = amout;
		this.registrationDate = registrationDate;
		this.updateDate = updateDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		nameUpperCase = name.toUpperCase();
	}

	public String getNameUpperCase() {
		return nameUpperCase;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
		descriptionUpperCase = description.toUpperCase();
	}

	public String getDescriptionUpperCase() {
		return descriptionUpperCase;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amout) {
		this.amount = amout;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
