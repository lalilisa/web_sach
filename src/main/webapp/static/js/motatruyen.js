var nutTheoDoi = document.querySelector(".nut-theo-doi")
var nutboTheoDoi = document.querySelector(".bo-theo-doi")

function theoDoi(id_sach){
    document.querySelector(".nut-theo-doi").style.display='none';
    document.querySelector(".bo-theo-doi").style.display = "block";
        $.ajax({
		type:"POST",
		url:`${contextPath}/api/truyenyeuthich/`,
		dataType:"json",
		contentType:"application/json",
		data:JSON.stringify({"ID_User":0,"ID_Sach":id_sach}),
		success :function(response){
			console.log(response)
		}
		
})
}
 document.querySelector(".nut-theo-doi").style.display='none';
function boTheoDoi(id_sach){
    document.querySelector(".nut-theo-doi").style.display='block';
    document.querySelector(".bo-theo-doi").style.display = "none";
    $.ajax({
		type:"DELETE",
		url:`${contextPath}/api/truyenyeuthich/`,
		dataType:"json",
		contentType:"application/json",
		data:JSON.stringify({"ID_User":0,"ID_Sach":id_sach}),
		success:function(response){
			console.log(response)
		}
		
})
}


var tensach=window.location.href.split("/")[5] 
function theLoai(theLoaiSach){
	

	let theloai=''
	for(let j=0;j<theLoaiSach.length;j++){
	theloai+=`<li><a href="">${theLoaiSach[j].TenTheLoai}</a></li>`
	
	}

	return theloai
					
}


window.onload=ss()
function ss(){
$.ajax({
	type:"GET",
	url:`${contextPath}/api/sach/${tensach}`,
	contentType:"application/json",
	dataType:"json",
	success: function(data){
		let tlSach=theLoai(data.theLoaiSach);
	
		let motatruyen=`
				<div class="mo-ta-truyen">
                <img src="/WebSach/static/img/${data.img}" alt="" class="anh-truyen">
                <div class="thuoc-tinh-mo-ta">
                    <p class="ten-truyen">${data.TenSach}</p>
                    <ul class="thong-so-truyen">
                        <li>
                            <span class="ten-thuoc-tinh"><i class="fa-solid fa-user"></i>Tác giả</span>
                            <span class="gia-tri">${data.TacGia}</span>
                        </li>
                        <li>
                            <span class="ten-thuoc-tinh"><i class="fa-solid fa-rss"></i>Tình trạng</span>
                            <span class="gia-tri">Hoàn Thành</span>
                        </li>
                        <li>
                            <span class="ten-thuoc-tinh"><i class="fa-solid fa-thumbs-up"></i>Lượt thích</span>
                            <span class="gia-tri">1048</span>
                        </li>
                     
                        <li>
                            <span class="ten-thuoc-tinh"><i class="fa-solid fa-eye"></i>Lượt xem</span>
                            <span class="gia-tri">1316086</span>
                        </li>
                    </ul>
                    <ul class="the-loai-truyen">
                    	${tlSach}

                    </ul>
                    <div class="nut-tuong-tac">
                        <a  class="btn mau-8bc34a" onclick="lichsu()">
                            <i class="fa-solid fa-book" ></i>
                            <span class="ten-nut"> Đọc từ đầu</span>
                        </a>
                        <div onclick="theoDoi(${data.ID_Sach})" class="btn mau-ff3860 nut-theo-doi">
                            <i class="fa-solid fa-heart"></i>
                            <span class="ten-nut">Yêu thích</span>
                        </div>
                        <div onclick="boTheoDoi(${data.ID_Sach})" class="btn mau-ff3860 bo-theo-doi">
                            <i class="fa-solid fa-xmark"></i>
                            <span class="ten-nut">Bỏ Yêu thích</span>
                        </div>
 
                        <a href="doctruyen.html" class="btn">
                            
                        </a>
                    </div>
                </div>
            </div>
		
		`
		document.getElementsByClassName('mo-ta-truyen')[0].innerHTML=motatruyen
		console.log(data);

	}
})
}
$.ajax({
	type:"GET",
	 url:`${contextPath}/api/trangtruyen/${tensach}`,
	contentType:"application/json",
	dataType:"json",
	success: function(data){
		console.log(data);
		let trangsach="";
		for(let i=0;i<data.length;i++){
			trangsach+=`<li>
                        <a href="${contextPath}/doctruyen/${data[i].tenSachKhongDau}/${data[i].ID_Trang}" class="so-chuong">Trang ${data[i].ID_Trang}</a>
                        
                    </li>`
		}
				document.getElementsByClassName('chuong')[0].innerHTML=trangsach
	}
})
$.ajax({
	type:"GET",
	 url:`${contextPath}/api/trangtruyen/${tensach}/full`,
	contentType:"application/json",
	dataType:"json",
	success: function(data){
		console.log(data);
		let trangsach="";
		for(let i=0;i<data.length;i++){
			trangsach+=`<li>
                        <a href="${contextPath}/doctruyen/${data[i].tenSachKhongDau}/${data[i].ID_Trang}" class="so-chuong">Trang ${data[i].ID_Trang}</a>
                        
                    </li>`
		}
				document.getElementsByClassName('chuong')[0].innerHTML=trangsach
				    
	}
})
var fd = new FormData();    
fd.append( 'ten_sach_khong_dau', tensach );
$.ajax({
	
	type:"POST",
	url:`${contextPath}/api/checktruyenyeuthich`,
	contentType:false,
	cache: false,
    processData: false,
    contentType: false,
	data:fd,
	success: function(response){
		console.log(response)
		if(response==="yêu thích"){
			    document.querySelector(".nut-theo-doi").style.display='none';
   				document.querySelector(".bo-theo-doi").style.display = "block";
		}
		else{
					console.log("trimai")
				    document.querySelector(".nut-theo-doi").style.display='block';
    				document.querySelector(".bo-theo-doi").style.display = "none";
		}
	}
		
})
const tenTruyen=window.location.href.split("/")[5]



 function lichsu(){
	
	
    $.ajax({
		contentType:"application/json",
		dataType:"json",
        type: "post",
        url: `http://localhost:8080/WebSach/api/lichsudoc/${tenTruyen}`,
        
        success: function (result) {
            console.log(result);
			window.location.href=`${contextPath}/doctruyen/${tenTruyen}/full`
			
      }
      });
    

    

}

