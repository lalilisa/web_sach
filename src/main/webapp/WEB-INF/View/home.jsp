<%@page import="tach.web.jwt.Token"%>
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
    <title>Trang chủ</title>
</head>

<body >


    <section class="header">
        <div class="logo">
            <a href="${pageContext.request.contextPath}/trangchu"></a>
        </div>
        <div class="div-tim-kiem">
            <input type="text" placeholder="Maria Ozawa" class="thanh-tim-kiem" id="nhap-tim-kiem">
            <button class="nut-tim-kiem" onclick="timkiem()"><i class="fa-solid fa-magnifying-glass"></i></button>
        </div>
        <div class="div-nut-tim-kiem-an" >
        
        <button class="nut-tim-kiem-res" id="nut-tim-kiem-an" onclick="timkiem()"><i class="fa-solid fa-magnifying-glass"></i></button>
    
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
                       
                        <li><a href="${pageContext.request.contextPath}/truyenyeuthich">Yêu thích </a></li>
                   </div>
                   <div>
                   
                    <li><a href="">Ngày đăng </a></li>
               </div>
                </div>
            </div>

            <div class="ten-lua-chon"><a href="${pageContext.request.contextPath}/lichsudoc">Lịch sử</a></div>
            <div class="ten-lua-chon" > <a href="${pageContext.request.contextPath}/truyenyeuthich">Yêu Thích</a> </div>
            
            <div class="ten-lua-chon"> <a href="">Fanpage</a></div>
        </div>
        </nav>

    </section>
    <div class="noi-dung">
        <div class="can-giua">
            <div class="noi-dung-chinh">
                <section class="mo-dau">
                    <div class="gioi-thieu">
                        <div class="gioi-thieu1">
                            <div class="tile ">
                                <a href="doctruyen.html">
                                    <div class="nhan_truyen">
                                        <img class="cover" src="http://i.truyenvua.com/slider/290x191/slider_1560493497.jpg?r=r8645456" alt="cover">
                                        <div class="bottom-shadow"></div>
                                        <div class="captions">
                                            <h3>Black Clover</h3>
                                        </div>
                                        <div class="chapter red">Chương 327</div>
                                    </div>
                                    <!-- /.nhan_truyen -->
                                </a>
                            </div>
                            <div class="tile ">
                                <a href="doctruyen.html">
                                    <div class="nhan_truyen">
                                        <img class="cover" src="http://i.truyenvua.com/slider/290x191/slider_1560493497.jpg?r=r8645456" alt="cover">
                                        <div class="bottom-shadow"></div>
                                        <div class="captions">
                                            <h3>Black Clover</h3>
                                        </div>
                                        <div class="chapter red">Chương 327</div>
                                    </div>
                                    <!-- /.nhan_truyen -->
                                </a>
                            </div>
                        </div>
                        <div class="gioi-thieu2">
                            <div class="tile ">
                                <a href="doctruyen.html">
                                    <div class="nhan_truyen">
                                        <img class="cover" src="http://i.truyenvua.com/slider/290x191/slider_1560493497.jpg?r=r8645456" alt="cover">
                                        <div class="bottom-shadow"></div>
                                        <div class="captions">
                                            <h3>Black Clover</h3>
                                            <h4>Black Clover</h4>
                                        </div>
                                        <div class="chapter red">Chương 327</div>
                                    </div>
                                    <!-- /.nhan_truyen -->
                                </a>
                            </div>
                    </div>
                        <div class="gioi-thieu1">
                            <div class="tile ">
                                <a href="doctruyen.html">
                                    <div class="nhan_truyen">
                                        <img class="cover" src="http://i.truyenvua.com/slider/290x191/slider_1560493497.jpg?r=r8645456" alt="cover">
                                        <div class="bottom-shadow"></div>
                                        <div class="captions">
                                            <h3>Black Clover</h3>
                                        </div>
                                        <div class="chapter red">Chương 327</div>
                                    </div>
                                    <!-- /.nhan_truyen -->
                                </a>
                            </div>
                        <div class="tile ">
                                <a href="doctruyen.html">
                                    <div class="nhan_truyen">
                                        <img class="cover" src="http://i.truyenvua.com/slider/290x191/slider_1560493497.jpg?r=r8645456" alt="cover">
                                        <div class="bottom-shadow"></div>
                                        <div class="captions">
                                            <h3>Black Clover</h3>
                                        </div>
                                        <div class="chapter red">Chương 327</div>
                                    </div>
                                    <!-- /.nhan_truyen -->
                                </a>
                            </div>   
                </div>
                </section>

                <div class="show-sach">
                    <h2>Sách mới cập nhật</h2>
                    <div class="danh-sach-sach">
                <ul class="chua-sach" id="chua-sach">
                <li>
                    <div class="anh_sach">
                    <a href="motatruyen.html"><img class="center" src="http://i.truyenvua.com/ebook/190x247/om-khan-tieu-ma-giap-cua-toi_1644148715.jpg?r=r8645456" alt="Ôm Khẩn Tiểu Mã Giáp Của Tôi" style=""></a>

                    <div class="thongtin_sach">
                        <div class="ten_sach qtip" data-qtip="#truyen-tranh-12139">
                            <h3><a title="Ôm Khẩn Tiểu Mã Giáp Của Tôi" href="motatruyen.html">Ôm Khẩn Tiểu Mã Giáp Của Tôi</a></h3>
                        </div>

                        <div class="trang_cuoi">
                                                    <a href="motatruyen.html-chap-66.html" title="Chapter 66">Chapter 66</a>
                                            </div>
                    </div>
                </li>
                <li>
                    <div class="anh_sach">
                    <a href="motatruyen.html"><img class="center" src="http://i.truyenvua.com/ebook/190x247/om-khan-tieu-ma-giap-cua-toi_1644148715.jpg?r=r8645456" alt="Ôm Khẩn Tiểu Mã Giáp Của Tôi" style=""></a>

                    <div class="thongtin_sach">
                        <div class="ten_sach qtip" data-qtip="#truyen-tranh-12139">
                            <h3><a title="Ôm Khẩn Tiểu Mã Giáp Của Tôi" href="motatruyen.html">Ôm Khẩn Tiểu Mã Giáp Của Tôi</a></h3>
                        </div>

                        <div class="trang_cuoi">
                                                    <a href="motatruyen.html-chap-66.html" title="Chapter 66">Chapter 66</a>
                                            </div>
                    </div>
                </li>
                <li>
                    <div class="anh_sach">
                    <a href="motatruyen.html"><img class="center" src="http://i.truyenvua.com/ebook/190x247/om-khan-tieu-ma-giap-cua-toi_1644148715.jpg?r=r8645456" alt="Ôm Khẩn Tiểu Mã Giáp Của Tôi" style=""></a>

                    <div class="thongtin_sach">
                        <div class="ten_sach qtip" data-qtip="#truyen-tranh-12139">
                            <h3><a title="Ôm Khẩn Tiểu Mã Giáp Của Tôi" href="motatruyen.html">Ôm Khẩn Tiểu Mã Giáp Của Tôi</a></h3>
                        </div>

                        <div class="trang_cuoi">
                                                    <a href="motatruyen.html-chap-66.html" title="Chapter 66">Chapter 66</a>
                                            </div>
                    </div>
                </li>
                <li>
                    <div class="anh_sach">
                    <a href="motatruyen.html"><img class="center" src="http://i.truyenvua.com/ebook/190x247/om-khan-tieu-ma-giap-cua-toi_1644148715.jpg?r=r8645456" alt="Ôm Khẩn Tiểu Mã Giáp Của Tôi" style=""></a>

                    <div class="thongtin_sach">
                        <div class="ten_sach qtip" data-qtip="#truyen-tranh-12139">
                            <h3><a title="Ôm Khẩn Tiểu Mã Giáp Của Tôi" href="motatruyen.html">Ôm Khẩn Tiểu Mã Giáp Của Tôi</a></h3>
                        </div>

                        <div class="trang_cuoi">
                                                    <a href="motatruyen.html-chap-66.html" title="Chapter 66">Chapter 66</a>
                                            </div>
                    </div>
                </li>
                <li>
                    <div class="anh_sach">
                    <a href="motatruyen.html"><img class="center" src="http://i.truyenvua.com/ebook/190x247/om-khan-tieu-ma-giap-cua-toi_1644148715.jpg?r=r8645456" alt="Ôm Khẩn Tiểu Mã Giáp Của Tôi" style=""></a>

                    <div class="thongtin_sach">
                        <div class="ten_sach qtip" data-qtip="#truyen-tranh-12139">
                            <h3><a title="Ôm Khẩn Tiểu Mã Giáp Của Tôi" href="motatruyen.html">Ôm Khẩn Tiểu Mã Giáp Của Tôi</a></h3>
                        </div>

                        <div class="trang_cuoi">
                                                    <a href="motatruyen.html-chap-66.html" title="Chapter 66">Chapter 66</a>
                                            </div>
                    </div>
                </li>
                <li>
                    <div class="anh_sach">
                    <a href="motatruyen.html"><img class="center" src="http://i.truyenvua.com/ebook/190x247/om-khan-tieu-ma-giap-cua-toi_1644148715.jpg?r=r8645456" alt="Ôm Khẩn Tiểu Mã Giáp Của Tôi" style=""></a>

                    <div class="thongtin_sach">
                        <div class="ten_sach qtip" data-qtip="#truyen-tranh-12139">
                            <h3><a title="Ôm Khẩn Tiểu Mã Giáp Của Tôi" href="motatruyen.html">Ôm Khẩn Tiểu Mã Giáp Của Tôi</a></h3>
                        </div>

                        <div class="trang_cuoi">
                                                    <a href="motatruyen.html-chap-66.html" title="Chapter 66">Chapter 66</a>
                                            </div>
                    </div>
                </li>
                                <li>
                    <div class="anh_sach">
                    <a href="motatruyen.html"><img class="center" src="http://i.truyenvua.com/ebook/190x247/om-khan-tieu-ma-giap-cua-toi_1644148715.jpg?r=r8645456" alt="Ôm Khẩn Tiểu Mã Giáp Của Tôi" style=""></a>

                    <div class="thongtin_sach">
                        <div class="ten_sach qtip" data-qtip="#truyen-tranh-12139">
                            <h3><a title="Ôm Khẩn Tiểu Mã Giáp Của Tôi" href="motatruyen.html">Ôm Khẩn Tiểu Mã Giáp Của Tôi</a></h3>
                        </div>

                        <div class="trang_cuoi">
                                                    <a href="motatruyen.html-chap-66.html" title="Chapter 66">Chapter 66</a>
                                            </div>
                    </div>
                </li>
                </ul>

                    </div>
                </div>
            </div>
            <div class="load-truyen">
                    
            </div>
        </div>
    </div>


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

    <script>
      var chatbox = document.getElementById('fb-customer-chat');
      chatbox.setAttribute("page_id", "111025784940642");
      chatbox.setAttribute("attribution", "biz_inbox");
    </script>

    <!-- Your SDK code -->
   <div id="fb-root"></div>

      <!-- Your Plugin chat code -->
      <div id="fb-customer-chat" class="fb-customerchat">
      </div>
          <script>
        window.fbAsyncInit = function() {
          FB.init({
            xfbml            : true,
            version          : 'v14.0'
          });
        };
  
        (function(d, s, id) {
          var js, fjs = d.getElementsByTagName(s)[0];
          if (d.getElementById(id)) return;
          js = d.createElement(s); js.id = id;
          js.src = 'https://connect.facebook.net/en_US/sdk/xfbml.customerchat.js';
          fjs.parentNode.insertBefore(js, fjs);
        }(document, 'script', 'facebook-jssdk'));
      </script>
     <script src="${pageContext.request.contextPath}/static/js/globalVariable.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/index.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/trangchu.js"></script>
     <script src="${pageContext.request.contextPath}/static/js/dataTLHeader.js"></script>
     <script src="${pageContext.request.contextPath}/static/js/searchingTheLoai.js"></script>
    
</body>
</html>