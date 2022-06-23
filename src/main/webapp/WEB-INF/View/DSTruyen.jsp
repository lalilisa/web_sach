<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/DSTruyen.css">
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
                <li><a href="${pageContext.request.contextPath}/admin/danhsachtruyen">Danh sách truyện</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/themtruyen">Thêm truyện</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/users">Danh sách người dùng</a></li>
            </ul>
        </div>
        <div class="content">
            <div class="danh-sach-truyen">
                <h1>Danh sách truyện</h1>
                <div class="tim-kiem">
                    <input type="text" name="" id="" placeholder="Nhập tên truyện">
                    <button>Tìm kiếm</button>
                </div>
                <div class="bang-sua-truyen">
                    <table class="bang-truyen">
                        <thead>
                            <colgroup>
                                <col width="45" >
                                <col width="250">
                                <col width="200">
                                <col width="200">
                                <col width="100">
                                <col width="100">
                            </colgroup>
                            <tbody id="ds_truyen">
                            <tr>
                                <th>ID</th>
                                <th>Tên Sách</th>
                                <th>Tác giả</th>
                                <th>Thể loại</th>
                                <th>Chaps</th>
                                <th>Thêm/Xóa</th>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>Vua Hải Tặc; One Piece; OnePiece</td>
                                <td>Eiichiro Oda</td>
                                <td>Action</td>
                                <td>1045</td>
                                <td>
                                    <button>Thêm</button>
                                    <button>Xóa</button>
                                </td>
                            </tr>
                            </tbody>
                        </thead>
                    </table>
                </div>
            </div>
        </div>

    </div>
    		<script src="${pageContext.request.contextPath}/static/js/globalVariable.js"></script>
    		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
     		<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery.form/3.51/jquery.form.min.js"></script>
            <script src="${pageContext.request.contextPath}/static/js/danhsachtruyen.js"></script>
            
</body>
</html>