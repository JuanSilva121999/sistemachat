package com.emergentes.utils;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author CJ
 */
public class EnvioCorreos {
    private static String emailFrom = "craftjosecp@gmail.com";
    private static String passwordFrom = "brehaeycybainola";
    private static String content = "Este es un correo de restauracion de Constraseña\n"
            + "Si usted no pidio este servicio, puede ignorar el mensaje.\n";
    private static String subject = "Restauracion de usuario y contraseña";
    private String emailTo;
   
    
    private Properties mProperties;
    private Session mSession;
    private MimeMessage mCorreo;

    public EnvioCorreos(String emailTo, String usuario, String contrasenia) {
        this.emailTo = emailTo;
        mProperties = new Properties();
        createEmail(usuario, contrasenia);
        sendEmail();
    }
    
    private void sendEmail(){
        try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(emailFrom, passwordFrom);
            mTransport.sendMessage(mCorreo, mCorreo.getAllRecipients());
            mTransport.close();
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(EnvioCorreos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EnvioCorreos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void createEmail(String usuario, String contrasenia){
        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user", emailFrom);
        mProperties.setProperty("mail.smtp.auth", "true");
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
         
        
        
        mSession = Session.getDefaultInstance(mProperties);
        
        mCorreo = new MimeMessage(mSession);
        try {
            mCorreo.setFrom(new InternetAddress(emailFrom));
            mCorreo.addRecipient(Message.RecipientType.TO, new InternetAddress(this.emailTo));
            mCorreo.setSubject(subject);
            mCorreo.setText(content + "Usuario: " + usuario + "\nContraseña: " + contrasenia, "ISO-8859-1", "html");
        } catch (AddressException ex) {
            Logger.getLogger(EnvioCorreos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EnvioCorreos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
