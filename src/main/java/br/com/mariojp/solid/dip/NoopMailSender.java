package br.com.mariojp.solid.dip;

public class NoopMailSender implements MailSender {
    @Override
    public void send(String to, String subject, String body) {
        // Intencionalmente vazio — em DRY_RUN não fazemos nada.
    }
}
