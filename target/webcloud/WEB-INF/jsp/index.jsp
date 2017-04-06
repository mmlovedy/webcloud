<!--<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
-->
<html xmlns:v-on="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="../css/bootstrap.min.css" />
    <title>这只是一个测试</title>

</head>
<body>
    <script src="../js/vue.js"></script>
    <div id="myVue">
        <form action="/insert.do" class="form-group">
            <div class="col-md-8 col-md-offset-2">
                <h2>{{user.nickname}}</h2>
                <input type="text" v-model="user.nickname" class="form-control">
                <button type="submit" class="btn-success">申请</button>
            </div>
        </form>
    </div>

<script type="text/javascript">

    new Vue({
        el : "#myVue",
        data: {
            user : {
                id : 0,
                state : 0,
                nickname : ""
            }
        },

        methods : {
            submit (user)  {
                alert("test");
            }
        }

    });

</script>
</body>
</html>