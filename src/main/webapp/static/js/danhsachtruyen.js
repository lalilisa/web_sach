$.ajax({
	
	type:"GET",
	contentType:"application/json",
	dataType:"json",
	url:`${contextPath}/api/sach/`,
	success : function(data){
		
	console.log(data);
	let dstruyen=`           <tr>
                                <th>ID</th>
                                <th>Tên Sách</th>
                                <th>Tác giả</th>
                                <th>Ngày Đăng</th>
                                <th>Số Trang</th>
                                <th>Thêm/Xóa</th>
                            </tr>`
                 for(let i=0;i<data.length;i++){
				dstruyen+=`<tr>
                                <td>${data[i].ID_Sach}</td>
                                <td>${data[i].TenSach}</td>
                                <td>${data[i].TacGia}</td>
                                <td>${data[i].NgayDang}</td>
                                <td>${data[i].SoTrang}</td>
                                <td>
                                    <button> <a href="${contextPath}/admin/themtrang/${data[i].tenKhongDau}" style="text-decoration:none;color:black">Thêm trang </a></button>
                                    <button><a href="${contextPath}/admin/${data[i].tenKhongDau}"style="text-decoration:none;color:black">Sửa </a></button>
                                    <button onclick="XoaSach(${data[i].ID_Sach})">Xóa</button>
                                    <button onclick="hienThiDanhSachTrang('${data[i].tenKhongDau}')">Danh Sách Trang</button>
                                </td>
                            </tr>`
	
}
			document.getElementById('ds_truyen').innerHTML=dstruyen
		                  
		
	}
	
})

function XoaSach(id_sach){
	$.ajax({
		type:"DELETE",
		url:`${contextPath}/api/sach/${id_sach}`,
		contentType:"application/json",
		dataType:"json",
		
		success : function(data){
			
			console.log(data);
			 
		},
		error:function(e){
			console.log(e.responseText)
			$("#ds_truyen").load(" #ds_truyen>*");
			getSach();
		}
		
		
	})
	
}
function hienThiDanhSachTrang(ten){
	
		$.ajax({
			
			type:"GET",
			url:`${contextPath}/api/trangtruyen/${ten}/full`,
			contentType:"application/json",
			dataType:"json",
			success : function(data){
				
				console.log(data)
						
				let dstruyen=`  <tr>
								<th>STT</th>
								
                                <th>Tên Sách Không dấu</th>
                                <th>Trang</th>
                                <th>Nội Dung</th>
                                <th>Action</th>
                            </tr>`
                 for(let i=0;i<data.length;i++){
				dstruyen+=`<tr>
                               
                                <td>${(i+1)}</td>
                                 <td>${data[i].tenSachKhongDau}</td>
                                <td>${data[i].ID_Trang}</td>
								<td>${data[i].noiDung}</td>
                                <td>
                             
                                    <button onclick="XoaTrangSach(${data[i].ID_Trang},'${data[i].tenSachKhongDau}')">Xóa</button>
                                    <button onclick="SuaTrangSach('${data[i].tenSachKhongDau}')">Sửa</button>

                                </td>
                            </tr>`
	
		}
			document.getElementById('ds_truyen').innerHTML=dstruyen
		                  
		
	}
			
			
		})
	
	
}

function SuaTrangSach(ten){
	window.location.href=`http://localhost:8080/WebSach/admin/suatrang/${ten}`
	
}
function XoaTrangSach(trang,ten){
	let TrangSach={}
	TrangSach['tenSachKhongDau']=ten
	TrangSach['ID_Trang']=parseInt(trang)
	$.ajax({
		type:"DELETE",
		url:"http://localhost:8080/WebSach/api/trangtruyen/",
		contentType:"application/json",
		dataType:"json",
		data:JSON.stringify(TrangSach),
		success : function(data){
			
			alert(data)
		},
		error : function(e){
			console.log(e.responseText)
			hienThiDanhSachTrang(ten)
		}
		
	})
	
}
function getSach(){
	$.ajax({
	
	type:"GET",
	contentType:"application/json",
	dataType:"json",
	url:`http://localhost:8080/WebSach/api/sach/`,
	success : function(data){
		
	console.log(data);
	let dstruyen=`           <tr>
                                <th>ID</th>
                                <th>Tên Sách</th>
                                <th>Tác giả</th>
                                <th>Thể loại</th>
                                <th>Chaps</th>
                                <th>Thêm/Xóa</th>
                            </tr>`
                 for(let i=0;i<data.length;i++){
				dstruyen+=`<tr>
                                <td>${data[i].ID_Sach}</td>
                                <td>${data[i].TenSach}</td>
                                <td>${data[i].TacGia}</td>
                                <td>${data[i].NgayDang}</td>
                                <td>${data[i].SoTrang}</td>
                                <td>
                                    <button> <a href="http://localhost:8080/WebSach/admin/themtrang/${data[i].tenKhongDau}" style="text-decoration:none;color:black">Thêm trang </a></button>
                                    <button><a href="http://localhost:8080/WebSach/admin/${data[i].tenKhongDau}"style="text-decoration:none;color:black">Sửa </a></button>
                                    <button onclick="XoaSach(${data[i].ID_Sach})">Xóa</button>
                                    <button onclick="hienThiDanhSachTrang('${data[i].tenKhongDau}')">Danh Sách Trang</button>
                                </td>
                            </tr>`
	
}
			document.getElementById('ds_truyen').innerHTML=dstruyen
		                  
		
	}
	
})
}