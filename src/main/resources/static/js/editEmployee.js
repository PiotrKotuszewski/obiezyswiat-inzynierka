$(document).ready(function () {

    $('.nBtn, .table .eBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text(); //return New or Edit

        if (text === 'Edit') {
            $.get(href, function (employee, status) {
                $('.myForm #id').val(employee.id);
                $('.myForm #firstName').val(employee.firstName);
                $('.myForm #lastName').val(employee.lastName);
                $('.myForm #salary').val(employee.salary);
                $('.myForm #position').val(employee.position);
            });
            $('.myForm #exampleModal').modal();
        } else {
            $('.myForm #id').val('');
            $('.myForm #firstName').val('');
            $('.myForm #lastName').val('');
            $('.myForm #salary').val('');
            $('.myForm #position').val('');
            $('.myForm #exampleModal').modal();
        }
    });

    $('.table .delBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#myModal #delRef').attr('href', href);
        $('#myModal').modal();
    });
});