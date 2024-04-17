package com.shinhan.javasqlproject;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import com.shinhan.util.DateUtil;

public class ApartmentController {

	static Scanner sc = new Scanner(System.in);
	static boolean isDone;
	static int selectWORK;
	static residentSERVICE resService = new residentSERVICE();
	static storeSERVICE strService = new storeSERVICE();
	static workerSERVICE wrkService = new workerSERVICE();
	static facilitySERVICE facService = new facilitySERVICE();

	public static void main(String[] args) {

		boolean isStop = false;
		while (!isStop) {
			int selectJOB = mainmenuDisplay();

			switch (selectJOB) {
			/*시스템 종료*/
			case 0 -> {
				isStop = true;
			}

			/*주민 항목*/
			case 1 -> {
				isDone = false;
				while (!isDone) {
					selectWORK = RESmenuDisplay();

					switch (selectWORK) {
					case 0 -> {// 메인 메뉴
						isDone = true;
					}
					case 1 -> {// 주민 정보 검색
						System.out.print("주민ID 입력>>");
						int resID = sc.nextInt();
						residentVIEW.print(resService.findBYID(resID), "주민 정보 조회");
					}
					case 2 -> {// 동별 주민 목록 조회
						System.out.print("조회할 아파트동 번호>>");
						int resDong = sc.nextInt();
						residentVIEW.print(resService.findBYDONG(resDong), "<"+resDong + "동 입주민 목록>");
					}
					case 3 -> {// 주민 정보 입력
						System.out.println("    -----주민 정보 입력 항목입니다-----");
						System.out.println("-----보유 차량 수와 관리비는 세대주만 입력-----");
						residentDTO res = insertResMenu();
						int result = resService.resInsert(res);
						residentVIEW.print(result > 0 ? "입력성공" : "입력실패");
					}
					case 4 -> {// 주민 정보 수정
						System.out.println("   ------주민 정보 수정 항목입니다------");
						System.out.println("------주민 ID와 수정 항목을 선택해주세요------");

						System.out.print("주민 ID>>");
						int resid = sc.nextInt();

						System.out.println("<< 수정 항목 선택 >>");
						System.out.print("1.주민 이름");
						System.out.print(" 2.주민 H.P");
						System.out.print(" 3.동");
						System.out.print(" 4.호수");
						System.out.print(" 5.입주일자");
						System.out.print(" 6.세대주 여부");
						System.out.print(" 7.보유 차량 수");
						System.out.println(" 8.관리비");
						System.out.print(">>");

						int select = sc.nextInt();
						System.out.println("선택항목:" + select);

						Object obj = updateResMenu(select);

						int result = resService.resUpdate(select, resid, obj);
						residentVIEW.print(result > 0 ? "수정성공" : "수정실패");
					}
					case 5 -> {// 주민 정보 삭제
						System.out.print("삭제할 주민의 ID>>");
						int resid = sc.nextInt();
						int result = resService.resDelete(resid);
						residentVIEW.print(result > 0 ? "삭제성공" : "삭제실패");
					}
					default -> {}
					}
				}

			}
			
			/*공용시설 항목*/
			case 2 -> {
				isDone = false;
				while (!isDone) {
					selectWORK = FACmenuDisplay();

					switch (selectWORK) {
					case 0 -> {// 메인 메뉴
						isDone = true;
					}
					case 1 -> {// 공용시설ID 입력해 정보 출력
						System.out.print("공용시설ID>>");
						int facID = sc.nextInt();
						facilityVIEW.print(facService.findBYID(facID));
					}
					case 2 -> {// 공용시설별 근무자 목록 검색
						System.out.print("공용시설명 입력>>");
						String facname = sc.next();
						facilityVIEW.print(facService.findBYfacname(facname));
					}
					case 3 -> {// 공용시설 정보 입력
						System.out.println("     ------공용시설 정보 입력 항목입니다------");
						facilityDTO fac = insertfacMenu();
						int result = facService.facInsert(fac);
						facilityVIEW.print(result > 0 ? "입력성공" : "입력실패");

					}
					case 4 -> {// 공용시설 정보 수정
						System.out.println("   ------공용시설 정보 수정 항목입니다------");
						System.out.println("------공용시설 ID와 수정 항목을 선택해주세요------");

						System.out.print("공용시설 ID>>");
						int facid = sc.nextInt();

						System.out.println("<< 수정 항목 선택 >>");
						System.out.print("1.시설명");
						System.out.print(" 2.준공일");
						System.out.print(" 3.시설종류");
						System.out.print(" 4.운영시작시각");
						System.out.print(" 5.운영종료시각");
						System.out.println(" 6.매니저ID");
						System.out.print(">>");

						int select = sc.nextInt();
						System.out.println("선택항목:" + select);

						Object obj = updateFacMenu(select);

						int result = facService.facUpdate(select, facid, obj);
						facilityVIEW.print(result > 0 ? "수정성공" : "수정실패");
					}
					case 5 -> {// 공용시설 정보 삭제
						System.out.print("삭제할 공용시설의 ID>>");
						int facid = sc.nextInt();
						int result = facService.facDelete(facid);
						residentVIEW.print(result > 0 ? "삭제성공" : "삭제실패");
					}
					default -> {}
					}
				}

			}
			
			/*근로자 항목*/
			case 3 -> {
				isDone = false;
				while (!isDone) {
					selectWORK = WKRmenuDisplay();

					switch (selectWORK) {
					case 0 -> {// 메인 메뉴
						isDone = true;
					}
					case 1 -> {// 근로자 ID를 입력하여 근로자 정보 검색
						System.out.print("근로자 ID 입력>>");
						int wkrID = sc.nextInt();
						workerVIEW.print(wrkService.findBYID(wkrID), "근로자 정보 조회");
					}
					case 2 -> {// 업무명을 입력하여 해당 업무의 근로자 목록 조회
						System.out.print("업무명 입력>>");
						String work = sc.next();
						workerVIEW.print(wrkService.findByWork(work));
					}
					case 3 -> {// 근로자 정보 입력
						System.out.println("     ------근로자 정보 입력 항목입니다------");
						workerDTO wkr = insertWkrMenu();
						int result = wrkService.wkrInsert(wkr);
						residentVIEW.print(result > 0 ? "입력성공" : "입력실패");
					}
					case 4 -> {// 근로자 정보 수정
						System.out.println("   ------근로자 정보 수정 항목입니다------");
						System.out.println("------근로자 ID와 수정 항목을 선택해주세요------");

						System.out.print("근로자 ID>>");
						int resid = sc.nextInt();

						System.out.println("<< 수정 항목 선택 >>");
						System.out.print("1.근로자명");
						System.out.print(" 2.나이");
						System.out.print(" 3.성별");
						System.out.print(" 4.H.P");
						System.out.print(" 5.근무시작일");
						System.out.print(" 6.담당시설ID");
						System.out.print(" 7.담당업무");
						System.out.println(" 8.급여");
						System.out.print(">>");

						int select = sc.nextInt();
						System.out.println("선택항목:" + select);

						Object obj = updateWrkMenu(select);

						int result = wrkService.wrkUpdate(select, resid, obj);
						workerVIEW.print(result > 0 ? "수정성공" : "수정실패");
					}
					case 5 -> {// 근로자 정보 삭제
						System.out.print("삭제할 근로자의 ID>>");
						int wrkid = sc.nextInt();
						int result = wrkService.wrkDelete(wrkid);
						workerVIEW.print(result > 0 ? "삭제성공" : "삭제실패");
					}
					default -> {}
					}
				}
			}
			
			/*상가 항목*/
			case 4 -> {
				isDone = false;
				while (!isDone) {
					selectWORK = STRmenuDisplay();

					switch (selectWORK) {
					case 0 -> {// 메인 메뉴
						isDone = true;
					}
					case 1 -> {// 상가ID를 입력해 해당 상가의 정보 출력
						System.out.print("상점ID 입력>>");
						int strID = sc.nextInt();
						storeVIEW.print(strService.findBYID(strID), "상점 정보 조회");
					}
					case 2 -> {// 업종별 상가 검색
						System.out.print("업종명 입력>>");
						String strType = sc.next();
						storeVIEW.print(strService.findByType(strType), "상점 목록:" + strType);
					}
					case 3 -> {// 상가 정보 입력
						System.out.println("     ------상점 정보 입력 항목입니다------");
						storeDTO str = insertStrMenu();
						int result = strService.strInsert(str);
						residentVIEW.print(result > 0 ? "입력성공" : "입력실패");

					}
					case 4 -> {// 상가 정보 수정
						System.out.println("   ------상가 정보 수정 항목입니다------");
						System.out.println("------상가 ID와 수정 항목을 선택해주세요------");

						System.out.print("상가 ID>>");
						int strid = sc.nextInt();

						System.out.println("<< 수정 항목 선택 >>");
						System.out.print("1.상점명");
						System.out.print(" 2.점주명");
						System.out.print(" 3.전화번호");
						System.out.print(" 4.업종");
						System.out.print(" 5.영업시작시각");
						System.out.println(" 6.영업종료시각");
						System.out.print(">>");

						int select = sc.nextInt();
						System.out.println("선택항목:" + select);

						Object obj = updateStrMenu(select);

						int result = strService.strUpdate(select, strid, obj);
						residentVIEW.print(result > 0 ? "수정성공" : "수정실패");
					}
					case 5 -> {// 상가 정보 삭제
						System.out.print("삭제할 상점의 ID>>");
						int strid = sc.nextInt();
						int result = strService.resDelete(strid);
						residentVIEW.print(result > 0 ? "삭제성공" : "삭제실패");
					}
					case 6->{
						storeVIEW.print(strService.findIsOpen(),"현재 영업 중인 상점");
					}
					
					
					default -> {}
					}
				}
			}
			default -> {
			}
			}
		}
		System.out.println("=============아파트 전산시스템 종료=============");

	}

	//시설 관련 세부메뉴
	private static Object updateFacMenu(int select) {
		Object obj = null;
		switch (select) {
		case 1 -> {// 시설명
			System.out.print("이름>>");
			obj = sc.next();
		}
		case 2 -> {// 준공일
			System.out.print("준공일>>");
			obj = DateUtil.getSQLDate(sc.next());
		}
		case 3 -> {// 시설종류
			System.out.print("시설종류>>");
			obj = sc.next();
		}
		case 4 -> {// 영업시작시각
			System.out.print("영업시작시각>>");
			obj = sc.next();
		}
		case 5 -> {// 영업종료시각
			System.out.print("영업종료시각>>");
			obj = sc.next();
		}
		case 6 -> {// 시설관리자ID
			System.out.print("시설관리자ID>>");
			obj = sc.nextInt();
		}
		}
		return obj;
	}

	private static facilityDTO insertfacMenu() {
		System.out.print("공용시설 ID>>");
		int facid = sc.nextInt();

		System.out.print("시설명>>");
		String facname = sc.next();

		System.out.print("준공일>>");
		Date facdate = DateUtil.getSQLDate(sc.next());

		System.out.print("시설종류>>");
		String factype = sc.next();

		System.out.print("운영시작시각>>");
		String fac_start_time = sc.next();

		System.out.print("운영종료시각>>");
		String fac_end_time = sc.next();

		System.out.print("시설관리자ID>>");
		int facManager = sc.nextInt();

		facilityDTO fac = new facilityDTO();
		fac.setFacility_id(facid);
		fac.setFacility_name(facname);
		fac.setFacility_date(facdate);
		fac.setFacility_type(factype);
		fac.setFacility_start_time(fac_start_time);
		fac.setFacility_end_time(fac_end_time);
		fac.setFacility_manager_id(facManager);

		return fac;
	}

	//근로자 관련 세부 메뉴
	private static Object updateWrkMenu(int select) {
		Object obj = null;
		switch (select) {
		case 1 -> {// 이름
			System.out.print("이름>>");
			obj = sc.next();
		}
		case 2 -> {// 나이
			System.out.print("나이>>");
			obj = sc.nextInt();
		}
		case 3 -> {// 성별
			System.out.print("성별>>");
			obj = sc.next();
		}
		case 4 -> {// 전화번호
			System.out.print("전화번호>>");
			obj = sc.next();
		}
		case 5 -> {// 입사일
			System.out.print("입사일>>");
			obj = DateUtil.getSQLDate(sc.next());
		}
		case 6 -> {// 담당시설ID
			System.out.print("담당시설ID>>");
			obj = sc.nextInt();
		}
		case 7 -> {// 업무
			System.out.print("업무>>");
			obj = sc.next();
		}
		case 8 -> {// 급여
			System.out.print("급여>>");
			obj = sc.nextInt();
		}
		}
		return obj;
	}

	private static workerDTO insertWkrMenu() {
		System.out.print("근로자 ID>>");
		int wkrid = sc.nextInt();

		System.out.print("이름>>");
		String name = sc.next();

		System.out.print("나이>>");
		int age = sc.nextInt();

		System.out.print("성별>>");
		String gender = sc.next();

		System.out.print("H.P>>");
		String phone = sc.next();

		System.out.print("입사일(yyyy-MM-dd)>>");
		Date date = DateUtil.getSQLDate(sc.next());

		System.out.print("담당시설ID>>");
		int fid = sc.nextInt();

		System.out.print("업무>>");
		String work = sc.next();

		System.out.print("급여>>");
		int salary = sc.nextInt();

		workerDTO wkr = new workerDTO();
		wkr.setWORKER_ID(wkrid);
		wkr.setWORKER_NAME(name);
		wkr.setWORKER_AGE(age);
		wkr.setWORKER_GENDER(gender);
		wkr.setWORKER_PHONE(phone);
		wkr.setWORKER_HIREDATE(date);
		wkr.setWORKER_WORKPLACE_ID(fid);
		wkr.setWORKER_WORK(work);
		wkr.setWORKER_SALARY(salary);

		return wkr;
	}

	//상가 관련 세부 메뉴
	private static Object updateStrMenu(int select) {
		Object obj = null;
		switch (select) {
		case 1 -> {// 상점명
			System.out.print("상점명>>");
			obj = sc.next();
		}
		case 2 -> {// 점주명
			System.out.print("점주명>>");
			obj = sc.next();
		}
		case 3 -> {// 전화번호
			System.out.print("전화번호>>");
			obj = sc.nextInt();
		}
		case 4 -> {// 업종명
			System.out.print("업종>>");
			obj = sc.nextInt();
		}
		case 5 -> {// 영업시작시각
			System.out.print("영업시작시각>>");
			obj = sc.next();
		}
		case 6 -> {// 영업종료시각
			System.out.print("영업종료시각>>");
			obj = sc.next();
		}
		}
		return obj;
	}

	private static storeDTO insertStrMenu() {
		System.out.print("상점 ID>>");
		int strid = sc.nextInt();

		System.out.print("사업자번호>>");
		String business_number = sc.next();

		System.out.print("상점명>>");
		String name = sc.next();

		System.out.print("점주명>>");
		String owner = sc.next();

		System.out.print("H.P>>");
		String phone = sc.next();

		System.out.print("업종구분>>");
		String type = sc.next();

		System.out.print("개업일(yyyy-MM-dd)>>");
		Date date = DateUtil.getSQLDate(sc.next());

		System.out.print("영업시작시각(HH24:mm:ss)>>");
		String startTime = sc.next();

		System.out.print("영업종료시각(HH24:mm:ss)>>");
		String endTime = sc.next();

		storeDTO str = new storeDTO();
		str.setSTORE_ID(strid);
		str.setSTORE_BUSSINESS_NUMBER(business_number);
		str.setSTORE_NAME(name);
		str.setSTORE_OWNER(owner);
		str.setSTORE_PHONE(phone);
		str.setSTORE_TYPE(type);
		str.setSTORE_STARTDATE(date);
		str.setSTORE_START_TIME(startTime);
		str.setSTORE_END_TIME(endTime);
		return str;
	}

	//주민 관련 세부 메뉴
	private static Object updateResMenu(int select) {
		Object obj = null;
		switch (select) {
		case 1 -> {// 주민 이름
			System.out.print("주민 이름>>");
			obj = sc.next();
		}
		case 2 -> {// 주민 H.P
			System.out.print("주민 H.P>>");
			obj = sc.next();
		}
		case 3 -> {// 동
			System.out.print("동>>");
			obj = sc.nextInt();
		}
		case 4 -> {// 호
			System.out.print("호>>");
			obj = sc.nextInt();
		}
		case 5 -> {// 입주일자
			System.out.print("입주일자>>");
			obj = DateUtil.getSQLDate(sc.next());
		}
		case 6 -> {// 세대주 여부
			System.out.print("세대주 여부>>");
			obj = sc.nextInt();
		}
		case 7 -> {// 보유 차량 수
			System.out.print("보유 차량 수>>");
			obj = sc.next();
		}
		case 8 -> {// 관리비
			System.out.print("관리비>>");
			obj = sc.next();
		}
		}
		return obj;
	}

	private static residentDTO insertResMenu() {
		System.out.print("주민 ID>>");
		int resid = sc.nextInt();

		System.out.print("주민 이름>>");
		String name = sc.next();

		System.out.print("주민 H.P>>");
		String phone = sc.next();

		System.out.print("동>>");
		int dong = sc.nextInt();

		System.out.print("호>>");
		int ho = sc.nextInt();

		System.out.print("입주일자(yyyy-MM-dd)>>");
		Date date = DateUtil.getSQLDate(sc.next());

		System.out.print("세대주 여부(O:1,X:0)>>");
		int isOwner = sc.nextInt();

		String carCount = "해당없음";
		String fee = "해당없음";

		if (isOwner == 1) {
			System.out.print("보유 차량 수>>");
			carCount = sc.next();

			System.out.print("관리비>>");
			fee = sc.next();
		}

		residentDTO res = new residentDTO();

		res.setResident_id(resid);
		res.setResident_name(name);
		res.setResident_phone(phone);
		res.setResident_dong(dong);
		res.setResident_ho(ho);
		res.setResident_date(date);
		res.setResident_car(carCount);
		res.setResident_fee(fee);
		res.setResident_owner(isOwner);

		return res;
	}

	/*업무 선택 메뉴들*/
	private static int STRmenuDisplay() {
		System.out.println("--상가 -> 업무 선택--");
		System.out.print("0.메인 메뉴");
		System.out.print(" 1.상가 정보 검색");
		System.out.print(" 2.업종별 상가 목록 조회");
		System.out.print(" 3.상가 정보 입력");
		System.out.print(" 4.상가 정보 수정");
		System.out.print(" 5.상가 정보 삭제");
		System.out.println(" 6.현재 영업 여부");
		System.out.print("항목 선택>>");
		int work = sc.nextInt();
		return work;
	}

	private static int WKRmenuDisplay() {
		System.out.println("--근로자 -> 업무 선택--");
		System.out.print("0.메인 메뉴");
		System.out.print(" 1.근로자 정보 검색");
		System.out.print(" 2.업무별 근로자 목록 조회");
		System.out.print(" 3.근로자 정보 입력");
		System.out.print(" 4.근로자 정보 수정");
		System.out.println(" 5.근로자 정보 삭제");
		System.out.print("항목 선택>>");
		int work = sc.nextInt();
		return work;
	}

	private static int FACmenuDisplay() {
		System.out.println("--공용시설 -> 업무 선택--");
		System.out.print("0.메인 메뉴");
		System.out.print(" 1.공용시설 정보 검색");
		System.out.print(" 2.해당 공용시설 근무자 목록");
		System.out.print(" 3.공용시설 정보 입력");
		System.out.print(" 4.공용시설 정보 수정");
		System.out.println(" 5.공용시설 정보 삭제");
		System.out.print("항목 선택>>");
		int work = sc.nextInt();
		return work;
	}

	private static int RESmenuDisplay() {
		System.out.println("--주민 -> 업무 선택--");
		System.out.print("0.메인 메뉴");
		System.out.print(" 1.주민 정보 검색");
		System.out.print(" 2.동별 주민 조회");
		System.out.print(" 3.주민 정보 입력");
		System.out.print(" 4.주민 정보 수정");
		System.out.println(" 5.주민 정보 삭제");
		System.out.print("항목 선택>>");
		int work = sc.nextInt();
		return work;
	}

	/*메인 메뉴*/
	private static int mainmenuDisplay() {
		System.out.println("================OOO 아파트 전산시스템================");
		System.out.println("--항목을 선택하세요--");
		System.out.print("0.시스템 종료");
		System.out.print(" 1.주민");
		System.out.print(" 2.공용시설");
		System.out.print(" 3.근로자");
		System.out.println(" 4.상가");
		System.out.print("항목 선택>>");
		int job = sc.nextInt();
		return job;
	}

}
