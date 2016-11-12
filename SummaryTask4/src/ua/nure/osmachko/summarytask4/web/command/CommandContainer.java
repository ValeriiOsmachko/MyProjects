package ua.nure.osmachko.summarytask4.web.command;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class CommandContainer {
	
	
	private static final Logger LOG = Logger.getLogger(CommandContainer.class);
	
	private static Map<String, Command> commands = new HashMap<String, Command>();

	
	
	static {
		commands.put("login", new LoginCommand());
		commands.put("listEnrolles",  new ListEnrolleesCommand());
		commands.put("listFaculties", new ListFacultiesCommand());
		commands.put("deleteFaculty", new DeleteFacultyCommand());
		commands.put("updateFaculty", new UpdateFacultyCommand());
		commands.put("addEnrollee",  new AddEnrolleeCommand());
		commands.put("addFaculty", new AddFacultyCommand());
		commands.put("addUser", new AddUserCommand());
		commands.put("listUsers", new ListUsersCommand());
		commands.put("blockEnrolee", new BlockEnrolleeCommand());
		commands.put("unblockEnrolee", new UnBlockEnrolleeCommand());
		commands.put("registrateUser", new RegistrateUserCommand());
		commands.put("logout", new LogOutCommand());
		commands.put("sortFacultyByName", new SortFacultyByNameCommand());
		commands.put("showSortedByName", new ShowSortedFacultyByNameCommand());
		commands.put("sortFacultyByTotalSeats", new SortFacultyByTotalSeats());
		commands.put("showSortedByTotalSeat", new ShowSortedFacultyByTotalSeatsCommand());
		commands.put("sortFacultyByBudgetSeats", new SortFacultyByBudgetSeats());
		commands.put("showSortedByBudgetSeats", new ShowSortedFacultyByBudgetSeatsCommand());
		commands.put("registrateOnFaculty", new RegistrateOnFacultyCommand());
		commands.put("showFacultySubjects", new ShowFacultySubjects());
		commands.put("confirmMarks", new ConfirmMarksCommand());
		commands.put("MakeResultOnFaculty", new MakeResultOnFacultyCommand());
		commands.put("language", new LanguageCommand());
		commands.put("showAdminPage", new ShowAdminPageCommand());
		commands.put("showEnrolleePage", new ShowEnrolleePageCommand());
		commands.put("showRegistrationPage", new ShowRegistrationFormCommand());
		commands.put("showResultOnFaculty", new ShowResultOnFacultyCommand());
		commands.put("showResultsOnFaculty", new ShowResultsOnFacultyCommand());
		LOG.debug("Command container was successfully initialized");
		LOG.trace("Total number of commands equals to -->" + commands.size());
	}
	
	
	
	
	public static Command get(String commandName) {
		if (commandName == null || !commands.containsKey(commandName)) {
			LOG.trace("Command not found with name = " + commandName);
			return commands.get("noCommand");
		}

		return commands.get(commandName);
	}
}
