<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/jstl_taglib.jsp"%>
<%@ include file="/WEB-INF/views/common/bootstrap.jsp"%>
<%@ page session="false" %>

<html>
    <head>
        <title>게시판</title>
        <script type="text/javascript">
            $(document).ready(function(){
                
            	//에디터 초기 설정
                CKEDITOR.replace( 'content' );
                CKEDITOR.config.height = 200;
                 
                //게시글 목록으로 이동
                $("#list").click(function(){
                    location.href = "/board/list";
                });
                 
              	//게시글 등록 버튼 클릭 시
                $("#save").click(function(){
                     
                    //에디터 내용 가져옴
                    var content = CKEDITOR.instances.content.getData();
                     
                    //유효성 검사
                    if($("#subject").val().trim() == ""){
                        alert("제목을 입력하세요.");
                        $("#subject").focus();
                        return false;
                    }
                     
                    if($("#writer").val().trim() == ""){
                        alert("작성자를 입력하세요.");
                        $("#writer").focus();
                        return false;
                    }
                     
                    if($("#password").val().trim() == ""){
                        alert("비밀번호를 입력하세요.");
                        $("#password").focus();
                        return false;
                    }
                     
                    //값 셋팅
                    var objParams = {
                            <c:if test="${boardView.id != null}"> //있으면 수정 없으면 등록
                            id          : $("#board_id").val(),
                            </c:if>
                            subject     : $("#subject").val(),
                            writer      : $("#writer").val(),
                            password    : $("#password").val(),
                            content     : content
                    };
                     
                    //ajax 호출
                    $.ajax({
                        url         :   "/board/save",
                        dataType    :   "json",
                        contentType :   "application/x-www-form-urlencoded; charset=UTF-8",
                        type        :   "post",
                        data        :   objParams,
                        success     :   function(retVal){
                        	
                            if(retVal.code == "OK") {
                                alert(retVal.message);
                                location.href = "/board/list";  
                            } else {
                                alert(retVal.message);
                            }
                             
                        },
                        error       :   function(request, status, error){
                            console.log("AJAX_ERROR");
                        }
                    });
                     
                     
                });
                 
            });
        </script>
        
    </head>
    <body>
        <input type="hidden" id="board_id" name="board_id" value="${boardView.id}" />
        <div class="container">
            </br>
            </br>
            <div class="form-group">
            	<label for="title" class="col-sm-2 control-label">제목</label>
            	<div class="col-sm-10">
            		<input type="text" id="subject" name="subject" class="form-control" placeholder="제목" value="${boardView.subject}"/>
            	</div>
            </div>
            
            <div class="form-group">
            	<label for="title" class="col-sm-2 control-label">작성자</label>
            	<div class="col-sm-10">
            		<input type="text" id="writer" name="writer"  class="form-control" maxlength="10" placeholder="작성자" value="${boardView.writer}"/>
            	</div>
            </div>
            
            <div class="form-group">
            	<label for="title" class="col-sm-2 control-label">비밀번호</label>
            	<div class="col-sm-10">
            		<input type="password" id="password" name="password" class="form-control"  placeholder="패스워드"/>
            	</div>
            </div>
            
            <div class="form-group">
            	<label for="title" class="col-sm-2 control-label">내용</label>
            	<div class="col-sm-10">
            		<textarea name="content" id="content" class="form-control" rows="10" cols="40">${boardView.content}</textarea>
            	</div>
            </div>
            
            <div class="form-group">
            	<button id="save" name="save" class="btn btn-primary">저장</button>
            	<button id="list" name="list" class="btn btn-success">목록</button>
            </div>
            
        </div>
    </body>
</html>