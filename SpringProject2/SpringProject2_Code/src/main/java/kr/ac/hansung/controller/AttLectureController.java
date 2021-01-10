package kr.ac.hansung.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.AttLecture;
import kr.ac.hansung.service.AttLectureService;

/* @Component를 구체화시켜 @Controller, @Service, @Repository를 사용한다. 
 * 이러면 스프링에게 좀 더 자세한 정보를 줄 수 있음. 
 * @Component는 제네럴한 어노테이션임. 
 */
@Controller
public class AttLectureController {
	@Autowired
	public AttLectureService attLectureService;

//	@RequestMapping("/attLectures")
//	public String showOffers(Model model) {
//		// database의 offers 테이블의 데이터들을 불러와서 리스트에 저장.
//		List<AttLecture> lectures = attLectureService.getCurrent();
//
//		int creditTotal2016_1 = attLectureService.getCreditTotal(2016, 1);
//		int creditTotal2016_2 = attLectureService.getCreditTotal(2016, 2);
//		int creditTotal2019_1 = attLectureService.getCreditTotal(2019, 1);
//		int creditTotal2019_2 = attLectureService.getCreditTotal(2019, 2);
//
//		// 불러온 offers를 model에 저장.
//		model.addAttribute("lectures", lectures);
//
//		model.addAttribute("creditTotal2016_1", creditTotal2016_1);
//		model.addAttribute("creditTotal2016_2", creditTotal2016_2);
//		model.addAttribute("creditTotal2019_1", creditTotal2019_1);
//		model.addAttribute("creditTotal2019_2", creditTotal2019_2);
//
//		// view로 offers 데이터들을 넘김.
//		return "attLectures";
//	}
//
//	@RequestMapping("/view2016_1Lectures")
//	public String show_2016_1_Offers(Model model) {
//		// database의 offers 테이블의 데이터들을 불러와서 리스트에 저장.
//
//		List<AttLecture> lecturesBy2016_1 = attLectureService.getLectureByYT(2016, 1);
//
//		// 불러온 offers를 model에 저장.
//		model.addAttribute("lecturesBy2016_1", lecturesBy2016_1);
//
//		// view로 offers 데이터들을 넘김.
//		return "view2016_1Lectures";
//	}
//
//	@RequestMapping("/view2016_2Lectures")
//	public String show_2016_2_Offers(Model model) {
//		// database의 offers 테이블의 데이터들을 불러와서 리스트에 저장.
//
//		List<AttLecture> lecturesBy2016_2 = attLectureService.getLectureByYT(2016, 2);
//
//		// 불러온 offers를 model에 저장.
//		model.addAttribute("lecturesBy2016_2", lecturesBy2016_2);
//
//		// view로 offers 데이터들을 넘김.
//		return "view2016_2Lectures";
//	}
//
//	@RequestMapping("/view2019_1Lectures")
//	public String show_2019_1_Offers(Model model) {
//		// database의 offers 테이블의 데이터들을 불러와서 리스트에 저장.
//
//		List<AttLecture> lecturesBy2019_1 = attLectureService.getLectureByYT(2019, 1);
//
//		// 불러온 offers를 model에 저장.
//		model.addAttribute("lecturesBy2019_1", lecturesBy2019_1);
//
//		// view로 offers 데이터들을 넘김.
//		return "view2019_1Lectures";
//	}
//
//	@RequestMapping("/view2019_2Lectures")
//	public String show_2019_2_Offers(Model model) {
//		// database의 offers 테이블의 데이터들을 불러와서 리스트에 저장.
//
//		List<AttLecture> lecturesBy2019_2 = attLectureService.getLectureByYT(2019, 2);
//
//		// 불러온 offers를 model에 저장.
//		model.addAttribute("lecturesBy2019_2", lecturesBy2019_2);
//
//		// view로 offers 데이터들을 넘김.
//		return "view2019_2Lectures";
//	}

	// 학기별 수강 리스트를 보기 위한 페이지로 이동
	@RequestMapping("/attLectures")
	public String showLecture(HttpServletRequest request, Model model) {
		List<AttLecture> lectures = attLectureService.getLecture();
		model.addAttribute("lectures", lectures);

		return "attLectures";
	}

	// 학기별 수강 리스트를 보여줌
	@RequestMapping("/viewLectures")
	public String showLectureList(HttpServletRequest request, Model model) {
		int att_year = Integer.parseInt(request.getParameter("att_year"));
		int att_term = Integer.parseInt(request.getParameter("att_term"));
		List<AttLecture> lectures = attLectureService.getLectureByYT(att_year, att_term);
		model.addAttribute("lectures", lectures);

		return "viewLectures";
	}

	@RequestMapping("/viewRegistLectures")
	public String showRegistLectures(Model model) {
		// database의 offers 테이블의 데이터들을 불러와서 리스트에 저장.

		List<AttLecture> lecturesBy2020_1 = attLectureService.getLectureByYT(2020, 1);

		// 불러온 offers를 model에 저장.
		model.addAttribute("lecturesBy2020_1", lecturesBy2020_1);

		// view로 offers 데이터들을 넘김.
		return "viewRegistLectures";
	}

	@RequestMapping("/registerLecture")
	public String createoffer(Model model) {

		/*
		 * model.addAttribute("offer", new Offer());을 하지 않으면 맨 처음 아무것도 입력하지 않았을때의 화면을 띄울
		 * 때( createoffer() )는 Model이 비어있게 되므로 가져올 offer이 없어서 에러가 발생하게 된다. docreate()에서는
		 * 데이터 바인딩을 해올 때 offer가 자동적으로 Model에 들어가므로 우리가 직접 넣어주지 않아도 됐다.
		 */
		model.addAttribute("lecture", new AttLecture());
		return "registerLecture";
	}

	// @Valid 사용 시 data를 객체로 binding할 때 자동으로 값을 검증 해 준다.
	@RequestMapping("/docreate")
	public String docreate(Model model, @Valid AttLecture lecture /* data binding */,
			BindingResult result/* binding하고 검증된 결과가 넣어지게 됨. */) {
		if (result.hasErrors()) {// 에러가 있을 경우
			System.out.println("=== Web Form data does not validated ===");
			// result에 있는 모든 에러를 리스트로 받아온다.
			List<ObjectError> errors = result.getAllErrors();

			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "registerLecture";
			// 에러뜨면 다시 페이지로 이동
		}

		// 에러가 없는 경우
		// controller는 service를 호출하고, service는 dao를 호출한다.
		attLectureService.insert(lecture); // controller->service->dao

		return "offercreated";
	}

}