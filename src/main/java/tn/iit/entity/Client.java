package tn.iit.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.EqualsAndHashCode.Include;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "t_client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Include
    @Column(name = "id")
	public Long id;
	
    @Column(name = "nom")
    public String nom;
	
    @Column(name = "prenom")
    public String prenom;
  
    @Column(name = "adresse")
    public String adresse;

    @JsonIgnore
    @OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE)
    public List<Compte> comptes;


    

    
}
