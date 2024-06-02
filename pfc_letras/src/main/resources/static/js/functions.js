document.addEventListener('DOMContentLoaded', () => {
    const button = document.getElementById("dropdown-button");
    const dropdownMenu = document.getElementById('dropdown-menu3')

    button.onclick = () => {
       var _= dropdownMenu.style.visibility === "visible" ? dropdownMenu.style.visibility = "hidden"
                                                                 : dropdownMenu.style.visibility = "visible";
    }
});

function createLoan() {
    const bookId = document.getElementById('book-id').getAttribute('data-bookId');
    const userId = document.getElementById('user-id').getAttribute('data-userId');
    alert('book id: '+ bookId + ' || user name: ' + userId);



    // var iconElement = document.getElementById('icon-loan');
    // var isLoanActive = false;
    //
    // if (!isLoanActive) {
    //     iconElement.innerHTML = document.getElementById('icon-loan-true').innerHTML;
    //     isLoanActive = true;
    // } else {
    //     iconElement.innerHTML = document.getElementById('icon-loan-false').innerHTML;
    //     isLoanActive = false;
    // }
}