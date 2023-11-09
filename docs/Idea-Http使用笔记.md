1. 模仿form表单POST请求
    ```text
    POST http://127.0.0.1:9085/login
    Content-Type: application/x-www-form-urlencoded
    
    username=test&password=123
    ```
2. 带body体的POST请求
    ```text
    POST http://127.0.0.1:9085/login
    Content-Type: application/json
    
    {
      "username":"test",
      "password":"123456"
    }
    ```
3. 带状态的GET请求
    ```text
    GET http://127.0.0.1:9085/api/item/list
    Cookie: JessionId=TG4OKFVOZP6A9ML4
    Authorization: Bearer TG4OKFVOZP6A9ML4
    ```
4. ptr、 ptrp 快捷键生成请求地址
5. 将登录token放入全局变量

    ```
    ###
    POST http://localhost:8000/user/login
    Content-Type: application/json
    
    {
      "mobile": "13000000001",
      "code": "8888"
    }
    
    > {%
    client.log(JSON.stringify(response.body));
    client.log(JSON.stringify(response.body.content.token));
    client.global.set("token", response.body.content.token);
    %}
    ```
6. 从全局变量中读取变量
    ```
    POST http://localhost:8000/member/passenger/save
    Content-Type: application/json
    token: {{token}}
    
    {
      "memberId": "1",
      "name": "test",
      "idCard": "123321",
      "type": "1"
    }
    ```
7. 

    