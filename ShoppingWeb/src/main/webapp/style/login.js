function submitFormRegister() {
	var user = document.getElementById("us").value;
	var pass = document.getElementById("pw").value;
	var role = document.getElementById("role").value;
	var name = document.getElementById("nameUser").value;
	if (!user || !pass || !role || !name) {
		if (!user) {
			alert("Vui lòng nhập email");
		} else if(!pass) {
			alert("Vui lòng nhập password");
		} else if(!role) {
			alert("Vui lòng chọn role");
		} else {
			alert("Vui lòng nhập tên");
		}
		return false;
	}
}

function submitForm() {
	var user = document.getElementById("us").value;
	var pass = document.getElementById("pw").value;
	if (!user || !pass) {
		if (!user) {
			alert("Vui lòng nhập email");
		} else if(!pass) {
			alert("Vui lòng nhập password");
		}  
		return false;
	}
}