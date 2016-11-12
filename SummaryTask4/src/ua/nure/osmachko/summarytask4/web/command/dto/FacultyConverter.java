package ua.nure.osmachko.summarytask4.web.command.dto;

import org.apache.log4j.Logger;

import ua.nure.osmachko.summarytask4.core.entity.Faculty;
import ua.nure.osmachko.summarytask4.dao.impl.DAOFacultyEnrolleeImpl;
import ua.nure.osmachko.summarytask4.web.command.ListFacultiesCommand;

/**
 * Faculty DTO realization.
 * @author Valerii Osmachko
 *
 */
public class FacultyConverter {

	private static volatile FacultyConverter instance = null;

	private static final Logger LOGGER = Logger.getLogger(FacultyConverter.class);

	public static synchronized FacultyConverter getInstance() {
		if (instance == null) {
			instance = new FacultyConverter();
		}
		return instance;
	}

	/**
	 * Method of modernization.
	 * @param faculty
	 * @return
	 */
	public FacultyDto convert(Faculty faculty) {
		FacultyDto dto = new FacultyDto();

		dto.setId(faculty.getId());
		dto.setNameOfFaculty(faculty.getNameOfFaculty());
		dto.setBudgetSeats(faculty.getBudgetSeats());
		dto.setTotalSeats(faculty.getTotalSeats());

		dto.setEmtpy(new DAOFacultyEnrolleeImpl().isEmptyFaculty(faculty.getId()));
		LOGGER.trace("faculty dto  = "+dto);
		return dto;

	}

}
