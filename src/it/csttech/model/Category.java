package it.csttech.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORY")
public class Category {

	@Id
	@Column(name = "ID", nullable = false, unique = true, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NAME", insertable = true, nullable = false)
	private String name;

	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Articolo> listaArticoli = new ArrayList<>();

	public List<Articolo> getListaArticoli() {
		return listaArticoli;
	}

	public void setListaArticoli(List<Articolo> listaArticoli) {
		this.listaArticoli = listaArticoli;
	}

	public Category(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Category() {

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

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}

	@Override
	public boolean equals(Object obj) {
		/*
		 * if (this == obj) return true;
		 */

		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		/*
		 * if (id != other.id) return false;
		 */
		/*
		 * if (listaArticoli == null) { if (other.listaArticoli != null) return
		 * false; } else if (!listaArticoli.equals(other.listaArticoli)) return
		 * false;
		 */
		/*
		 * if (name == null) { if (other.name != null) return false; } else
		 */
		if (!name.equals(other.name))
			return false;
		return true;
	}

}
