<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="tach.web.model.TheLoai"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/ThemTruyen.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/admin.css">
    
</head>
<body>
    <div class="admin-header">
        <div class="tieu-de">
            <p>Xin chào Admin</p>
        </div>
        <ul class="thao-tac">
            <li><a href="">Trang chủ</a></li>
            <li><a href="">Đăng xuất</a></li>
        </ul>
    </div>

    <div class="can_giua">
    <div class="admin-page">
        <div class="menu">
            <p>Tổng quan</p>
            <ul class="danh-sach">
                <li><a href="${pageContext.request.contextPath}/admin/danhsachtruyen">Danh sách truyện</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/themtruyen">Thêm truyện</a></li>
                <li><a href="DSNguoiDung.html">Danh sách người dùng</a></li>
            </ul>
        </div>
    
        <div class="content">            
            <!-- Thêm truyện -->
            <form enctype="multipart/form-data" id="form_dang_truyen">
            <div class="them-truyen">
                <h2>Thêm trang</h2>
                <button>Trở về</button>
                <div class="gioi-thieu">
                    <div class="ten-truyen">
                        <p> Trang</p>
                        <input type="text" name="trang" id="trang">
                    </div>
                  
                    
                </div>
             

                       
                <div class="tai-file">
                    <p>Tải file</p>
                    <input type="file" id="ajaxfile" name="file" />
                    <div class="tinh-trang">
                        <button id="them_sach">Đăng Trang</button>
                    </div>
                </div>
             
                <div class="the-loai">
                    
                </div>
            </div>
        </div>
        </form>
    </div>
    </div>
	  <script src="${pageContext.request.contextPath}/static/js/globalVariable.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
      <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery.form/3.51/jquery.form.min.js"></script>
    	    <script src="${pageContext.request.contextPath}/static/js/dangtrang.js"></script>
  
    <script>
        function huy(){
            document.getElementById('lua_chon').classList.remove('active');
        }
        $("#the_loai").focus(function(){
            console.log("tritir")
            const listTheLoai=document.querySelectorAll('.the_loai ul li');
            document.getElementById('lua_chon').classList.toggle('active');
            for(let i=0;i<listTheLoai.length;i++){
                listTheLoai[i].onclick=function(){
                    console.log("Clicked")
                    const list = document.querySelector('.chon_the_loai')
                    const newNode = document.createElement("span");
                    // Create a text node:
                    const textNode = document.createTextNode(listTheLoai[i].getAttribute('the_loai'));
                    // Append text node to "li" element:
                    newNode.appendChild(textNode);
                    newNode.setAttribute('id_theloai',listTheLoai[i].getAttribute('id_theloai'))
                    newNode.setAttribute('the_loai',listTheLoai[i].getAttribute('the_loai'))
                    list.insertBefore(newNode, document.getElementById('the_loai'));
                    if(document.getElementById('lua_chon').classList.contains('active'))
                        document.getElementById('lua_chon').classList.remove('active')
                    // console.log(index);
                    // console.log();
                }
            }
            })
             
             

        
        // $("#the_loai").focusout(function(){
        //     document.getElementById('lua_chon').classList.remove('active')

        // })
    </script>
    <script>

    </script>
</body>
</html>