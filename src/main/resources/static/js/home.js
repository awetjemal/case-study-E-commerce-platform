const grid = document.querySelector('.js-products-grid');
// const wishlistQuantity = document.querySelector('.js-wishlist-quantity');
// const cartQuantity = document.querySelector('.js-cart-quantity');


function displayMessage(message){
    alert(message);
}
document.querySelectorAll('.js-add-to-cart').forEach((button) => {
    button.addEventListener('click', () => {
        //1. get totalQuantity from database 2. check if product is already in the cart
        let currentQuantity = 0;
        const productId = button.dataset.productId;

        const numList = document.querySelectorAll('.js-num');
        numList.forEach((node) => {
            if (node.dataset.productId === productId) {
                currentQuantity = node.value;
            }
        });
        let totalQuantity = 0;
        // Data to be sent to the backend
        const cartItem = {
            productId: productId,
            quantity: Number(currentQuantity),
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

document.querySelectorAll('.js-fav-btn').forEach((button) => {
    button.addEventListener('click', () => {

        const productId = button.dataset.productId;
        const wishlistItem = {
            productId: productId
        };
        let totalInWishlist = 0;

        fetch("/wishlist/updateWishlist", {
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
                wishlistQuantity.innerHTML = totalInWishlist;
                if(data.status === "added"){
                    button.innerHTML = `<i class="bi bi-heart-fill"></i>`;
                }else if(data.status === "removed"){
                    button.innerHTML = `<i class="bi bi-heart"></i>`;
                }
            })
            .catch((error) => {
                console.error('Error:', error);
            });
        // console.log("Product Id = " + productId);


        // document.querySelector('.js-cart-quantity').innerHTML = totalQuantity;
        // console.log('# of items in a cart: ' + totalQuantity);
        console.log(wishlist);
    });

});