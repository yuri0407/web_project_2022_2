<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" href="../../resources/css/br_memWithdrawal.css">
    <script src="../../resources/script/jquery-3.6.0.js"></script>
    <script src="../../resources/script/script.js"></script>
	<title>회원 탈퇴</title>
</head>
<body>

    <div class="wrap">
    <%@include file="../includes/header.jsp" %>
        <%@include file="../includes/br_menu.jsp" %>
        
        <!-- 탈퇴 내용 영역 -->
        
        <div class="content">	
            <h2>회원탈퇴</h2>
        
            
                    <h4>회원탈퇴 시 주의사항</h4>
                    <div>
                        -회원탈퇴를 하시면 회원의 정보들이 영구히 삭제됩니다.<br>
                        -탈퇴 후 다시 회원가입을 하기 전까지는 본 사이트의 기능 이용이 제한됩니다.<br>
                    </div>
                
                <div class="btn">
                    <button onclick="location.href='/other/br_main'">메인으로</button>
                    <button onclick="location.href='/member/remove'">탈퇴하기</button>
                </div>
            
        </div>
				
	
</body>
</html>