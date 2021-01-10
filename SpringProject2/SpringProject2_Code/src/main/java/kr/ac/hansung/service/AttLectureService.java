package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.AttLectureDao;
import kr.ac.hansung.model.AttLecture;

@Service
public class AttLectureService {

	@Autowired
	private AttLectureDao attLectureDao;
	
	// offerDao의 getOffers()를 호출한다. 
//	public List<AttLecture> getCurrent() {
//		return attLectureDao.getLectures();
//	}
	
	public List<AttLecture> getLecture() {
		return attLectureDao.getLecture();
	}

	public void insert(AttLecture lecture) {
		attLectureDao.insert(lecture);
	}
	

	public List<AttLecture> getLectureByYT(int att_year, int att_term) {
		return attLectureDao.getLectureByYearTerm(att_year, att_term);
	}
	
//	public int getCreditTotal(int att_year, int att_term) {
//		return attLectureDao.getCreditTotal(att_year, att_term);
//	}

}
