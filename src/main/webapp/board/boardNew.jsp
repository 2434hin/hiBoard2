<%@page import="kr.or.ddit.user.model.User"%>
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

<title>Jsp</title>

<%@ include file="/commonJsp/basicLib.jsp" %>

<style>
	tr{
		height: 50px;
	}

	td{
		padding-right: 20px;
	}

	select {
		height: 27px;
	}
}
</style>

<script>
 	$(document).ready(function () {

 		// 생성 버튼 클릭 시
 		$('#newBoard').on('click', function () {

 			if(!($('#newBoardNm').val().trim().length == 0)){
 				// input 태그에 값 설정
 				// 게시판 이름
 				$('#newBoardName').val($('#newBoardNm').val());

 				// 게시판 사용여부
 				$('#newUseYN').val($("#newBoardYN option:selected").val());

 				$('#newForm').submit();
 			}else {
 				alert("게시판 이름을 입력하세요.");
 				$('#newBoardNm').focus();
 			}
 		});

 		// 수정버튼 클릭 시
		$('.boardModify').on('click', function () {
			$('#boardNo').val($(this).data("boardid"));
			$('#boardNm').val($(this).parent().siblings().children('.boardName').val());
			$('#useYN').val($(this).parent().siblings().children('.boardYN').val());

			$('#modifyForm').submit();
		})
 	})
</script>
</head>
<body>
	<!-- 생성 form -->
	<form id="newForm" action="${cp }/boardNew" method="post">
		<input type="hidden" id="newBoardName" name="newBoardName"/>
		<input type="hidden" id="newUseYN" name="newUseYN"/>
	</form>

	<!-- 수정 form -->
	<form id="modifyForm" action="${cp }/boardModify" method="post">
		<input type="hidden" id="boardNo" name="boardNo"/>
		<input type="hidden" id="boardNm" name="boardNm"/>
		<input type="hidden" id="useYN" name="useYN"/>
	</form>

	<!-- header -->
	<%@ include file="/commonJsp/header.jsp" %>

	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<!-- left -->
				<%@ include file="/commonJsp/left.jsp" %>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<table>
					<tr>
						<td>게시판 이름</td>
						<td><input type="text" id="newBoardNm" name="newBoardNm"/></td>
						<td>
							<select id="newBoardYN">
								<option value="0">사용</option>
								<option value="1">미사용</option>
							</select>
						</td>
						<td><input type="button" id="newBoard" class="btn btn-default pull-right" value="생성"/></td>
					</tr>
					<c:forEach items="${boardList}" var="board">
						<tr class="boardTr">
							<td>게시판 이름</td>
							<td><input type="text" class="boardName" value="${board.boardname}"/></td>
							<td>
								<select class="boardYN">
									<c:choose>
										<c:when test="${board.useyn == 0}">
											<option value="0" selected>사용</option>
											<option value="1">미사용</option>
										</c:when>
										<c:otherwise>
											<option value="0">사용</option>
											<option value="1" selected>미사용</option>
										</c:otherwise>
									</c:choose>
								</select>
							</td>
							<td><input type="button" class="btn btn-default pull-right boardModify" data-boardId="${board.boardno}" value="수정"/></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>