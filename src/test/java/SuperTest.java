import static java.lang.reflect.Modifier.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class SuperTest {
  @Test
  public void isNotPublic() { 
    int modifiers = Super.class.getModifiers();
    boolean isPublic = isPublic(modifiers);
    assertFalse(isPublic);    
  }
}
