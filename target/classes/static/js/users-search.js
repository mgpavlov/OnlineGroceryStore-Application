const findUserByUsername = () => {
    const username = $('input#inputUsername').val();

    if (username.trim() === '') {
        let $tbody = $('.table tbody').empty();

        fetch('http://localhost:8000/api/users')
            .then(res => res.json())
            .then(res => res.forEach((user) => {
                $tbody.append($('<tr>')
                    .append($('<th scope="row">').text(user.id))
                    .append($('<td>').text(user.username))
                    .append($('<td>').text(user.email))
                    .append($('<td>').text(parseRoles(user.authorities)))
                    .append($('<td>')
                        .append($('<a class="btn bg-re"><i class="fas fa-user-edit"></i> Profile</a>')
                            .attr("href", "/user/profile/" + user.id)
                        ))
                );
            })).catch(err => console.log(err));
    } else {

        $('input#inputUsername').val('');

        fetch('http://localhost:8000/api/users/find?username=' + username)
            .then(res => res.json())
            .then(user => {
                let $tbody = $('.table tbody').empty();
                $tbody
                    .append($('<tr>')
                        .append($('<th scope="row">').text(user.id))
                        .append($('<td>').text(user.username))
                        .append($('<td>').text(user.email))
                        .append($('<td>').text(parseRoles(user.authorities)))
                        .append($('<td>')
                            .append($('<a class="btn bg-re"><i class="fas fa-user-edit"></i> Profile</a>')
                                .attr("href", "/user/profile/" + user.id)
                            ))
                    );
            }).catch(err => console.log(err));
    }

    function parseRoles(roles) {
        return roles
            .map(r => {
                return r.authority.startsWith("ROOT") ? r.authority
                    : r.authority.split("_")[1];
            })
            .sort()
            .join(", ");
    }
};