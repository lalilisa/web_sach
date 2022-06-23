
$.ajax({
	
	type:"GET",
	contentType:"application/json",
	dataType:"json",
	url:`http://localhost:8080/WebSach/api/user/`,
	success : function(data){
		console.log(data)
		$("#ten-dang-nhap").val(data.Username);
		$("#ho-ten").val(data.HoTen);
		$("#email").val(data.Email);
		$("#vai-tro").val(data.Role);
		

		
		
	}
	
})

const luu=document.querySelector(".nut-luu");
const hoten=document.querySelector("#ho-ten");
const email=document.querySelector("#email");

luu.onclick=function(){
	
	var user = {
            "HoTen": hoten.value,
            "Email": email.value
        };
	
	$.ajax({
		type: "PUT",
		url: "http://localhost:8080/WebSach/api/user/",
            data: JSON.stringify(user),
            success: function (result) {
                console.log(result);
                if (result=="Sua that bai!!!")
                    alert(result);
                else{
                    alert("Sua thành công");
                }
            }
	});
}
