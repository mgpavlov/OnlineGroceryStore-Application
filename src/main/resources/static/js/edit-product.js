(() => {
    fetch('/categories/fetch')
        .then((response) => response.json())
        .then((json) => {
            let categories = [[${product.categories}]];
            console.log(categories);
            json.forEach((category) =>
                $('#add-product-categories').append(
                    categories.includes(category.name)
                        ? `<option value="${category.id}" selected>${category.name}</option>`
                        : `<option value="${category.id}">${category.name}</option>`));
        })
        .catch((err) => console.log(err));
})();