package com.stepupacademy.carnetdevoyage.entity;

import javax.persistence.*;

@Entity
public class Ressource {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		private String lienSite;
		
		@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
		@JoinColumn(name = "etape_id")
		private Etape etape;
	
		public Ressource() {
			
		}
		
		public Long getId() {
			return this.id;
		}
		
		public void setId(Long id) {
			this.id = id;
		}
		
		public Etape getEtape() {
			return this.etape;
		}
			
		public void setEtape(Etape etape) {
			this.etape = etape;
		}		
			
		public String getLienSite() {
			return this.lienSite;
		}
		
		public void setLienSite(String lienSite) {
			this.lienSite = lienSite;
		}
}
