<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 


<html>
<head>
<meta charset="UTF-8">
<meta charset="UTF-8">	
<link rel="stylesheet" href="../../resources/css/br_requestList.css">
<script src="../../resources/script/jquery-3.6.0.js"></script>
<script src="../../resources/script/script.js"></script>
<title>Q&A</title>
</head>
<body>
    <div class="wrap">
    
    <%@include file="../includes/header.jsp" %>
    <%@include file="../includes/br_menu.jsp" %>



	<!-- 질문목록 영역 -->
    <div class="content">
	
		<h2>Q&A</h2>

        <div class="btn">		
			<button onclick="location.href='/question/br_writeQuestion'">질문하기</button>
		</div>
	
	
		
        <div class="tablearea">
            <table>
                <tr>
                    <th style="width: 5%">No.</th>
                    <th style="width:60%">제목</th>
                    <th>날짜</th>
                </tr>
                <c:forEach var="list" items="${question}">
                <tr class="row" onclick="location.href='br_questionDetail.do?qNo=${list.qno}'">
                    <td style="text-align:center;">${list.qno}</td>
                    <td>${list.qtitle}</td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd" value="${list.qdate}"/></td>
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
	
	<form id="pageForm" action="/question/br_questionList"  method="get">
		<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
		<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
	</form>
	
	
	
<script type="text/javascript">
	$(document).ready(function(){
		var result = '<c:out value="${result}"/>';
		
		checkModal(result);
		
		history.replaceState({}, null, null); //브라우저 주소창에 보관하고 있는 정보 지우기
		
		function checkModal(result){
			
			if(result ===''|| history.state){ //브라우저 기록 스택의 맨위에 있는 상태값 가져오기. 상태값이 있으면 return
				return;
				
			}else if(result ==='registered'){
				alert("질문이 등록되었습니다.");
				
			}
		}
			
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