<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">	
    <link rel="stylesheet" href="../../resources/css/br_noticeDetail.css">
    <script src="../../resources/script/jquery-3.6.0.js"></script>
    <script src="../../resources/script/script.js"></script>
	<title>도서리뷰</title>
</head>
<body>
	<div class="wrap">
	
	<%@include file="../includes/header.jsp" %>
	<%@include file="../includes/br_menu.jsp" %>



        <!-- 리뷰상세 영역 -->
        <div class="content">
            <div class="btn">
                <button onclick="location.href='/review/br_reviewList'">목록으로</button>
            </div>

            
            <div class="detail">
                <h2><c:out value="${detail.bname }"/></h2>
                <div class="date">닉네임 : <c:out value="${detail.nickName}"/></div>
                <hr>

                <div class="contentbox"><c:out value="${detail.content }"/></div>

            </div>
			
		
        
	
        </div>




	</div>
	
</body>
</html>