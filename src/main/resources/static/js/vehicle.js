$(document).ready(function () {

    $('.nBtn, .table .eBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text(); //return New or Edit

        if (text === 'Edit') {
            $.get(href, function (vehicle, status) {
                $('.myForm #id').val(vehicle.id);
                $('.myForm #vehicleType').val(vehicle.vehicleType);
                $('.myForm #brand').val(vehicle.brand);
                $('.myForm #capacity').val(vehicle.capacity);
                $('.myForm #registerNr').val(vehicle.registerNr);
                $('.myForm #reviewDate').val(vehicle.reviewDate);
                $('.myForm #insuranceDate').val(vehicle.insuranceDate);
            });
            $('.myForm #exampleModal').modal();
        } else {
            $('.myForm #id').val('');
            $('.myForm #vehicleType').val('');
            $('.myForm #brand').val('');
            $('.myForm #capacity').val('');
            $('.myForm #registerNr').val('');
            $('.myForm #reviewDate').val('');
            $('.myForm #insuranceDate').val('');
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