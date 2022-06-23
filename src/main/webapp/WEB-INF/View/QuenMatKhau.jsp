<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/dangnhap.css">
    <title>Quên mật khẩu</title>
</head>

<body >
    <section class="header">
        <div class="logo">
             <a href="${pageContext.request.contextPath}/trangchu"></a>
        </div>
        <div class="div-tim-kiem">
            <input type="text" placeholder="Maria Ozawa" class="thanh-tim-kiem">
            <button class="nut-tim-kiem"><i class="fa-solid fa-magnifying-glass"></i></button>
        </div>
        <div class="div-nut-tim-kiem-an" >
        
        <button class="nut-tim-kiem-res" id="nut-tim-kiem-an"><i class="fa-solid fa-magnifying-glass"></i></button>
    
    </div>
    
        <div class="truycap">
            <a href="/dangnhap" class="nut-dang-nhap">Đăng Nhập</a>
            <a href="/dangky" class="nut-dang-ki">Đăng kí</a>
        </div>
    </section>
    <div class="div-thanh-tim-kiem-an" id="div-thanh-tim-kiem-an">
        <form action="">
            <input type="text" class="thanh-tim-kiem-an">
            
            <button class="nut-tim-kiem"><i class="fa-solid fa-magnifying-glass"></i></button>
    </form>
   </div>
  
    <section class="menu">
        <div  id="menu-lua-chon"><i class="fa-solid fa-bars"></i></div>
        <nav class="lua-chon" id="lua-chon" >
            <div class="chua">
            <div class="ten-lua-chon"> <a href="${pageContext.request.contextPath}/trangchu">Trang chủ</a></div>
            <div class="ten-lua-chon" id="the-loai"> 

                <a>Thể loại <i class="fa-solid fa-angle-down"></i></a>
                <div class="the-loai">
                    <div>
                        <li><a href=""> Kiếm hiệp</a></li>
                        <li><a href="">Tâm lý</a></li>
                        <li><a href="">Lãng mạn</a></li>
                        <li><a href="">NTR</a></li>
                    </div>
                    <div>
                         <li><a href="">Cổ trang </a></li>
                         <li><a href="">Tiểu thuyết</a></li>
                         <li><a href="">Comic</a></li>
                         <li><a href="">Ngôn tình</a></li>
                    </div>
                    <div>
                         <li><a href="">Oneshot</a></li>
                         <li><a href="">Hài kịch</a></li>
                         <li><a href="">Xuyên không</a></li>
                         <li><a href="">Khoa học-viễn tưởng </a></li>
                    </div>
                
            </div>
            </div>
            <div class="ten-lua-chon" id="sap-xep"> 
                    <a >Sắp xếp <i class="fa-solid fa-angle-down"></i></a>
                   <div class="sap-xep">
                    <div>
                        <li><a href="">Top lượt xem</a></li>
                 
                        
                   </div>
                   <div>
                       
                        <li><a href="">Yêu thích </a></li>
                   </div>
                   <div>
                   
                    <li><a href="">Ngày đăng </a></li>
               </div>
                </div>
            </div>

            <div class="ten-lua-chon"><a href="">Lịch sử</a></div>
            <div class="ten-lua-chon" > <a href="">Yêu Thích</a> </div>
            
            <div class="ten-lua-chon"> <a href="">Fanpage</a></div>
        </div>
        </nav>

    </section>


    <!-- From đăng nhập -->
    <section class="from-dang-nhap">
        <div class="dang-nhap">
            <div class="dang-nhap_header">
                <h3 class="dang-nhap_heading">Quên mật khẩu</h3>
            </div>
            <div class="dang-nhap_form">
                <div class="dang-nhap_group">
                    <input type="text" class="dang-nhap_input" id="user-name" placeholder="Username của bạn">
                    <span class="form-message" ></span>
                </div>
                <div class="dang-nhap_group">
                    <input type="text" class="dang-nhap_input" id="email" placeholder="Email của bạn">
                    <span class="form-message" ></span>
                </div>
            </div>
            <div class="nut-dieu-khien">
                <button class="btn btn_dn">Gửi yêu cầu</button>
                <button class="btn btn_tl">Trở lại đăng nhập</button>
            </div>
        </div>
    </section>
    <script src="${pageContext.request.contextPath}/static/js/globalVariable.js"></script>
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/cookies.js"></script>
       <script src="${pageContext.request.contextPath}/static/js/quenmatkhau.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/dataTLHeader.js"></script>
</body>
</html>