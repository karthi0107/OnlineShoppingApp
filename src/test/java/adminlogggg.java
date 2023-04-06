import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
@Listeners(com.GenericUtilities.ListenerImplementation.class)
public class adminlogggg extends BaseClass {
	@Test
	public void log() {
		System.out.println("logggggggggggggggggggg");
		Assert.fail();
	}

}
