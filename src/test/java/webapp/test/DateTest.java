package webapp.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import webapp.escape.Background;
import webapp.escape.Screen;

import com.ibm.icu.util.Calendar;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DateTest {

	static Log log = LogFactory.getLog(DateTest.class);
	
	@Test
	public void test() {
		Date current = new Date();
		log.info(current.toLocaleString());
	}
	
	@Test
	public void test2(){
		Calendar current = Calendar.getInstance();
		log.info(current.getTime());
	}
	
	@Test
	public void test4(){
		Date date = new Date(2015-1900,3-1,1);
		
		log.info("start week "+date.getDay());
		
		log.info(date.toLocaleString());
		
		int month = date.getMonth();
		while(true){
			date.setDate(date.getDate()+1);
			if(month != date.getMonth()){
				break;
			}
		}
		date.setDate(date.getDate()-1);
		log.info("end week "+date.getDay());
		log.info(date.toLocaleString());	
	}
	
	@Test
	public void test5(){
		Date date = new Date(2015-1900,3-1,1);
		
		int month = date.getMonth()+1;
		int year = date.getYear()+1900;
		
		log.info(year+"."+month);
		
		String week = "";
		
		int firstWeekDay = date.getDay();
		
		for(int i=0;i<firstWeekDay;i++){
			week = week+"_ ";
		}	
		
		while(true){
			String d = "";
			if(date.getDate()<10){
				d="0"+date.getDate();
			}else{
				d=""+date.getDate();
			}
			week = week+d+" ";	
			if(date.getDay()==6){
				log.info(week);
				week="";
			}			
			
			date.setDate(date.getDate()+1);			
			
			if(month-1 != date.getMonth()){
				log.info(week);
				break;
			}
		}
	}
	
	@Test
	public void test6(){
		Screen.clear();		
		
		boolean condition = true;
		while(condition){
			Screen.cursorPosition(5,1);
			System.out.print("[yyyy/MM] : ");		
			Scanner scanner = new Scanner(System.in);
			String param = scanner.nextLine();
			
			if(param.equals(".")) break;
			
			System.out.println(param);
			String[] p = param.split("/");
			int year = Integer.parseInt(p[0]);
			int month = Integer.parseInt(p[1]);
		}
		
		
		
		Screen.background(Background.RED);		
		System.out.println("Calendar Test");
		
		Screen.reset();
	}

}
