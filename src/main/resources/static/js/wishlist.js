const wishlist = [];
 const wishlistQuantity = document.querySelector('.js-wishlist-quantity');
const cartQuantity = document.querySelector('.js-cart-quantity');
document.querySelectorAll('.delete-item-link').forEach((link) =>{
    link.addEventListener('click', () =>{
        const productId = link.dataset.productId;
        const wishlistItem = {
            productId: productId
        };
        let totalInWishlist = 0;
        fetch("/wishlist/removeFromWishlist", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(wishlistItem)
        })
            .then(response => response.json())
            .then(data => {

                totalInWishlist= data.totalInWishlist;
                console.log('totalInWishlist:', data.totalInWishlist);
                console.log('Status: ', data.status);
                console.log('message: ', data.message);

                if(data.status === "removed"){
                 //
                    wishlistQuantity.innerHTML = totalInWishlist;
                    const containerList = document.querySelectorAll('.cart-item-container');
                    containerList.forEach((node) => {
                        if (node.dataset.productId === productId) {
                            node.remove();
                        }
                    });
                }
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    });
});
document.querySelectorAll('.add-to-cart-link').forEach((link) => {
    link.addEventListener('click', () => {

        const productId = link.dataset.productId;

        let totalQuantity = 0;
        // Data to be sent to the backend
        const cartItem = {
            productId: productId,
            quantity: 1,
            shippingOption: "Option1"
        };

        fetch("/cart/addToCart", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(cartItem)
        })
            .then(response => response.json())
            .then(data => {

                totalQuantity = data.totalQuantity;
                console.log('Success:', data.totalQuantity);

                cartQuantity.innerHTML = totalQuantity;
            })
            .catch((error) => {
                console.error('Error:', error);
            });

    });

});