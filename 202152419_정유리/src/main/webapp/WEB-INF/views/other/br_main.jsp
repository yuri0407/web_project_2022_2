<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">	
    <link rel="stylesheet" href="../../resources/css/br_main.css">
    <script src="../../resources/script/jquery-3.6.0.js"></script>
    <script src="../../resources/script/script.js"></script>
    <title>도서리뷰사이트입니다.</title>
</head>
<body>

	
    <div class="wrap">
		<%@include file="../includes/header.jsp" %>
		
			
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
			
	

		<div class="main">
			<h1>도서리뷰사이트에 오신 것을 환영합니다!</h1>
		</div>
	
	<!-- content 영역 -->
	<div class="content">
		<!-- 도서목록 영역 -->
		<div class="list">
			<h2>도서목록</h2>
			<button onclick="location.href='/book/br_bookList'">more></button>

			<div class="tablearea">
				<table>
					<tr>
	                    <th style="display:none">bNo.</th>
	                    <th>image</th>
	                    <th style="width: 30%">도서명</th>
	                    <th style="width: 15%">저자명</th>
	                    <th style="width: 15%">출판사</th>
	                    <th style="width: 13%">출판일</th>
	                    <th style="width: 10%">분류번호</th>
                	</tr>
                	
					<c:forEach var="list" items="${mainBook}">
	                	<tr class="row" onclick="location.href='/book/br_bookExplanation?bno=${list.bno}'">
		                    <td style="display:none">${list.bno}</td>
		                    <td class="imgAlign"><img class="bImage" src="../resources/uploadfiles/${list.bimage}"></td>
		                    <td>${list.bname}</td>
		                    <td>${list.writer}</td>
		                    <td>${list.publisher}</td>
		                    <td>${list.pdate}</td>
		                    <td>${list.category}</td>
		                </tr>
	                </c:forEach>
				</table>
			</div>
		
		</div>
	</div>

		
		
		
     
  </div>
  
<script type="text/javascript">
	$(document).ready(function(){
		var result = '<c:out value="${result}"/>';
		
		checkModal(result);
		
		history.replaceState({}, null, null);
		
		function checkModal(result){
			if(result === '' || history.state){
				return;
				
				
			}else if(result === 'registered'){
				alert("회원이 되신 것을 환영합니다!");
				
			}else if(result === 'notUser'){
				alert("아이디 또는 비밀번호가 맞지 않습니다.");
				
			}else if(result == 'removed'){
				alert("회원탈퇴가 완료되었습니다.");
				
			}else if(result == 'logout'){
				alert("로그아웃 되었습니다.");
				
			}
		}
		
		
		
	});

</script>   
   
</body>
</html>