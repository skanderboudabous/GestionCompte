package tn.iit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.EqualsAndHashCode.Include;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Table(name = "t_compte")
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Include
	 @Column(name = "id")
	public Long id;
		
	@Column(name = "rib")
	public Long rib;
	
	@Column(name = "solde")
	public float solde;
		
	@ManyToOne()
	public Client client;


	
}
