function includeHTML() {
    let z, i, elmnt, file, xhttp;

    z = document.getElementsByTagName("*");
    for (i = 0; i < z.length; i++) {
        elmnt = z[i];

        file = elmnt.getAttribute("include-html");
        if (file) {
            xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState == 4) {
                    if (this.status == 200) {
                        elmnt.innerHTML = this.responseText;
                    }
                    if (this.status == 404) {
                        elmnt.innerHTML = "Page not found.";
                    }

                    elmnt.removeAttribute("include-html");
                    includeHTML();
                }
            };
            xhttp.open("GET", file, true);
            xhttp.send();
            return;
        }
    }
}
window.onload = () => {
    let myPage = document.getElementsByClassName("mypage");
    let myPageMenu = document.getElementById("mypage-menu");
    let check = document.getElementById("mypage-check");

    myPage[0].addEventListener("click", ()=>{
        if(check.checked === false) {
            myPageMenu.style.visibility = "visible";
            check.checked = true;
        }
        else {
            myPageMenu.style.visibility = "hidden";
            check.checked = false;
        }
    })
}
