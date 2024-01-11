<%-- 
    Document   : Verify
    Created on : 10-Jan-2024, 08:54:45
    Author     : MASTER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.0/flowbite.min.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.0/flowbite.min.js"></script>

    </head>
    <body>
        <%  //   no chache stored, page will not display after logout
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

            if (session.getAttribute("userid") == null) {
                session.invalidate();
                response.sendRedirect("hodlogin.jsp");
            }%>
        <h1>Verification </h1>
        <span>Enter verification code</span>
        <form action="VerifyCode" method="post">
            <input type="text" id="auth" name="authcode"><span id="err">
            </span><br>
            <input type="submit" name="Verify"/>
        </form>

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
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="justify-between items-center pt-0 space-y-4 sm:flex sm:space-y-0">
                        <a href="#" class="font-medium text-primary-600 dark:text-primary-500 hover:underline">Learn more about privacy</a>
                        <div class="items-center space-y-4 sm:space-x-4 sm:flex sm:space-y-0">
                            <button id="close-modal" type="button"  class="py-2 px-4 w-full text-sm font-medium text-gray-500 bg-white rounded-lg border border-gray-200 sm:w-auto hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-primary-300 hover:text-gray-900 focus:z-10 dark:bg-gray-700 dark:text-gray-300 dark:border-gray-500 dark:hover:text-white dark:hover:bg-gray-600 dark:focus:ring-gray-600">Cancel</button>
                            <button id="confirm-button" type="button" class="py-2 px-4 w-full text-sm font-medium text-center text-white rounded-lg bg-blue-700 sm:w-auto hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-primary-300 dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800">Confirm</button>
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
                document.getElementById("err").innerHTML = 'wrong code';
            }
//            document.getElementById("pwd2").addEventListener("keyup", function () {
//                //alert("hi");
//                validate_password();
//            });
            const closeModalEl = document.getElementById('close-modal');
            closeModalEl.addEventListener('click', function () {
                privacyModal.hide();
            });

            const acceptPrivacyEl = document.getElementById('confirm-button');
            acceptPrivacyEl.addEventListener('click', function () {
                alert('privacy accepted');
                privacyModal.hide();
            });
        </script>

        <script>
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

    </body>

    <% session.setAttribute("sts", null);%>
</html>
