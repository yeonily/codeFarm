let code_id_check = false;
let code_pw_check = false;

/*사용자가 입력한 전화번호*/
let $inputPhoneNumber;

/*사용자가 인증번호 입력칸에 입력한 값*/
let $smsCheckNumber;

/*coolSMS에서 보낸 인증번호*/
let $smsNumber;


// 아이디 찾기 팝업 띄우기
    function openPop_id() {
        document.getElementById("fine_id_popup").style.display = "block";
        code_id_check = false;
        $("#fine_id_popup").show();
        $(".id_step1").show();
        $(".findId_code").hide();
        $(".id_step2").hide();
    }
    // 아이디 찾기에서 팝업 닫기
    function closePop_id() {
        document.getElementById("fine_id_popup").style.display = "none";
    }

    /* 휴대폰번호 인증버튼 클릭시 */
  		$(".btn_phone_id").click(function () {
		$inputPhoneNumber = $("#find_id_phone").val();
		$inputName = $("#find_id_name").val();
        
		if(!findIdForm.memberFindName.value){
            findIdForm.memberFindName.focus();
            return;
        }
        
        if(!findIdForm.memberFindPhoneNumber.value){
            findIdForm.memberFindPhoneNumber.focus();
            return;
        }
			
			$.ajax({
				url: "/member/send.me",
				type: "post",
				data: { inputPhoneNumber: $inputPhoneNumber },
				success: function(result) {
					$smsNumber = result;
				}
			})
      
       $(".findId_code").css("display", "block");
        code_id_check = true;
    });

let memberFindId;
    // 이이디 찾기 핸드폰 인증 후 확인 버튼
    $(".id_next_step").click(function () {
		$smsCheckNumber = $("#find_id_phone_code").val();
        if ($smsCheckNumber != $smsNumber) {
            alert ("올바른 인증번호를 입력해주세요.");
            return;
        }
        $(".id_step2").show();
        $(".id_step1").hide();

		$.ajax({
			url:"/member/findId.me",
			type : "post",
			data: { inputPhoneNumber: $inputPhoneNumber, inputName : $inputName },
			success: function(result) {
				console.log(result);
				memberFindId = result;
				console.log(memberFindId);
				$("#memberFindId").text(memberFindId);
				console.log(memberFindId);
			}
		});
		
		/*document.getElementById("memberFindId").innerHTML=memberFindId;*/
	console.log($inputPhoneNumber);
	console.log($inputName);
	
});

 // ---------------------------------------------------------------------------------


 // 비밀번호 찾기 팝업 띄우기
    function openPop_pw() {
        document.getElementById("fine_pw_popup").style.display = "block";
        code_pw_check = false;
        $("#fine_pw_popup").show();
        $(".pw_step1").show();
        $(".findPw_code").hide();
        $(".pw_step2").hide();
    }
    // 비밀번호 찾기에서 팝업 닫기
    function closePop_pw() {
        document.getElementById("fine_pw_popup").style.display = "none";
    }
    
    // 비밀번호 저장하고 팝업 닫기
    function closePop_save() {
        document.getElementById("fine_pw_popup").style.display = "none";
    }

    /* 휴대폰번호 인증버튼 클릭시 */
    $(".btn_phone_pw").click(function () {
		$inputPhoneNumber = $("#find_id_phone").val();
		$inputId = $("#find_pw_name").val();
		
        if(!findPwForm.findPw_name.value){
            findPwForm.findPw_name.focus();
            return;
        }
        
        if(!findPwForm.findPw_phone.value){
            findPwForm.findPw_phone.focus();
            return;
        }

	$.ajax({
		url: "/member/send.me",
		type: "post",
		data: { inputPhoneNumber: $inputPhoneNumber },
		success: function(result) {
			$smsNumber = result;
		}
	})
        $(".findPw_code").css("display", "block");
        code_pw_check = true;
    });

    // 비밀번호 찾기 핸드폰 인증 후 확인 버튼
    $(".pw_next_step").click(function () {
	$smsCheckNumber = $("#find_pw_phone_code").val();
	
        if ($smsCheckNumber != $smsNumber) {
            alert ("올바른 인증번호를 입력해주세요.");
            return;
        }
        $(".pw_step2").show();
        $(".pw_step1").hide();

		$.ajax({
			url:"/member/findPw.me",
			type : "post",
			data: { inputPhoneNumber: $inputPhoneNumber, inputId : $inputId },
			success: function(result) {
				console.log(result);
			}
		});
		console.log($inputPhoneNumber);
		console.log($inputName);
    });
