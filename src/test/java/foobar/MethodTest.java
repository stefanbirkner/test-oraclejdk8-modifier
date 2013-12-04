package foobar;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;

import org.junit.Test;

public class MethodTest {
	@Test
	public void does_not_have_annotation_defined_by_super() throws Exception {
		Method method = Sub.class.getMethod("methodOfSuper");
		assertEquals("Wrong number of annotations", 0,
				method.getAnnotations().length);
	}
}
