<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!-- header 영역  --> 	
	<header>
		<div class="headerBg"></div>
		
		<a href="/other/br_main"><img src="../../resources/images/로고.png" alt="사이트로고"></a>
		
<%
	String userId = (String)session.getAttribute("userId");

	if(userId != null){
		//로그인 상태일 때의 출력
%>

	<div class="head"><%=userId %>님 반갑습니다! | <a href="/member/logout">로그아웃</a></div>
		
<%
	}else{
%>		

		<div class="head"><a href="/member/br_login">로그인</a> | <a href="/member/br_signUp">회원가입</a></div>
		
<%
	}
%>