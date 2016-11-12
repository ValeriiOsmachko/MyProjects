package ua.nure.osmachko.summarytask4.web.command.dto;

import org.apache.log4j.Logger;

import ua.nure.osmachko.summarytask4.core.entity.Faculty;
import ua.nure.osmachko.summarytask4.core.entity.User;
import ua.nure.osmachko.summarytask4.dao.impl.DAOFacultyEnrolleeImpl;
import ua.nure.osmachko.summarytask4.dao.impl.EnrolleeDAOImpl;

public class UserConverter {

	
	private static volatile UserConverter instance = null;

	private static final Logger LOGGER = Logger.getLogger(UserConverter.class);

	public static synchronized UserConverter getInstance() {
		if (instance == null) {
			instance = new UserConverter();
		}
		return instance;
	}

	public UserDto convert(User user) {
		UserDto dto = new UserDto();
		dto.setId(user.getId());
		dto.setEmail(user.getEmail());
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		dto.setLogin(user.getLogin());
		dto.setPassword(user.getPassword());
		dto.setRole(user.getRole());
		dto.setBlocked(new EnrolleeDAOImpl().getStatusOfEnrollee(user.getId()));
		dto.setEnrolleeExist(new EnrolleeDAOImpl().isEnrolleeExists(user.getId()));
		LOGGER.trace("user dto  = " + dto);
		return dto;

	}
}
