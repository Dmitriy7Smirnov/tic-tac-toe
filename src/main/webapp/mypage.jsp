<%--
  Created by IntelliJ IDEA.
  User: PMY Archon
  Date: 03.01.2017
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        .myField {
            border: solid 1px black;
            width:100px;
            height: 100px;
            background-color: red;
            display: inline-block;
            text-align: center;
            float: left;
            line-height: 100px;
            font-size: xx-large;
            overflow-y: hidden;
        }

        .wrapper {
            float: none;
            display: table-row;
        }

        a.button24 {
            display: inline-block;
            color: white;
            text-decoration: none;
            padding: .5em 2em;
            outline: none;
            border-width: 2px 0;
            border-style: solid none;
            border-color: #FDBE33 #000 #D77206;
            border-radius: 6px;
            background: linear-gradient(#F3AE0F, #E38916) #E38916;
            transition: 0.2s;
        }
        a.button24:hover { background: linear-gradient(#f5ae00, #f59500) #f5ae00; }
        a.button24:active { background: linear-gradient(#f59500, #f5ae00) #f59500; }


    </style>
    <script src="http://code.jquery.com/jquery-3.1.1.js"></script>

    <title>Devcolibri.com</title>
</head>
<body>
    <h1>Hello ${name}</h1>
    <form action="http://localhost:8080/alesson27-1.0/test1" method="post">
        Username: <input type="text" name="login"/>
        Password: <input type="text" name="password" />
        <input type="submit" value="Submit" />
    </form>

        <div class="wrapper">
            <div class="myField" id="0"></div> <div class="myField" id="1"></div> <div class="myField" id="2"></div>
        </div>
        <div class="wrapper">
            <div class="myField" id="10"></div> <div class="myField" id="11"></div> <div class="myField" id="12"></div>
        </div>
        <div class="wrapper">
            <div class="myField" id="20"></div> <div class="myField" id="21"></div> <div class="myField" id="22"></div>
        </div>
    </div>

    <br />

    <a href="/test" class="button24">New game</a>


    <script>
        $(".myField").click(function(){
            var myId = $(this).attr("id");
                //alert("fuck");
            $.post("http://localhost:8080/test/test1", {login : "Dima", id : myId}).done(function(data){
                $("div#"+data.id).text(data.symbol);
                if(data.isWon) {
                    alert(data.msg);
                }
                $("div#" + data.id1).text(data.symbol1);

                //alert(data.password1);
                //var obj = $.parseJSON(data);
                //alert(obj.toArray[1]);
            });
            //alert("you");
        });

        $(".button24").click(function(){
            var myId = $(this).attr("id");
            $.post("http://localhost:8080/test/test1", {login : "Dima", id : "777"}).done(function(data){

            });
        });

    </script>
</body>
</html>
