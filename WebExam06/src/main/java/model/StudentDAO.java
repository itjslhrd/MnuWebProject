package model;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	
	public List<StudentDTO> getStudent(){
		
		List<StudentDTO> sList = new ArrayList();
		
		sList.add(new StudentDTO("1","01","01","김학생","20020101","F","010","1111","1001"));
		sList.add(new StudentDTO("1","01","02","이학생","20020201","M","010","1111","1002"));
		sList.add(new StudentDTO("1","01","03","박학생","20020301","M","010","1111","1003"));
		sList.add(new StudentDTO("1","02","01","김학생","20020401","M","010","1111","1004"));
		sList.add(new StudentDTO("1","02","02","이학생","20020501","F","010","1111","1005"));
		sList.add(new StudentDTO("1","03","03","홍학생","20020601","F","010","1111","1006"));
		sList.add(new StudentDTO("1","03","01","박학생","20020701","M","010","1111","1007"));
		sList.add(new StudentDTO("1","03","02","강학생","20020801","M","010","1111","1008"));
		sList.add(new StudentDTO("1","03","03","최학생","20020901","F","010","1111","1009"));
		
		
		return sList;
	}
	
	public List<StudentDTO> studentInput() {
		List<String> data = new ArrayList<String>();
		data.add("1,01,01,김학생,20020101,F,010,1111,1001");
		data.add("1,01,02,이학생,20020201,M,010,1111,1002");
		data.add("1,01,03,박학생,20020301,M,010,1111,1003");
		data.add("1,02,01,김학생,20020401,M,010,1111,1004");
		data.add("1,02,02,이학생,20020501,F,010,1111,1005");
		data.add("1,03,03,홍학생,20020601,F,010,1111,1006");
		data.add("1,03,01,박학생,20020701,M,010,1111,1007");
		data.add("1,03,02,강학생,20020801,M,010,1111,1008");
		data.add("1,03,03,최학생,20020901,F,010,1111,1009");
/*		
		// 테스트
		for(String str : data) {
			System.out.println(str);
		}
*/
		List<StudentDTO> sList = new ArrayList<StudentDTO>();
		for(int i=0; i<data.size(); i++) {
			StudentDTO student = new StudentDTO();
			String str[] = data.get(i).split(",");
			student.setSyear(str[0]);
			student.setSclass(str[1]);
			student.setSno(str[2]);
			student.setSname(str[3]);
			student.setBirth(str[4]);
			student.setGender(str[5]);
			student.setTel1(str[6]);
			student.setTel2(str[7]);
			student.setTel3(str[8]);
			
			sList.add(student);
		}
		return sList;
	}
}
