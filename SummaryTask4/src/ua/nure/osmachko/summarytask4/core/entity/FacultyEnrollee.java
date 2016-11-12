package ua.nure.osmachko.summarytask4.core.entity;

/**
 * This class tells ablout concret enrolles,
 * which are applied for the which faculty using their
 * foreign keys.
 * @author Valerii Osmachko
 *
 */
public class FacultyEnrollee extends Entity {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 3575702946111571141L;

	/**
	 * Field for id.
	 */
	private int id;

	/**
	 * Field for facultyId.
	 */
	private int facultyId;

	/**
	 * Field for enrolleeId.
	 */
	private int enrolleeId;

	/**
	 * Field for first Name.
	 */
	private String firstName;

	/**
	 * Field for last Name.
	 */
	private String lastName;
	/**
	 * Filed for city.
	 */
	private String city;
	/**
	 * Field for region.
	 */
	private String region;
	/**
	 * Field for summary points.
	 */
	private Integer summaryPionts;

	/**
	 * Empty constructor.
	 */
	public FacultyEnrollee() {

	}

	/**
	 * Constructor for getting FacultyEnrollee from database.
	 * 
	 * @param id
	 * @param facultyId
	 * @param enrolleeId
	 * @param firstName
	 * @param lastName
	 * @param city
	 * @param region
	 * @param summaryPionts
	 */
	public FacultyEnrollee(int id, int facultyId, int enrolleeId, String firstName, String lastName, String city,
			String region, Integer summaryPionts) {
		super();
		this.setId(id);
		this.facultyId = facultyId;
		this.enrolleeId = enrolleeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.region = region;
		this.summaryPionts = summaryPionts;
	}

	/**
	 * Constructor for adding FacultyEnrollee into database.
	 * 
	 * @param facultyId
	 * @param enrolleeId
	 * @param firstName
	 * @param lastName
	 * @param city
	 * @param region
	 * @param summaryPionts
	 */
	public FacultyEnrollee(int facultyId, int enrolleeId, String firstName, String lastName, String city, String region,
			Integer summaryPionts) {
		this.facultyId = facultyId;
		this.enrolleeId = enrolleeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.region = region;
		this.summaryPionts = summaryPionts;
	}

	// public FacultyEnrollee(int facultyId, int enrolleeId) {
	// super();
	// this.facultyId = facultyId;
	// this.enrolleeId = enrolleeId;
	// }
	//
	// public FacultyEnrollee(Faculty faculty, Enrollee enrollee){
	// this(faculty.getId(), enrollee.getId());
	// }

	/**
	 * Getter for first Name.
	 * 
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter for the first Name.
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getter for the Lase name.
	 * 
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter for the last Name.
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Getter for the city.
	 * 
	 * @return
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Setter for the City.
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Getter for the region.
	 * 
	 * @return
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * Setter for the region.
	 * 
	 * @param region
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * Getter for the SummaryPoints.
	 * 
	 * @return
	 */
	public Integer getSummaryPionts() {
		return summaryPionts;
	}

	/**
	 * Setter for the summaty Pionts.
	 * 
	 * @param summaryPionts
	 */
	public void setSummaryPionts(Integer summaryPionts) {
		this.summaryPionts = summaryPionts;
	}

	/**
	 * Getter for faculty id.
	 * 
	 * @return
	 */
	public int getFacultyId() {
		return facultyId;
	}

	/**
	 * Setter for faculty id.
	 * 
	 * @param facultyId
	 */
	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	/**
	 * Getter for Enrollee id.
	 * 
	 * @return
	 */
	public int getEnrolleeId() {
		return enrolleeId;
	}

	/**
	 * Setter for enrollee id.
	 * 
	 * @param enrolleeId
	 */
	public void setEnrolleeId(int enrolleeId) {
		this.enrolleeId = enrolleeId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.osmachko.summarytask4.core.entity.Entity#getId()
	 */
	public int getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ua.nure.osmachko.summarytask4.core.entity.Entity#setId(int)
	 */
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "FacultyEnrollee [facultyId=" + facultyId + ", enrolleeId=" + enrolleeId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", city=" + city + ", region=" + region + ", summaryPionts="
				+ summaryPionts + "]";
	}




	

	
	
}
