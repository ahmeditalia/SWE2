package SWEProject.Main.TestNG;

import org.testng.annotations.Test;

import SWEProject.Main.Application;
import SWEProject.Main.Controller.StatisticsController;
import SWEProject.Main.Controller.Entities.Statistics;

import org.testng.annotations.DataProvider;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.crypto.KeyAgreement;

import org.junit.runner.RunWith;
import org.junit.validator.PublicClassValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class StatisticsTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private StatisticsController statisticsController;

	@Test(dataProvider = "validstat")
	public void addstatTestValid(List<String[]> lists) {
		
		List<Statistics> statistics=statisticsController.showstat(Arrays.asList(lists.get(0)));
		for(int i=0;i<statistics.size();i++)
		{
			assertEquals(statistics.get(i).getId().toString(), lists.get(1)[4*i+0]);
			assertEquals(Integer.toString(statistics.get(i).getNumUserBuy()), lists.get(1)[4*i+1]);
			assertEquals(Integer.toString(statistics.get(i).getNumUserView()), lists.get(1)[4*i+2]);
			assertEquals(Integer.toString(statistics.get(i).getSoldProducts()), lists.get(1)[4*i+3]);
		}
		
	}

	@Test(dataProvider = "invalidstat")
	public void addstatTestInvalid(String[] lists) {
		
		List<Statistics> statistics=statisticsController.showstat(Arrays.asList(lists));
		assertEquals(statistics.size(), 0);
	}
	@DataProvider(name="validstat" )
	public Object[][] validstat() {
		return new Object[][] {
			{listing(new String[] {"store1"},new String[] {"1","1","1","3"})},
			{listing(new String[] {"store2"},new String[] {"2","1","1","4"})},
			{listing(new String[] {"store1","store2"},new String[] {"1","1","1","3","2","1","1","4"})}

			};
	}
	@DataProvider(name="invalidstat" )
	public Object[][] invalidstat() {
		return new Object[][] {
			{"store3","store4"},
			{""},
			{"null"},
			};
	}	
	public List<String[]>listing(String [] actual,String[] expexted)
	{
		List<String[]> list=new ArrayList<String[]>();
		list.add(actual);
		list.add(expexted);
		return list;
	}

}
