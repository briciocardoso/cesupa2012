package br.com.saldopositivo.helper;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class EnvioDeEmail
{
	private String remetente = "gcm.sequeira@gmail.com";
	
	public void eviaEmail(String destinatario, String senhaNova){
		
            Properties props = new Properties();
            //Parâmetros de conexão com servidor Gmail
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            	protected PasswordAuthentication getPasswordAuthentication(){
                 return new PasswordAuthentication("saldopositivoinfo@gmail.com", "saldojboss");
                }               
            });

            /** Ativa Debug para sessão */
            session.setDebug(true);

            try {

                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress(remetente)); //Remetente
                  Address[] toUser = InternetAddress //Destinatário(s)
                             .parse(destinatario);  

                  message.setRecipients(Message.RecipientType.TO, toUser);
                  message.setSubject("Saldo Positivo - Sua nova senha");//Assunto
                  message.setText("Sua nova senha é " + senhaNova);
                  
                  /**Método para enviar a mensagem criada*/
                  Transport.send(message);

                  System.out.println("Feito!!!");

             } catch (MessagingException e) {
                  throw new RuntimeException(e);
            }
      }
}

