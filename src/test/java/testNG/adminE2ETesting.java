package testNG;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.GenericUtilities.BaseClass;
import ObjectRepo.adminHomePage;
import ObjectRepo.createcategoryPage;
import ObjectRepo.insertProductPage;
import ObjectRepo.subCategoryPage;
//@Listeners(com.GenericUtilities.ListenerImplementation.class)
public class adminE2ETesting extends BaseClass{

	@Test //(retryAnalyzer = com.GenericUtilities.retryImpClass.class)
	public void addProduct() throws Throwable {

		adminHomePage ahp = new adminHomePage(driver);
		ahp.CreateCategorylink();
		createcategoryPage cc = new createcategoryPage(driver);
		String categoryname = cc.createcategory(jLib, eLib, driver);

		ahp.subcategorylink();
		subCategoryPage sc = new subCategoryPage(driver);
		String subcategoryname = sc.createsubCategory(driver, eLib, wLib, categoryname);
		
		ahp.insertproductlink();
		insertProductPage insert = new insertProductPage(driver);
		insert.insertProduct(wLib, jLib, eLib, driver, categoryname, subcategoryname);

	}
}
