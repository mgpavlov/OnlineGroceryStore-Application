(() => {
    fetch('/categories/fetch')
        .then((response) => response.json())
        .then((json) => {
            json.forEach((category) => $('#add-product-categories').append(`<option value="${category.id}">${category.name}</option>`));
        })
        .catch((err) => console.log(err));
})();