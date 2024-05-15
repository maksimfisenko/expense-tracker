const categoryForm = `
    <h2 class="form-title"> Add Category </h2>
    <form class="form-body" id="category-form">
        <input type="text" placeholder="Category Name" id="category-name-input"><br>
        <label for="color-picker">Category Color: </label>
        <input type="color" name="color-picker" id="color-picker"><br>
        <input type="submit" value="Add Category">
    </form>
    <button class="pop-up" onclick="closePopUp();"> Close Window </button>
`;

const spendForm = `
    <h2 class="form-title"> Add Expense </h2>
    <form class="form-body" id="spend-form">
        <label for="account-selector"> Account: </label>
        <select class="account-selector" id="account-selector" name="account-selector"> </select><br>
        <label for='category-selector'> Category: </label>
        <select id='category-selector' name='category-selector'> </select><br>
        <label for='sub-selector'> Subcategory: </label>
        <select id='sub-selector' name='sub-selector'> </select><br>
        <input type="number" min="0" placeholder="Amount" id="spend-amount"><br>
        <input type="submit" value="Add">
    </form>
    <button class="pop-up" onclick="closePopUp();"> Close Window </button>
`;

const subForm = `
    <h2 class="form-title"> Add subcategory </h2>
    <form class="form-body" id="sub-form">
        <label for='category-selector'> Category: </label>
        <select id='category-selector' name='category-selector'> </select><br>
        <input type="text" placeholder="Subcategory name" id="sub-name-input"><br>
        <input type="submit" value="Add Subcategory">
    </form>
    <button class="pop-up" onclick="closePopUp();"> Close Window </button>
`;

const addMoneyForm = `
    <h2 class="form-title"> Add Money </h2>
    <form class="form-body" id="income-form">
        <label for="account-selector"> Account: </label>
        <select class="account-selector" id="account-selector" name="account-selector"> </select><br>
        <input type="number" min="0" placeholder="Amount" id="add-amount-input"><br>
        <input type="submit" value="Add">
    </form>
    <button class="pop-up" onclick="closePopUp();"> Close this window </button>
`;

const transferForm = `
    <h2 class="form-title"> Transfer Money </h2>
    <form class="form-body" id="transfer-form">
        <label for="account1-selector"> Sending Account: </label>
        <select class="account-selector" id="account1-selector" name="account1-selector"> </select><br>
        <label for="account2-selector"> Receiving Account: </label>
        <select class="account-selector" id="account2-selector" name="account2-selector"> </select><br>
        <input type="number" min="0" placeholder="Amount" id="add-amount-input"><br>
        <input type="submit" value="Transfer">
    </form>
    <button class="pop-up" onclick="closePopUp();"> Close Window </button>
`;

const addAccountForm=`
    <h2 class="form-title"> New Account </h2>
    <form class="form-body" id="account-form">
        <input type="text" placeholder="Name of the account" id="add-account-input"><br>
        <input type="submit" value="Add Account">
    </form>
    <button class="pop-up" onclick="closePopUp();"> Close Window </button>
`;

function categorySelectorSetUp(mode="EXPENSE"){
    let categorySelect = document.getElementById('category-selector');
    categorySelect.innerHTML = '';
    categories.forEach(category =>{
            if (category.type == mode)
            categorySelect.innerHTML += `
                <option value='${category.name}'> ${category.name} </option>
            `;
    });
}

function accountSelectorSetUp(){
    const selectors = document.getElementsByClassName('account-selector');
    Array.from(selectors).forEach(selector => {
        selector.innerHTML = '';
        accounts.forEach(account => {
            selector.innerHTML += `
                <option value="${account.name}"> ${account.name} </option>
            `;
        });
    });
}

function popUp(popUpTar, mode="EXPENSE"){
    window.mode = mode;
    const overlay = document.getElementById('pop-up-overlay');
    overlay.classList.toggle('show');
    const box = document.getElementById('box');
    box.innerHTML = '';
    let close = false;
    switch (popUpTar){  
        case 'category': {
            box.innerHTML += categoryForm;
            let form = document.getElementById('category-form');
            form.addEventListener('submit', addCategory);
            break;
        }
        case 'spend': {
            if (categories.length == 0){
                alert("Create Category First!");
                close = true;
                break;
            }
            else{
                box.innerHTML += spendForm;
                let form = document.getElementById('spend-form');
                form.addEventListener('submit', addSpend);
                categorySelectorSetUp(window.mode);
                accountSelectorSetUp();
                let subSelect = document.getElementById('sub-selector');
                let categorySelect = document.getElementById('category-selector');
                categorySelect.addEventListener('change', (event) => {
                    subSelect.innerHTML = '';
                    const categoryName = event.target.value;
                    let curCategory;
                    categories.forEach(category => {
                        if (category.name == categoryName)
                            curCategory = category;
                    });
                    curCategory.subs.forEach(sub => {
                        subSelect.innerHTML += `
                            <option value='${sub.name}'> ${sub.name} </option>
                        `;
                    });
                });
                let event = new Event('change');
                categorySelect.dispatchEvent(event);
                break;
            }
        }
        case 'sub': {
            if (categories.length == 0){
                alert("Create Category First!");
                close = true;
                break;
            }
            else{
                box.innerHTML += subForm;
                let form = document.getElementById('sub-form');
                form.addEventListener('submit', addSub);
                categorySelectorSetUp(window.mode);
                break;
            }
        }
        case 'add': {
            box.innerHTML += addMoneyForm;
            let form = document.getElementById('income-form');
            form.addEventListener('submit', addMoney);
            accountSelectorSetUp();
            break;
        }
        case 'transfer': {
            box.innerHTML += transferForm;
            let form = document.getElementById('transfer-form');
            form.addEventListener('submit', transferMoney);
            accountSelectorSetUp();
            if (accounts.length > 1){
                document.getElementById('account2-selector').value = accounts[1].name;
            }
            break;
        }
        case 'account': {
            box.innerHTML += addAccountForm;
            let form = document.getElementById('account-form');
            form.addEventListener('submit', addAccount);
            break;
        }
    }
    box.classList.toggle('show');

    let body = document.body
    let html = document.documentElement;

    let height = Math.max( body.scrollHeight, body.offsetHeight, 
                       html.clientHeight, html.scrollHeight, html.offsetHeight);
    overlay.style.height = `${height}px`;
    if (close)
        closePopUp();
}

function closePopUp(){
    const overlay = document.getElementById('pop-up-overlay');
    overlay.classList.toggle('show');
    const box = document.getElementById('box');
    box.classList.toggle('show');
}