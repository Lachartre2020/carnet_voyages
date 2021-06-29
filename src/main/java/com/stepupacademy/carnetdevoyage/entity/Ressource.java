package com.stepupacademy.carnetdevoyage.entity;

import javax.persistence.*;

@Entity
public class Ressource {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		private String lienGalPhoto;
		private String lienRestau;
		private String lienAutre;
		
		@ManyToOne
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
			
		public String getLienGalPhoto() {
			return this.lienGalPhoto;
		}
		
		public void setLienGalPhoto(String lienGalPhoto) {
			this.lienGalPhoto = lienGalPhoto;
		}
		
		public String getLienRestau() {
			return this.lienRestau;
		}
		
		public void setLienRestau(String lienRestau) {
			this.lienRestau = lienRestau;
		}	
	
		public String getLienAutre() {
			return this.lienAutre;
		}
		
		public void setLienAutre(String lienAutre) {
			this.lienAutre = lienAutre;
		}
		
		public Etape getEtape() {
			return this.etape;
		}
		
		public void setEtape(Etape etape) {
			this.etape = etape;
		}
}
