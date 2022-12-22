<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../../resources/css/br_writeQuestion.css">
    <script src="../../resources/script/jquery-3.6.0.js"></script>
    <script src="../../resources/script/script.js"></script>
    
    <title>질문작성</title>
</head>
<body>
    <div class="wrap">
    <%@include file="../includes/header.jsp" %>
    <%@include file="../includes/br_menu.jsp" %>

        
        <!-- 입력 영역 -->
        <div class="content">
            <h2>질문작성</h2>
        
            <form method="post">
            
                <table>
                    <tr>
                        <td>제목</td>
                        <td><input type="text" name="qtitle" class="textbox"></td>
                    </tr>
                    
                    <tr>
	                    <td>내용</td>
	                    <td><textarea name = "qcontent" rows="4" cols=""></textarea></td>
                    </tr>
                    
                    <tr>
                        <td></td>
                        <td class="btn">
                        	<input type="submit" value="돌아가기" formaction="/question/br_questionList" class="submit">
                            <input type="submit" value= "등록하기" class="submit" formaction="/question/register">
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
				
				
			}else if(result === 'error'){
				alert("모든 정보를 입력해야 합니다.");
				
			}
		}
		
		
		
	});

</script>

</body>
</html>