<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="true" %>
<html>
    <head>
        <title>게시판</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        
        <script type="text/javascript">
            $(document).ready(function(){
                 
                //--페이지 셋팅
                var totalPage = ${totalPage}; //전체 페이지
                var startPage = ${startPage}; //현재 페이지
                 
                var pagination = "";
                 
                //--페이지네이션에 항상 10개가 보이도록 조절
                var forStart = 0;
                var forEnd = 0;
                 
                if((startPage-5) < 1){
                    forStart = 1;
                }else{
                    forStart = startPage-5;
                }
                 
                if(forStart == 1){
                     
                    if(totalPage>9){
                        forEnd = 10;
                    }else{
                        forEnd = totalPage;
                    }
                     
                }else{
                     
                    if((startPage+4) > totalPage){
                         
                        forEnd = totalPage;
                         
                        if(forEnd>9){
                            forStart = forEnd-9
                        }
                         
                    }else{
                        forEnd = startPage+4;
                    }
                }
                //--페이지네이션에 항상 10개가 보이도록 조절
                 
                //전체 페이지 수를 받아 돌린다.
                for(var i = forStart ; i<= forEnd ; i++){
                    if(startPage == i){
                        pagination += ' <button name="page_move" start_page="'+i+'" disabled>'+i+'</button>';
                    }else{
                        pagination += ' <button name="page_move" start_page="'+i+'" style="cursor:pointer;" >'+i+'</button>';
                    }
                }
                 
                //하단 페이지 부분에 붙인다.
                $("#pagination").append(pagination);
                //--페이지 셋팅
                 
                 
                $("a[name='subject']").click(function(){
                     
                    location.href = "/board/view?id="+$(this).attr("content_id");
                     
                });
                 
                $("#write").click(function(){
                	  location.href = "/board/edit";
                });
                                 
                $(document).on("click","button[name='page_move']",function(){
                     
                    var visiblePages = 10;//리스트 보여줄 페이지
                     
                    $('#startPage').val($(this).attr("start_page"));//보고 싶은 페이지
                    $('#visiblePages').val(visiblePages);
                     
                    $("#frmSearch").submit();
                     
                });
                 
            });
        </script>
        <style>
            .mouseOverHighlight {
                   cursor: pointer !important;
                   pointer-events: auto;
                   text-decoration:none;
                }
            .bs-example{
		    	margin: 130px;
		    }
        </style>
    </head>
    <body>
        <form class="form-inline" id="frmSearch" action="/board/list">
            <input type="hidden" id="startPage" name="startPage" value=""><!-- 페이징을 위한 hidden타입 추가 -->
            <input type="hidden" id="visiblePages" name="visiblePages" value=""><!-- 페이징을 위한 hidden타입 추가 -->
            
            <div align="center" class="bs-example">
            	<c:choose>
					<c:when test="${sessionScope.userId == null }">
						<a href="${path}/main/login">로그인 이동</a>
					</c:when>
					<c:otherwise>
						${sessionScope.userName}님 환영합니다.
						<a href="${path}/main/logout">로그아웃</a>
					</c:otherwise>
				</c:choose>
                <table width="1200px" >
                    <tr>
                        <td align="right">
                        	<button type="button" class="btn btn-secondary btn-sm" id="write" name="write">게시글 작성</button>
                        </td>
                    </tr>
                </table>
                <table  width="1200px" class="table">
                    <tr>
                        <th width="50px">
                            No
                        </th>
                        <th width="850px">
                           	 제목
                        </th>
                        <th width="100px">
                           	 작성자
                        </th>
                        <th width="200px">
                           	 작성일
                        </th>
                    </tr>
                    <c:choose>
                        <c:when test="${fn:length(boardList) == 0}">
                            <tr>
                                <td colspan="4" align="center">
                                    	조회결과가 없습니다.
                                </td>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <c:forEach var="boardList" items="${boardList}" varStatus="status">
                                <tr>
                                    <td align="center">${boardList.id}</td>
                                    <td>
                                        <a name="subject" class="mouseOverHighlight"  content_id="${boardList.id}">${boardList.subject}</a>
                                    </td>
                                    <td align="center">${boardList.writer}</td>
                                    <td align="center">${boardList.register_datetime}</td>
                                </tr>
                            </c:forEach>
                        </c:otherwise> 
                    </c:choose>
                </table>
                <br>
                <div id="pagination"></div>
            </div>
        </form>
    </body>
</html>