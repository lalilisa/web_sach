let urlParams = new URLSearchParams(window.location.search).get('theloai');


if(urlParams===null){
$.ajax({
    type:"GET",
    url:`${contextPath}/api/sach/`,
    contentType:"application/json",

    success : function(data){
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
        console.log(data)
    }

})
}
        function timkiem(){
            $('.gioi-thieu').html("");
            $.ajax({
                url : 'http://localhost:8080/WebSach/api/sach/',
                type : 'get',
                dataType : 'json',
                success : function (result){
                    var html='';
                    var giatritimkiem=document.getElementById('nhap-tim-kiem').value.toLowerCase().normalize('NFD').replace(/[\u0300-\u036f]/g, '').replace(/đ/g, 'd').replace(/Đ/g, 'D');
                    console.log("Mĩ thuật 1".toLowerCase().indexOf(giatritimkiem.toLowerCase()));
                    $.each(result, function(key, value){
                    var tensach1=value['TenSach'].toLowerCase().normalize('NFD').replace(/[\u0300-\u036f]/g, '').replace(/đ/g, 'd').replace(/Đ/g, 'D');
                    if(tensach1.indexOf(giatritimkiem)!=-1){
                        html+='<li>';
                            html+='<div class="anh_sach">'
                                html+='<a href="http://localhost:8080/WebSach/doctruyen/'+value['tenKhongDau']+'"><img class="center" src="'+'/WebSach/static/img/'+value['img']+'" alt="'+value['TenSach']+'" style=""></a>';
                                html+='<div class="thongtin_sach">';
                                    html+='<div class="ten_sach qtip" data-qtip="#truyen-tranh-12139">';
                                        html+='<h3><a title="'+value['TenSach']+'" href="http://localhost:8080/WebSach/doctruyen/'+value['tenKhongDau']+'">'+value['TenSach']+'</a></h3>';
                                    html+='</div>';

                                    html+='<div class="trang_cuoi"></div>';
                            html+='</div>';
                        html+='</li>';
                    }
                    });
                    $('#chua-sach').html(html);
                }
            });
}
$.ajax({
    type:"GET",
    url:`${contextPath}/toptruyen`,
    contentType:"application/json",
    dataType:"json",
    success : function(data){
        let danhSach=`
                        <div class="gioi-thieu1">
                            <div class="tile ">
                                <a href="doctruyen.html">
                                    <div class="nhan_truyen">
                                        <img class="cover" src="/WebSach/static/img/${data[0].img}" alt="cover">
                                        <div class="bottom-shadow"></div>
                                        <div class="captions">
                                            <h3>${data[0].TenSach}</h3>
                                        </div>
                                        <div class="chapter red">${data[0].SoTrang} Trang</div>
                                    </div>
                                    <!-- /.nhan_truyen -->
                                </a>
                            </div>
                            <div class="tile ">
                                <a href="doctruyen.html">
                                    <div class="nhan_truyen">
                                        <img class="cover" src="/WebSach/static/img/${data[1].img}" alt="cover">
                                        <div class="bottom-shadow"></div>
                                        <div class="captions">
                                            <h3>${data[1].TenSach}</h3>
                                        </div>
                                        <div class="chapter red">${data[1].SoTrang} Trang</div>
                                    </div>
                                    <!-- /.nhan_truyen -->
                                </a>
                            </div>
                        </div>
                        <div class="gioi-thieu2">
                            <div class="tile ">
                                <a href="doctruyen.html">
                                    <div class="nhan_truyen">
                                        <img class="cover" src="/WebSach/static/img/${data[2].img}" alt="cover">
                                        <div class="bottom-shadow"></div>
                                        <div class="captions">
                                            <h3>${data[2].TenSach}</h3>
                                            <h4>${data[2].TenSach}</h4>
                                        </div>
                                        <div class="chapter red">${data[2].SoTrang} trang</div>
                                    </div>
                                    <!-- /.nhan_truyen -->
                                </a>
                            </div>
                    </div>
                        <div class="gioi-thieu1">
                            <div class="tile ">
                                <a href="doctruyen.html">
                                    <div class="nhan_truyen">
                                        <img class="cover" src="/WebSach/static/img/${data[3].img}" alt="cover">
                                        <div class="bottom-shadow"></div>
                                        <div class="captions">
                                            <h3>${data[3].TenSach}</h3>
                                        </div>
                                        <div class="chapter red">${data[3].SoTrang} trang</div>
                                    </div>
                                    <!-- /.nhan_truyen -->
                                </a>
                            </div>
                        <div class="tile ">
                                <a href="doctruyen.html">
                                    <div class="nhan_truyen">
                                        <img class="cover" src="/WebSach/static/img/${data[4].img}" alt="cover">
                                        <div class="bottom-shadow"></div>
                                        <div class="captions">
                                            <h3>${data[4].TenSach}r</h3>
                                        </div>
                                        <div class="chapter red">${data[4].SoTrang} trang</div>
                                    </div>
                                    <!-- /.nhan_truyen -->
                                </a>
                            </div>   
                </div>
                `;
        console.log(data)
        //document.querySelector('.gioi-thieu').innerHTML=danhSach
        
    }

})
$.ajax({
  type:"GET",
  url:"http://localhost:3000/api/user/",
  contentType:"application/json",
  dataType:"json",
  success :function(data){
    console.log(data)
  }
})
