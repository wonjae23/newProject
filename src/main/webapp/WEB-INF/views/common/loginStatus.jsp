<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>



<c:choose>
	<c:when test="${sessionScope.userId == null }">
		<a href="${path}/main/login">로그인id</a>
	</c:when>
	<c:otherwise>
		${sessionScope.userName}님이 로그인중입니다.
		<a href="${path}/main/logout">로그아웃</a>
	</c:otherwise>
</c:choose>