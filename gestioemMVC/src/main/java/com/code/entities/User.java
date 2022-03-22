package com.code.entities;

import java.io.Serializable;
import java.lang.annotation.Repeatable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="user")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private int id_user;
	
	 @Column(name = "nom_user", nullable = false)
	 @Size(min=4, message = "Le nom de l'utilisateur ne peut pas être vide!")
     private String nom_user;
	 
     @Column(name = "prenom_user", nullable = false)
     @Size(min=4, message="Le prénom de l'utilisateur ne peut pas être vide!") 
     private String prenom_user;
     
     @Column(name = "email")
     @NotEmpty(message = "L'e-mail de l'utilisateur ne peut pas être vide!")
     private String email;
     
     @Column(name = "password")
     @Size(min=4, message="required !!!")  
     private String password;
     
     @ManyToOne(fetch = FetchType.EAGER)
     @JoinColumn(name="id_role")
     private Role rol;


     public User(int id_user, String nom_user, String prenom_user, String email, String password) {
         this.id_user = id_user;
         this.nom_user = nom_user;
         this.prenom_user = prenom_user;
         this.email = email;
         this.password = password;

     }

     public User() {
     }


     public User(int id_user) {
         this.id_user = id_user;
     }

     public User(String nom_user, String prenom_user, String email, String password) {
         this.nom_user = nom_user;
         this.prenom_user = prenom_user;
         this.email = email;
         this.password = password;

     }

     public int getId_user() {
         return id_user;
     }

     public void setId_user(int id_user) {
         this.id_user = id_user;
     }

     public String getNom_user() {
         return nom_user;
     }

     public void setNom_user(String nom_user) {
         this.nom_user = nom_user;
     }

     public String getPrenom_user() {
         return prenom_user;
     }

     public void setPrenom_user(String prenom_user) {
         this.prenom_user = prenom_user;
     }

     public String getEmail() {
         return email;
     }

     public void setEmail(String email) {
         this.email = email;
     }

     public String getPassword() {
         return password;
     }

     public void setPassword(String password) {
         this.password = password;
     }

	public Role getRol() {
		return rol;
	}

	public void setRol(Role rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "User [id_user=" + id_user + ", nom_user=" + nom_user + ", prenom_user=" + prenom_user + ", email="
				+ email + ", password=" + password + ", rol=" + rol + "]";
	}

      

}
