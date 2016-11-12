package ua.nure.osmachko.summarytask4.web.utils.writeFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.osmachko.summarytask4.core.entity.FacultyEnrollee;
import ua.nure.osmachko.summarytask4.dao.impl.FacultyDAOImpl;
import ua.nure.osmachko.summarytask4.dao.impl.UserDAOImpl;

public class WriteFileUtils {

	private static final Logger LOG = Logger.getLogger(WriteFileUtils.class);
	
	
	public static void wtireToFileResultsOfBudget(List<FacultyEnrollee> faculties) {
		LOG.trace("Starting write to file");
		try {
		File file = new File("C:/ResultsOfFaculty/Budget.txt");
		Writer out = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(file), "UTF8"));
		for(FacultyEnrollee item : faculties) {
			String nameOfFaculty = new FacultyDAOImpl().getNameOfFacultyById(item.getFacultyId());
			String firstName = new UserDAOImpl().getFirstNameById(item.getEnrolleeId());
			String lastName = new UserDAOImpl().getLastNameById(item.getEnrolleeId());
			LOG.trace("first name = " + firstName);
			out.append("First name: ").append(firstName).append("\r\n");
			out.append("LastName : " + lastName + "\r\n");
			out.append("Faculty : " + nameOfFaculty + "\r\n");
			out.append("Sum of pionts : " + item.getSummaryPionts() + "\r\n");
			out.append("Status : Budget" + "\r\n");
			out.append("****************************" + "\r\n");
			
		}
		
		out.flush();
		out.close();
		} catch(Exception ex) {
			
		}
	}
	
	public static void wtireToFileResultsOfContract(List<FacultyEnrollee> faculties) throws IOException {
		LOG.trace("Starting write to file");
		File file = new File("C:/ResultsOfFaculty/Contract.txt");
//		PrintWriter printWriter = new PrintWriter("C:/ResultsOfFaculty/Contract.txt", "UTF-8");
		Writer out = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(file), "UTF8"));
		
		for(FacultyEnrollee item : faculties) {
			String nameOfFaculty = new FacultyDAOImpl().getNameOfFacultyById(item.getFacultyId());
			String firstName = new UserDAOImpl().getFirstNameById(item.getEnrolleeId());
			String lastName = new UserDAOImpl().getLastNameById(item.getEnrolleeId());
			out.append("First name: " + firstName + "\r\n");
			out.append("LastName : " + lastName + "\r\n");
			out.append("Faculty : " + nameOfFaculty + "\r\n");
			out.append("Sum of pionts : " + item.getSummaryPionts() + "\r\n");
			out.append("Status : Contract" + "\r\n");
			out.append("****************************" + "\r\n");
			
		}
		out.flush();
		out.close();
		
		
	}
	
	public static void wtireToFileResultsOfNotBudgetNotContract(List<FacultyEnrollee> faculties) throws IOException {
		LOG.trace("Starting write to file");
		File file = new File("C:/ResultsOfFaculty/NotBudgetNotContract.txt");
//		PrintWriter printWriter = new PrintWriter("C:/ResultsOfFaculty/NotBudgetNotContract.txt", "UTF-8");
		Writer out = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(file), "UTF8"));
		for(FacultyEnrollee item : faculties) {
			String nameOfFaculty = new FacultyDAOImpl().getNameOfFacultyById(item.getFacultyId());
			String firstName = new UserDAOImpl().getFirstNameById(item.getEnrolleeId());
			String lastName = new UserDAOImpl().getLastNameById(item.getEnrolleeId());
			out.append("First name: " + firstName + "\r\n");
			out.append("LastName : " + lastName + "\r\n");
			out.append("Faculty : " + nameOfFaculty + "\r\n");
			out.append("Sum of pionts : " + item.getSummaryPionts() + "\r\n");
			out.append("Status : Out Of Faculty" + "\r\n");
			out.append("****************************" + "\r\n");
			
		}
		out.flush();
		out.close();
		
		
	}
	
}
