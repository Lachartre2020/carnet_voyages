package com.stepupacademy.carnetdevoyage.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Etape {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nameVille;
	private Date dateEtape;
	private String resume;
	
		
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "pays_id")
	private Pays pays;
	
	@OneToMany(mappedBy = "etape", cascade = CascadeType.ALL)
	private List<Ressource> ressources;	
	
	public Etape(){
	}
		
	public Long getId() {
		return this.id;
	}
		
	public void setId(Long id) {
		this.id = id;
	}
			
	public String getNameVille() {
		return this.nameVille;
	}
		
	public void setNameVille(String nameVille) {
		this.nameVille = nameVille;
	}
		
	public Date getDateEtape() {
		return this.dateEtape;
	}
		
	public void setDateEtape(Date dateEtape) {
		this.dateEtape= dateEtape;
	}
		
	public String getResume() {
		return this.resume;
	}
		
	public void setResume(String resume) {
		this.resume = resume;
	}
	
	public Pays getPays() {
		return this.pays;
	}
		
	public void setPays(Pays pays) {
		this.pays = pays;
	}

	public List<Ressource> getRessources() {
		return ressources;
	}

	public void setRessources(List<Ressource> Ressources) {
		this.ressources = Ressources;
	}
	
}
