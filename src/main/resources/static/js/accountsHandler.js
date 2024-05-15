function updateAccounts(){

    const tar = document.getElementById('accounts');
    tar.innerHTML = '';

    accounts.forEach(account => {
        tar.innerHTML += `
            <div class="account" id="account-${account.id}">
                <h3 class="account-name"> ${account.name} </h3>
                <strong class="account-amount"> ${account.balance} &#8381;</strong>
            </div>
        `;
    });
}