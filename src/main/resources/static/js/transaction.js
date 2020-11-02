$(document).ready(function () {

    $('.table .eBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');

            $.get(href, function (transaction, employee, status) {
                $('.myForm #id').val(transaction.id);
                $('.myForm #companyName').val(transaction.companyName);
                $('.myForm #bid').val(transaction.bid);
                $('.myForm #route').val(transaction.route);
                $('.myForm #loadingPlace').val(transaction.loadingPlace);
                $('.myForm #unloadingPlace').val(employee.firstName);

            });
            $('.myForm #exampleModal').modal();

    });
});