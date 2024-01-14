
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

        <script>
            document.addEventListener('DOMContentLoaded', function () {

                // Get banner element
                var banner = document.getElementById('banner');

                // Toggle the banner's visibility based on the showBanner variable
                if (<%=session.getAttribute("sts")%>) {
                    banner.style.display = 'flex';

                }

                // Close the banner and update the session when the button is clicked
                document.getElementById('closeBanner').addEventListener('click', function () {
                    banner.style.display = 'none';
            <% session.setAttribute("sts", null);%>

                });
            });
        </script>
    </head>
    <body>

        <!-- //////------------------------ Navigation bar  --------------------\\\\\\\ -->
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

        <div id="banner" tabindex="-1"
             class="hidden fixed z-50 gap-8 justify-between items-start py-3 px-4 w-full bg-green-500 border border-b border-green-200 sm:items-center dark:border-gray-700 lg:py-4 dark:bg-gray-800" style="top:64px;">
            <!-- Adjusted top value to match the height of the navbar -->
            <p class="text-sm font-light text-gray-500 dark:text-gray-400">
                <strong>Your password has been successfully changed. You can now use your new credentials to log in securely.</strong> </p>
            <button id="closeBanner" type="button"
                    class="flex items-center text-gray-400 hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 dark:hover:bg-gray-600 dark:hover:text-white">
                <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd"
                      d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
                      clip-rule="evenodd"></path>
                </svg>
            </button>
        </div>
        <!-- //////------------------------  login section ------------------------\\\\\\\ -->
        <section class="py-12 bg-gray-100 dark:bg-gray-900">
            <div class="flex flex-col items-center justify-center px-2 py-12 mx-auto md:h-screen lg:py-12 sm:py-12 ">
                <a href="Home.html" class="flex items-center mb-6 text-2xl font-semibold text-gray-900 dark:text-white">
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
                                <a href="forgotPass.jsp?username=<%= session.getAttribute("userid") == null ? "" : session.getAttribute("userid")%>" class="text-sm font-medium text-primaerror404.htmlry-600 hover:underline dark:text-primary-500">Forgot password?</a>
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
                <span class="text-sm  text-gray-500 sm:text-center dark:text-gray-400">© 2023 <a href="Home.html" class="hover:underline">LeaveApp.com™</a>. All Rights Reserved.
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
                   alert("Failed to Update");
                }
            }
        </script>

        <script>
            window.onload = alertNamefun;
        </script>
        <% session.setAttribute("status", null);%>

    </body>
</html>
