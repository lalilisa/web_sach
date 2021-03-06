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

function setCookie(cname, cvalue, expired) {
  var now = new Date();
  var time = now.getTime();
  var expireTime = time + 1000*expired;
  now.setTime(expireTime);
  document.cookie = cname+'='+cvalue+';expires='+now.toUTCString()+';path=/';
}

function deleteCookie(){
  document.cookie = "token=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
  document.cookie = "username=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
  document.cookie = "role=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
}

function logout(){
  deleteCookie();
  document.location.href = "http://localhost:8080/WebSach/dangnhap";
}