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

<%-- <div id="fb-root"></div>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v3.3&appId=2104056399720115&autoLogAppEvents=1"></script>


<div class="fb-login-button" data-width="" data-size="large" data-button-type="continue_with" data-auto-logout-link="true" data-use-continue-as="true" onlogin="checkLoginState();">

</div>



<div class="fb-login-button" data-width="" data-size="large" data-button-type="continue_with" data-auto-logout-link="false" data-use-continue-as="false">
<a href="${facebook_url}">
	 	<button class="btn btn-primary btn-round" style="width: 100%">
			<i class="fa fa-facebook" aria-hidden="true"></i>Facebook Login
		</button>
</a>
</div> --%>

<div id="fb-root">
</div>
<script>(function(d, s, id) { var js, fjs = d.getElementsByTagName(s)[0]; if (d.getElementById(id)) return; js = d.createElement(s); js.id = id; js.src = "//connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v3.3&appId=2104056399720115&autoLogAppEvents=1"; fjs.parentNode.insertBefore(js, fjs); }(document, 'script', 'facebook-jssdk'));</script><div class="fb-login-button" data-show-faces="true" data-width="200" data-max-rows="1">
</div>


</body>
</html>