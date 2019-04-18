(() => {
    $(document).ready(() => {
        const $table = $('.table').empty();
        $table
            .append($('<thead class="font-weight-bold">')
                .append($('<tr>')
                    .append($('<th scope="col">').text("#"))
                    .append($('<th scope="col">').text("Username"))
                    .append($('<th scope="col">').text("Email"))
                    .append($('<th scope="col">').text("Authorities"))
                    .append($('<th scope="col">'))
                ))
            .append($('<tbody>')
            );

        fetch('/api/users')
            .then(res => res.json())
            .then(res => res.forEach((user) => {
                $table.find('tbody')
                    .append($('<tr class="brush-script">')
                        .append($('<th class="brush-script" scope="row">').text(user.id))
                        .append($('<td class="brush-script">').text(user.username))
                        .append($('<td class="brush-script">').text(user.email))
                        .append($('<td class="brush-script">').text(parseRoles(user.authorities)))
                        .append($('<td class="brush-script">')
                            .append($('<a class="btn btn-info"><i class="fas fa-user-edit"></i> Profile</a>')
                                .attr("href", "/user/profile/" + user.username)
                        ))
                    );
            })).catch(err => console.log(err));
    });

    function parseRoles(roles) {
        return roles
            .map(r => {
                return r.authority.startsWith("ROOT") ? r.authority
                    : r.authority.split("_")[1];
            })
            .sort()
            .join(", ");
    }

})();