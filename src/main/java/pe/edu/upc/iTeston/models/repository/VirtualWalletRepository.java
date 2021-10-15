package pe.edu.upc.iTeston.models.repository;

import java.util.List;

import pe.edu.upc.iTeston.models.entities.VirtualWallet;

public interface VirtualWalletRepository extends JpaRepository<VirtualWallet, String> {
	List<VirtualWallet> findBySaldo(Float saldo) throws Exception;
}
