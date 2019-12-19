package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.MyClassDao;
import kr.ac.hansung.model.MySemester;


@Service
public class MyClassService {

	@Autowired
	private MyClassDao myClassDao;
	
	public List<MySemester> getClassSemester () {
		return myClassDao.getClassSemester();
	}
	
//	public void insert (MyClass myClass) {
//		myClassDao.insert(myClass);
//	}
}
