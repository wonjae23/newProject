<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/popup_header.jsp"%>
<link href="//cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css" rel="stylesheet">

<script type="text/javascript">
	$(document).ready(function(){
		
		$("#insertMember").click(function(){    	    
		   var idReg = /^[a-zA-Z0-9]{4,12}$/ // 아이디와 패스워드가 적합한지 검사할 정규식
	       var emailReg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	       // 이메일이 적합한지 검사할 정규식
	
	       var name  = $("#userName");
	       var id    = $("#userId");
	       var pw    = $("#userPw");
	       var pw_a  = $("#userPw_a");
	       var email = $("#userEmail");
	       var doubleCheckStatus = $("#doubleCheckStatus");
	    
	       if(name.val()=="") {
	           alert("이름을 입력해 주세요");
	           name.focus();
	           return false;
	       }
	        
	       if(id.val()=="") {
	           alert("아이디를 입력해 주세요");
	           id.focus();
	           return false;
	       }
	       
	       if(!idReg.test(id.val())){
	            alert("아이디는 영문자로 시작하는 4~12자 영문자 또는 숫자이어야 합니다.");
	            id.focus();
	            return false;
	       }
	       
	       alert(doubleCheckStatus.val());
	       if(doubleCheckStatus.val() != 'Y'){
	            alert("중복 아아디체크는 필수사항입니다.");
	            return false;
	       }
	    
	       if(email.val()=="") {
	           alert("이메일을 입력해 주세요");
	           email.focus();
	           return false;
	       }
	       
	       if(!emailReg.test(email.val())){
	            alert("적합하지 않은 이메일 형식입니다.");
	            email.focus();
	            return false;
	       }
	       
	       if(pw.val()=="") {
	           alert("비밀번호를 입력해 주세요");
	           pw.focus();
	           return false;
	       }
	       
	       if(!idReg.test(pw.val())){
	            alert("비밀번호는 영문자로 시작하는 4~12자 영문자 또는 숫자이어야 합니다.");
	            pw.focus();
	            return false;
	       }
	       
	       if(pw_a.val()=="") {
	           alert("비밀번호를 입력해 주세요");
	           pw_a.focus();
	           return false;
	       }
	       
	       if(!idReg.test(pw_a.val())){
	            alert("비밀번호는 영문자로 시작하는 4~12자 영문자 또는 숫자이어야 합니다.");
	            pw_a.focus();
	            return false;
	       }
	       
	       if(pw.val() != pw_a.val()) {
	           alert("비밀번호가 다릅니다. 다시 확인해 주세요.");
	           pw.focus();
	           return false;
	       }
	          
		    //값 셋팅
		    /* var objParams = {
		    		userName   : $("#userName").val(),
		            userId     : $("#userId").val(),
		            userEmail  : $("#userEmail").val(),
		            userPw     : $("#userPw").val(),
		    };
		     
		    //ajax 호출
		    $.ajax({
		        url         :   "/main/insertMember",
		        dataType    :   "json",
		        contentType :   "application/x-www-form-urlencoded; charset=UTF-8",
		        type        :   "post",
		        data        :   objParams,
		        success     :   function(retVal){
		        	if(retVal.code == "OK") {
		                alert('가입되었습니다.');
		                location.href = "/board/list";  
		            } else {
		                alert('오류가 발생하였습니다.');
		            }
		             
		        },
		        error       :   function(request, status, error){
		            console.log("AJAX_ERROR");
		        }
		    }); */ 
		    
		    $("#login-form").attr("action", "/main/insertMember");
		    $("#login-form").submit();
		});
		
		$("#doubleCheckId").click(function(){
			if($("#userId").val() != ""){
				var objParams = {
			    		userId     : $("#userId").val()
			    };
				
				$.ajax({
			        url         :   "/main/doubleCheck",
			        dataType    :   "json",
			        contentType :   "application/x-www-form-urlencoded; charset=UTF-8",
			        type        :   "post",
			        data        :   objParams,
			        success     :   function(retVal){
			        	if(retVal.code == "OK") {
			                alert('사용할수 있는 아이디입니다.');
			                $("#doubleCheckStatus").val('Y')
			            } else {
			                alert('중복된 아이디가 있습니다.');
			                $("#userId").val("");
			                $("#userId").focus();
			            }
			             
			        },
			        error       :   function(request, status, error){
			            console.log("AJAX_ERROR");
			        }
			    });
			}
			
		});
	
	});
</script>

<div id="login-page" class="row">
  <div class="col s12 z-depth-4 card-panel">
    <form class="login-form" id="login-form">
      <div class="row">
        <div class="input-field col s12 center">
          <h4>Register</h4>
          <p class="center">Join to our community now !</p>
        </div>
      </div>

      <div class="row margin">
        <div class="input-field col s12">
          <i class="material-icons prefix">account_circle</i>
          <input id="userName" name="userName" type="text"  required />
          <label for="userName">Username</label>
        </div>
      </div>
	  
	  <div class="row margin" >
        <div class="input-field col s12" >
          <i class="material-icons prefix">account_circle</i>
          <input id="userId" name="userId" type="text"  required />
          <label for="userId">UserId</label>
          <button type="button" class="btn btn-secondary btn-sm" id="doubleCheckId" name="doubleCheckId">중복체크</button>
        </div>
      </div>
		
      <div class="row margin">
        <div class="input-field col s12">
          <i class="material-icons prefix">email</i>
          <input id="userEmail" name="userEmail" type="text"  required style="cursor: auto;" />
          <label for="userEmail">Email</label>
        </div>
      </div>

      <div class="row margin">
        <div class="input-field col s12">
          <i class="material-icons prefix">vpn_key</i>
          <input id="userPw" name="userPw" type="password" required/>
          <label for="userPw">Password</label>
        </div>
      </div>

      <div class="row margin">
        <div class="input-field col s12">
          <i class="material-icons prefix">vpn_key</i>
          <input id="userPw_a" name="userPw_a" type="password" required/>
          <label for="userPw_a">Password again</label>
        </div>
      </div>

      <div class="row">
        <div class="input-field col s12">
          <button class="btn waves-effect waves-light col s12" id="insertMember" name="insertMember">REGISTER NOW</button>
        </div>
        <div class="input-field col s12">
          <p class="margin center medium-small sign-up">Already have an account? <a href="/main/login">Login</a></p>
        </div>
      </div>

		<input type="hidden" id="doubleCheckStatus" name="doubleCheckStatus" >
    </form>
  </div>
</div>

<%@ include file="/WEB-INF/views/common/popup_footer.jsp"%>














