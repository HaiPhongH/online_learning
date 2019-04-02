var flagIcon = document.getElementById("ul_footer");
var allClass = document.querySelectorAll(".nation");
var iconLang = document.getElementById("icon_language");
var flag = document.querySelectorAll(".flag");
flagIcon.onclick = onclickFunction;
function onclickFunction() {
    if (allClass[0].style.display != 'none' && flag[0].style.display != 'none') {
        for (var i = 0; i < allClass.length; i++) {
            allClass[i].style.display = 'none';
        }
    } else if (allClass[0].style.display === 'none' && flag[0].style.display != 'none') {
        iconLang.style.width = '20px';
        iconLang.style.height = '20px';
        iconLang.style.display = 'block';
        for (var i = 0; i < flag.length; i++) {
            flag[i].style.display = 'none';
        }
    } else {
        for (var i = 0; i < allClass.length; i++) {
            flag[i].style.display = 'inline-block';
            allClass[i].style.display = 'inline-block';
            iconLang.style.display = 'none';
        }
    }
}