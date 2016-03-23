/**
 *
 */
package de.hybris.platform.cuppytrail.scripting;

import de.hybris.platform.cuppytrail.model.StadiumModel;
import de.hybris.platform.scripting.engine.ScriptExecutable;
import de.hybris.platform.scripting.engine.ScriptExecutionResult;
import de.hybris.platform.scripting.engine.ScriptingLanguagesService;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author charles.barton
 *
 */
public class ScriptingArgumentsTest extends ServicelayerTransactionalTest
{
	@Resource
	ScriptingLanguagesService scriptingLanguagesService;

	@Resource
	ModelService modelService;

	@Test
	public void testScriptArguments()
	{
		final StadiumModel testStadium = new StadiumModel();
		testStadium.setCode("Emirates");
		testStadium.setCapacity(10000);
		modelService.save(testStadium);

		final ScriptExecutable executable = scriptingLanguagesService
				.getExecutableByURI("classpath://scripts/findStadiumByCode.groovy");
		final Map<String, Object> params = new HashMap<>();
		params.put("stadiumCode", "Emirates");
		final ScriptExecutionResult result = executable.execute(params);

		final StadiumModel resultStadium = (StadiumModel) result.getScriptResult();
		// Assuming that stadium 'Emirates' already exists
		Assert.assertEquals(testStadium.getCode(), resultStadium.getCode());

	}
}
