package com.pilares.mspagamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pilares.mspagamentos.model.entity.Pagamento;

public interface PagamentoRepositoy extends JpaRepository<Pagamento, Long> {

}
