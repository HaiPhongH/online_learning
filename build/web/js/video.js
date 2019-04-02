/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var video = document.getElementById('video');
var sectionID = document.getElementById('sectionID');
var memberID = document.getElementById('memberID');

function startVideoAtTime(time) {
    if (time !== 0) {
        var minute = Math.floor(time/60);
        var second = time-60*minute;
        var conf = confirm("You are in " +minute+":"+ second+". Do you want to continue?");
        if (conf === true) {
            video.currentTime = time;
            video.play();
        }
    }
}
video.addEventListener("play", learning);
video.addEventListener("ended", ending);

function  learning() {
    $.ajax({
        type : 'POST',
        url : '../VideoController',
        data : {
            currentTime: Math.floor(video.currentTime),
            sectionID: sectionID.value,
            memberID : memberID.value
        },
        success : function (){
        },
        error: function () {
            alert("Learning loi");
        }
    });
    video.removeEventListener("play",learning);
}
function ending() {
    $.ajax({
        type : 'POST',
        url : '../VideoController',
        data : {
            currentTime: Math.floor(video.currentTime),
            sectionID: sectionID.value,
            memberID : memberID.value
        },
        success : function (){
        },
        error: function () {
            alert("Ending loi");
        }
    });
}
window.onunload = function () {
    if(video.currentTime !==0 ) {
        $.ajax({
            type: 'POST' ,
            url : '../VideoController',
            data : {
                currentTime: Math.floor(video.currentTime),
                sectionID: sectionID.value,
            memberID : memberID.value
            },
            success : function (){
            },
            error: function () {
                alert("Onunload loi");
            }
        });
    }
};
window.onblur = function () {
    if(video.currentTime !==0 ) {
        $.ajax({
            type: 'POST' ,
            url : '../VideoController',
            data : {
                currentTime: Math.floor(video.currentTime),
                sectionID: sectionID.value,
                memberID : memberID.value
            },
            success : function (){
            },
            error: function () {
                alert("Onblur loi");
            }
        });
    }
};