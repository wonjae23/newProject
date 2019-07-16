<%/****************************************************************************
 JSP Name : popup_header.jsp
 Description : popup용 header
 Author: dolcoms
 Since: 2013. 10. 01
 Modification Information
 Mod Date	    Modifier	  Description
 ----------	    --------	  ---------------------------
 2013.10.01	    dolcoms	              최초 생성 
*******************************************************************************/%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.epasskorea.groupware.util.SessionUtil"%>
<%@ include file="/WEB-INF/views/common/jstl_taglib.jsp" %>

<c:set value="<%=SessionUtil.getCheckAuth(\"ASIGN\")%>" var="AUTH_READ"/>
<c:set value="<%=SessionUtil.getCheckAuth(\"ENTR\")%>" var="AUTH_WRITE"/>
<c:set value="<%=SessionUtil.getCheckAuth(\"EDIT\")%>" var="AUTH_EDIT"/>
<c:set value="<%=SessionUtil.getCheckAuth(\"DEL\")%>" var="AUTH_DELETE"/>
<c:set value="<%=SessionUtil.getCheckAuth(\"EXCL\")%>" var="AUTH_EXCEL"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>이패스코리아 GroupWare</title>
	<link rel="stylesheet" href="resources/common/css/admin.css" type="text/css" />  <!-- admin basic css -->
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"> <!-- jquery ui css -->
	<link rel="stylesheet" href="resources/common/css/tinyeditor.css">	<!-- tiny web editor css -->					
		
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
 	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>	
 	<script type="text/javascript" src="resources/common/js/jquery.DOMwindow.js"></script>	<!-- jquery dom window -->
 	<script type="text/javascript" src="resources/common/js/jquery.alphanumeric.js"></script>	<!-- jquery number input check -->
	<script type="text/javascript" src="resources/common/js/json.js"></script> 		<!-- jsonp 호출 -->	
	<script type="text/javascript" src="resources/common/js/tiny.editor.packed.js"></script> <!-- tiny web editor -->	
	<script type="text/javascript" src="resources/common/js/common.js"></script>		<!-- common js -->	
	<script type="text/javascript" src="resources/common/js/jquery_validate/jquery.validate.min.js"></script>		<!-- jquery validation -->
	<script type="text/javascript" src="resources/common/js/jquery_validate/messages_ko.js"></script>		<!-- jquery validation korean message-->
	<script type="text/javascript" src="resources/common/js/jquery.ui.datepicker-ko.js"></script><!-- 달력한글표기 -->
</head>
<body <c:if test="${req.player eq 'Y' || req.player eq 'N'}">oncontextmenu="javascript: return false;" ondragstart="javascript: return false;" onselectstart="javascript: return false;" </c:if>>
