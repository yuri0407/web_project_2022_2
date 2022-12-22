<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">	
    <link rel="stylesheet" href="../../resources/css/br_noticeDetail.css">
    <script src="../../resources/script/jquery-3.6.0.js"></script>
    <script src="../../resources/script/script.js"></script>
	<title>도서추가요청</title>
</head>
<body>
	<div class="wrap">
	<%@include file="../includes/header.jsp" %>
	<%@include file="../includes/br_menu.jsp" %>



        <!-- 요청상세 영역 -->
        <div class="content">
        	
        	<h2>도서추가요청</h2>
        
            <div class="btn">
                <button onclick="location.href='/request/br_requestList'">목록으로</button>
            </div>

            	
            <div class="detail">
            	<div class="date">닉네임 : ${detail.rname}</div>
                <div class="date">등록일 : <fmt:formatDate pattern="yyyy-MM-dd" value="${detail.rdate}"/></div>
                <hr>

                <div class="contentbox">${detail.rcontent }</div>
            </div>
			
		
        
	
        </div>




	</div>
	
</body>
</html>