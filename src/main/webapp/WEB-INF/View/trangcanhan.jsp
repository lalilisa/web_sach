<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/body.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/trangcanhan.css">
    <link rel="stylesheet" href="/css/header.css">
    <link rel="stylesheet" href="/css/body.css">
    <link rel="stylesheet" href="/css/footer.css">
    <link rel="stylesheet" href="/css/trangcanhan.css">
    <title>Document</title>
</head>

<body >
    <section class="header">
        <div class="logo">
            <a href="home.html"></a>
        </div>
        <div class="div-tim-kiem">
            <input type="text" placeholder="Maria Ozawa" class="thanh-tim-kiem">
            <button class="nut-tim-kiem"><i class="fa-solid fa-magnifying-glass"></i></button>
        </div>
        <div class="div-nut-tim-kiem-an" >
        
        <button class="nut-tim-kiem-res" id="nut-tim-kiem-an"><i class="fa-solid fa-magnifying-glass"></i></button>
    
    </div>
    
    <% 
    int t=1;
         Cookie[] cookies = null;
         cookies = request.getCookies();

     String token="";
     for(Cookie i : cookies) {
         if(i.getName().equalsIgnoreCase("token")) {
                 token=i.getValue();
         }
     }
     String username=""; 
     Token jwt=new Token();
     boolean decode=false;
     
     try{
         username=jwt.getUserNameFromJwtToken(token);
         decode=true;
     }
     catch(Exception e){
             decode=false;
     }
     
     
     if(decode){%>
     <div class="truycap">
                <a href="${pageContext.request.contextPath}/dangnhap" class="nut-dang-nhap"><%=username%></a>
                <a  onclick="dangxuat()" class="nut-dang-ki">????ng Xu???t</a>
     </div>
     <%} else {%>
      <div class="truycap">
            <a href="${pageContext.request.contextPath}/dangnhap" class="nut-dang-nhap">????ng Nh???p</a>
         <a href="${pageContext.request.contextPath}/dangky" class="nut-dang-ki">????ng k??</a>
         
     </div>
     <% }%>
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
            <div class="ten-lua-chon"> <a href="">Trang ch???</a></div>
            <div class="ten-lua-chon" id="the-loai"> 

                <a>Th??? lo???i <i class="fa-solid fa-angle-down"></i></a>
                <div class="the-loai">
                    <div>
                        <li><a href=""> Ki???m hi???p</a></li>
                        <li><a href="">T??m l??</a></li>
                        <li><a href="">L??ng m???n</a></li>
                        <li><a href="">NTR</a></li>
                    </div>
                    <div>
                         <li><a href="">C??? trang </a></li>
                         <li><a href="">Ti???u thuy???t</a></li>
                         <li><a href="">Comic</a></li>
                         <li><a href="">Ng??n t??nh</a></li>
                    </div>
                    <div>
                         <li><a href="">Oneshot</a></li>
                         <li><a href="">H??i k???ch</a></li>
                         <li><a href="">Xuy??n kh??ng</a></li>
                         <li><a href="">Khoa h???c-vi???n t?????ng </a></li>
                    </div>
                
            </div>
            </div>
            <div class="ten-lua-chon" id="sap-xep"> 
                    <a >S???p x???p <i class="fa-solid fa-angle-down"></i></a>
                   <div class="sap-xep">
                    <div>
                        <li><a href="">Top ng??y</a></li>
                        <li><a href="">Top tu???n</a></li>
                        
                   </div>
                   <div>
                        <li><a href="">Top th??ng</a></li>
                        <li><a href="">Y??u th??ch </a></li>
                   </div>
                   <div>
                    <li><a href="">M???i update</a></li>
                    <li><a href="">Ng??y ????ng </a></li>
               </div>
                </div>
            </div>
            <div class="ten-lua-chon"><a href="">Con G??i</a></div>
            <div class="ten-lua-chon"><a href="">Con Trai</a></div>
            <div class="ten-lua-chon"> <a href="">T??m truy???n</a></div>
            <div class="ten-lua-chon"><a href="">L???ch s???</a></div>
            <div class="ten-lua-chon" > <a href="">Theo d??i</a> </div>
            <div class="ten-lua-chon" > <a href="">Th???o lu???n</a></div>
            <div class="ten-lua-chon"> <a href="">Fanpage</a></div>
        </div>
        </nav>

    </section>
   
    <section class="canhan">
        <div class="lua-chon-thong-tin">
           <a  onclick="thongTinCaNhan()">Th??ng tin c?? nh??n</a>
           <a onclick="doiMatKhau()">?????i m???t kh???u</a>
        </div>
        <div class="noi-dung-lua-chon" id="thong-tin-ca-nhan">
            <h1>Th??ng tin c?? nh??n</h1>
            <div class="anh-dai-dien">
            <form action="" enctype="multipart/form-data">
                <!-- <img src="./img/anhtruyen.jpg" alt=""> -->
                 
            </div>
            <label for=""></label>
			
			
			<label for="">Username1</label>
            <div class="nhap-thong-tin ten-dang-nhap" >
               
                <input type="text" id="ten-dang-nhap"  readonly>
            </div>
            
            <label for="">H??? v?? t??n</label>
            <div class="nhap-thong-tin vai-tro"  >
               
                <input type="text" id="ho-ten">
            </div>
            <label for="">Email</label>
            <div class="nhap-thong-tin email" >
                <input type="text" id="email">
            </div>
            <label for="">Gi???i t??nh</label>
            <div class="nhap-thong-tin gioi-tinh" >
               
                <select name="" id="gioi-tinh">
                    <option value="1">Nam</option>
                    <option value="0">N???</option>
                </select>
            </div>

            <div class="nut-luu">
                <button> L??u</button>
            </div>
        </form>
        </div>
        <div class="noi-dung-lua-chon" id="doi-mat-khau">
            <h1>?????i m???t kh???u</h1>

            <label for=""></label>

            <label for="">M???t kh???u c??</label>
            <div class="nhap-thong-tin">
               
                <input type="password" id="mat-khau-cu">
            </div>
            <label for="">M???t kh???u m???i</label>
            <div class="nhap-thong-tin">
                <input type="password" id="mat-khau-moi">
            </div>
            <label for="">X??c Nh???n M???t kh???u m???i</label>
            <div class="nhap-thong-tin">
                <input type="password" id="xac-nhan-mat-khau-moi">
            </div>
        

            <div class="nut-luu-mat-khau">
                <button> L??u</button>
            </div>
        </div>
    </section>

    <!-- Footer -->
    <footer class="footer">
        <div class="can-giua">
            <div class="trai">
                <p class="logo" itemscope="" itemtype="http://schema.org/Organization">
                    <a itemprop="url" href="/">
                    <img itemprop="logo" src="http://st.truyenqqpro.com/template/frontend/images/logo.png" alt="TruyenQQ - Truy???n tranh Online">
                    </a>
                </p>
                <p class="link">Email: ad.truyenqq@gmail.com</p>
            </div>
            <div class="phai">
                <ul>
                    <li><a href="/the-loai/chuyen-sinh-91.html">Chuy???n Sinh</a></li>
                    <li><a href="/the-loai/manhwa-49.html">Manhwa</a></li>
                    <li><a href="/the-loai/manhua-35.html">Hanhua</a></li>
                    <li><a href="/the-loai/dam-my-93.html">??am M???</a></li>
                    <li><a href="/the-loai/romance-36.html">Romance</a></li>
                    <li><a href="/the-loai/ngon-tinh-87.html">Ng??n T??nh</a></li>
                    <li><a href="/the-loai/co-dai-90.html">C??? ?????i</a></li>
                    <li><a href="/the-loai/xuyen-khong-88.html">Xuy??n Kh??ng</a></li>
                    <li><a href="/the-loai/fantasy-30.html">Fantasy</a></li>
                    <div class="clear"></div>
                </ul>
                <p>M???i th??ng tin v?? h??nh ???nh tr??n website ?????u ???????c s??u t???m tr??n Internet. Ch??ng t??i kh??ng s??? h???u hay ch???u tr??ch nhi???m b???t k??? th??ng tin n??o tr??n web n??y. N???u l??m ???nh h?????ng ?????n c?? nh??n hay t??? ch???c n??o, khi ???????c y??u c???u, ch??ng t??i s??? xem x??t v?? g??? b??? ngay l???p t???c.</p>
            </div>
        
        </div>
    </footer>
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/suaThongTinUser.js">
    </script>
	
    <script>
                function passFileUrl(){
            document.getElementById('asgnmnt_file').click();
        }
    
        function thongTinCaNhan(){
            document.getElementById('thong-tin-ca-nhan').style.display='block'
            document.getElementById('doi-mat-khau').style.display='none'
        }
        function doiMatKhau(){
            document.getElementById('thong-tin-ca-nhan').style.display='none'
            document.getElementById('doi-mat-khau').style.display='block'
        }
    </script>
</body>
</html>