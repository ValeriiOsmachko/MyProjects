package ua.nure.osmachko.summarytask4.core.entity;


/**
 * @author Valerii Osmachko
 *The folowing class is the bean for Enrollee
 *entity.
 */
public class Enrollee extends Entity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6230795066664903440L;
	
	/**
	 * Id of Enrollee.
	 */
	private int id;
	/**
	 * City of enrollee.
	 */
	private String city;
	/**
	 * Region of Enrollee.
	 */
	private String region;
	/**
	 * User id of Enrollee.
	 */
	private int userId;
	/**
	 * Status of enrollee.
	 */
	private boolean blockedStatus;
	
	
	/**
	 * Empty constructor.
	 */
	public Enrollee() {
		
	}
	

	/**
	 * First constructor(for selecting).
	 * @param city
	 * @param region
	 * @param user
	 * @param blockedStatus
	 */
	public Enrollee(int id,String city, String region, User user, boolean blockedStatus) {
		this(id,city,region,user.getId(),blockedStatus);
	}
	
	
	
	
	
	/**
	 * Second constructor(for adding enrollee to DB).
	 * @param city
	 * @param region
	 * @param userId
	 * @param blockedStatus
	 */
	public Enrollee(String city, String region, int userId, boolean blockedStatus) {
		super();
		this.city = city;
		this.region = region;
		this.userId = userId;
		this.blockedStatus = blockedStatus;
	}


	/**
	 * Second constructor
	 * @param city
	 * @param region
	 * @param userId
	 * @param blockedStatus
	 */
	public Enrollee(int id ,String city, String region, int userId, boolean blockedStatus) {
		super();
		this.setId(id);
		this.city = city;
		this.region = region;
		this.userId = userId;
		this.blockedStatus = false;
	}


	/** Getting city.
	 * @return String 
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Getting region.
	 * @return String 
	 */
	public String getRegion() {
		return region;
	}
	
	/**
	 * Getting name of university.
	 * @return Sting
	 */
	


	/**
	 * Returns the status of the enrollee.
	 * @return boolean 
	 */
	public boolean isBlockedStatus() {
		return blockedStatus;
	}




	/**
	 * Setter for field city.
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}


	/**Setter for field region.
	 * @param region
	 */
	public void setRegion(String region) {
		this.region = region;
	}



	/**
	 * Setter for the field blockStatus.
	 * @param blockedStatus
	 */
	public void setBlockedStatus(boolean blockedStatus) {
		this.blockedStatus = blockedStatus;
	}


	/**
	 * Getter for the userId field.
	 * @return
	 */
	public int getUserId() {
		return userId;
	}


	/**
	 * Setter for userid field.
	 * @param userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}


	/* (non-Javadoc)
	 * @see ua.nure.osmachko.summarytask4.core.entity.Entity#getId()
	 */
	public int getId() {
		return id;
	}


	/* (non-Javadoc)
	 * @see ua.nure.osmachko.summarytask4.core.entity.Entity#setId(int)
	 */
	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Enrollee [id=" + id + ", city=" + city + ", region=" + region + ", userId=" + userId
				+ ", blockedStatus=" + blockedStatus + "]";
	}
	
	
	
	
	
}
