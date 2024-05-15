const apiAddress = 'http://localhost:8080';
const userId = 'af643371-c6ea-456e-be6a-11f6f1b5f0c4';
const getAccountsUrl = apiAddress + '/api/v1/accounts';

let accounts = [];

(async () => {

    let response = await fetch(getAccountsUrl + `?userId=${userId}`);

    if (response.ok){
        accounts = await response.json();
        updateAccounts();
    }
    else{
        alert('Error: ' + response.status);
    }
})();