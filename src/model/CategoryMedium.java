package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import interfaces.QuestionListMaker;

public class CategoryMedium implements QuestionListMaker {

	public CategoryMedium() {		
		populateMap();
	}
	
	@Override
	public void populateMap() {
		map.clear();
		map.put(11,new QuestionCategory("RB","EASY"));
		map.put(12,new QuestionCategory("TF","EASY"));
		map.put(13,new QuestionCategory("RB","EASY"));
		map.put(14,new QuestionCategory("FIB","EASY"));
		map.put(15,new QuestionCategory("RB","MEDIUM"));
		map.put(16,new QuestionCategory("INT","MEDIUM"));
		map.put(17,new QuestionCategory("RB","MEDIUM"));
		map.put(18,new QuestionCategory("TF","HARD"));
		map.put(19,new QuestionCategory("RB","HARD"));
		map.put(20,new QuestionCategory("FIB","HARD"));			
	}

	@Override
	public List<Questions> getQuestionsList() {		
		List<Questions> list = new ArrayList();				
		for(Map.Entry<Integer,QuestionCategory> entry:map.entrySet())
			list.add(dBhelper.getByTypeAndDifficulty(map.get(entry.getKey())));
		
		return list;
	}

}
