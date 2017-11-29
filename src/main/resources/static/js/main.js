(function($) {
    $(document).ready(function () {
        // navbar initializations
        $(".dropdown-button").dropdown();
        $(".button-collapse").sideNav();
        Materialize.udpateTextFields();
        $('.btn.dec-btn').click(function(){
            var inputToDecrement = $(this).siblings("input[type=number]")[0];

            if(inputToDecrement.value > 0){
                inputToDecrement.value--;
            }
        });

        $(".percent.inc-btn").click(function () {
            var inputToIncrement = $(this).siblings("input[type=number]")[0];

            if(inputToIncrement.value < 100) {
                inputToIncrement.value++;
            }
        });

        $("#calories-inc-btn").click(function () {
            var inputToIncrement = $(this).siblings("input[type=number]")[0];

            inputToIncrement.value++;
        });

        $("input[type=number]").blur(function () {
            var inputQty = parseInt($(this).val());
            var max = parseInt($(this).attr("data-max"));

            if(isNaN(inputQty) || inputQty < 0) {
                $(this).val(0);
            }

            if(inputQty > max) {
                $(this).val(max);
            }
        });
    });

    $('.datepicker').pickadate({
        selectMonths: true, // Creates a dropdown to control month
        selectYears: 15, // Creates a dropdown of 15 years to control year,
        today: 'Today',
        clear: 'Clear',
        close: 'Ok',
        closeOnSelect: false // Close upon selecting a date,
    });

})(jQuery);

