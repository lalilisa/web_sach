

const oringi=window.location.origin
const contextPath="http://localhost:8080/WebSach"

function delete_cookie(name) {
    document.cookie = name + '=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;';
};

function dangxuat(){
	delete_cookie("token");
	delete_cookie("role");
	delete_cookie("username");
	window.location.href=`${contextPath}/trangchu`
}