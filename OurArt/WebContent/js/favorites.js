jQuery(function($) {
	$(document).on('click', '.addtofavories', function(event){
		event.preventDefault();
		var $this = $(this);
		var count = $this.attr('data-favorites');

		var request = {
			'option' : 'com_product',
			'view' : 'products',
			'task'    : 'favorites',
			'product_id' : $this.data('id')
		};

		$.ajax({
			type   : 'POST',
			data   : request,

			success: function (response) {
				var data = $.parseJSON(response);

				if(data.status == 'failed') {
					alert('Please login first.');
				} else if (data.status == 'added') {

					var added = (count*1 + 1);

					$this.removeAttr('data-favorites').attr('data-favorites', added);
					$this.find('span').text(added);
					$this.addClass('active');

				} else if (data.status == 'deleted') {

					var deleted = (count*1 - 1);

					$this.removeAttr('data-favorites').attr('data-favorites', deleted);
					$this.find('span').text(deleted);
					$this.removeClass('active');
				}
				
			}
		});

		return false;

	});
});