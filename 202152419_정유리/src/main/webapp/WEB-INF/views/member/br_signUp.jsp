<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">	
    <link rel="stylesheet" href="../../resources/css/br_signUp.css">
    <script src="../../resources/script/jquery-3.6.0.js"></script>
    <script src="../../resources/script/script.js"></script>
	<title>회원가입</title>
</head>
<body>
	
	<div class="wrap">
	<%@include file="../includes/header.jsp" %>
	<%@include file="../includes/br_menu.jsp" %>
	<% String id = (String)session.getAttribute("id"); %>

	
	
	
	<!-- 회원가입 영역 -->
	<div class="content">
		<h2>회원가입</h2><br>
		<form method="post">

			<table>
				
				<tr>
					<td><label>아이디</label></td>
					<td><input type="text" name="id" class="textbox" value="${id}"></td>
					<td class="btn"><input type="submit" value="중복확인" class="submit" formaction="/member/checkId"></td>
				</tr>
				
				<tr>
					<td><label>비밀번호</label></td>
					<td colspan="2"><input type="password" name="pwd" class="textbox"></td>
				</tr>
				
				<tr>
					<td><label>이메일</label></td>
					<td colspan="2"><input type="email" name="email" class="textbox"></td>
				</tr>
			
				
				
				<tr>
					<td colspan="3" class="btn">
						<input type="submit" value="메인으로" class="submit" formaction="/other/br_main">
						<input type="submit" value="회원가입" class="submit" formaction="/member/register">
					</td>
				</tr>
				
			</table>
		</form>
	
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
				
				
			}else if(result === 'idError'){
				alert("입력하신 아이디는 사용하실 수 없습니다.");
				
			}else if(result === 'idSuccess'){
				alert("해당 아이디는 사용하실 수 있습니다.");
				
			}else if(result === 'error'){
				alert("모든 정보를 입력해야 합니다.");
				
			}
		}
		
		
		
	});

</script>

	
</body>
</html>