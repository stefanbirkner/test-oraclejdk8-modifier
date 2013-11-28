package foobar;

import static java.lang.reflect.Modifier.*;
import static org.junit.Assert.*;

import java.lang.reflect.Method;
import org.junit.Test;

public class SubTest {
  @Test
  public void is_declared_class_of_inherited_method() throws Exception {
    Method method = Sub.class.getMethod("methodOfSuper"); 
    assertEquals("foobar.Sub", method.getDeclaringClass().getName());
  }

  @Test
  public void has_one_declared_method() {
    Method[] methods = Sub.class.getDeclaredMethods();
    assertEquals("Wrong number of methods.", 1, methods.length);
  }
}
