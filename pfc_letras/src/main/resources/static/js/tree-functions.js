var filter = [];

document.addEventListener('DOMContentLoaded', function() {
    var filterInput = document.getElementById('filter');

    if (filterInput) {
        var filterValue = filterInput.value.trim();
        console.log('Filter value antes del remplace', filterValue)
        filterValue = filterValue.replace(/^(\[+)|(\]+$)/g, '');

        console.log('Valor del atributo value:', filterValue);

        if (filterValue.length > 0) {
            filter = filterValue.split(",").map(function(item) {
                return item.trim();
            });
        }
        console.log('Valor del filtro después del parseo:', filter);
        console.log('Valor del filtro después del parseo con flat:', filter.flat(Infinity));

        filter.forEach(function(name) {
            var checkbox = document.getElementById('subsubcategory' + name);
            if (checkbox) {
                checkbox.checked = true;
            }
        });
    } else {
        console.error('No se encontró ningún elemento con ID "filter"');
    }

    console.log(filter);
    document.getElementById('filter').value = filter;
    localStorage.setItem('filter', JSON.stringify(filter));
});

function updateChecked(checkbox) {
    var name = checkbox.nextElementSibling.textContent.trim();
    var isChecked = checkbox.checked;

    if (isChecked && filter.indexOf(name) === -1) {
        filter.push(name);
    } else if (!isChecked) {
        var index = filter.indexOf(name);
        if (index !== -1) {
            filter.splice(index, 1);
        }
    }

    console.log(filter);
    document.getElementById('filter').value = filter;
    localStorage.setItem('filter', JSON.stringify(filter));
}