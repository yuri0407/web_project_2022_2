<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">	
    <link rel="stylesheet" href="../../resources/css/br_login.css">
    <script src="../../resources/script/jquery-3.6.0.js"></script>
    <script src="../../resources/script/script.js"></script>
	<title>로그인</title>
</head>
<body>
	
	<div class="wrap">
	<%@include file="../includes/header.jsp" %>
	<%@include file="../includes/br_menu.jsp" %>

	
	
	<!-- 로그인 영역 -->
	<div class="content">
	
		<h2>로그인</h2>
		<div class="tablearea">
			<form method="post">
			<table>
				<tr>
					<td><label>아이디</label></td>
					<td><input type="text" name="id" class="textbox"></td>
				</tr>
				
				<tr>
					<td><label>비밀번호</label></td>
					<td><input type="password" name="pwd" class="textbox"></td>
				</tr>
			</table>
		

			<div class="btn">
				<input type="submit" value="로그인" class="submit" formaction="/member/login">
				<input type="submit" value="회원가입" class="submit" formaction="/member/br_signUp">
			</div>
			
			</form>
			

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
				
				
			}else if(result === 'failed'){
				alert("로그인 후 이용가능합니다.");
				
			}else if(result === 'notUser'){
				alert("아이디 또는 비밀번호가 맞지 않습니다.");
			}
		}
		
		
		
	});

</script>
	
</body>
</html>