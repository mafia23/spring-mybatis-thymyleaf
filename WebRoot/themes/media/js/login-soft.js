var Login = function () {
    
    return {
        //main function to initiate the module
        init: function () {
	        $('.login-form input').keypress(function (e) {
	            if (e.which == 13) {
	            	$('.login-form').submit();
	            }
	        });

	        $('.forget-form input').keypress(function (e) {
	            if (e.which == 13) {
	                $('.forget-form').submit();
	            }
	        });

	        jQuery('#forget-password').click(function () {
	            jQuery('.login-form').hide();
	            jQuery('.forget-form').show();
	        });

	        jQuery('#back-btn').click(function () {
	            jQuery('.login-form').show();
	            jQuery('.forget-form').hide();
	        });


	        jQuery('#register-btn').click(function () {
	            jQuery('.login-form').hide();
	            jQuery('.register-form').show();
	        });

	        jQuery('#register-back-btn').click(function () {
	            jQuery('.login-form').show();
	            jQuery('.register-form').hide();
	        });

	        $.backstretch([
		        "themes/media/image/bg/1.jpg",
		        "themes/media/image/bg/2.jpg",
		        "themes/media/image/bg/3.jpg",
		        "themes/media/image/bg/4.jpg"
		        ], {
		          fade: 1000,
		          duration: 8000
		      });
        }

    };

}();