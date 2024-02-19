package thiago;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaAmigoMapTest {

    private SistemaAmigoMap sistema;

    @BeforeEach
    void setUp() {
        this.sistema = new SistemaAmigoMap();
    }

    @Test
    void testCadastraAmigo() throws AmigoJaExisteException, AmigoInexistenteException {
        sistema.cadastraAmigo("João", "joao@example.com");
        Amigo amigo = sistema.pesquisaAmigo("joao@example.com");
        assertNotNull(amigo);
        assertEquals("João", amigo.getNome());
        assertEquals("joao@example.com", amigo.getEmail());
    }

    @Test
    void testCadastraAmigoDuplicado() {
        assertThrows(AmigoJaExisteException.class, () -> {
            sistema.cadastraAmigo("Maria", "maria@example.com");
            sistema.cadastraAmigo("Pedro", "pedro@example.com");
            sistema.cadastraAmigo("Maria", "maria@example.com");
        });
        assertEquals(2, sistema.getAmigos().size());
    }


    @Test
    void testPesquisaAmigoInexistente() {
        assertThrows(AmigoInexistenteException.class, () -> {
            sistema.pesquisaAmigo("inexistente@example.com");
        });
    }

    @Test
    void testEnviarMensagemParaTodos() {
        sistema.enviarMensagemParaTodos("Olá a todos!", "ana@example.com", false);
        assertEquals(1, sistema.pesquisaTodasAsMensagens().size());
    }

    @Test
    void testEnviarMensagemParaAlguem() throws AmigoJaExisteException {
        sistema.cadastraAmigo("Ana", "ana@example.com");
        sistema.cadastraAmigo("João", "joao@example.com");
        sistema.enviarMensagemParaAlguem("Olá João!", "ana@example.com", "joao@example.com", false);
        assertEquals(1, sistema.pesquisaTodasAsMensagens().size());
    }

    @Test
    void testPesquisaMensagensAnonimas() {
        sistema.enviarMensagemParaTodos("Olá a todos!", "ana@example.com", true);
        assertEquals(1, sistema.pesquisaMensagensAnonimas().size());
    }

    @Test
    void testConfiguraAmigoSecretoDe() throws AmigoJaExisteException, AmigoInexistenteException, AmigoNaoSorteadoException {
        sistema.cadastraAmigo("Ana", "ana@example.com");
        sistema.cadastraAmigo("João", "joao@example.com");
        sistema.configuraAmigoSecretoDe("ana@example.com", "joao@example.com");
        assertEquals("joao@example.com", sistema.pesquisaAmigoSecretoDe("ana@example.com"));
    }

    @Test
    void testPesquisaAmigoSecretoDe() throws AmigoJaExisteException, AmigoInexistenteException, AmigoNaoSorteadoException {
        sistema.cadastraAmigo("Ana", "ana@example.com");
        sistema.cadastraAmigo("João", "joao@example.com");
        sistema.configuraAmigoSecretoDe("ana@example.com", "joao@example.com");
        assertEquals("joao@example.com", sistema.pesquisaAmigoSecretoDe("ana@example.com"));
    }
}
