/**
 * 
 */
package de.hybris.platform.cuppytrail.daos;

import de.hybris.platform.cuppytrail.model.StadiumModel;

import java.util.List;


/**
 * @author luca.gennari
 * 
 */
public interface StadiumDAO
{
	/**
	 * Return a list of stadium models that are currently persisted. If none are found an empty list is returned.
	 * 
	 * @return all Stadiums of system
	 */
	List<StadiumModel> findStadiums();

	/**
	 * Finds all stadiums with given code. If none is found, an empty list will be returned.
	 * 
	 * @param code
	 *           the code to search for stadiums
	 * @return All stadiums with the given code.
	 */
	List<StadiumModel> findStadiumsByCode(String code);
}
