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