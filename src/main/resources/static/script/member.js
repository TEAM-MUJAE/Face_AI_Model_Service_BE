$().ready(function(){
//	$('.update').on('click',function(){
//		alert(111);
//	})
	
})//전체

function update(flag){
	//패스워드 확인하기
	 openWin = window.open("/pwCheck","pwCheck", 
         "width=400, height=150, toolbar=no,location=no,menubar=no, resizable = no, scrollbars = no") ;
	if(flag=='u'){
		$("#upForm").attr('action',"/memUpForm");
	}else{
		/*var yn = confirm("정말 삭제하시겠습니까? \n 구매이력과 포인트가 삭제됩니다")
		if(yn==true){*/
		$("#upForm").attr('action',"/memdelete");
			
		/*}else{
			return False
		}*/
	}
}
function setParentText(){
	var pw1 = $('#pwck').val()//popup에서 받은 pass
	if(pw1==null || pw1.length==0){
		alert('패스워드를 입력하시오')
		$('#pwck').focus();
		return false;
	}
	var pw2 = $("#pw", opener.document).val();//opener값
    if(pw1==pw2){
		$("#upForm", opener.document).submit();
		this.window.close();
	}else{
		alert('비밀번호 오류')
		this.window.close();
	}
}





