//get transcation type:
const transactType = document.querySelector("#transact-type");

//Get transaction forms :
const paymentCard = document.querySelector(".payment-card");
const transferCard = document.querySelector(".transfer-card");
const depositCard = document.querySelector(".deposit-card");
const withdrawCard=document.querySelector(".withdraw-card");
transactType.addEventListener("change", () => {
    //check for transaction types and display form:
    switch (transactType.value) {
        case "payment":
            paymentCard.style.display = "block";

            paymentCard.nextElementSibling.style.display = "none";
            depositCard.style.display="none";
            withdrawCard.style.display="none";
            break;
        case "transfer":
            transferCard.previousElementSibling.style.display = "none";
            transferCard.style.display = "block";
            transferCard.nextElementSibling.style.display = "none";
            withdrawCard.style.display="none";
            break;

        case "deposit":
            paymentCard.style.display = "none";
            depositCard.previousElementSibling.style.display = "none";
            depositCard.style.display = "block";
            depositCard.nextElementSibling.style.display = "none";
            break;

        case "withdraw":
            withdrawCard.previousElementSibling.style.display = "none";
            withdrawCard.style.display = "block";
            transferCard.style.display = "none";
            paymnetCard.style.display = "none";
           
            break;
    }
});
// end of  for transaction type event listeners
