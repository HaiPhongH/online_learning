/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var courseID = document.getElementById('courseID');
var btnRating = document.getElementById('btnRating');
var formData = document.getElementById('form').querySelectorAll('input[type="radio"]');
var ratingValue = document.getElementById('ratingValue');
btnRating.onclick = ratingFunction;
function ratingFunction() {
    for(var i=0;i<formData.length; i++) {
        if(formData[i].checked === true) {
            $.ajax({
                type : 'POST',
                url : '../RatingController',
                data: {
                    star : formData[i].value,
                    courseID: courseID.value
                },
                error: function () {
                    alert("OPPS");
                }
            });
            alert("You rated this course for "+formData[i].value+" stars");
        }
    }
}
window.onload = function() {
  for(var i=0;i<formData.length; i++) {
      if(parseFloat(formData[i].value) >= parseFloat(ratingValue.value)) {
          formData[i].checked = true;
      }
    }  
};