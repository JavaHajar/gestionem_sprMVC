package com.code.entities;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id_role;
    @Column(name = "nom_role")
    private String nom_role;
    @OneToMany(mappedBy = "rol")
    private Set<User> users;
   
    
    public Role() {
    }

    public Role(String nom_role) {
        this.nom_role = nom_role;
    }

    public Role(int id_role, String nom_role) {
        this.id_role = id_role;
        this.nom_role = nom_role;
    }
    public int getId_role() {
        return id_role;
    }
    public void setId_role(int id_role) {
        this.id_role = id_role;
    }
    public String getNom_role() {
        return nom_role;
    }
    public void setNom_role(String nom_role) {
        this.nom_role = nom_role;
    }

	@Override
	public String toString() {
		return "Role [id_role=" + id_role + ", nom_role=" + nom_role + "]";
	}

	

	
	
   
   


}
