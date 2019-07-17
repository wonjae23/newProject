<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/popup_header.jsp"%>
<link href="//cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css" rel="stylesheet">
<script type="text/javascript"> //<![CDATA[ $(function() { $("#login-form").validate(); }); //]]> </script>

<script type="text/javascript">
	$(document).ready(function(){
		$("#insertMember").click(function(){    
		    
		    if($("#userPw").val().trim() != $("#userPw_a").val().trim()){
		        alert("비밀번호가 동일하지 않습니다.");
		        $("#userPw").focus();
		        return false;
		    }
		     
		    /* //값 셋팅
		    var objParams = {
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
		    });  */ 
		    
		    //$("#login-form").attr("action", "/main/insertMember");
		    //$("#login-form").submit();
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
          <!-- <i class="mdi-social-person-outline prefix"></i> -->
          <i class="material-icons prefix">account_circle</i>
          <input id="userName" name="userName" type="text" minlength="2" required />
          <label for="userName">Username</label>
        </div>
      </div>
	  
	  <div class="row margin">
        <div class="input-field col s12">
          <!-- <i class="mdi-social-person-outline prefix"></i> -->
          <i class="material-icons prefix">account_circle</i>
          <input id="userId" name="userId" type="text" minlength="2" required />
          <label for="userId">UserId</label>
        </div>
      </div>
		
      <div class="row margin">
        <div class="input-field col s12">
          <!-- <i class="mdi-social-person-outline prefix"></i> -->
          <i class="material-icons prefix">email</i>
          <input id="userEmail" name="userEmail" type="text" minlength="2" required style="cursor: auto;" />
          <label for="userEmail">Email</label>
        </div>
      </div>

      <div class="row margin">
        <div class="input-field col s12">
          <!-- <i class="mdi-action-lock-outline prefix"></i> -->
          <i class="material-icons prefix">vpn_key</i>
          <input id="userPw" name="userPw" type="password" required/>
          <label for="userPw">Password</label>
        </div>
      </div>

      <div class="row margin">
        <div class="input-field col s12">
          <!-- <i class="mdi-action-lock-outline prefix"></i> -->
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


    </form>
  </div>
</div>

<%@ include file="/WEB-INF/views/common/popup_footer.jsp"%>














