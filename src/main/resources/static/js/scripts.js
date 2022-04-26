$(window).on('load', function () {
    $('#signInModal').modal('show');
});

function filterFunction() {
    var input, filter, ul, li, a, i;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();

    div = document.getElementById("myDropdown");
    a = div.getElementsByTagName("a");

    for (i = 0; i < a.length; i++) {
        txtValue = a[i].textContent || a[i].innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            a[i].style.display = "block";
            if (input.value == ""){
                a[i].style.display = "none";
            }
        } else {
            a[i].style.display = "none";
        }

    }
}