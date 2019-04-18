(() => {
    function formatProduct(product) {
        return '<div class="product col-md-2 mt-2 bg-product rounded ml-4 mr-4 mb-5">'
            + '<div class="text-center mt-3">'
            + `<a href="/products/details/${product.id}"><img src="${product.imageUrl}" class="product-image-home img-thumbnail px-auto" alt="Image not loaded..."/></a>`
            + '</div>'
            + `<h5 class="text-center font-weight-bold mt-3">Name: ${product.name}</h5>`
            + `<h5 class="text-center font-weight-bold">Price: ${product.price.toFixed(2)}</h5>`
            + '</div>'
    }

    fetch('/categories/fetch')
        .then((response) => response.json())
        .then((json) => {
            json.forEach((category) => $('#product-categories')
                .append($(`<a class="dropdown-item text-white custom-hover categories-dropdown" href="/products/category/${category.name}">
<i class="fas fa-angle-right"></i> ${category.name}</a>`)/*.onclick(()=>{
                    fetch('/products/fetch/' + category.name)
                        .then((response) => response.json())
                        .then((json) => {

                            $('.products-data').empty();

                            $('#categoryTittle').text(`${category.name}`);

                            if (json.length === 0) {
                                $('.products-data').append(`<h1 class="text-center font-weight-bold">There are no products in the ${category.name} category.</h1>`)
                            } else {
                                for (let i = 0; i < json.length; i++) {
                                    $('.products-data').append(formatProduct(json[i]));
                                }
                            }
                        })
                })*/)
            );
        })
        .catch((err) => console.log(err));

    /*$('#allProducts').bind("click", ()=>{
        fetch('/products/fetch')
            .then((response) => response.json())
            .then((json) => {
                $('.products-data').empty();

                $('#categoryTittle').text(`All Products`);

                if (json.length === 0) {
                    $('.products-data').append(`<h1 class="text-center font-weight-bold">There are no products in the ${category} category.</h1>`)
                } else {
                    for (let i = 0; i < json.length; i++) {
                        $('.products-data').append(formatProduct(json[i]));
                    }
                }
            })
            .catch((err) => console.log(err));
    })*/
})();