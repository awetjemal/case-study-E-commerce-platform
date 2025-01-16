
const grid = document.querySelector('.js-products-grid');
const wishlistQuantity = document.querySelector('.js-wishlist-quantity');
const cartQuantity = document.querySelector('.js-cart-quantity');


document.querySelectorAll('.js-add-to-cart').forEach((button) => {
    button.addEventListener('click', () => {
        let currentQuantity = 0;
        const productId = button.dataset.productId;
        let matchingItem;
        const numList  = document.querySelectorAll('.js-num');
        numList.forEach((node) =>{
            if(node.dataset.productId === productId){
                currentQuantity = node.value ;
            }
        });
        cart.forEach((item) => {
            if(productId === item.productId){
                matchingItem = item;
            }
        });
        if(matchingItem){
            matchingItem.quantity += Number(currentQuantity);
        }else{
            cart.push({
                productId: productId,
                quantity: Number(currentQuantity),
            });
        }
        let totalQuantity = 0;
        cart.forEach((item) => {
            totalQuantity += Number(item.quantity);
        });
        cartQuantity.innerHTML = totalQuantity;
        console.log('# of items in a cart: ' + totalQuantity);
        console.log(cart);
        // console.log("currentQuantity selected is  =  " + currentQuantity);

    });

});
document.querySelectorAll('.js-fav-btn').forEach((button) => {
    button.addEventListener('click', () => {

        const productId = button.dataset.productId;
        console.log("Product Id = " + productId);
        if(wishlist.includes(productId)){
            wishlist.pop(productId);
            button.innerHTML = `<i class="bi bi-heart"></i>`;
            wishlistQuantity.innerHTML = wishlist.length;
        }else{
            wishlist.push(productId);
            button.innerHTML = `<i class="bi bi-heart-fill"></i>`;
            wishlistQuantity.innerHTML = wishlist.length;

        }

        // document.querySelector('.js-cart-quantity').innerHTML = totalQuantity;
        // console.log('# of items in a cart: ' + totalQuantity);
        console.log(wishlist);
    });

});