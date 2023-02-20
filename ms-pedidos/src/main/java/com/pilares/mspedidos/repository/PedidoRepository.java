package com.pilares.mspedidos.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.pilares.mspedidos.model.entity.Pedido;
import com.pilares.mspedidos.model.enuns.Status;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	@Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Pedido p set p.status = :status where p = :pedido")
    void atualizaStatus(Status status, Pedido pedido);

    @Query(value = "SELECT p from Pedido p LEFT JOIN FETCH p.itens where p.id = :id")
    Pedido porIdComItens(Long id);
	
}
