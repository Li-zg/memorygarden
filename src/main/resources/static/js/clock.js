function clock() {
    var hours = document.getElementById('hour');
    var minutes = document.getElementById('min');
    var seconds = document.getElementById('sec');

    var h = new Date().getHours();
    var m = new Date().getMinutes();
    var s = new Date().getSeconds();

    hours.innerHTML = h;
    minutes.innerHTML = m;
    seconds.innerHTML = s;
}
var interval = setInterval(clock, 1000);
