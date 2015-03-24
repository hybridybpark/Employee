package webapp.main;

import java.util.Date;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import webapp.escape.Background;
import webapp.escape.Screen;

public class CalendarTest {
	
	public static void printCalendar(int y,int m){
		Screen.cursorPosition(3, 5);
		
		
			int year = y;
			int month = m;
			Date date = new Date(year-1900,month-1,1);	
			
			System.out.println(year+"."+month);
			System.out.println("--------------------");
			
			String week = "";
			
			int firstWeekDay = date.getDay();
			
			for(int i=0;i<firstWeekDay;i++){
				week = week+"   ";
			}	
			int count = 0;
			while(true){
				String d = "";
				if(date.getDate()<10){
					d="0"+date.getDate();
				}else{
					d=""+date.getDate();
				}
				week = week+d+" ";	
				if(date.getDay()==6){
					System.out.println(week);
					week="";
				}			
				
				date.setDate(date.getDate()+1);			
				
				if(month-1 != date.getMonth()){					
					break;
				}
				count++;
			}
			for(int i=date.getDay();i<7;i++){
				week = week+"   ";
			}
			System.out.println(week);
			System.out.println("--------------------");
//			System.out.println(count);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Screen.clear();
		Scanner scan = new Scanner(System.in);
		while(true){			
			int year=0;
			int month=0;
			String param="";
			boolean flag=true;
			
			do{
				Screen.cursorPosition(20, 1);
				System.out.print("[yyyy/MM] : ");
				param = scan.nextLine();
				System.out.println("param="+param);				
				
//				flag = param.matches("[1-9][0-9][0-9][0-9]/[0-9][0-9]");
				flag = param.matches("[1-9][0-9]{3}/[0-1][0-9]");
			}while(!flag);
			String[] p = param.split("/");
			year = Integer.parseInt(p[0]);
			month = Integer.parseInt(p[1]);
			if(month>0 && month<13){
				printCalendar(year,month);
			}
		}
	}

}
