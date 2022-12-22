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
	<title>Q&A</title>
</head>
<body>
	<div class="wrap">
	
	<%@include file="../includes/header.jsp" %>
	<%@include file="../includes/br_menu.jsp" %>



        <!-- 질문상세 영역 -->
        <div class="content">
            <div class="btn">
                <button onclick="location.href='/question/br_questionList'">목록으로</button>
            </div>

            
            <div class="detail">
                <h2><c:out value="${detail.qtitle}"/></h2>
                <div class="date">등록일 :<fmt:formatDate pattern="yyyy-MM-dd" value="${detail.qdate}"/></div>
                <hr>

                <div class="contentbox"><c:out value="${detail.qcontent}"/></div>

                <hr>
                <div class="label">관리자답변</div>
                <div class="answerbox"><c:out value="${detail.manswer}"/></div>
            </div>
			
		
        
	
        </div>




	</div>
	
</body>
</html>