



   $.ajax({
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
      
        },
        type: "GET",
        url: `${contextPath}/api/theloai`,
        success: function (result) {
           	
           	let element=`<div>`
           	let count=0;
			for(let i=0;i<result.length;i++){
				if(count===4){
					if(i===result.length-1)
						element+=`<li><a href="${contextPath}/trangchu?theloai=${result[i].ID_TheLoai}"> ${result[i].TenTheLoai}</a></li></div>`
					else
						element+=`</div><div><li><a href="${contextPath}/trangchu?theloai=${result[i].ID_TheLoai}"> ${result[i].TenTheLoai}</a></li>`
					count=0;
					continue;
				}
				if(i===result.length-1){
						element+=`<li><a href="${contextPath}/trangchu?theloai=${result[i].ID_TheLoai}"> ${result[i].TenTheLoai}</a></li></div>`	
						continue;
						}
				element+=`
                        <li><a href="${contextPath}/trangchu?theloai=${result[i].ID_TheLoai}"> ${result[i].TenTheLoai}</a></li>`
                count++;
             }
            
             document.getElementsByClassName('the-loai')[0].innerHTML=element
       } 
      });