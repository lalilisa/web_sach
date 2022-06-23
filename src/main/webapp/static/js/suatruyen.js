
let tenTruyen=window.location.href.split("/")[5]
$.ajax({
	
	type:"GET",
	contentType:"application/json",
	dataType:"json",
	url:`${contextPath}/api/sach/${tenTruyen}`,
	success : function(data){
		console.log(data)
		$("#ten_truyen").val(data.TenSach);
		$("#tac_gia").val(data.TacGia);
		$("#mo_ta").val(data.Mota);

		$("#so_trang").val(data.SoTrang);
				$("#t").val("11");
		let theloai=""
		for(let i=0;i<data.theLoaiSach.length;i++){
			         const list = document.querySelector('.chon_the_loai')
                    const newNode = document.createElement("span");
                    
                    newNode.setAttribute('id_theloai',data.theLoaiSach[i].ID_TheLoai)
                    newNode.setAttribute('the_loai',data.theLoaiSach[i].TenTheLoai)
                    newNode.innerHTML=data.theLoaiSach[i].TenTheLoai+'<i class="fa-solid fa-xmark"></i>'
               		newNode.setAttribute('onclick',"xoaTagTheLoai(this)")
                    list.insertBefore(newNode, document.getElementById('the_loai'));
		}
		                  
		
	}
	
})

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
    			 $("#the_loaisach").val(t);
    			 console.log($("#the_loaisach").val())
    		      $(this).ajaxSubmit({
    		          type:'PUT',
    		          url:`${contextPath}/api/sach/${tenTruyen}`,
    		          error: function(xhr) {
    		     			console.log(xhr.status)
    		          },

    		      success: function(response) {
    		            console.log(response);
    		            alert(response)
    		           
    		          }
    		  });
    		  return false;
    		  });    
    		  });