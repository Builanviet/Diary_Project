<%-- 
    Document   : Home.jsp
    Created on : Mar 6, 2023, 10:54:25 PM
    Author     : Dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Account"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>

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
                background-color: white;

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
                color: #ff7f50;
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

                color: white;
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
            .styled-table {
                border-collapse: collapse;
                width: 100%;
                font-size: 0.9em;
                font-family: sans-serif;
                box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
                margin: 25px 0;
            }

            .styled-table thead tr {
                background-color: #009879;
                color: #ffffff;
                text-align: left;
            }
            .styled-table th{
                font-weight: bold;
                text-align: center;
            }
            .styled-table th,
            .styled-table td {
                padding: 12px 15px;
            }

            .styled-table tbody tr {
                border-bottom: 1px solid #dddddd;
            }

            .styled-table tbody tr:nth-of-type(even) {
                background-color: #f3f3f3;
            }

            .styled-table tbody tr:last-of-type {
                border-bottom: 2px solid #009879;
            }
            .styled-table tr:hover {
                background-color: #ddd;
            }
            .search-box{

                width: fit-content;
                height: fit-content;
                position: relative;
            }
            .edit-button {
                border: none;
                background-color: transparent;
                cursor: pointer;
            }

            .edit-button:hover {
                box-shadow: 0 0 10px rgba(0, 0, 255, 0.5);
            }
            .edit-button a{
                text-decoration: none;
                color: black;
            }
            .my-button {
                background-color: #1abc9c;
                border: none;
                color: #ffffff;
                padding: 10px 20px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                cursor: pointer;
                border-radius: 20px;
                transition: background-color 0.5s ease;
                box-shadow: 2px 2px 6px rgba(0, 0, 0, 0.2);
                float:right;
            }

            .my-button:hover {
                background-color: #148f77;
            }
            .my-button a{
                text-decoration: white;
                color: white;
            }
            .ab a{
                text-decoration: none;
                color: white;
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

                <button class="col-md-6 ab"><a href="information">INFO</a></button>
                <button class="col-md-6 ab"><a href="logout">LOG OUT</a></button>

            </div>
        </div>
        <div class="row content">
            <div class="col-md-2 menu">
                <!--You will code the menu content here-->
                <ul class="navbar__left">
                    <li class="navbar__left__link">Menu</li>
                    <li class="navbar__left__link"><a href="home">Home</a></li>

                </ul>
            </div>
            <div class="col-md-10 accessories">
                <h1 class="accessories__title">Account Management</h1>
<!--                <div>
                    <button class="my-button"><a href="listblog">MANAGE ALL BLOG</a></button>

                </div>-->


                <table class="styled-table">
                    <thead>
                        <tr>
                            <td>id</td>
                            <td>username</td>
                            <td>password</td>
                            <td>Delete account</td>

                        </tr>
                    </thead>
                    <c:forEach items="${data}" var="item">
                        <tr>
                            <td>${item.getId()}</td>
                            <td>${item.getUsername()}</td>
                            <td>${item.getPassword()}</td>
                            <!--                            <td>
                                                               <button class="edit-button"><a href="deleteaccount?bid=${item.getId()}"><img src="https://cdn-icons-png.flaticon.com/512/3405/3405244.png" width="20" height="20" alt="alt"/></a></button>
                                                        </td>-->
                            <td> <button class="edit-button"><a href="deleteaccount?bid=${item.getId()}"><img src="https://cdn-icons-png.flaticon.com/512/3405/3405244.png" width="20" height="20" alt="alt"/></a></button>
<!--                                <button class="edit-button"><a href="viewuserblog?bid=${item.getId()}"> VIEW STORY </a> </button>-->
                            </td>      
                            
                        </tr>
                    </c:forEach>
                </table>
                <!--                <h2 class="accessories__title">"Every story starts with an idea, but it is the characters that move this idea forward."</h2>-->
                <!--                <div class="accessories__list">
                                    <div class="accessories__list__item">
                                        <div class="row accessories__list__item__info">
                                            <div class="col-md-3 ">
                                            <img src="pic/flowers.png" alt="GigaByte" />
                                            </div>
                                            <div class="col-md-9 ">
                                            <p name="title">Tôi bị Đinh Quang Thuận bỏ rơi</p>
                                            <p> Thuận là một thằng xấu tính vkl nó yêu thầm đỗ hương thảo</p>
                                            <div>Buy Now</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="accessories__list__item">
                                        <div class="accessories__list__item__info">
                                            <img src="images/VGAGreeForce.jpg" alt="Greeforce" />
                                            <h4> Card Video 4GB- GreeForce</h4>
                                            <p> <del>270$ </del> &nbsp; &nbsp;  255$ </p>
                                            <div>Buy Now</div>
                                        </div>
                                    </div>
                
                                    <div class="accessories__list__item">
                                        <div class="accessories__list__item__info">
                                            <img src="images/CameraYoosee.jpg" alt="Camera Yoosee" />
                                            <h4>Camera Yoosee</h4>
                                            <p> <del>45$</del> &nbsp; &nbsp;  38$ </p>
                                            <div>Buy Now</div>
                                        </div>
                                    </div>
                
                                    <div class="accessories__list__item">
                                        <div class="accessories__list__item__info">
                                            <img src="images/DDR5.jpg" alt="Kingston" />
                                            <h4>DDR5-16GB -5200 </h4>
                                            <p> <del>200$ </del> &nbsp; &nbsp;  182$ </p>
                                            <div>Buy Now</div>
                                        </div>
                                    </div>
                
                                    <div class="accessories__list__item">
                                        <div class="accessories__list__item__info">
                                            <img src="images/MouseGM68.jpg" alt="Gamer" />
                                            <h4>Mouse GM-68 </h4>
                                            <p> <del>28$ </del> &nbsp; &nbsp;  23$ </p>
                                            <div>Buy Now</div>
                                        </div>
                                    </div>
                
                                    <div class="accessories__list__item">
                                        <div class="accessories__list__item__info">
                                            <img src="images/X7Led.jpg" alt="Gamer" />
                                            <h4>Earphone X7-Led </h4>
                                            <p> <del>28$ </del> &nbsp; &nbsp;  23$ </p>
                                            <div>Buy Now</div>
                                        </div>
                                    </div>
                
                                </div>-->
            </div>
            <div style="clear: both;"></div>
        </div> 

    </div>

    <!----------------------------------------------------------------------------------------------->

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>


</body>
</html>
