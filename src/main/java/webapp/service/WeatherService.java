package webapp.service;

import java.io.IOException;
import java.io.InputStream;

import java.net.URL;
import java.util.ArrayList;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;

import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import org.springframework.stereotype.Service;

import webapp.model.Current;
import webapp.model.Forecast;
import webapp.model.Weather;



@Service
public class WeatherService {
	
	
	static Log log = LogFactory.getLog(WeatherService.class);
	
	SAXBuilder jdom;
	XPathFactory factory;
	XPathExpression<Element> expression1,expression2;
	
	String weatherUrl = "http://weather.service.msn.com/data.aspx?culture=ko-KR&weasearchstr=";
	
	public WeatherService() {
		// TODO Auto-generated constructor stub
		jdom = new SAXBuilder();
		factory = XPathFactory.instance();
		
		expression1 = factory.compile("//forecast",Filters.element());
		expression2 = factory.compile("//current",Filters.element());
		
	}
	
	public Weather getWeather(String city) throws IOException, JDOMException{
		log.info("#####################");
		log.info("GET WEATHER ="+city);
		log.info("#####################");
		weatherUrl = weatherUrl+city;
		Weather w = new Weather();
		
		w.setCurrent(this.getCurrentWeather());
		w.setForecasts(this.getForecast());
		
		return w;
	}
	public Current getCurrentWeather() throws IOException, JDOMException{
		
		
		URL url;
		url = new URL(weatherUrl);
		
		InputStream in = url.openStream();		
		
		Document doc = jdom.build(in);
		
		List<Element> current = expression2.evaluate(doc);
		
		Element c1 = current.get(0);
		
		Current cr = new Current();
		
		cr.setDate(c1.getAttributeValue("date"));
		cr.setDay(c1.getAttributeValue("day"));
		
		cr.setFeelslike(c1.getAttributeValue("feelslike"));
		cr.setHumidity(c1.getAttributeValue("humidity"));
		cr.setObservationpoint(c1.getAttributeValue("observationpoint"));
		cr.setObservationtime(c1.getAttributeValue("observationtime"));
		cr.setShortday(c1.getAttributeValue("shortday"));
		cr.setSkycode(c1.getAttributeValue("skycode"));
		cr.setSkytext(c1.getAttributeValue("skytext"));
		cr.setTemperature(c1.getAttributeValue("temperature"));
		cr.setWinddisplay(c1.getAttributeValue("winddisplay"));
		cr.setWindspeed(c1.getAttributeValue("windspeed"));
		
		return cr;
	}
	public List<Forecast> getForecast() throws IOException, JDOMException{		
		
		URL url;
		url = new URL(weatherUrl);
		
		InputStream in = url.openStream();		
		
		Document doc = jdom.build(in);
		
		List<Element> forecasts = expression1.evaluate(doc);
		
		log.info(forecasts.size());
		
		List<Forecast> forecastList = new ArrayList<Forecast>();
		
		for(Element e : forecasts){
						
			Forecast temp = new Forecast();
			temp.setDate(e.getAttributeValue("date"));
			temp.setDay(e.getAttributeValue("day"));
			temp.setHigh(e.getAttributeValue("high"));
			temp.setLow(e.getAttributeValue("low"));
			temp.setPrecip(e.getAttributeValue("precip"));
			temp.setShortday(e.getAttributeValue("shortday"));
			temp.setSkycodeday(e.getAttributeValue("skycodeday"));
			temp.setSkytextday(e.getAttributeValue("skytextday"));
			
			
			forecastList.add(temp);			
		}
		
		return forecastList;
	}
}
