var devTitle = document.getElementById('development_title');
var btnEnroll = document.getElementById('btnEnroll');
var courseID = document.getElementById('courseID');
var memberID = document.getElementById('memberID');
function devMouseOver() {
    if (devTitle.style.paddingLeft === '0px') {
        devTitle.style.transitionTimingFunction = 'ease-out';
        devTitle.style.transition = '3s';
        devTitle.style.paddingLeft = '750px';
    } else {
        devTitle.style.transitionTimingFunction = 'ease-out';
        devTitle.style.transition = '3s';
        devTitle.style.paddingLeft = '0px';
    }
}

btnEnroll.onclick = enrollCourse;
function enrollCourse() {
    $.ajax({
        type: 'POST',
        url : '../EnrollCourse',
        data : {
            courseID: courseID.value,
            memberID: memberID.value
        },
        success: function (html) {
            alert(html);
        },
        error: function () {
            alert("ERROR!");
        }
    });
}
