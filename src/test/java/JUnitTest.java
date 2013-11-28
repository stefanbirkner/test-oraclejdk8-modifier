import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.internal.MethodSorter;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import foobar.Sub;

public class JUnitTest {
    @Test(expected = InitializationError.class)
    public void inaccessibleBaseClassIsCaughtAtValidation() throws InitializationError {
        new BlockJUnit4ClassRunner(Sub.class);
    }
}
