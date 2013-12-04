package foobar;

import static java.lang.reflect.Modifier.isPublic;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.lang.reflect.Method;

import org.junit.Test;

public class SuperTest {
	@Test
	public void is_declared_class_of_its_method() throws Exception {
		Method method = Super.class.getMethod("methodOfSuper");
		assertEquals("foobar.Super", method.getDeclaringClass().getName());
	}

	@Test
	public void isNotPublic() {
		int modifiers = Super.class.getModifiers();
		boolean isPublic = isPublic(modifiers);
		assertFalse("Super is public (modifiers: " + modifiers + ").", isPublic);
	}
}
