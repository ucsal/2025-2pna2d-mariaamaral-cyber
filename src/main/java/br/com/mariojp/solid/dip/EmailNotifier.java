package br.com.mariojp.solid.dip;

public class EmailNotifier {
    private final MailSender mailSender;

    // Default constructor: keeps backward compatibility but respects DRY_RUN.
    public EmailNotifier() {
        if ("true".equalsIgnoreCase(System.getProperty("DRY_RUN"))) {
            this.mailSender = new NoopMailSender();
        } else {
            this.mailSender = new SmtpClient();
        }
    }

    // Constructor for dependency injection (useful in tests or framework wiring)
    public EmailNotifier(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void welcome(User user) {
        mailSender.send(user.email(), "Bem-vindo", "Olá " + user.name());
    }
}
