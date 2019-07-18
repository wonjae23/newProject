<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/popup_header.jsp"%>

<script>
	$(document).ready(function(){
		if (getCookie("id")) { // getCookie함수로 id라는 이름의 쿠키를 불러와서 있을경우
		    $("#userId").val(getCookie("id")); //input 이름이 id인곳에 getCookie("id")값을 넣어줌
            $("#idsave").attr("checked", true);
        }
         
		$("#btnLogin").click(function(){
			var userId = $("#userId").val();
			var userPw = $("#userPw").val();
			
			if(userId == ""){
				alert("아이디를 입력하세요.");
				$("#userId").focus();
				return;
			}
			
			if(userPw == ""){
				alert("비밀번호를 입력하세요.");
				$("#userPw").focus();
				return;
			}
			
			if($("#idsave").is(":checked")){ // 아이디 저장을 체크 하였을때
			    setCookie("id", $("#userId").val(), 7); //쿠키이름을 id로 아이디입력필드값을 7일동안 저장
	        } else { // 아이디 저장을 체크 하지 않았을때
	            setCookie("id", $("#userId").val(), 0); //날짜를 0으로 저장하여 쿠키삭제
	        }
			 
			document.form1.action="${path}/main/loginCheck"
			document.form1.submit();
		});
		
		  
		
	});
	
	function setCookie(name, value, expiredays){ //쿠키 저장함수
        var todayDate = new Date();
        todayDate.setDate(todayDate.getDate() + expiredays);
        document.cookie = name + "=" + escape(value) + "; path=/; expires="
                + todayDate.toGMTString() + ";"
    }
 
    function getCookie(Name) { // 쿠키 불러오는 함수
        var search = Name + "=";
        if (document.cookie.length > 0) {
            offset = document.cookie.indexOf(search);
            if (offset != -1) {
                offset += search.length;
                end = document.cookie.indexOf(";", offset);
                if (end == -1)
                    end = document.cookie.length;
                return unescape(document.cookie.substring(offset, end));
            }
        }
    }
</script>

<div class="container">
    <div class="omb_login">
    	<h3 class="omb_authTitle">Login or <a href="/main/signUp">Sign up</a></h3>
		<div class="row omb_row-sm-offset-3 omb_socialButtons">
    	    <div class="col-xs-4 col-sm-2">
		        <a href="#" class="btn btn-lg btn-block omb_btn-facebook">
			        <i class="fa fa-facebook visible-xs"></i>
			        <span class="hidden-xs">Facebook</span>
		        </a>
	        </div>
        	<div class="col-xs-4 col-sm-2">
		        <a href="#" class="btn btn-lg btn-block omb_btn-twitter">
			        <i class="fa fa-twitter visible-xs"></i>
			        <span class="hidden-xs">Twitter</span>
		        </a>
	        </div>	
        	<div class="col-xs-4 col-sm-2">
		        <a href="#" class="btn btn-lg btn-block omb_btn-google">
			        <i class="fa fa-google-plus visible-xs"></i>
			        <span class="hidden-xs">Google+</span>
		        </a>
	        </div>	
		</div>

		<div class="row omb_row-sm-offset-3 omb_loginOr">
			<div class="col-xs-12 col-sm-6">
				<hr class="omb_hrOr">
				<span class="omb_spanOr">or</span>
			</div>
		</div>

		<div class="row omb_row-sm-offset-3">
			<div class="col-xs-12 col-sm-6">	
			    <form class="omb_loginForm"  autocomplete="off" method="POST" name="form1" id="form1">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-user"></i></span>
						<input type="text" class="form-control" name="userId" id="userId" placeholder="Id">
					</div>
					<span class="help-block"></span>
										
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-lock"></i></span>
						<input  type="password" class="form-control" name="userPw" id="userPw" placeholder="Password">
					</div>
					<c:if test="${msg == 'failure'}">
						<span class="help-block">아이디 또는 비밀번호가 일치하지 않습니다.</span>
					</c:if>
					<c:if test="${msg != 'failure'}">
						<span class="help-block"></span>
					</c:if>
					
    				<button class="btn btn-lg btn-primary btn-block" id="btnLogin">Login</button>
				</form>
			</div>
    	</div>
		<div class="row omb_row-sm-offset-3">
			<div class="col-xs-12 col-sm-3">
				<label class="checkbox">
					<input type="checkbox" value="remember-me" id="idsave" name="idsave">Remember Me
				</label>
			</div>
			<div class="col-xs-12 col-sm-3">
				<p class="omb_forgotPwd">
					<a href="#">Forgot password?</a>
				</p>
			</div>
		</div>	    	
	</div>
</div>

<%@ include file="/WEB-INF/views/common/popup_footer.jsp"%>
