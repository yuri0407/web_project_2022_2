<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">    
    <link rel="stylesheet" href="../../resources/css/br_writeReview.css">
    <script src="../../resources/script/jquery-3.6.0.js"></script>
    <script src="../../resources/script/script.js"></script>
	<title>리뷰작성</title>
</head>
<body>

    <div class="wrap">
    	<%@include file="../includes/header.jsp" %>
        <%@include file="../includes/br_menu.jsp" %>
        
        
        <div class="content">
            <!-- 작성영역 -->
            
            <h2>리뷰작성</h2>
            
                <form method="post">
                
                <table>
                	<tr>
                        <td>닉네임</td>
                        <td><input type="text" name="nickName" class="bName"></td>
                    </tr>
                    <tr>
                        <td>도서명</td>
                        <td><input type="text" name="bname" class="bName"></td>
                    </tr>
                    
                    <tr>
                        <td>리뷰내용</td>
                        <td><textarea rows="5" name="content"></textarea>
                    </tr>
                    
                    <tr>
                        <td></td>
                        <td class="btn">
                            <input type="submit" value="이전으로" class="submit" formaction="/review/br_reviewList">
                            <input type="submit" value="등록하기" class="submit" formaction="/review/register">
                        </td>
                </table>
                
                </form>

            
            
        
            <br>
            <br>
        
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