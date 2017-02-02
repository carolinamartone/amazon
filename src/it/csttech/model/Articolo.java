package it.csttech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Articolo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String name;
	
	@Column
	private Integer quantita;
	
	@Column
	private double prezzo;
	
	@Column
	private String immagineUrl;

	

	public String getImmagineUrl() {
		return immagineUrl;
	}

	public void setImmagineUrl(String immagineUrl) {
		this.immagineUrl = immagineUrl;
	}

	@ManyToOne(optional = false, targetEntity = Category.class)
	@JoinColumn(name = "category_id", nullable = false, insertable = false, updatable = false)
	private Category category;

	@Column(name = "category_id", nullable = false)
	private Integer categoryId;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantita() {
		return quantita;
	}

	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	@Override
	public String toString() {
		return "Articolo [id=" + id + ", name=" + name + ", quantita=" + quantita + ", prezzo=" + prezzo
				+ ", immagineUrl=" + immagineUrl + ", category=" + category + ", categoryId=" + categoryId + "]";
	}

	public Articolo(Integer id, String name, Integer quantita, double prezzo, String immagineUrl, Category category,
			Integer categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.quantita = quantita;
		this.prezzo = prezzo;
		this.immagineUrl = immagineUrl;
		this.category = category;
		this.categoryId = categoryId;
	}

	public Articolo() {

	}
}
