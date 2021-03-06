<%@page import="kr.or.ddit.user.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp-basicLib</title>

<%@ include file="/commonJsp/basicLib.jsp"%>

<script src="/SE2/js/HuskyEZCreator.js"></script>
<script type="text/javascript">
	var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

	$(document).ready(function() {
		// Editor Setting
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors, // 전역변수 명과 동일해야 함.
			elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
			sSkinURI : "/SE2/SmartEditor2Skin.html", // Editor HTML
			fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
			htParams : {
				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseToolbar : true,
				// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseVerticalResizer : true,
				// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
				bUseModeChanger : true,
			}
		});

		// 전송버튼 클릭이벤트
		$("#savebutton").click(function(){
			if(confirm("저장하시겠습니까?")) {
				// id가 smarteditor인 textarea에 에디터에서 대입
				oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);

				// 이부분에 에디터 validation 검증
				if(validation()) {
					$("#frm").submit();
				}
			}
		})
	});

	// 필수값 Check
	function validation(){
		var contents = $.trim(oEditors[0].getContents());
		if(contents === '<p>&nbsp;</p>' || contents === ''){ // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음.
			alert("내용을 입력하세요.");
			oEditors.getById['smarteditor'].exec('FOCUS');
			return false;
		}

		return true;
	}
</script>

<style>
	td{
		padding-right : 10px;
		padding-bottom: 20px;
	}
	#button{
		float: right;
	}
</style>
</head>

<body>

	<!-- header -->
	<%@ include file="/commonJsp/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<!-- left -->
				<%@ include file="/commonJsp/left.jsp" %>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<c:choose>
					<c:when test="${postNo == null }">
						<h1>새글 작성</h1>
					</c:when>
					<c:otherwise>
						<h1>답글 작성</h1>
					</c:otherwise>
				</c:choose>

				<br><br>

				<form action="${cp }/insertPost" method="post" id="frm" enctype="multipart/form-data">
					<input type="hidden" id="boardNo" name="boardNo" value="${boardno }"/>
					<input type="hidden" id="parentpostno" name="parentpostno" value="${postNo }"/>
					<input type="hidden" id="postGn" name="postGn" value="${postGn }"/>
					<table>
						<tr>
							<td>제목</td>
							<td><input type="text" id="postTitle" name="postTitle" style="width:750px; height:35px;"/></td>
						</tr>
						<tr>
							<td>글내용</td>
							<td><textarea name="postContent" id="smarteditor" rows="10" cols="100" style="width:750px; height:412px;"></textarea></td>
						</tr>
						<tr>
							<td>첨부파일</td>
							<td><input type="file" multiple="multiple" id="file" name="file"/></td>
						</tr>
						<tr>
							<td></td>
							<td id="button"><input type="button" id="savebutton" class="btn btn-default pull-right" value="저장" /></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>