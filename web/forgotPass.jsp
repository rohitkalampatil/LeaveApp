
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Leave Application - Forgot Password</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.0/flowbite.min.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.0/flowbite.min.js"></script>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            .mb-12{
                padding-bottom: 100px;
            }
        </style>
    </head>
    <body>
        <%  //   no chache stored, page will not display after logout
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");


        %>
        <header>
            <nav class="bg-white shadow dark:bg-gray-900 fixed w-full z-20 top-0 left-0 border-b border-gray-200 dark:border-gray-600">
                <div class="max-w-screen-xl flex flex-wrap items-center justify-between mx-auto p-4">
                    <a href="Home.html" class="flex items-center">
                        <img src="logo.png" class="h-8 mr-3" alt="Logo">
                        <span class="self-center text-2xl font-semibold whitespace-nowrap dark:text-white">LeaveApp</span>
                    </a>
                </div>
            </nav>
        </header>
        <section class="py-12 mb-12 bg-gray-100 dark:bg-gray-900">
            <div class="flex flex-col items-center justify-center px-2 py-12 mx-auto md:h-screen lg:py-12 sm:py-12 ">
                <a href="Home.html" class="flex items-center mb-6 text-2xl font-semibold text-gray-900 dark:text-white">
                    <img class="w-8 h-8 mr-2" src="logo.png" alt="logo">
                    Leave Application   
                </a>
                <div class="w-96 bg-white rounded-lg shadow dark:border md:mt-0 sm:max-w-md xl:p-0 dark:bg-gray-800 dark:border-gray-700">
                    <div class="p-6 space-y-4 md:space-y-6 sm:p-8">
                        <h1 class="text-xl font-bold leading-tight tracking-tight text-gray-900 md:text-2xl dark:text-white">
                            Forgot your password?
                        </h1>
                        <p class="font-light text-gray-500 dark:text-gray-400">Don't fret! Just type in your email and we will send you a code to reset your password!</p>
                        <!-- -----------------------  Form ----------------------- -->
                        <form class="mt-4 space-y-4 lg:mt-5 md:space-y-5" action="UserVerify" method="post">
                            <div>
                                <label for="username" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Enter user id</label>
                                <input type="text" value="<%= request.getParameter("username") == null ? "" : request.getParameter("username")%>" onkeyup="this.value = this.value.replace(/[^a-zA-Z0-9_]/g, '')" name="username" maxlength="12" minlength="3" id="username" class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="ex.admin" required="">
                            </div>
                            <div>
                                <label for="useremail" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Your email</label>
                                <input type="email" name="useremail" id="useremail" class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="name@company.com" required="">
                            </div>
                            <div class="flex items-start">
                                <div class="flex items-center h-5">
                                    <input id="terms" aria-describedby="terms" type="checkbox" class="w-4 h-4 border border-gray-300 rounded bg-gray-50 focus:ring-3 focus:ring-primary-300 dark:bg-gray-700 dark:border-gray-600 dark:focus:ring-primary-600 dark:ring-offset-gray-800" required="">
                                </div>
                                <div class="ml-3 text-sm">
                                    <label for="terms" class="font-light text-gray-500 dark:text-gray-300">I accept the <a class="font-medium text-primary-600 hover:underline dark:text-primary-500" href="#">Terms and Conditions</a></label>
                                </div>
                            </div>
                            <div class="flex items-center justify-between">
                                <div class="flex items-start">
                                    <span id="error" class="self-center text-red-600 font-semibold  dark:text-white"><%= session.getAttribute("error") == null ? "" : session.getAttribute("error")%></span>
                                </div>
                                 </div>
                            <button type="submit" class="w-full text-white bg-blue-600 hover:bg-blue-700 focus:ring-4 focus:outline-none focus:ring-primary-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800">Reset password</button>
                        </form>
                    </div>
                </div>
            </div>
        </section>
        <footer class="bg-white rounded-lg shadow m-4 dark:bg-gray-800">
            <div class="w-full mx-auto max-w-screen-xl p-4 md:flex md:items-center md:justify-between">
                <span class="text-sm  text-gray-500 sm:text-center dark:text-gray-400">© 2023 <a href="Home.html" class="hover:underline">LeaveApp.com™</a>. All Rights Reserved.
                </span>
            </div>
        </footer>

        <script >
            function alertNamefun() {

                var status = '<%= session.getAttribute("sts")%>';

                if (status === "F") {
                 
                    alert("Wrong email");       
                }
                
            }
        </script>

        <script>
            window.onload = alertNamefun;
        </script>

        <% session.setAttribute("sts", null);%>
    </body>
</html>
