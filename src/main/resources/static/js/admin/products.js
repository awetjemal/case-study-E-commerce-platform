const editModalForm = document.getElementById('editProduct');
const editButtons = document.querySelectorAll('.js-edit-product')

editButtons.forEach((btn) =>{
   btn.addEventListener('click', ()=>{
       const productId = btn.dataset.productId;
   });
});

