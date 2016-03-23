/**
 *
 */
package de.hybris.platform.cuppytrail.scripting;

import de.hybris.platform.scripting.engine.ScriptExecutable;
import de.hybris.platform.scripting.engine.ScriptExecutionResult;
import de.hybris.platform.scripting.engine.ScriptingLanguagesService;
import de.hybris.platform.scripting.enums.ScriptType;
import de.hybris.platform.scripting.model.ScriptModel;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.model.ModelService;

import javax.annotation.Resource;

import org.junit.Test;


/**
 * @author charles.barton
 *
 */
public class ScriptingHelloGroovyTest extends ServicelayerTransactionalTest
{
	@Resource
	ScriptingLanguagesService scriptingLanguagesService;

	@Resource
	ModelService modelService;

	@Test
	public void testScriptArguments()
	{
		final ScriptModel script = modelService.create(ScriptModel.class);
		script.setScriptType(ScriptType.GROOVY);
		script.setContent("'hello groovy!' + new Date()");
		// code must be unique
		script.setCode("helloGroovyScript");
		modelService.save(script);

		final ScriptExecutable executable = scriptingLanguagesService.getExecutableByURI("model://helloGroovyScript");
		final ScriptExecutionResult result = executable.execute();
		System.out.println(result.getScriptResult());


	}
}
