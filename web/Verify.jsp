
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Verification</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.0/flowbite.min.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.0/flowbite.min.js"></script>
        <style>
            body {
                display: flex;
                align-items: center;
                justify-content: center;
                height: 100vh;
                margin: 0;
            }

            .form{
                width: 100%;
                max-width: 400px;;
            }
            .toggle-btn {
                position: absolute;
                right: 5px;
                top: 50%;
                transform: translateY(-50%);
                cursor: pointer;
            }
            #eye-icon {
                width: 25px;
                margin-top: 15px;
                margin-right: 12px;
                opacity: 60%;
            }
        </style>
    </head>
    <body>
        <%  //   no chache stored, page will not display after logout
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

            if (session.getAttribute("username") == null || session.getAttribute("authcode") == null) {
                //session.invalidate();
                response.sendRedirect("hodlogin.jsp");
            }%>
        <div class="form max-w-sm mx-auto">
            <h1 class="mb-4 text-xl font-bold">Account Verification </h1>
            <form action="VerifyCode" method="post" class="max-w-sm mx-auto form " onsubmit="return verifyCode()">
                <div class="flex items-center">
                    <div class="relative w-full">
                        <input type="text" id="auth" name="authcode" aria-describedby="helper-text-explanation" class="block p-2.5 w-full z-20 text-sm text-gray-900 bg-gray-50 rounded-e-lg border-s-0 border border-gray-300 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-s-gray-700  dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:border-blue-500" placeholder="OTP" required>
                    </div>
                </div>
                <p id="helper-text-explanation" class="mt-2 mb-4 text-sm text-gray-500 dark:text-gray-400">A verification code has been sent to your email address.</p>
                <button type="submit" class="text-white w-full bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 me-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800">Verify Code</button>

                <p class="text-gray-500 dark:text-gray-400">Back to <a href="hodlogin.jsp" class="inline-flex items-center font-medium text-blue-600 dark:text-blue-500 hover:underline">
                        Login 
                        <svg class="w-4 h-4 ml-1 rtl:rotate-180" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 10">
                        <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M1 5h12m0 0L9 1m4 4L9 9"/>
                        </svg>
                    </a></p>

            </form>
        </div>

        <div id="info-popup" tabindex="-1" class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 w-full md:inset-0 h-modal md:h-full">
            <div class="relative p-4 w-full max-w-lg h-full md:h-auto">
                <div class="relative p-4 bg-white rounded-lg shadow dark:bg-gray-800 md:p-8">
                    <div class="mb-4 text-sm font-light text-gray-500 dark:text-gray-400">
                        <h3 class="mb-3 text-2xl font-bold text-gray-900 dark:text-white">Create New Password</h3>
                        <form action="UpdateNewPass" method="post">
                            <div class="grid ">
                                <div class="relative z-0 w-full mb-6 group">
                                    <input type="password" name="pwd1"  id="pwd1" maxlength="8" minlength="4" onkeyup="validatePasswords()" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" " required />
                                    <label for="pwd1" id="pass1" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:left-0 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">New Password</label>
                                </div>
                                <div class="relative z-0 w-full mb-6 group">
                                    <input type="password" name="pwd2" id="pwd2" maxlength="8" minlength="4" onkeyup="validatePasswords()"  class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" " required />
                                    <label for="pwd2" id="pass2" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:left-0 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Confirm password</label>
                                    <div class="toggle-btn" onclick="togglePasswordVisibility()">
                                        <img src="eye-open.png" alt="Toggle Password Visibility" id="eye-icon">
                                    </div>
                                </div>
                            </div>
                            <div class="flex items-start">
                                <span id="error" class="self-center text-red-600 font-semibold  dark:text-white">
                                    <%= session.getAttribute("error") == null ? "" : session.getAttribute("error")%></span>
                            </div>

                    </div>
                    <div class="justify-between items-center pt-0 space-y-4 sm:flex sm:space-y-0">
                        <div class="items-center space-y-4 sm:space-x-4 sm:flex sm:space-y-0">
                            <button id="close-modal" type="button"  class="py-2 px-4 w-full text-sm font-medium text-gray-500 bg-white rounded-lg border border-gray-200 sm:w-auto hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-primary-300 hover:text-gray-900 focus:z-10 dark:bg-gray-700 dark:text-gray-300 dark:border-gray-500 dark:hover:text-white dark:hover:bg-gray-600 dark:focus:ring-gray-600">Cancel</button>
                            <button id="confirm-button" type="submit" class="py-2 px-4 w-full text-sm font-medium text-center text-white rounded-lg bg-blue-700 sm:w-auto hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-primary-300 dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800">Confirm</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script>
            const modalEl = document.getElementById('info-popup');

            var sts = '<%= session.getAttribute("sts")%>';

            const privacyModal = new Modal(modalEl, {
                placement: 'center',
                backdrop: 'static'
            });


            if (sts === "done") {
                privacyModal.show();
            }
            if (sts === "fail") {
                setTimeout(function () {
                    // Assuming the verification failed

                    displayErrorMessage("Invalid Verification Code", "rgb(239 68 68)");

                    // After 2 seconds, change the message to "Re-enter verification code"
                    setTimeout(function () {
                        displayErrorMessage("Re-enter verification code", "rgb(75 85 99)");

                        // After another 2 seconds, revert to the original message
                        setTimeout(function () {
                            displayErrorMessage("A verification code has been sent to your email address.", "gray");
                        }, 2000);
                    }, 2000);
                }, 20);
            }

            const closeModalEl = document.getElementById('close-modal');
            closeModalEl.addEventListener('click', function () {

                privacyModal.hide();
            });


            function displayErrorMessage(message, color) {
                var helperText = document.getElementById("helper-text-explanation");
                helperText.textContent = message;
                helperText.style.color = color;
            }


            function togglePasswordVisibility() {
                const passwordInput = document.getElementById('pwd2');
                const eyeIcon = document.getElementById('eye-icon');
                if (passwordInput.type === 'password') {
                    passwordInput.type = 'text';
                    eyeIcon.src = 'eye-closed.png';
                } else {
                    passwordInput.type = 'password';
                    eyeIcon.src = 'eye-open.png';
                }
            }


            function validatePasswords() {
                var password1 = document.getElementById('pwd1').value;
                var password2 = document.getElementById('pwd2').value;
                var pwd1Element = document.getElementById('pwd1');
                var pwd2Element = document.getElementById('pwd2');

                if (password2 !== "") {
                    if (password1 !== password2) {
                        // Passwords do not match
                        pwd1Element.style.borderBottomColor = 'red';
                        pwd2Element.style.borderBottomColor = 'red';
                    } else {
                        // Passwords match
                        pwd1Element.style.borderBottomColor = 'green';
                        pwd2Element.style.borderBottomColor = 'green';
                    }
                }
            }
        </script>
        <script >
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

    <% session.setAttribute("sts", null);%>
</html>
