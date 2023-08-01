<%-- 
    Document   : AddBlog
    Created on : Mar 13, 2023, 10:43:51 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MY STORY</title>
        <style>
            /* Style inputs with type="text", select elements and textareas */
            
            input[type=text], select, textarea {
                width: 100%; /* Full width */
                padding: 12px; /* Some padding */
                border: 1px solid #ccc; /* Gray border */
                border-radius: 4px; /* Rounded borders */
                box-sizing: border-box; /* Make sure that padding and width stays in place */
                margin-top: 6px; /* Add a top margin */
                margin-bottom: 16px; /* Bottom margin */
                resize: vertical /* Allow the user to vertically resize the textarea (not horizontally) */
            }

            /* Style the submit button with a specific background color etc */
            input[type=submit] {
                background-color: #04AA6D;
                color: white;
                padding: 12px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            /* When moving the mouse over the submit button, add a darker green color */
            input[type=submit]:hover {
                background-color: #009879;
            }

            /* Add a background color and some padding around the form */
            .container {
                border-radius: 5px;
                background-color: #f2f2f2;
                padding: 20px;
            }
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
                color: black;
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
            .label{
                font-family: sans-serif;
            }
            .container{
                width: 50%;
                display:block; 
                margin-left:auto; 
                margin-right:auto;
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
                <button class="col-md-6 but"><a href="manageBlog">BACK</a></button>
                
            </div>
        </div>
         <div>
           
            
               <h1 class="accessories__title">ADD NEW STORY</h1>
            
            <div class="container">
              <form action="addblog" method="post">  
                <p class="text-danger">${mess}</p>
                <label for="subject">Title</label>
                <textarea id="subject" name="title" placeholder="Write your title.." style="height:100px" required="required"></textarea>
                <label for="fname">Date</label>
                <input type="date" name="date" value="0000-00-00" required="required">
                <br>
                <label for="fname">Image</label>
                <input type="text" name="image" placeholder="Image link.." required="required">
                  <label for="subject">Text</label>
                <textarea id="subject" name="text" placeholder="Write your story.." style="height:200px" required="required"></textarea>
                <input type="submit" value="Save">
            </form>
            </div>
            
             
         </div>
    </body>
</html>
