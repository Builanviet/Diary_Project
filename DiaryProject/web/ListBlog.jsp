<%-- 
    Document   : Home.jsp
    Created on : Mar 6, 2023, 10:54:25 PM
    Author     : Dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Blog"%>
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
                color:black;
            }
            .input-search::placeholder{
                color:black;
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
                border-bottom:1px solid black;
                transition: all 500ms cubic-bezier(0, 0.110, 0.35, 2);
            }
            .input-search:focus{
                width: 300px;
                border-radius: 0px;
                background-color: transparent;
                border-bottom:1px solid black;
                transition: all 500ms cubic-bezier(0, 0.110, 0.35, 2);
            }

            .but a{
                text-decoration: none;
                color:white;
            }
            .edit-button {
                border: none;
                background-color: transparent;
                cursor: pointer;
            }

            .edit-button:hover {
                box-shadow: 0 0 10px rgba(0, 0, 255, 0.5);
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
            .alarm{
                display: none;
                background-color: #4CAF50;
                color: green;
                text-align: center;
                padding: 10px;
            }
            .icon img:hover {
                background-color: purple;
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

                <button class="col-md-6 but"><a href="information">INFO</a></button>
                <button class="col-md-6 but"><a href="logout">LOG OUT</a></button>

            </div>
        </div>
        <div class="row content">
            <div class="col-md-2 menu">
                <!--You will code the menu content here-->
                <ul class="navbar__left">
                    <li class="navbar__left__link">Menu</li>
                    <li class="navbar__left__link"><a href="home">Home</a></li>
                    <li class="navbar__left__link"><a href="manageaccount">Back</a></li>
                </ul>
            </div>
            <div class="col-md-10 accessories">
                
                <h1 class="accessories__title">VIEW STORY</h1>
                <div class="alarm">${mess}</div>
               
               <form action="searchlistblog" method="post">
                    <div class="search-box">
                        <button class="col-md-6 btn-search"><i class="fas fa-search"><img src="https://pic.onlinewebfonts.com/svg/img_194915.png" width="20" height="20"  alt="alt"/></i></button>
                        <input type="text" name="text" class="input-search" placeholder="Search Tittle or Text...">  
                    </div>
                </form>
                
                <form action="findblogbyacc" method="post">
                    <select name="acc">
                        <option value="all">All</option>
                        <c:forEach items="${sessionScope.acc}" var="item">
                            <option value="${item.getId()}">
                                ${item.getUsername()}
                        </option>
                        </c:forEach>
                    </select>
                    <button type="submit" name="submit">FIND</button>
                </form>

                <table class="styled-table">
                    <thead>
                        <tr>

                            <th>TITLE</th>
                            <th>DATE
                                </th>
                            <th>IMAGE</th>
                            <th>TEXT</th>
                            <th>EDIT</th>
                        </tr>
                    </thead>
                    <div class="alo">
                        <c:forEach items="${data}" var="item">
                            <tr>

                                <td>${item.getTitle()}</td>
                                <td>${item.getDate()}</td>
                                <td align="center" width="350px"><img src="${item.getImage()}" width="350px"
                                                        alt="alt"/></td>
                                <td>${item.getText()}</td> 
                                <td>                      
                                   
                                    <button class="edit-button"><a href="deleteuserblog?bid=${item.getId()}"><img src="https://cdn-icons-png.flaticon.com/512/3405/3405244.png" width="20" height="20" alt="alt"/></a></button>
                                </td>

                            </tr>
                        </c:forEach>
                    </div>
                </table>

            </div>
            <div style="clear: both;"></div>
        </div> 

    </div>

    <!----------------------------------------------------------------------------------------------->

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>


</body>
</html>
