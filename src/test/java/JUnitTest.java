import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.TestClass;

import foobar.Sub;

public class JUnitTest {
    @Test(expected = InitializationError.class)
	public void inaccessible_base_class_is_caught_at_validation()
			throws InitializationError {
        new BlockJUnit4ClassRunner(Sub.class);
    }

	@Test
	public void has_invalid_annotated_method()
			throws Exception {
		TestClass testClass = new TestClass(Sub.class);
		FrameworkMethod annotatedMethod = testClass.getAnnotatedMethods(
				Test.class).get(0);
		List<Throwable> errors = new ArrayList<Throwable>();
		annotatedMethod.validatePublicVoidNoArg(false, errors);
		assertEquals("Wrong numer of errors.", 1, errors.size());
	}

	@Test
	public void has_one_annotated_method() throws Exception {
		TestClass testClass = new TestClass(Sub.class);
		List<FrameworkMethod> methods = testClass
				.getAnnotatedMethods(Test.class);
		assertEquals("Wrong number of methods.", 1, methods.size());
	}
}
