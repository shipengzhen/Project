const root = '/pet/api/';

// const API_BASE_URL = 'http://fly2you.cn' + root;
const API_BASE_URL = 'http://localhost:8080' + root;
module.exports = {
    Login: API_BASE_URL + 'auth/login', //账号登录
};
