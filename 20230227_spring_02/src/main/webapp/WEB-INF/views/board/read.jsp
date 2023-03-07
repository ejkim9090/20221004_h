<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글</title>
	<script src="https://code.jquery.com/jquery-3.6.3.js" ></script>
</head>
<body>
	<h1>${board.boardNum } 게시글</h1>
	<div>
	<p> ${board.boardTitle }</p>
	</div>
	<div>
	${board.boardContent }
	</div>
	
	<form id="frmReply">
	<fieldset>
	 	<legend>답글작성</legend>
		<div>제목<input type="text" name="boardTitle"></div>
		<div>내용<input type="text" name="boardContent"></div>
		<input type="hidden" name="boardNum" value="${board.boardNum }">
		<button type="button" class="btn reply">답글작성</button>
		<!-- <button type="reset">초기화</button> -->
	</fieldset>
	</form>
	
<script>
	$(".btn.reply").on("click", replyClickHandler);
	
	function replyClickHandler(){
		console.log(this);  // this (DOM)
		console.log($(this));  // this를 jquery 형태로 변형
		//$(this).parents("form")
		console.log($("#frmReply").serialize());
		$.ajax({ 
			url: "<%=request.getContextPath()%>/board/insertReplyAjax"
			, type: "post"
			//contentType:
			, data: $("#frmReply").serialize()   // QueryString // js object
			, success: function(result){
				console.log(result);
				//$("#frmReply").eq(0).reset();  // 작성된 글 초기화
				frmReply.reset(); // 작성된 글 초기화
				if(result == "ok"){
					alert("댓글작성되었습니다.")
				} else {
					alert("댓글작성되지 않았습니다. 다시 작성해주세요.")
				}
			}
			, error: function(){
				
			}
		});
		
		
		
		
		
		
		
		
		
		
		
	}	
</script>
</body>
</html>