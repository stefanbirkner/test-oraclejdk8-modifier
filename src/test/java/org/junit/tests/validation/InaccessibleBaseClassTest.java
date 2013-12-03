package org.junit.tests.validation;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

import foobar.Sub;

public class InaccessibleBaseClassTest {
    @Test(expected = InitializationError.class)
	@Ignore("Ignored until everything else is fine. (Want to remove distraction.)")
    public void inaccessibleBaseClassIsCaughtAtValidation() throws InitializationError {
        new BlockJUnit4ClassRunner(Sub.class);
    }
}
