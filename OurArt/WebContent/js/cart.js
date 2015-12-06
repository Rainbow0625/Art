jQuery(document).ready(function($) {
    $(document).on('click', '.product-add-to-cart, .item-add-to-cart', function(event) {
        event.preventDefault();

        var value   = $(this).closest('.cart').serializeArray();

        var request = {
            'option'    : 'com_product',
            'view'      : 'products',
            'task'      : 'addToCart',
            'data'      : value
        };

       $.ajax({
            type: 'POST',
            data   : request,
            beforeSend : function(){
               // $self.find('.splms-icon').addClass(' splms-icon-spinner splms-icon-spin');
            },
            success : function (data) {
                var cartData = $.parseJSON(data);

                if (cartData.status === 'success')
                {
                    var popupConetnt = $('<div class="cart-popup"><i class="sb-icon-ok"></i><h3 class="popup-title">Product Succefully Added to Your Cart</h3></div>');
                    popupConetnt.append( '<div class="product-price"><span>Price</span><h4>' + cartData.product.price + '</h4><div>' );
                    popupConetnt.append( '<img class="product-thumbnail" src="' + cartData.image_url + '" />' );
                    popupConetnt.append( '<h3 class="product-title">' + cartData.product.title + '</h3>' );
                    popupConetnt.append('<div class="popup-btns"><a href="#"class="btn btn-primary btn-lg keep-shoping">Keep Shoping</a><a class="btn btn-success btn-lg" href="'+ cartData.cart_url +'">View Cart</a></div>');

                    // Update Cart
                    $('.my-cart').text(cartData.count);


                }else{
                    var popupConetnt = '<p>Problem in adding product to cart</p>';
                }
                $.magnificPopup.open({
                    items: {
                        src: popupConetnt,
                        type: 'inline'
                    },
                    tLoading: '',
                    preloader: true,
                    showCloseBtn : true,
                    enableEscapeKey : false,
                    closeOnBgClick : false,
                    removalDelay: 300,
                    mainClass: 'mfp-fade'
                });
            }
        });

    });

    $(document).on('click', '.keep-shoping', function(event) {
        event.preventDefault();
        $.magnificPopup.close();
    });
});
