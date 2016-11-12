package ua.nure.osmachko.summarytask4.web.command;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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

import ua.nure.osmachko.summarytask4.core.entity.Enrollee;
import ua.nure.osmachko.summarytask4.core.entity.Faculty;
import ua.nure.osmachko.summarytask4.core.entity.FacultyEnrollee;
import ua.nure.osmachko.summarytask4.core.entity.FinalReportSheet;
import ua.nure.osmachko.summarytask4.dao.FacultyDAO;
import ua.nure.osmachko.summarytask4.dao.impl.DAOFactoryImpl;
import ua.nure.osmachko.summarytask4.dao.impl.DAOFacultyEnrolleeImpl;
import ua.nure.osmachko.summarytask4.dao.impl.EnrolleeDAOImpl;
import ua.nure.osmachko.summarytask4.dao.impl.FacultyDAOImpl;
import ua.nure.osmachko.summarytask4.dao.impl.UserDAOImpl;
import ua.nure.osmachko.summarytask4.web.ActionType;
import ua.nure.osmachko.summarytask4.web.Path;
import ua.nure.osmachko.summarytask4.web.utils.writeFile.WriteFileUtils;

public class MakeResultOnFacultyCommand extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8514019356292877140L;
	
	private static final Logger LOG = Logger.getLogger(MakeResultOnFacultyCommand.class);
	
	
private static final Comparator<FacultyEnrollee> SORT_FACULTYENROLLEE_BY_POINTS = new Comparator<FacultyEnrollee>() {
		
		@Override
		public int compare(FacultyEnrollee o1, FacultyEnrollee o2) {
			return o2.getSummaryPionts() - o1.getSummaryPionts();
		}
	};

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
	
	
	private String doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		LOG.trace("starting making result...");
		if(new DAOFactoryImpl().getDAOFacultyEnrollee().isEmptyFaculty(Integer.parseInt(request.getParameter("facultyId")))){
			return Path.REDIRECT_TO_VIEW_ALL_USERS;
		}
		
		List<FacultyEnrollee> list = new DAOFacultyEnrolleeImpl().getAllFacultyEnrollee();
		List<FacultyEnrollee> listOfBudgetEnrollees = new ArrayList<FacultyEnrollee>();
		List<FacultyEnrollee> listOfContractEnrollees = new ArrayList<FacultyEnrollee>();
		List<FacultyEnrollee> listOfNotBlockedEnrollees = new ArrayList<FacultyEnrollee>();
		List<FinalReportSheet> finalReportSheets = new ArrayList<FinalReportSheet>();
		List<FacultyEnrollee> listOfNotBudgetNotContract = new ArrayList<FacultyEnrollee>();
		LOG.trace("FacultyEnrollees were got" + list);
//		Collections.sort(list,SORT_FACULTYENROLLEE_BY_POINTS);
		LOG.trace("faculties were sorted : " + Arrays.asList(list));
		Integer budgetSeats = new FacultyDAOImpl().getNumberOfBudgetSeats(Integer.parseInt(request.getParameter("facultyId")));
		Faculty faculty = new FacultyDAOImpl().getFacultyById(Integer.parseInt(request.getParameter("facultyId")));
		for(FacultyEnrollee item : list) {
//			Enrollee enrollee = new EnrolleeDAOImpl().getEnrolleeById(item.getEnrolleeId());
			boolean status = new EnrolleeDAOImpl().getStatusOfEnrollee(item.getEnrolleeId());
			if(status == false) {
				listOfNotBlockedEnrollees.add(item);
			} else {
//				continue label;
			}
		}
		
		Collections.sort(listOfNotBlockedEnrollees,SORT_FACULTYENROLLEE_BY_POINTS);
		 for(FacultyEnrollee item : listOfNotBlockedEnrollees) {
			if(list.indexOf(item) <= budgetSeats - 1) {
				listOfBudgetEnrollees.add(item);	
			} else if((list.indexOf(item) > budgetSeats - 1) && (list.indexOf(item) <= faculty.getTotalSeats() - 1)) {
				listOfContractEnrollees.add(item);
			} else if(list.indexOf(item) > faculty.getTotalSeats() - 1){
				listOfNotBudgetNotContract.add(item);
			}
		}
		
		
		for(FacultyEnrollee item : listOfBudgetEnrollees) {
			String nameOfFaculty = new FacultyDAOImpl().getNameOfFacultyById(item.getFacultyId());
			String email = new UserDAOImpl().getEmailById(item.getEnrolleeId());
			String firstName = new UserDAOImpl().getFirstNameById(item.getEnrolleeId());
			String lastName = new UserDAOImpl().getLastNameById(item.getEnrolleeId());
			sendEmailBudget(email, nameOfFaculty,firstName, lastName);
			finalReportSheets.add(new FinalReportSheet(firstName, lastName, item.getCity(), item.getRegion(), item.getSummaryPionts(), "Budget"));
			
		}
		
		
		
		for(FacultyEnrollee item : listOfContractEnrollees) {
			String nameOfFaculty = new FacultyDAOImpl().getNameOfFacultyById(item.getFacultyId());
			String email = new UserDAOImpl().getEmailById(item.getEnrolleeId());
			String firstName = new UserDAOImpl().getFirstNameById(item.getEnrolleeId());
			String lastName = new UserDAOImpl().getLastNameById(item.getEnrolleeId());
			sendEmailContract(email, nameOfFaculty,firstName, lastName);
			finalReportSheets.add(new FinalReportSheet(firstName, lastName, item.getCity(), item.getRegion(), item.getSummaryPionts(), "Contract"));
		}
		
		
		
		for(FacultyEnrollee item : listOfNotBudgetNotContract) {
			String nameOfFaculty = new FacultyDAOImpl().getNameOfFacultyById(item.getFacultyId());
			String email = new UserDAOImpl().getEmailById(item.getEnrolleeId());
			String firstName = new UserDAOImpl().getFirstNameById(item.getEnrolleeId());
			String lastName = new UserDAOImpl().getLastNameById(item.getEnrolleeId());
			sendEmailNotBudgetNotContract(email, nameOfFaculty,firstName, lastName);
			finalReportSheets.add(new FinalReportSheet(firstName, lastName, item.getCity(), item.getRegion(), item.getSummaryPionts(), "Out of Faculty"));
		}
		
		try {
			WriteFileUtils.wtireToFileResultsOfBudget(listOfBudgetEnrollees);
			WriteFileUtils.wtireToFileResultsOfContract(listOfContractEnrollees);
			WriteFileUtils.wtireToFileResultsOfNotBudgetNotContract(listOfNotBudgetNotContract);
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getSession().setAttribute("finalResult", finalReportSheets);
		
		return Path.REDIRECT_TO_VIEW_ALL_FACULTIES;
	}
	
	
	
	 public void sendEmailBudget(String email, String nameOfFaculty,String name, String lastName){

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
	            message.setText("Dear " + " " + name + " " +  lastName + "!!! \n" 
	            + "You were successfully granded on Faculty : " + nameOfFaculty + " on budget." );

	            System.out.println("Mail Check 3");

	            Transport.send(message);
	            System.out.println("Mail Sent");
	        }catch(Exception ex){
	            System.out.println("Mail fail");
	            System.out.println(ex);
	        }
	    }
	 
	 public void sendEmailContract(String email, String nameOfFaculty,String name, String lastName){

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
	            message.setText("Dear " + " " + name + " " + lastName + "!!! \n" 
	            + " We're genuinely sorry, but you couldn't become a budget student of " + nameOfFaculty + " ." );

	            System.out.println("Mail Check 3");

	            Transport.send(message);
	            System.out.println("Mail Sent");
	        }catch(Exception ex){
	            System.out.println("Mail fail");
	            System.out.println(ex);
	        }
	    }
	 
	 
	 public void sendEmailNotBudgetNotContract(String email, String nameOfFaculty,String name, String lastName){

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
	            message.setText("Dear " + " " + name + " " + lastName + "!!! \n" 
	            + "We're genuinely sorry , but you couldn't become not budget, not contract student of " + nameOfFaculty + " ." );

	            System.out.println("Mail Check 3");

	            Transport.send(message);
	            System.out.println("Mail Sent");
	        }catch(Exception ex){
	            System.out.println("Mail fail");
	            System.out.println(ex);
	        }
	    }

}
