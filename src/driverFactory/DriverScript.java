 package driverFactory;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import commonFunction.FunctionLibrary;
import constant.AppUtil;
import utilities.ExcelFileUtil;

public class DriverScript extends AppUtil{
	String inputpath="D:\\Automation_practice\\Hybrids_Framework\\TestInput\\exceltable.xlsx";
	String outputpath="D:\\Automation_practice\\Hybrids_Framework\\TestOutput\\Hybridresults.xlsx";
	ExtentReports report;
	ExtentTest test;
	String TCSheet="TestCases";
	String TSSheet="TestSteps";
	@Test
	public void startTest() throws Throwable {
		boolean res=false;
		String tcres="";
		ExcelFileUtil xl=new ExcelFileUtil(inputpath);
		//count no of rows in both sheets
		int TCCount=xl.rowcount(TCSheet);
		int TSCount=xl.rowcount(TSSheet);
		//count no  of cells in both sheets
		int TCCells=xl.cellcount(TCSheet);
		int TSCells=xl.cellcount(TSSheet);
		Reporter.log(TCCount+"  "+TSCount+"  "+TCCells+"  "+TSCells,true);
		for(int i=1;i<=TCCount;i++)
		{
			//read module name
			String modulename=xl.getcelldata(TCSheet, i, 1);
			//read module status cell
			String modulestatus=xl.getcelldata(TCSheet, i, 2);
			if (modulestatus.equalsIgnoreCase("Y")) {
				String tcid=xl.getcelldata(TCSheet, i, 0);
				//iterate all rows for tssheet
				for(int j=1;j<=TSCount;j++)
				{
					//read description cell
					String description=xl.getcelldata(TSSheet, j, 2);
					//read tsid cell
					String tsid=xl.getcelldata(TSSheet, j, 0);
					if (tcid.equalsIgnoreCase(tsid)) 
					{
						//read keyword cell
						String keyword=xl.getcelldata(TSSheet, j, 4);
						if (keyword.equals("adminlogin")) 
						{
							String para1=xl.getcelldata(TSSheet, j, 5);
							String para2=xl.getcelldata(TSSheet, j, 6);
							res=FunctionLibrary.verifylogin(para1, para2);
						}
						else if (keyword.equalsIgnoreCase("branchcreation")) 
						{
							String para1=xl.getcelldata(TSSheet, j, 5);
							String para2=xl.getcelldata(TSSheet, j, 6);
							String para3=xl.getcelldata(TSSheet, j, 7);
							String para4=xl.getcelldata(TSSheet, j, 8);
							String para5=xl.getcelldata(TSSheet, j, 9);
							String para6=xl.getcelldata(TSSheet, j, 10);
							String para7=xl.getcelldata(TSSheet, j, 11);
							String para8=xl.getcelldata(TSSheet, j, 12);
							String para9=xl.getcelldata(TSSheet, j, 13);
							FunctionLibrary.clickbranches();
							res=FunctionLibrary.verifybranchcreation(para1, para2, para3, para4, para5,para6, para7, para8, para9);			
						}
						else if (keyword.equalsIgnoreCase("branchupdate")) 
						{
							String para1=xl.getcelldata(TSSheet, j, 5);
							String para2=xl.getcelldata(TSSheet, j, 6);
							String para5=xl.getcelldata(TSSheet, j, 9);
							FunctionLibrary.clickbranches();
							res=FunctionLibrary.verifybranchupdate(para1, para2, para5);
						}
						else if (keyword.equalsIgnoreCase("adminlogout")) 
						{
							res=FunctionLibrary.verifylogout();
						}
						else if(keyword.equalsIgnoreCase("rolecreation"))
						{
							String para1=xl.getcelldata(TSSheet, j, 5);
						String para2=xl.getcelldata(TSSheet, j, 6);
						String para3=xl.getcelldata(TSSheet, j, 7);
						FunctionLibrary.clickroles();
						res=FunctionLibrary.verifyrolecreation(para1, para2, para3);	
						}
						
						
						String tsres="";
						if (res)
						{
							
							//write as pass into tssheet
							tsres="pass";
							xl.setcelldata(TSSheet, j, 3, tsres, outputpath);
						}
						else
							//write as fail
							tsres="fail";
						xl.setcelldata(TSSheet, j, 3, tsres, outputpath);
						tcres=tsres;
					}
					}
				
			
			xl.setcelldata(TCSheet, i, 3, tcres, outputpath);	
			}
		else 
		{
			//write as bloked into status cell which are flagged to N
			xl.setcelldata(TCSheet, i, 3, "blocked", outputpath);
		}
	}

		}
}
		
	












