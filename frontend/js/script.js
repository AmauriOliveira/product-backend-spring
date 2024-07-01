//Masks
$("#inputPrice").mask("000.000.000.000.000,00", { reverse: true });

function convertToNumber(priceFormat){
    return priceFormat.replace(/\./g, '').replace(',', '.');
}

let products = [];

let categories = [];

//OnLoad
loadCategories();
loadProducts();

function loadCategories() {
    $.ajax({
        url: 'http://localhost:8080/categories',
        type: 'GET',
        async: false,
        success: (categoriesResponse) => {
            categories = categoriesResponse;

            for (const category of categories) {
                const { id, name } = category;

                document.getElementById('selectCategory').innerHTML += `<option value=${id}>${name}</option>`
            }
        },
    });
}

function loadProducts() {
    $.getJSON('http://localhost:8080/products', (productsResponse) => {
        for (let product of productsResponse) {
            addNewRow(product);
        }
    });
}

//save a product
function save() {

    var prod = {
        id: products.length + 1,
        name: document.getElementById("inputName").value,
        description: document.getElementById("inputDescription").value,
        price: convertToNumber(document.getElementById("inputPrice").value),
        category: document.getElementById("selectCategory").value,
        promotion: document.getElementById("checkBoxPromotion").checked,
        new: document.getElementById("checkBoxNewProduct").checked
    };

    addNewRow(prod);
    products.push(prod);

    document.getElementById("formProduct").reset();
}


//Add new Row
function addNewRow(product) {
    const { id, name, description, price, idCategory, onSale, launching } = product;
    var table = document.getElementById("productsTable");

    var newRow = table.insertRow();

    //Insert product id
    var idNode = document.createTextNode(id);
    newRow.insertCell().appendChild(idNode);

    //Insert product name
    var nameNode = document.createTextNode(name);
    newRow.insertCell().appendChild(nameNode);

    //Insert product description
    var descriptionNode = document.createTextNode(description);
    var cell = newRow.insertCell();
    cell.className="d-none d-md-table-cell";
    cell.appendChild(descriptionNode);

    //Insert product price
    var formatter = new Intl.NumberFormat("pt-BR", {
        style: "currency",
        currency: "BRL",
    });

    var priceNode = document.createTextNode(formatter.format(price));
    newRow.insertCell().appendChild(priceNode);

    //Insert product category
    var categoryNode = document.createTextNode(categories.find(cat => cat.id === idCategory).name);
    newRow.insertCell().appendChild(categoryNode);

    //Insert product options
    var options = "";
    if (onSale) {
        options = "<span class='badge bg-success me-1'>P</span>";
    }

    if (launching) {
        options += "<span class='badge bg-primary'>L</span>";
    }

    cell = newRow.insertCell();
    cell.className="d-none d-md-table-cell";
    cell.innerHTML = options;

}












