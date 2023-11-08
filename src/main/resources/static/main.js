function submit() {
    let sellerName = document.getElementById("name").value;
    sessionStorage.setItem("sellerName", sellerName);
    console.log(sellerName);
    window.open("/index");
}

function onPageLoad() {
    document.getElementById("sellerName").innerHTML = "Seller: " + sessionStorage.getItem("sellerName");
    console.log(sessionStorage.getItem("sellerName"));

    fetch("/customers/")
        .then(response => response.json())
        .then(customers => {
            let customerList = document.getElementById("customerList");
            customers.forEach(customer => {
                let listItem = document.createElement("li");
                listItem.textContent = `${customer.name} ${customer.surname}`;
                customerList.appendChild(listItem);
            });
        })
        .catch(error => console.error(error));
}

function addCustomer(event) {
    event.preventDefault();
    let name = document.getElementById("customerName").value;
    let surname = document.getElementById("customerSurname").value;

    fetch("/customers/", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            name: name,
            surname: surname
        })
    })
        .then(response => response.json())
        .then(customerId => {
            let customerList = document.getElementById("customerList");
            let listItem = document.createElement("li");
            listItem.textContent = `${name} ${surname}`;
            customerList.appendChild(listItem);
        })
        .catch(error => console.error(error));
}
