/**
 * 사용자가 알바 신청
 */
function send(){
      if(!applyForm.userName){
         alert("이름을 작성해주세요.");
         return;
      }
      
      if(!applyForm.userBirth){
         alert("생년월일을 작성해주세요.");
         return;
      }
      
      if(!applyForm.userPhone){
         alert("핸드폰 번호을 작성해주세요.");
         return;
      }
      
      if(!applyForm.userEmail){
         alert("이메일을 작성해주세요.");
         return;
      }
      
      applyForm.submit();
   }