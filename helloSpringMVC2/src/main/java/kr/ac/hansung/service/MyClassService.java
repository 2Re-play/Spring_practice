package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.MyClassDao;
import kr.ac.hansung.model.MyClass;
import kr.ac.hansung.model.Semester;

@Service
public class MyClassService {

	@Autowired
	private MyClassDao myClassDao;
	
	public List<Semester> getMyClassSemester () {
		return myClassDao.getSemesters();
	}
	
	
	public List<MyClass> getMyClassSemesterList (int year, int semester) {
		return myClassDao.getSemestersList(year, semester);
	}
	
	public void insert (MyClass myClass) {
		myClassDao.insert(myClass);
	}
	
	public List<MyClass> getMyClassSemesterFuture () {
		return myClassDao.getSemestersFutureList();
	}
	
	
}
