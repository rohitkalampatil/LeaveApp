
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" type="image/png" href="logo.png"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login - HOD</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.0/flowbite.min.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.0/flowbite.min.js"></script>
    </head>
    <body>
        <!-- //////------------------------ Navigation bar  --------------------\\\\\\\ -->
        <header>
            <nav class="bg-white shadow dark:bg-gray-900 fixed w-full z-20 top-0 left-0 border-b border-gray-200 dark:border-gray-600">
                <div class="max-w-screen-xl flex flex-wrap items-center justify-between mx-auto p-4">
                    <a href="index.html" class="flex items-center">
                        <img src="logo.png" class="h-8 mr-3" alt="Logo">
                        <span class="self-center text-2xl font-semibold whitespace-nowrap dark:text-white">LeaveApp</span>
                    </a>
                </div>
            </nav>
        </header>
        <!-- //////------------------------  login section ------------------------\\\\\\\ -->
        <section class="py-12 bg-gray-100 dark:bg-gray-900">
            <div class="flex flex-col items-center justify-center px-2 py-12 mx-auto md:h-screen lg:py-12 sm:py-12 ">
                <a href="index.html" class="flex items-center mb-6 text-2xl font-semibold text-gray-900 dark:text-white">
                    <img class="w-8 h-8 mr-2" src="logo.png" alt="logo">
                    Department Head Login    
                </a>
                <div class="w-96 bg-white rounded-lg shadow dark:border md:mt-0 sm:max-w-md xl:p-0 dark:bg-gray-800 dark:border-gray-700">
                    <div class="p-6 space-y-4 md:space-y-6 sm:p-8">
                        <h1 class="text-xl font-bold leading-tight tracking-tight text-gray-900 md:text-2xl dark:text-white">
                            Sign in to your account
                        </h1>
                        <!-- -----------------------  Form ----------------------- -->
                        <form class="space-y-4 md:space-y-6" action="Login" method="POST">
                            <!-- ----------------------- userid ------------------------ -->
                            <div>
                                <label for="userid" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Enter user id</label>
                                <input type="text" value="<%= session.getAttribute("userid") == null ? "" : session.getAttribute("userid")%>" onkeyup="this.value = this.value.replace(/[^a-zA-Z0-9_]/g, '')" name="userid" maxlength="30" minlength="3" id="userid" class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="ex.admin" required="">
                            </div>
                            <!-- ----------------------- password ------------------------ -->
                            <div>
                                <label for="password" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Password</label>
                                <input type="password" onclick="document.getElementById('error').innerHTML = ''" maxlength="8" name="password" id="password" placeholder="••••••••" class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required="">
                            </div>
                            <!-- ------------------Error message forgot pass  ------------------------ -->
                            <div class="flex items-center justify-between">
                                <div class="flex items-start">
                                    <span id="error" class="self-center text-red-600 font-semibold  dark:text-white"><%= session.getAttribute("error") == null ? "" : session.getAttribute("error")%></span>
                                </div>
                                <a href="error404.html" class="text-sm font-medium text-primary-600 hover:underline dark:text-primary-500">Forgot password?</a>
                            </div>
                            <button type="submit" class="w-full text-blue bg-blue-600 hover:bg-blue-700 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Sign in</button>
                        </form>
                    </div>
                </div>
            </div>
        </section>
        <!-- //////------------------- footer section  -----------------\\\\\\\ -->
        <footer class="bg-white rounded-lg shadow m-4 dark:bg-gray-800">
            <div class="w-full mx-auto max-w-screen-xl p-4 md:flex md:items-center md:justify-between">
                <span class="text-sm  text-gray-500 sm:text-center dark:text-gray-400">© 2023 <a href="index.html" class="hover:underline">LeaveApp.com™</a>. All Rights Reserved.
                </span>
            </div>
        </footer>

        <script >
            function alertNamefun() {

                setTimeout(fundiss, 3000);
                function fundiss() {
                    document.getElementById("error").innerHTML = '<% session.setAttribute("error", "");%>';
                }
                var status = '<%= session.getAttribute("status")%>';

                if (status === "success") {
                    alert("updated success");       
                }
                if (status === "failed") {
                    alert(${erroralert});
                }
            }
        </script>

        <script>
            window.onload = alertNamefun;
        </script>
        <% session.setAttribute("status", null);%>
        <% session.setAttribute("status", null);%>
    </body>
</html>
