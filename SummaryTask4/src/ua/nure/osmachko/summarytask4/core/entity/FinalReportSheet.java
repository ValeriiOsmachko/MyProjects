package ua.nure.osmachko.summarytask4.core.entity;

public class FinalReportSheet extends Entity {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4678495797329352441L;
	
	String firstName;
	String lastName;
	String city;
	String region;
	String statusOfEducation;
	Integer summaryPionts;
	
	
	
	
	
	public FinalReportSheet(String firstName, String lastName, String city, String region,
			Integer summaryPionts, String statusOfEducation) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.region = region;
		this.summaryPionts = summaryPionts;
		this.statusOfEducation = statusOfEducation;
		
		
	}
	public FinalReportSheet(Integer id, String firstName, String lastName, String city, String region,
			Integer facultyId, Integer summaryPionts) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.region = region;
		this.summaryPionts = summaryPionts;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	public Integer getSummaryPionts() {
		return summaryPionts;
	}
	public void setSummaryPionts(Integer summaryPionts) {
		this.summaryPionts = summaryPionts;
	}
	
	
	public String getStatusOfeducation() {
		return statusOfEducation;
	}
	public void setStatusOfeducation(String statusOfeducation) {
		this.statusOfEducation = statusOfeducation;
	}
	@Override
	public String toString() {
		return "FinalReportSheet [id="  + ", firstName=" + firstName + ", lastName=" + lastName + ", city=" + city
				+ ", region=" + region + ", facultyId="  + ", summaryPionts=" + summaryPionts + "]";
	}
	
	
	
	
}
