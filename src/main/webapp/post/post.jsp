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

<style>
	td{
		padding-right : 10px;
		padding-bottom: 20px;
	}
	#button{
		float: right;
	}
	.btn {
		margin-left : 10px;
	}
</style>

<script>
	$(document).ready(function () {

		$("#deleteBtn").on('click', function () {
			$('#deleteForm').submit();
		})

		$("#replyPostBtn").on('click', function () {
			$('#replyPostForm').submit();
		})

		$("#modifyBtn").on('click', function () {
			$('#updatePostForm').submit();
		})

		$(".replySpan").on('click', function () {

			var dataValue = $(this).data('replyno');

			$('#replyNo').val(dataValue)

			$('#deleteReplyForm').submit();
		})
	})


</script>

</head>

<body>
	<!-- 게시글 삭제 form -->
	<form id="deleteForm" action="${cp }/deletePost" method="get">
		<input type="hidden" id="deletePostNo" name="deletePostNo" value="${post.postno }"/>
		<input type="hidden" id="boardNo" name="boardNo" value="${post.boardno }"/>
	</form>

	<!-- 게시글 답글 form -->
	<form id="replyPostForm" action="${cp }/replyPost" method="get">
		<input type="hidden" id="postNo" name="postNo" value="${post.postno }"/>
		<input type="hidden" id="boardNo" name="boardNo" value="${post.boardno }"/>
		<input type="hidden" id="postGn" name="postGn" value="${post.postgn }"/>
	</form>

	<!-- 게시글 수정 form -->
	<form id="updatePostForm" action="${cp }/updatePost" method="get">
		<input type="hidden" id="postNo" name="postNo" value="${post.postno }"/>
	</form>

	<!-- 답글 삭제 -->
	<form id="deleteReplyForm" action="${cp }/deleteReply" method="get">
		<input type="hidden" id="postNo" name="postNo" value="${post.postno }"/>
		<input type="hidden" id="replyNo" name="replyNo"/>
	</form>
	<!-- header -->
	<%@ include file="/commonJsp/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<!-- left -->
				<%@ include file="/commonJsp/left.jsp" %>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<h1>게시글 상세 정보</h1>

				<br><br>

				<form action="${cp }/insertReply" method="post" id="frm">
					<table>
						<tr>
							<td>제목</td>
							<td><div style="width:760px; height:35px; border: 1px solid; padding-top: 5px">${post.posttitle }</div></td>
						</tr>
						<tr>
							<td>글내용</td>
							<td><div style="width:760px; height:412px; border: 1px solid">${post.postcontent }</div></td>
						</tr>
						<tr>
							<td>첨부파일</td>
							<td></td>
						</tr>
						<c:forEach items="${fileList}" var="postFile">
							<tr>
								<td></td>
								<td>${postFile.filename}</td>
							</tr>
						</c:forEach>
						<tr>
							<td></td>
							<td id="button">
								<c:choose>
									<c:when test="${post.userid == S_USERVO.userId }">
										<input type="button" id="replyPostBtn" class="btn btn-default pull-right" value="답글" />
										<input type="button" id="modifyBtn" class="btn btn-default pull-right" value="수정" />
										<input type="button" id="deleteBtn" class="btn btn-default pull-right" value="삭제" />
									</c:when>
									<c:otherwise>
										<input type="button" id="replyPostBtn" class="btn btn-default pull-right" value="답글" />
									</c:otherwise>
								</c:choose>

							</td>
						</tr>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td>댓글</td>
							<td>
								<div class="col-sm-8">
									<input type="text" id="postReply" class="form-control" name="postReply" maxlength="500"/>
									<input type="hidden" id="postNo" name="postNo" value="${post.postno }"/>
								</div>
								<div class="col-sm-2">
									<input type="submit" id="reply" class="btn btn-default pull-right" value="댓글등록" >
								</div>
							</td>
						</tr>
						<c:forEach items="${replyList}" var="reply">
							<tr>
								<td></td>
								<td>
									<div class="col-sm-8">
									<c:choose>
										<c:when test="${reply.deleteyn == 1 }">
											<label>※삭제된 댓글입니다.</label>
										</c:when>
										<c:otherwise>
											<label>${reply.replycontent}</label>
										</c:otherwise>
									</c:choose>
									</div>
									<div class="col-sm-4">
										<c:choose>
											<c:when test="${reply.userid == S_USERVO.userId }">
												<label>&nbsp;&nbsp;&nbsp;&nbsp;[${reply.userid} / ${reply.replywdateFmt}]&nbsp;&nbsp;<span class="replySpan glyphicon glyphicon-remove" data-replyNo="${reply.replytno}" ></span></label>
											</c:when>
											<c:otherwise>
												<label>&nbsp;&nbsp;&nbsp;&nbsp;[${reply.userid} / ${reply.replywdateFmt}]</label>
											</c:otherwise>
										</c:choose>
									</div>
								</td>
							</tr>
						</c:forEach>
					</table>
				</form>

			</div>
		</div>
	</div>
</body>
</html>