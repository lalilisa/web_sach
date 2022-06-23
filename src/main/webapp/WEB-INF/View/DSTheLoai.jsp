<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/DSNguoiDung.css">
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
    <div class="admin-page">
        <div class="menu">
            <p>Tổng quan</p>
            <ul class="danh-sach">
                <li><a href="DSTruyen.html">Danh sách truyện</a></li>
                <li><a href="ThemTruyen.html">Thêm truyện</a></li>
                <li><a href="DSNguoiDung.html">Danh sách người dùng</a></li>
            </ul>
        </div>
        <div class="content">
            <div class="danh-sach-nguoi-dung">
                <h1>Danh sách thể loại</h1>
                <div class="themTL">
                    <input type="text" name="" id="" placeholder="Nhập tên thể loại">
                    <button>Thêm</button>
                </div>
                <div class="bang-sua-nguoi-dung">
                    <table class="bang-nguoi-dung">
                        <thead>
                        </thead>
                    </table>
                </div>
            </div>
            
           
        </div>

    </div>
    <style>
    </style>
    <script src="${pageContext.request.contextPath}/static/js/globalVariable.js"></script>
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/cookies.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/theloai.js"></script>
    
</body>
</html>