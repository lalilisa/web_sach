
const dsinput=document.querySelector(".dang-ky_input")
const dangky=document.querySelector(".btn.btn_dk");
const email=document.querySelector("#email");
const username=document.querySelector("#user-name");
const ps=document.querySelector("#password");
const nlps=document.querySelector("#nhap-lai-password");

// dsinput.forEach((giatri,sott) => {
//     giatri.onblur=function(){
//         console.log(this.id);
//     }
// });


dangky.onclick=function(){

    ktemail();
    ktuser();
    ktpassword();
    ktnlps();

    if(ktemail()==1 && ktuser()==1 && ktpassword()==1 && ktnlps()==1){
        var taikhoan = {
            "Username": username.value,
            "Email": email.value,
            "Password": ps.value
        };
        $.ajax({
            headers: {
              Accept: "application/json",
              "Content-Type": "application/json"
            },
            type: "POST",
            url: `${contextPath}/api/dangky`,
            data: JSON.stringify(taikhoan),
            success: function (result) {
                console.log(result);
                if (result=="Dang ky that bai!!!")
                    alert(result);
                else{
                    alert("Đăng ký tài khoản thành công");
                }
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
    var ktu=username.parentElement.querySelector('.form-message');
    if (username.value == ''){
        ktu.innerHTML = 'Tên đăng nhập ko được để trống ';

    } 
    else if ((username.value.length > 0 && username.value.length < 3) || username.value.length > 10){
        ktu.innerHTML = 'Tên đăng nhập từ 3-10 kí tự ';
    } 
    else{
        ktu.innerHTML=null;
        return 1;
    }
}

function ktpassword(){
    var ktp=ps.parentElement.querySelector('.form-message');
    if(ps.value==''){
        ktp.innerHTML="Mật khẩu không được để trống";
    }
    else if((ps.value.length > 0 && ps.value.length < 6) || ps.value.length > 15){
        ktp.innerHTML="Mật khẩu có độ dài từ 6-15 ký tự";
    }
    else{
        ktp.innerHTML=null;
        return 1;
    }
}

function ktnlps(){
    var ktnlp=nlps.parentElement.querySelector('.form-message');
    if(nlps.value!=ps.value ){
        ktnlp.innerHTML="Mật khẩu không khớp";
    }
    else{
        ktnlp.innerHTML=null;
        return 1;
    }
}
