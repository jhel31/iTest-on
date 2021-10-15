package pe.edu.upc.iTeston.business.crud;

import java.util.List;


import pe.edu.upc.iTeston.models.entities.VirtualWallet;

public interface VirtualWalletService extends CrudService<VirtualWallet, String> {
	List<VirtualWallet> findBySaldo(Float saldo) throws Exception;
}
