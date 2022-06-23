const dangnhap=document.querySelector(".btn.btn_dn");
const qmk=document.querySelector(".btn.btn_tl");
//const email=document.querySelector("#email");
const ps=document.querySelector("#password");

// dsinput.forEach((giatri,sott) => {
//     giatri.onblur=function(){
//         console.log(this.id);
//     }
// });

qmk.onclick = function(){
    document.location.href = `${contextPath}/quenmatkhau`;
}

dangnhap.onclick=function(){
 /*   ktemail();
    ktpassword();*/

   // if (ktemail()==1 && ktpassword()==1){
        var taikhoan = {
            "Username": email.value,
            "Password": ps.value
        };
        $.ajax({
            headers: {
              Accept: "application/json",
              "Content-Type": "application/json"
            },
            type: "POST",
            url: `${contextPath}/api/dangnhap`,
            data: JSON.stringify(taikhoan),
            success: function (result) {
                console.log(result);
                if (result=="Dang nhap that bai!!!")
                    alert(result);
                else{
                    let han = 10000;
                    setCookie("token", result.Token, han);
                    setCookie("username", result.Username, han);
                    setCookie("role", result.Role, han);
                    document.location.href = `${contextPath}/trangchu`;
                }
            }
          });
    }
//}   

function ktemail(){
    var kte=email.parentElement.querySelector('.form-message');
    if(email.value==''){
        kte.innerHTML="Email không được để trống";
    }
    else{
        kte.innerHTML=null;
        return 1;
    }
}

function ktpassword(){
    var ktp=ps.parentElement.querySelector('.form-message');
    if(ps.value==''){
        ktp.innerHTML="Mật khẩu không được để trống";
    }
    else{
        ktp.innerHTML=null;
        return 1;
    }
}
function setCookie(cname, cvalue, exdays) {
  const d = new Date();
  d.setTime(d.getTime() + (exdays*24*60*60*1000));
  let expires = "expires="+ d.toUTCString();
  document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}
function getCookie(cname) {
  let name = cname + "=";
  let decodedCookie = decodeURIComponent(document.cookie);
  let ca = decodedCookie.split(';');
  for(let i = 0; i <ca.length; i++) {
    let c = ca[i];
    while (c.charAt(0) == ' ') {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
}
