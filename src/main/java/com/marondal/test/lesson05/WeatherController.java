package com.marondal.test.lesson05;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marondal.test.lesson05.bo.WeatherBO;
import com.marondal.test.lesson05.model.Weather;

@Controller
@RequestMapping("/lesson05")
public class WeatherController {
	
	@Autowired
	private WeatherBO weatherBO;

	@GetMapping("/weather_history")
	public String weatherHistory(Model model) {
		// 데이터베이스 조회
		List<Weather> weatherHistory = weatherBO.getWeatherHistory();
		
		// 데이터를 모델에 셋팅
		model.addAttribute("weatherHistory", weatherHistory);
		
		return "lesson05/test05/weatherHistory";
		
	}
	
	@GetMapping("/weather_input")
	public String weatherInput() {
		return "lesson05/test05/weatherInput";
	}
	
	@GetMapping("/add_weather")
	public String addWeahter(
			@DateTimeFormat(pattern="yyyy-MM-dd")
			@RequestParam("date") Date date,
			@RequestParam("weather") String weather,
			@RequestParam("temperatures") double temperstures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("microDust") String microDust,
			@RequestParam("windSpeed") double windSpeed) {
		
		int count = weatherBO.addWeather(date, weather, temperstures, precipitation, microDust, windSpeed);
		
		// redirect
		return "redirect:/lesson05/weather_history";
		
	}
	
	
}
