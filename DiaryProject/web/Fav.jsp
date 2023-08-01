<%-- 
    Document   : Home.jsp
    Created on : Mar 6, 2023, 10:54:25 PM
    Author     : Dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

        <title>MY STORY</title>
        <style>

            .header {
                display: flex;
                justify-content: space-between;
                align-items: center;
                margin: 0 0;
                background-color:#23283d;
            }

            .header__tile {
                color: red;
            }
            .header__logo{
                display:flex;
            }
            .header__logo img {
                width: 90px;
                height: 90px;

            }
            .header__search button:hover{
                background-color: purple;
            }
            .header__search button {
                background-color: black;
                color: white;
                border: none;
                outline: none;
                padding: 30px 30px;
                border-radius: 3px;
                font-family: cursive;


            }



            .content {
                background-color: black;

                display: flex;
            }

            .menu {
                /*                 width: calc((100%/12)*2);*/
                background-color: #23283d;
                flex: 1;

            }

            .navbar__left {
                color: white;
                list-style: none;
                padding: 0;
                margin: 0;
            }

            .navbar__left__link {
                padding: 20px;
            }

            .navbar__left__link a {
                color: white;
                text-decoration: none;
            }

            .navbar__left__link:hover {
                background-color: purple;
            }

            /*            .navbar__left li:first-child {
                            background-color: #85dcb8;
                        }*/


            .accessories {
                /*                width: calc((100%/12)*10);*/
            }

            .accessories__title {
                text-align: center;
                color: whitesmoke;
                padding: 20px 0;
                margin-top: 0;
            }

            .accessories__list {
                display: flex;
                flex-wrap: wrap;
                margin: 0 40px;
            }

            .accessories__list__item {

                width: calc((100%/12)*12);
                margin-bottom: 50px;

            }

            .accessories__list__item__info {
                background-color: white;
                margin: auto;
                width: 100%;
                box-shadow: 0 0 10px rgba(0, 0, 0, 1);
                border-radius: 7px;
                overflow: hidden;
                text-align: center;
                padding: 20px 0;

            }
            .accessories__list__item__info div{

                color: black;
                width: fit-content;
                margin: auto;
                padding: 10px;
                border-radius: 8px;
            }

            .accessories__list__item__info img{
                width: 100%;
            }
            .accessories__list__item__info p{
                color: wheat;
                font-weight: bold;
            }
            .accessories__list__item__info del{
                color: grey;
                font-weight: 200;
            }
            .accessories__list__item__info div{
                cursor: pointer;
            }
            .accessories__list__item__info:a{
                background-color:white;
            }
            .footer{
                text-align:center;
                background-color: rgb(0, 140, 255);
                color: white;
            }
            .footer__content{
                padding: 10px 0;
            }
            .h4{
                font-family: sans-serif;
                color: black;
                font-size: 20px;
            }
            .but a{
                text-decoration: none;
                color:white;
            }
            .image img{
                width: 300px;
                height: 300px;

            }
            .text{
                box-sizing: auto;
            }
            .text {
                width: 200px;
                height: 100px;
                font-size: 16px;
                overflow: hidden;
                text-overflow: ellipsis;
                white-space: nowrap;
            }
            .search-box{
                float:left;
                width: fit-content;
                height: fit-content;
                position: relative;
            }
            .input-search{
                height: 50px;
                width: 50px;
                border-style: none;
                padding: 10px;
                font-size: 18px;
                letter-spacing: 2px;
                outline: none;
                border-radius: 25px;
                transition: all .5s ease-in-out;
                background-color: #009879;
                padding-right: 40px;
                color:white;
            }
            .input-search::placeholder{
                color:white;
                font-size: 18px;
                letter-spacing: 2px;
                font-weight: 100;
            }
            .btn-search{
                width: 50px;
                height: 50px;
                border-style: none;
                font-size: 20px;
                font-weight: bold;
                outline: none;
                cursor: pointer;
                border-radius: 50%;
                position: absolute;
                right: 0px;
                color:#009879 ;
                background-color:transparent;
                pointer-events: painted;
            }
            .btn-search:focus ~ .input-search{
                width: 300px;
                border-radius: 0px;
                background-color: transparent;
                border-bottom:1px solid white;
                transition: all 500ms cubic-bezier(0, 0.110, 0.35, 2);
            }
            .input-search:focus{
                width: 300px;
                border-radius: 0px;
                background-color: transparent;
                border-bottom:1px solid white;
                transition: all 500ms cubic-bezier(0, 0.110, 0.35, 2);
            }
            .search-box img{
                width:20px;
                height:20px
            }
        </style>
    </head>
    <body>

        <div class="header">
            <div class="header__logo">
                <img src="pic/flowers.png">
                <p style="color:wheat;font-weight:bold;margin: 0 auto;text-align: center">Your Story</p>

            </div>         
            <div class="row header__search">
                <c:if test = "${sessionScope.user != null}">

                    <button class="col-md-6 but"><a href="information">INFO</a></button>
                    <button class="col-md-6 but"><a href="logout">LOG OUT</a></button>
                </c:if>
                <c:if test = "${sessionScope.user == null}">
                    <div class ="col-md-12">
                        <button class=but><a href="login">LOG IN</a></button>
                    </div>
                </c:if>
            </div>
        </div>
        <div class="row content">

            <c:if test = "${sessionScope.user != null}">
                <div class="col-md-2 menu">
                    <!--You will code the menu content here-->
                    <ul class="navbar__left">

                        <li class="navbar__left__link">Menu</li>
                        <li class="navbar__left__link"><a href="Home.jsp">Home</a></li>

                        <li class="navbar__left__link"><a href="manageBlog">Manage Blog</a></li>
                        <li class="navbar__left__link"><a href="favblog">Favourite List</a></li>
                            <c:if test="${sessionScope.user.isAdmin == 1}">
                            <li class="navbar__left__link"><a href="manageaccount">Manage Account</a></li>
                            </c:if>
                         



                    </ul>
                </div>

                <div class="col-md-10 accessories">
                    <form action="searchuser" method="post">
                        <div class="search-box">
                            <button class="col-md-6 btn-search"><i class="fas fa-search"><img src="https://icon-library.com/images/search-icon-white/search-icon-white-16.jpg" width="20" height="20"  alt="alt"/></i></button>
                            <input type="text" name="username" class="input-search" placeholder="Another life's story">  
                        </div>
                    </form>
                    <h1 class="accessories__title">Dear ${sessionScope.user.name}</h1>

                    <h2 class="accessories__title">"FAVOURITE STORY"</h2>

                    <div class="accessories__list">
                        <c:forEach items="${data}" var="item">
                            <div class="accessories__list__item">

                                <div class="row accessories__list__item__info">
                                    <div class="col-md-3 image ">
                                        <img src=${item.getImage()} alt="image" />
                                    </div>
                                    <div class="col-md-9 ">
                                        <div style='font-weight: bold;font-size:20px;font-family: sans-serif'>
                                            ${item.getTitle()}
                                        </div>
                                        <div >
                                            ${item.getText()}
                                        </div>

                                        <div style='float: right;color: red'>
                                            Date : ${item.getDate()}
                                        </div>
                                    </div>
                                                         
                            
                               </div>

</div>
                                            

                        </c:forEach>



                    

                
                <div style="clear: both;"></div>
            </c:if>
        </div> 

    </div>

    <!----------------------------------------------------------------------------------------------->

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>


</body>
</html>
