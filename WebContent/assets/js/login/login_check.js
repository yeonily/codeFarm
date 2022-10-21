/**
 * 로그인 send함수쓰기
 */
function send() {
	let id = loginForm.memberId.value;
	let pw = loginForm.memberPassword.value;

	if (!id) {
		loginForm.memberId.focus();
		return;
	}
	if (!pw) {
		loginForm.memberPassword.focus();
		return;
	}

	loginForm.submit();
}

// 아이디 저장 박스 체크하기

	// 아이디를 전달받았다면, 아이디 저장을 눌러서 로그인 했다는 뜻.
		let memberId = "${memberId}";
		
	// 위의 상황에 맞게 체크해주기!
		if(memberId){$("input[name='saveId']").prop("checked", true);}
		
		
		
		
// 아이디 찾기 부분 인증번호 요청 부분

/*사용자가 입력한 전화번호*/
let $inputPhoneNumber;

/*사용자가 인증번호 입력칸에 입력한 값*/
let $smsCheckNumber;

/*coolSMS에서 보낸 인증번호*/
let $smsNumber;

/*인증번호 일치 여부 flag 값*/
let $isCheck = false;


/*인증번호 발송 누를 시*/
function requestSms(){
	   $inputPhoneNumber = $(".findId_phone").val();
	  $.ajax({
		   url : "/member/send.me",
		   type : "post",
		   data: {inputPhoneNumber: $inputPhoneNumber},
		   success : function (result) {
			$smsNumber = result;
			}
	   })
       $(".p_con_inner").css("display", "block");
        code_id_check = true;
   }

/*인증번호 체크*/
function checkNumber(){
	$smsCheckNumber = $("#find_id_phone_code").val();
	
	if($smsCheckNumber == $smsNumber){
		$("#findIdMsg").text("인증번호가 일치합니다.");
		$("#findIdMsg").css("color", "blue");
		 $isCheck = true;
	
	}else{
		$("#findIdMsg").text("인증번호가 일치하지 않습니다.");
		$("#findIdMsg").css("color", "red");
		$("#find_id_phone_code").focus();
		 $isCheck = false;
	}
}

/*완료 버튼 누를 시*/
function findIdOk(){
		if($isCheck = true){
		findIdForm.submit();
		}else{
		  alert('휴대폰 인증을 해주세요.');
		}
	}

