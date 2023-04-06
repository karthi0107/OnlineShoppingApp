package crossBrowserExecution;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;

public class Login extends BaseClass {
	
	@Test
	public void Loginadmin()  {
		System.out.println("login to admin application ");
	}

}
