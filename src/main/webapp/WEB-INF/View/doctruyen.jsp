<%@page import="tach.web.jwt.Token"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
  
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/header.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/footer.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/doctruyen.css" />
    <title>Document</title>
</head>

<body >
    <!-- Header -->
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
                        <a  onclick="dangxuat()" class="nut-dang-ki">Đăng Xuất</a>
        </div>
        <%} else {%>
         <div class="truycap">
       		<a href="${pageContext.request.contextPath}/dangnhap" class="nut-dang-nhap">Đăng Nhập</a>
            <a href="${pageContext.request.contextPath}/dangky" class="nut-dang-ki">Đăng kí</a>
            
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


    <!-- Content -->
    <section class="phan-than-trang">
        <div class="noi-dung-than-trang">
            <div class="thanh-chuyen-chuong">
            

                <div class="tieu-de-truyen">
                    <a href="#" class="ten-truyen"></a>
                    
                    <span class="chuong-truyen"></span>
                </div>

<!--                 <div class="huong-dan-phim-tat">
                    <i class="fa-solid fa-circle-info"></i>
                    <span class="thong-tin-phim-tat">Sử dụng mũi tên trái 
                        <i class="fa-solid fa-arrow-left-long"></i>
                        hoặc phải
                        <i class="fa-solid fa-arrow-right-long"></i>
                        để chuyển chapter
                    </span>
                </div> -->

                <div class="nut-chuyen-trang">
<!--                     <a href="#" class="nut">
                        <span>
                            <i class="fa-solid fa-arrow-left"></i>
                            Chap trước
                        </span>
                    </a>
                    <a href="#" class="nut">
                        <span>
                            Chap sau
                            <i class="fa-solid fa-arrow-right"></i> -->
                        </span>
                    </a>
                </div>
            </div>

            <div class="noi-dung-chuyen" id="noi-dung-chuyen">
                <img src="http://tintruyen.net/10622/fix-68/0.jpg?d=dfgd6546" alt="">
                <img src="http://tintruyen.net/10622/fix-68/1.jpg?d=dfgd6546" alt="">
                <img src="http://tintruyen.net/10622/fix-68/2.jpg?d=dfgd6546" alt="">
                <img src="http://tintruyen.net/10622/fix-68/3.jpg?d=dfgd6546" alt="">
                <img src="http://tintruyen.net/10622/fix-68/4.jpg?d=dfgd6546" alt="">
                <img src="http://tintruyen.net/10622/fix-68/5.jpg?d=dfgd6546" alt="">
            </div>

            <div class="thanh-chuyen-chuong">
                <div class="nut-chuyen-trang">
<!--                     <a href="#" class="nut">
                        <span>
                            <i class="fa-solid fa-arrow-left"></i>
                            Chap trước
                        </span>
                    </a>
                    <a href="#" class="nut">
                        <span>
                            Chap sau
                            <i class="fa-solid fa-arrow-right"></i>
                        </span>
                    </a> -->
                </div>
              
            </div>

     
    </section>

  

    <a href="#" class="nut-ve-dau-trang">
        <i class="fa-solid fa-angle-up"></i>
    </a>
    <!-- Footer -->
    <footer class="footer">
        <div class="can-giua">
            <div class="trai">
                <p class="logo" itemscope="" itemtype="http://schema.org/Organization">
                    <a itemprop="url" href="/">
                    <img itemprop="logo" src="http://st.truyenqqpro.com/template/frontend/images/logo.png" alt="TruyenQQ - Truyện tranh Online">
                    </a>
                </p>
                <p class="link">Email: ad.truyenqq@gmail.com</p>
            </div>
            <div class="phai">
                <ul>
                    <li><a href="/the-loai/chuyen-sinh-91.html">Chuyển Sinh</a></li>
                    <li><a href="/the-loai/manhwa-49.html">Manhwa</a></li>
                    <li><a href="/the-loai/manhua-35.html">Hanhua</a></li>
                    <li><a href="/the-loai/dam-my-93.html">Đam Mỹ</a></li>
                    <li><a href="/the-loai/romance-36.html">Romance</a></li>
                    <li><a href="/the-loai/ngon-tinh-87.html">Ngôn Tình</a></li>
                    <li><a href="/the-loai/co-dai-90.html">Cổ Đại</a></li>
                    <li><a href="/the-loai/xuyen-khong-88.html">Xuyên Không</a></li>
                    <li><a href="/the-loai/fantasy-30.html">Fantasy</a></li>
                    <div class="clear"></div>
                </ul>
                <p>Mọi thông tin và hình ảnh trên website đều được sưu tầm trên Internet. Chúng tôi không sở hữu hay chịu trách nhiệm bất kỳ thông tin nào trên web này. Nếu làm ảnh hưởng đến cá nhân hay tổ chức nào, khi được yêu cầu, chúng tôi sẽ xem xét và gỡ bỏ ngay lập tức.</p>
            </div>
        
        </div>
    </footer>
    	<script src="${pageContext.request.contextPath}/static/js/globalVariable.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
     <script src="${pageContext.request.contextPath}/static/js/index.js"></script>

    <script src="${pageContext.request.contextPath}/static/js/doctruyen.js"></script>
     <script src="${pageContext.request.contextPath}/static/js/dataTLHeader.js"></script>
</body>
</html>