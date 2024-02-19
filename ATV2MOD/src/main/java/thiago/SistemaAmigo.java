//package thiago;
//
//import java.util.List;
//import java.util.ArrayList;
//
//public class SistemaAmigo {
//
//    private List<Mensagem> mensagens;
//    private List<Amigo> amigos;
//
//    public SistemaAmigo() {
//        this.mensagens = new ArrayList<>();
//        this.amigos = new ArrayList<>();
//    }
//
//    public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException {
//        for (Amigo amigo : amigos) {
//            if (amigo.getEmail().equals(emailAmigo)) {
//                throw new AmigoJaExisteException("Amigo com email " + emailAmigo + " já existe.");
//            }
//        }
//        Amigo amigo = new Amigo(nomeAmigo, emailAmigo);
//        amigos.add(amigo);
//
//    }
//
//
//    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException {
//        for (Amigo amigo : amigos) {
//            if (amigo.getEmail().equals(emailAmigo)) {
//                return amigo;
//            }
//        }
//        throw new AmigoInexistenteException("Amigo com email " + emailAmigo + " não encontrado.");
//    }
//
//    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean isAnonima) {
//        MensagemParaTodos mensagem = new MensagemParaTodos(texto, emailRemetente, isAnonima);
//        mensagens.add(mensagem);
//    }
//
//    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean isAnonima) {
//        Mensagem mensagem = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, isAnonima);
//        mensagens.add(mensagem);
//    }
//
//    public List<Mensagem> pesquisaMensagensAnonimas() {
//        List<Mensagem> mensagensAnonimas = new ArrayList<>();
//        for (Mensagem mensagem : mensagens) {
//            if (mensagem.isAnonima()) {
//                mensagensAnonimas.add(mensagem);
//            }
//        }
//        return mensagensAnonimas;
//    }
//
//    public List<Mensagem> pesquisaTodasAsMensagens() {
//        return mensagens;
//    }
//
//    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
//        Amigo pessoa = pesquisaAmigo(emailDaPessoa);
//        if (pessoa == null) {
//            throw new AmigoInexistenteException("Amigo com email " + emailDaPessoa + " não encontrado.");
//        }
//        pessoa.setEmailAmigoSorteado(emailAmigoSorteado);
//    }
//
//    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
//        Amigo pessoa = pesquisaAmigo(emailDaPessoa);
//        if (pessoa == null) {
//            throw new AmigoInexistenteException("Amigo com email " + emailDaPessoa + " não encontrado.");
//        }
//        String emailAmigoSorteado = pessoa.getEmailAmigoSorteado();
//        if (emailAmigoSorteado == null) {
//            throw new AmigoNaoSorteadoException("Amigo secreto de " + emailDaPessoa + " ainda não foi sorteado.");
//        }
//        return emailAmigoSorteado;
//    }
//
//    public List<Amigo> getAmigos() {
//        return amigos;
//    }
//
//
//}