package model;

import java.util.ArrayList;
import java.util.List;

public class ScoreDAO {
	
	public List<ScoreDTO> scoreList() {
		//입력자료
		List<String> data = new ArrayList();
		
		data.add("1,01,01,90,80,90");
		data.add("1,01,02,90,78,88");
		data.add("1,01,03,,89,77,88");
		data.add("1,02,01,78,67,88");
		data.add("1,02,02,95,86,86");
		data.add("1,03,03,93,66,88");
		data.add("1,03,01,77,88,88");
		data.add("1,03,02,70,80,80");
		data.add("1,03,03,70,90,90");
		
		//ScoreDTO 객체를 생성 후 반환
		List<ScoreDTO> sList = new ArrayList<ScoreDTO>();
		ScoreDTO dto = null;
		for(int i=0; i<data.size(); i++) {
			String str[] = data.get(i).split(",");
			dto = new ScoreDTO();
			dto.setSyear(str[0]);
			dto.setSclass(str[1]);
			dto.setSno(str[2]);
			dto.setKor(Integer.parseInt(str[3]));
			dto.setEng(Integer.parseInt(str[4]));
			dto.setMat(Integer.parseInt(str[5]));

			sList.add(dto);
		}
		return sList;
	}
}
