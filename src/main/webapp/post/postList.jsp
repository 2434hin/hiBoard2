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

<script>
	// 문서 로딩이 완료되고 나서
	$(document).ready(function () {

		$(".postTr").on('click', function () {

			var deletePost = $(this).children('.noclick').text();

			if(deletePost == "※삭제된 게시글입니다."){
				return;
			}

			var dataValue = $(this).data("postno");

			$('#postNo').val(dataValue)

			$('#frm').submit();
		})

	})
</script>

</head>

<body>

	<form id="frm" action="${cp }/post" method="get">
		<input type="hidden" id="postNo" name="postNo"/>
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


				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">${board.boardname}</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>게시글 번호</th>
									<th>제목</th>
									<th>작성자 아이디</th>
									<th>작성 일시</th>
								</tr>

								<c:forEach items="${postList}" var="post">
									<tr class="postTr" data-postNo="${post.postno}">
										<td>${post.postno}<input type="hidden" value="${post.postno}"/></td>
										<c:choose>
											<c:when test="${post.deleteyn == 1 }">
												<td class="noclick">
												<c:forEach begin="0" end="${post.level }">
													&nbsp;
												</c:forEach>
												<span class="glyphicon glyphicon-hand-right"></span>※삭제된 게시글입니다.</td>
											</c:when>
											<c:otherwise>
												<td class="noclick">
												<c:forEach begin="0" end="${(post.level-1)*2 }">
													&nbsp;
												</c:forEach>
												<span class="glyphicon glyphicon-hand-right"></span>${post.posttitle}</td>
											</c:otherwise>
										</c:choose>
										<td>${post.userid}</td>
										<td>${post.postwdateFmt}</td>
									</tr>
								</c:forEach>

							</table>
						</div>

						<a href="${pageContext.request.contextPath }/postForm?boardno=${board.boardno}" class="btn btn-default pull-right">새글 등록</a>

						<div class="text-center">
							<ul class="pagination">

								<%-- 이전 페이지 가기 : 지금 있는 페이지에서 한페이지 전으로
									  단 1페이지인 경우는 li 태그에 class="disabled"를 추가하고 이동 경로는 차단
								 --%>
								<c:choose>
									<c:when test="${page == 1 }">
										<li class="disabled">
									      <a href="#" aria-label="Previous">
									        <span aria-hidden="true">&laquo;</span>
									      </a>
									    </li>
									</c:when>
									<c:otherwise>
										<li>
									      <a href="${cp }/userPagingList?page=${page-1 }" aria-label="Previous">
									        <span aria-hidden="true">&laquo;</span>
									      </a>
									    </li>
									</c:otherwise>
								</c:choose>

								<c:forEach begin="1" end="${paginationSize}" var="pageSize">
									<%-- 방법1 --%>
									<c:choose>
										<c:when test="${pageSize == page}">
											<li	class="active"><span>${pageSize }</span></li>
										</c:when>
										<c:otherwise>
											<li><a href="${cp }/userPagingList?page=${pageSize }">${pageSize }</a></li>
										</c:otherwise>
									</c:choose>

								</c:forEach>

								<c:choose>
									<c:when test="${page == paginationSize }">
									    <li class="disabled">
									      <a href="#" aria-label="Next">
									        <span aria-hidden="true">&raquo;</span>
									      </a>
									    </li>
									</c:when>
									<c:otherwise>
										<li>
									      <a href="${cp }/userPagingList?page=${page+1 }" aria-label="Next">
									        <span aria-hidden="true">&raquo;</span>
									      </a>
									    </li>
									</c:otherwise>
								</c:choose>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>