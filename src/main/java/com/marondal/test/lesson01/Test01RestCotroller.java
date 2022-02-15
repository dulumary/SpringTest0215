package com.marondal.test.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ReponseBody
public class Test01RestCotroller {
	
	@RequestMapping("/lesson01/test01/3")
	public List<Map<String, Object>> printMap() {
		
		List<Map<String, Object>> list = new ArrayList<>();
		
		Map<String, Object> map1 = new HashMap<>();
		map1.put("rate", 15);
		map1.put("director", "����ȣ");
		map1.put("time", 131);
		map1.put("title", "�����");
		list.add(map1);
		
		Map<String, Object> map2 = new HashMap<>();
		map2.put("rate", 0);
		map2.put("director", "�κ����� ���ϴ�");
		map2.put("time", 116);
		map2.put("title", "�λ��� �Ƹ��ٿ�");
		list.add(map2);
		
		return list;
		
	}

}
