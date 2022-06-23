
let id_user=window.location.href.split("/")[6]
$.ajax({
	
	type:"GET",
	contentType:"application/json",
	dataType:"json",
	url:`http://localhost:8080/WebSach/api-admin/user/${id_user}`,
	success : function(data){
		console.log(data)
		$("#ten-dang-nhap").val(data.Username);
		$("#ho-ten").val(data.HoTen);
		$("#email").val(data.Email);
		$("#vai-tro").val(data.Role);
		$("#gioi-tinh").val(data.Gioitinh);
		

		
		
	}
	
})

const sua=document.querySelector(".sua-user");

const username=document.querySelector("#ten-dang-nhap");
const password=document.querySelector("#mat-khau");
const vaitro=document.querySelector("#vai-tro");
const gioitinh=document.querySelector("#gioi-tinh");
const hoten=document.querySelector("#ho-ten");
const email=document.querySelector("#email");

sua.onclick=function(){
	
	var user = {
			"Username": username.value,
			"Password": password.value,
			"Role": vaitro.value,
            "HoTen": hoten.value,
            "Email": email.value,
            "Gioitinh": gioitinh.value
        };
	
	$.ajax({
		type: "PUT",
		url: "http://localhost:8080/WebSach/api-admin/user/${id_user}",
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
