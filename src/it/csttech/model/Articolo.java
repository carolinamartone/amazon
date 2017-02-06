package it.csttech.model;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "ARTICOLO")

public class Articolo {
	@Id
	@Column(name = "ID", nullable = false, unique = true, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "NAME", nullable = false, length = 50, unique = true)
	private String name;

	@Column(name = "QUANTITA")
	private Integer quantita;

	@Column(name = "PREZZO")
	private double prezzo;
	// unique =@UniqueConstraint(columnNames = ConstraintMode.CONSTRAINT,
	// name="UK_ARTICOLO_IMG")
	@Column(name = "IMMAGINE_URL",unique =true) 
	private String immagineUrl;

	@ManyToOne(optional = false, targetEntity = Category.class)
	@JoinColumn(name = "CATEGORY_ID", nullable = false, insertable = false, updatable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_ARTICOLO_TO_CATEGORY"))
	private Category category;

	@Column(name = "CATEGORY_ID", nullable = false)
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

	public String getImmagineUrl() {
		return immagineUrl;
	}

	public void setImmagineUrl(String immagineUrl) {
		this.immagineUrl = immagineUrl;
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
