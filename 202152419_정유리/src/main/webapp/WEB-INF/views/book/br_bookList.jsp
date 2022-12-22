<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">	
    <link rel="stylesheet" href="../../resources/css/br_bookList.css">
    <script src="../../resources/script/jquery-3.6.0.js"></script>
    <script src="../../resources/script/script.js"></script>
	<title>도서목록</title>
</head>
<body>
	<div class="wrap">

	<%@include file="../includes/header.jsp" %>
    <%@include file="../includes/br_menu.jsp" %>

	
	
	
	<!-- 리뷰영역  -->
	
	<div class="content">
	
		<h2>도서목록</h2>
	
	

		
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
                <c:forEach var="list" items="${book}">
                <tr class="row" onclick="location.href='/book/br_bookExplanation?bno=${list.bno}'">
                    <td style="display:none">${list.bno }</td>
                    <td class="imgAlign"><img class="bImage" src="../resources/uploadfiles/${list.bimage}"></td>
                    <td>${list.bname }</td>
                    <td>${list.writer }</td>
                    <td>${list.publisher }</td>
                    <td>${list.pdate }</td>
                    <td>${list.category }</td>
                </tr>
                </c:forEach>
            </table>
        </div>
	
	</div>
	
	</div>
	
	<!-- 페이지네이션 -->
	<div class="pull-right">
	  <ul class="pagination">
	   	<c:if test="${pageMaker.prev}">
	    	<li class="page-item">
	    		<a class="page-link" href="${pageMaker.startPage-1 }">Previous</a>
	    	</li>
	    </c:if>
	    
	    <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
	    	<li class="page-item${pageMaker.cri.pageNum == num ? '_active':''}">
	    		<a class="page-link" href="${num}">${num}</a>
	    	</li>
	    </c:forEach>	
	    
	    <c:if test="${pageMaker.next}">
	    	<li class="page-item">
	    		<a class="page-link" href="${pageMaker.endPage+1 }">Next</a>
	    	</li>
	    </c:if>
	  </ul>
	</div><!-- end of pagination -->
	
	<form id="pageForm" action="/book/br_bookList"  method="get">
		<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
		<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
	</form>
	
	
	
<script type="text/javascript">
	$(document).ready(function(){
			
		//page 클릭 이벤트로 이동
		var pageForm = $("#pageForm");
		
		$(".page-link").on("click", function(e){
			
			e.preventDefault(); //기본 동작 막기 : a태그의 기본동작은 이동 -> 이동을 막음
			
			var targetPage = $(this).attr("href");
			
			console.log(targetPage);
			
			pageForm.find("input[name='pageNum']").val(targetPage);
			pageForm.submit();
			
		});
	});
	
</script>
	
	
</body>
</html>