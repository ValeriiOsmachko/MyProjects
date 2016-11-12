package ua.nure.osmachko.summarytask4.web.command;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.osmachko.summarytask4.core.entity.User;
import ua.nure.osmachko.summarytask4.dao.UserDAO;
import ua.nure.osmachko.summarytask4.dao.impl.DAOFactoryImpl;
import ua.nure.osmachko.summarytask4.web.ActionType;
import ua.nure.osmachko.summarytask4.web.utils.RegistrateUserValidator;


public class RegistrateUserCommand extends Command{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5267961749096370859L;
	
	private static final Logger LOG = Logger.getLogger(RegistrateUserCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, ActionType actionType)
			throws IOException, ServletException {
		LOG.debug("Start executing Command");

		String result = null;

		if (ActionType.POST == actionType) {
			result = doPost(request, response); 
		}
		LOG.debug("Finished executing Command");

		return result;
	}
	
	
	private String doPost(HttpServletRequest request, HttpServletResponse response) {
		LOG.trace("Starting doPost in RegistrateCommand");
		String firstName = request.getParameter("firstName");
		byte[] bytes = firstName.getBytes(StandardCharsets.ISO_8859_1);
		firstName = new String(bytes, StandardCharsets.UTF_8);
		String lastName = request.getParameter("lastName");
		byte[] bytes1 = lastName.getBytes(StandardCharsets.ISO_8859_1);
		lastName = new String(bytes1, StandardCharsets.UTF_8);
		String email = request.getParameter("email");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String role = "client";
		String result = null;
		LOG.trace("Fields were got : " + "first Name = " + firstName + ", last Name = " + lastName +
				", email = " + email + ",login = " + login + ", password = " + password + ",role = " + role);
		
		boolean valid = RegistrateUserValidator.validateUserParameters(firstName, lastName, email, password, login);
		if(valid == true) {
		User user = new User(email,password,login,firstName,lastName,role);
		UserDAO userdao = new DAOFactoryImpl().getUserDAO();
		userdao.insertUser(user);
		sendEmail(email, login, password);
		result = "index.jsp";
		LOG.trace("User was added to data base and fields are valid");
		} else if(valid == false){
			LOG.error("NOT CORRECT INPUT FIELDS, TRY AGAIN PLEASE");
			result = "index.jsp";
		}
		
		return result;
	}
	
	
	
//	private void sendEmail(String email, String login, String password) {
//		LOG.trace("Startin sending Email to new client....");
//
//	      // Sender's email ID needs to be mentioned
//	      String from = "v.o.osmachko@gmail.com";
//
//	      // Assuming you are sending email from localhost
////	      String host = "localhost";
//	      
//	      String host = "smtp.gmail.com";
//
//	      // Get system properties
//	      Properties properties = System.getProperties();
//	      
//	      properties.put("mail.transport.protocol", "smtp");
//
//	      properties.put("mail.smtp.starttls.enable", "true");
//	      
//	      properties.setProperty("mail.smtp.user", "v.o.osmachko@gmail.com");
//	      properties.setProperty("mail.smtp.password", "barcelonabo1994");
//	      properties.setProperty("mail.smtp.auth", "false"); 
//	      properties.put("mail.smtp.port", "25");
//	      
//	      
//	      // Setup mail server
//	      properties.setProperty("mail.smtp.host", host);
//	      
//	      
//	      
//	      
//
//	      // Get the default Session object.
//	      Session session = Session.getDefaultInstance(properties, null);
//
//	      try{
//	         // Create a default MimeMessage object.
//	         MimeMessage message = new MimeMessage(session);
//	         
//
//	         // Set From: header field of the header.
//	         message.setFrom(new InternetAddress(from));
//
//	         // Set To: header field of the header.
//	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
//
//	         // Set Subject: header field
//	         message.setSubject("Registration in Faculty System!");
//	         
//	         message.setSentDate(new Date());
//
//	         // Now set the actual message
//	         message.setText("You were successfully registrated in our sustem. " + "\n" 
//	         + "You login: " + login + " , You password: " + password);
//
//	         // Send message
//	         Transport.send(message);
//	         System.out.println("Sent message successfully....");
//	         LOG.trace("Email successfully sended.");
//	      }catch (MessagingException mex) {
//	         mex.printStackTrace();
//	      }
//	}

	 public void sendEmail(String email, String login, String password){

	        try{
	            final String fromEmail = "v.o.osmachko@gmail.com"; //requires valid gmail id
	            final String passwordFrom = "barcelonabo1994"; // correct password for gmail id
	            final String toEmail = email; // can be any email id 

	            System.out.println("TLSEmail Start");
	            Properties props = new Properties();
	            props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
	            props.put("mail.smtp.port", "587"); //TLS Port
	            props.put("mail.smtp.auth", "true"); //enable authentication
	            props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

	                //create Authenticator object to pass in Session.getInstance argument
	            Authenticator auth = new Authenticator() {
	                //override the getPasswordAuthentication method
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(fromEmail, passwordFrom);
	                }
	            };
	            Session session = Session.getInstance(props, auth);

	            MimeMessage message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(fromEmail));
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

	            System.out.println("Mail Check 2");

	            message.setSubject("Faculty System");
	            message.setText("You were successfully registrated in Faculty system." + "\n" 
	            + "You login: " + login + " ,You password: " + password);

	            System.out.println("Mail Check 3");

	            Transport.send(message);
	            System.out.println("Mail Sent");
	        }catch(Exception ex){
	            System.out.println("Mail fail");
	            System.out.println(ex);
	        }
	    }
	
}
