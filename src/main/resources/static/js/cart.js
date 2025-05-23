const cart = [];
const cartQuantityC = document.querySelector('.js-cart-quantity');
const cartQuantituCK = document.getElementById('cartQuantityCK');
const cartQuantitySmall = document.getElementById('cartQuantityCK2');
let totalItemsInCart = 0;
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
            quantity: currentQuantity,
            shippingOption: "Option1"
        };

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
                document.getElementById('ln-1').innerHTML = data.totalLine1;
                document.getElementById('ln-2').innerHTML = data.totalLine2;
                document.getElementById('ln-3').innerHTML = data.totalLine3;
                document.getElementById('ln-4').innerHTML = data.totalLine4;
                document.getElementById('ln-5').innerHTML = data.totalLine5;


                if(data.status === "removed"){
                    cartQuantityC.innerHTML = totalItemsInCart;
                    cartQuantituCK.innerHTML = totalItemsInCart;
                    cartQuantitySmall.innerHTML = totalItemsInCart;
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

