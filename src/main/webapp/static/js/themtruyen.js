




    	  $(document).ready(function() {
              	let TheLoaiSach=[]
    		    $('#form_dang_truyen').submit(function() {
				$('.chon_the_loai >span').each(function(){
		    			let TheLoai ={}
		    				TheLoai['id_TheLoai']=$(this).attr('id_theloai');
		    				TheLoai['tenTheLoai']=$(this).attr('the_loai');
		    				TheLoaiSach.push(TheLoai);
    				
    				})
    			 let t=JSON.stringify(TheLoaiSach).toString();
    			 $("#theloaisach").val(t);
    			 console.log($("#theloaisach").val())
    		      $(this).ajaxSubmit({
    		          type:'POST',
    		          url:`${contextPath}/api/sach/`,
    		          error: function(xhr) {
    		     			console.log(xhr.status)
    		          },

    		      success: function(response) {
    		            console.log(response)
    		            alert("Đăng thành công")
    		          }
    		  });
    		  return false;
    		  });    
    		  });
		  
    async function DangTruyen(){
    	let Sach={};
    		Sach['TenSach']=$("#ten_truyen").val();
    		Sach['Mota']=$("#mo_ta").val();
    		Sach['TacGia']=$("#tac_gia").val();
    		Sach['SoTrang']=$("#so_trang").val();
    		Sach['NgayDang']=$("#tac_gia").val();
    		Sach['img']=$("#tac_gia").val();
    		Sach['TenTheLoai']=[]
    		$('.chon_the_loai >span').each(function(){
    			let TheLoai ={}
    				TheLoai['id_TheLoai']=$(this).attr('id_theloai');
    				TheLoai['tenTheLoai']=$(this).attr('the_loai');
    				Sach['TenTheLoai'].push(TheLoai);
    				
    		})
    		console.log(Sach)
    		let formData=new FormData();
    		formData.append("Sach",JSON.stringify(Sach));
    		formData.append("file",ajaxfile.files[0]);
    		formData.append("ten","trimai");
    		
    	

    		await fetch(`${contextPath}/api/sach/`, {
    		      method: "POST", 
    		      body: formData
    		    });
    	
      			//.then(response => console.log(response.json()));
    	
    	
    }