
import com.br.desafios.api_ib_codigo_fonte.model.Transacao;
import com.br.desafios.api_ib_codigo_fonte.service.TransacaoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TransacaoServiceTest {

    private final TransacaoService transacaoService = new TransacaoService();

    @Test
    void testSalvar() {

        Transacao transacao = new Transacao();
        transacao.setDataHora(OffsetDateTime.parse("2025-05-04T11:10:00.000-03:00"));
        transacao.setValor(100.0);

        transacaoService.salvar(transacao);

        Assertions.assertNotNull(transacao);

    }

    @Test
    void testLimpar() {

        Transacao transacao = new Transacao();
        transacao.setDataHora(OffsetDateTime.parse("2025-05-04T11:10:00.000-03:00"));
        transacao.setValor(100.0);

        transacaoService.salvar(transacao);

        transacaoService.limpar();

        Collection<Transacao> transacoes = transacaoService.listar();
        assertEquals(0, transacoes.size(), "A lista de transações deveria estar vazia após limpar.");
    }

    @Test
    void testLimparListaVazia() {
        transacaoService.limpar();
        Collection<Transacao> transacoes = transacaoService.listar();
        assertEquals(0, transacoes.size(), "A lista de transações deveria continuar vazia após limpar.");
    }

    @Test
    void testListar() {

        Transacao transacao1 = new Transacao();
        transacao1.setDataHora(OffsetDateTime.parse("2025-05-04T11:10:00.000-03:00"));
        transacao1.setValor(100.0);

        Transacao transacao2 = new Transacao();
        transacao2.setDataHora(OffsetDateTime.parse("2025-05-05T12:00:00.000-03:00"));
        transacao2.setValor(200.0);

        transacaoService.salvar(transacao1);
        transacaoService.salvar(transacao2);

        Collection<Transacao> transacoes = transacaoService.listar();

        assertEquals(2, transacoes.size(), "A lista de transações deveria conter 2 transações.");
        assertTrue(transacoes.contains(transacao1), "A lista deveria conter a primeira transação.");
        assertTrue(transacoes.contains(transacao2), "A lista deveria conter a segunda transação.");
    }

    @Test
    void testListarSemTransacoes() {
        Collection<Transacao> transacoes = transacaoService.listar();
        assertEquals(0, transacoes.size(), "A lista de transações deveria estar vazia quando nenhuma transação foi salva.");
    }
}