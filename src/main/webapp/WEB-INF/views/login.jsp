<%/****************************************************************************
 JSP Name : /login.jsp
 Description : login form
 Author: dolcoms
 Since: 2014. 01. 00
 Modification Information
 Mod Date	    Modifier	  Description
 ----------	    --------	  ---------------------------
 2014.01.00	    dolcoms	              최초 생성 
*******************************************************************************/%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/popup_header.jsp"%>
<div class="loginWrap">
	<h1><a href="">LOGO</a></h1> 
	<h2>Administrator Login</h2>
	<br>
	<%
	    String error = (String) request.getAttribute("error");
	    if (error != null && error.equals("true"))
	    {
	        out.println("<h3 style=\"color:red\">로그인 정보가 유효하지 않습니다. 다시 시도해주세요!!</h4>");
	    }
	     
	%>
	
	<form method="POST" action="<c:url value='login' />">
		<div class="login">
			<p>
				<label for="">아이디</label>
				<input type="text" name="username" id="username" value="" required  maxlength="30"/><!-- !!주의!! 아이디 패스워드 입력해서 SVN 및 개발서버 업로드 금지 -->
			</p>
			<p>
				<label for="">비밀번호</label>
				<input type="password" name="password" id="password" value="" required  maxlength="30"/><!-- !!주의!! 아이디 패스워드 입력해서 SVN 및 개발서버 업로드 금지 -->
			</p>
			<input type="submit" name="submit" value="LOGIN" class="btBasic login">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />		
		</div>
	</form>
	
	 

	<p class="attention">※ 본 사이트는 관리자 외에는 접근을 금지합니다. </p>
	<ul class="dotList">
		<li>사내 인트라넷 시스템(GroupWare)에서 발급받으신 아이디와 비밀번호를<br> 입력 후 로그인하여 주십시오.</li>
		<li>아이디와 비밀번호가 유출되지 않도록 각별히 주의하여 주시기 바라며,<br> 비밀번호는 수시로 변경하여 비밀번호가 유출되는 것을 방지하여 주십시오. </li>
		<li>사용 중 오류가 발생할 경우 시스템 담당자에게 문의하여 주십시오.</li>
	</ul>
	<p class="attentionBox">
		시스템 담당자 :  정보기술팀  조성우 팀장  ☎ 070-4304-1310
	</p>
</div>
<div id="footer">
	<p class="copyright">
		Copyright (C) 2003~2019 epasskorea. All Rights Reserved. 
	</p>
</div>	


<%@ include file="/WEB-INF/views/common/popup_footer.jsp"%>

<script type="text/javascript">
window.name ="epkAdmin";

	$(document).ready(function(){
		/**
		* LOGIN 버튼 클릭
		*/
		/* $("#btnLogin").click(function(){
			$("#frmInsert").validate();
		});
		
		if ("${checkplusYN }" == "Y") {
			popup_checkplus();
		} */
		
	});

</script>
