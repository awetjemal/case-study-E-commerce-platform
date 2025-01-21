const cart = [];
const cartQuantityC = document.querySelector('.js-cart-quantity');
document.querySelectorAll('.delete-quantity-link').forEach((link) =>{
    link.addEventListener('click', () => {
        // console.log('clicked the delete link');
        const productId = link.dataset.productId;
        let currentQuantity = 0;
        const numList = document.querySelectorAll('.quantity-label');
        numList.forEach((node) => {
            if (node.dataset.productId === productId) {
                currentQuantity = node.innerHTML;
            }
        });

        const cartItem = {
            productId: productId,
            quantity: currentQuantity
        };
        let totalItemsInCart = 0;
        fetch("/cart/removeFromCart", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(cartItem)
        })
            .then(response => response.json())
            .then(data => {

                totalItemsInCart= data.totalItemsInCart;
                console.log('totalItemsInCart: ', data.totalItemsInCart);
                console.log('Status: ', data.status);
                console.log('message: ', data.message);

                if(data.status === "removed"){
                    cartQuantityC.innerHTML = totalItemsInCart;
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
        // location.reload();
    });

});
// document.getElementById('bbb').addEventListener('click', ()=>{
//     console.log("clicked the test button");
// });