const gui=document.querySelector(".btn.btn_dn");
const vedn=document.querySelector(".btn.btn_tl");
const email=document.querySelector("#email");
const user=document.querySelector("#user-name");

// dsinput.forEach((giatri,sott) => {
//     giatri.onblur=function(){
//         console.log(this.id);
//     }
// });

vedn.onclick = function(){
    document.location.href = "${contextPath}/dangnhap";
}

gui.onclick=function(){
    ktemail();
    ktuser();

    if (ktemail()==1 && ktuser()==1){
        var taikhoan = {
            "Email": email.value,
            "Username": user.value
        };
        $.ajax({
            headers: {
              Accept: "application/json",
              "Content-Type": "application/json"
            },
            type: "POST",
            url: `${contextPath}/api/quenmatkhau`,
            data: JSON.stringify(taikhoan),
            success: function (result) {
                alert(result);
            }
          });
    }
}   


function ktemail(){
    var kte=email.parentElement.querySelector('.form-message');
    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/; 
    if(email.value==''){
        kte.innerHTML="Email không được để trống";
    }
    else if (!filter.test(email.value)) { 
        kte.innerHTML="Email không hợp lệ";
    }
    else{
        kte.innerHTML=null;
        return 1;
    }
}

function ktuser(){
    var ktu=user.parentElement.querySelector('.form-message');
    if (user.value == ''){
        ktu.innerHTML = 'Tên đăng nhập ko được để trống ';

    } 
    else if ((user.value.length > 0 && user.value.length < 3) || user.value.length > 10){
        ktu.innerHTML = 'Tên đăng nhập từ 3-10 kí tự ';
    } 
    else{
        ktu.innerHTML=null;
        return 1;
    }
}

