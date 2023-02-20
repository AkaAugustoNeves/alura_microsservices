package com.pilares.mspagamentos.service;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pilares.mspagamentos.model.dto.PagamentoDto;
import com.pilares.mspagamentos.model.entity.Pagamento;
import com.pilares.mspagamentos.model.enuns.Status;
import com.pilares.mspagamentos.repository.PagamentoRepositoy;

@Service
public class PagamentoService {

	@Autowired
	private PagamentoRepositoy pagamentoRepositoy;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Page<PagamentoDto> obterTodos(Pageable paginacao) {
        return pagamentoRepositoy
                .findAll(paginacao)
                .map(p -> modelMapper.map(p, PagamentoDto.class));
    }
	
	public PagamentoDto obterPorId(Long id) {
        Pagamento pagamento = pagamentoRepositoy.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(pagamento, PagamentoDto.class);
    }

    public PagamentoDto criarPagamento(PagamentoDto dto) {
        Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
        pagamento.setStatus(Status.CRIADO);
        pagamentoRepositoy.save(pagamento);

        return modelMapper.map(pagamento, PagamentoDto.class);
    }

    public PagamentoDto atualizarPagamento(Long id, PagamentoDto dto) {
        Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
        pagamento.setId(id);
        pagamento = pagamentoRepositoy.save(pagamento);
        return modelMapper.map(pagamento, PagamentoDto.class);
    }

    public void excluirPagamento(Long id) {
    	pagamentoRepositoy.deleteById(id);
    }
}
