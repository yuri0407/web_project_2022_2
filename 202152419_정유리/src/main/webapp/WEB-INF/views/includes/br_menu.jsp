<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
		
		
	<!-- 메인메뉴영역  -->
	 <nav>			
            
		<ul>
			<li class="lv1">
				<a href="#">도서</a>
				<ul class="lv2">
					<li><a href="/book/br_bookList">도서목록</a></li>
					<li><a href="/review/br_reviewList">도서리뷰</a></li>
				</ul>
			</li>
			<li class="lv1">
				<a href="#">고객센터</a>
				<ul class="lv2">
					<li><a href="/question/br_questionList">Q&A</a></li>
					<li><a href="/request/br_requestList">도서추가요청</a></li>
				</ul>
			</li>
			<li class="lv1">
				<a href="#">마이페이지</a>
				<ul class="lv2">
					<li><a href="/member/br_memWithdrawal">회원탈퇴</a></li>
				</ul>
			</li>
			
		</ul>
		
	</nav>

</header>
	
	<!-- 서브메뉴영역  -->

	<div class="subMenu">			
		
			
		<ul class="subLv1">
			<li>도서</li>
			<ul class="subLv2">
				<li><a href="/book/br_bookList">도서목록</a></li>
				<li><a href="/review/br_reviewList">도서리뷰</a></li>
			</ul>
		</ul>
		
		<ul class="subLv1">
			<li>고객센터</li>
			<ul class="subLv2">
				<li><a href="/question/br_questionList">Q&A</a></li>
				<li><a href="/request/br_requestList">도서추가요청</a></li>
			</ul>
		</ul>
		
		<ul class="subLv1">
			<li>마이페이지</li>
			<ul class="subLv2">
				<li><a href="/member/br_memWithdrawal">회원탈퇴</a></li>
			</ul>
		</ul>
		
		
	</div>
</body>
</html>