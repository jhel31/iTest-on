package pe.edu.upc.iTeston.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name = "Virtual_Wallets")

public class VirtualWallet {
	@Id
	@Column(name = "id_virtual_wallet", length = 10, nullable = false)
	private String id;
	
	@Column(name = "saldo", length = 10, nullable = false)
	private Float saldo;
	
	@OneToOne(mappedBy= "virtualWallet" )
	private Teacher teacher;
}
