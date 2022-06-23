$.ajax({
	
	type:"GET",
	contentType:"application/json",
	dataType:"json",
	url:`http://localhost:8080/WebSach/api-admin/user/`,
	success : function(data){
		
	console.log(data);
	let dsuser=`          <tr>
                                <th>ID User</th>
                                <th>Username</th>
                                <th>Password</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Avarta</th>
                                <th>Vai tro</th>
                                <th>Sửa/Xóa</th>
                            </tr>`
                 for(let i=0;i<data.length;i++){
				dsuser+=`<tr>
                                <td>${data[i].ID_User}</td>
                                <td>${data[i].Username}</td>
                                <td>${data[i].Password}</td>
                                <td>${data[i].HoTen}</td>
                                <td>${data[i].Email}</td>
                                <td>${data[i].img}</td>
                                <td>${data[i].Role}</td>
                                <td>
                                    <button> <a href="http://localhost:8080/WebSach/admin/suaUser/${data[i].ID_User}" style="text-decoration:none;color:black">Sua</a></button>
                                    
                                </td>
                            </tr>`
	
}
			document.getElementById('danh-sach-user').innerHTML=dsuser
		                  
		
	}
	
})