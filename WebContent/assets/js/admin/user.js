/**
 * 사용자관리페이지 관련
 */

$.ajax({
	url:"/admin/User.ad",
	type:"get",
	data:{memberNumber: memberNumber, memberId: memberId, memberEmail: memberEmail, 
	memberPhoneNumber: memberPhoneNumber, memberName: memberName,
	 memberGrade: memberGrade, memberLocation: memberLocation},
	contentType: "application/json; charset=utf-8",
	dataType: "json",
	success: function(userList){
		console.log(userList);
	}
	
});