document.addEventListener('DOMContentLoaded', () => {
    const button = document.getElementById("dropdown-button");
    const dropdownMenu = document.getElementById('dropdown-menu3')
    button.onclick = () => {
       var _= dropdownMenu.style.visibility === "visible" ? dropdownMenu.style.visibility = "hidden"
                                                                 : dropdownMenu.style.visibility = "visible";
    }
});