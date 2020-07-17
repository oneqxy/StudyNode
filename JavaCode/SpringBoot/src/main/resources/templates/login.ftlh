<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
</head>
<body>
<h1>登录页面</h1>
<hr/>
<h3 style="color: red">${msg!}</h3>
<form method="post" action="login">
    用户名 ：<input type="text" name="username"><br>
    密 码 ：<input type="password" name="password"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>