package ua.nure.osmachko.summarytask4.dao;

import java.util.List;

import ua.nure.osmachko.summarytask4.core.entity.Mark;

public interface MarkDAO {

	/**
	 * Getting all marks.
	 * @return
	 */
	List<Mark> getAllMarks();
	
	/**
	 * Finding mark by id.
	 * @param idMark
	 * @return
	 */
	Mark findMarkById(Integer idMark);
	
	/**
	 * Inserting mark.
	 * @param mark
	 * @return
	 */
	boolean insertMark(Mark mark);
	
	/**
	 * Updating mark.
	 * @param idMark
	 * @param mark
	 * @return
	 */
	boolean updateMark(Integer idMark, Mark mark);
	
	/**
	 * Deleting mark.
	 * @param idMark
	 * @return
	 */
	boolean deleteMark(Integer idMark);
	
	
	
}
