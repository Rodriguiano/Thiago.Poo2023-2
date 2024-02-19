package thiago;

public class MensagemParaTodos extends Mensagem {

    public MensagemParaTodos(String texto, String emailRemetente, String emailDestinatario, boolean anonima) {
        super(texto, emailRemetente, emailDestinatario, anonima);
    }

    public MensagemParaTodos(String texto, String emailRemetente, boolean isAnonima) {
        super(texto, emailRemetente, "", isAnonima);
    }

    @Override
    public String getTextoCompletoAExibir() {
        if (isAnonima()) {
            return "Mensagem para todos. Texto: " + getTexto();
        } else {
            return super.getTextoCompletoAExibir();
        }
    }
}
