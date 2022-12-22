<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<html>
<head>
	<meta charset="UTF-8">	
    <link rel="stylesheet" href="../../resources/css/br_bookExplanation.css">
    <script src="../../resources/script/jquery-3.6.0.js"></script>
    <script src="../../resources/script/script.js"></script>
	<title>도서설명</title>
</head>
<body>
	
	<div class="wrap">
	
	 <%@include file="../includes/header.jsp" %>
	 <%@include file="../includes/br_menu.jsp" %>
	 

	


	
	<!-- 로그인 영역 -->
	<div class="content">
	
		<div class="btn">
                <button onclick="location.href='/book/br_bookList'">목록으로</button>
        </div>	
        
		<h2>도서소개</h2>
		
		<table>
			<tr>
				<td rowspan=5><img src="../resources/uploadfiles/<c:out value="${book.bimage}"/>"></td>
				<td class="td">도서명</td>
				<td><span><c:out value="${book.bname}"/></span></td>
			</tr>
			
			<tr>
				<td class="td">저자</td>
				<td><span><c:out value="${book.writer}"/></span></td>
			</tr>
			
			<tr>
				<td class="td">출판사</td>
				<td><span><c:out value="${book.publisher}"/></span></td>
			</tr>

			<tr>
				<td class="td">출판일</td>
				<td><span><c:out value="${book.pdate}"/></span></td>
			</tr>
			
			<tr>
				<td class="td">분류번호</td>
				<td><span><c:out value="${book.category}"/></span></td>
			</tr>
			
      </table>
		<div class="explanation">
			<c:out value="${book.bcontent}"/>

		</div>
	</div>
	</div>
	
</body>
</html>