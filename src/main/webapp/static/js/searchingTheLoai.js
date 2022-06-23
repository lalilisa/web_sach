

urlParams = new URLSearchParams(window.location.search).get('theloai');
console.log(urlParams)
if(urlParams!==null){

$.ajax({
	type:"GET",
	url:`${contextPath}/api/sach/`,
	contentType:"application/json",
	dataType:"json",
	success: function(data){
		
		data=data.filter( o=> (o.theLoaiSach).find( s=> s.ID_TheLoai===urlParams))
		console.log(data)
		let danhSach='';
        for(let i=0;i<data.length;i++){
                danhSach+=`
                <li>
                <div class="anh_sach">
                <a href="${contextPath}/doctruyen/${data[i].tenKhongDau}"><img class="center" src="static/img/${data[i].img}" alt="${data[i].TenSach}" style=""></a>

                <div class="thongtin_sach">
                    <div class="ten_sach qtip" data-qtip="#truyen-tranh-12139">
                        <h3><a title="${data[i].TenSach}" href="${contextPath}/doctruyen/${data[i].tenKhongDau}">${data[i].TenSach}</a></h3>
                    </div>

                    <div class="trang_cuoi">
                                               
                                        </div>
                </div>
            </li>
                `
        }
        document.getElementById('chua-sach').innerHTML=danhSach
        document.getElementsByClassName('mo-dau')[0].innerHTML=''
	}
	
})
}