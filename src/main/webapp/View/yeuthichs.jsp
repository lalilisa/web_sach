<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<button id="yeu" onclick="yeuthich(3)">Yeuthich</button>
</body>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	function yeuthich(id){
		let data={}
		data['ID_Sach']=id
		data['ID_User']=0
		$.ajax({
			type:"POST",
			url:"http://localhost:8080/WebSach/api/truyenyeuthich/",
			contentType:"application/json",
			dataType:'json',
			data:JSON.stringify(data),
			success:function(data){
				console.log(data)
			}
		})
	}
</script>
</html>