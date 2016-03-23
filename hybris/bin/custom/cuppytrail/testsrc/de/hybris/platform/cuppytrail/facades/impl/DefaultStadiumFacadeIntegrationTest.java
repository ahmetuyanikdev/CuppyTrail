/**
 * 
 */
package de.hybris.platform.cuppytrail.facades.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import de.hybris.platform.cuppytrail.data.StadiumData;
import de.hybris.platform.cuppytrail.facades.StadiumFacade;
import de.hybris.platform.cuppytrail.model.StadiumModel;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;


/**
 * @author luca.gennari
 * 
 */
public class DefaultStadiumFacadeIntegrationTest extends ServicelayerTransactionalTest
{
	@Resource
	private StadiumFacade stadiumFacade;

	@Resource
	private ModelService modelService;

	private StadiumModel stadiumModel;
	private final String STADIUM_NAME = "wembley";
	private final Integer STADIUM_CAPACITY = Integer.valueOf(90000);
	public static final String IMAGE_URL = "testUrl";
	public static final String CONVERSION_MEDIA_FORMAT = "conversionMediaFormatTest";

	@Before
	public void setUp()
	{
		// This instance of a StadiumModel will be used by the tests
		stadiumModel = new StadiumModel();
		stadiumModel.setCode(STADIUM_NAME);
		stadiumModel.setCapacity(STADIUM_CAPACITY);
	}

	@Test(expected = UnknownIdentifierException.class)
	public void testFailBehavior()
	{
		stadiumFacade.getStadium(STADIUM_NAME, "UninportantFormat");
	}

	@Test
	public void testStadiumFacade()
	{
		List<StadiumData> stadiumListData = stadiumFacade.getStadiums(CONVERSION_MEDIA_FORMAT);
		assertNotNull(stadiumListData);
		final int size = stadiumListData.size();
		modelService.save(stadiumModel);

		stadiumListData = stadiumFacade.getStadiums("stadiumListFormat");
		assertNotNull(stadiumListData);
		assertEquals(size + 1, stadiumListData.size());
		assertEquals(STADIUM_NAME, stadiumListData.get(size).getName());
		assertEquals(STADIUM_CAPACITY.toString(), stadiumListData.get(size).getCapacity());

		final StadiumData persistedStadiumData = stadiumFacade.getStadium(STADIUM_NAME, "stadiumListFormat");
		assertNotNull(persistedStadiumData);
		assertEquals(STADIUM_NAME, persistedStadiumData.getName());
		assertEquals(STADIUM_CAPACITY.toString(), persistedStadiumData.getCapacity());
	}
}
