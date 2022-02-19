<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
//찜목록을 위한 세션에 저장된 닉네임 가져오기
//String nick = session.getAttribute("nick");
String nick = "테스트";
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	
	<button onclick="location.href='Jjim.jsp'">찜한 정보 보러가기</button>
	


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
					onclick="FlavorValue(event)">'ㄱ'</button>
				<button type="submit" name="flavor" value="b"
					onclick="FlavorValue(event)">'ㄴ'</button>
				<button type="submit" name="flavor" value="c"
					onclick="FlavorValue(event)">'ㄷ'</button>
				<button type="submit" name="flavor" value="d"
					onclick="FlavorValue(event)">'ㄹ'</button>
				<button type="submit" name="flavor" value="e"
					onclick="FlavorValue(event)">'ㅁ'</button>
				<button type="submit" name="flavor" value="f"
					onclick="FlavorValue(event)">'ㅂ'</button>
				<button type="submit" name="flavor" value="g"
					onclick="FlavorValue(event)">'ㅅ'</button>
				<button type="submit" name="flavor" value="h"
					onclick="FlavorValue(event)">'ㅇ'</button>
				<button type="submit" name="flavor" value="i"
					onclick="FlavorValue(event)">'ㅈ'</button>
				<button type="submit" name="flavor" value="j"
					onclick="FlavorValue(event)">'ㅊ'</button>
				<button type="submit" name="flavor" value="k"
					onclick="FlavorValue(event)">'ㅋ'</button>
				<button type="submit" name="flavor" value="l"
					onclick="FlavorValue(event)">'ㅌ'</button>
				<button type="submit" name="flavor" value="m"
					onclick="FlavorValue(event)">'ㅍ'</button>
				<button type="submit" name="flavor" value="n"
					onclick="FlavorValue(event)">'ㅎ'</button>
			</td>
		</tr>
		<tr id="flavor">

		</tr>
	</table>



	<!-- 본인이 고른 향, 맛 출력  -->
	<table border="1">
		<tr>
			<td>맛</td>
		</tr>
		<tr id="selectTaste">
		</tr>
		<tr>
			<td>향</td>
		</tr>
		<tr id="selectFlavor">
		</tr>
		<tr>
			<td>검색옵션</td>
			<td><input type="radio" name="option" value="or"
				onclick="selectOption(event)">OR <input type="radio"
				name="option" value="and" onclick="selectOption(event)">AND
			</td>
		</tr>

		<tr>
			<td><button type="submit" name="reset" value="reset"
					onclick="Reset(event)">초기화</button></td>
			<!-- 선택한 값 삭제   -->
			<td><button type="submit" name="resultSend" value="result"
					onclick="Send(event)">검색</button></td>
		</tr>
	</table>

	<!-- 결과 출력  -->
	<table border="1" id="result">

	</table>







	<script src="jquery-3.6.0.min.js"></script>

	<script type="text/javascript">
		//대분류
		let sort = "";
		//맛을 담을 배열
		let tasteList = [];
		//향을 담을 배열
		let flavorList = [];
		//옵션 담을 변수
		let option = "";
		//찜카운터
		let bSubmit = 1;
		//닉네임
		let nick = "<%=nick%>";
		console.log(nick) 

		//대분류 선택시 술 설명과 이미지 나오게 하기
		function ButtonValue(event) {
			
			//대분류를 눌렀을때 이미 중분류가 선택되어있는 상태일수 있으니 중분류 초기화
				$("#result").empty();
				$("#selectTaste").empty();
				$("#selectFlavor").empty();
				$("#taste").empty();
				$("#flavor").empty();
				tasteList = [];
				flavorList = [];
				option = "";
				
				
			//대분류 변수만들기
			//let sort = "";
			if (event.target.click) {
				sort = event.target.value;
				console.log(sort);
				$.ajax({
					url : "DesCon",
					data : {
						"num" : sort
					},
					dataType : "json",
					success : function(result) {
						alert("성공");
						/* 	console.log(result); */
						// 소분류 초기화
						$("#des").empty();
						// 넘어온 result 중에서 해당하는 값만 출력
						for (let i = 0; i < result.length; i++) {
							// for문안에 잘 들어왔는지, 분류값은 잘 유지되는지 확인
							/* console.log("for문 안")
							console.log(sort) */
							// 해당 번호에 맞는 정보만 append
							if (sort - 1 == i) {
								let data = JSON.parse(result[i]);
								$("#des").append(
										"<tr>" + "<td>" + data.des + "</td>"
												+ "<td>" + data.img + "</td>"
												+ "</tr>");
							} else {
								console.log("실패")
							}
						}
					},
					error : function() {
						alert("실패");
					}
				});
			}
		}
		

		//초성으로 맛 선택하기
		function TasteValue(event) {
			//초성을 담을 변수
			let index = "";

			if (event.target.click) {
				index = event.target.value;
				$
						.ajax({
							url : "TasteCon",
							data : {
								"num" : sort,
								"index" : index
							},
							dataType : "json",
							success : function(result) {
								alert("성공");
								$("#taste").empty();
								for (let i = 0; i < result.length; i++) {
									// for문안에 잘 들어왔는지, 분류값은 잘 유지되는지 확인
									console.log("for문 안")
									console.log(index)
									// 해당 번호에 맞는 정보만 append
									let data = JSON.parse(result[i]);
									if (result != null) {

										if (data != null) {
											$("#taste")
													.append(
															"<tr>"
																	+ "<td><input type ='checkbox'  id = '"
																	+ i
																	+ "' onclick = 'checkTaste(event)' value = '"
																	+ data
																	+ "'>"
																	+ data
																	+ "</td>"
																	+ "</tr>");

										}
									} else {
										console.log("실패")
									}

								}

							},
							error : function() {
								alert("실패");
							}
						});

			}

		}

		//초성으로 향 선택하기
		function FlavorValue(event) {
			//초성을 담을 변수
			let index = "";

			if (event.target.click) {
				index = event.target.value;
				$
						.ajax({
							url : "FlavorCon",
							data : {
								"num" : sort,
								"index" : index
							},
							dataType : "json",
							success : function(result) {
								alert("성공");
								$("#flavor").empty();
								for (let i = 0; i < result.length; i++) {
									// for문안에 잘 들어왔는지, 분류값은 잘 유지되는지 확인
									console.log("for문 안")
									console.log(index)
									// 해당 번호에 맞는 정보만 append
									let data = JSON.parse(result[i]);
									if (result != null) {

										if (data != null) {
											$("#flavor")
													.append(
															"<tr>"
																	+ "<td><input type ='checkbox'  id = '"
																	+ i
																	+ "' onclick = 'checkFlavor(event)' value = '"
																	+ data
																	+ "'>"
																	+ data
																	+ "</td>"
																	+ "</tr>");

										}
									} else {
										console.log("실패")
									}

								}

							},
							error : function() {
								alert("실패");
							}
						});

			}

		}

		//선택한 맛 출력하기

		function checkTaste(event) {
			let tasteValue = "";

			if (event.target.checked == true) {
				tasteValue = event.target.value;
				$("#selectTaste").append(
						"<td id ="+ event.target.id + ">" + tasteValue
								+ "</td>")
				tasteList.push(tasteValue);
				console.log(tasteList);

			} else if (event.target.checked == false) {
				tasteValue = event.target.value;

				//			$("#selectTaste td").eq(1).remove();
				$("#selectTaste td#" + event.target.id).remove();
				//$("#selectTaste > td:nth-child(" +tasteValue+ ")").remove(); 
				for (let i = 0; i < tasteList.length; i++) {
					if (tasteList[i] === tasteValue) {
						tasteList.splice(i, 1);
						i--;
						console.log(tasteList);
					}
					;
				}
				;
			}
			;
		};

		//선택한 향 출력하기

		function checkFlavor(event) {
			let flavorValue = "";

			if (event.target.checked == true) {
				flavorValue = event.target.value;
				$("#selectFlavor").append(
						"<td id =" + event.target.id+ ">" + flavorValue
								+ "</td")
				flavorList.push(flavorValue);
				console.log(flavorList);

			} else if (event.target.checked == false) {
				flavorValue = event.target.value;
				$("#selectFlavor td#" + event.target.id).remove();
				for (let i = 0; i < flavorList.length; i++) {
					if (flavorList[i] === flavorValue) {
						flavorList.splice(i, 1);
						i--;
						console.log(flavorList);
					}
					;
				}
				;
			}
		}

		//옵션 선택하기(and , or)

		function selectOption(event) {

			if (event.target.checked) {
				option = event.target.value;
				console.log(option)
			}

		}

		//결과 출력하기

		function Send(event) {

			if (event.target.click) {
				//향이나 맛을 안골랐어도 실행하기 위해 배열에 임의의 값을 넣는다
			 	if (Array.isArray(flavorList) && flavorList.length === 0) {
					flavorList.push("빈값임");
					
				}
				if (Array.isArray(tasteList) && tasteList.length === 0) {
					tasteList.push("빈값임");
					
				} 
				//한가지 중분류만 골랐을 때 자동으로 or가 들어가게 하는 조건문
				if (!option) {
					option = "or";
					console.log("선택을 안했기 때문에 지금 옵션은> " + option);
				};
				

				$.ajax({
							url : "ResultCon",
							traditional : true,
							data : {
								"num" : sort,
								"tasteList" : tasteList,
								"flavorList" : flavorList,
								"option" : option
							},
							dataType : "json",
							success : function(result) {
								console.log(tasteList)
								alert("성공");
								$("#result").empty();
								if(result.length == 0){
									$("#result").append(
											"<tr><td>검색하신 결과가 없습니다</td></tr>");
								}
								for (let i = 0; i < result.length; i++) {
									let data = JSON.parse(result[i]);
									console.log(result[i]);
									
									if (data.dr_des != null) {
										$("#result")
												.append(
														"<tr>" + "<td>이름</td>"
																+ "<td>"
																+ data.dr_id
																+ "</td></tr>"
																+ "<tr>"
																+ "<td>향</td>"
																+ "<td>"
																+ data.dr_flavor
																+ "</td></tr>"
																+ "<tr>"
																+ "<td>맛</td>"
																+ "<td>"
																+ data.dr_taste
																+ "</td></tr>"
																+ "<tr>"
																+ "<td>도수</td>"
																+ "<td>"
																+ data.dr_abv
																+ "</td></tr>"
																+ "<tr>"
																+ "<td>설명</td>"
																+ "<td>"
																+ data.dr_des
																+ "</td></tr>"
																+ "<tr>"
																+ "<td>이미지</td>"
																+ "<td><img src = " + data.dr_img + "></td></tr>"
																+ "<tr>"
																+ "<td><button type = 'submit' id = '"+ data.num + "' value = '"+ data.num +"' onclick = 'Jjim(event)'>찜하기</button></td>"
																+ "</tr>");

									} else if (data.dr_des == null) {
										//des가 비어있을때 작동
										data.dr_des = "";
										$("#result")
												.append(
														"<tr>" + "<td>이름</td>"
																+ "<td>"
																+ data.dr_id
																+ "</td></tr>"
																+ "<tr>"
																+ "<td>향</td>"
																+ "<td>"
																+ data.dr_flavor
																+ "</td></tr>"
																+ "<tr>"
																+ "<td>맛</td>"
																+ "<td>"
																+ data.dr_taste
																+ "</td></tr>"
																+ "<tr>"
																+ "<td>도수</td>"
																+ "<td>"
																+ data.dr_abv
																+ "</td></tr>"
																+ "<tr>"
																+ "<td>설명</td>"
																+ "<td>"
																+ data.dr_des
																+ "</td></tr>"
																+ "<tr>"
																+ "<td>이미지</td>"
																+ "<td><img src = " + data.dr_img + "></td></tr>"
																+ "<tr>"
																+ "<td><button type = 'submit' id = '"+ data.num + "' value = '"+ data.num +"' onclick = 'Jjim(event)'>찜하기</button></td>"
																+ "</tr>");

									}
								}

							},
							error : function() {
								alert("실패");
							}

						});
			}

			//'빈값임' 삭제
			if (flavorList[0] === "빈값임") {
				flavorList = [];
				console.log(flavorList[0]);
			}
			if (tasteList[0] === "빈값임") {
				tasteList = [];
				console.log(tasteList[0]);
			}

		}
		
		//찜기능
		function Jjim(event){
			
			//넘버링 가져오기
			if(event.target.click){
			let num = event.target.value;
			let id = event.target.id;
			let color = 
			
			
				
				
			$("#"+id).css("color","red")
			console.log("번호확인 > " + num)
			$.ajax({
				url : "JjimCon",
				data : {"bSubmit" : bSubmit, "num" : num, "nick" : nick},
				dataType : "json",
				success : function(result){
					alert("찜등록");
				},
				error : function(){
					alert("찜등록");
				}
			});
			
			
			/* if(bSubmit === 0){
				//0이면 1로 바꾸기
				bSubmit = 1;
				console.log("번호확인 > " + num)
				$.ajax({
					url : "JjimCon",
					data : {"bSubmit" : bSubmit, "num" : num},
					dataType : "json",
					success : function(result){
						alert("찜등록");
					},
					error : function(){
						alert("실패");
					}
				});
			}else{
				bSubmit = 0;
				console.log("번호확인 > " + num)
				$.ajax({
					url : "JjimCon",
					data : {"bSubmit" : bSubmit, "num" : num},
					dataType : "json",
					success : function(result){
						alert("찜해제");
					},
					error : function(){
						alert("실패");
					}
					
					});
			} */
			
			
			}
			
		}
		

		//초기화 기능
		function Reset(event) {
			$("#result").empty();
			$("#selectTaste").remove();
			$("#selectFlavor").remove();
			$("#taste").empty();
			$("#flavor").empty();
			tasteList = [];
			flavorList = [];
			option = "";
		}
	</script>



</body>
</html>