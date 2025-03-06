const editButtons = document.querySelectorAll('.js-customer-edit-btn');
    // console.log("Number of buttons: " + editButtons.length);
editButtons.forEach((btn) =>{
    btn.addEventListener('click', ()=>{
        const customerId = btn.dataset.customerId;
        // const firstName =
        document.getElementById('firstName').setAttribute('value', getFirstNameById(customerId));
        document.getElementById('lastName').setAttribute('value', getLastNameById(customerId));
        document.getElementById('email').setAttribute('value', getEmailById(customerId));
        document.getElementById('phoneNumber').setAttribute('value', getPhoneNumberById(customerId));
        document.getElementById('street').setAttribute('value', getStreetById(customerId));
        document.getElementById('city').setAttribute('value', getCityById(customerId));
        document.getElementById('state').setAttribute('value', getStateById(customerId));
        document.getElementById('zipCode').setAttribute('value', getZipCodeById(customerId));
    });
    // console.log('Each single button element: ' + btn.outerHTML);
});

function getFirstNameById(id){
    let val;
    document.querySelectorAll('.firstName-field').forEach((field) =>{
        if(field.dataset.customerId === id){
            val = field.innerHTML;
        }
    });
    return val;
}
function getLastNameById(id){
    let val;
    document.querySelectorAll('.lastName-field').forEach((field) =>{
        if(field.dataset.customerId === id){
            val =  field.innerHTML;
        }
    });
    return val;
}
function getEmailById(id){
    let val;
    document.querySelectorAll('.email-field').forEach((field) =>{
        if(field.dataset.customerId === id){
            val = field.innerHTML;
        }
    });
    return val;
}
function getPhoneNumberById(id){
    let val;
    document.querySelectorAll('.phoneNumber-field').forEach((field) =>{
        if(field.dataset.customerId === id){
            val = field.innerHTML;
        }
    });
    return val;
}
function getStreetById(id){
    let val;
    document.querySelectorAll('.street-field').forEach((field) =>{
        if(field.dataset.customerId === id){
            val = field.innerHTML;
        }
    });
    return val;
}
function getCityById(id){
    let val
    document.querySelectorAll('.city-field').forEach((field) =>{
        if(field.dataset.customerId === id){
            val = field.innerHTML;
        }
    });
    return val;
}
function getStateById(id){
    let val;
    document.querySelectorAll('.state-field').forEach((field) =>{
        if(field.dataset.customerId === id){
           val = field.innerHTML;
        }
    });
    return val;
}
function getZipCodeById(id){
    let val
    document.querySelectorAll('.zipCode-field').forEach((field) =>{
        if(field.dataset.customerId === id){
            val = field.innerHTML;
        }
    });
    return val;
}


