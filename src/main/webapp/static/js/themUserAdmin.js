

const them=document.querySelector(".them-user");

const username=document.querySelector("#ten-dang-nhap");
const password=document.querySelector("#mat-khau");
const vaitro=document.querySelector("#vai-tro");
const gioitinh=document.querySelector("#gioi-tinh");
const hoten=document.querySelector("#ho-ten");
const email=document.querySelector("#email");

them.onclick=function(){
	
	var user = {
			"Username": username.value,
			"Password": password.value,
			"Role": vaitro.value,
            "HoTen": hoten.value,
            "Email": email.value,
            "Gioitinh": gioitinh.value
        };
	
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/WebSach/api-admin/user/",
            data: JSON.stringify(user),
            success: function (result) {
                console.log(result);
              
                    alert(result);
              
                
            }
	});
}


