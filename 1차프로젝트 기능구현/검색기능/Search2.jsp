<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 대분류  -->
	<div id="sort">
		<button type="submit" name="sort" value="1"
			onclick="ButtonValue(event)">소주</button>
		<button type="submit" name="sort" value="2"
			onclick="ButtonValue(event)">맥주</button>
		<button type="submit" name="sort" value="3"
			onclick="ButtonValue(event)">데킬라</button>
		<button type="submit" name="sort" value="4"
			onclick="ButtonValue(event)">럼</button>
		<button type="submit" name="sort" value="5"
			onclick="ButtonValue(event)">브랜디</button>
		<button type="submit" name="sort" value="6"
			onclick="ButtonValue(event)">위스키</button>
		<button type="submit" name="sort" value="7"
			onclick="ButtonValue(event)">진</button>
		<button type="submit" name="sort" value="8"
			onclick="ButtonValue(event)">리큐르</button>
		<button type="submit" name="sort" value="9"
			onclick="ButtonValue(event)">보드카</button>
		<button type="submit" name="sort" value="10"
			onclick="ButtonValue(event)">와인</button>
	</div>
	<!-- 술에대한 설명과 이미지를 담기 위한 표  -->
	<table border="1" id="des"></table>

	<br>
	<br>
	<!-- 맛  -->

	<table border="1">
		<tr>
		<td>맛</td>
			<td>
				<button type="submit" name="taste" value="a"
					onclick="TasteValue(event)">'ㄱ'</button>
				<button type="submit" name="taste" value="b"
					onclick="TasteValue(event)">'ㄴ'</button>
				<button type="submit" name="taste" value="c"
					onclick="TasteValue(event)">'ㄷ'</button>
				<button type="submit" name="taste" value="d"
					onclick="TasteValue(event)">'ㄹ'</button>
				<button type="submit" name="taste" value="e"
					onclick="TasteValue(event)">'ㅁ'</button>
				<button type="submit" name="taste" value="f"
					onclick="TasteValue(event)">'ㅂ'</button>
				<button type="submit" name="taste" value="g"
					onclick="TasteValue(event)">'ㅅ'</button>
				<button type="submit" name="taste" value="h"
					onclick="TasteValue(event)">'ㅇ'</button>
				<button type="submit" name="taste" value="i"
					onclick="TasteValue(event)">'ㅈ'</button>
				<button type="submit" name="taste" value="j"
					onclick="TasteValue(event)">'ㅊ'</button>
				<button type="submit" name="taste" value="k"
					onclick="TasteValue(event)">'ㅋ'</button>
				<button type="submit" name="taste" value="l"
					onclick="TasteValue(event)">'ㅌ'</button>
				<button type="submit" name="taste" value="m"
					onclick="TasteValue(event)">'ㅍ'</button>
				<button type="submit" name="taste" value="n"
					onclick="TasteValue(event)">'ㅎ'</button>
			</td>
		</tr>
		<tr id="taste">

		</tr>
	</table>
	
	<table border="1">
		<tr>
		<td>향</td>
			<td>
				<button type="submit" name="flavor" value="a"
					onclick="TasteValue(event)">'ㄱ'</button>
				<button type="submit" name="flavor" value="b"
					onclick="TasteValue(event)">'ㄴ'</button>
				<button type="submit" name="flavor" value="c"
					onclick="TasteValue(event)">'ㄷ'</button>
				<button type="submit" name="flavor" value="d"
					onclick="TasteValue(event)">'ㄹ'</button>
				<button type="submit" name="flavor" value="e"
					onclick="TasteValue(event)">'ㅁ'</button>
				<button type="submit" name="flavor" value="f"
					onclick="TasteValue(event)">'ㅂ'</button>
				<button type="submit" name="flavor" value="g"
					onclick="TasteValue(event)">'ㅅ'</button>
				<button type="submit" name="flavor" value="h"
					onclick="TasteValue(event)">'ㅇ'</button>
				<button type="submit" name="flavor" value="i"
					onclick="TasteValue(event)">'ㅈ'</button>
				<button type="submit" name="flavor" value="j"
					onclick="TasteValue(event)">'ㅊ'</button>
				<button type="submit" name="flavor" value="k"
					onclick="TasteValue(event)">'ㅋ'</button>
				<button type="submit" name="flavor" value="l"
					onclick="TasteValue(event)">'ㅌ'</button>
				<button type="submit" name="flavor" value="m"
					onclick="TasteValue(event)">'ㅍ'</button>
				<button type="submit" name="flavor" value="n"
					onclick="TasteValue(event)">'ㅎ'</button>
			</td>
		</tr>
		<tr id="taste">

		</tr>
	</table>
	
	

	<!-- 본인이 고른 향, 맛 출력  -->
	<table border="1">
		<tr >
			<td>맛</td>
		</tr>
		<tr id="selectTaste">
		</tr>
		<tr id="selectFlavor">
			<td>향</td>
		</tr>
		<tr>
			<td><button type = "submit" name = "resultSend" value ="result" onclick = "Send(event)">검색</button></td>
		</tr>
	</table>
	
	<!-- 결과 출력  -->
	<table border = "1" id = "result">
		
	</table>
	
	





	<script src="jquery-3.6.0.min.js"></script>

	<script type="text/javascript">
	
	
	
	
	//대분류
	let sort = "";
	//맛을 담을 배열
	let tasteList = [];
	
	
	//대분류 선택시 술 설명과 이미지 나오게 하기
	function ButtonValue(event){
		//대분류 변수만들기
		//let sort = "";
		if(event.target.click){
			sort = event.target.value;
			console.log(sort);
			$.ajax({
				url : "DesCon",
				data : {"num" : sort},
				dataType : "json",
				success : function(result){
					alert("성공");
				/* 	console.log(result); */
					// 소분류 초기화
					$("#des").empty();
					// 넘어온 result 중에서 해당하는 값만 출력
					for (let i = 0 ; i < result.length; i ++) {
						// for문안에 잘 들어왔는지, 분류값은 잘 유지되는지 확인
						/* console.log("for문 안")
						console.log(sort) */
						// 해당 번호에 맞는 정보만 append
						if (sort-1 == i){
						let data = JSON.parse(result[i]);
							$("#des").append("<tr>"
									+"<td>"+data.des+"</td>"
									+"<td>"+data.img+"</td>"
									+"</tr>");
						}else{
							console.log("실패")
						}
					}
					},
				error : function(){
					alert("실패");
				}
			});
		}
	}
	
	

	 //초성으로 맛 선택하기
	function TasteValue(event) {
		//초성을 담을 변수
		let index = "";
		
		if(event.target.click){
			index = event.target.value;
			$.ajax({
				url : "TasteCon",
				data : {"num" : sort, "index" : index},
				dataType : "json",
				success : function(result){
					alert("성공");
					$("#taste").empty();
					for (let i = 0 ; i < result.length; i ++) {
						// for문안에 잘 들어왔는지, 분류값은 잘 유지되는지 확인
						console.log("for문 안")
						console.log(index)
						// 해당 번호에 맞는 정보만 append
						let data = JSON.parse(result[i]);
						if (result != null){
							
						if(data != null){
							$("#taste").append("<tr>"
									+"<td><input type ='checkbox' name = 'taste' onclick = 'checkTaste(event)' value = '"+data+"'>"+data+"</td>"
									+"</tr>");
							
						}
						}else{
							console.log("실패")
						}
						
					}
					
					
				},error : function(){
					alert("실패");
				}
			});
			
		}
		
	} 
	
	//선택한 맛과 향 출력하기
	
 	function checkTaste(event){
		let tasteValue = "";
		
		if(event.target.checked == true){
			tasteValue = event.target.value;
			$("#selectTaste").append("<td>" + tasteValue + "</td")
			tasteList.push(tasteValue);
			console.log(tasteList);
		
		}else if(event.target.checked == false){
			$("#selectTaste * " ).first().remove();
		}
	} 
	
	//결과 출력하기
	
	function Send(event){
		
		if(event.target.click){
			console.log(tasteList)
			
			
			$.ajax({
				url : "ResultCon",
				traditional : true,
				data : {"num" : sort, "tasteList" : tasteList},
				dataType : "json",
				success : function(result){
					console.log(tasteList)
					alert("성공");
					$("#result").empty();
					for(let i = 0; i < result.length; i++){
						let data = JSON.parse(result[i]);
						console.log(result[i]);
						if(data.dr_des == null){
							
						$("#result").append("<tr>"
								+"<td>이름</td>"
								+"<td>" + data.dr_id + "</td></tr>"
								+"<tr>"
								+"<td>향</td>"
								+"<td>" + data.dr_flavor + "</td></tr>"
								+"<tr>"
								+"<td>맛</td>"
								+"<td>" + data.dr_taste + "</td></tr>"
								+"<tr>"
								+"<td>도수</td>"
								+"<td>" + data.dr_abv + "</td></tr>"
								+"<tr>"
								+"<td>설명</td>"
								+"<td>" + data.dr_des + "</td></tr>"
								+"<tr>"
								+"<td>이미지</td>"
								+"<td>" + data.dr_img + "</td></tr>");
						}
						}
					
					
					
				},
				error : function(){
					alert("실패");
				}
				
				
			});
		}
		
		
	}
	
	
	
	</script>





















</body>
</html>