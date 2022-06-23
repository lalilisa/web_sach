<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form enctype="multipart/form-data" id="form_up">
	<input type="text" id="name" name="name">
  <input id="ajaxfile" type="file" name="file"/> <br/>
  <button id="sub" > Upload </button>
</form>
	<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
      <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery.form/3.51/jquery.form.min.js"></script>
    	<script>
    	  $(document).ready(function() {
    		  $("#sub").click(function(){
              	let formData=new FormData();
              	formData.append("file",$("#ajaxfile")[0].files[0]);
              	//formData.append("name",$("#name").val());
              	$.ajax({
              		url:"http://localhost:8080/WebSach/fileuploadservlet",
              		type:"POST",
              		contentType:false,
              		processData:false,
              		data:formData,
              		success : function(data){
              			console.log(data)
              		}
              	})
    		    
    		  return false;
    		  });   
    	  })
    		 
		  
  </script>
</body>
	
</html>