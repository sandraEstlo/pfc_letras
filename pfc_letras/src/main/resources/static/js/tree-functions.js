var filter = /*[[${filter}]] */ [];

function updateChecked(checkbox) {
    var name = checkbox.nextElementSibling.textContent.trim();
    if (checkbox.checked) {
        filter.push(name);
    } else {
        var index = filter.indexOf(name);
        if (index !== -1) {
            filter.splice(index, 1);
        }
    }
    console.log(filter);
}