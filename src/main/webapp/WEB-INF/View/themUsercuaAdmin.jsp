<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
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
                <li><a href="http://localhost:8080/WebSach/admin/danhsachtruyen">Danh sách truyện</a></li>
                <li><a href="http://localhost:8080/WebSach/admin/themtruyen">Thêm truyện</a></li>
                <li><a href="http://localhost:8080/WebSach/admin/users">Danh sách người dùng</a></li>
                <li><a href="http://localhost:8080/WebSach/admin/themUser">Thêm người dùng</a></li>
            </ul>
        </div>
        <div class="content">            
            <!-- Thêm truyện -->
            <div class="them-truyen">
                <h2>Thêm truyện</h2>
                <button>Trở về</button>
                <div class="gioi-thieu">
                    <div class="ten-truyen">
                        <p>Username</p>
                        <input type="text" id="ten-dang-nhap">
                    </div>
                    <div class="tac-gia">
                        <p>Password</p>
                        <input type="text" name="" id="mat-khau">
                    </div>
                    
                </div>
                <div class="gioi-thieu">
                    <div class="ten-truyen">
                        <p>Họ và Tên</p>
                        <input type="text" id="ho-ten">
                    </div>
                    <div class="tac-gia">
                        <p>Email</p>
                        <input type="text" name="" id="email">
                    </div>
                    
                </div>
                <div class="the_loai">
                    <p>Vai Trò</p>
                   
                    <select name="" id="vai-tro">

                      <option value="0">User</option>
                      <option value="1">Admin</option>
                    </select>
                   
					<p>Giới tính</p>
                    <select name="" id="gioi-tinh">

                      <option value="1">Nam</option>
                      <option value="0">Nữ</option>
                    </select>
                </div>

                <div class="tai-file">
                 
                    <div class="tinh-trang">
                        <input type="button" value="Lưu" class="them-user">
                    </div>
                </div>
                <div class="the-loai">
                    
                </div>
            </div>
        </div>
    </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
     		<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery.form/3.51/jquery.form.min.js"></script>
            <script src="${pageContext.request.contextPath}/static/js/themUserAdmin.js"></script>
</body>
</html>
