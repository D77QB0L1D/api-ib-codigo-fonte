package com.br.desafios.api_ib_codigo_fonte.repository;

import com.br.desafios.api_ib_codigo_fonte.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository <Transacao, Long> {
}
