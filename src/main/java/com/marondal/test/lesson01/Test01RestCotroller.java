package com.marondal.test.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marondal.test.lesson01.model.BoardContent;

@RestController // @Controller + @ReponseBody
@RequestMapping("/lesson01/test01")
public class Test01RestCotroller {
	
	@RequestMapping("/3")
	public List<Map<String, Object>> printMap() {
		
		List<Map<String, Object>> list = new ArrayList<>();
		
		Map<String, Object> map1 = new HashMap<>();
		map1.put("rate", 15);
		map1.put("director", "봉준호");
		map1.put("time", 131);
		map1.put("title", "기생충");
		list.add(map1);
		
		Map<String, Object> map2 = new HashMap<>();
		map2.put("rate", 0);
		map2.put("director", "로베르토 베니니");
		map2.put("time", 116);
		map2.put("title", "인생은 아름다워");
		list.add(map2);
		
		return list;
		
	}
	
	@RequestMapping("/4")
	public List<BoardContent> printListObject() {
		
		List<BoardContent> list = new ArrayList<>();
		
		BoardContent boardContent1 = new BoardContent();
		boardContent1.setTitle("안녕하세요. 가입인사 드립니다.");
		boardContent1.setContent("안녕하세요 가입했어요 블라 블라~~");
		boardContent1.setUser("김인규");
		list.add(boardContent1);
		
		BoardContent boardContent2 = new BoardContent();
		boardContent2.setTitle("헐 대박");
		boardContent2.setContent("응 아니야~");
		boardContent2.setUser("바다");
		list.add(boardContent2);
		
		BoardContent boardContent3 = new BoardContent();
		boardContent3.setTitle("오늘 여친 만난 썰 푼다");
		boardContent3.setContent(".......");
		boardContent3.setUser("dulumary");
		list.add(boardContent3);
		
		return list;
	}
	
	@RequestMapping("/5")
	public ResponseEntity<BoardContent> entity() {
		BoardContent boardContent1 = new BoardContent();
		boardContent1.setTitle("안녕하세요. 가입인사 드립니다.");
		boardContent1.setContent("안녕하세요 가입했어요 블라 블라~~");
		boardContent1.setUser("김인규");
		
		ResponseEntity<BoardContent> entity = new ResponseEntity<>(boardContent1, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
		
	}

}
