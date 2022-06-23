const thembtn = document.querySelector(".themTL button");
const theloai = document.querySelector(".themTL input");

window.onload = function(){
    $.ajax({
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
          Authorization: "Bearer " + getCookie("token")
        },
        type: "GET",
        url: `${contextPath}/api/theloai`,
        success: function (result) {
            let content = ` <tr>
                                <th width="75">ID thể loại</th>
                                <th width="300">Tên thể loại</th>                                
                                <th width="150"></th>
                            </tr>`;
            result.forEach(element => {
                content += `<tr>
                                <td width="75">${element.ID_TheLoai}</td>
                                <td width="300">${element.TenTheLoai}</td>
                                <td width="150">
                                    <input onclick=xoaTL(${element.ID_TheLoai}) type="button" value="Xóa">
                                </td>
                            </tr>`;
            });
            document.querySelector(".bang-nguoi-dung thead").innerHTML = content;
        }
      });
}

thembtn.onclick = function(){
    if(theloai.value==''){
        theloai.focus();
    }
    else{
        var tlmoi = {
            "TenTheLoai" : theloai.value
        }
        $.ajax({
            headers: {
              Accept: "application/json",
              "Content-Type": "application/json",
              Authorization: "Bearer " + getCookie("token")
            },
            type: "POST",
            url: `${contextPath}/api/theloai`,
            data: JSON.stringify(tlmoi),
            success: function (result) {
                alert(result!=null? "Thêm thành công":"Có lỗi xảy ra");
            }
          });
    }
}

function xoaTL(id){
    if(confirm("Xoá thể loại?")){
        $.ajax({
            headers: {
              Accept: "application/json",
              "Content-Type": "application/json",
              Authorization: "Bearer " + getCookie("token")
            },
            type: "DELETE",
            url: `${contextPath}/api/theloai?id=${id}`,
            success: function (result) {
                alert(result);
            }
          });
    }
}