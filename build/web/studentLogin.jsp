

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Sign in - Students</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.0/flowbite.min.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.0/flowbite.min.js"></script>

    </head>
    <body>
        <div class="flex flex-col items-center justify-center px-2 py-8 mx-auto md:h-screen lg:py-8">
            <a href="index.html" class="flex items-center mb-6 text-2xl font-semibold text-gray-900 dark:text-white">
                <img class="w-8 h-8 mr-2" src="logo.png" alt="logo">
                LeaveApp    
            </a>
            <div class="w-96 bg-white rounded-lg shadow dark:border md:mt-0 sm:max-w-md xl:p-0 dark:bg-gray-800 dark:border-gray-700">
                <div class="p-6 space-y-4 md:space-y-6 sm:p-8">
                    <h1 class="text-xl font-bold leading-tight tracking-tight text-gray-900 md:text-2xl dark:text-white">
                        Sign in to your account
                    </h1>

                    <form class="space-y-4 md:space-y-6" method="POST" action="LoginStudent">

                        <div>
                            <label for="prn" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Your prn</label>
                            <input type="text"  maxlength="12" onkeyup="this.value = this.value.replace(/[^0-9]/g, '')" value="<%= session.getAttribute("prn") == null ? "" : session.getAttribute("prn")%>" placeholder="1234" required="" name="prn" id="prn" class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" >
                        </div>
                        <div>
                            <label for="password" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Password</label>
                            <input type="password" onclick="document.getElementById('error').innerHTML = ''" name="password" id="password" maxlength="8" placeholder="••••••••" class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required="">
                        </div>
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
        <script>
            function alertNamefun() {

                setTimeout(fundiss, 3000);
                function fundiss() {
                    document.getElementById("error").innerHTML = '<% session.setAttribute("error", "");%>';
                }
            }
        </script>
        <script>
            window.onload = alertNamefun;
        </script>
    </body>
</html>

