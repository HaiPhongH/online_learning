var image = document.getElementById("image");
image.onload = displayImage;
function displayImage() {
    image.style.transitionTimingFunction = 'ease-out';
    image.style.transition = '0.75s';
    image.style.width = '100%';
}
