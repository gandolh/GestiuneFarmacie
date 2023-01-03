package gestiune.farmacie.utils;

import gestiune.farmacie.vault.EmailCredentials;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.temporal.ValueRange;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.NewsAddress;


/**
 * Clasa ajutatoare pentru gestionarea trimiterii de email-uri
 */
public class EmailOperations {

    /**
     * Construieste calea catre template-urile de email-uri
     * @return un string ce reprezinta calea
     */
    private static String getEmailTemplatePath(){
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        Path filePath = Paths.get(currentPath.toString(), "farmacie","src","main","java","gestiune","farmacie","templates","mail");
//        System.out.println(filePath.toString());
        return filePath.toString();
    }

    /**
     * Preia continutul pentru un mail de resetare a parolei
     * @return continutul pentru un mail de resetare a parolei
     */
    private static String getResetPasswordBody(){
        try {
            var resourcePath = Paths.get(getEmailTemplatePath(),"resetPassword.html");
            return new String(Files.readAllBytes(resourcePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Trimiterea mail-ului de resetare a parolei
     * @param newPassword noua parola
     */
    public static void sendResetPassword(String to,String newPassword){
        String body = getResetPasswordBody().replaceFirst("HERE_SECRET_PASSWORD",newPassword);
        send(to,body,"Parola dumneavoastra a fost resetata");
    }

    /**
     * Trimite un email prin smtp
     * @param to destinatarul mail-ului
     * @param body corpul mail-ului
     * @param subject subiect-ul mail-ului
     */
    public static void send(String to, String body, String subject){
        String from = EmailCredentials.getSmtpEmail();
        String password = EmailCredentials.getSmtpPassword();
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from,password);
            }
        });
//        session.setDebug(true);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setContent(
                    body,
                    "text/html");

            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
