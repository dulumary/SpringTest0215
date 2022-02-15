package com.marondal.test.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lesson01/test01")
public class Test01Controller {

	@RequestMapping("/1")
	@ResponseBody
	public String welcome() {
		return "<h2>테스트 프로젝트 완성</h2> 해당 프로젝트를 통해서 문제 풀이를 진행합니다";
	}
	
	@ResponseBody
	@RequestMapping("/2")
	public Map<String, Integer> printMap() {
		
		Map<String, Integer> map = new HashMap<>();
		map.put("국어", 90);
		map.put("수학", 95);
		map.put("영어", 85);
		
		return map;
	}
}
