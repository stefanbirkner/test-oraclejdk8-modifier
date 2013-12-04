package foobar;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.runners.model.FrameworkMethod;

public class FrameworkMemberTest {
	@Test
	public void does_not_have_annotation_defined_by_super() throws Exception {
		Method method = Sub.class.getMethod("methodOfSuper");
		FrameworkMethod frameworkMethod = new FrameworkMethod(method);
		assertEquals("Wrong number of annotations", 0,
				frameworkMethod.getAnnotations().length);
	}
}
