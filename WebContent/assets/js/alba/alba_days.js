/**
 * 디데이 계산
 */

let progressCount = 0;
let $endDay = $("span.end-day"); //신청 종료 날짜

$(document).ready(function(){
	
	$endDay.each(function(){
		let $countDay = $(this).prev(); //디데이
		let $applyStartDay = $(this).next(); //디데이
		let $progress = $(this).parents("li").find("p.progress"); // 진행상황
		
		let dDay = dDaysCount($(this));
		let count = countDates($applyStartDay);
		
		
		/* 비교 후 맞는 문구 삽입 */
		if (dDay > 0) {
			$countDay.html("D-" + dDay);
			/* 현재 시간이 신청 시작 날짜보다 이를 때 */
			if (count > 0) {
				$progress.html("예정");
			}
		} else if (dDay == 0) {
			$countDay.html("D-day");
			$progress.html("오늘마감");
		} else {
			$countDay.html("마감");
			$progress.html("마감");
		}
	});
});

/* 디데이 계산 함수 */
function dDaysCount(endDay){
	let today = new Date(); //현재 날짜 가져오기
	let dday = new Date(endDay.html()).getTime(); //디데이
	
	let days = dday - today;
	let result = Math.floor(days / (1000 * 60 * 60 * 24) + 1);
	
	return result;
}

/* 현재시간 - 신청 시작 날자 */
function countDates(startDay){
	let today = new Date(); //현재 날짜 가져오기
	let start = new Date(startDay.html()).getTime(); //시작날짜
	
	let days = start - today;
	let result = Math.floor(days / (1000 * 60 * 60 * 24) + 1);
	
	return result;
}

