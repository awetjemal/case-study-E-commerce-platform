const editModalForm = document.getElementById('editProduct');
const editButtons = document.querySelectorAll('.js-edit-product')

const pImages = document.querySelectorAll('.product-image');
const pNames = document.querySelectorAll('.product-name');
const pKeywords = document.querySelectorAll('.product-keywords');
const pPrices = document.querySelectorAll('.product-price-inner');

document.getElementById('add-product-btn').addEventListener('click', () => {
    const pName = document.getElementById('Product-Name');
    const pPrice = document.getElementById('Product-Price');
    const pKeyWords = document.getElementById('Key-Words');
    const pImageUrl = document.getElementById('Image-URL');

    console.log(pName.value + '\n' + pPrice.value + '\n' + pKeyWords.value + '\n' + pImageUrl.value );
    //send to backend -> database those entries 
    pName.value = '';
    pPrice.value = '';
    pKeyWords.value = '';
    pImageUrl.value = '';
});
editButtons.forEach((btn) =>{
   btn.addEventListener('click', ()=>{
       const productId = btn.dataset.productId;
       const imageUrl = getImageById(productId);
       const name = getPNameById(productId);
       const keyWords = getKeywordsById(productId);
       const price = getPriceById(productId);
       // console.log('productId clicked: ' + productId);
       // console.log('Image clicked: ' + imageUrl);
       // console.log('Name of clicked product: ' + name);
       // console.log('Key words: ' + keyWords);
       // console.log('Price of product: ' + price);
       document.getElementById('Product-Name-e').setAttribute('value', name);
       document.getElementById('Product-Price-e').setAttribute('value', price);
       document.getElementById('Key-Words-e').setAttribute('value', keyWords);
       document.getElementById('Image-URL-e').setAttribute('value', imageUrl);
       document.getElementById('image-edit').setAttribute('src', imageUrl);

   });
});

function getImageById(id){
    let val;
    pImages.forEach((img) =>{
        if(img.dataset.productId === id)
            val = img.src;
    });
    return val;
}
function getPNameById(id){
    let val ="";
    pNames.forEach((name) =>{
        if(name.dataset.productId === id)
            val = name.innerHTML;
    });
    return val;
}
function getKeywordsById(id){
    let words = "";
    pKeywords.forEach((key) =>{
        if(key.dataset.productId === id)
            words = key.innerHTML;
    });
    return words;
}
function getPriceById(id){
    let price ;
    pPrices.forEach((prc) =>{
        if(prc.dataset.productId === id)
            price = prc.innerHTML;
    });
    return price;
}