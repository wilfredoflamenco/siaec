package util;


import com.sun.mail.smtp.SMTPAddressFailedException;
import entities.Configuraciones;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class CorreoBasico {

    private static Properties props;
    private Configuraciones configuracion;

    public CorreoBasico(Configuraciones c) {
        //System.setSecurityManager(null);
        props = new Properties();

        //Propiedades basicas
        props.put("mail.smtp.host", c.getConfiguracionCorreoHost());
        props.put("mail.smtp.port", c.getConfiguracionCorreoPort());
        props.put("mail.smtp.from", c.getConfiguracionCorreoCuenta());
        props.put("mail.smtp.password", c.getConfiguracionCorreoContrasenya());

        //otras propiedades 
        props.put("mail.smtp.auth", c.getConfiguracionCorreoRequerido());

        switch (c.getConfiguracionCorreoEncryptacion()) {
            case "sin":
                System.out.println("correo.correo.configuracion()");
                break;
            case "tls":
                props.setProperty("mail.smtp.starttls.enable", "true");
                break;
            case "ssl":
                props.setProperty("mail.smtp.ssl.enable", "true");
                props.put("mail.smtp.ssl.trust", "*");
                break;
        }
    }
    
    
    public static  void metodocualquiera(){}

    public void sendMail(String destinatario, String asunto, String cuerpo) throws MessagingException {

        //Session session = Session.getDefaultInstance(props);
        Session session = Session.getInstance(props, null);
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(props.getProperty("mail.smtp.from")));
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(destinatario));//Se podrian añadir varios de la misma manera
            message.setSubject(asunto);
            message.setText(cuerpo);

            Transport trans = session.getTransport("smtp");
            trans.connect(props.getProperty("mail.smtp.host"),
                    props.getProperty("mail.smtp.from"),
                    props.getProperty("mail.smtp.password"));
            trans.sendMessage(message, message.getAllRecipients());
            trans.close();
        } catch (MessagingException me) {
            me.printStackTrace(); //Si se produce error
            throw me;
        }

    }
    
    
    
    public void sendMailHTML(String destinatarios, String asuntos, String cuerpoHTML) throws SMTPAddressFailedException, SendFailedException, MessagingException, Exception {
        //Session session = Session.getDefaultInstance(props);
        Session session = Session.getInstance(props, null);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(props.getProperty("mail.smtp.from")));
            message.addRecipients(Message.RecipientType.TO, destinatarios);
            message.setSubject(asuntos);
            Multipart parts = new MimeMultipart();
            BodyPart bodyMail = new MimeBodyPart();
            bodyMail.setContent(cuerpoHTML, "text/html");
            parts.addBodyPart(bodyMail);
            message.setContent(parts);
            Transport transport = session.getTransport("smtp");
            transport.connect(props.getProperty("mail.smtp.host"),
                    props.getProperty("mail.smtp.from"),
                    props.getProperty("mail.smtp.password"));
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }catch(SMTPAddressFailedException me){
            me.printStackTrace();
        }
        catch( SendFailedException me){
            me.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace(); //Si se produce error
        }
        catch(Exception me){
            me.printStackTrace();
        }

    }
    
    public void sendMailHTML(String destinatarios, String asuntos, String cuerpoHTML, List<File> files) throws IOException {
        
        //Session session = Session.getDefaultInstance(props);
        System.out.println("correo.Correo2.sendMailHTML() con archivos");
        System.out.println("tamanyo " + files.size());
        
        
        Session session = Session.getInstance(props, null);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(props.getProperty("mail.smtp.from")));
            message.addRecipients(Message.RecipientType.TO, destinatarios);
            message.setSubject(asuntos);
            Multipart parts = new MimeMultipart();
            BodyPart bodyMail = new MimeBodyPart();
            bodyMail.setContent(cuerpoHTML, "text/html");
            parts.addBodyPart(bodyMail);
            System.out.println("antes de entrara a archivos ");
            for (File file : files) {
                System.out.println("Hola entras");
                System.out.println("correo.Correo2.sendMailHTML()");
                MimeBodyPart attached = new MimeBodyPart();
                attached.attachFile(file);
                parts.addBodyPart(attached);
            }
            message.setContent(parts);
            Transport transport = session.getTransport("smtp");
            transport.connect(props.getProperty("mail.smtp.host"),
                    props.getProperty("mail.smtp.from"),
                    props.getProperty("mail.smtp.password"));
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException me) {
            me.printStackTrace(); //Si se produce error

        }
    }

}
