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
	<link rel="stylesheet" href="/common/css/admin.css" type="text/css" />  <!-- admin basic css -->
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"> <!-- jquery ui css -->
		
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
 	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>	
 	<script type="text/javascript" src="/common/js/common.js"></script>		<!-- common js -->	
 	
 	
 	<!-- 부트스트랩 부분 css, js -->
 	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  	<meta name="description" content="">
  	<meta name="author" content="">

  	<!-- Custom fonts for this template-->
  	<link href="/common/bootstrap/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  	<!-- Page level plugin CSS-->
  	<link href="/common/bootstrap/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

  	<!-- Custom styles for this template-->
  	<link href="/common/bootstrap/css/sb-admin.css" rel="stylesheet">
  	
  	 <!-- Bootstrap core JavaScript-->
  	<script src="/common/bootstrap/vendor/jquery/jquery.min.js"></script>
  	<script src="/common/bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  	<!-- Core plugin JavaScript-->
  	<script src="/common/bootstrap/vendor/jquery-easing/jquery.easing.min.js"></script>

  	<!-- Page level plugin JavaScript-->
  	<script src="/common/bootstrap/vendor/chart.js/Chart.min.js"></script>
  	<script src="/common/bootstrap/vendor/datatables/jquery.dataTables.js"></script>
  	<script src="/common/bootstrap/vendor/datatables/dataTables.bootstrap4.js"></script>

  	<!-- Custom scripts for all pages-->
  	<script src="/common/bootstrap/js/sb-admin.min.js"></script>

  	<!-- Demo scripts for this page-->
  	<script src="/common/bootstrap/js/demo/datatables-demo.js"></script>
  	<script src="/common/bootstrap/js/demo/chart-area-demo.js"></script>
</head>
<body id="page-top">
