package foobar;
import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.TestClass;

public class JUnitTest {
	@Test
	@Ignore("Ignored until everything else is fine. (Want to remove distraction.)")
	public void has_invalid_annotated_method()
			throws Exception {
		TestClass testClass = new TestClass(Sub.class);
		FrameworkMethod annotatedMethod = testClass.getAnnotatedMethods(
				Test.class).get(0);
		List<Throwable> errors = new ArrayList<Throwable>();
		annotatedMethod.validatePublicVoidNoArg(false, errors);
		assertEquals("Wrong number of errors.", 1, errors.size());
	}

	@Test
	public void has_one_annotated_method() throws Exception {
		TestClass testClass = new TestClass(Sub.class);
		List<FrameworkMethod> methods = testClass
				.getAnnotatedMethods(Test.class);
		assertEquals("Wrong number of methods.", 1, methods.size());
	}

	@Test
	@Ignore("Ignored until everything else is fine. (Want to remove distraction.)")
	public void single_annotated_method_is_declared_by_super() throws Exception {
		TestClass testClass = new TestClass(Sub.class);
		List<FrameworkMethod> methods = testClass
				.getAnnotatedMethods(Test.class);
		assertEquals("Wrong declaring class.", "foobar.Super", methods.get(0)
				.getMethod().getDeclaringClass().getName());
	}

	@Test
	public void finds_single_annotated_method_from_super() throws Exception {
		TestClass testClass = new TestClass(Sub.class);
		Method methodFromJunit = testClass.getAnnotatedMethods(Test.class)
				.get(0).getMethod();
		Method methodViaReflection = Super.class.getMethod("methodOfSuper");
		assertEquals("Wrong method.", methodViaReflection, methodFromJunit);
	}
}
