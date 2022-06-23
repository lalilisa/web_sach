
var nutTheoDoi = document.querySelector(".nut-theo-doi")
var nutboTheoDoi = document.querySelector(".bo-theo-doi")

function theoDoi(){
    nutTheoDoi.style.display = "none";
    nutboTheoDoi.style.display = "block";
}

function boTheoDoi(){
    nutTheoDoi.style.display = "block";
    nutboTheoDoi.style.display = "none";
}

var tensach=window.location.href.split("/")[5] 
var trang=window.location.href.split("/")[6] 


$.ajax({
	type:"GET",
	 url:`${contextPath}/api/trangtruyen/${tensach}/${trang}`,
	contentType:"application/json",
	dataType:"json",
	success: function(data){
		console.log(data);
		
		let trangtruyen="";
			for(let i=0;i<data.length;i++){
			trangtruyen+=`<img src="/WebSach/static/img/${data[i].noiDung}" alt="">`
		}
		console.log(trangtruyen)
		document.getElementById("noi-dung-chuyen").innerHTML=trangtruyen;
	}
	
	
	
})