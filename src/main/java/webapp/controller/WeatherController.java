package webapp.controller;


import webapp.model.Weather;
import webapp.service.WeatherService;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom2.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/weather")
public class WeatherController {
	
	static Log log = LogFactory.getLog(WeatherController.class);
	
	@Autowired
	WeatherService service;	
	
//	public void setService(WeatherService service) {
//		this.service = service;
//	}
	
//	@RequestMapping(method=RequestMethod.GET,value={"/",""})
	@RequestMapping(method=RequestMethod.GET,value={"/"})
	public String showForm(){
		
		log.info("###SHOW FORM######");
		
		return "weather/form";
	}
	
	@RequestMapping(value="/show",method=RequestMethod.POST)
	public String showWeather(Model model,String city){
		log.info("###SHOW WEATHER###");
		
		log.info("city = "+city);
		
		try {
			Weather weather = service.getWeather(city);
			
			model.addAttribute("weather", weather);
			
		} catch (IOException | JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "weather/weather";
	}
}
